package com.metersbonwe.stock.biz.manager.service;

import java.util.List;
import java.util.Map;

import com.metersbonwe.stock.po.core.StockPreSaleModifiedDetail;
import com.metersbonwe.stock.po.core.StockPreSaleModify;
import com.metersbonwe.stock.po.core.StockPreSaleModifyDetail;
import com.metersbonwe.stock.pojo.StockPreSaleModifyResultBean;

public interface StockPreSaleModifyService {

    /**
     * TODO 保存商品预售调整单
     * 
     * @param masterBean
     * @return
     */
    StockPreSaleModifyResultBean insertStockPreSaleModify(StockPreSaleModify masterBean) throws Exception;

    /**
     * TODO 修改商品预售调整单
     * 
     * @param masterBean
     * @return
     * @throws Exception
     */
    StockPreSaleModifyResultBean updateStockPreSaleModify(StockPreSaleModify masterBean) throws Exception;

    /**
     * TODO 插入商品预售调整单明细
     * 
     * @param detailBean
     * @return
     * @throws Exception
     */
    int insertStockPreSaleModifyDetail(StockPreSaleModifyDetail detailBean) throws Exception;

    /**
     * TODO 修改商品预售调整单明细
     * 
     * @param detailBean
     * @return
     * @throws Exception
     */
    int updateStockPreSaleModifyDetail(StockPreSaleModifyDetail detailBean) throws Exception;

    /**
     * TODO 删除商品预售调整单明细
     * 
     * @param detailBean
     * @return
     * @throws Exception
     */
    int deleteStockPreSaleModifyDetail(StockPreSaleModifyDetail detailBean);

    /**
     * TODO 保存商品预售调整单和明细
     * 
     * @param masterBean
     * @param detailBeanList
     * @return
     */
    StockPreSaleModifyResultBean insertStockPreSaleModifyAndDtl(StockPreSaleModify masterBean, List<StockPreSaleModifyDetail> detailBeanList)
            throws Exception;

    /**
     * TODO 修改商品预售调整单和明细
     * 
     * @param masterBean
     * @param detailBeanList
     * @return
     */
    StockPreSaleModifyResultBean updateStockPreSaleModifyAndDtl(StockPreSaleModify masterBean, List<StockPreSaleModifyDetail> detailBeanList)
            throws Exception;

    /**
     * TODO 删除商品预售调整单和明细
     * 
     * @param masterBean
     * @return
     */
    StockPreSaleModifyResultBean deleteStockPreSaleModify(StockPreSaleModify masterBean);

    /**
     * TODO 审批商品预售调整单
     * 
     * @param masterBean
     * @return
     */
    StockPreSaleModifyResultBean submitFlowStockPreSaleModify(StockPreSaleModify masterBean);

    /**
     * TODO 根据预售主表id查询预售主表信息
     * 
     * @param id
     * @return
     */
    StockPreSaleModify getStockPreSaleModify(long id);

    /**
     * TODO 根据预售主表id查询预售明细信息
     * 
     * @param relationId
     * @return
     */
    List<StockPreSaleModifyDetail> getStockPreSaleModifyDetailList(long relationId);

    /**
     * TODO 查询所有预售主表信息
     * 
     * @return
     */
    List<StockPreSaleModify> getStockPreSaleModifyList();

    /**
     * TODO 根据渠道编码、调整类型等条件来查询所有预售主表信息
     * 
     * @return
     */
    List<StockPreSaleModify> selectPreSaleModifyList(Map<String, List<String>> paraListMap);

    /**
     * TODO 根据预售调整单id、商品编码、仓库编码、调整结束日期等条件来查询所有预售调整明细信息
     * 
     * @param paraListMap
     * @return
     */
    List<StockPreSaleModifyDetail> selectStockPreSaleModifyDetailList(Map<String, List<String>> paraListMap);

    /**
     * TODO 根据预售单id、商品编码、仓库编码等条件来查询所有预售修改后明细信息
     * 
     * @param paraListMap
     * @return
     */
    List<StockPreSaleModifiedDetail> selectStockPreSaleModifiedDetailList(Map<String, List<String>> paraListMap);

    /**
     * TODO 上传数据
     * 
     * @param fileStrs
     * @param relationId
     * @return
     */
    String uploadPreSaleModifyDetail(StockPreSaleModify stockPreSaleModify, List<String> fileStrs);

    /**
     * TODO 保存导入的明细数据
     * 
     * @param preSaleModifyDetailInsertList
     * @param preSaleModifyDetailUpdateList
     * @return
     */
    String saveImportStockPreSaleModifyDetailData(List<StockPreSaleModifyDetail> preSaleModifyDetailInsertList,
            List<StockPreSaleModifyDetail> preSaleModifyDetailUpdateList);

}
