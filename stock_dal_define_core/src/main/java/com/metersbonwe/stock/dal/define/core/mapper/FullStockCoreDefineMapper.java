package com.metersbonwe.stock.dal.define.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.metersbonwe.stock.po.core.TmpStockWarehProdFree;
import com.metersbonwe.stock.po.core.TmpStockWarehProdLock;

public interface FullStockCoreDefineMapper {
    /**
     * 插入自由量临时表
     * 
     * @param item
     *            自由量集合
     * @param suffix
     *            表后缀
     * @return
     */
    int insertFreeStockTmp(@Param("freeStocks") List<TmpStockWarehProdFree> item, @Param("suffix") String suffix);

    /**
     * 批量插入锁定量临时表
     * 
     * @param tempItme
     *            锁定量集合
     * @param suffix
     *            表后缀
     * @return
     */
    int insertLockedStockTmp(@Param("lockStocks") List<TmpStockWarehProdLock> tempItme, @Param("suffix") String suffix);
    
    /**
     * 
     * 更新WP安全库存到临时表
     * @param suffix
     */
    int updateWpSafeStockTmp(@Param("suffix") String suffix);
    /**
     * 
     * 更新门店安全库存
     * @param suffix
     * @return
     */
    int updateShopSafeStockTmp(@Param("suffix") String suffix);
    
    /**
     *  
     * 更新门店安全库存到-1
     * @param suffix
     * @return
     */
    int updateShopSafeStockDefaultTmp(@Param("suffix") String suffix);
    
    /**
     * 
     * 更新门店污损值
     * @param suffix 
     * @return
     */
    int updateShopDame(@Param("suffix") String suffix);
    
    /**
     * 
     * 更新门店未日结
     * @param suffix 
     * @return
     */
    int updateShopRemail(@Param("suffix") String suffix);
    
    /**
     * 
     * 将门店未日结数据汇总插入到临时表tmp_shop_remail
     * @return
     */
    int insertGroupByShopReMail();
    
    /**
     *  
     * 插入仓库+sku数据从临时表
     * @param suffix 表后缀
     * @return
     */
    int insertStockWarehProdTableFormTmp(@Param("suffix") String suffix);
    
    /**
     * 
     * 更新正数锁定到自由量临时表
     * 
     * @param suffix
     * @return
     */
    int updateStockWmsLockedStock(@Param("suffix") String suffix,@Param("tableName") String tableName);
    
    /**
     * 
     * 更新NO安全库存
     *
     * @param suffix
     */
    void updateNOSafeStockTmp(@Param("suffix") String suffix);
}
