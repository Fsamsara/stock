package com.metersbonwe.stock.biz.api.query;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.metersbonwe.stock.biz.common.service.FreeShareReservedLockedStockService;
import com.metersbonwe.stock.biz.common.service.MultiTableService;
import com.metersbonwe.stock.biz.common.service.PosAlloctSumQueryStockService;
import com.metersbonwe.stock.biz.common.service.QueryStockWarehProdService;
import com.metersbonwe.stock.facade.api.UniformQueryStockFacade;
import com.metersbonwe.stock.facade.api.bean.QryFreeShareStock;
import com.metersbonwe.stock.facade.api.bean.QryFreeShareStockReq;
import com.metersbonwe.stock.facade.api.bean.QryFreeShareStockRes;
import com.metersbonwe.stock.facade.api.bean.QryLockStock;
import com.metersbonwe.stock.facade.api.bean.QryLockStockReq;
import com.metersbonwe.stock.facade.api.bean.QryLockStockRes;
import com.metersbonwe.stock.facade.api.bean.QryProdSumStockRes;
import com.metersbonwe.stock.facade.api.bean.QryReservedStock;
import com.metersbonwe.stock.facade.api.bean.QryReservedStockReq;
import com.metersbonwe.stock.facade.api.bean.QryReservedStockRes;
import com.metersbonwe.stock.facade.api.bean.QryStock;
import com.metersbonwe.stock.facade.api.bean.QryStockReq;
import com.metersbonwe.stock.facade.api.bean.QryUsefulStkStock;
import com.metersbonwe.stock.facade.api.bean.QryUsefulStkStockReq;
import com.metersbonwe.stock.facade.api.bean.QryUsefulStkStockRes;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockWarehProd;
import com.metersbonwe.stock.po.sync.UrUnitReservedResult;
import com.metersbonwe.stock.pojo.QryLockStockResultBean;
import com.metersbonwe.stock.pojo.QueryStockAllParamBean;
import com.metersbonwe.stock.pojo.QueryStockResultBean;

@Service public class UniformQueryStockFacadeImpl implements UniformQueryStockFacade {

    private static StockLog                               stockLog = StockLogFactory.getLogger(UniformQueryStockFacadeImpl.class);

    @Resource private QueryStockWarehProdService          queryStockWarehProdServiceImpl;

    @Resource private FreeShareReservedLockedStockService freeShareReservedLockedStockServiceImpl;

    @Resource private MultiTableService                   multiTableServiceImpl;

    @Resource private PosAlloctSumQueryStockService       posAlloctSumQueryStockServiceImpl;

