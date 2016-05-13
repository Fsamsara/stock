package com.metersbonwe.stock.controller.select;

import java.util.ArrayList;
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
import com.metersbonwe.stock.FileConstants;
import com.metersbonwe.stock.biz.common.service.ShopQueryStockService;
import com.metersbonwe.stock.controller.BaseController;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.pojo.Page;
import com.metersbonwe.stock.pojo.ShopQueryLocStockParamBean;
import com.metersbonwe.stock.pojo.ShopQueryLocStockResultBean;
import com.metersbonwe.stock.pojo.ShopQueryStockParamBean;
import com.metersbonwe.stock.pojo.ShopQueryStockResultBean;
import com.metersbonwe.stock.pojo.imexcel.ShopQueryLocStockExcelBean;
import com.metersbonwe.stock.utils.CommonUtil;
import com.metersbonwe.stock.utils.imexcel.ImportExportDataUtil;
import com.metersbonwe.stock.vo.ShopQueryStockVo;

/**
 * TODO 门店实际库存查询
 * 
 * @author zhangjf
 * @date 2016年5月5日 下午1:00:01
 * @since V1.0
 * @version V1.0
 */
@Controller public class ShopQueryStockController extends BaseController {
    private static StockLog          LOGGER = StockLogFactory.getLogger(ShopQueryStockController.class);

    @Autowired ShopQueryStockService ShopQueryStockService;

    @ResponseBody
    @RequestMapping(value = "/selectShopQueryStock")
    public String selectShopQueryStock(HttpServletRequest request, HttpServletResponse response) {
        List<ShopQueryStockVo> dames = null;
        Page<?> page = null;
        try {
            Map<String, String> paraMap = assembleSelectParam(request);
            Map<String, List<String>> paraListMap = assembleSelectListParam(paraMap);
            String fileDownFlag = paraMap.get("fileDownFlag");
            // fileDownFlag 为空则不是文件下载    则需要分页
            if (StringUtils.isBlank(fileDownFlag)) {
                page = assemblePageSelect_Custom(paraMap);
            }

            ShopQueryStockParamBean paramBean = new ShopQueryStockParamBean();
            List<String> warehIds = paraListMap.get("warehId");
            if (CollectionUtils.isEmpty(warehIds)) {
                return assembleUnSelectResult(0, "请输入要查询的门店");
            } else {
                if (warehIds.size() != 1) {
                    return assembleUnSelectResult(0, "目前只支持单门店查询");
                }
            }
            String warehId = warehIds.get(0);
            paramBean.setWarehId(warehId);
            List<String> prodIds = paraListMap.get("prodId");
            paramBean.setSkuList(prodIds);
            if (CollectionUtils.isEmpty(prodIds)) {
                return assembleUnSelectResult(0, "请输入要查询的商品");
            }

            List<ShopQueryStockResultBean> shopQueryStockResultBeans = ShopQueryStockService.shopQueryStock_Page(page, paramBean);
            dames = new ArrayList<ShopQueryStockVo>();
            for (ShopQueryStockResultBean shopQueryStockResultBean : shopQueryStockResultBeans) {
                ShopQueryStockVo vo = new ShopQueryStockVo();
                BeanUtils.copyProperties(shopQueryStockResultBean, vo);
                dames.add(vo);
            }

            if (StringUtils.isNotBlank(fileDownFlag)) {
                List<Object> objects = new ArrayList<>();
                objects.addAll(dames);
                fileDownload(
                        FileConstants.Template.SHOPQUERYSTOCKETAIL,
                        converFileDownStr(objects, FileConstants.TEMPLATE_MAP.get(FileConstants.Template.SHOPQUERYSTOCKETAIL)),
                        response);
                return null;
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return assembleSelectResult(dames, page);
    }

    private Page<?> assemblePageSelect_Custom(Map<String, String> paraMap) {
        String pageNo = paraMap.get(Constants.PAGE_OBJECT);
        String rows = paraMap.get(Constants.ROWS_OBJECT);

        Page<?> page = new Page<>();
        page.setPageNo(CommonUtil.toInt(pageNo));
        page.setPageSize(CommonUtil.toInt(rows));
        return page;
    }

    @ResponseBody
    @RequestMapping(value = "/selectShopQueryLocStock")
    public String selectShopQueryLocStock(HttpServletRequest request, HttpServletResponse response) {
        List<ShopQueryLocStockExcelBean> dames = null;
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
            List<String> warehIds = paraListMap.get("warehId");
            if (CollectionUtils.isEmpty(warehIds)) {
                return assembleUnSelectResult(0, "请输入要查询的门店");
            } else {
                if (warehIds.size() != 1) {
                    return assembleUnSelectResult(0, "目前只支持单门店查询");
                }
            }
            String warehId = warehIds.get(0);
            List<String> locIds = paraListMap.get("locId");
            List<String> prodIds = paraListMap.get("prodId");
            if (CollectionUtils.isEmpty(prodIds)) {
                return assembleUnSelectResult(0, "请输入要查询的商品");
            }

            if (isquery) {
                ShopQueryLocStockParamBean paramBean = new ShopQueryLocStockParamBean();
                paramBean.setWarehId(warehId);
                paramBean.setLocList(locIds);
                paramBean.setSkuList(prodIds);

                List<ShopQueryLocStockResultBean> shopQueryLocStockResultList = this.ShopQueryStockService.shopQueryLocStock_Page(page, paramBean);
                dames = new ArrayList<ShopQueryLocStockExcelBean>();
                if (shopQueryLocStockResultList != null && shopQueryLocStockResultList.size() > 0) {
                    for (ShopQueryLocStockResultBean shopQueryLocStockResultBean : shopQueryLocStockResultList) {
                        ShopQueryLocStockExcelBean excelBean = new ShopQueryLocStockExcelBean();
                        BeanUtils.copyProperties(shopQueryLocStockResultBean, excelBean);
                        dames.add(excelBean);
                    }
                }
            } else {
                dames = new ArrayList<ShopQueryLocStockExcelBean>();
            }

            if (StringUtils.isNotBlank(fileDownFlag)) {
                String values = ImportExportDataUtil.getExportData(dames, ShopQueryLocStockExcelBean.class);
                fileDownload("门店货位库存_" + warehId, values, response);
                return null;
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return assembleSelectResult(dames, page);
    }
}
