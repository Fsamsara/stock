package com.metersbonwe.stock.biz.common.service;

import java.util.List;

/**
 * 仓|店属性相关公用服务
 * @author tony
 *
 */
public interface WarehPropertyService {
    /**
     * @description 获取所有启用了B2B的仓
     */
    List<String> getB2Bwareh();

}
