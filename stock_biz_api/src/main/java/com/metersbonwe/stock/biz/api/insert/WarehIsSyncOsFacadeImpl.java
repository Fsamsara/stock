package com.metersbonwe.stock.biz.api.insert;

import com.google.common.collect.Lists;
import com.metersbonwe.stock.biz.common.service.AllocationRangeService;
import com.metersbonwe.stock.biz.common.service.CacheService;
import com.metersbonwe.stock.biz.log.LogService;
import com.metersbonwe.stock.dal.auto.sync.mapper.TmpChannelScopeMapper;
import com.metersbonwe.stock.dal.define.sync.mapper.TmpChannelScopeDefineMapper;
import com.metersbonwe.stock.facade.api.WarehIsSyncOsFacade;
import com.metersbonwe.stock.facade.api.bean.ChannelScope;
import com.metersbonwe.stock.facade.api.bean.Message;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.sync.TmpChannelScope;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author 张洪琴 仓是否同步os变化接口实现类
 */
@Service public class WarehIsSyncOsFacadeImpl implements WarehIsSyncOsFacade {

    @Resource TmpChannelScopeMapper       tmpChannelScopeMapper;                                              // 同步库的TMP_CHANNEL_SCOPE表的mapper

    @Resource TmpChannelScopeDefineMapper tmpChannelScopeDefineMapper;

    @Resource AllocationRangeService      allocationRangeServiceImpl;

    @Resource CacheService cacheServiceImpl;

    private static StockLog               stockLog = StockLogFactory.getLogger(WarehIsSyncOsFacadeImpl.class);

    /**
     * 单条数据的有效性检查：如果数据有效，则进行封装
     * 
     * @param channelScope
     * @return
     */
    private Map<String, Object> checkParam(ChannelScope channelScope) {
        Map<String, Object> msg = new HashMap<String, Object>();
        if (channelScope == null || StringUtils.isEmpty(channelScope.getWarehId()) || StringUtils.isEmpty(channelScope.getWarehState())) {
            msg.put("tag", false);
        } else {
            // 申明封装的类：stock_po子项目中的po.sync.TmpChannelScope
            TmpChannelScope tcs = new TmpChannelScope();
            // 将stock_facade子项目中的oracle.po.TmpChannelScope重新封装成stock_po子项目中的po.sync.TmpChannelScope
            BeanUtils.copyProperties(channelScope, tcs);
            if (tcs.getUpdateTime() == null) {
                tcs.setUpdateTime(new Date());
            }
            msg.put("tag", true);
            msg.put("tmpChannelScope", tcs);
        }
        return msg;
    }

    /**
     * 多条数据的有效性检查：如果数据有效，则进行封装
     * 
     * @param channelScopeList
     * @return
     */
    private Map<String, Object> checkParamList(List<ChannelScope> channelScopeList) {
        Map<String, Object> msg = new HashMap<String, Object>();
        List<TmpChannelScope> validParamList = new ArrayList<TmpChannelScope>();
        List<ChannelScope> invalidParamList = new ArrayList<ChannelScope>();

        //
        if (channelScopeList == null || channelScopeList.size() == 0) {
            msg.put("tag", false);
            return msg;
        }
        stockLog.debug("传入的参数数据量：" + channelScopeList.size());

        for (ChannelScope channelScope : channelScopeList) {
            Map<String, Object> map = checkParam(channelScope);
            if (!(boolean) map.get("tag")) {
                invalidParamList.add(channelScope);
            }
            TmpChannelScope tmp = (TmpChannelScope) map.get("tmpChannelScope");
            if (tmp != null) {
                validParamList.add(tmp);
            }
        }

        msg.put("validParamList", validParamList);
        msg.put("invalidParamList", invalidParamList);
        stockLog.debug("有效参数数据量：" + validParamList.size());
        stockLog.debug("无效参数数据量：" + invalidParamList.size());
        return msg;
    }

