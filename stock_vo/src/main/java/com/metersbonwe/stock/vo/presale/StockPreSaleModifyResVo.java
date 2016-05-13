package com.metersbonwe.stock.vo.presale;

public class StockPreSaleModifyResVo {

    private boolean              sucess;

    private String               msg;

    private StockPreSaleModifyVo master;

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

    public StockPreSaleModifyVo getMaster() {
        return master;
    }

    public void setMaster(StockPreSaleModifyVo master) {
        this.master = master;
    }

}
