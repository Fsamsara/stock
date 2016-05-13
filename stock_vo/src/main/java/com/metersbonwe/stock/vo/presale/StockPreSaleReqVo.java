package com.metersbonwe.stock.vo.presale;

import java.util.List;

public class StockPreSaleReqVo {

    private StockPreSaleVo             master;

    private List<StockPreSaleDetailVo> detailList;

    public StockPreSaleVo getMaster() {
        return master;
    }

    public void setMaster(StockPreSaleVo master) {
        this.master = master;
    }

    public List<StockPreSaleDetailVo> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<StockPreSaleDetailVo> detailList) {
        this.detailList = detailList;
    }

}
