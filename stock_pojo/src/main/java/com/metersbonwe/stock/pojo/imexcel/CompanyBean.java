package com.metersbonwe.stock.pojo.imexcel;

import java.util.Date;

public class CompanyBean {

    @Header(value = "公司ID", order = 1) private int     companyId;

    @Header(value = "公司编码", order = 2) private String  member;

    @Header(value = "公司名称", order = 3) private String  companyName;

    @Header(value = "序号", order = 4) private long      order;

    @Header(value = "是否男性", order = 5) private boolean sex;

    @Header(value = "创建时间", order = 6) private Date    createDate;

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public long getOrder() {
        return order;
    }

    public void setOrder(long order) {
        this.order = order;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

}
