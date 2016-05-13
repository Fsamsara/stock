package com.metersbonwe.stock.dal.define.sync.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface FullStockSyncDefineMapper {
    /**
     * 查询新ERP自由量数据
     * 
     * @param begin
     * @param end
     * @return
     */
    List<Map<String, Object>> selectFreeStockNERP(@Param("begin") Integer begin, @Param("end") Integer end);

    /**
     * 查询新ERP自由量总量
     * 
     * @return
     */
    int countFreeStockNERP();

    /**
     * 查询老ERP自由量数据
     * 
     * @param begin
     * @param end
     * @return
     */
    List<Map<String, Object>> selectFreeStockOERP(@Param("begin") Integer begin, @Param("end") Integer end);

    /**
     * 查询老ERP自由量总量
     * 
     * @return
     */
    int countFreeStockOERP();

    /**
     * 查询新ERP锁定量数据
     * 
     * @param begin
     * @param end
     * @return
     */
    List<Map<String, Object>> selectLockStockNERP(@Param("begin") Integer begin, @Param("end") Integer end);

    /**
     * 查询新ERP锁定总记录数量
     * 
     * @return
     */
    int countLockStockNERP();

    /**
     * 查询老ERP锁定量数据
     * 
     * @param begin
     * @param end
     * @return
     */
    List<Map<String, Object>> selectLockStockOERP(@Param("begin") Integer begin, @Param("end") Integer end);

    /**
     * 查询老ERP锁定总记录数量
     * 
     * @return
     */
    int countLockStockOERP();

    /**
     * 查询预留结果数据
     * 
     * @param begin
     * @param end
     * @return
     */
    List<Map<String, Object>> selectReservedStock(@Param("begin") Integer begin, @Param("end") Integer end);

    /**
     * 查询预留结果总量
     * 
     * @return
     */
    int countReservedStock();

}
