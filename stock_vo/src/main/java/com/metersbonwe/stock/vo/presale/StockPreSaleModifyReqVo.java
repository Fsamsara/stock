package com.metersbonwe.stock.vo.presale;

import java.util.List;

public class StockPreSaleModifyReqVo {

    private StockPreSaleModifyVo             master;

    private List<StockPreSaleModifyDetailVo> detailList;

    public StockPreSaleModifyVo getMaster() {
        return master;
    }

    public void setMaster(StockPreSaleModifyVo master) {
        this.master = master;
    }

    public List<StockPreSaleModifyDetailVo> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<StockPreSaleModifyDetailVo> detailList) {
        this.detailList = detailList;
    }

}
