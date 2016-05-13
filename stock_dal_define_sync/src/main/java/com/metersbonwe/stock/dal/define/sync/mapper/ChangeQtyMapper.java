package com.metersbonwe.stock.dal.define.sync.mapper;

import java.util.List;

import com.metersbonwe.stock.pojo.ChangeQtyGlobalBean;
import com.metersbonwe.stock.pojo.ChangeQtyInfoBean;

/**
 * 库存变化调度服务 Mapper
 * @author TanYibin
 */
public interface ChangeQtyMapper {

    /**
     * 获取Oracle同步库临时表 自由量 变化信息
     * @param changeQtyGlobalBean
     * @return
     */
    public List<ChangeQtyInfoBean> selectTmpFreeQtyInfo(ChangeQtyGlobalBean changeQtyGlobalBean);
    
    /**
     * 获取Oracle同步库临时表 锁定量 变化信息
     * @param changeQtyGlobalBean
     * @return
     */
    public List<ChangeQtyInfoBean> selectTmpLockedQtyInfo(ChangeQtyGlobalBean changeQtyGlobalBean);
    
    
    /**
     * 获取Oracle同步库临时表 预留量 变化信息
     * @param changeQtyGlobalBean
     * @return
     */
    public List<ChangeQtyInfoBean> selectTmpReservedQtyInfo(ChangeQtyGlobalBean changeQtyGlobalBean);

    /**
     * 删除Oracle同步库临时表 自由量 变化信息
     * @param changeQtyInfoBean
     */
    public int deleteTmpFreeQtyInfo(ChangeQtyInfoBean changeQtyInfoBean);

    /**
     * 删除Oracle同步库临时表 锁定量 变化信息
     * @param changeQtyInfoBean
     */
    public int deleteTmpLockedQtyInfo(ChangeQtyInfoBean changeQtyInfoBean);

    /**
     * 删除Oracle同步库临时表 预留量 变化信息
     * @param changeQtyInfoBean
     */
    public int deleteTmpReservedQtyInfo(ChangeQtyInfoBean changeQtyInfoBean);

    /**
     * 获取Oracle同步库临时表 第三方自由量 变化信息
     * @param changeQtyGlobalBean
     * @return
     */
    public List<ChangeQtyInfoBean> selectTmpTpQtyInfo(ChangeQtyGlobalBean changeQtyGlobalBean);

    /**
     * 删除Oracle同步库临时表 第三方自由量 变化信息
     * @param changeQtyInfoBean
     */
    public int deleteTmpTpQtyInfo(ChangeQtyInfoBean changeQtyInfoBean);

    /**
     * 获取Oracle同步库临时表 门店未日结量 变化信息
     * @param changeQtyGlobalBean
     * @return
     */
    public List<ChangeQtyInfoBean> selectTmpRemailQtyInfo(ChangeQtyGlobalBean changeQtyGlobalBean);

    /**
     * 删除Oracle同步库临时表 门店未日结量 变化信息
     * @param changeQtyInfoBean
     */
    public int deleteTmpRemailQtyInfo(ChangeQtyInfoBean changeQtyInfoBean);

    /**
     * 获取Oracle同步库临时表 门店无损值 变化信息
     * @param changeQtyGlobalBean
     * @return
     */
    public List<ChangeQtyInfoBean> selectTmpDameQtyInfo(ChangeQtyGlobalBean changeQtyGlobalBean);

    /**
     * 删除Oracle同步库临时表 门店无损值 变化信息
     * @param changeQtyInfoBean
     */
    public int deleteTmpDameQtyInfo(ChangeQtyInfoBean changeQtyInfoBean);

    /**
     * 获取Oracle同步库临时表 门店安全库存 变化信息
     * @param changeQtyGlobalBean
     * @return
     */
    public List<ChangeQtyInfoBean> selectTmpShopSafeQtyInfo(ChangeQtyGlobalBean changeQtyGlobalBean);

    /**
     * 删除Oracle同步库临时表 门店安全库存 变化信息
     * @param changeQtyInfoBean
     */
    public int deleteTmpShopSafeQtyInfo(ChangeQtyInfoBean changeQtyInfoBean);

    /**
     * 获取Oracle同步库渠活动期间道商品配置 变化信息
     * @param changeQtyGlobalBean
     * @return
     */
    public List<ChangeQtyInfoBean> selectTmpChannelPordInfo(ChangeQtyGlobalBean changeQtyGlobalBean);

    /**
     * 删除Oracle同步库临时表 活动期间渠道商品推送独占量 变化信息
     * @param changeQtyInfoBean
     */
    public int deleteTmpChannelPordInfo(ChangeQtyInfoBean changeQtyInfoBean);

}
