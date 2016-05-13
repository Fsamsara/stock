package com.metersbonwe.stock.biz.api.insert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.metersbonwe.stock.biz.common.service.AllocationRangeService;
import com.metersbonwe.stock.biz.log.LogService;
import com.metersbonwe.stock.dal.auto.sync.mapper.StActivityWarehMapper;
import com.metersbonwe.stock.dal.define.sync.mapper.TmpChannelScopeDefineMapper;
import com.metersbonwe.stock.facade.api.ShopMainSwitchFacade;
import com.metersbonwe.stock.facade.api.bean.Message;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.sync.StActivityWareh;
import com.metersbonwe.stock.po.sync.StActivityWarehExample;
import com.metersbonwe.stock.po.sync.TmpChannelScope;

/**
 * @author 张洪琴 门店总开关变化写入接口实现类
 */
@Service public class ShopMainSwitchFacadeImpl implements ShopMainSwitchFacade {

    @Resource TmpChannelScopeDefineMapper tmpChannelScopeDefineMapper;                                         // 同步库的TMP_CHANNEL_SCOPE表的mapper

    @Resource StActivityWarehMapper       stActivityWarehMapper;

    @Resource AllocationRangeService      allocationRangeServiceImpl;

    private static StockLog               stockLog = StockLogFactory.getLogger(ShopMainSwitchFacadeImpl.class);

    @Override @LogService("门店总开关变化写入接口")
    public Message shopMainSwitch(String warehState) {
        stockLog.debug("门店总开关变化写入接口storeMainSwitch-->开始");
        stockLog.debug("storeMainSwitch传入的参数是：" + warehState);

        try {

            if (StringUtils.isEmpty(warehState)) {
                stockLog.error("传入的参数无效" + warehState);
                return new Message(false, "传入的参数无效" + warehState);
            }

            // 1.OMS中心获取渠道列表
            List<String> channelCodeList = allocationRangeServiceImpl.getAllUsefulChannel();
            stockLog.debug("storeMainSwitch从OMS中心获取渠道列表是：" + channelCodeList);
            // 2.获取所有门店
            List<StActivityWareh> shopList = getShopList();
            stockLog.debug("storeMainSwitch中获取所有门店：" + channelCodeList);
            if (shopList == null || shopList.isEmpty()) {
                return new Message(true, "");
            }
            // 3.封装渠道和所有门店的笛卡尔积的数据到 TMP_CHANNEL_SCOPE临时表 对应的javabean：
            List<TmpChannelScope> tmpList = new ArrayList<TmpChannelScope>();
            for (String channelCode : channelCodeList) {
                for (StActivityWareh st : shopList) {
                    TmpChannelScope tmp = new TmpChannelScope();
                    tmp.setChannelCode(channelCode);
                    tmp.setWarehId(st.getWarehId());
                    tmp.setScopeChange("0");
                    tmp.setWarehState(warehState);
                    tmp.setUpdateTime(new Date());
                    tmpList.add(tmp);
                }
            }
            stockLog.debug("storeMainSwitch中封装渠道和所有门店的笛卡尔积的数据：" + tmpList.size());

            // 4.将封装好的数据批量更新到同步库的TMP_CHANNEL_SCOPE
            int tag = this.tmpChannelScopeDefineMapper.insertList(tmpList);
            stockLog.debug("实际插入到同步库的TMP_CHANNEL_SCOPE的数据量是：" + tag);
            return new Message(tag == tmpList.size() ? true : false, tag == tmpList.size() ? null : Message.INSERT_WRONG);

        } catch (Exception e) {
            stockLog.error("shopMainSwitch门店总开关接口报异常：" + e.getMessage(), e);
            return new Message(false, Message.INSERT_DEBUG);
        } finally {
            stockLog.debug("门店总开关变化写入接口storeMainSwitch-->结束");
        }
    }

    protected List<StActivityWareh> getShopList() {
        StActivityWarehExample example = new StActivityWarehExample();
        example.or().andIsShopEqualTo("1");
        List<StActivityWareh> shopList = stActivityWarehMapper.selectByExample(example);
        return shopList;
    }

}
