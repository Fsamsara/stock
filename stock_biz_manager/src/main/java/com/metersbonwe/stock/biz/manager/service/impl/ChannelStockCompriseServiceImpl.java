package com.metersbonwe.stock.biz.manager.service.impl;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.metersbonwe.oms.channel.service.ChannelService;
import com.metersbonwe.stock.Constants;
import com.metersbonwe.stock.biz.common.service.AllocationRangeService;
import com.metersbonwe.stock.biz.common.service.CacheService;
import com.metersbonwe.stock.biz.common.service.MultiTableService;
import com.metersbonwe.stock.biz.manager.service.ChannelStockCompriseService;
import com.metersbonwe.stock.dal.auto.core.mapper.StockWpSafeMapper;
import com.metersbonwe.stock.dal.define.core.mapper.ChannelStockCompriseCoreMapper;
import com.metersbonwe.stock.dal.define.sync.mapper.UsefulWarehChangeSyncMapper;
import com.metersbonwe.stock.po.core.StockChannelScope;
import com.metersbonwe.stock.po.core.StockWpSafe;
import com.metersbonwe.stock.po.core.StockWpSafeExample;
import com.metersbonwe.stock.po.core.define.ChannelProdBean;
import com.metersbonwe.stock.po.sync.define.ChannelReservedBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huangbiao
 * @version V1.0
 * @description
 * @date 2016/5/12
 */
@Service
public class ChannelStockCompriseServiceImpl implements ChannelStockCompriseService {

    @Resource CacheService cacheServiceImpl;

    @Resource ChannelService channelServiceImpl;

    @Resource MultiTableService multiTableService;

    @Resource AllocationRangeService allocationRangeServiceImpl;

    @Resource ChannelStockCompriseCoreMapper channelStockCompriseCoreMapper;

    @Resource UsefulWarehChangeSyncMapper usefulWarehChangeSyncMapper;

    @Resource StockWpSafeMapper stockWpSafeMapper;

    @Override public List<ChannelProdBean> selectChannelStockComprise(Map<String, String> paraMap) {
        String channelCode = paraMap.get("channelCode");
        String prodId = paraMap.get("prodId");
        if (StringUtils.isBlank(channelCode) || StringUtils.isBlank(prodId)) {
            return new ArrayList<>();
        }
        List<String> usefulWareh = cacheServiceImpl.getChannelUsefulWarehFromCache(channelCode);
        String channelName = getChannelName(channelCode);
        String getFreeLockStockSql = createSqlString(channelCode, channelName, usefulWareh, prodId);
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put(Constants.ParamMapKey.TABLE_NAME, getFreeLockStockSql);
        List<ChannelProdBean> channelProdBeanList = channelStockCompriseCoreMapper.getFreeLockStock(paramMap);
        List<ChannelProdBean> listReserved =  calReservedData(channelCode, usefulWareh, prodId, Constants.ReservedFlg.RESERVED);
        String channelGorup = cacheServiceImpl.getShopGroupFromCache(channelCode);
        List<ChannelProdBean> listGroupReserved =  calReservedData(channelGorup,usefulWareh,prodId,Constants.ReservedFlg.CHANNELGROUPRESERVED);
        channelProdBeanList.addAll(listReserved);
        channelProdBeanList.addAll(listGroupReserved);
        return channelProdBeanList;
    }

    /**
     * 获取渠道名称
     * @param channelCode 渠道编码
     * @return 渠道名称
     */
    private String getChannelName(String channelCode) {
        List<StockChannelScope> stockChannelScopeList = allocationRangeServiceImpl.getAllUsefulChannelForBean();
        for (StockChannelScope stockChannelScope : stockChannelScopeList) {
            if (channelCode.equalsIgnoreCase(stockChannelScope.getChannelCode())) {
                return stockChannelScope.getChannelName();
            }
        }
        return "没找到对应渠道名称";
    }

