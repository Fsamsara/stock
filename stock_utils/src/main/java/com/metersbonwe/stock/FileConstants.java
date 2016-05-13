package com.metersbonwe.stock;

import java.util.LinkedHashMap;
import java.util.Map;

public class FileConstants {
    /**
     * 导出模板flag
     */
    public static final String TEMPLATE_FLAG = "templateFlg";

    /**
     * 导出模板配置
     */
    public static final class Template {

        public static final String PRESALEDETAIL       = "preSaleDetail";

        public static final String SHOPDAMEDETAIL      = "shopdamedetail";

        public static final String SHOPREMAILDETAIL    = "shopremaildetail";

        public static final String SHOPSAFEDETAIL      = "shopsafedetail";

        public static final String STACTIVITYWAREHDTL  = "stactivitywarehdetail";

        public static final String SHOPQUERYSTOCKETAIL = "shopquerystocktail";

        public static final String CHANNELSCOPEDETAIL  = "channelScopedetail";

        public static final String SHOPONLINEDETAIL    = "shopOnlinedetail";

        public static final String STOCKWMSETAIL       = "stockwmsdetail";

        public static final String PRODUCTONSALE       = "productOnSale";

        public static final String CHANNELMSG          = "channelMsg";

        public static String DIFF_BETWEEN_ONLINE_AND_SENDED = "diffBetweenOnlineAndSended";
    }

    /**
     * 预售模板下载
     */
    public static final Map<String, String> PRESALEDETAIL = new LinkedHashMap<>();

    static {
        PRESALEDETAIL.put("prodId", "商品编码");
        PRESALEDETAIL.put("warehId", "仓库编码");
        PRESALEDETAIL.put("prePrivateStock", "预售数量");
        PRESALEDETAIL.put("startTime", "开始时间");
        PRESALEDETAIL.put("endTime", "结束时间");
    }

    /**
     * 渠道在售商品
     */
    public static final Map<String, String> PRODUCTONSALE = new LinkedHashMap<>();

    static {
        PRODUCTONSALE.put("channelCode", "渠道编码");
        PRODUCTONSALE.put("prodId", "商品编码");
    }

    /**
     * 渠道库存与推送库存差异查询
     */
    public static final Map<String, String> DIFF_BETWEEN_ONLINE_AND_SENDED = new LinkedHashMap<>();

    static {
        DIFF_BETWEEN_ONLINE_AND_SENDED.put("channelCode", "渠道编码");
        DIFF_BETWEEN_ONLINE_AND_SENDED.put("prodId", "商品编码");
        DIFF_BETWEEN_ONLINE_AND_SENDED.put("onlineStock", "线上库存");
        DIFF_BETWEEN_ONLINE_AND_SENDED.put("finalFreeStock", "本地库存");
    }

    /**
     * 污损值列表导出
     */
    public static final Map<String, String> SHOPDAMEDETAIL = new LinkedHashMap<>();

    static {
        SHOPDAMEDETAIL.put("prodId", "商品编码");
        SHOPDAMEDETAIL.put("warehId", "门店ID");
        SHOPDAMEDETAIL.put("dameStock", "污损值");
        SHOPDAMEDETAIL.put("updateTime", "更新时间");
        SHOPDAMEDETAIL.put("updateBy", "更新人");
        SHOPDAMEDETAIL.put("createTime", "创建时间");
    }

    /**
     * 门店未日结
     */
    public static final Map<String, String> SHOPREMAILETAIL = new LinkedHashMap<>();

    static {
        SHOPREMAILETAIL.put("warehId", "门店编码");
        SHOPREMAILETAIL.put("prodId", "商品编码");
        SHOPREMAILETAIL.put("locId", "货位编码");
        SHOPREMAILETAIL.put("rllNum", "小票号");
        SHOPREMAILETAIL.put("remailStock", "未日结数量");
        SHOPREMAILETAIL.put("updateTime", "更新时间");
    }

    /**
     * WMS正数锁定量
     */
    public static final Map<String, String> STOCKWMSDETAIL = new LinkedHashMap<>();

    static {
        STOCKWMSDETAIL.put("warehId", "仓库编码");
        STOCKWMSDETAIL.put("prodId", "商品编码");
        STOCKWMSDETAIL.put("wmsStock", "正数锁定量");
        STOCKWMSDETAIL.put("updateTime", "更新时间");
    }

