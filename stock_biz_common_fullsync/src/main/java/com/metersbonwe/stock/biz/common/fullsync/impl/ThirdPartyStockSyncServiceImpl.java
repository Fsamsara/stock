package com.metersbonwe.stock.biz.common.fullsync.impl;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.mbv.comm.api.SyncInventoryService;
import com.mbv.comm.bean.ResultData;
import com.mbv.comm.bean.VpWarehProdEntity;
import com.metersbonwe.stock.Constants;
import com.metersbonwe.stock.biz.common.fullsync.ThirdPartyStockSyncService;
import com.metersbonwe.stock.biz.common.service.MultiTableService;
import com.metersbonwe.stock.configuration.ThreadConfig;
import com.metersbonwe.stock.configuration.ThreadConfigFactory;
import com.metersbonwe.stock.jdbc.mapper.StockFullSyncMapper;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.pojo.sync.PageBean;

/**
 * 全量同步第三方库存
 * 
 * @author 张瑞雨 zhangry@metersbonwe.com
 * @date 2016-4-18 下午1:17:52
 */
@Service public class ThirdPartyStockSyncServiceImpl implements ThirdPartyStockSyncService {

    @Resource MultiTableService    multiTableServiceImpl;

    @Resource SyncInventoryService syncInventoryService;

    @Resource StockFullSyncMapper  stockFullSyncMapperMysqlImpl;

    StockLog                       log = StockLogFactory.getLogger(ThirdPartyStockSyncServiceImpl.class);

    @Override
    public void syncTpStock() {
        ThreadConfig config = ThreadConfigFactory.getThreadConfig(Constants.THREAD_CONFIG_BIZNAME_THIRDPARTY_SYNC);
        int maxPageNum = 1;
        int currentPageNum = 1;
        while (currentPageNum <= maxPageNum) {
            try {
                int allsize = sysncTpStock(currentPageNum, config.getSize());
                if (currentPageNum == 1 && allsize > 0) {
                    maxPageNum = new PageBean(config.getSize(), allsize).getMaxPageNo();
                }
            } catch (Exception e) {
                log.error("第三方库存全量获取失败:" + e.getMessage(), e);
            }
            currentPageNum++;
        }
    }

    private int sysncTpStock(int page, int size) throws Exception {
        ResultData<ArrayList<VpWarehProdEntity>> result = syncInventoryService.getProdInventory(page, size);
        Assert.notNull(result, "result is null");
        Assert.isTrue(result.getIsOk() == 1, "第三方库存全量获取失败,status:" + result.getIsOk() + ",msg:" + result.getMsg());
        int allcount = result.getTotalCount();
        try {
            insertTpStock(result);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return allcount;
    }

    private void insertTpStock(ResultData<ArrayList<VpWarehProdEntity>> result) {
        List<VpWarehProdEntity> item = result.getData();
        Assert.notEmpty(item, "第三方库存获取为空:" + result.getMsg() + ",status:" + result.getIsOk());
        for (int i = 0; i < item.size(); i++) {
            try {
                VpWarehProdEntity entity = item.get(i);
                insertItem(entity);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
    }

    private int insertItem(VpWarehProdEntity entity) {
        Assert.notNull(entity, " List<VpWarehProdEntity>数据有NULL值");
        String suffix = multiTableServiceImpl.getTableSuffixByWarehId(entity.getWarehCode());
        StringBuilder sql = new StringBuilder("insert into tmp_stock_wareh_prod_free_");
        sql.append(suffix).append(" (wareh_id,prod_id,stk_on_hand,qty_committed,free_share_stock,safe_type,")
                .append("safe_stock,wms_stock,remail_stock,dame_stock,is_shop,update_time) values ('").append(entity.getWarehCode()).append("','")
                .append(entity.getProdNum()).append("',").append(entity.getStkOnHand()).append(",0,").append(entity.getStkOnHand())
                .append(",'NO',0,0,0,0,0,now())");
        log.debug("插入第三方库存:" + sql.toString());
        return stockFullSyncMapperMysqlImpl.execSqlU(sql.toString());
    }
}
