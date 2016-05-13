package com.metersbonwe.stock.biz.manager.service;

import com.metersbonwe.stock.po.core.StockUser;

public interface StockUserService {

    /**
     * TODO 插入注册的用户信息
     * 
     * @param record
     * @return
     */
    int insertStockUser(StockUser record);

    /**
     * TODO 根据用户名查找用户信息
     * 
     * @param userName
     * @return
     */
    StockUser findStockUser(String userName);

    /**
     * TODO 验证用户和密码
     * 
     * @param userName
     * @param password
     * @return
     */
    String checkUser(String userName, String password);

    /**
     * TODO 根据用户名查找菜单
     * 
     * @param userName
     * @return
     */
    String getMenuByUserName(String userName);

}
