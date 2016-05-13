package com.metersbonwe.stock.controller.channelStockSearch;

import com.metersbonwe.oms.channel.bean.ChannelApiResult;
import com.metersbonwe.oms.channel.service.ChannelService;
import com.metersbonwe.stock.Constants;
import com.metersbonwe.stock.FileConstants;
import com.metersbonwe.stock.biz.common.service.impl.ChannelOmsApiServiceImpl;
import com.metersbonwe.stock.biz.manager.service.ProductOnSaleService;
import com.metersbonwe.stock.controller.BaseController;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.define.ChannelProdBean;
import com.metersbonwe.stock.pojo.Page;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 渠道商品在售清单查询
 */
@Controller public class ProductOnSaleController extends BaseController {

    private static StockLog                log = StockLogFactory.getLogger(ProductOnSaleController.class);

    @Resource private ProductOnSaleService productOnSaleServiceImpl;

    @Resource ChannelService               channelServiceImpl;

    @Resource ChannelOmsApiServiceImpl     channelOmsApiServiceImpl;

    /**
     * 渠道商品在售清单查询
     *
     * @return 结果集合
     */
    @ResponseBody
    @RequestMapping(value = "/selectProductOnSale", method = RequestMethod.GET)
    public String selectPrivateStock(HttpServletRequest request, HttpServletResponse response) {
        List<ChannelProdBean> channelOnSaleBeanList = new ArrayList<>();
        Page<?> page = null;
        try {
            Map<String, String> paraMap = assembleSelectParam(request);
            //下载标识
            String fileDownFlag = paraMap.get("fileDownFlag");
            if (StringUtils.isNotBlank(fileDownFlag)) {
                downLoadFile(paraMap, response);
                return null;
            }
            page = assemblePageSelect(paraMap);
            channelOnSaleBeanList = productOnSaleServiceImpl.selectOnlineChannelStock(paraMap, page);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return assembleSelectResult(channelOnSaleBeanList, page);
    }

    @SuppressWarnings("rawtypes")
    private void downLoadFile(Map<String, String> paraMap, HttpServletResponse response) throws Exception {
        List<Object> channelOnSaleBeanList;
        String channelCode = paraMap.get(Constants.CHANNEL_CODE);
        ChannelApiResult result = channelServiceImpl.onSellList(channelCode, null, 1, 0);
        int page = result.getNumIid();
        for (int i = 1; i <= page; i++) {
            Page<?> pageP = new Page<>();
            pageP.setPageNo(i);
            channelOnSaleBeanList = new ArrayList<Object>(productOnSaleServiceImpl.selectOnlineChannelStock(paraMap, pageP));
            fileDownload(
                    "在售商品清单_" + channelCode,
                    converFileDownStr(channelOnSaleBeanList, FileConstants.TEMPLATE_MAP.get(FileConstants.Template.PRODUCTONSALE)),
                    response,
                    false);
        }
        response.getWriter().flush();
    }

}
