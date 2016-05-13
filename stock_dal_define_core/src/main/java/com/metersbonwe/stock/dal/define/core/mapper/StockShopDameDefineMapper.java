package com.metersbonwe.stock.dal.define.core.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.metersbonwe.stock.po.core.StockShopDame;
import com.metersbonwe.stock.vo.StockShopDameVo;

/**
 * @author zhq
 */
public interface StockShopDameDefineMapper {

	
	/**
	 * 无效污次少洗历史数据删除(根据仓|门店ID、SKUID删除)
	 * @param suffix
	 * @param configValue
	 * @return
	 */
	int deleteInvalid(@Param("warehId") String warehId,@Param("prodId") String prodId);

    /**
     * TODO 通过条件查询污损值
     *
     * @param dameVo
     * @return
     */
    List<StockShopDameVo> selectStockShopDame(@Param("shopDame") StockShopDame damePo);
    
    int insertDameStock(StockShopDame damePo);
    
    int updateDameStock(StockShopDame damePo);
}

