package com.metersbonwe.stock.biz.common.service.impl;


import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.metersbonwe.stock.Constants;
import com.metersbonwe.stock.biz.common.service.MultiTableService;
import com.metersbonwe.stock.dal.auto.core.mapper.StockCommonConfigMapper;
import com.metersbonwe.stock.dal.auto.core.mapper.StockWarehProdMapper;
import com.metersbonwe.stock.dal.auto.core.mapper.StockWarehTableMappingMapper;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockCommonConfig;
import com.metersbonwe.stock.po.core.StockCommonConfigExample;
import com.metersbonwe.stock.po.core.StockWarehProdExample;
import com.metersbonwe.stock.po.core.StockWarehTableMapping;
import com.metersbonwe.stock.po.core.StockWarehTableMappingExample;
import com.metersbonwe.stock.utils.concurrent.TableMappingLock;

@Service
public class MultiTableServiceImpl implements MultiTableService {

	final StockLog log = StockLogFactory.getLogger(MultiTableServiceImpl.class);

	@Resource
	StockWarehTableMappingMapper stockWarehTableMappingMapper;
	@Resource
	StockCommonConfigMapper stockCommonConfigMapper;
	@Resource
	StockWarehProdMapper stockWarehProdMapper;

	private final static Map<String, StockWarehTableMapping> mappingCache = new HashMap<String, StockWarehTableMapping>();

	private final static Object lockObj = new Object();

	@Override
	public String getTableSuffixByWarehId(String warehId) {
		initMappingCache();
		StockWarehTableMapping mapping = getMapping(warehId);
		return getMappingSuffix(mapping);
	}

	@Override
	public String getTableNameByWarehId(String warehId) {
		return Constants.STOCK_WAREH_PROD_PREFIX
				+ getTableSuffixByWarehId(warehId);
	}

	/**
	 * 初始化mapping缓存
	 */
	private void initMappingCache() {
		if (mappingCache.isEmpty()) {
			synchronized (lockObj) {
				if (!mappingCache.isEmpty()) {
					return;
				}
				// 查询所有映射数据
				List<StockWarehTableMapping> item = getMappingList();
				if (item != null && !item.isEmpty()) {
					mappingCache.clear();
				}
				for (int i = 0; i < item.size(); i++) {
					StockWarehTableMapping mapping = item.get(i);
					if (mapping != null) {
						mappingCache.put(mapping.getWarehId(), mapping);
					}
				}
			}
		}
	}

	private List<StockWarehTableMapping> getMappingList() {
		StockWarehTableMappingExample example = new StockWarehTableMappingExample();
		example.or();
		List<StockWarehTableMapping> item = stockWarehTableMappingMapper
				.selectByExample(example);
		return item;
	}

	/**
	 * 获取字符串的表后缀
	 * 
	 * @param mapping
	 * @return
	 */
	private String getMappingSuffix(StockWarehTableMapping mapping) {
		return getMappingSuffix(mapping.getHash());
	}

	/**
	 * 获取字符串的表后缀
	 * 
	 * @param hash
	 * @return
	 */
	public String getMappingSuffix(int hash) {
		return hash < 10 ? "0" + hash : "" + hash;
	}

	/**
	 * 
	 * 获取仓库表映射关系
	 * 
	 * @param warehId
	 *            仓库ID
	 * @return
	 */
	private StockWarehTableMapping getMapping(String warehId) {
		if (!StringUtils.isEmpty(warehId) && mappingCache.containsKey(warehId)) {
			return mappingCache.get(warehId);
		}
		StockWarehTableMapping mapping = null;
		// 如果之前不存在MAPPING关系 则新建MAPPING关系
		Lock lock = TableMappingLock.getLock();
		try {
			lock.lock();
			mapping = stockWarehTableMappingMapper.selectByPrimaryKey(warehId);
			if (mapping == null) {
				mapping = createWarehTableMapping(warehId);
			}
		} finally {
			lock.unlock();
		}
		return mapping;
	}