    /**
     * @description 根据最终可用仓、sku，拼写查询仓+sku表的相关sql
     * @param channelCode
     *@param channelName
     * @param usefulWarehList
     *            渠道最终可用仓集合
     * @param prodId
 *            商品11位码   @return sql字符串
     */
    protected String createSqlString(String channelCode, String channelName, List<String> usefulWarehList, String prodId) {
        // 开通了 b2b 的仓
        List<String> b2bWarehlist = cacheServiceImpl.getB2BWarehFromCache();
        List<String> noB2BWareh = new ArrayList<>(usefulWarehList);
        noB2BWareh.removeAll(b2bWarehlist);
        List<String> b2bWareh = new ArrayList<>(usefulWarehList);
        b2bWareh.retainAll(b2bWarehlist);
        StringBuilder stringBuilder = new StringBuilder();
        if(b2bWareh.size() > 0)
            for (int i = 0; i <= multiTableService.getMaxTableSeq(); i++) {
                stringBuilder.append(" select '").append(channelCode).append("' channelCode,'").append(channelName)
                        .append("' channelName, wareh_id, prod_id,final_free_share_stock finalFreeShareStock, t.lock_stock from ");
                stringBuilder.append("stock_wareh_prod_").append(multiTableService.getMappingSuffix(i)).append(" t ");
                stringBuilder.append(" where t.prod_id = '").append(prodId).append("' ").append(" and online_safe_stock !=-1").append(
                        " and t.wareh_id in (");
                for (String wareh : b2bWareh) {
                    stringBuilder.append("'").append(wareh).append("',");
                }
                stringBuilder.deleteCharAt(stringBuilder.length() - 1).append(")");
                if (i != multiTableService.getMaxTableSeq()) {
                    stringBuilder.append(" union all ");
                }
            }
        if (noB2BWareh.size() > 0) {
            if(b2bWareh.size() > 0) stringBuilder.append(" union all ");
            for (int i = 0; i <= multiTableService.getMaxTableSeq(); i++) {
                stringBuilder.append(" select '").append(channelCode).append("' channelCode,'").append(channelName)
                        .append("' channelName, wareh_id, prod_id,final_free_share_stock finalFreeShareStock, 0 lock_stock from ");
                stringBuilder.append("stock_wareh_prod_").append(multiTableService.getMappingSuffix(i)).append(" t ");
                stringBuilder.append(" where t.prod_id = '").append(prodId).append("' ").append(" and online_safe_stock !=-1").append(" and t.wareh_id in (");
                for (String wareh : noB2BWareh) {
                    stringBuilder.append("'").append(wareh).append("',");
                }
                stringBuilder.deleteCharAt(stringBuilder.length() - 1).append(")");
                if (i != multiTableService.getMaxTableSeq()) {
                    stringBuilder.append(" union all ");
                }
            }
        }
        return stringBuilder.toString();
    }

    /**
     * @description 计算预留量,店群预留量
     * @param channelCode 渠道编码
     * @param prodId 产品ID
     * @return 预留量
     */
    public List<ChannelProdBean> calReservedData(String channelCode, List<String> usefulWareh, String prodId, String reservedFlg) {
        List<ChannelProdBean> channelProdBeanList = new ArrayList<>();
        if(usefulWareh == null || usefulWareh.size() == 0){
            return channelProdBeanList;
        }
        Map<String, Object> paramMap = new HashMap<>();
        List<String> channelCodeList = new ArrayList<>();
        channelCodeList.add(channelCode);
        paramMap.put(Constants.ParamMapKey.CHANNEL_CODE_LIST, channelCodeList);
        paramMap.put(Constants.ParamMapKey.USEFUL_WAREH_LIST, usefulWareh);
        paramMap.put(Constants.ParamMapKey.PROD_ID, prodId);
        List<ChannelReservedBean> channelReservedBeanList = usefulWarehChangeSyncMapper.getChannelReservedData(paramMap);
        List<String> haveWpSafeValueWarehList = getHaveWpSafeValueWarehIdByProdId(prodId);
        for (ChannelReservedBean channelReservedBean : channelReservedBeanList) {
            String warhId = channelReservedBean.getWarehId();
            String safeType = channelReservedBean.getSafeType();
            if ("WP".equalsIgnoreCase(safeType) && !haveWpSafeValueWarehList.contains(warhId)) {
              continue;
            }
            ChannelProdBean channelProdBean = new ChannelProdBean();
            channelProdBean.setProdId(prodId);
            channelProdBean.setWarehId(warhId);
            channelProdBean.setChannelCode(channelCode);
            channelProdBean.setChannelName(getChannelName(channelCode));
            if(reservedFlg.equalsIgnoreCase(Constants.ReservedFlg.RESERVED)) {
                channelProdBean.setPrivateStock(channelReservedBean.getReservedStock());
            }else{
                channelProdBean.setShopGroupStock(channelReservedBean.getReservedStock());
            }
            channelProdBeanList.add(channelProdBean);
        }
        return channelProdBeanList;
    }

    /**
     * @description 获取prod_id在哪几个wp类型的仓有安全库存
     * @param prodId
     *            商品11位码
     * @return 仓List
     */
    private List<String> getHaveWpSafeValueWarehIdByProdId(String prodId) {
        StockWpSafeExample stockWpSafeExample = new StockWpSafeExample();
        stockWpSafeExample.createCriteria().andProdIdEqualTo(prodId);
        List<String> haveReservedWarehList = new ArrayList<>();
        List<StockWpSafe> stockWpSafeList = stockWpSafeMapper.selectByExample(stockWpSafeExample);
        for (StockWpSafe stockWpSafe : stockWpSafeList) {
            haveReservedWarehList.add(stockWpSafe.getWarehId());
        }
        return haveReservedWarehList;
    }
}
