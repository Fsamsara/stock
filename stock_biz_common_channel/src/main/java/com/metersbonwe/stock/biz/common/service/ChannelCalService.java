package com.metersbonwe.stock.biz.common.service;


/**
 * @description 仓到渠道库存汇总计算
 */
public interface ChannelCalService {

    boolean processChannelUsefulWarehChange(boolean isFullSyncFlag);
}
