package com.metersbonwe.stock.facade.api;

import com.metersbonwe.stock.facade.api.bean.QryFreeShareStockReq;
import com.metersbonwe.stock.facade.api.bean.QryFreeShareStockRes;
import com.metersbonwe.stock.facade.api.bean.QryLockStockReq;
import com.metersbonwe.stock.facade.api.bean.QryLockStockRes;
import com.metersbonwe.stock.facade.api.bean.QryProdSumStockRes;
import com.metersbonwe.stock.facade.api.bean.QryReservedStockReq;
import com.metersbonwe.stock.facade.api.bean.QryReservedStockRes;
import com.metersbonwe.stock.facade.api.bean.QryStockReq;
import com.metersbonwe.stock.facade.api.bean.QryUsefulStkStockReq;
import com.metersbonwe.stock.facade.api.bean.QryUsefulStkStockRes;

/**
 * @author 李映平
 *
 */
public interface UniformQueryStockFacade {
    
    /**
     * 
     * TODO 仓库、门店自由量查询
     * TODO 根据仓库编码/门店编码、多个商品编码查询自由量(如果不传skuList就查出整个仓的出来)
     * @param req {wareh_id:"",skuList:["",""]}
     * @return
     */
    public QryFreeShareStockRes queryFreeShareStock(QryFreeShareStockReq req);
    
    /**
     * 
     * TODO 预留量查询
     * TODO 根据渠道编码、预留类型、仓库编码集合、商品编码集合
     * @param qryReservedStockReq{channel_code:'',reservedType:'',warehList:['',...],skuList:['',...]}
     * @return
     */
    public QryReservedStockRes queryReservedStock(QryReservedStockReq qryReservedStockReq);
    
    /**
     * 
     * TODO 锁定量查询
     * TODO 根据预留类型集合、仓库编码集合、商品编码集合
     * @param qryReservedStockReq{reservedTypeList:['',...],warehList:['',...],skuList:['',...]}
     * @return
     */
    public QryLockStockRes queryLockStock(QryLockStockReq qryLockStockReq);
    
    /**
     * 
     * TODO POS全流通库存查询
     * TODO POS全流通库存查询(根据商品编码汇总可用库存)
     * @param bean
     * @return
     */
    public QryProdSumStockRes posQueryStock(QryUsefulStkStockReq req);
    
    /**
     * 
     * TODO 分配时查询库存（手工分单）
     * TODO 分配时查询库存（手工分单）
     * @param bean
     * @return
     */
    public QryUsefulStkStockRes alloctQueryStock(QryUsefulStkStockReq req);
    
    /**
     * 
     * TODO 全流通库存查询（总查询）
     * TODO 全流通库存查询（总查询,只传入渠道编码和商品编码集合）
     * @param bean
     * @return
     */
    public QryUsefulStkStockRes sumQueryStock(QryStockReq req);
    
}
