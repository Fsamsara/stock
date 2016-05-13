package com.metersbonwe.stock.controller.select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.metersbonwe.stock.FileConstants;
import com.metersbonwe.stock.biz.common.service.WmsLockedStockService;
import com.metersbonwe.stock.biz.manager.service.TmpStockWmsService;
import com.metersbonwe.stock.controller.BaseController;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.TmpStockWms;
import com.metersbonwe.stock.pojo.Page;
import com.metersbonwe.stock.vo.TmpStockWmsVo;

/**
 * TODO 仓库WMS锁定量查询
 * 
 * @author zhangjf
 * @date 2016年5月5日 下午1:00:01
 * @since V1.0
 * @version V1.0
 */
@Controller public class TmpStockWmsController extends BaseController {
    private static StockLog          LOGGER = StockLogFactory.getLogger(TmpStockWmsController.class);

    @Autowired TmpStockWmsService    tmpStockWmsService;

    @Autowired WmsLockedStockService wmsLockedStockService;

    /**
     * TODO 仓库WMS锁定量查询
     * 
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectStockWms")
    public String selectStockWms(HttpServletRequest request, HttpServletResponse response) {
        List<TmpStockWmsVo> dames = null;
        Page<?> page = null;
        try {
            String tableName = wmsLockedStockService.getCurrentWmsLockedStockTableName();
            List<String> tableNames=new ArrayList<String>();
            tableNames.add(tableName);
            
            Map<String, String> paraMap = assembleSelectParam(request);
            Map<String, List<String>> paraListMap = assembleSelectListParam(paraMap);
            String fileDownFlag = paraMap.get("fileDownFlag");
            // fileDownFlag 为空则不是文件下载    则需要分页
            if (StringUtils.isBlank(fileDownFlag)) {
                page = assemblePageSelect(paraMap);
            }
            paraListMap.put("tbn", tableNames);
            List<TmpStockWms> tmpStockWmss = tmpStockWmsService.selectTmpStockWms(paraListMap);
            dames = new ArrayList<TmpStockWmsVo>();
            for (TmpStockWms tmpStockWms : tmpStockWmss) {
                TmpStockWmsVo vo = new TmpStockWmsVo();
                BeanUtils.copyProperties(tmpStockWms, vo);
                dames.add(vo);
            }
            if (StringUtils.isNotBlank(fileDownFlag)) {
                List<Object> objects = new ArrayList<>();
                objects.addAll(dames);
                fileDownload(
                        FileConstants.Template.STOCKWMSETAIL,
                        converFileDownStr(objects, FileConstants.TEMPLATE_MAP.get(FileConstants.Template.STOCKWMSETAIL)),
                        response);
                return null;
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return assembleSelectResult(dames, page);
    }
}
