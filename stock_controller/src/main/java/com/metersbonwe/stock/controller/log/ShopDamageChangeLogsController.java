package com.metersbonwe.stock.controller.log;

import com.metersbonwe.stock.biz.manager.service.ShopDamageChangeLogsService;
import com.metersbonwe.stock.controller.BaseController;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockShopDameTran;
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

@Controller public class ShopDamageChangeLogsController extends BaseController {

    private static StockLog                       log = StockLogFactory.getLogger(ShopDamageChangeLogsController.class);

    @Resource private ShopDamageChangeLogsService shopDamageChangeLogsServiceImpl;

    /**
     * 门店污次少洗维护日志查询
     *
     * @return 结果集合
     */
    @ResponseBody
    @RequestMapping(value = "/selectShopDamageChangeLogs", method = RequestMethod.GET)
    public String selectShopDamageChangeLogs(HttpServletRequest request) {
        List<StockShopDameTran> stockShopDameTranList = null;
        Page<?> page = null;
        try {
            Map<String, String> paraMap = assembleSelectParam(request);
            Map<String, List<String>> paraListMap = assembleSelectListParam(paraMap);
            page = assemblePageSelect(paraMap);
            stockShopDameTranList = shopDamageChangeLogsServiceImpl.selectShopDamageChangeLogs(paraListMap);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return assembleSelectResult(stockShopDameTranList, page);
    }

}
