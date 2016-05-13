package com.metersbonwe.stock.biz.api.query;

import com.metersbonwe.stock.dal.auto.core.mapper.StockChannelSendedMapper;
import com.metersbonwe.stock.facade.api.UsefulStockSearchService;
import com.metersbonwe.stock.facade.api.bean.SkuStock;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockChannelSended;
import com.metersbonwe.stock.po.core.StockChannelSendedExample;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huangbiao
 * @version V1.0
 * @description 可用库存查询
 * @date 2016/3/28
 */
@Service public class UsefulStockSearchServiceImpl implements UsefulStockSearchService {

    private static StockLog stockLog = StockLogFactory.getLogger(UsefulStockSearchServiceImpl.class);

    @Resource StockChannelSendedMapper stockChannelSendedMapper;

    @Override
    public int getStock(String sku, String channelCode) {
        stockLog.info("==========查询条件 sku： " + sku + "渠道：" + channelCode + "的可用库存==========");
        StockChannelSendedExample stockChannelSendedExample = new StockChannelSendedExample();
        stockChannelSendedExample.createCriteria().andProdIdEqualTo(sku).andChannelCodeEqualTo(channelCode);
        StockChannelSended stockChannelSended = new StockChannelSended();
        stockChannelSended.setTableSuffix(channelCode.toLowerCase());
        List<StockChannelSended> stockChannelSendedList = stockChannelSendedMapper.selectByExample(stockChannelSended, stockChannelSendedExample);
        if (stockChannelSendedList != null && stockChannelSendedList.size() > 0) {
            return stockChannelSendedList.get(0).getStockSended();
        } else {
            stockLog.info("==========未查询到sku:" + sku + "的相关数据==========");
            return -9;
        }
    }

    @Override
    public List<SkuStock> getBatchStock(List<String> skuList, String channelCode) {
        stockLog.info("==========查询条件 skuList： " + skuList + "渠道：" + channelCode + "的可用库存==========");
        if (skuList == null || skuList.size() == 0) {
            return null;
        }
        List<SkuStock> result = new ArrayList<>(skuList.size());
        for (String sku : skuList) {
            int stock = getStock(sku, channelCode);
            SkuStock temp = new SkuStock();
            temp.setSku(sku);
            temp.setAllStock(stock);
            result.add(temp);
        }
        return result;
    }

    @Override
    public List<SkuStock> getBatchStockBySn(String sn, String channelCode) {
        stockLog.info("==========查询条件 六位码sku： " + sn + "渠道：" + channelCode + "的可用库存==========");
        if (StringUtils.isBlank(sn) || StringUtils.isBlank(channelCode)) {
            return null;
        }
        StockChannelSendedExample stockChannelSendedExample = new StockChannelSendedExample();
        stockChannelSendedExample.createCriteria().andChannelCodeEqualTo(channelCode).andProdIdLike(sn+"%");
        StockChannelSended stockChannelSended = new StockChannelSended();
        stockChannelSended.setTableSuffix(channelCode.toLowerCase());
        List<StockChannelSended> stockChannelSendedList = stockChannelSendedMapper.selectByExample(stockChannelSended, stockChannelSendedExample);
        List<SkuStock> result = new ArrayList<>();
        for (StockChannelSended tempBean : stockChannelSendedList) {
            SkuStock temp = new SkuStock();
            temp.setAllStock(tempBean.getStockSended());
            temp.setSku(tempBean.getProdId());
            result.add(temp);
        }
        return result;
    }
}
