package com.metersbonwe.stock.biz.common.service.impl;

import org.springframework.stereotype.Service;

import com.metersbonwe.stock.biz.common.service.FullChannelGroupService;
import com.metersbonwe.stock.configuration.ZkConfig;

@Service public class FullChannelGroupServiceImpl implements FullChannelGroupService {
    @Override
    public boolean getChannelProdUpdateFlag(String channelCode) {
        return "true".equalsIgnoreCase(ZkConfig.getConfig(channelCode));
    }

    @Override
    public void setChannelProdUpdateFlag(String channelCode, boolean updateFlag) {
        ZkConfig.setConfig(channelCode, String.valueOf(updateFlag));
    }

   
}
