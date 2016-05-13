package com.metersbonwe.stock.controller.select;

import java.util.ArrayList;
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
import com.metersbonwe.stock.biz.manager.service.StockShopOnlineService;
import com.metersbonwe.stock.controller.BaseController;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.pojo.Page;
import com.metersbonwe.stock.pojo.StockChannelBean;
import com.metersbonwe.stock.pojo.StockShopOnlineBean;

/**
 * TODO 全流通线上库存查询
 * 
 * @author zhangfeng zhangfeng13@metersbonwe.com
 * @date 2016年4月5日 下午1:00:01
 * @since V1.0
 * @version V1.0
 */
@Controller public class StockShopOnlineController extends BaseController {

    private static StockLog          LOGGER = StockLogFactory.getLogger(StockShopOnlineController.class);

    @Resource StockShopOnlineService stockShopOnlineServiceImpl;

    /**
     * TODO 全流通线上库存查询
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectShopOnline")
    public String selectShopOnline(HttpServletRequest request, HttpServletResponse response) {
        List<StockChannelBean> stocks = null;
        Page<?> page = null;
        try {
            Map<String, String> paraMap = assembleSelectParam(request);
            Map<String, List<String>> paraListMap = assembleSelectListParam(paraMap);
            String fileDownFlag = paraMap.get("fileDownFlag");
            StockShopOnlineBean vo = new StockShopOnlineBean();
            if (CollectionUtils.isNotEmpty(paraListMap.get("warehId"))) {
                vo.setWarehShopIds(paraListMap.get("warehId"));
            }

            if (CollectionUtils.isNotEmpty(paraListMap.get("prodId"))) {
                vo.setProdIds(paraListMap.get("prodId"));
            }
            // 涉及分表 获取并存放所有分表表后缀 
            vo.setTableSeqs(getMaxTableSeqs());
            // fileDownFlag 为空则不是文件下载    则需要分页
            if (StringUtils.isBlank(fileDownFlag)) {
                page = assemblePageSelect(paraMap);
            }
            stocks = stockShopOnlineServiceImpl.selectShopOnlineStock(vo);
            if (StringUtils.isNotBlank(fileDownFlag)) {
                List<Object> objects = new ArrayList<>();
                objects.addAll(stocks);
                fileDownload(
                        FileConstants.Template.SHOPONLINEDETAIL,
                        converFileDownStr(objects, FileConstants.TEMPLATE_MAP.get(FileConstants.Template.SHOPONLINEDETAIL)),
                        response);
                return null;
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return assembleSelectResult(stocks, page);
    }
}
