package com.metersbonwe.stock.biz.log.interceptor;

import org.aspectj.lang.JoinPoint;

/**
 * 方法参数日志记录
 * 
 * @author zhangruiyu zhangry@metersbonwe.com
 * @date 2016年5月11日 上午10:37:57
 * @since V1.0
 * @version V1.0
 */
public interface MethodArgsLogInterceptor {

    void doBefore(JoinPoint jp);

}
