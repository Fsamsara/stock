package com.metersbonwe.stock.controller.select;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.metersbonwe.stock.Constants;
import com.metersbonwe.stock.biz.common.service.FreeShareReservedLockedStockService;
import com.metersbonwe.stock.controller.BaseController;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.pojo.Page;
import com.metersbonwe.stock.pojo.QryLockStockResultBean;
import com.metersbonwe.stock.pojo.imexcel.QueryLockedStockExcelBean;
import com.metersbonwe.stock.utils.CommonUtil;
import com.metersbonwe.stock.utils.imexcel.ImportExportDataUtil;

@Controller public class QueryLockedStockController extends BaseController {
    private static StockLog                        LOGGER = StockLogFactory.getLogger(QueryLockedStockController.class);

    @Autowired FreeShareReservedLockedStockService freeShareReservedLockedStockServiceImpl;

    private Page<?> assemblePageSelect_Custom(Map<String, String> paraMap) {
        String pageNo = paraMap.get(Constants.PAGE_OBJECT);
        String rows = paraMap.get(Constants.ROWS_OBJECT);

        Page<?> page = new Page<>();
        page.setPageNo(CommonUtil.toInt(pageNo));
        page.setPageSize(CommonUtil.toInt(rows));
        return page;
    }

    @ResponseBody
    @RequestMapping(value = "/selectQueryLockedStock")
    public String selectQueryLockedStock(HttpServletRequest request, HttpServletResponse response) {
        List<QueryLockedStockExcelBean> dames = null;
        Page<?> page = null;
        try {
            Map<String, String> paraMap = assembleSelectParam(request);
            Map<String, List<String>> paraListMap = assembleSelectListParam(paraMap);
            String fileDownFlag = paraMap.get("fileDownFlag");
            // fileDownFlag 为空则不是文件下载    则需要分页
            if (StringUtils.isBlank(fileDownFlag)) {
                page = assemblePageSelect_Custom(paraMap);
            }
            Boolean isquery = true;
            List<String> warehList = paraListMap.get("warehId");
            if (CollectionUtils.isEmpty(warehList)) {
                return assembleUnSelectResult(0, "请输入要查询的仓库");
            }
            List<String> reservedTypeList = paraListMap.get("reservedType");
            if (CollectionUtils.isEmpty(reservedTypeList)) {
                return assembleUnSelectResult(0, "请输入要查询的预留类型");
            }

            List<String> skuList = paraListMap.get("prodId");

            if (isquery) {
                List<QryLockStockResultBean> qryLockStockResultBeanList = freeShareReservedLockedStockServiceImpl.getLockStock_Page(
                        page,
                        reservedTypeList,
                        warehList,
                        skuList);
                dames = new ArrayList<QueryLockedStockExcelBean>();
                if (qryLockStockResultBeanList != null && qryLockStockResultBeanList.size() > 0) {
                    for (QryLockStockResultBean qryLockStockResultBean : qryLockStockResultBeanList) {
                        QueryLockedStockExcelBean excelBean = new QueryLockedStockExcelBean();
                        BeanUtils.copyProperties(qryLockStockResultBean, excelBean);
                        dames.add(excelBean);
                    }
                }
            } else {
                dames = new ArrayList<QueryLockedStockExcelBean>();
            }

            if (StringUtils.isNotBlank(fileDownFlag)) {
                String values = ImportExportDataUtil.getExportData(dames, QueryLockedStockExcelBean.class);
                fileDownload("仓库锁定量_" + String.valueOf((new Date()).getTime()), values, response);
                return null;
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return assembleSelectResult(dames, page);
    }
}
