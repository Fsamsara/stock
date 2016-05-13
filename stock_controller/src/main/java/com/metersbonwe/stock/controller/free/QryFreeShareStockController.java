package com.metersbonwe.stock.controller.free;

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

import com.metersbonwe.stock.biz.common.service.QueryStockWarehProdService;
import com.metersbonwe.stock.controller.BaseController;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockWarehProd;
import com.metersbonwe.stock.pojo.Page;
import com.metersbonwe.stock.pojo.imexcel.QryShopFreeShareStockExcelBean;
import com.metersbonwe.stock.pojo.imexcel.QryWarehFreeShareStockExcelBean;
import com.metersbonwe.stock.utils.imexcel.ImportExportDataUtil;
import com.metersbonwe.stock.vo.free.QryFreeShareStockVo;

@Controller public class QryFreeShareStockController extends BaseController {

    private static StockLog                      stockLog = StockLogFactory.getLogger(QryFreeShareStockController.class);

    @Resource private QueryStockWarehProdService queryStockWarehProdServiceImpl;

    protected Page<?> assemblePageSelect(Integer pageNo, Integer rows) {
        Page<?> page = new Page<>();
        page.setPageNo(pageNo);
        page.setPageSize(rows);
        return page;
    }

    /**
     * TODO 查询门店自由量
     * 
     * @param jsonData
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/qryShopFreeShareStock")
    public String qryShopFreeShareStock(HttpServletRequest request, HttpServletResponse response) {
        List<QryFreeShareStockVo> qryFreeShareStockVoList = null;
        Page<?> page = null;
        try {
            Map<String, String> paraMap = assembleSelectParam(request);
            Map<String, List<String>> paraListMap = assembleSelectListParam(paraMap);
            String fileDownFlag = paraMap.get("fileDownFlag");
            // fileDownFlag 为空则不是文件下载    则需要分页
            if (StringUtils.isBlank(fileDownFlag)) {
                page = assemblePageSelect(paraMap);
            }
            String warehId = "";
            List<String> warehList = paraListMap.get("warehId");
            if (warehList != null && warehList.size() > 0) {
                warehId = warehList.get(0);
            }
            if (null == warehId || "".equals(warehId)) {
                return assembleUnSelectResult(0, "请传入仓库编码");
            }
            List<String> skuList = paraListMap.get("prodId");

            qryFreeShareStockVoList = getQryFreeShareStockVoList(warehId, skuList, page);

            if (StringUtils.isNotBlank(fileDownFlag)) {
                List<QryShopFreeShareStockExcelBean> dames = new ArrayList<>();
                for (QryFreeShareStockVo vo : qryFreeShareStockVoList) {
                    QryShopFreeShareStockExcelBean excelBean = new QryShopFreeShareStockExcelBean();
                    BeanUtils.copyProperties(vo, excelBean);
                    dames.add(excelBean);
                }
                String values = ImportExportDataUtil.getExportData(dames, QryShopFreeShareStockExcelBean.class);
                fileDownload("门店自由量库存_" + warehId + "_" + String.valueOf((new Date()).getTime()), values, response);
                return null;
            }

        } catch (Exception e) {
            stockLog.error(e.getMessage(), e);
        }
        String jsonData = assembleSelectResult(qryFreeShareStockVoList, page);
        return jsonData;
    }

    /**
     * TODO 查询仓库自由量
     * 
     * @param jsonData
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/qryWarehFreeShareStock")
    public String qryWarehFreeShareStock(HttpServletRequest request, HttpServletResponse response) {
        List<QryFreeShareStockVo> qryFreeShareStockVoList = null;
        Page<?> page = null;
        try {
            Map<String, String> paraMap = assembleSelectParam(request);
            Map<String, List<String>> paraListMap = assembleSelectListParam(paraMap);
            String fileDownFlag = paraMap.get("fileDownFlag");
            // fileDownFlag 为空则不是文件下载    则需要分页
            if (StringUtils.isBlank(fileDownFlag)) {
                page = assemblePageSelect(paraMap);
            }

            String warehId = "";
            List<String> warehList = paraListMap.get("warehId");
            if (warehList != null && warehList.size() > 0) {
                warehId = warehList.get(0);
            }
            if (null == warehId || "".equals(warehId)) {
                return assembleUnSelectResult(0, "请传入仓库编码");
            }
            List<String> skuList = paraListMap.get("prodId");

            qryFreeShareStockVoList = getQryFreeShareStockVoList(warehId, skuList, page);

            if (StringUtils.isNotBlank(fileDownFlag)) {
                List<QryWarehFreeShareStockExcelBean> dames = new ArrayList<>();
                for (QryFreeShareStockVo vo : qryFreeShareStockVoList) {
                    QryWarehFreeShareStockExcelBean excelBean = new QryWarehFreeShareStockExcelBean();
                    BeanUtils.copyProperties(vo, excelBean);
                    dames.add(excelBean);
                }
                String values = ImportExportDataUtil.getExportData(dames, QryWarehFreeShareStockExcelBean.class);
                fileDownload("仓库自由量库存_" + warehId + "_" + String.valueOf((new Date()).getTime()), values, response);
                return null;
            }

        } catch (Exception e) {
            stockLog.error(e.getMessage(), e);
        }
        String jsonData = assembleSelectResult(qryFreeShareStockVoList, page);
        return jsonData;
    }

    private List<QryFreeShareStockVo> getQryFreeShareStockVoList(String warehId, List<String> skuList, Page<?> page) {
        List<StockWarehProd> stockWarehProdList = this.queryStockWarehProdServiceImpl.getWarehSkuStockByPage(page, warehId, skuList);
        List<QryFreeShareStockVo> qryFreeShareStockVoList = new ArrayList<QryFreeShareStockVo>();
        for (StockWarehProd stockWarehProd : stockWarehProdList) {
            QryFreeShareStockVo qryFreeShareStockVo = new QryFreeShareStockVo();
            qryFreeShareStockVo.setWarehId(stockWarehProd.getWarehId());
            qryFreeShareStockVo.setProdId(stockWarehProd.getProdId());

            qryFreeShareStockVo.setStkOnHand(stockWarehProd.getStkOnHand());
            qryFreeShareStockVo.setQtyCommitted(stockWarehProd.getQtyCommitted());
            qryFreeShareStockVo.setFreeShareStock(stockWarehProd.getFreeShareStock());
            qryFreeShareStockVo.setFinalFreeShareStock(stockWarehProd.getFinalFreeShareStock());
            qryFreeShareStockVo.setOnlineSafeStock(stockWarehProd.getOnlineSafeStock());
            qryFreeShareStockVo.setShopDame(stockWarehProd.getShopDame());
            qryFreeShareStockVo.setShopRemail(stockWarehProd.getShopRemail());
            qryFreeShareStockVo.setLockStock(stockWarehProd.getLockStock());
            qryFreeShareStockVo.setWmsStock(stockWarehProd.getWmsStock());

            qryFreeShareStockVoList.add(qryFreeShareStockVo);
        }

        return qryFreeShareStockVoList;
    }

}
