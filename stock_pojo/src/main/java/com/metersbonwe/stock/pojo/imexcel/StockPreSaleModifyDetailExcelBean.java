package com.metersbonwe.stock.pojo.imexcel;

import java.util.Date;

public class StockPreSaleModifyDetailExcelBean {
    @Header(value = "仓库编码", order = 1) private String     warehId;

    @Header(value = "商品编码", order = 2) private String     prodId;

    @Header(value = "预售数量", order = 3) private Integer    prePrivateStock;

    @Header(value = "调整后预售数量", order = 4) private Integer prePrivateStockModify;

    @Header(value = "开始时间", order = 5) private Date       startTime;

    @Header(value = "结束时间", order = 6) private Date       endTime;

    @Header(value = "调整后结束日期", order = 7) private Date    endTimeModify;

    public String getWarehId() {
        return warehId;
    }

    public void setWarehId(String warehId) {
        this.warehId = warehId;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public Integer getPrePrivateStock() {
        return prePrivateStock;
    }

    public void setPrePrivateStock(Integer prePrivateStock) {
        this.prePrivateStock = prePrivateStock;
    }

    public Integer getPrePrivateStockModify() {
        return prePrivateStockModify;
    }

    public void setPrePrivateStockModify(Integer prePrivateStockModify) {
        this.prePrivateStockModify = prePrivateStockModify;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getEndTimeModify() {
        return endTimeModify;
    }

    public void setEndTimeModify(Date endTimeModify) {
        this.endTimeModify = endTimeModify;
    }

}
