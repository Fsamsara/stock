package com.metersbonwe.stock.biz.schedule.thread;

import java.util.List;

import org.springframework.util.StringUtils;

import com.metersbonwe.stock.biz.schedule.service.ChangeQtyHandleSerivce;
import com.metersbonwe.stock.configuration.ThreadConfig;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.pojo.ChangeQtyInfoBean;
import com.metersbonwe.stock.pojo.sync.PageIndexBean;

/**
 * 库存变化调度服务 Runnable
 * 
 * @author TanYibin
 */
public class ChangeQtyConsumerRunnable implements Runnable {

    private static StockLog         stockLog = StockLogFactory.getLogger(ChangeQtyConsumerRunnable.class);

    private ChangeQtyHandleSerivce  changeQtyHandleSerivce;

    private List<ChangeQtyInfoBean> changeQtyInfos;

    private PageIndexBean           pageIndexBean;

    private Integer                 changeType;

    private ThreadConfig            threadConfig;

    @Override
    public void run() {
        Long time1 = System.currentTimeMillis();
        
        int operatCount = 0;

        try {
            if (changeQtyInfos == null || changeQtyInfos.isEmpty()) {
                return;
            }
            for (int i = pageIndexBean.getBegin(); i < pageIndexBean.getEnd(); i++, operatCount++) {
                ChangeQtyInfoBean changeQtyInfoBean = changeQtyInfos.get(i);
                try {
                    if (!StringUtils.isEmpty(changeQtyInfoBean.getWarehId()) && !StringUtils.isEmpty(changeQtyInfoBean.getProdId())) {
                        //1.更新MySql核心库STOCK_WAREH_PORD表变化量及最终自由量
                        Integer count = changeQtyHandleSerivce.updateChangeQtyInfo(changeQtyInfoBean, changeType);

                        if (count == 1) {
                            //2.发送变化信息到MQ
                            changeQtyHandleSerivce.sendChangeQtyInfoToMQ(changeQtyInfoBean, changeType);
                        }
                    }
                    //3.删除Oracle同步库临时表变化信息
                    if (i == (pageIndexBean.getEnd() - 1)) {
                        stockLog.info("库存变化调度服务，删除ID小于等于" + changeQtyInfoBean.getId() + "的数据 ChangeType：" + changeType);
                        changeQtyHandleSerivce.deleteChangeQtyInfo(changeQtyInfoBean, changeType);
                    }
                } catch (Exception e) {
                    stockLog.error("库存变化调度服务 线程处理异常，ChangeQtyInfoBean.ID:" + changeQtyInfoBean.getId(), e);
                }
            }
        } finally {
            threadConfig.threadDown();
            Long time2 = System.currentTimeMillis();
            stockLog.info("处理同步库临时表变化信息集合" + operatCount + "条，耗时：" + (time2 - time1) + "ms，ChangeType：" + changeType);
        }
    }

    public ChangeQtyHandleSerivce getchangeQtyHandleSerivce() {
        return changeQtyHandleSerivce;
    }

    public void setchangeQtyHandleSerivce(ChangeQtyHandleSerivce changeQtyHandleSerivce) {
        this.changeQtyHandleSerivce = changeQtyHandleSerivce;
    }

    public Integer getChangeType() {
        return changeType;
    }

    public void setChangeType(Integer changeType) {
        this.changeType = changeType;
    }

    public List<ChangeQtyInfoBean> getChangeQtyInfos() {
        return changeQtyInfos;
    }

    public void setChangeQtyInfos(List<ChangeQtyInfoBean> changeQtyInfos) {
        this.changeQtyInfos = changeQtyInfos;
    }

    public PageIndexBean getPageIndexBean() {
        return pageIndexBean;
    }

    public void setPageIndexBean(PageIndexBean pageIndexBean) {
        this.pageIndexBean = pageIndexBean;
    }

    public ThreadConfig getThreadConfig() {
        return threadConfig;
    }

    public void setThreadConfig(ThreadConfig threadConfig) {
        this.threadConfig = threadConfig;
    }

}
