package com.metersbonwe.stock.controller.select;

import java.util.ArrayList;
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

import com.metersbonwe.stock.FileConstants;
import com.metersbonwe.stock.biz.common.service.AllocationRangeService;
import com.metersbonwe.stock.biz.manager.service.StockChannelScopService;
import com.metersbonwe.stock.controller.BaseController;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockChannelScope;

/**
 * TODO 配发范围查询
 * 
 * @author zhangfeng zhangfeng13@metersbonwe.com
 * @date 2016年4月5日 下午1:00:01
 * @since V1.0
 * @version V1.0
 */
@Controller public class StockChannelScopeController extends BaseController {

    private static StockLog           LOGGER = StockLogFactory.getLogger(StockChannelScopeController.class);

    @Resource StockChannelScopService stockChannelScopServiceImpl;

    @Resource AllocationRangeService  allocationRangeServiceImpl;

    /**
     * TODO 渠道配发范围查询
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectChannelScope")
    public String selectChannelScope(HttpServletRequest request, HttpServletResponse response) {
        List<StockChannelScope> channels = null;
        try {
            Map<String, String> paraMap = assembleSelectParam(request);
            String fileDownFlag = paraMap.get("fileDownFlag");
            StockChannelScope vo = new StockChannelScope();
            BeanUtils.populate(vo, paraMap);
            channels = stockChannelScopServiceImpl.selectStockChannelScope(vo);

            if (StringUtils.isNotBlank(fileDownFlag)) {
                List<Object> objects = new ArrayList<>();
                objects.addAll(channels);
                fileDownload(
                        FileConstants.Template.CHANNELSCOPEDETAIL,
                        converFileDownStr(objects, FileConstants.TEMPLATE_MAP.get(FileConstants.Template.CHANNELSCOPEDETAIL)),
                        response);
                return null;
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return assembleSelectResult(channels);
    }

    /**
     * TODO 获取所有渠道仓店信息
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectChannelInfo")
    public String selectChannelInfo(HttpServletRequest request) {
        List<StockChannelScope> channels = null;
        try {
            channels = allocationRangeServiceImpl.getAllUsefulChannelForBean();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return assembleSelectResult(channels);
    }
}
