package com.metersbonwe.stock.biz.schedule.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metersbonwe.stock.dal.auto.core.mapper.StockCommonConfigMapper;
import com.metersbonwe.stock.dal.auto.sync.mapper.DrInterfaceProMapper;
import com.metersbonwe.stock.dal.auto.sync.mapper.StActivityWarehMapper;
import com.metersbonwe.stock.dal.define.sync.mapper.BfOrgShopDefineMapper;
import com.metersbonwe.stock.dal.define.sync.mapper.UdWarehParamDefineMapper;
import com.metersbonwe.stock.facade.schedule.StActivityWarehService;
import com.metersbonwe.stock.facade.sync.api.FullStockSyncService;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockCommonConfig;
import com.metersbonwe.stock.po.core.StockCommonConfigExample;
import com.metersbonwe.stock.po.sync.DrInterfacePro;
import com.metersbonwe.stock.po.sync.DrInterfaceProExample;
import com.metersbonwe.stock.po.sync.StActivityWareh;
import com.metersbonwe.stock.po.sync.StActivityWarehExample;
import com.metersbonwe.stock.po.sync.define.BfOrgShopDefine;
import com.metersbonwe.stock.po.sync.define.UdWarehParamDefine;
import com.metersbonwe.stock.utils.concurrent.FullStockSyncLock;

@Service public class StActivityWarehServiceImpl implements StActivityWarehService {
    private static StockLog             stockLog       = StockLogFactory.getLogger(StActivityWarehServiceImpl.class);

    private final String                SERVICE_NAME   = "ST_ACTITY_WAREH表维护任务";

    private final String                SERVICE_NAME_B = "ST_ACTITY_WAREH表维护任务，有新增仓数据，触发全量同步服务";

    private final String                CONFIG_NAME    = "IS_SHOP_DATASOURCE_ALL_OERP";

    @Autowired UdWarehParamDefineMapper UdWarehParamB2CMapper;

    @Autowired BfOrgShopDefineMapper    BfOrgShopB2CMapper;

    @Autowired DrInterfaceProMapper     DrInterfaceProMapper;

    @Autowired StActivityWarehMapper    StActivityWarehMapper;

    @Autowired FullStockSyncService     fullStockSyncService;

    @Autowired StockCommonConfigMapper  stockCommonConfigMapper;

    @Override
    public void doService() {
        Boolean isHaveNewWareh = false;
        stockLog.info(SERVICE_NAME + "开始运行");
        ReadWriteLock rwLock = FullStockSyncLock.getLock();
        Lock lock = rwLock.readLock();
        try {
            lock.lock();
            List<StActivityWareh> oldActivityWarehs = getAllDate();
            stockLog.debug("获取数据库的配发范围信息有:" + oldActivityWarehs.size());

            List<StActivityWareh> activityWarehs = new ArrayList<StActivityWareh>();
            //获取仓库记录
            addWarehs(activityWarehs);
            stockLog.debug("获取仓库记录后,有" + activityWarehs.size());
            //获取门店记录
            addShops(activityWarehs);
            stockLog.debug("获取门店记录后,有" + activityWarehs.size());

            isHaveNewWareh = getIsHaveNewDate(oldActivityWarehs, activityWarehs);
            stockLog.debug("是否有新增仓库" + isHaveNewWareh);

            //保存
            saveDate(activityWarehs);
            stockLog.debug("更新插入获取到的记录");
        } catch (Exception e) {
            stockLog.error(SERVICE_NAME + "出错", e);
        } finally {
            lock.unlock();
            stockLog.info(SERVICE_NAME + "结束运行");
            if (isHaveNewWareh) {
                callFullStockSyncService();
            }
        }
    }

    /**
     * 全量同步
     */
    private void callFullStockSyncService() {
        stockLog.info(SERVICE_NAME_B + "开始运行");
        try {
            fullStockSyncService.performFullStockSync();
        } catch (Exception e) {
            stockLog.error(SERVICE_NAME_B + "出错", e);
        } finally {
            stockLog.info(SERVICE_NAME_B + "结束运行");
        }
    }

    /**
     * 获取参与B2C配发的仓库
     * 
     * @param activityWarehs
     */
    private void addWarehs(List<StActivityWareh> activityWarehs) {
        List<UdWarehParamDefine> warehs = UdWarehParamB2CMapper.selectAllForB2C();
        for (UdWarehParamDefine udWarehParamB2C : warehs) {
            StActivityWareh newItem = new StActivityWareh();
            newItem.setWarehId(udWarehParamB2C.getCode());
            newItem.setIsShop("0");
            newItem.setDataSource(udWarehParamB2C.getProdSource());
            newItem.setUpdateTime(new Date());
            activityWarehs.add(newItem);
        }
    }

