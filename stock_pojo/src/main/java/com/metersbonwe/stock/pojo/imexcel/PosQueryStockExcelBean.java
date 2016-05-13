package com.metersbonwe.stock.pojo.imexcel;

import java.math.BigDecimal;

public class PosQueryStockExcelBean {

    @Header(value = "组织类型", order = 1) private String     warehShopType;

    @Header(value = "组织编码", order = 2) private String     warehShopId;

    @Header(value = "商品编码", order = 3) private String     prodId;

    @Header(value = "可用库存", order = 4) private BigDecimal usefulStock;

    public String getWarehShopId() {
        return warehShopId;
    }

    public void setWarehShopId(String warehShopId) {
        this.warehShopId = warehShopId;
    }

    public String getWarehShopType() {
        return warehShopType;
    }

    public void setWarehShopType(String warehShopType) {
        this.warehShopType = warehShopType;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public BigDecimal getUsefulStock() {
        return usefulStock;
    }

    public void setUsefulStock(BigDecimal usefulStock) {
        this.usefulStock = usefulStock;
    }

}
