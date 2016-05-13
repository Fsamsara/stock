package com.metersbonwe.stock.controller.log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.metersbonwe.oms.api.bean.ChannelShop;
import com.metersbonwe.oms.channel.bean.ChannelApiResult;
import com.metersbonwe.oms.channel.service.ChannelService;
import com.metersbonwe.stock.biz.manager.service.StockBizLogDetailService;
import com.metersbonwe.stock.controller.BaseController;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockBizLogDetails;
import com.metersbonwe.stock.po.core.StockShopRemail;
import com.metersbonwe.stock.pojo.Page;
import com.metersbonwe.stock.vo.StockBizLogDetailsVo;
import com.metersbonwe.stock.vo.StockShopRemailVo;

@Controller public class StockBizLogDetailController extends BaseController {

    private static StockLog             LOGGER = StockLogFactory.getLogger(StockBizLogDetailController.class);

    @Autowired StockBizLogDetailService stockBizLogDetailService;

    @Resource ChannelService            channelService;

    /**
     * TODO 推送线上日志信息查询
     * 
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectStockBizLogDtl")
    public String selectStockBizLogDtl(HttpServletRequest request, HttpServletResponse response) {
        List<StockBizLogDetailsVo> dames = null;
        Page<?> page = null;
        try {
            Map<String, String> paraMap = assembleSelectParam(request);
            Map<String, List<String>> paraListMap = assembleSelectListParam(paraMap);

            List<StockBizLogDetails> stockBizLogDetailss = stockBizLogDetailService.selectStockBizLogDetail(paraListMap);

            Map<String, String> map = new HashMap<String, String>();
            ChannelApiResult result = channelService.getAllSynStockChannelShop();
            if (result == null) {
                throw new RuntimeException("获取渠道列表出错！");
            }
            List<ChannelShop> channelShops = result.getChannelShopList();
            for (ChannelShop channelShop : channelShops) {
                map.put(channelShop.getShopCode(), channelShop.getShopTitle());
            }

            dames = new ArrayList<StockBizLogDetailsVo>();
            for (StockBizLogDetails stockBizLogDetails : stockBizLogDetailss) {
                StockBizLogDetailsVo vo = new StockBizLogDetailsVo();
                BeanUtils.copyProperties(stockBizLogDetails, vo);
                vo.setChannelName(map.get(stockBizLogDetails.getChannelcode()));
                dames.add(vo);
            }

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return assembleSelectResult(dames, page);
    }
}