    /**
     * TODO 仓库、门店自由量查询 【自动分配使用】
     * 
     * @see com.metersbonwe.stock.facade.api.UniformQueryStockFacade#queryFreeShareStock(com.metersbonwe.stock.facade.api.bean.QryFreeShareStockReq)
     */
    public QryFreeShareStockRes queryFreeShareStock(QryFreeShareStockReq req) {
        QryFreeShareStockRes qryFreeShareStockRes = new QryFreeShareStockRes();
        qryFreeShareStockRes.setSucessed(false);
        if (req == null) {
            stockLog.warn("queryFreeShareStock传入的参数无效");
            qryFreeShareStockRes.setMsg("传入的参数无效");
            return qryFreeShareStockRes;
        }

        stockLog.info("queryFreeShareStock传入的参数为:" + req.toString());
        String channelSource = req.getChannelSource();
        if (null == channelSource || "".equals(channelSource)) {
            stockLog.warn("queryFreeShareStock传入的参数渠道数据源无效," + req.toString());
            qryFreeShareStockRes.setMsg("传入的参数渠道数据源无效");
            return qryFreeShareStockRes;
        }
        List<String> warehList = req.getWarehList();
        if (null == warehList || warehList.size() <= 0) {
            stockLog.warn("queryFreeShareStock传入的参数仓库编码无效," + req.toString());
            qryFreeShareStockRes.setMsg("传入的参数仓库编码无效");
            return qryFreeShareStockRes;
        }

        List<String> skuList = req.getSkuList();
        if (null == skuList || skuList.size() <= 0) {
            stockLog.warn("queryFreeShareStock传入的参数商品编码无效," + req.toString());
            qryFreeShareStockRes.setMsg("传入的参数商品编码无效");
            return qryFreeShareStockRes;
        }

        List<StockWarehProd> stockWarehProdList = this.queryStockWarehProdServiceImpl.selectStockWarehProdListByOthers(
                channelSource,
                warehList,
                skuList);
        if (stockWarehProdList == null || stockWarehProdList.size() <= 0) {
            stockLog.warn("queryFreeShareStockge根据传入的参数[" + req.toString() + "]没有查询到记录");
            qryFreeShareStockRes.setMsg("根据传入的参数[" + req.toString() + "]没有查询到记录");
            return qryFreeShareStockRes;
        }

        List<QryFreeShareStock> qryFreeShareStockList = new ArrayList<QryFreeShareStock>();
        for (StockWarehProd stockWarehProd : stockWarehProdList) {
            QryFreeShareStock qryFreeShareStock = new QryFreeShareStock();
            qryFreeShareStock.setWarehId(stockWarehProd.getWarehId());
            qryFreeShareStock.setProdId(stockWarehProd.getProdId());
            qryFreeShareStock.setFreeShareStock(stockWarehProd.getFreeShareStock()); //自由量
            qryFreeShareStock.setFinalFreeShareStock(stockWarehProd.getFinalFreeShareStock()); //最终自由量
            qryFreeShareStock.setWmsStock(stockWarehProd.getWmsStock());
            qryFreeShareStock.setOnlineSafeStock(stockWarehProd.getOnlineSafeStock());
            qryFreeShareStockList.add(qryFreeShareStock);
        }
        qryFreeShareStockRes.setSucessed(true);
        qryFreeShareStockRes.setQryFreeShareStockList(qryFreeShareStockList);

        return qryFreeShareStockRes;
    }

    /**
     * TODO 预留量查询 【自动分配使用】
     * 
     * @see com.metersbonwe.stock.facade.api.UniformQueryStockFacade#queryReservedStock(com.metersbonwe.stock.facade.api.bean.QryReservedStockReq)
     */
    public QryReservedStockRes queryReservedStock(QryReservedStockReq req) {

        QryReservedStockRes qryReservedStockRes = new QryReservedStockRes();
        qryReservedStockRes.setSucessed(false);
        if (req == null) {
            stockLog.warn("queryReservedStock传入的参数无效");
            qryReservedStockRes.setMsg("传入的参数无效");
            return qryReservedStockRes;
        }

        stockLog.info("queryReservedStock传入的参数为:" + req.toString());
        List<String> channelCodeList = req.getChannelCodeList();
        if (null == channelCodeList || channelCodeList.size() <= 0) {
            stockLog.warn("queryReservedStock传入的渠道编码无效," + req.toString());
            qryReservedStockRes.setMsg("传入的渠道编码无效");
            return qryReservedStockRes;
        }
        List<String> reservedTypeList = req.getReservedTypeList();
        if (null == reservedTypeList || reservedTypeList.size() <= 0) {
            stockLog.warn("queryReservedStock传入的预留类型无效," + req.toString());
            qryReservedStockRes.setMsg("传入的预留类型无效");
            return qryReservedStockRes;
        }
        if (null == req.getWarehList() || req.getWarehList().size() <= 0) {
            stockLog.warn("queryReservedStock传入的仓库编码无效," + req.toString());
            qryReservedStockRes.setMsg("传入的仓库编码无效");
            return qryReservedStockRes;
        }
        if (null == req.getSkuList() || req.getSkuList().size() <= 0) {
            stockLog.warn("queryReservedStock传入的商品编码无效," + req.toString());
            qryReservedStockRes.setMsg("传入的商品编码无效");
            return qryReservedStockRes;
        }

        //查询预留量
        List<UrUnitReservedResult> urUnitReservedResultList = this.freeShareReservedLockedStockServiceImpl.getUnitReserved(
                channelCodeList,
                reservedTypeList,
                req.getWarehList(),
                req.getSkuList());

        if (urUnitReservedResultList == null || urUnitReservedResultList.size() <= 0) {
            stockLog.warn("queryReservedStock根据传入的参数[" + req.toString() + "]没有查询到记录");
            qryReservedStockRes.setMsg("根据传入的参数[" + req.toString() + "]没有查询到记录");
            return qryReservedStockRes;
        }

        List<QryReservedStock> qryReservedStockList = new ArrayList<QryReservedStock>();
        for (UrUnitReservedResult urUnitReservedResult : urUnitReservedResultList) {
            QryReservedStock qryReservedStock = new QryReservedStock();
            qryReservedStock.setChannel_code(urUnitReservedResult.getUnitId());
            qryReservedStock.setReservedType(urUnitReservedResult.getReservedType());
            qryReservedStock.setProd_id(urUnitReservedResult.getProdId());
            qryReservedStock.setStock(urUnitReservedResult.getReservedQty());
            qryReservedStockList.add(qryReservedStock);
        }
        qryReservedStockRes.setSucessed(true);
        qryReservedStockRes.setQryReservedStockList(qryReservedStockList);

        return qryReservedStockRes;
    }

