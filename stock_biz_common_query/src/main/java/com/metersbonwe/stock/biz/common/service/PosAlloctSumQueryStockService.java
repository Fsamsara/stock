package com.metersbonwe.stock.biz.common.service;


import java.util.List;

import com.metersbonwe.stock.pojo.QueryStockAllParamBean;
import com.metersbonwe.stock.pojo.QueryStockResultBean;

public interface PosAlloctSumQueryStockService {

    /**
     * 
     * TODO 查询库存
     * TODO POS全流通、分配（手工分单）、全流通（总查询）共用方法
     * @param bean
     * @return
     */
    List<QueryStockResultBean> queryStock(QueryStockAllParamBean paramBean);
    
}
