package com.metersbonwe.stock.dal.define.core.mapper;

import com.metersbonwe.stock.po.core.TmpQueueFreeLock;

import java.util.List;
import java.util.Map;

/* *
 * @description 仓安全库存类型变化专用mapper
 * @author huangbiao
 * @date 2016/03/26
 * @version V1.0
 */
public interface WarehSafeTypeChangeCoreMapper {

    /**
     * @description 更新仓商品明细表仓库安全类型为WP的仓的online_safe_stock字段
     * @param paramMap 参数Map
     */
    void updateWPWarehProdOnlineSafeStock(Map<String, Object> paramMap);

    /**
     * @description 更新仓商品明细表仓库安全类型为WS的仓的online_safe_stock字段
     * @param paramMap 参数Map
     */
    void updateWSOrNOWarehProdOnlineSafeStock(Map<String, Object> paramMap);

    /**
     * @description 在指定的仓商品明细表搜索指定仓的数据
     * @param paramMap 参数Map
     */
    List<TmpQueueFreeLock> selectSafeTypeChangedData(Map<String, Object> paramMap);
}
