package com.metersbonwe.stock.vo.safe;

import java.util.List;

public class SafeStockReqVo {
    private String       warehId;

    private List<String> skuList;

    private int          pageNo;

    private int          pageSize;

    public String getWarehId() {
        return warehId;
    }

    public void setWarehId(String warehId) {
        this.warehId = warehId;
    }

    public List<String> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<String> skuList) {
        this.skuList = skuList;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "SafeStockReqVo [warehId=" + warehId + ", skuList=" + skuList + ", pageNo=" + pageNo + ", pageSize=" + pageSize + "]";
    }

}
