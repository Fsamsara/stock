package com.metersbonwe.stock.controller.select;

import java.util.ArrayList;
import java.util.HashMap;
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
import com.metersbonwe.stock.biz.manager.service.StActivityWarehBizService;
import com.metersbonwe.stock.controller.BaseController;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.sync.StActivityWareh;
import com.metersbonwe.stock.pojo.Page;
import com.metersbonwe.stock.vo.StActivityWarehVo;

@Controller public class StActivityWarehController extends BaseController {
    private static StockLog              LOGGER = StockLogFactory.getLogger(StActivityWarehController.class);

    @Autowired StActivityWarehBizService stActivityWarehBizService;

    /**
     * TODO 配发组织查询
     * 
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectStActivityWareh")
    public String selectStActivityWareh(HttpServletRequest request, HttpServletResponse response) {
        List<StActivityWarehVo> dames = null;
        Page<?> page = null;
        try {
            Map<String, String> paraMap = assembleSelectParam(request);
            Map<String, List<String>> paraListMap = assembleSelectListParam(paraMap);
            String fileDownFlag = paraMap.get("fileDownFlag");
            // fileDownFlag 为空则不是文件下载    则需要分页
            if (StringUtils.isBlank(fileDownFlag)) {
                page = assemblePageSelect(paraMap);
            }
            List<StActivityWareh> stActivityWarehs = stActivityWarehBizService.selectStActivityWareh(paraListMap);
            dames = new ArrayList<StActivityWarehVo>();
            for (StActivityWareh stActivityWareh : stActivityWarehs) {
                StActivityWarehVo vo = new StActivityWarehVo();
                BeanUtils.copyProperties(stActivityWareh, vo);
                dames.add(vo);
            }
            if (StringUtils.isNotBlank(fileDownFlag)) {
                List<Object> objects = new ArrayList<>();
                Map<String, String> map = new HashMap<String, String>();
                map.put("OERP", "老ERP");
                map.put("NERP", "新ERP");
                map.put("VERP", "门户");
                for (StActivityWarehVo stActivityWarehVo : dames) {
                    stActivityWarehVo.setDataSource(map.get(stActivityWarehVo.getDataSource()));
                    stActivityWarehVo.setIsShop("1".equals(stActivityWarehVo) ? "是" : "否");
                }
                objects.addAll(dames);
                fileDownload(
                        FileConstants.Template.STACTIVITYWAREHDTL,
                        converFileDownStr(objects, FileConstants.TEMPLATE_MAP.get(FileConstants.Template.STACTIVITYWAREHDTL)),
                        response);
                return null;
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return assembleSelectResult(dames, page);
    }

}
