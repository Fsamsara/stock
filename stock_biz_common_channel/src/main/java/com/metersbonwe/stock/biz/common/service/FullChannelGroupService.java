package com.metersbonwe.stock.biz.common.service;

/**
 * 渠道全量汇总相关SERVICE
 *
 */
public interface FullChannelGroupService {
    /**
     * #description 从ZK中获取，渠道商品明细表是否在大量更新的标识
     * @return 是否在大量更新
     */
    boolean getChannelProdUpdateFlag(String channelCode);

    /**
     * @description 更新ZK里面的渠道商品明细表的正在更新标识
     * @param updateFlag true表示正在更新， false则相反
     */
    void setChannelProdUpdateFlag(String channelCode, boolean updateFlag);

}
