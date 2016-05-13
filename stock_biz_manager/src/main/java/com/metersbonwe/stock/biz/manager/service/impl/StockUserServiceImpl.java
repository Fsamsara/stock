package com.metersbonwe.stock.biz.manager.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.metersbonwe.stock.biz.manager.service.StockUserService;
import com.metersbonwe.stock.dal.define.core.mapper.StockUserDefineMapper;
import com.metersbonwe.stock.po.core.StockUser;
import com.mtsbw.platform.core.vo.Result;
import com.mtsbw.ump.permission.dubbo.service.UserMenuService;
import com.mtsbw.ump.permission.dubbo.service.UserRoleService;
import com.mtsbw.ump.permission.vo.MenuTree;
import com.mtsbw.ump.permission.vo.UserType;

@Service public class StockUserServiceImpl implements StockUserService {

    @Autowired private StockUserDefineMapper stockUserDefineMapper;

    @Resource private UserMenuService        userMenuServiceDubbo; //配置获取菜单服务

    @Resource private UserRoleService        userRoleServiceDubbo; //验证登录服务

    /**
     * TODO 插入注册的用户信息
     * 
     * @see com.metersbonwe.stock.biz.manager.service.StockUserService#insertStockUser(com.metersbonwe.stock.po.core.StockUser)
     */
    @Override
    public int insertStockUser(StockUser record) {
        int iResult = stockUserDefineMapper.insertStockUser(record);
        return iResult;
    }

    /**
     * TODO 根据用户名查找用户信息
     * 
     * @see com.metersbonwe.stock.biz.manager.service.StockUserService#findStockUser(java.lang.String)
     */
    @Override
    public StockUser findStockUser(String userName) {
        List<StockUser> stockUserList = stockUserDefineMapper.selectStockUserByUserName(userName);
        if (stockUserList != null && stockUserList.size() > 0) {
            return stockUserList.get(0);
        } else {
            return null;
        }

    }

    /**
     * TODO 验证用户和密码
     * 
     * @see com.metersbonwe.stock.biz.manager.service.StockUserService#checkUser(java.lang.String, java.lang.String)
     */
    public String checkUser(String userName, String password) {
        Result r = userRoleServiceDubbo.checkUser(userName, password, UserType.LOCAL);
        if ("OK".equals(r.getStatus().name())) {
            return "";
        } else {
            return r.getMessage().toString();
        }
    }

    /**
     * TODO 根据用户名查找菜单
     * 
     * @see com.metersbonwe.stock.biz.manager.service.StockUserService#getMenuByUserName(java.lang.String)
     */
    public String getMenuByUserName(String userName) {
        String jsonData = "";
        String menuType = "BS";
        String parentMenuCode = "NEW_STOCK_CODE";
        List<MenuTree> menuTreeList = userMenuServiceDubbo.getMenuTreeByParentAndUser(userName, parentMenuCode, menuType);
        List<MenuTreeVo> menuTreeVoList = new ArrayList<>();
        initMenuTreeVoList(menuTreeVoList, menuTreeList);
        ReturnMenuBean bean = new ReturnMenuBean();
        bean.setMessage(menuTreeVoList);
        jsonData = JSON.toJSONString(bean);
        return jsonData;
    }

    private void initMenuTreeVoList(List<MenuTreeVo> menuTreeVoList, List<MenuTree> menuTreeList) {
        if (menuTreeList == null || menuTreeList.size() <= 0) {
            return;
        }
        for (MenuTree menuTree : menuTreeList) {
            MenuTreeVo menuTreeVo = new MenuTreeVo();
            menuTreeVo.setId(menuTree.getMenuCode());
            menuTreeVo.setMenuName(menuTree.getMenuName());
            menuTreeVo.setIcon(menuTree.getIcon());
            menuTreeVo.setUrl(menuTree.getUrl());
            menuTreeVo.setMenuStyle(menuTree.getMenuStyle());

            List<MenuTree> tList = menuTree.getChildren();
            if (tList != null && tList.size() > 0) {
                List<MenuTreeVo> voList = new ArrayList<>();
                menuTreeVo.setChildren(voList);

                initMenuTreeVoList(voList, tList);
            }

            menuTreeVoList.add(menuTreeVo);
        }
    }
}

class ReturnMenuBean {

    private List<MenuTreeVo> message;

    public List<MenuTreeVo> getMessage() {
        return message;
    }

    public void setMessage(List<MenuTreeVo> message) {
        this.message = message;
    }

}

class MenuTreeVo {

    // 菜单代码
    private String           id;

    // 菜单名称
    private String           menuName;

    // 菜单地址
    private String           url;

    // 菜单图标
    private String           icon;

    // 菜单样式
    private String           menuStyle;

    // 子菜单
    private List<MenuTreeVo> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getMenuStyle() {
        return menuStyle;
    }

    public void setMenuStyle(String menuStyle) {
        this.menuStyle = menuStyle;
    }

    public List<MenuTreeVo> getChildren() {
        return children;
    }

    public void setChildren(List<MenuTreeVo> children) {
        this.children = children;
    }

}
