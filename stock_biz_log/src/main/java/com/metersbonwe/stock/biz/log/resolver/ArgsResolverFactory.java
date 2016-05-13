package com.metersbonwe.stock.biz.log.resolver;

import javax.annotation.Resource;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.metersbonwe.stock.biz.log.LogSystemConfig;
import com.metersbonwe.stock.biz.log.bean.PointcutBean;

@Service public class ArgsResolverFactory implements ApplicationContextAware {

    @Resource LogSystemConfig  config;

    private ApplicationContext applicationContext;

    public ArgsResolver getArgsResolver(PointcutBean pointcutBean, int argsIdx) {
        String beanId = config.getResolver(pointcutBean, argsIdx);
        return applicationContext.getBean(beanId, ArgsResolver.class);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

}
