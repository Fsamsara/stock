package com.metersbonwe.stock.biz.log.interceptor;

import javax.annotation.Resource;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Service;

import com.metersbonwe.stock.biz.log.StockLogPointcut;
import com.metersbonwe.stock.biz.log.StockMethodArgsLogPerform;
import com.metersbonwe.stock.biz.log.bean.PointcutBean;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;

@Service public class StockMethodArgsLogInterceptor implements MethodArgsLogInterceptor {

    @Resource private StockLogPointcut          stockLogPointcut;

    @Resource private StockMethodArgsLogPerform stockMethodArgsLogPerform;

    StockLog log = StockLogFactory.getLogger(StockMethodArgsLogInterceptor.class);
    
    @Override
    public void doBefore(JoinPoint jp) {
        log.debug("doBefore");
        Class<?> clazz = jp.getTarget().getClass();
        String methodName = jp.getSignature().getName();
        PointcutBean point = new PointcutBean(clazz, methodName, jp.getArgs());
        if (!stockLogPointcut.isPointcut(point)) {
            return;
        }
        stockMethodArgsLogPerform.perform(point, jp.getArgs());
    }
}
