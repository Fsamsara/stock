package com.metersbonwe.stock.controller.log;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.metersbonwe.stock.ExceptionConstants;
import com.metersbonwe.stock.biz.manager.service.StockSyncLogDetailService;
import com.metersbonwe.stock.controller.BaseController;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.LogStockDetail;
import com.metersbonwe.stock.pojo.Page;

@Controller public class SyncLogDetailController extends BaseController {

    private static StockLog             LOGGER = StockLogFactory.getLogger(SyncLogDetailController.class);

    @Resource StockSyncLogDetailService stockSyncLogDetailServiceImpl;

    /**
     * TODO 推送线上日志信息查询
     *
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectSyncLogDetail")
    public String selectSyncLogDetail(HttpServletRequest request, HttpServletResponse response) {
        List<LogStockDetail> logStockDetails = null;
        Page<?> page = null;
        try {
            Map<String, String> paraMap = assembleSelectParam(request);
            LogStockDetail detail = new LogStockDetail();
            BeanUtils.populate(detail, paraMap);
            if (StringUtils.isBlank(detail.getChannelCode()) || StringUtils.isBlank(detail.getProdId()) || detail.getStartTime() == null
                    || detail.getEndTime() == null) {
                return assembleUnSelectResult(ExceptionConstants.ERROR_CODE, "查询条件错误，渠道编号、商品编码、查询开始时间、查询结束时间 都不能为空！");
            }
            logStockDetails = stockSyncLogDetailServiceImpl.selectLogStockDetail(detail);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return assembleSelectResult(logStockDetails, page);
    }
}
