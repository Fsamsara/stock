package com.metersbonwe.stock.facade.api.bean;

import java.io.Serializable;

public class SkuStock implements Serializable {

    private static final long serialVersionUID = 1435201392412164221L;

    private String sku;
    private int stock;// 调用时提供需占用(释放)库存值
    private int allStock; // 返回给调用方，当前sku最新库存总值
    private int deductStock = 0; // 实际扣除的库存
    boolean opFlag = false;// 返回给调用方，说明是否调用成功 true:成功
    private String note_type;// 错误日志类型
    private String rmsg;// 当前sku的操作结果
    private String invoiceNO;// 发货单号

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getAllStock() {
        return allStock;
    }

    public void setAllStock(int allStock) {
        this.allStock = allStock;
    }

    public boolean validate() {
        return sku != null && sku.trim().length() > 0;
    }

    public boolean isOpFlag() {
        return opFlag;
    }

    public void setOpFlag(boolean opFlag) {
        this.opFlag = opFlag;
    }

    public int getDeductStock() {
        return deductStock;
    }

    public void setDeductStock(int deductStock) {
        this.deductStock = deductStock;
    }

    public String getNote_type() {
        return note_type;
    }

    public void setNote_type(String note_type) {
        this.note_type = note_type;
    }

    public String getRmsg() {
        return rmsg;
    }

    public void setRmsg(String rmsg) {
        this.rmsg = rmsg;
    }

    public String getInvoiceNO() {
        return invoiceNO;
    }

    public void setInvoiceNO(String invoiceNO) {
        this.invoiceNO = invoiceNO;
    }

}
