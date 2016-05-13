package com.metersbonwe.stock.biz.log.resolver;

import java.util.List;

import com.metersbonwe.stock.biz.log.bean.MethodArgsLogs;
import com.metersbonwe.stock.biz.log.bean.PointcutBean;

public interface ArgsResolver {
    List<MethodArgsLogs> resolver(PointcutBean pointcutBean, Object obj);
}
