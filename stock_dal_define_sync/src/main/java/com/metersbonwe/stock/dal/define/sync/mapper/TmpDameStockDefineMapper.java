package com.metersbonwe.stock.dal.define.sync.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.metersbonwe.stock.po.sync.TmpDameStock;

/**
 * @author 张洪琴
 */
@Repository public interface TmpDameStockDefineMapper {

    /**
     * @param list
     *            多条数据批量插入
     * @return
     */
    public int insertList(List<TmpDameStock> list);
}
