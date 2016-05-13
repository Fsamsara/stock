package com.metersbonwe.stock.controller.power;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.metersbonwe.stock.biz.manager.service.StockUserService;
import com.metersbonwe.stock.controller.BaseController;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockUser;

@Controller public class LoginController extends BaseController {

    private static StockLog            stockLog = StockLogFactory.getLogger(LoginController.class);

    @Resource private StockUserService stockUserServiceImpl;

    @ResponseBody
    @RequestMapping(value = "/user/register")
    public String register(@RequestBody Map<String, String> params) {
        int id = 0;
        String errCode = null;
        try {
            stockLog.debug("总共获取到：" + params.size() + "个参数");
            String userName = params.get("userName");
            String nickName = params.get("nickName");
            String phoneNO = params.get("phoneNO");
            String password = params.get("password");
            String email = params.get("email");

            StockUser stockUser = new StockUser();
            stockUser.setUsername(userName);
            stockUser.setNickname(nickName);
            stockUser.setPhoneno(phoneNO);
            stockUser.setPassword(password);
            stockUser.setEmail(email);
            stockUser.setCreateTime(new Date());

            id = stockUserServiceImpl.insertStockUser(stockUser);
        } catch (Exception e) {
            stockLog.error(e.getMessage(), e);
        }
        return assembleUnSelectResult(id, errCode);
    }

    @ResponseBody
    @RequestMapping(value = "/user/login")
    public String login(HttpServletRequest request) {
        String errCode = null;
        try {
            Map<String, String> params = assembleSelectParam(request);
            stockLog.debug("总共获取到：" + params.size() + "个参数");
            String userName = params.get("userName");
            String password = params.get("password");
            errCode = stockUserServiceImpl.checkUser(userName, password);
            if ("".equals(errCode)) {
                UserBean stockUser = new UserBean();
                stockUser.setUserName(userName);
                stockUser.setPassword(password);
                String jsonString = JSON.toJSONString(stockUser);
                return assembleUnSelectResult(1, jsonString);
            }
        } catch (Exception e) {
            stockLog.error(e.getMessage(), e);
        }
        return assembleUnSelectResult(0, errCode);
    }

    @ResponseBody
    @RequestMapping(value = "/user/getMenu")
    public String getMenuByUserName(HttpServletRequest request) {
        String jsonData = "";
        try {
            Map<String, String> params = assembleSelectParam(request);
            stockLog.debug("总共获取到：" + params.size() + "个参数");
            String userName = params.get("userName");

            jsonData = stockUserServiceImpl.getMenuByUserName(userName);
        } catch (Exception e) {
            stockLog.error(e.getMessage(), e);
        }
        return jsonData;
    }

}

class UserBean {

    private String userName;

    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

class ReturnMessageBean {

    private String   status;

    private UserBean message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserBean getMessage() {
        return message;
    }

    public void setMessage(UserBean message) {
        this.message = message;
    }

}
