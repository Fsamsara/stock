package com.metersbonwe.stock.biz.common.service;

import java.util.List;

import com.metersbonwe.stock.po.sync.StActivityWareh;

/**
 * 活动仓店公用服务
 * @author 张瑞雨
 *
 */
public interface ActivityWarehService {
	
	/**
	 * 查找活动仓店数据
	 * @param warehId 仓库code
	 * @return 仓店数据
	 */
	StActivityWareh findActivityWareh(String warehId);
	
	/**
     * 查找多个活动仓店数据
     * @param warehList 仓库编码集合
     * @return 多个仓店数据
     */
	List<StActivityWareh> findActivityWarehs(List<String> warehList);
	
	/**
	 * 数据是否在新erp
	 * @param datasource
	 * @return
	 */
	boolean isNewERP(String datasource);
	
	/**
	 * 数据是否在老ERP
	 * @param datasource
	 * @return
	 */
	boolean isOldERP(String datasource);
	
	/**
	 * 是否是门店
	 * @param isShop 0或1 1是0否
	 * @return
	 */
	boolean isShop(String isShop);
	
	/**
     * 安全库存类型是否为 NO
     * @param safetyStockType
     * @return
     */
	boolean isNOSafetyStockType(String safetyStockType);
	
	/**
     * 安全库存类型是否为 WS
     * @param safetyStockType
     * @return
     */
    boolean isWSSafetyStockType(String safetyStockType);
    
    /**
     * 安全库存类型是否为 WP
     * @param safetyStockType
     * @return
     */
    boolean isWPSafetyStockType(String safetyStockType);
    
    /**
     * 
     * TODO 判断是否线上
     * @param channelSource
     * @return
     */
    boolean isChannelSourceOnLine(String channelSource);
    
    /**
     * 
     * TODO 判断是否线下
     * @param channelSource
     * @return
     */
    boolean isChannelSourceOffLine(String channelSource);
	
}