    @Override @LogService("仓是否同步os变化接口")
    public Message warehIsSynchronousOs(ChannelScope channelScope) {
        stockLog.debug("仓是否同步os变化接口warehIsSynchronousOs-->开始");
        stockLog.debug("warehIsSynchronousOs传入的参数为:" + channelScope);

        try {
            Map<String, Object> map = checkParam(channelScope);
            if (!(boolean) map.get("tag")) {
                stockLog.error("warehIsSynchronousOs传入的参数无效：" + channelScope);
                return new Message(false, "传入的参数无效：" + channelScope);
            }
            List<String> channels = cacheServiceImpl.getAllUsefulChannelForCache();
            if (CollectionUtils.isEmpty(channels)) {
                return new Message(false, "系统可用渠道为空");
            }
            TmpChannelScope scope = (TmpChannelScope) map.get("tmpChannelScope");
            for (int i = 0; i < channels.size(); i++) {
                try {
                    TmpChannelScope tmpScope = new TmpChannelScope();
                    BeanUtils.copyProperties( scope,tmpScope);
                    tmpScope.setScopeChange("0");
                    tmpScope.setChannelCode(channels.get(i));
                    this.tmpChannelScopeMapper.insertSelective(tmpScope);
                } catch (Exception e) {
                    stockLog.error(e.getMessage(), e);
                }
            }
            // 返回插入的结果：插入成功为true,插入失败为false
            return new Message(true, null);

        } catch (BeansException e) {
            stockLog.debug("warehIsSynchronousOs报异常", e);
            return new Message(false, " 数据插入数据库时出现异常-->" + e.getMessage());
        } finally {
            stockLog.debug("仓是否同步os变化接口warehIsSynchronousOs-->结束");
        }
    }

    @SuppressWarnings("unchecked") @Override @LogService("仓是否同步os变化接口")
    public Message warehIsSynchronousOsList(List<ChannelScope> channelScopeList) {
        stockLog.debug("仓是否同步os变化接口warehIsSynchronousOs（多条数据传入）-->开始");
        stockLog.debug("warehIsSynchronousOs传入的参数是：" + channelScopeList);
        Map<String, Object> msg = null;
        try {
            msg = checkParamList(channelScopeList);
            stockLog.debug("传入的无效参数列表：" + msg.get("invalidParamList"));
            stockLog.debug("传入的有效参数封装后的列表：" + msg.get("validParamList"));

            List<TmpChannelScope> tmpList = (List<TmpChannelScope>) msg.get("validParamList");
            if (tmpList.size() == 0) {
                stockLog.error("传入的无效参数列表：" + msg.get("invalidParamList"));
                return new Message(false, "传入的无效参数列表：" + msg.get("invalidParamList"));
            }

            List<String> channels = cacheServiceImpl.getAllUsefulChannelForCache();
            if (CollectionUtils.isEmpty(channels)) {
                return new Message(false, "系统可用渠道为空");
            }
            List<TmpChannelScope> insertList = Lists.newArrayList();
            for (int i = 0; i < channels.size(); i++) {
                for (int j = 0; j < tmpList.size(); j++) {
                    try {
                        TmpChannelScope scope = tmpList.get(j);
                        TmpChannelScope tmpScope = new TmpChannelScope();
                        BeanUtils.copyProperties( scope,tmpScope);
                        tmpScope.setScopeChange("0");
                        tmpScope.setChannelCode(channels.get(i));
                        insertList.add(tmpScope);
                    } catch (Exception e) {
                        stockLog.error(e.getMessage(), e);
                    }
                }
            }
            stockLog.debug("需要插入到临时表的数据量：" + tmpList.size());
            int tag = tmpChannelScopeDefineMapper.insertList(insertList);
            stockLog.debug("插入到临时表的数据量：" + tag);
            return new Message(tag != 0, "传入的无效参数列表：" + msg.get("invalidParamList"));
        } catch (BeansException e) {
            stockLog.error("warehIsSynchronousOs方法中出现异常：" + e.getMessage(), e);
            return new Message(false, " 数据插入数据库时出现异常！" + "-->" + e.getMessage() + ",传入的无效参数列表：" + msg.get("invalidParamList"));
        } finally {
            stockLog.debug("仓是否同步os变化接口warehIsSynchronousOs（多条数据传入）-->结束");
        }
    }

}
