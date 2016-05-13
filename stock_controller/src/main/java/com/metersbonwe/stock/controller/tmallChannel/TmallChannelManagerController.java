package com.metersbonwe.stock.controller.tmallChannel;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.metersbonwe.stock.biz.manager.service.TmallChannelManagerService;
import com.metersbonwe.stock.controller.BaseController;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockChannelIncrement;
import com.metersbonwe.stock.po.core.StockChannelIncrementSub;
import com.metersbonwe.stock.pojo.Page;

@Controller public class TmallChannelManagerController extends BaseController {

    private static StockLog stockLog = StockLogFactory.getLogger(TmallChannelManagerController.class);
    
    @Resource
    TmallChannelManagerService tmallChannelManagerService;

    @ResponseBody
    @RequestMapping(value = "/selectTmallChannelManager")
    public String selectTmallChannelManagerInfos(HttpServletRequest request) {

        Page<?> page = null;

        Map<String, String> paramMap = assembleSelectParam(request);
        Map<String, List<String>> paramListMap = assembleSelectListParam(paramMap);
        
        String channelCodes = paramMap.get("channelCode");
        // fileDownFlag 为空则不是文件下载    则需要分页
        if (!StringUtils.isEmpty(channelCodes)) {
            paramMap.put("channelCode", channelCodes.toLowerCase());
        }

        String fileDownFlag = paramMap.get("fileDownFlag");

        if (StringUtils.isBlank(fileDownFlag)) {
            page = assemblePageSelect(paramMap);
        }
        
        List<StockChannelIncrement> lists = tmallChannelManagerService.selectTmallChannelManagerInfos(paramListMap);
        
        stockLog.debug("天猫库存同步管理查询完成");

        return assembleSelectResult(lists, page);
    }
    
    @ResponseBody
    @RequestMapping(value = "/selectTmallChannelManagerDetail")
    public String selectTmallChannelManagerDetailInfos(HttpServletRequest request) {
        Page<?> page = null;

        Map<String, String> paramMap = assembleSelectParam(request);

        String fileDownFlag = paramMap.get("fileDownFlag");
        // fileDownFlag 为空则不是文件下载    则需要分页
        if (StringUtils.isBlank(fileDownFlag)) {
            page = assemblePageSelect(paramMap);
        }
        
        List<StockChannelIncrementSub> subBean = tmallChannelManagerService.selectTmallChannelManagerDetailInfos(paramMap);
        
        stockLog.debug("天猫库存同步管理明细查询完成");

        return assembleSelectResult(subBean, page);
        
    }
    
    @ResponseBody
    @RequestMapping(value = "/isExistTmallChannelManagerDetail")
    public String isExistTmallChannelManagerDetailInfo(HttpServletRequest request) {

        Map<String, String> paramMap = assembleSelectParam(request);

        List<StockChannelIncrementSub> subBean = tmallChannelManagerService.isExistTmallChannelManagerDetailInfo(paramMap);

        stockLog.debug("天猫库存同步管理明细检查完成");

        return assembleSelectResult(subBean);

    }
    
    @ResponseBody
    @RequestMapping(value = "/addTmallChannelManagerDetail")
    public String addTmallChannelManagerDetailInfo(HttpServletRequest request) {

        Integer count = 0;
        String errMsg = null;
        try {
            Map<String, String> paramMap = assembleUnSelectParam(request);
            count = tmallChannelManagerService.addTmallChannelManagerDetailInfo(paramMap);
        } catch (Exception e) {
            errMsg = e.getMessage();
        }

        stockLog.debug("天猫库存同步管理明细添加完成");

        return assembleUnSelectResult(count,errMsg);

    }
    
    
    
}
