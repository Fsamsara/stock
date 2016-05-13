package com.metersbonwe.stock.controller.channelStockSearch;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.metersbonwe.stock.biz.manager.service.StockPrivateService;
import com.metersbonwe.stock.controller.BaseController;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.sync.define.ChannelReservedBean;
import com.metersbonwe.stock.pojo.Page;
import com.mtsbw.platform.core.util.JsonUtil;

@Controller public class PrivateStockController extends BaseController {

    private static StockLog               log = StockLogFactory.getLogger(PrivateStockController.class);

    @Resource private StockPrivateService stockPrivateServiceImpl;

    /**
     * 预留独占量查询
     *
     * @return 结果集合
     */
    @SuppressWarnings("unchecked")
    @ResponseBody
    @RequestMapping(value = "/selectPrivateStock", method = RequestMethod.GET)
    public String selectPrivateStock(HttpServletRequest request) {
        List<ChannelReservedBean> channelReservedBeanList = null;
        Page<?> page = null;
        try {
            Map<String, String> paraMap = assembleSelectParam(request);
            Map<String, List<String>> paraListMap = assembleSelectListParam(paraMap);
            Map<String, Object> filterMap = JsonUtil.fromJsonToMap(paraMap.get("filters"));
            List<JSONObject> rulesList = (List<JSONObject>) filterMap.get("rules");
            String privateStockOpFlg = "eq";
            for (JSONObject jsonStr : rulesList) {
                if ("reservedStock".equalsIgnoreCase(String.valueOf(jsonStr.get("field")))) {
                    privateStockOpFlg = String.valueOf(jsonStr.get("op"));
                    break;
                }
            }
            page = assemblePageSelect(paraMap);
            channelReservedBeanList = stockPrivateServiceImpl.selectPrivateStock(paraListMap, privateStockOpFlg);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return assembleSelectResult(channelReservedBeanList, page);
    }

}
