package com.metersbonwe.stock.dal.define.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.metersbonwe.stock.pojo.StockChannelBean;

/**
 * TODO 库存查询服务
 * 
 * @author zhangfeng zhangfeng13@metersbonwe.com
 * @date 2016年4月5日 上午9:31:43
 * @since V1.0
 * @version V1.0
 */
public interface StockShopOnlineDefineMapper {

    /**
     * TODO 全流通库存查询（供方）
     * 
     * @param seqs
     * @param scope
     * @return
     */
    List<StockChannelBean> selectShopOnlineStock(@Param("shopIds") List<String> shopIds, @Param("prodIds") List<String> prodIds,
            @Param("seqs") List<String> seqs);
}
