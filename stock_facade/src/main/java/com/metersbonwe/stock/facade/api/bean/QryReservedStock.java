package com.metersbonwe.stock.facade.api.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class QryReservedStock implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -6079431933079549344L;
    private String channel_code;    //渠道编码
    private String reservedType;    //预留类型
    private String wareh_id;        //仓库编码
    private String prod_id;         //商品编码
    private BigDecimal stock;           //预留量
    public String getChannel_code() {
        return channel_code;
    }
    public void setChannel_code(String channel_code) {
        this.channel_code = channel_code;
    }
    public String getReservedType() {
        return reservedType;
    }
    public void setReservedType(String reservedType) {
        this.reservedType = reservedType;
    }
    public String getWareh_id() {
        return wareh_id;
    }
    public void setWareh_id(String wareh_id) {
        this.wareh_id = wareh_id;
    }
    public String getProd_id() {
        return prod_id;
    }
    public void setProd_id(String prod_id) {
        this.prod_id = prod_id;
    }
    public BigDecimal getStock() {
        return stock;
    }
    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }
    
}
