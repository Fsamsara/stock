package com.metersbonwe.stock.controller.select;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.metersbonwe.stock.biz.common.service.PosAlloctSumQueryStockService;
import com.metersbonwe.stock.controller.BaseController;
import com.metersbonwe.stock.facade.FacadeConstants;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.pojo.Page;
import com.metersbonwe.stock.pojo.QueryStockAllParamBean;
import com.metersbonwe.stock.pojo.QueryStockResultBean;
import com.metersbonwe.stock.pojo.imexcel.PosQueryStockExcelBean;
import com.metersbonwe.stock.utils.imexcel.ImportExportDataUtil;

@Controller public class PosQueryStockController extends BaseController {
    private static StockLog                         LOGGER = StockLogFactory.getLogger(PosQueryStockController.class);

    @Resource private PosAlloctSumQueryStockService posAlloctSumQueryStockServiceImpl;

    @ResponseBody
    @RequestMapping(value = "/selectPosQueryStock")
    public String selectPosQueryStock(HttpServletRequest request, HttpServletResponse response) {
        List<PosQueryStockExcelBean> dames = null;
        Page<?> page = null;
        try {
            Map<String, String> paraMap = assembleSelectParam(request);
            Map<String, List<String>> paraListMap = assembleSelectListParam(paraMap);
            String fileDownFlag = paraMap.get("fileDownFlag");
            //            // fileDownFlag 为空则不是文件下载    则需要分页
            //            if (StringUtils.isBlank(fileDownFlag)) {
            //                page = assemblePageSelect_Custom(paraMap);
            //            }
            Boolean isquery = true;
            List<String> channelSourceList = paraListMap.get("channelSource");
            if (CollectionUtils.isEmpty(channelSourceList)) {
                channelSourceList = new ArrayList<>();
                channelSourceList.add(FacadeConstants.CHANNELSOURCE_ONLINE);

            } else {
                if (channelSourceList.size() > 1) {
                    return assembleUnSelectResult(0, "只能按一个渠道来源来查询");
                }
            }
            List<String> channelCodeList = paraListMap.get("channelCode");
            if (CollectionUtils.isEmpty(channelCodeList)) {
                return assembleUnSelectResult(0, "请输入要查询的渠道");
            } else {
                if (channelCodeList.size() > 1) {
                    return assembleUnSelectResult(0, "只能按一个渠道来查询");
                }
            }
            List<String> skuList = paraListMap.get("prodId");
            if (CollectionUtils.isEmpty(skuList)) {
                return assembleUnSelectResult(0, "请输入要查询的商品");
            }
            String county = "中国";
            String province = paraMap.get("province");
            String city = paraMap.get("city");
            String district = paraMap.get("district");

            //排除仓
            List<String> extWarehShopList = paraListMap.get("extWarehShop");

            String channelCode = "";
            if (isquery) {
                String channelSource = channelSourceList.get(0);
                channelCode = channelCodeList.get(0);
                //查询可用量、库存量
                QueryStockAllParamBean stockAllParam = new QueryStockAllParamBean();
                stockAllParam.setChannelSource(channelSource);
                stockAllParam.setChannelCode(channelCode);
                stockAllParam.setCounty(county);
                stockAllParam.setProvince(province);
                stockAllParam.setCity(city);
                stockAllParam.setDistrict(district);
                stockAllParam.setSkuList(skuList);
                stockAllParam.setExtWarehShopList(extWarehShopList);
                stockAllParam.setQueryModule(1);
                List<QueryStockResultBean> queryStockResultList = this.posAlloctSumQueryStockServiceImpl.queryStock(stockAllParam);

                dames = new ArrayList<PosQueryStockExcelBean>();
                if (queryStockResultList != null && queryStockResultList.size() > 0) {
                    for (QueryStockResultBean queryStockResultBean : queryStockResultList) {
                        PosQueryStockExcelBean excelBean = new PosQueryStockExcelBean();
                        BeanUtils.copyProperties(queryStockResultBean, excelBean);
                        dames.add(excelBean);
                    }
                }
            } else {
                dames = new ArrayList<PosQueryStockExcelBean>();
            }

            if (StringUtils.isNotBlank(fileDownFlag)) {
                String values = ImportExportDataUtil.getExportData(dames, PosQueryStockExcelBean.class);
                fileDownload("Pos全流通库存_" + channelCode + "_" + String.valueOf((new Date()).getTime()), values, response);
                return null;
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return assembleSelectResult(dames, page);
    }
}
