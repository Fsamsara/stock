package com.metersbonwe.stock.facade.schedule;

/**
 * @author sky
 * @version V1.0
 * @description 渠道可用仓，及全量同步接口
 * @date 2016/3/21
 */
public interface UsefulWarehChangeService {

    /**
     * @description 定时任务调用方法，从tmp_channel_scope里面获取数据
     */
    void processChannelUsefulWarehChange() throws Exception;

}
