package com.metersbonwe.stock.biz.api.insert;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.metersbonwe.stock.biz.log.LogService;
import com.metersbonwe.stock.dal.auto.sync.mapper.TmpSafeTypeStockMapper;
import com.metersbonwe.stock.dal.define.sync.mapper.TmpSafeTypeStockDefineMapper;
import com.metersbonwe.stock.facade.api.SafeTypeStockFacade;
import com.metersbonwe.stock.facade.api.bean.Message;
import com.metersbonwe.stock.facade.api.bean.SafeTypeStock;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.sync.TmpSafeTypeStock;

/**
 * @author 张洪琴
 * 仓安全类型变化写入接口实现类
 */
@Service
public class SafeTypeStockFacadeImpl implements SafeTypeStockFacade {

	@Resource
	TmpSafeTypeStockMapper tmpSafeTypeStockMapper;
	@Resource
	TmpSafeTypeStockDefineMapper tmpSafeTypeStockDefineMapper;

	private static StockLog stockLog = StockLogFactory
			.getLogger(SafeTypeStockFacadeImpl.class);
	
	/**
	 * 参数检查，对有效数据进行封装
	 * @param safeTypeStock
	 * @return
	 */
	private Map<String, Object> checkParam(SafeTypeStock safeTypeStock){
		Map<String, Object> msg = new HashMap<String, Object>();
		if(safeTypeStock==null ||
				StringUtils.isEmpty(safeTypeStock.getSafeType()) ||
				StringUtils.isEmpty(safeTypeStock.getWarehId())){
			msg.put("tag", false);
		}else{
			msg.put("tag", true);
			// 申明数据重新封装的变量：
			TmpSafeTypeStock target = new TmpSafeTypeStock();
			BeanUtils.copyProperties(safeTypeStock, target);
			if(target.getUpdateTime()==null){
				target.setUpdateTime(new Date());
			}
			msg.put("tmpSafeTypeStock", target);
		}
		return msg;
	}
	
	/**
	 * 参数检查，对有效数据进行封装
	 * @param safeTypeStock
	 * @return
	 */
	private Map<String, Object> checkParamList(List<SafeTypeStock> safeTypeStockList){
		Map<String, Object> msg = new HashMap<String, Object>();
		List<TmpSafeTypeStock> validParamList = new ArrayList<TmpSafeTypeStock>();
		List<SafeTypeStock> invalidParamList = new ArrayList<SafeTypeStock>();
		//
		if(safeTypeStockList==null || safeTypeStockList.size()==0){
			msg.put("tag", false);
			return msg;
		}
		stockLog.debug("传入的参数数量："+safeTypeStockList.size());
		for (SafeTypeStock safeTypeStock : safeTypeStockList) {
			Map<String, Object> map = checkParam(safeTypeStock);
			if( !(Boolean)map.get("tag") ){
				invalidParamList.add(safeTypeStock);
			}
			TmpSafeTypeStock tmp = (TmpSafeTypeStock)map.get("tmpSafeTypeStock");
			if(tmp!=null){
				validParamList.add( tmp );				
			}
		}
		
		msg.put("invalidParamList", invalidParamList);
		msg.put("validParamList", validParamList);
		stockLog.debug("有效参数数量："+validParamList.size());
		stockLog.debug("无效参数数量："+invalidParamList.size());
		return msg;
	}
	
	@Override @LogService("仓安全类型变化写入接口")
	public Message setSafeTypeStock(SafeTypeStock safeTypeStock) {
		stockLog.debug("仓安全类型变化写入接口setSafeTypeStock-->开始");
		stockLog.debug("setSafeTypeStock方法传入的参数是：" + safeTypeStock);
		// 数据封装、插入数据库处理
		Map<String, Object> msg = null;
		try {
			
			msg = checkParam(safeTypeStock);
			if( !(Boolean)msg.get("tag") ){
				stockLog.error("setSafeTypeStock方法传入的参数无效：" + safeTypeStock);
				return new Message(false,Message.PARAMETER_WRONG+"--->"+safeTypeStock);
			}
			int tag = this.tmpSafeTypeStockMapper.insertSelective( (TmpSafeTypeStock)msg.get("tmpSafeTypeStock") );
			// 返回
			return new Message(tag!=0,tag!=0?null:Message.INSERT_WRONG);
		
		} catch (Exception e) {
			stockLog.error("setSafeTypeStock方法出现debug", e);
			return new Message(false,Message.INSERT_DEBUG+","+e.getMessage());
		}finally{
			stockLog.debug("仓安全类型变化写入接口setSafeTypeStock-->结束");
		}

	}

	@Override @LogService("仓安全类型变化写入接口")
	public Message setSafeTypeStockList(List<SafeTypeStock> safeTypeStockList) {
		stockLog.debug("仓安全类型变化写入接口setSafeTypeStock（多条数据传入）-->开始");
		stockLog.debug("setSafeTypeStock方法传入的参数是：" + safeTypeStockList);
		Map<String, Object> msg = null;
		// 数据封装、插入数据库处理
		try {
			msg = checkParamList( safeTypeStockList );
			stockLog.debug("传入的无效参数列表："+ msg.get("invalidParamList"));
			stockLog.debug("传入的有效参数封装后的列表："+ msg.get("validParamList"));
			
			List<TmpSafeTypeStock> tmpList = (List<TmpSafeTypeStock>)msg.get("validParamList");
			if(tmpList.size()==0){
				stockLog.error("setSafeTypeStock方法传入的参数无效：" +  msg.get("invalidParamList"));
				return new Message(false,Message.PARAMETER_WRONG+"--->"+ msg.get("invalidParamList"));
			}
			
			// 插入到同步库的仓安全库存类型变化临时表TMP_SAFE_TYPE_STOCK
			int tag = tmpSafeTypeStockDefineMapper.insertList( tmpList );
			stockLog.debug("实际插入到临时表的数据量："+tag);
			// 返回
			return new Message(tag!=0,"传入的无效参数列表："+ msg.get("invalidParamList"));			

		} catch (Exception e) {
			stockLog.error("setSafeTypeStock方法(多条数据插入)出现debug", e);
			return new Message(false,Message.INSERT_DEBUG+"-->"+e.getMessage()+",传入的无效参数列表："+ msg.get("invalidParamList"));
		}finally{
			stockLog.debug("仓安全类型变化写入接口setSafeTypeStock（多条数据传入）-->结束");
		}
	}

}
