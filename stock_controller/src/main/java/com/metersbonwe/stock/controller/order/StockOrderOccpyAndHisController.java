package com.metersbonwe.stock.controller.order;

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
import com.metersbonwe.stock.biz.manager.service.StockOrderOccpyAndHisService;
import com.metersbonwe.stock.controller.BaseController;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockChannelOrderDetail;
import com.metersbonwe.stock.po.core.StockChannelOrderDetailHis;
import com.metersbonwe.stock.pojo.Page;

@Controller public class StockOrderOccpyAndHisController extends BaseController {
    private static StockLog                LOGGER = StockLogFactory.getLogger(StockOrderOccpyAndHisController.class);

    @Resource StockOrderOccpyAndHisService stockOrderOccpyAndHisServiceImpl;

    /**
     * TODO 订单预占信息查询
     *
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectOrderOccupy")
    public String selectOrderOccupy(HttpServletRequest request, HttpServletResponse response) {
        List<StockChannelOrderDetail> orderDetails = null;
        Page<?> page = null;
        try {
            Map<String, String> paraMap = assembleSelectParam(request);
            StockChannelOrderDetail detail = new StockChannelOrderDetail();
            BeanUtils.populate(detail, paraMap);
            if (StringUtils.isBlank(detail.getChannelCode()) || StringUtils.isBlank(detail.getProdId())) {
                return assembleUnSelectResult(ExceptionConstants.ERROR_CODE, "查询条件错误，渠道编号、商品编码 都不能为空！");
            }
            orderDetails = stockOrderOccpyAndHisServiceImpl.selectOrderOccupy(detail);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return assembleSelectResult(orderDetails, page);
    }

    /**
     * TODO 订单实占信息查询
     *
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectOrderOccupyHis")
    public String selectOrderOccupyHis(HttpServletRequest request, HttpServletResponse response) {
        List<StockChannelOrderDetailHis> orderDetails = null;
        Page<?> page = null;
        try {
            Map<String, String> paraMap = assembleSelectParam(request);
            StockChannelOrderDetailHis detail = new StockChannelOrderDetailHis();
            BeanUtils.populate(detail, paraMap);
            if (StringUtils.isBlank(detail.getChannelCode()) || StringUtils.isBlank(detail.getProdId())) {
                return assembleUnSelectResult(ExceptionConstants.ERROR_CODE, "查询条件错误，渠道编号、商品编码 都不能为空！");
            }
            orderDetails = stockOrderOccpyAndHisServiceImpl.selectOrderOccupyHis(detail);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return assembleSelectResult(orderDetails, page);
    }
}