    /**
     * 获取参与B2C配发的门店
     * 
     * @param activityWarehs
     */
    private void addShops(List<StActivityWareh> activityWarehs) {
        //获取使用新ERP的门店组织
        Set<BigDecimal> nerpUnits = getUsingNerpUnitIds();
        //获取参与配发门店
        List<BfOrgShopDefine> shops = BfOrgShopB2CMapper.selectAllForB2C();
        for (BfOrgShopDefine bfOrgShopB2C : shops) {
            StActivityWareh newItem = new StActivityWareh();
            newItem.setWarehId(bfOrgShopB2C.getCode());
            newItem.setIsShop("1");
            String dataSource = "OERP";
            if (nerpUnits.contains(bfOrgShopB2C.getOwnerId())) {
                dataSource = "NERP";
            }
            newItem.setDataSource(dataSource);
            newItem.setUpdateTime(new Date());
            activityWarehs.add(newItem);
        }
    }

    private List<DrInterfacePro> getDrInfo() {
        DrInterfaceProExample example = new DrInterfaceProExample();
        example.createCriteria();
        return DrInterfaceProMapper.selectByExample(example);
    }

    /**
     * 获取切换到新ERP的门店组织ID(根据配置获取门店是否全老ERP)
     * 
     * @return
     */
    private Set<BigDecimal> getUsingNerpUnitIds() {
        Set<BigDecimal> nerpUnits = new HashSet<BigDecimal>();
        Boolean isDataSourceAllOerp = getDataSourceAllOerp();
        stockLog.debug("通过配置，查询门店数据源是否全部老ERP:" + isDataSourceAllOerp);
        if (!isDataSourceAllOerp) {
            List<DrInterfacePro> shopPros = getDrInfo();
            for (DrInterfacePro drInterfacePro : shopPros) {
                nerpUnits.add(drInterfacePro.getUnitId());
            }
        }
        return nerpUnits;
    }

    /**
     * 获取配置门店是否全老ERP。没有配置的话，默认老ERP:true
     * 
     * @return
     */
    private Boolean getDataSourceAllOerp() {
        StockCommonConfigExample example = new StockCommonConfigExample();
        example.createCriteria().andConfigNameEqualTo(CONFIG_NAME);
        List<StockCommonConfig> configs = stockCommonConfigMapper.selectByExample(example);
        if (configs == null || configs.size() == 0) {
            return true;
        } else {
            return "1".equals(configs.get(0).getConfigValue());
        }
    }

    /**
     * 保存
     * 
     * @param activityWarehs
     */
    private void saveDate(List<StActivityWareh> activityWarehs) {
        for (StActivityWareh StActivityWareh : activityWarehs) {
            int upBak = StActivityWarehMapper.updateByPrimaryKey(StActivityWareh);
            if (upBak == 0) {
                StActivityWarehMapper.insert(StActivityWareh);
            }
        }
    }

    /**
     * 获取仓库列表
     * 
     * @return
     */
    private List<StActivityWareh> getAllDate() {
        StActivityWarehExample example = new StActivityWarehExample();
        example.createCriteria();
        return StActivityWarehMapper.selectByExample(example);
    }

    /**
     * 判断是否有新增的仓库
     * 
     * @param oldActivityWarehs
     * @param newActivityWarehs
     * @return
     */
    private Boolean getIsHaveNewDate(List<StActivityWareh> oldActivityWarehs, List<StActivityWareh> newActivityWarehs) {
        for (StActivityWareh stActivityWareh_new : newActivityWarehs) {
            Boolean bak = getWarehIdNotExits(stActivityWareh_new.getWarehId(), oldActivityWarehs);
            if (bak) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断仓库是否不在列表里
     * 
     * @param warehId
     * @param activityWarehs
     * @return
     */
    private Boolean getWarehIdNotExits(String warehId, List<StActivityWareh> activityWarehs) {
        int i = 0;
        for (StActivityWareh stActivityWareh : activityWarehs) {
            if (warehId.equalsIgnoreCase(stActivityWareh.getWarehId())) {
                i++;
            }
        }
        return i == 0;
    }
}
