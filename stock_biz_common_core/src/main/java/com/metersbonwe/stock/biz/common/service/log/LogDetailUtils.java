package com.metersbonwe.stock.biz.common.service.log;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.metersbonwe.stock.dal.auto.core.mapper.LogStockDetailMapper;
import com.metersbonwe.stock.po.core.LogStockDetail;

/**
 * TODO 日志操作
 * 
 * @author zhangfeng zhangfeng13@metersbonwe.com
 * @date 2016年4月7日 上午9:27:16
 * @since V1.0
 * @version V1.0
 */
@Service public class LogDetailUtils {

    @Resource LogStockDetailMapper logStockDetailMapper;

    ExecutorService                service = Executors.newFixedThreadPool(10);

    // 默认用10个固定线程异步写入日志 
    public void insertLogDetail(final LogStockDetail logStockDetail) {
        service.execute(new Runnable() {
            @Override
            public void run() {
                logStockDetailMapper.insert(logStockDetail);
            }
        });
    }
}
