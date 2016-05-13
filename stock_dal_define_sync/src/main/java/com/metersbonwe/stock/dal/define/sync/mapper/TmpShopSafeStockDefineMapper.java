package com.metersbonwe.stock.dal.define.sync.mapper;

import com.metersbonwe.stock.po.sync.TmpShopSafeStock;
import com.metersbonwe.stock.pojo.TmpShopSafeGlobalBean;

import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * @author 张洪琴
 */
@Repository public interface TmpShopSafeStockDefineMapper {

    /**
     * @param list
     *            批量插入数据库
     * @return
     */
    public int insertList(List<TmpShopSafeStock> list);

    /**
     * 获取门店安全库存,去重
     * 
     * @return
     */
    List<TmpShopSafeStock> selectAllDeleteRepeat(TmpShopSafeGlobalBean tmpShopSafeGlobalBean);
}
