package com.metersbonwe.stock.biz.manager.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import com.metersbonwe.stock.po.core.StockPreSale;
import com.metersbonwe.stock.po.core.StockPreSaleDetail;
import com.metersbonwe.stock.pojo.StockPreSaleResultBean;

public interface StockPreSaleService {

    /**
     * TODO 保存商品预售
     * 
     * @param masterBean
     * @param detailBeanList
     * @return
     */
    StockPreSaleResultBean insertStockPreSale(StockPreSale masterBean, List<StockPreSaleDetail> detailBeanList) throws Exception;

    /**
     * TODO 修改商品预售
     * 
     * @param masterBean
     * @param detailBeanList
     * @return
     */
    StockPreSaleResultBean updateStockPreSale(StockPreSale masterBean, List<StockPreSaleDetail> detailBeanList) throws Exception;

    /**
     * TODO 删除商品预售
     * 
     * @param masterBean
     * @return
     */
    StockPreSaleResultBean deleteStockPreSale(StockPreSale masterBean);

    /**
     * TODO 审批商品预售
     * 
     * @param masterBean
     * @return
     */
    StockPreSaleResultBean submitFlowStockPreSale(StockPreSale masterBean);

    /**
     * TODO 撤销商品预售
     * 
     * @param masterBean
     * @return
     */
    StockPreSaleResultBean cancelFlowStockPreSale(StockPreSale masterBean);

    /**
     * TODO 修改商品预售
     * 
     * @param masterBean
     * @return
     */
    StockPreSaleResultBean updateStockPreSale(StockPreSale masterBean) throws Exception;

    /**
     * TODO 根据预售主表id查询预售主表信息
     * 
     * @param id
     * @return
     */
    StockPreSale getStockPreSale(long id);

    /**
     * TODO 根据预售主表id查询预售明细信息
     * 
     * @param relationId
     * @return
     */
    List<StockPreSaleDetail> getStockPreSaleDetailList(long relationId);

    /**
     * TODO 查询所有预售主表信息
     * 
     * @return
     */
    List<StockPreSale> getStockPreSaleList();

    /**
     * @description 查询预售主表信息
     * @param paraListMap
     *            参数Map
     * @return 预售主表信息集合
     */
    List<StockPreSale> selectPreSale(Map<String, List<String>> paraListMap);

    /**
     * @description 根据预售主表ID查询其详细信息
     * @param paraListMap
     *            参数Map
     * @return 详细信息集合
     */
    List<StockPreSaleDetail> selectPreSaleDetail(Map<String, List<String>> paraListMap);

    /**
     * @description 添加预售信息
     * @param vo
     *            预售信息
     * @return 插入的记录的主键
     */
    long addPreSale(StockPreSale vo);

    /**
     * @description 添加预售明细
     * @param paramMap
     *            参数Map
     * @return 插入的记录数
     */
    int addPreSaleDetail(Map<String, String> paramMap) throws Exception;

    /**
     * @description 添加明细的时候，获取这个sku是否已经存在，获取这个存在的值
     * @param paraListMap
     *            参数列表
     * @return 明细记录集合
     */
    List<StockPreSaleDetail> getExistPreSaleDetail(Map<String, List<String>> paraListMap);

    /**
     * @description 更新预售明细
     * @param vo
     *            参数列表
     * @return 明细记录集合
     */
    int updatePreSaleDetail(Map<String, String> paramMap) throws InvocationTargetException, IllegalAccessException;

    int deletePreSaleDetail(Map<String, String> paramMap) throws InvocationTargetException, IllegalAccessException;

    String uploadPreSaleDetail(List<String> fileStrs, long repationId) throws InterruptedException;

    int updatePreSale(Map<String, String> paraMap);
}
