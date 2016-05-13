package com.metersbonwe.stock.biz.log;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import com.metersbonwe.stock.biz.log.bean.MethodArgsLogs;
import com.metersbonwe.stock.dal.auto.core.mapper.StockBizLogDetailsMapper;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockBizLogDetails;

@Service public class StockLogPersistence {
    @Resource StockBizLogDetailsMapper stockBizLogDetailsMapper;

    StockLog                           log = StockLogFactory.getLogger(StockLogPersistence.class);

    public void saveLog(MethodArgsLogs logsBean) {
        StockBizLogDetails stockBizLogDetails = new StockBizLogDetails();
        try {
            BeanUtils.copyProperties(stockBizLogDetails, logsBean);
            log.debug(logsBean.toString());
            stockBizLogDetailsMapper.insertSelective(stockBizLogDetails);
        } catch (Exception e) {
        }
    }

}
