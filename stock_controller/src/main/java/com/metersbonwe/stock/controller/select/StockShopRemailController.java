package com.metersbonwe.stock.controller.select;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.metersbonwe.stock.FileConstants;
import com.metersbonwe.stock.biz.manager.service.StockShopRemailService;
import com.metersbonwe.stock.controller.BaseController;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockShopRemail;
import com.metersbonwe.stock.pojo.Page;
import com.metersbonwe.stock.vo.StockShopRemailVo;

/**
 * TODO 门店未日结小票查询
 * 
 * @author zhangjf
 * @date 2016年5月5日 下午1:00:01
 * @since V1.0
 * @version V1.0
 */
@Controller public class StockShopRemailController extends BaseController {
    private static StockLog           LOGGER = StockLogFactory.getLogger(StockShopRemailController.class);

    @Autowired StockShopRemailService stockShopRemailService;

    /**
     * TODO 门店未日结小票查询
     * 
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectShopRemail")
    public String selectShopRemail(HttpServletRequest request, HttpServletResponse response) {
        List<StockShopRemailVo> dames = null;
        Page<?> page = null;
        try {
            Map<String, String> paraMap = assembleSelectParam(request);
            Map<String, List<String>> paraListMap = assembleSelectListParam(paraMap);
            String fileDownFlag = paraMap.get("fileDownFlag");
            // fileDownFlag 为空则不是文件下载    则需要分页
            if (StringUtils.isBlank(fileDownFlag)) {
                page = assemblePageSelect(paraMap);
            }
            List<StockShopRemail> stockShopRemails = stockShopRemailService.selectStockShopRemail(paraListMap);
            dames = new ArrayList<StockShopRemailVo>();
            for (StockShopRemail stockShopRemail : stockShopRemails) {
                StockShopRemailVo vo=new StockShopRemailVo();
                BeanUtils.copyProperties(stockShopRemail,vo);
                dames.add(vo);
            }
            if (StringUtils.isNotBlank(fileDownFlag)) {
                List<Object> objects = new ArrayList<>();
                objects.addAll(dames);
                fileDownload(
                        FileConstants.Template.SHOPREMAILDETAIL,
                        converFileDownStr(objects, FileConstants.TEMPLATE_MAP.get(FileConstants.Template.SHOPREMAILDETAIL)),
                        response);
                return null;
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return assembleSelectResult(dames, page);
    }
}
