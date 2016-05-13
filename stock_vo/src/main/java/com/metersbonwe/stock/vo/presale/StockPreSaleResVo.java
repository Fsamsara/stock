package com.metersbonwe.stock.vo.presale;

public class StockPreSaleResVo {

    private boolean        sucess;

    private String         msg;

    private StockPreSaleVo master;

    public boolean isSucess() {
        return sucess;
    }

    public void setSucess(boolean sucess) {
        this.sucess = sucess;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public StockPreSaleVo getMaster() {
        return master;
    }

    public void setMaster(StockPreSaleVo master) {
        this.master = master;
    }

}
