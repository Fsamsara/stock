package com.metersbonwe.stock.dal.define.core.mapper;

import com.metersbonwe.stock.po.core.define.ChannelProdBean;

import java.util.List;
import java.util.Map;

/* *
 * @description 渠道可用仓变化专用mapper
 * @author huangbiao
 * @date 2016/03/17
 * @version V1.0
 */
public interface UsefulWarehChangeCoreMapper {
    void insertToTmpStockChannelProd();

    void insertToTmpStockBatchReserved(Map<String, Object> paramMap);

    void insertToTmpStockBatchShopGroupReserved(Map<String, Object> paramMap);

    void updateDecreaceSku(Map<String, Object> paramMap);

    void insertToStockChannelProdSub(Map<String, Object> paramMap);

    List<ChannelProdBean> getNeedSendData(Map<String, Object> paramMap);

    void updateChannelProdTable(Map<String, Object> paramMap);

    void insertIntoChannelProdTable(Map<String, Object> paramMap);

    void insertIntoTmpReservedSum();

    void insertIntoTmpShopGroupReservedSum();

    void insertToTmpStockWareh(Map<String, Object> paramMap);

    List<String> getTmpStockWareh();

    List<String> getTableNoList(Map<String, Object> paramMap);

    void insertWarehToTmpStockTableSum(Map<String, Object> paramMap);

    void insertShopToTmpStockTableSum(Map<String, Object> paramMap);
}
