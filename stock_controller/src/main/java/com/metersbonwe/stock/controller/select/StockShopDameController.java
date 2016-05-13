package com.metersbonwe.stock.controller.select;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.metersbonwe.stock.ExceptionConstants.ExceptionCode;
import com.metersbonwe.stock.FileConstants;
import com.metersbonwe.stock.biz.manager.service.StockShopDameService;
import com.metersbonwe.stock.controller.BaseController;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockShopDame;
import com.metersbonwe.stock.pojo.Page;
import com.metersbonwe.stock.vo.StockShopDameVo;

/**
 * TODO 污损值查询
 * 
 * @author zhangfeng zhangfeng13@metersbonwe.com
 * @date 2016年4月5日 下午1:00:01
 * @since V1.0
 * @version V1.0
 */
@Controller public class StockShopDameController extends BaseController {

    private static StockLog        LOGGER = StockLogFactory.getLogger(StockShopDameController.class);

    @Resource StockShopDameService stockShopDameServiceImpl;

    /**
     * TODO 全流通污损值查询
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectShopDame")
    public String selectShopDame(HttpServletRequest request, HttpServletResponse response) {
        List<StockShopDame> dames = null;
        Page<?> page = null;
        try {
            Map<String, String> paraMap = assembleSelectParam(request);
            Map<String, List<String>> paraListMap = assembleSelectListParam(paraMap);
            String fileDownFlag = paraMap.get("fileDownFlag");
            // fileDownFlag 为空则不是文件下载    则需要分页
            if (StringUtils.isBlank(fileDownFlag)) {
                page = assemblePageSelect(paraMap);
            }
            dames = stockShopDameServiceImpl.selectStockShopDame(paraListMap);
            if (StringUtils.isNotBlank(fileDownFlag)) {
                List<Object> objects = new ArrayList<>();
                objects.addAll(dames);
                fileDownload(
                        FileConstants.Template.SHOPDAMEDETAIL,
                        converFileDownStr(objects, FileConstants.TEMPLATE_MAP.get(FileConstants.Template.SHOPDAMEDETAIL)),
                        response);
                return null;
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return assembleSelectResult(dames, page);
    }

    /**
     * TODO 全流通污损值查询（文件上传方式）
     *
     * @param request
     * @return
     */
    @SuppressWarnings("unused")
    @ResponseBody
    @RequestMapping(value = "/fileUploadShopDame")
    public String fileUploadShopDame(HttpServletRequest request, HttpServletResponse response) {
        String errorCode = null;
        int count = 0;
        try {
            File file = fileUploadSingle(request);
            List<String> fileStrLists = FileUtils.readLines(file);
            String title = fileStrLists.get(0);
            String[] subTitles = title.split(",");
            count = file == null ? 0 : 1;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return assembleUnSelectResult(count, errorCode);
    }

    /**
     * TODO 全流通污损值更新
     *
     * @param jsonData
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateShopDame")
    public String updateShopDame(HttpServletRequest request) {
        int succCount = 0;
        String errCode = null;
        try {
            Map<String, String> paraMap = assembleUnSelectParam(request);
            StockShopDameVo vo = new StockShopDameVo();
            BeanUtils.populate(vo, paraMap);
            succCount = stockShopDameServiceImpl.updateStockShopDame(vo);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return assembleUnSelectResult(succCount, errCode);
    }

    /**
     * TODO 全流通污损值删除
     *
     * @param jsonData
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteShopDame")
    public String deleteShopDame(HttpServletRequest request) {
        int succCount = 0;
        String errCode = null;
        try {
            Map<String, String> paraMap = assembleUnSelectParam(request);
            String ids = paraMap.get("id");
            if (StringUtils.isNotBlank(ids)) {
                String[] idStrs = ids.split(",");
                for (String id : idStrs) {
                    StockShopDameVo vo = new StockShopDameVo();
                    vo.setId(Integer.valueOf(id));
                    succCount = stockShopDameServiceImpl.deleteStockShopDame(vo);
                }
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return assembleUnSelectResult(succCount, errCode);
    }

    /**
     * TODO 全流通污损值新增
     *
     * @param jsonData
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addShopDame")
    public String addShopDame(HttpServletRequest request) {
        int succCount = 0;
        String errCode = null;
        try {
            Map<String, String> paraMap = assembleUnSelectParam(request);
            StockShopDameVo vo = new StockShopDameVo();
            BeanUtils.populate(vo, paraMap);
            vo.setUpdateTime(new Date());
            succCount = stockShopDameServiceImpl.addStockShopDame(vo);
        } catch (Exception e) {
            errCode = ExceptionCode.DUPLICATION_RECODE;
            LOGGER.error(e.getMessage(), e);
        }
        return assembleUnSelectResult(succCount, errCode);
    }
}
