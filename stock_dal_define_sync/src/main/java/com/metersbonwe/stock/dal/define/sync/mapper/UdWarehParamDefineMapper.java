package com.metersbonwe.stock.dal.define.sync.mapper;

import java.util.List;
import java.util.Map;

import com.metersbonwe.stock.po.sync.define.UdWarehParamDefine;

/**
 * @author zhangjf
 */
public interface UdWarehParamDefineMapper {
    /**
     * 获取参与B2C配发的仓库信息
     * 
     * @return
     */
    List<UdWarehParamDefine> selectAllForB2C();
    
    /**
     * 
     * TODO 获取仓库参数
     * TODO 根据仓库编码获取仓库参数（安全库存类型、值等）
     * @param map
     * @return
     */
    List<UdWarehParamDefine> selectWarehParamByWarehs(Map<String,Object> map);

}