	/**
	 * 创建新的仓库表映射关系
	 * 
	 * @param warehId
	 *            仓库ID
	 * @return
	 */
	private StockWarehTableMapping createWarehTableMapping(String warehId) {
		int maxSeq = getMaxTableSeq();
		String tableSuff = getMappingSuffix(maxSeq);
		StockWarehProdExample example = new StockWarehProdExample();
		example.or();
		example.setTableNum(tableSuff);
		// 查询当前表记录数
		int count = stockWarehProdMapper.countByExample(example);
		// 如果当前表记录数大于最大表记录数 需要新增加表
		if (count >= Constants.MAX_TABLE_COUNT) {
			// 更新最大表序列
			maxSeq++;
			updateMaxSeqConfig(maxSeq);
		}
		return createTableMapping(warehId, maxSeq);
	}

	/**
	 * 创建新的表映射关系
	 * 
	 * @param warehId
	 * @param maxSeq
	 * @return
	 */
	private StockWarehTableMapping createTableMapping(String warehId, int maxSeq) {
		StockWarehTableMapping mapping = new StockWarehTableMapping();
		mapping.setHash(maxSeq);
		mapping.setWarehId(warehId);
		mapping.setWarehDataCnt(0);
		stockWarehTableMappingMapper.insertSelective(mapping);
		mappingCache.put(warehId, mapping);
		return mapping;
	}

	/**
	 * 更新最大表序列配置
	 * 
	 * @param maxSeq
	 */
	private void updateMaxSeqConfig(int maxSeq) {
		StockCommonConfig record = new StockCommonConfig();
		record.setConfigValue(maxSeq + "");
		StockCommonConfigExample exampletemp = new StockCommonConfigExample();
		exampletemp.or().andConfigNameEqualTo(
				Constants.MAX_TABLE_SQE_CONFIG_NAME);
		stockCommonConfigMapper.updateByExampleSelective(record, exampletemp);
	}

	/**
	 * 获取最大表序列
	 * 
	 * @return 最大表序列
	 */
	public int getMaxTableSeq() {
		StockCommonConfigExample example = new StockCommonConfigExample();
		example.or().andConfigNameEqualTo(Constants.MAX_TABLE_SQE_CONFIG_NAME);
		List<StockCommonConfig> item = stockCommonConfigMapper
				.selectByExample(example);
		checkConfig(item);
		StockCommonConfig config = item.get(0);
		String value = config.getConfigValue();
		try {
			int maxSeq = Integer.parseInt(value);
			return maxSeq;
		} catch (Exception e) {
			final String msg = "仓+sku表分表最大表序列配置数据解析出错";
			log.error(msg, e);
			throw new RuntimeException(msg, e);
		}
	}

	/**
	 * 检查配置合法性
	 * 
	 * @param item
	 *            配置
	 */
	private void checkConfig(List<StockCommonConfig> item) {
		if (item == null || item.isEmpty() || item.get(0) == null) {
			throw new RuntimeException("没有找到仓+sku表分表最大表序列配置");
		}
		if (item.size() != 1) {
			throw new RuntimeException("仓+sku表分表最大表序列配置数据不唯一");
		}
	}

	@Override
	public Set<String> getTableSuffixsByWarehIds(String... warehIds) {
		return getTableSuffByWarehsMap(warehIds).keySet();
	}

	@Override
	public Map<String, Set<String>> getTableSuffByWarehsMap(String... warehIds) {
		Map<String, Set<String>> itemMap = new HashMap<String, Set<String>>();
		for (int i = 0; i < warehIds.length; i++) {
			String wid = warehIds[i];
			if (StringUtils.isEmpty(wid)) {
				continue;
			}
			String suff = getTableSuffixByWarehId(wid);
			if (!itemMap.containsKey(suff)) {
				itemMap.put(suff, new HashSet<String>());
			}
			Set<String> temp =  itemMap.get(suff);
			temp.add(wid);
		}
		return itemMap;
	}

}
