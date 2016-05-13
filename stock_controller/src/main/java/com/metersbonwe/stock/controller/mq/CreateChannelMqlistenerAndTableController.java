package com.metersbonwe.stock.controller.mq;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.netty.util.CharsetUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.metersbonwe.stock.biz.common.service.CreateTablesWarehChannelCommonService;
import com.metersbonwe.stock.biz.common.service.MqSendService;
import com.metersbonwe.stock.controller.BaseController;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.pojo.MqMessagePojo;

@Controller public class CreateChannelMqlistenerAndTableController extends BaseController {

    private static StockLog                         LOGGER = StockLogFactory.getLogger(CreateChannelMqlistenerAndTableController.class);

    @Resource MqSendService                         mqSendServiceImpl;

    @Resource CreateTablesWarehChannelCommonService createTablesWarehChannelCommonServiceImpl;

    /**
     * TODO 动态注册渠道MQ和新建渠道表
     *
     * @param request
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/createChannelMqlistenerAndTable")
    public void createChannelMqlistenerAndTable(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> pMap = assembleRequestParam(request);
        try {
            if (pMap.containsKey("channelCode")) {
                MqMessagePojo pojo = new MqMessagePojo();
                pojo.setProxyClass("com.metersbonwe.stock.biz.common.service.mq.DynamicListenerForChannel");
                pojo.setListenerClass("com.metersbonwe.stock.biz.queue.service.impl.OnlineChannelStockQueueServiceImpl");
                pojo.setObject(pMap.get("channelCode"));
                mqSendServiceImpl.sendTopicMessage(pojo);
            }
            createTablesWarehChannelCommonServiceImpl.createChannelTable();
            response.getWriter().write("<script>alert(" + "添加成功!".getBytes(CharsetUtil.ISO_8859_1) + ");history.go(-1);</script>");
            response.getWriter().flush();
        } catch (Exception e) {
            LOGGER.error("注册MQ监听器失败,渠道:" + pMap.get("channelCode") + "," + e.getMessage(), e);
        }
    }

}
