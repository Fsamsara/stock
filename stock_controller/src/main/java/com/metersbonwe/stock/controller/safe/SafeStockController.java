package com.metersbonwe.stock.controller.safe;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.metersbonwe.stock.biz.manager.service.SafeStockService;
import com.metersbonwe.stock.controller.BaseController;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockWpSafe;
import com.metersbonwe.stock.pojo.Page;
import com.metersbonwe.stock.pojo.PageThreadLocal;
import com.metersbonwe.stock.pojo.imexcel.SafeStockExcelBean;
import com.metersbonwe.stock.utils.imexcel.ImportExportDataUtil;
import com.metersbonwe.stock.vo.safe.SafeStockVo;

@Controller public class SafeStockController extends BaseController {

    private static StockLog            stockLog = StockLogFactory.getLogger(SafeStockController.class);

    @Resource private SafeStockService safeStockServiceImpl;

    protected Page<?> assemblePageSelect(Integer pageNo, Integer rows) {
        Page<?> page = new Page<>();
        page.setPageNo(pageNo);
        page.setPageSize(rows);
        return page;
    }

    /**
     * TODO 查询erp仓、SKU的安全库存
     * 
     * @param jsonData
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/querySafeStock")
    public String querySafeStock(HttpServletRequest request, HttpServletResponse response) {
        List<SafeStockVo> safeStockVoList = null;
        Page<?> page = null;
        try {
            Map<String, String> paraMap = assembleSelectParam(request);
            Map<String, List<String>> paraListMap = assembleSelectListParam(paraMap);
            String fileDownFlag = paraMap.get("fileDownFlag");
            // fileDownFlag 为空则不是文件下载    则需要分页
            if (StringUtils.isBlank(fileDownFlag)) {
                page = assemblePageSelect(paraMap);
            }
            List<String> warehList = paraListMap.get("warehId");
            if (warehList == null || warehList.size() <= 0) {
                return assembleUnSelectResult(0, "传入的参数仓库编码无效");
            }
            List<String> skuList = paraListMap.get("prodId");
            if (page != null) {
                PageThreadLocal.setThreadLocalPage(page);
            }
            safeStockVoList = getSafeStockVoList(warehList, skuList);

            if (StringUtils.isNotBlank(fileDownFlag)) {
                List<SafeStockExcelBean> dames = new ArrayList<>();
                for (SafeStockVo vo : safeStockVoList) {
                    SafeStockExcelBean excelBean = new SafeStockExcelBean();
                    BeanUtils.copyProperties(vo, excelBean);
                    dames.add(excelBean);
                }
                String values = ImportExportDataUtil.getExportData(dames, SafeStockExcelBean.class);
                fileDownload("仓库安全库存_" + String.valueOf((new Date()).getTime()), values, response);
                return null;
            }
        } catch (Exception e) {
            stockLog.error(e.getMessage(), e);
        }
        String jsonData = assembleSelectResult(safeStockVoList, page);
        return jsonData;
    }

    private List<SafeStockVo> getSafeStockVoList(List<String> warehList, List<String> skuList) {
        List<StockWpSafe> stockWpSafeList = this.safeStockServiceImpl.getErpWarehSafeStock(warehList, skuList);
        List<SafeStockVo> safeStockVoList = new ArrayList<SafeStockVo>();
        for (StockWpSafe stockWpSafe : stockWpSafeList) {
            SafeStockVo safeStockVo = new SafeStockVo();
            safeStockVo.setWarehId(stockWpSafe.getWarehId());
            safeStockVo.setProdId(stockWpSafe.getProdId());
            safeStockVo.setSafeStock(stockWpSafe.getSafeStock());
            safeStockVoList.add(safeStockVo);
        }

        return safeStockVoList;
    }

}
