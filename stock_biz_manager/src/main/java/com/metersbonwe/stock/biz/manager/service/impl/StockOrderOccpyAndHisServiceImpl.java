package com.metersbonwe.stock.biz.manager.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.metersbonwe.stock.biz.manager.service.StockOrderOccpyAndHisService;
import com.metersbonwe.stock.dal.auto.core.mapper.StockChannelOrderDetailHisMapper;
import com.metersbonwe.stock.dal.auto.core.mapper.StockChannelOrderDetailMapper;
import com.metersbonwe.stock.po.core.StockChannelOrderDetail;
import com.metersbonwe.stock.po.core.StockChannelOrderDetailExample;
import com.metersbonwe.stock.po.core.StockChannelOrderDetailHis;
import com.metersbonwe.stock.po.core.StockChannelOrderDetailHisExample;

@Service public class StockOrderOccpyAndHisServiceImpl implements StockOrderOccpyAndHisService {

    @Resource StockChannelOrderDetailMapper    stockChannelOrderDetailMapper;

    @Resource StockChannelOrderDetailHisMapper stockChannelOrderDetailHisMapper;

    @Override
    public List<StockChannelOrderDetail> selectOrderOccupy(StockChannelOrderDetail detail) {
        StockChannelOrderDetailExample example = new StockChannelOrderDetailExample();
        StockChannelOrderDetailExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(detail.getChannelCode())) {
            criteria.andChannelCodeEqualTo(detail.getChannelCode());
        }
        if (StringUtils.isNotBlank(detail.getProdId())) {
            criteria.andProdIdEqualTo(detail.getProdId());
        }
        if (StringUtils.isNotBlank(detail.getBusinessId())) {
            criteria.andBusinessIdEqualTo(detail.getBusinessId());
        }
        if (StringUtils.isNotBlank(detail.getSubOrderId())) {
            criteria.andSubOrderIdEqualTo(detail.getSubOrderId());
        }
        if (StringUtils.isNotBlank(detail.getOsOrderId())) {
            criteria.andOsOrderIdEqualTo(detail.getOsOrderId());
        }
        if (StringUtils.isNotBlank(detail.getRelationChannel())) {
            criteria.andRelationChannelEqualTo(detail.getRelationChannel());
        }
        return stockChannelOrderDetailMapper.selectByExample(example);

    }

    @Override
    public List<StockChannelOrderDetailHis> selectOrderOccupyHis(StockChannelOrderDetailHis detail) {
        StockChannelOrderDetailHisExample example = new StockChannelOrderDetailHisExample();
        StockChannelOrderDetailHisExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(detail.getChannelCode())) {
            criteria.andChannelCodeEqualTo(detail.getChannelCode());
        }
        if (StringUtils.isNotBlank(detail.getProdId())) {
            criteria.andProdIdEqualTo(detail.getProdId());
        }
        if (StringUtils.isNotBlank(detail.getBusinessId())) {
            criteria.andBusinessIdEqualTo(detail.getBusinessId());
        }
        if (StringUtils.isNotBlank(detail.getSubOrderId())) {
            criteria.andSubOrderIdEqualTo(detail.getSubOrderId());
        }
        if (StringUtils.isNotBlank(detail.getOsOrderId())) {
            criteria.andOsOrderIdEqualTo(detail.getOsOrderId());
        }
        if (StringUtils.isNotBlank(detail.getRelationChannel())) {
            criteria.andRelationChannelEqualTo(detail.getRelationChannel());
        }
        return stockChannelOrderDetailHisMapper.selectByExample(example);
    }

}
