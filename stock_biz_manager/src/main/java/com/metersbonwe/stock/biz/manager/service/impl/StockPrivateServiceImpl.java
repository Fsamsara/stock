package com.metersbonwe.stock.biz.manager.service.impl;

import com.metersbonwe.stock.Constants;
import com.metersbonwe.stock.biz.manager.service.StockPrivateService;
import com.metersbonwe.stock.dal.define.sync.mapper.UsefulWarehChangeSyncMapper;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.sync.define.ChannelReservedBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huangbiao
 * @version V1.0
 * @description
 * @date 2016/5/5
 */
@Service
public class StockPrivateServiceImpl implements StockPrivateService {
    private static StockLog log = StockLogFactory.getLogger(StockPrivateServiceImpl.class);

    @Resource
    UsefulWarehChangeSyncMapper usefulWarehChangeSyncMapper;

    @Override public List<ChannelReservedBean> selectPrivateStock(Map<String, List<String>> paraListMap, String privateStockOpFlag) {
        Map<String, Object> paramMap = new HashMap<>();
        List<String> channelCodeList = paraListMap.get(Constants.ParamMapKey.CHANNEL_CODE);
        List<String> warehId = paraListMap.get(Constants.ParamMapKey.WAREH_ID);
        List<String> prodIds = paraListMap.get(Constants.ParamMapKey.PROD_ID);
        List<String> reservedStock = paraListMap.get(Constants.ParamMapKey.RESERVED_STOCK);
        paramMap.put(Constants.ParamMapKey.CHANNEL_CODE_LIST, channelCodeList);
        paramMap.put(Constants.ParamMapKey.USEFUL_WAREH_LIST, warehId);
        String prodId = prodIds != null && prodIds.size() > 0 ? prodIds.get(0) : null;
        paramMap.put(Constants.ParamMapKey.PROD_ID, prodId);
        String op = "";
        if(Constants.Opration.GT.equalsIgnoreCase(privateStockOpFlag)){
            op = ">";
        }else if(Constants.Opration.LT.equalsIgnoreCase(privateStockOpFlag)){
            op = "<";
        }else{
            op = "=";
        }
        paramMap.put("op", op);
        if(reservedStock != null && reservedStock.size() > 0){
            paramMap.put("reservedStock", reservedStock.get(0));
        }
        return usefulWarehChangeSyncMapper.getChannelReservedData(paramMap);
    }
}
