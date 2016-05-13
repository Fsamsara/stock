package com.metersbonwe.stock.biz.schedule.service;

import java.util.List;

import com.metersbonwe.stock.pojo.ChangeQtyGlobalBean;
import com.metersbonwe.stock.pojo.ChangeQtyInfoBean;

/**
 * 库存变化调度服务 DataService
 * @author TanYibin
 *
 */
public interface ChangeQtyHandleSerivce {

    /**
     * 获取Oracle同步库临时表变化信息集合List
     * @param changeQtyGlobalBean
     * @return
     * @throws Exception
     */
    public List<ChangeQtyInfoBean> selectChangeQtyInfos(ChangeQtyGlobalBean changeQtyGlobalBean) throws Exception;
    
    /**
     * 更新MySql核心库STOCK_WAREH_PORD表变化量及最终自由量
     * @param changeQtyGlobalBean
     * @return
     * @throws Exception
     */
    public Integer updateChangeQtyInfo(ChangeQtyInfoBean changeQtyInfoBean, Integer changeType) throws Exception;

    /**
     * 发送变化信息到MQ
     * @param changeQtyInfoBean
     * @throws Exception
     */
    public void sendChangeQtyInfoToMQ(ChangeQtyInfoBean changeQtyInfoBean, Integer changeType) throws Exception;

    /**
     * 删除Oracle同步库临时表变化信息
     * @param changeQtyInfoBean
     * @param changeType
     * @throws Exception
     */
    public void deleteChangeQtyInfo(ChangeQtyInfoBean changeQtyInfoBean, Integer changeType) throws Exception;

}
