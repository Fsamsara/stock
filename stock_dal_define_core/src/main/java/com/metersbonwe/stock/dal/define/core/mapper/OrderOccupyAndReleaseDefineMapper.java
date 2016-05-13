package com.metersbonwe.stock.dal.define.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.metersbonwe.stock.po.core.StockChannelOrderDetail;
import com.metersbonwe.stock.po.core.define.ChannelProdBean;
import com.metersbonwe.stock.pojo.StockChannelBean;

/**
 * TODO 订单占用释放自定义SQL
 * 
 * @author zhangfeng zhangfeng13@metersbonwe.com
 * @date 2016年3月28日 上午9:28:03
 * @since V1.0
 * @version V1.0
 */
public interface OrderOccupyAndReleaseDefineMapper {

    /**
     * TODO 通过渠道商品查询渠道商品所有信息
     *
     * @param channelCode
     * @param prodId
     * @return
     * @throws Exception
     */
    ChannelProdBean selectChannelProdDetail(@Param("channelBean") StockChannelBean channelBean) throws Exception;

    /**
     * TODO 根据prodid 查询渠道信息
     *
     * @param tmpStockChannelStatuss
     * @return
     */
    public List<ChannelProdBean> selectChannelProdDetails(@Param("prodIds") List<String> prodIds, @Param("channel") String channel);

    /**
     * TODO 订单占用时更新渠道商品子表的预占总量（数据库UPDATE方式）
     *
     * @param channelBean
     * @return
     */
    int updateChannelSubDetailForOccupy(@Param("channelBean") StockChannelBean channelBean);

    /**
     * TODO 订单释放时更新渠道商品子表的预占总量（数据库UPDATE方式）
     *
     * @param channelBean
     * @return
     */
    int updateChannelSubDetailForRelease(@Param("channelBean") StockChannelBean channelBean);

    /**
     * TODO 订单释放时更新渠道商品子表的预占总量（覆盖方式）
     *
     * @param channelBean
     * @return
     */
    int updateChannelSubDetailForReleaseOverWrite(@Param("channelBean") StockChannelBean channelBean);

    /**
     * TODO 订单占用时更新渠道商品子表的预占总量（数据库UPDATE方式） 批量
     *
     * @param channelBean
     * @return
     */
    int updateChannelSubDetails(List<StockChannelBean> channelBeans);

    /**
     * TODO 查询符合条件的子单号
     * 
     * @param channelBeans
     * @return
     */
    List<String> selectReleaseChannelSubOrderIds();

    /**
     * TODO 查询符合释放的商品编码
     * 
     * @param channelBeans
     * @return
     */
    List<String> selectReleaseProdIds();

    /**
     * TODO 查询符合释放的商品编码
     * 
     * @param channelBean
     * @return
     */
    List<String> selectReleaseProdIdsByChannelBean(@Param("channelBean") StockChannelBean channelBean);

    /**
     * TODO 根据渠道和商品查询订单信息
     *
     * @param channelCode
     * @param prodId
     * @return
     */
    StockChannelOrderDetail selectReleaseProdStocks(@Param("channelCode") String channelCode, @Param("prodId") String prodId);

    /**
     * TODO 订单释放时根据子单号 查询出子单号下面 所有渠道和商品的独占和共享库存 需要 GROUP BY SUM
     * 
     * @param channelBeans
     * @return
     */
    List<StockChannelOrderDetail> selectReleaseChannelSubDetails();

    /**
     * TODO 从预占明细表插入到实在明细表 insert into select。。。
     *
     * @param stockChannelBean
     */
    void insertToOrderHis(@Param("channelBean") StockChannelBean stockChannelBean);

    /**
     * TODO 从预占明细表插入到实在明细表 insert into select。。。
     *
     * @param stockChannelBean
     */
    void insertToOrderHisByCodeAndProdId(@Param("channelBean") StockChannelBean stockChannelBean);

    /**
     * TODO 释放时更新延迟释放标识
     *
     * @param stockChannelBean
     * @return
     */
    int updateReleaseChannelSubDetail(@Param("channelBean") StockChannelBean stockChannelBean);

    /**
     * 更新订单预占明细表里面预售预占信息为 实物预占信息 并将延迟释放标识标志为 1 下次释放定时任务自动释放库存。
     *
     * @param channelCode
     * @param prodId
     */
    void updateOrderDetailForPreOrder(@Param("channelCode") String channelCode, @Param("prodId") String prodId);

}
