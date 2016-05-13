package com.metersbonwe.stock.biz.common.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.metersbonwe.stock.biz.common.service.ActivityWarehService;
import com.metersbonwe.stock.dal.auto.sync.mapper.StActivityWarehMapper;
import com.metersbonwe.stock.facade.FacadeConstants;
import com.metersbonwe.stock.po.sync.StActivityWareh;
import com.metersbonwe.stock.po.sync.StActivityWarehExample;

@Service public class ActivityWarehServiceImpl implements ActivityWarehService {

    private final static String     NEW_ERP              = "NERP";

    private final static String     OLD_ERP              = "OERP";

    private final static String     IS_SHOP              = "1";

    //仓库、门店安全库存类型 NO
    private final static String     NO_SAFETY_STOCK_TYPE = "NO";

    //仓库、门店安全库存类型 WS
    private final static String     WS_SAFETY_STOCK_TYPE = "WS";

    //仓库安全库存类型 WP
    private final static String     WP_SAFETY_STOCK_TYPE = "WP";

    @Resource StActivityWarehMapper stActivityWarehMapper;

    @Override
    public StActivityWareh findActivityWareh(String warehId) {
        return stActivityWarehMapper.selectByPrimaryKey(warehId);
    }

    @Override
    public List<StActivityWareh> findActivityWarehs(List<String> warehList) {
        StActivityWarehExample example = new StActivityWarehExample();
        example.createCriteria().andWarehIdIn(warehList);
        List<StActivityWareh> stActivityWarehList = stActivityWarehMapper.selectByExample(example);
        return stActivityWarehList;
    }

    @Override
    public boolean isNewERP(String datasource) {
        return StringUtils.equalsIgnoreCase(NEW_ERP, datasource);
    }

    @Override
    public boolean isOldERP(String datasource) {
        return StringUtils.equalsIgnoreCase(OLD_ERP, datasource);
    }

    @Override
    public boolean isShop(String isShop) {
        return StringUtils.equalsIgnoreCase(IS_SHOP, isShop);
    }

    @Override
    public boolean isNOSafetyStockType(String safetyStockType) {
        return StringUtils.equalsIgnoreCase(NO_SAFETY_STOCK_TYPE, safetyStockType);
    }

    @Override
    public boolean isWSSafetyStockType(String safetyStockType) {
        return StringUtils.equalsIgnoreCase(WS_SAFETY_STOCK_TYPE, safetyStockType);
    }

    @Override
    public boolean isWPSafetyStockType(String safetyStockType) {
        return StringUtils.equalsIgnoreCase(WP_SAFETY_STOCK_TYPE, safetyStockType);
    }

    public boolean isChannelSourceOnLine(String channelSource) {
        return StringUtils.equalsIgnoreCase(FacadeConstants.CHANNELSOURCE_ONLINE, channelSource);
    }

    public boolean isChannelSourceOffLine(String channelSource) {
        return StringUtils.equalsIgnoreCase(FacadeConstants.CHANNELSOURCE_OFFLINE, channelSource);
    }

}
