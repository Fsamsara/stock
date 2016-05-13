package com.metersbonwe.stock.controller.select;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.metersbonwe.stock.FileConstants;
import com.metersbonwe.stock.biz.common.service.AllocationRangeService;
import com.metersbonwe.stock.controller.BaseController;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockChannelScope;

@Controller public class channelMsgController extends BaseController {
    private static StockLog          LOGGER = StockLogFactory.getLogger(channelMsgController.class);

    @Resource AllocationRangeService allocationRangeServiceImpl;

    @ResponseBody
    @RequestMapping(value = "/selectChannelMsg")
    public String selectChannelInfo(HttpServletRequest request,HttpServletResponse response) {
        List<StockChannelScope> channels = null;
        try {
            Map<String, String> paraMap = assembleSelectParam(request);
            Map<String, List<String>> paraListMap = assembleSelectListParam(paraMap);
            String fileDownFlag = paraMap.get("fileDownFlag");
            
            List<String> channelCodes = paraListMap.get("channelCode");
            channels = allocationRangeServiceImpl.getAllUsefulChannelForBean();
            if (CollectionUtils.isNotEmpty(channelCodes)) {
                Map<String, String> map = new HashMap<String, String>();
                for (StockChannelScope stockChannelScope : channels) {
                    if (!map.containsKey(stockChannelScope.getChannelCode())) {
                        map.put(stockChannelScope.getChannelCode(), stockChannelScope.getChannelName());
                    }
                }
                channels = new ArrayList<StockChannelScope>();
                Map<String, String> map1 = new HashMap<String, String>();//防重复
                for (String string : channelCodes) {
                    if (map.containsKey(string)) {
                        if (!map1.containsKey(string)) {
                            map1.put(string, string);
                            StockChannelScope stockChannelScope = new StockChannelScope();
                            stockChannelScope.setChannelCode(string);
                            stockChannelScope.setChannelName(map.get(string));
                            channels.add(stockChannelScope);
                        }
                    }
                }
            }
            
            if (StringUtils.isNotBlank(fileDownFlag)) {
                List<Object> objects = new ArrayList<>();
                objects.addAll(channels);
                fileDownload(
                        FileConstants.Template.CHANNELMSG,
                        converFileDownStr(objects, FileConstants.TEMPLATE_MAP.get(FileConstants.Template.CHANNELMSG)),
                        response);
                return null;
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return assembleSelectResult(channels);
    }
}