    /**
     * TODO 锁定量查询 【自动分配使用】
     * 
     * @see com.metersbonwe.stock.facade.api.UniformQueryStockFacade#queryLockStock(com.metersbonwe.stock.facade.api.bean.QryLockStockReq)
     */
    public QryLockStockRes queryLockStock(QryLockStockReq req) {
        QryLockStockRes qryLockStockRes = new QryLockStockRes();
        qryLockStockRes.setSucessed(false);
        if (req == null) {
            stockLog.warn("queryLockStock传入的参数无效");
            qryLockStockRes.setMsg("传入的参数无效");
            return qryLockStockRes;
        }
        stockLog.info("queryLockStock传入的参数为:" + req.toString());

        if (null == req.getReservedTypeList() || req.getReservedTypeList().size() <= 0) {
            stockLog.warn("queryLockStock传入的预留类型无效," + req.toString());
            qryLockStockRes.setMsg("传入的预留类型无效");
            return qryLockStockRes;
        }
        if (null == req.getWarehList() || req.getWarehList().size() <= 0) {
            stockLog.warn("queryLockStock传入的仓库编码无效," + req.toString());
            qryLockStockRes.setMsg("传入的仓库编码无效");
            return qryLockStockRes;
        }
        if (null == req.getSkuList() || req.getSkuList().size() <= 0) {
            stockLog.warn("queryLockStock传入的商品编码无效," + req.toString());
            qryLockStockRes.setMsg("传入的商品编码无效");
            return qryLockStockRes;
        }

        //检查仓库是否支持统一库存平台
        List<String> warehList = req.getWarehList();
        List<QryLockStockResultBean> qryLockStockResultList = freeShareReservedLockedStockServiceImpl.getLockStock(
                req.getReservedTypeList(),
                warehList,
                req.getSkuList());

        List<QryLockStock> qryLockStockList = new ArrayList<QryLockStock>();
        for (QryLockStockResultBean qryLockStockResultBean : qryLockStockResultList) {
            QryLockStock bean = new QryLockStock();
            bean.setWarehId(qryLockStockResultBean.getWarehId());
            bean.setProdId(qryLockStockResultBean.getProdId());
            bean.setReservedType(qryLockStockResultBean.getReservedType());
            bean.setStock(qryLockStockResultBean.getStock());

            qryLockStockList.add(bean);
        }

        qryLockStockRes.setSucessed(true);
        qryLockStockRes.setQryLockStockList(qryLockStockList);
        return qryLockStockRes;
    }

