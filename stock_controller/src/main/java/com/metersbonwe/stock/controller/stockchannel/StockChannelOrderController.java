package com.metersbonwe.stock.controller.stockchannel;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.metersbonwe.stock.biz.manager.service.StockChannelSendedService;
import com.metersbonwe.stock.biz.manager.service.StockChannelStatusService;
import com.metersbonwe.stock.controller.BaseController;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockChannelSended;
import com.metersbonwe.stock.po.core.StockChannelStatus;
import com.metersbonwe.stock.pojo.Page;
import com.metersbonwe.stock.pojo.StockChannelSendedBean;
import com.metersbonwe.stock.pojo.PageStockChannelStatusBean;

@Controller public class StockChannelOrderController extends BaseController {

    private static StockLog stockLog = StockLogFactory.getLogger(StockChannelOrderController.class);
    
    @Resource
    StockChannelSendedService stockChannelSendedService;
    
    @Resource
    StockChannelStatusService stockChannelStatusService;

    @ResponseBody
    @RequestMapping(value = "/selectStockChannelOrders")
    public String selectStockChannelOrders(HttpServletRequest request) {

        List<StockChannelSended> lists = null;

        Page<?> page = null;

        Map<String, String> paramMap = assembleSelectParam(request);
        
        paramMap.put("isPre", "0");
        
        String channelCodes = paramMap.get("channelCode");
        
        if(!StringUtils.isEmpty(channelCodes)){
            paramMap.put("channelCode", channelCodes.toLowerCase());
        }

        String fileDownFlag = paramMap.get("fileDownFlag");

        if (StringUtils.isBlank(fileDownFlag)) {
            page = assemblePageSelect(paramMap);
        }
        
        Map<String, List<String>> paramListMap = assembleSelectListParam(paramMap);
        
        List<String> channelCodeLists = paramListMap.get("channelCode");
        
        if(channelCodeLists != null && channelCodeLists.size() > 0) {
            StockChannelSendedBean stockChannelSendedBean = new StockChannelSendedBean();
            stockChannelSendedBean.setChannelCodes(paramListMap.get("channelCode"));
            stockChannelSendedBean.setProdIds(paramListMap.get("prodId"));
            stockChannelSendedBean.setIsPres(paramListMap.get("isPre"));
            lists = stockChannelSendedService.selectForChannelsAndProds(stockChannelSendedBean);
        }
        
        stockLog.info("渠道实物库存查询完成");

        return assembleSelectResult(lists, page);
    }
    
    @ResponseBody
    @RequestMapping(value = "/selectPageStockChannelStatus")
    public String selectPageStockChannelStatus(HttpServletRequest request) {

        List<StockChannelStatus> lists = null;

        Page<?> page = null;

        Map<String, String> paramMap = assembleSelectParam(request);
        
        String channelCodes = paramMap.get("channelCode");
        
        if(!StringUtils.isEmpty(channelCodes)){
            paramMap.put("channelCode", channelCodes.toLowerCase());
        }

        String fileDownFlag = paramMap.get("fileDownFlag");

        if (StringUtils.isBlank(fileDownFlag)) {
            page = assemblePageSelect(paramMap);
        }
        
        Map<String, List<String>> paramListMap = assembleSelectListParam(paramMap);
        
        List<String> channelCodeLists = paramListMap.get("channelCode");
        
        if(channelCodeLists != null && channelCodeLists.size() > 0) {
            PageStockChannelStatusBean stockChannelStatusBean = new PageStockChannelStatusBean();
            stockChannelStatusBean.setChannelCodes(paramListMap.get("channelCode"));
            stockChannelStatusBean.setSixProdIds(paramListMap.get("sixProdId"));
            stockChannelStatusBean.setSaleStatus(paramListMap.get("saleStatus"));
            stockChannelStatusBean.setIsSyncs(paramListMap.get("isSync"));
            lists = stockChannelStatusService.selectPageStockChannelStatus(stockChannelStatusBean);
        }
        
        stockLog.info("渠道商品状态查询完成");

        return assembleSelectResult(lists, page);
    }
    
    @ResponseBody
    @RequestMapping(value = "/selectStockChannelPreOrders")
    public String selectStockChannelPreOrders(HttpServletRequest request) {

        List<StockChannelSended> lists = null;

        Page<?> page = null;

        Map<String, String> paramMap = assembleSelectParam(request);
        
        paramMap.put("isPre", "1");
        
        String channelCodes = paramMap.get("channelCode");
        
        if (!StringUtils.isEmpty(channelCodes)) {
            paramMap.put("channelCode", channelCodes.toLowerCase());
        }

        String fileDownFlag = paramMap.get("fileDownFlag");

        if (StringUtils.isBlank(fileDownFlag)) {
            page = assemblePageSelect(paramMap);
        }
        
        Map<String, List<String>> paramListMap = assembleSelectListParam(paramMap);
        
        List<String> channelCodeLists = paramListMap.get("channelCode");
        
        if(channelCodeLists != null && channelCodeLists.size() > 0) {
            StockChannelSendedBean stockChannelSendedBean = new StockChannelSendedBean();
            stockChannelSendedBean.setChannelCodes(paramListMap.get("channelCode"));
            stockChannelSendedBean.setProdIds(paramListMap.get("prodId"));
            stockChannelSendedBean.setIsPres(paramListMap.get("isPre"));
            lists = stockChannelSendedService.selectForChannelsAndProds(stockChannelSendedBean);
        }
        
        stockLog.info("渠道预售库存查询完成");

        return assembleSelectResult(lists, page);
    }
}
