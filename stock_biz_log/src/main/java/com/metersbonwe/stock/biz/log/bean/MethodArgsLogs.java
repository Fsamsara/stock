package com.metersbonwe.stock.biz.log.bean;

import java.util.Date;

public class MethodArgsLogs {

    private Integer id;

    private String servicename;

    private String classname;

    private String methodname;

    private String channelcode;

    private String warehid;

    private String prodid;

    private String ip;

    private Date updatetime;

    private Date createtime;

    private Date logtime;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getMethodname() {
        return methodname;
    }

    public void setMethodname(String methodname) {
        this.methodname = methodname;
    }

    public String getChannelcode() {
        return channelcode;
    }

    public void setChannelcode(String channelcode) {
        this.channelcode = channelcode;
    }

    public String getWarehid() {
        return warehid;
    }

    public void setWarehid(String warehid) {
        this.warehid = warehid;
    }

    public String getProdid() {
        return prodid;
    }

    public void setProdid(String prodid) {
        this.prodid = prodid;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getLogtime() {
        return logtime;
    }

    public void setLogtime(Date logtime) {
        this.logtime = logtime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "MethodArgsLogs [id=" + id + ", servicename=" + servicename + ", classname=" + classname + ", methodname=" + methodname
                + ", channelcode=" + channelcode + ", warehid=" + warehid + ", prodid=" + prodid + ", ip=" + ip + ", updatetime=" + updatetime
                + ", createtime=" + createtime + ", logtime=" + logtime + ", content=" + content + "]";
    }

    

}