    /**
     * TODO 参数有效性检查 TODO POS全流通库存查询、分配时查询库存（手工分单）传入的参数有效性检查
     * 
     * @param req
     * @return
     */
    private QryUsefulStkStockRes checkQueryStockParam(QryUsefulStkStockReq req) {
        QryUsefulStkStockRes qryUsefulStkStockRes = new QryUsefulStkStockRes();
        qryUsefulStkStockRes.setSucessed(true);

        if (req == null) {
            stockLog.warn("posAndAlloctQueryStock传入的参数无效");
            qryUsefulStkStockRes.setMsg("传入的参数无效");
            qryUsefulStkStockRes.setSucessed(false);
            return qryUsefulStkStockRes;
        }
        if (req.getChannelSource() == null || "".equals(req.getChannelSource())) {
            stockLog.warn("posAndAlloctQueryStock传入的渠道来源无效");
            qryUsefulStkStockRes.setMsg("传入的渠道来源无效");
            qryUsefulStkStockRes.setSucessed(false);
            return qryUsefulStkStockRes;
        }
        if (req.getChannelCode() == null || "".equals(req.getChannelCode())) {
            stockLog.warn("posAndAlloctQueryStock传入的渠道编码无效");
            qryUsefulStkStockRes.setMsg("传入的渠道编码无效");
            qryUsefulStkStockRes.setSucessed(false);
            return qryUsefulStkStockRes;
        }
        if (req.getSkuList() == null || req.getSkuList().size() <= 0) {
            stockLog.warn("posAndAlloctQueryStock传入的商品编码无效");
            qryUsefulStkStockRes.setMsg("传入的商品编码无效");
            qryUsefulStkStockRes.setSucessed(false);
            return qryUsefulStkStockRes;
        }
        stockLog.info("posAndAlloctQueryStock传入的参数为:" + req.toString());

        return qryUsefulStkStockRes;
    }

    /**
     * TODO 设置参数查询库存 TODO POS全流通、分配（手工分单）、全流通（总查询）共用查询入口
     * 
     * @param req
     * @param queryModule
     * @return
     */
    private List<QueryStockResultBean> passParamAndQueryStock(QryUsefulStkStockReq req, int queryModule) {
        //查询可用量、库存量
        QueryStockAllParamBean stockAllParam = new QueryStockAllParamBean();
        stockAllParam.setChannelSource(req.getChannelSource());
        stockAllParam.setChannelCode(req.getChannelCode());
        stockAllParam.setCounty(req.getCounty());
        stockAllParam.setProvince(req.getProvince());
        stockAllParam.setCity(req.getCity());
        stockAllParam.setDistrict(req.getDistrict());
        stockAllParam.setSkuList(req.getSkuList());
        stockAllParam.setExtWarehShopList(req.getExtWarehShopList());
        stockAllParam.setQueryModule(queryModule);
        List<QueryStockResultBean> queryStockResultList = this.posAlloctSumQueryStockServiceImpl.queryStock(stockAllParam);

        return queryStockResultList;
    }

    /**
     * TODO Bean转换 TODO 把QueryStockResultBean转换为QryUsefulStkStock
     * 
     * @param queryStockResultList
     * @return
     */
    private List<QryUsefulStkStock> QueryStockResultChangeToQryUsefulStkStock(List<QueryStockResultBean> queryStockResultList) {
        //Bean转换
        List<QryUsefulStkStock> qryUsefulStkStockList = new ArrayList<QryUsefulStkStock>();
        for (QueryStockResultBean queryStockResult : queryStockResultList) {
            QryUsefulStkStock qryUsefulStkStock = new QryUsefulStkStock();
            qryUsefulStkStock.setWarehShopId(queryStockResult.getWarehShopId());
            qryUsefulStkStock.setProdId(queryStockResult.getProdId());
            qryUsefulStkStock.setWarehShopType(queryStockResult.getWarehShopType());
            qryUsefulStkStock.setUsefulStock(queryStockResult.getUsefulStock());
            qryUsefulStkStock.setStkOnHand(queryStockResult.getStkOnHand());

            qryUsefulStkStockList.add(qryUsefulStkStock);
        }

        return qryUsefulStkStockList;
    }

