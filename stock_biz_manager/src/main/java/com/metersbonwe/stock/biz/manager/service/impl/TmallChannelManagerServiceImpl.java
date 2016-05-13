package com.metersbonwe.stock.biz.manager.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.metersbonwe.stock.biz.manager.service.TmallChannelManagerService;
import com.metersbonwe.stock.dal.auto.core.mapper.StockChannelIncrementSubMapper;
import com.metersbonwe.stock.dal.define.core.mapper.TmallChannelManagerDefineMapper;
import com.metersbonwe.stock.po.core.StockChannelIncrement;
import com.metersbonwe.stock.po.core.StockChannelIncrementSub;
import com.metersbonwe.stock.po.core.StockChannelIncrementSubExample;
import com.metersbonwe.stock.pojo.TmallChannelManagerQueryBean;
import com.metersbonwe.stock.pojo.TmallChannelManagerSubQueryBean;

@Service
public class TmallChannelManagerServiceImpl implements TmallChannelManagerService {
    
    @Autowired private TmallChannelManagerDefineMapper tmallChannelManagerDefineMapper;
    
    @Autowired private StockChannelIncrementSubMapper stockChannelIncrementSubMapper;

    @Override
    public List<StockChannelIncrement> selectTmallChannelManagerInfos(Map<String, List<String>> paramListMap) {
        
        TmallChannelManagerQueryBean queryBean = new TmallChannelManagerQueryBean();
        queryBean.setIncrementIds(paramListMap.get("incrementId"));
        queryBean.setIncrementNames(paramListMap.get("incrementName"));
        queryBean.setChannelCodes(paramListMap.get("channelCode"));
        queryBean.setiStatus(paramListMap.get("iStatus"));
        queryBean.setCreateTimes(paramListMap.get("createTime"));
        return tmallChannelManagerDefineMapper.selectTmallChannelManagerInfos(queryBean);
    }

    @Override
    public List<StockChannelIncrementSub> selectTmallChannelManagerDetailInfos(Map<String, String> paramMap) {
        TmallChannelManagerSubQueryBean subQueryBean = new TmallChannelManagerSubQueryBean();
        subQueryBean.setReletionId(paramMap.get("reletionId"));
        return tmallChannelManagerDefineMapper.selectTmallChannelManagerDetailInfos(subQueryBean);
    }

    @Override
    public List<StockChannelIncrementSub> isExistTmallChannelManagerDetailInfo(Map<String, String> paramMap) {
        TmallChannelManagerSubQueryBean subQueryBean = new TmallChannelManagerSubQueryBean();
        subQueryBean.setReletionId(paramMap.get("reletionId"));
        subQueryBean.setProdId(paramMap.get("prodId"));
        return tmallChannelManagerDefineMapper.selectTmallChannelManagerDetailInfos(subQueryBean);
    }

    @Override
    public Integer addTmallChannelManagerDetailInfo(Map<String, String> paramMap) {
        StockChannelIncrementSub sub = new StockChannelIncrementSub();
        //Integer.parseInt(Long.toString(System.currentTimeMillis()).substring(2))
        if(!StringUtils.isEmpty(paramMap.get("serialId"))){
            sub.setId(Integer.parseInt(paramMap.get("serialId")));
        }
        sub.setReletionId(Long.parseLong(paramMap.get("reletionId")));
        sub.setProdId(paramMap.get("prodId"));
        sub.setStock(paramMap.get("stock"));
        sub.setExeStatus("0");
        sub.setNote(paramMap.get("note"));
        StockChannelIncrementSubExample example = new StockChannelIncrementSubExample();
        example.createCriteria().andReletionIdEqualTo(Long.parseLong(paramMap.get("reletionId"))).andProdIdEqualTo(paramMap.get("prodId"));
        int count = stockChannelIncrementSubMapper.updateByExample(sub, example);
        if(count <= 0) {
            count = stockChannelIncrementSubMapper.insert(sub);
        }
        return count;
    }
}
