package com.metersbonwe.stock.biz.log;

import java.util.List;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.metersbonwe.stock.biz.log.bean.PointcutBean;

@Service public class StockLogPointcut {

    private List<PointcutBean> pointcuts = Lists.newArrayList();

    public boolean isPointcut(PointcutBean point) {
        boolean flag = pointcuts.contains(point);
        if (!flag) {
            LogService logservice = point.getLogService();
            return logservice != null;
        }
        return flag;
    }

}
