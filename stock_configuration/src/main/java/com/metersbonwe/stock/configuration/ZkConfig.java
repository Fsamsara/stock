package com.metersbonwe.stock.configuration;

import org.I0Itec.zkclient.ZkClient;

import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;

/**
 * 配置文件相关文件
 * 
 * @author 张瑞雨 zhangry@metersbonwe.com
 * @date 2016-4-7 下午7:10:22
 */
public class ZkConfig {

    static ZkClient zkclient = ZookeeperManager.getZkClient();

    static StockLog log      = StockLogFactory.getLogger(ZkConfig.class);

    /**
     * 读取配置
     * 
     * @param name
     *            key
     * @return
     */
    public static String getConfig(String name) {
        String path = ZookeeperManager.DEFAULT_STOCK_CONF_BASE + name;
        log.debug("读取配置参数key=" + name + "path:" + path);
        Object o = zkclient.readData(ZookeeperManager.DEFAULT_STOCK_CONF_BASE + name, true);
        if (o == null) {
            log.debug("没有读取到配置信息key=" + name + ",value:" + o);
            return null;
        }
        log.debug("读取配置参数key=" + name + ",value:" + o);
        return o.toString();
    }

    /**
     * 写入配置
     * 
     * @param name
     * @param value
     * @return
     */
    public static boolean setConfig(String name, String value) {
        String path = ZookeeperManager.DEFAULT_STOCK_CONF_BASE + name;
        log.debug("写入配置信息 key:" + name + ",value:" + value + ",path:" + path);
        ZookeeperManager.createPath(path);
        try {
            zkclient.writeData(path, value);
        } catch (Exception e) {
            log.error("写入配置数据失败[key:" + name + ",value:" + value, e);
            return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        ZkConfig.setConfig("zry", "aaa");
       String s = ZkConfig.getConfig("zry");
       System.out.println(s);
    }
    
}