    /**
     * 门店安全库存
     */
    public static final Map<String, String> SHOPSAFEETAIL = new LinkedHashMap<>();

    static {
        SHOPSAFEETAIL.put("warehId", "门店编码");
        SHOPSAFEETAIL.put("prodId", "商品编码");
        SHOPREMAILETAIL.put("safeStock", "安全库存");
        SHOPREMAILETAIL.put("updateTime", "更新时间");
    }

    /**
     * 门店实际库存
     */
    public static final Map<String, String> SHOPSTOCKDTAIL = new LinkedHashMap<>();

    static {
        SHOPSTOCKDTAIL.put("warehId", "门店编码");
        SHOPSTOCKDTAIL.put("prodId", "商品编码");
        SHOPSTOCKDTAIL.put("stock", "实际库存");
    }

    /**
     * 配置组织
     */
    public static final Map<String, String> STACTIVITYWAREHDTAIL = new LinkedHashMap<>();

    static {
        STACTIVITYWAREHDTAIL.put("warehId", "仓库编码");
        STACTIVITYWAREHDTAIL.put("isShop", "是否门店");
        STACTIVITYWAREHDTAIL.put("dataSource", "数据来源");
        STACTIVITYWAREHDTAIL.put("updateTime", "更新时间");
    }

    /**
     * 渠道配发范围导出
     */
    public static final Map<String, String> CHANNELSCOPEDETAIL = new LinkedHashMap<>();

    static {
        CHANNELSCOPEDETAIL.put("channelCode", "渠道编码");
        CHANNELSCOPEDETAIL.put("channelName", "渠道名称");
        CHANNELSCOPEDETAIL.put("warehId", "配发组织编码");
        CHANNELSCOPEDETAIL.put("warehName", "配发组织名称");
    }

    /**
     * 门店线上库存导出
     */
    public static final Map<String, String> SHOPONLINEDETAIL = new LinkedHashMap<>();

    static {
        SHOPONLINEDETAIL.put("prodId", "商品编码");
        SHOPONLINEDETAIL.put("onlineStock", "可用库存总量");
    }

    /**
     * 渠道信息
     */
    public static final Map<String, String> CHANNELMSGDTAIL = new LinkedHashMap<>();

    static {
        CHANNELMSGDTAIL.put("channelCode", "渠道编码");
        CHANNELMSGDTAIL.put("channelName", "渠道名称");
    }

    /**
     * 模板Map
     */
    public static final Map<String, Map<String, String>> TEMPLATE_MAP = new LinkedHashMap<>();

    static {
        TEMPLATE_MAP.put(Template.PRESALEDETAIL, PRESALEDETAIL);
        TEMPLATE_MAP.put(Template.SHOPDAMEDETAIL, SHOPDAMEDETAIL);
        TEMPLATE_MAP.put(Template.SHOPREMAILDETAIL, SHOPREMAILETAIL);
        TEMPLATE_MAP.put(Template.SHOPSAFEDETAIL, SHOPSAFEETAIL);
        TEMPLATE_MAP.put(Template.SHOPQUERYSTOCKETAIL, SHOPSTOCKDTAIL);
        TEMPLATE_MAP.put(Template.CHANNELSCOPEDETAIL, CHANNELSCOPEDETAIL);
        TEMPLATE_MAP.put(Template.SHOPONLINEDETAIL, SHOPONLINEDETAIL);
        TEMPLATE_MAP.put(Template.STOCKWMSETAIL, STOCKWMSDETAIL);
        //在售商品清单下载
        TEMPLATE_MAP.put(Template.PRODUCTONSALE, PRODUCTONSALE);
        TEMPLATE_MAP.put(Template.STACTIVITYWAREHDTL, STACTIVITYWAREHDTAIL);
        TEMPLATE_MAP.put(Template.CHANNELMSG, CHANNELMSGDTAIL);
        //渠道库存与推送库存差异查询
        TEMPLATE_MAP.put(Template.DIFF_BETWEEN_ONLINE_AND_SENDED, DIFF_BETWEEN_ONLINE_AND_SENDED);

    }

}
