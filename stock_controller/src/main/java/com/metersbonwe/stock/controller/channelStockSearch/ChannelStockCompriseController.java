package com.metersbonwe.stock.controller.channelStockSearch;

import com.metersbonwe.stock.biz.manager.service.ChannelStockCompriseService;
import com.metersbonwe.stock.controller.BaseController;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.define.ChannelProdBean;
import com.metersbonwe.stock.pojo.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author huangbiao
 * @date 2016/05/12
 */

@Controller public class ChannelStockCompriseController extends BaseController {

    private static StockLog log = StockLogFactory.getLogger(ChannelStockCompriseController.class);

    @Resource private ChannelStockCompriseService channelStockCompriseServiceImpl;

    /**
     * 渠道库存分部查询
     * @return 结果集合
     */
    @ResponseBody @RequestMapping(value = "/selectChannelStockComprise", method = RequestMethod.GET) public String selectChannelStockComprise(
            HttpServletRequest request) {
        List<ChannelProdBean> channelProdBeanList = null;
        Page<?> page = null;
        try {
            Map<String, String> paraMap = assembleSelectParam(request);
            page = assemblePageSelect(paraMap);
            channelProdBeanList = channelStockCompriseServiceImpl.selectChannelStockComprise(paraMap);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return assembleSelectResult(channelProdBeanList, page);
    }

}
