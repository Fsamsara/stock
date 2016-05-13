package com.metersbonwe.stock.biz.common.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.metersbonwe.stock.biz.common.localcache.provider.WarehPropertyB2BCacheProvider;
import com.metersbonwe.stock.biz.common.service.WarehPropertyService;
@Service
public class WarehPropertyServiceImpl implements WarehPropertyService {

	@Resource WarehPropertyB2BCacheProvider warehPropertyB2BCacheProvider;
	
	@Override public List<String> getB2Bwareh() {
		return warehPropertyB2BCacheProvider.getB2Bwareh();
	}
}
