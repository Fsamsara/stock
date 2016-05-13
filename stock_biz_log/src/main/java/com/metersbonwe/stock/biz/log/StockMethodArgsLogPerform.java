package com.metersbonwe.stock.biz.log;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.metersbonwe.stock.biz.log.bean.MethodArgsLogs;
import com.metersbonwe.stock.biz.log.bean.PointcutBean;
import com.metersbonwe.stock.biz.log.resolver.ArgsResolver;
import com.metersbonwe.stock.biz.log.resolver.ArgsResolverFactory;

@Service public class StockMethodArgsLogPerform {

    @Resource ArgsResolverFactory argsResolverFactory;

    @Resource StockLogPersistence tockLogPersistence;

    public void perform(PointcutBean pointcutBean, Object[] objects) {
        ArgsResolver resolver = argsResolverFactory.getArgsResolver(pointcutBean, 0);
        List<MethodArgsLogs> logs = resolver.resolver(pointcutBean, objects[0]);
        System.out.println(logs);
        for (int i = 0; i < logs.size(); i++) {
            tockLogPersistence.saveLog(logs.get(i));
        }
    }

}
