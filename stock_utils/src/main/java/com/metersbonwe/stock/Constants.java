package com.metersbonwe.stock;

/**
 * @author zhangfeng zhangfeng@metersbonwe.com
 * @date 2016年3月23日 下午2:43:23 常量类
 */
public class Constants {
    /**
     * 仓商品明细表前缀
     */
    public static final String STOCK_WAREH_PROD_PREFIX = "stock_wareh_prod_";

    /**
     * 线程数量配置
     */
    public static class ThreadNum {
        //将仓商品明细表数据插入到tmp_stock_table_sum数据表线程数
        //public static final int INSERT_TMP_STOCK_TABLE_SUM = 20;
    }

    /**
     * 屬性相關
     */
    public static class Property {
        public static final String TYPE  = "type";

        public static final String VALUE = "value";

        public static final String NAME  = "name";
    }

    /**
     * 临时表
     */
    public static class TmpDataTable {

        //渠道可用仓变化临时表--同步库
        public static final String TMP_CHANNEL_SCOPE                   = "tmp_channel_scope";

        //渠道商品明细临时表(渠道可用仓变化用)--核心库
        public static final String TMP_CHANNEL_PROD_TABLE              = "tmp_stock_channel_prod";

        //遇到渠道商品明细表大量更新的时候保留channel_wareh_prod_free_lock队列的数据的临时表--核心库
        public static final String TMP_QUEUE_FREE_LOCK                 = "tmp_queue_free_lock";

        //遇到渠道商品明细表大量更新的时候保留channel_wareh_prod_free_lock队列的数据的临时表--核心库
        public static final String TMP_QUEUE_RESERVED                  = "tmp_queue_reserved";

        //遇到渠道商品明细表大量更新的时候保留CHANNEL_ALL队列的数据的临时表--核心库
        public static final String TMP_QUEUE_ALL                  = "tmp_queue_all";

        //遇到渠道商品明细表大量更新的时候保留CHANNEL_GROUP_RESERVED队列的数据的临时表--核心库
        public static final String TMP_QUEUE_CHANNELGROUP_RESERVED                  = "tmp_queue_channelgroup_reserved";

        //仓库安全库存类型变化表--同步库
        public static final String TMP_SAFE_TYPE_STOCK                 = "tmp_safe_type_stock";

        //汇总仓商品明细表数据临时表
        public static final String TMP_STOCK_TABLE_SUM                 = "tmp_stock_table_sum";

        //渠道商品明细表临时表
        public static final String TMP_STOCK_CHANNEL_PROD              = "tmp_stock_channel_prod";

        //预留量批量更新临时表
        public static final String TMP_STOCK_BATCH_RESERVED            = "tmp_stock_batch_reserved";

        //预留量数据根据仓类型，按照prod_id汇总临时表
        public static final String TMP_RESERVED_SUM                    = "tmp_reserved_sum";

        //所有仓库临时表
        public static final String TMP_STOCK_WAREH                     = "tmp_stock_wareh";

        //店群预留量批量临时表
        public static final String TMP_STOCK_BATCH_SHOP_GROUP_RESERVED = "tmp_stock_batch_shop_group_reserved";

        //店群预留量汇总表
        public static final String TMP_SHOP_GROUP_RESERVED_SUM         = "tmp_shop_group_reserved_sum";
    }

    /**
     * 自定义Mapper使用Map做为参数时候，公用的key
     */
    public static class ParamMapKey {
        //表名
        public static final String TABLE_NAME        = "tableName";

        //去重复字段，字符串
        public static final String PARTITION_STRING  = "partitionStr";

        //仓库ID
        public static final String WAREH_ID          = "warehId";

        //渠道code
        public static final String CHANNEL_CODE      = "channelCode";

        //可用仓
        public static final String USEFUL_WAREH_LIST = "usefulWarehList";

        //渠道列表
        public static final String CHANNEL_CODE_LIST = "channelCodeList";

        //产品ID
        public static final String PROD_ID           = "prodId";

        //自由量获取
        public static final String FREE_STOCK        = "freestock";

        //锁定量获取
        public static final String LOCK_STOCK        = "lockstock";

        public static final String SHOP_GROUP_ID     = "shopGroupId";

        public static final String RESERVED_STOCK    = "reservedStock";
    }

    /**
     * 查询操作常量
     */
    public static class Opration {
        //等于
        public static final String EQ = "eq";

        //大于
        public static final String GT = "gt";

        //小于
        public static final String LT = "lt";

    }

    /**
     * 临时表去重字符串
     */
    public static class Dereplication {
        //按仓去重
        public static final String PARTITION_BY_WAREHID                     = "wareh_id";

        //按仓，渠道，是否配发范围变化去重
        public static final String PARTITION_BY_WAREHID_CHANNEL_SCOPECHANGE = "wareh_id, channel_code, scope_change";
    }

    /**
     * 获取线上库存分页SIZE
     */
    public static final Integer ONLINE_SIZE                           = 100;

    /**
     * 渠道商品明细表分表前缀
     */
    public static final String  STOCK_CHANNEL_PROD_PREFIX             = "stock_channel_prod_";

    /**
     * 渠道商品明细表子表分表前缀
     */
    public static final String  STOCK_CHANNEL_PROD_SUB_PREFIX         = "stock_channel_prod_sub_";

    /** 最大表序列的配置名称 */
    public final static String  MAX_TABLE_SQE_CONFIG_NAME             = "MAX_TABLE_SQE";

    /** 表的最大记录数量 */
    public final static int     MAX_TABLE_COUNT                       = 100 * 10000;

    /** 数据源为新ERP */
    public final static String  DATASOURCE_NEW                        = "NERP";

