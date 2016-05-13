package com.metersbonwe.stock.configuration;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

import org.I0Itec.zkclient.ZkClient;
import org.apache.commons.lang.StringUtils;
import org.menagerie.DefaultZkSessionManager;
import org.menagerie.ZkSessionManager;
import org.menagerie.locks.Locksmith;

public class ZookeeperManager {

    // TODO 读取配置加载配置
    private static String            connectionStr           = "10.100.200.13:2181";

    private static int               timeout                 = 50000;

    private static ZkSessionManager  zkSessionManager        = null;

    private static ZkClient          zkClient;

    private static String            DEFAULT_LOCK_BASE       = "/lock/stock/";

    public static String             DEFAULT_STOCK_CONF_BASE = "/stock/config/channel/";

    private static PropertiesManager properManager           = PropertiesManager.getPropertiesManager();

    static {
        initZk();
    }

    /**
     * 获取锁对象
     * 
     * @param path
     *            锁定路径
     * @return
     */
    public static Lock getDefaultLock(String path) {
        createPath(DEFAULT_LOCK_BASE + path);
        return Locksmith.reentrantLock(zkSessionManager, DEFAULT_LOCK_BASE + path);
    }

    /**
     * 获取分布式读写锁
     * 
     * @param path
     *            锁定路径
     * @return
     */
    public static ReadWriteLock getReadWriteLock(String path) {
        createPath(DEFAULT_LOCK_BASE + path);
        return Locksmith.readWriteLock(zkSessionManager, DEFAULT_LOCK_BASE + path);
    }

    /**
     * 创建锁定节点
     * 
     * @param path
     */
    public static void createPath(String path) {
        if (StringUtils.isEmpty(path)) {
            return;
        }
        if (!zkClient.exists(path)) {
            StringBuffer sb = new StringBuffer(path.trim());
            sb.deleteCharAt(0);
            String[] arr = sb.toString().split("/");
            StringBuffer temp = new StringBuffer();
            for (int i = 0; i < arr.length; i++) {
                temp.append("/").append(arr[i]);
                if (!zkClient.exists(temp.toString())) {
                    zkClient.createPersistent(temp.toString());
                }
            }
        }
    }

    /**
     * 初始化zookeeper
     */
    private static void initZk() {
        readConfig();
        zkSessionManager = new DefaultZkSessionManager(connectionStr, timeout, -1);
        zkClient = new ZkClient(connectionStr, timeout);
    }

    /**
     * 加载配置
     */
    private static void readConfig() {
        connectionStr = properManager.getProperty("lock.zookeeper.url");
        timeout = Integer.parseInt(properManager.getProperty("lock.zookeeper.timeout", "50000"));
        DEFAULT_LOCK_BASE = properManager.getProperty("lock.zookeeper.basepath", "/lock/stock/");
        DEFAULT_STOCK_CONF_BASE = properManager.getProperty("conf.zookeeper.basepath", "/stock/config/channel/");
    }

    public static ZkClient getZkClient() {
        return zkClient;
    }

}

