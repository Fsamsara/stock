package com.metersbonwe.stock.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 变化信息对象
 * @author TanYibin
 */
public class ChangeQtyInfoBean {
    
    private BigDecimal startId;
    
    /** 非业务主键 */
    private BigDecimal id;

    /** 仓库编码 */
    private String warehId;

    /** 商品编码 */
    private String prodId;
    
    /** 自由量 */
    private Integer freeStock;
    
    /** 实际库存 */
    private Integer stkOnHand;
    
    /** 已分配量 */
    private Integer qtyCommitted;
    
    /** 数据源 */
    private String dataSource;
    
    /** 仓库编码 */
    private String warehCode;
    
    /** 商品编码 */
    private String prodCode;

    /** 序列化锁对象 */
    private StringBuffer serializeLock;
    
    /** 自由量变化次数 */
    private Integer freeChangedCount;
    
    /** 锁定量 */
    private Integer lockedStock;
    
    /** 门店未日结量 */
    private Integer remailStock;
    
    /** 门店污损值 */
    private Integer dameStock;
    
    /** 门店安全库存*/
    private Integer shopSafeStock;
    
    /** 货位*/
    private String locId;

    /** 渠道编码 */
    private String channelCode;
    
    /** 是否删除全部记录 */
    private Character deleteAll;
    
    /** 未日结小票号*/
    private String rllNum;
    
    /**更新时间*/
    private Date updateTime;
    
    /**更新人*/
    private String updateBy;
    
    /**创建时间*/
    private Date createTime;
    
    /**创建人*/
    private String createBy;

    public StringBuffer getSerializeLock() {
        return serializeLock;
    }

    public void setSerializeLock(StringBuffer serializeLock) {
        this.serializeLock = serializeLock;
    }

    public String getWarehCode() {
        return warehCode;
    }

    public void setWarehCode(String warehCode) {
        this.warehCode = warehCode;
    }

    public String getProdCode() {
        return prodCode;
    }

    public void setProdCode(String prodCode) {
        this.prodCode = prodCode;
    }

    public Integer getFreeChangedCount() {
        return freeChangedCount;
    }

    public void setFreeChangedCount(Integer freeChangedCount) {
        this.freeChangedCount = freeChangedCount;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public Integer getRemailStock() {
        return remailStock;
    }

    public void setRemailStock(Integer remailStock) {
        this.remailStock = remailStock;
    }

    public Integer getDameStock() {
        return dameStock;
    }

    public void setDameStock(Integer dameStock) {
        this.dameStock = dameStock;
    }

    public Integer getShopSafeStock() {
        return shopSafeStock;
    }

    public void setShopSafeStock(Integer shopSafeStock) {
        this.shopSafeStock = shopSafeStock;
    }

    public Integer getLockedStock() {
        return lockedStock;
    }

    public void setLockedStock(Integer lockedStock) {
        this.lockedStock = lockedStock;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

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

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public Integer getFreeStock() {
        return freeStock;
    }

    public void setFreeStock(Integer freeStock) {
        this.freeStock = freeStock;
    }

    public Integer getStkOnHand() {
        return stkOnHand;
    }

    public void setStkOnHand(Integer stkOnHand) {
        this.stkOnHand = stkOnHand;
    }

    public Integer getQtyCommitted() {
        return qtyCommitted;
    }

    public void setQtyCommitted(Integer qtyCommitted) {
        this.qtyCommitted = qtyCommitted;
    }

    public Character getDeleteAll() {
        return deleteAll;
    }

    public void setDeleteAll(Character deleteAll) {
        this.deleteAll = deleteAll;
    }

    public BigDecimal getStartId() {
        return startId;
    }

    public void setStartId(BigDecimal startId) {
        this.startId = startId;
    }

    public String getLocId() {
        return locId;
    }

    public void setLocId(String locId) {
        this.locId = locId;
    }

    public String getRllNum() {
        return rllNum;
    }

    public void setRllNum(String rllNum) {
        this.rllNum = rllNum;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
}
