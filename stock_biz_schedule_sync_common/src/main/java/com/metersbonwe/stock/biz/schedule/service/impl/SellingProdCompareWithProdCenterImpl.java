package com.metersbonwe.stock.biz.schedule.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.metersbonwe.oms.channel.bean.ChannelApiResult;
import com.metersbonwe.oms.channel.service.ChannelService;
import com.metersbonwe.oms.channel.service.ProductGoodsCacheService;
import com.metersbonwe.stock.biz.common.localcache.provider.ChannelCodeCacheProvider;
import com.metersbonwe.stock.facade.schedule.SellingProdCompareWithProdCenter;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.utils.MailManager;

@Service public class SellingProdCompareWithProdCenterImpl implements SellingProdCompareWithProdCenter {
    private static StockLog            stockLog     = StockLogFactory.getLogger(SellingProdCompareWithProdCenterImpl.class);

    private final String               SERVICE_NAME = "线上在售商品和商品中心商品比较";

    @Resource ChannelService           channelService;

    @Resource ChannelCodeCacheProvider channelCodeCacheProvider;

    @Resource ProductGoodsCacheService productGoodsCacheService;

    @Override
    public void doService() {
        stockLog.info(SERVICE_NAME + "开始运行");
        try {
            List<String> sellingProdList = getSellingProdList();
            stockLog.debug("获取在售商品" + sellingProdList.size() + "条");

            List<String> noHaveMasgProdlist = getNotExistInProdCenterProds(sellingProdList);
            stockLog.debug("获取在售商品在商品中心未配置的有" + noHaveMasgProdlist.size() + "条");

            sendMail(noHaveMasgProdlist);
        } catch (Exception e) {
            stockLog.error(SERVICE_NAME + "出错", e);
        } finally {
            stockLog.info(SERVICE_NAME + "结束运行");
        }
    }

    /**
     * 获取在售商品
     * 
     * @return
     */
    private List<String> getSellingProdList() {
        //查询渠道
        Set<String> skus = new HashSet<String>();
        List<String> channels = channelCodeCacheProvider.getAllUsefulChannel();

        for (String channelCode : channels) {
            ChannelApiResult result = channelService.onSellList(channelCode, null, 1, 0);
            stockLog.debug("查询渠道" + channelCode + "返回信息：" + result.getMessage());
            if ("0".equals(result.getCode())) {
                int page = result.getNumIid();
                stockLog.debug("查询渠道" + channelCode + "sku 页数:" + page);
                for (int i = 1; i <= page; i++) {
                    stockLog.debug("查询渠道" + channelCode + "sku 第" + i + "页数据");
                    result = channelService.onSellList(channelCode, null, i, 0);
                    List<Map<String, String>> maps = result.getShellList();
                    if (CollectionUtils.isNotEmpty(maps)) {
                        for (Map<String, String> map : maps) {
                            skus.add(map.get("sku"));
                        }
                    }
                    stockLog.debug("渠道sku列表数据有" + skus.size() + "条");
                }
            } else {
                stockLog.error("查询渠道" + channelCode + "返回信息：" + result.getMessage());
            }
        }
        return new ArrayList<String>(skus);
    }

    /**
     * 比较商品中心，找出没有维护信息的商品
     * 
     * @return
     */
    private List<String> getNotExistInProdCenterProds(List<String> sellingProdList) {
        List<String> bak = new ArrayList<String>();
        ChannelApiResult result = productGoodsCacheService.searchProductGoodsInfo(sellingProdList);
        stockLog.debug("调用服务searchProductGoodsInfo返回信息:" + result.getMessage());
        if ("0".equals(result.getCode())) {
            bak = result.getShellList();
        } else {
            stockLog.error("调用服务searchProductGoodsInfo失败:" + result.getMessage());
        }
        return bak;
    }

    /**
     * 发邮件给相关人员
     * 
     * @param noHaveMasgProdlist
     */
    private void sendMail(List<String> noHaveMasgProdlist) {
        try {
            String subject = "商品中心未维护在售商品列表信息";
            String to = "";
            String text = noHaveMasgProdlist.toString();
            MailManager.sendMail(subject, to, text);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            stockLog.error(SERVICE_NAME + ",发送邮件出错", e);
        }
    }
}
