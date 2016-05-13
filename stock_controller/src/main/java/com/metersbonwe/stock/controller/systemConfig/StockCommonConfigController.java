package com.metersbonwe.stock.controller.systemConfig;

import com.metersbonwe.stock.biz.manager.service.StockCommonConfigService;
import com.metersbonwe.stock.controller.BaseController;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockCommonConfig;
import com.metersbonwe.stock.pojo.Page;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * 渠道商品在售清单查询
 * @author huangbiao
 * @date 2016/05/10
 * @version 1.0
 */
@Controller public class StockCommonConfigController extends BaseController {

    private static StockLog log = StockLogFactory.getLogger(StockCommonConfigController.class);

    @Resource private StockCommonConfigService stockCommonConfigServiceImpl;

    /**
     * 系统配置查询
     *
     * @return 结果集合
     */
    @ResponseBody @RequestMapping(value = "/selectStockCommonConfig", method = RequestMethod.GET) public String selectStockCommonConfig(
            HttpServletRequest request, HttpServletResponse response) {
        List<StockCommonConfig> channelOnSaleBeanList = new ArrayList<>();
        Page<?> page = null;
        try {
            Map<String, String> paraMap = assembleSelectParam(request);
            page = assemblePageSelect(paraMap);
            channelOnSaleBeanList = stockCommonConfigServiceImpl.selectStockCommonConfig(paraMap);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return assembleSelectResult(channelOnSaleBeanList, page);
    }

    /**
     * 系统配置删除
     *
     * @return 结果集合
     */
    @ResponseBody @RequestMapping(value = "/deleteStockCommonConfig", method = RequestMethod.GET) public String deleteStockCommonConfig(
            HttpServletRequest request, HttpServletResponse response) {
        int succCount = 0;
        String errCode = null;
        try {
            Map<String, String> paraMap = assembleUnSelectParam(request);
            Map<String, List<String>> paraListMap = assembleSelectListParam(paraMap);
            succCount = stockCommonConfigServiceImpl.deleteStockCommonConfig(paraListMap);
        } catch (Exception e) {
            errCode = e.getMessage();
            log.error(e.getMessage(), e);
        }
        return assembleUnSelectResult(succCount, errCode);
    }

    /**
     * @description 配置添加
     * @param request 前台传递过来的参数等信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addStockCommonConfig")
    public String addStockCommonConfig(HttpServletRequest request) {
        int count = 0;
        String errorMsg = "添加配置信息成功！";
        try {
            Map<String, String> paraMap = assembleUnSelectParam(request);
            StockCommonConfig stockCommonConfig = new StockCommonConfig();
            BeanUtils.populate(stockCommonConfig, paraMap);
            //TODO 从Session里面获取
            String user = "0001";
            stockCommonConfig.setCreateBy(user);
            stockCommonConfig.setCreateTime(new Date());
            count = stockCommonConfigServiceImpl.addStockCommonConfig(stockCommonConfig);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            errorMsg = "添加记录失败，请联系相关人员！";
        }
        return assembleUnSelectResult(count, errorMsg);
    }

    /**
     * @description 更新预售主表信息
     * @param request 请求参数
     * @return String
     */
    @ResponseBody
    @RequestMapping(value = "/editStockCommonConfig")
    public String editStockCommonConfig(HttpServletRequest request) {
        int succCount = 0;
        String msg = "修改记录成功！";
        try {
            Map<String, String> paraMap = assembleUnSelectParam(request);
            succCount = stockCommonConfigServiceImpl.editStockCommonConfig(paraMap);
        } catch (Exception e) {
            msg = "修改记录失败，请联系相关人员！";
            log.error(e.getMessage(), e);
        }
        return assembleUnSelectResult(succCount, msg);
    }
}