    /** 数据源为老ERP */
    public final static String  DATASOURCE_OLD                        = "OERP";

    /** 渠道来源为线上 */
    public final static String  CHANNELSOURCE_ONLINE                  = "ONLINE";

    /** 渠道来源为线下 */
    public final static String  CHANNELSOURCE_UNLINE                  = "UNLINE";

    /** 分页查询获取page对象标识 */
    public final static String  PAGE_OBJECT                           = "page";

    /** 分页查询获取pageSize对象标识 */
    public final static String  PAGESIZE                              = "pageSize";

    /** 分页查询获取rows对象标识 */
    public final static String  ROWS_OBJECT                           = "rows";

    /** 反射获取方法对象标识 */
    public final static String  METHOD_NAME                           = "methodName";

    /** 反射获取类名对象标识 */
    public final static String  MAPPER_OBJECT                         = "mapperObject";

    /** 线程数量标识 */
    public final static String  THREAD_NUM                            = "threadNum";

    /** 当一个查询条件对应多个参数的标识 */
    public final static String  MULTIPLE_FLAG                         = "multipleFlag";

    /** 调度中心渠道编码传参 */
    public final static String  CHANNEL_CODE                          = "channelCode";

    /** STOCKCOMMONCONFIG查询WMS表配置 */
    public static final String  WMS_TABLE_NAME                        = "wmsTableName";

    /** STOCKCOMMONCONFIG查询推送线上间隔时间 */
    public static final String  ONLINE_INTERVAL_TIME                  = "onlineIntervalTime";

    /** 配发范围 线上查询标识 */
    public static final String  SCOPE_ONLINE_FLAG                     = "0";

    /** 配发范围 线下查询标识 */
    public static final String  SCOPE_OFFLINE_FLAG                    = "1";

    /** 配发范围 线上数据来源标识 */
    public static final String  SCOPE_ONLINE_SOURCE                   = "01";

    /** 配发范围 线下数据来源标识 */
    public static final String  SCOPE_OFFLINE_SOURCE                  = "03";

    /** 库存变化调度服务 自由量 变化类型 */
    public static final int     STOCK_CHANGE_TYPE_FREE_QTY            = 1;

    /** 库存变化调度服务 锁定量 变化类型 */
    public static final int     STOCK_CHANGE_TYPE_LOCKED_QTY          = 2;

    /** 库存变化调度服务 预留量 变化类型 */
    public static final int     STOCK_CHANGE_TYPE_RESERVED_QTY        = 3;

    /** 库存变化调度服务 第三方自由量 变化类型 */
    public static final int     STOCK_CHANGE_TYPE_TP_FREE_QTY         = 4;

    /** 库存变化调度服务 门店未日结量 变化类型 */
    public static final int     STOCK_CHANGE_TYPE_REMAIL_QTY          = 5;

    /** 库存变化调度服务 门店污损值 变化类型 */
    public static final int     STOCK_CHANGE_TYPE_DAME_QTY            = 6;

    /** 库存变化调度服务 活动期间渠道商品推送独占量 变化类型 */
    public static final int     STOCK_CHANGE_TYPE_CHANNEL_PORD        = 8;

    //仓库、门店安全库存类型 NO
    public static final String  NO_SAFETY_STOCK_TYPE                  = "NO";

    //仓库、门店安全库存类型 WS
    public static final String  WS_SAFETY_STOCK_TYPE                  = "WS";

    //仓库、门店安全库存类型 WP
    public static final String  WP_SAFETY_STOCK_TYPE                  = "WP";

    /** 多线程配置 全量同步更新mysql 业务名称 */
    public static final String  THREAD_CONFIG_BIZNAME_FULLSYNCMYSQL   = "fullsyncmysql";

    /** 多线程配置 全量同步 业务名称 */
    public static final String  THREAD_CONFIG_BIZNAME_FULLSYNC        = "fullsync";

    /** 多线程配置 库存变化 业务名称 */
    public static final String  THREAD_CONFIG_BIZNAME_CHANGEQTY       = "changeqty";

    /** 多线程配置 门店安全库存 业务名称 */
    public static final String  THREAD_CONFIG_BIZNAME_SHOPSAFE        = "shopsafe";

    /** 多线程配置 全量同步 渠道临时表处理 业务名称 */
    public static final String  THREAD_CONFIG_BIZNAME_CHANNELTMP      = "channeltmp";

    /** 多线程配置 预售明细文件上传处理 业务名称 */
    public static final String  THREAD_CONFIG_UPLOAD_PREDETAIL      = "uploadpredetail";

    /** 多线程配置 默认配置 业务名称 */
    public static final String  THREAD_CONFIG_BIZNAME_DEFAULT         = "default";

    /** 多线程配置 推送线上业务名称 */
    public static final String  THREAD_CONFIG_BIZNAME_SEND_ONLINE     = "mq_send_online";

    /** 多线程配置 第三方库存全量业务名称 */
    public static final String  THREAD_CONFIG_BIZNAME_THIRDPARTY_SYNC = "thirdparty";

    /** 文件上传前端页面默认ID */
    public static final String  FILE_UPLOAD_FLAG                      = "files";

    /** 选择JMSTEMPLATE时分类标识 渠道相关 */
    public final static String  MQ_CHANNEL                            = "mqChannel";

    /** 选择JMSTEMPLATE时分类标识 推送线上相关 */
    public final static String  MQ_ONLINE                             = "mqOnline";

    /** 选择JMSTEMPLATE时分类标识 订单相关 */
    public final static String  MQ_ORDER                              = "mqOrder";

    public static final class ReservedFlg {
        public static final String RESERVED             = "reserved";

        public static final String CHANNELGROUPRESERVED = "channelGroupReserved";
    }
}
