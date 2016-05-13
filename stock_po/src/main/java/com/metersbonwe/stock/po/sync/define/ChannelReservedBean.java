package com.metersbonwe.stock.po.sync.define;

/**
 * @author sky
 * @version V1.0
 * @description 渠道预留bean
 * @date 2016/3/18
 */
public class ChannelReservedBean {

    private String warehId;

    private String prodId;

    private String channelCode;

    private int    reservedStock;

    private String safeType;

    private int    safeStock;

    private int srcReservedStock;

    private int allocatedQty;

    private int lockedQty;

    private String reservedType;

    public String getReservedType() {
        return reservedType;
    }

    public void setReservedType(String reservedType) {
        this.reservedType = reservedType;
    }

    public int getSrcReservedStock() {
        return srcReservedStock;
    }

    public void setSrcReservedStock(int srcReservedStock) {
        this.srcReservedStock = srcReservedStock;
    }

    public int getAllocatedQty() {
        return allocatedQty;
    }

    public void setAllocatedQty(int allocatedQty) {
        this.allocatedQty = allocatedQty;
    }

    public int getLockedQty() {
        return lockedQty;
    }

    public void setLockedQty(int lockedQty) {
        this.lockedQty = lockedQty;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public int getReservedStock() {
        return reservedStock;
    }

    public void setReservedStock(int reservedStock) {
        this.reservedStock = reservedStock;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getSafeType() {
        return safeType;
    }

    public void setSafeType(String safeType) {
        this.safeType = safeType;
    }

    public int getSafeStock() {
        return safeStock;
    }

    public void setSafeStock(int safeStock) {
        this.safeStock = safeStock;
    }

    public String getWarehId() {
        return warehId;
    }

    public void setWarehId(String warehId) {
        this.warehId = warehId;
    }
}