    /**
     * TODO POS全流通库存查询 TODO POS全流通库存查询(根据商品编码汇总可用库存)
     * 
     * @param bean
     * @return
     */
    public QryProdSumStockRes posQueryStock(QryUsefulStkStockReq req) {

        QryProdSumStockRes qryProdSumStockRes = new QryProdSumStockRes();
        qryProdSumStockRes.setSucessed(false);

        //检查参数
        QryUsefulStkStockRes qryUsefulStkStockRes = checkQueryStockParam(req);
        if (qryUsefulStkStockRes.isSucessed() == false) {
            qryProdSumStockRes.setMsg(qryUsefulStkStockRes.getMsg());
            return qryProdSumStockRes;
        }

        //传入参数查询库存
        List<QueryStockResultBean> queryStockResultList = passParamAndQueryStock(req, 1);

        //汇总计算
        Map<String, QryStock> qryStockMap = new HashMap<String, QryStock>();
        List<QryStock> qryStockList = new ArrayList<QryStock>();
        for (QueryStockResultBean queryStockResult : queryStockResultList) {
            String prodId = queryStockResult.getProdId();
            BigDecimal usefulStock = queryStockResult.getUsefulStock();
            QryStock qryStock = null;
            if (qryStockMap.containsKey(prodId)) {
                qryStock = qryStockMap.get(prodId);
                BigDecimal t = qryStock.getUsefulStock();
                qryStock.setUsefulStock(BigDecimal.valueOf(t.longValue() + usefulStock.longValue()));
            } else {
                qryStock = new QryStock();
                qryStock.setProdId(prodId);
                qryStock.setUsefulStock(usefulStock);

                qryStockList.add(qryStock);

                qryStockMap.put(prodId, qryStock);
            }
        }

        qryProdSumStockRes.setQryStockList(qryStockList);
        qryProdSumStockRes.setSucessed(true);

        return qryProdSumStockRes;
    }

    /**
     * TODO 分配时查询库存（手工分单） TODO 分配时查询库存（手工分单）
     * 
     * @param bean
     * @return
     */
    public QryUsefulStkStockRes alloctQueryStock(QryUsefulStkStockReq req) {
        //检查参数
        QryUsefulStkStockRes qryUsefulStkStockRes = checkQueryStockParam(req);
        if (qryUsefulStkStockRes.isSucessed() == false) {
            return qryUsefulStkStockRes;
        }

        //传入参数查询库存
        List<QueryStockResultBean> queryStockResultList = passParamAndQueryStock(req, 2);

        //Bean转换
        List<QryUsefulStkStock> qryUsefulStkStockList = QueryStockResultChangeToQryUsefulStkStock(queryStockResultList);

        qryUsefulStkStockRes.setQryUsefulStkStockList(qryUsefulStkStockList);
        qryUsefulStkStockRes.setSucessed(true);
        return qryUsefulStkStockRes;
    }

    /**
     * TODO 全流通库存查询（总查询） TODO 全流通库存查询（总查询,只传入渠道编码和商品编码集合）
     * 
     * @param bean
     * @return
     */
    public QryUsefulStkStockRes sumQueryStock(QryStockReq req) {
        QryUsefulStkStockRes qryUsefulStkStockRes = new QryUsefulStkStockRes();
        qryUsefulStkStockRes.setSucessed(false);
        if (req == null) {
            stockLog.warn("posAndAlloctQueryStock传入的参数无效");
            qryUsefulStkStockRes.setMsg("传入的参数无效");
            return qryUsefulStkStockRes;
        }
        if (null == req.getChannelSource() || "".equals(req.getChannelSource())) {
            stockLog.warn("sumQueryStock传入的渠道来源无效," + req.toString());
            qryUsefulStkStockRes.setMsg("传入的渠道来源无效");
            return qryUsefulStkStockRes;
        }

        if (null == req.getSkuList() || req.getSkuList().size() <= 0) {
            stockLog.warn("sumQueryStock传入的商品编码无效," + req.toString());
            qryUsefulStkStockRes.setMsg("传入的商品编码无效");
            return qryUsefulStkStockRes;
        }

        //传入参数查询库存
        QryUsefulStkStockReq qryUsefulStkStockReq = new QryUsefulStkStockReq();
        qryUsefulStkStockReq.setChannelSource(req.getChannelSource());
        qryUsefulStkStockReq.setSkuList(req.getSkuList());
        List<QueryStockResultBean> queryStockResultList = passParamAndQueryStock(qryUsefulStkStockReq, 3);

        //Bean转换
        List<QryUsefulStkStock> qryUsefulStkStockList = QueryStockResultChangeToQryUsefulStkStock(queryStockResultList);

        qryUsefulStkStockRes.setQryUsefulStkStockList(qryUsefulStkStockList);
        qryUsefulStkStockRes.setSucessed(true);
        return qryUsefulStkStockRes;
    }

}
