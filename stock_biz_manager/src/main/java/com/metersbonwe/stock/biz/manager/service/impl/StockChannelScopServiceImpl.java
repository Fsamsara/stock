package com.metersbonwe.stock.biz.manager.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.metersbonwe.stock.biz.common.service.AllocationRangeService;
import com.metersbonwe.stock.biz.manager.service.StockChannelScopService;
import com.metersbonwe.stock.po.core.StockChannelScope;
import com.mtsbw.soa.udb.common.model.AllotScopeBean;

@Service public class StockChannelScopServiceImpl implements StockChannelScopService {

    @Resource AllocationRangeService allocationRangeServiceImpl;

    @Override
    public List<StockChannelScope> selectStockChannelScope(StockChannelScope scopePo) throws Exception {
        String channelCode = scopePo == null ? null : scopePo.getChannelCode();
        String warehId = scopePo == null ? null : scopePo.getWarehId();
        List<StockChannelScope> scopes = new ArrayList<>();
        if (scopePo != null && StringUtils.isNotBlank(channelCode) && StringUtils.isNotBlank(warehId)) {
            scopePo = allocationRangeServiceImpl.getOnlineAllotScopeByChannelWarehId(channelCode, warehId);
            scopes.add(scopePo);
        } else if (scopePo != null && StringUtils.isNotBlank(channelCode) && StringUtils.isBlank(warehId)) {
            Map<StockChannelScope, List<AllotScopeBean>> scopeMap = allocationRangeServiceImpl.getAllOnlineAllotScopesForBean();
            if (MapUtils.isNotEmpty(scopeMap)) {
                for (Entry<StockChannelScope, List<AllotScopeBean>> entry : scopeMap.entrySet()) {
                    if (channelCode.equals(entry.getKey().getChannelCode())) {
                        List<AllotScopeBean> beans = entry.getValue();
                        for (AllotScopeBean allotScopeBean : beans) {
                            StockChannelScope stockChannelScope = new StockChannelScope();
                            stockChannelScope.setChannelCode(entry.getKey().getChannelCode());
                            stockChannelScope.setChannelName(entry.getKey().getChannelName());
                            stockChannelScope.setWarehId(allotScopeBean.getCode());
                            stockChannelScope.setWarehName(allotScopeBean.getName());
                            scopes.add(stockChannelScope);
                        }
                    }
                }
            }
        } else if (scopePo != null && StringUtils.isBlank(channelCode) && StringUtils.isNotBlank(warehId)) {
            Map<StockChannelScope, List<AllotScopeBean>> scopeMap = allocationRangeServiceImpl.getAllOnlineAllotScopesForBean();
            if (MapUtils.isNotEmpty(scopeMap)) {
                for (Entry<StockChannelScope, List<AllotScopeBean>> entry : scopeMap.entrySet()) {
                    List<AllotScopeBean> beans = entry.getValue();
                    for (AllotScopeBean allotScopeBean : beans) {
                        if (warehId.equals(allotScopeBean.getCode())) {
                            StockChannelScope stockChannelScope = new StockChannelScope();
                            stockChannelScope.setChannelCode(entry.getKey().getChannelCode());
                            stockChannelScope.setChannelName(entry.getKey().getChannelName());
                            stockChannelScope.setWarehId(allotScopeBean.getCode());
                            stockChannelScope.setWarehName(allotScopeBean.getName());
                            scopes.add(stockChannelScope);
                        }
                    }
                }
            }
        } else if (scopePo == null || (StringUtils.isBlank(channelCode) && StringUtils.isBlank(warehId))) {
            Map<StockChannelScope, List<AllotScopeBean>> scopeMap = allocationRangeServiceImpl.getAllOnlineAllotScopesForBean();
            if (MapUtils.isNotEmpty(scopeMap)) {
                for (Entry<StockChannelScope, List<AllotScopeBean>> entry : scopeMap.entrySet()) {
                    List<AllotScopeBean> beans = entry.getValue();
                    for (AllotScopeBean allotScopeBean : beans) {
                        StockChannelScope stockChannelScope = new StockChannelScope();
                        stockChannelScope.setChannelCode(entry.getKey().getChannelCode());
                        stockChannelScope.setChannelName(entry.getKey().getChannelName());
                        stockChannelScope.setWarehId(allotScopeBean.getCode());
                        stockChannelScope.setWarehName(allotScopeBean.getName());
                        scopes.add(stockChannelScope);
                    }
                }
            }
        }
        return scopes;
    }

}
