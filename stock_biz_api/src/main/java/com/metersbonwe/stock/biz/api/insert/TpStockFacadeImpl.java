package com.metersbonwe.stock.biz.api.insert;

import java.math.BigDecimal;
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
import com.metersbonwe.stock.dal.auto.sync.mapper.TmpTpStockMapper;
import com.metersbonwe.stock.dal.define.sync.mapper.TmpTpStockDefineMapper;
import com.metersbonwe.stock.facade.api.TpStockFacade;
import com.metersbonwe.stock.facade.api.bean.Message;
import com.metersbonwe.stock.facade.api.bean.TpStock;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.sync.TmpTpStock;

/**
 * @author 张洪琴
 * TODO 第三方自由量写入接口实现类
 */
@Service
public class TpStockFacadeImpl implements TpStockFacade {

	@Resource
	TmpTpStockMapper tmpTpStockMapper;
	@Resource
	TmpTpStockDefineMapper tmpTpStockDefineMapper;

	private static StockLog stockLog = StockLogFactory
			.getLogger(TpStockFacadeImpl.class);
	
	/**
	 * 单个数据有效性检查：如果有效则进行封装
	 * @param tpStock
	 * @return
	 */
	private Map<String, Object> checkParam(TpStock tpStock){
		Map<String, Object> msg = new HashMap<String, Object>();
		if( tpStock==null ||
				StringUtils.isEmpty(tpStock.getWarehId()) ||
				StringUtils.isEmpty(tpStock.getProdId())  || 
				tpStock.getTpStock() == null
				){
			msg.put("tag", false);
		}else{
			// 重新封装数据：第三方自由量库存临时表 TMP_TP_STOCK
			TmpTpStock target = new TmpTpStock();
			BeanUtils.copyProperties(tpStock, target);
			//手动封装数据类型不一致的数据
			target.setTpStock(new BigDecimal(tpStock.getTpStock()));
			if(target.getUpdateTime()==null){
				target.setUpdateTime(new Date());
			}
			msg.put("tag", true);
			msg.put("tmpTpStock", target);
		}
		
		return msg;
	}
	
	/**
	 * 多个数据有效性检查：如果有效则进行封装
	 * @param tpStock
	 * @return
	 */
	private Map<String, Object> checkParamList(List<TpStock> tpStockList){
		Map<String, Object> msg = new HashMap<String, Object>();
		List<TmpTpStock> validParamList = new ArrayList<TmpTpStock>();
		List<TpStock> invalidParamList = new ArrayList<TpStock>();
		//
		if(tpStockList==null || tpStockList.size()==0){
			msg.put("tag", false);
			return msg;
		}
		stockLog.debug("传入的参数数量："+tpStockList.size());
		for (TpStock tpStock : tpStockList) {
			Map<String, Object> map = checkParam(tpStock);
			if( !(boolean)map.get("tag") ){
				invalidParamList.add(tpStock);
			}
			TmpTpStock tmp = (TmpTpStock)map.get("tmpTpStock");
			if(tmp!=null){
				validParamList.add( tmp );				
			}
		}
		msg.put("validParamList", validParamList);
		msg.put("invalidParamList", invalidParamList);
		stockLog.debug("有效的参数数量："+validParamList.size());
		stockLog.debug("无效的参数数量："+invalidParamList.size());
		return msg;
	}
	
	@Override @LogService("第三方自由量写入接口")
	public Message setTpStock(TpStock tpStock) {
		stockLog.debug("第三方自由量写入接口setTpStock-->开始");
		stockLog.debug("setTpStock传入的参数是：" + tpStock);

		try {
			
			Map<String, Object> msg = checkParam(tpStock);
			if( !(boolean)msg.get("tag") ){
				stockLog.error("setTpStock传入的参数无效：" + tpStock);
				return new Message(false,Message.PARAMETER_WRONG+"-->"+tpStock);
			}
	
			// 将数据插入到第三方自由量库存临时表 TMP_TP_STOCK：
			int tag = this.tmpTpStockMapper.insertSelective( (TmpTpStock)msg.get("tmpTpStock") );
			return new Message(tag!=0,tag!=0?null:Message.INSERT_WRONG);
			
		} catch (Exception e) {
			stockLog.error("setTpStock报异常：" + e.getMessage());
			return new Message(false,Message.INSERT_DEBUG);
		}finally{
			stockLog.debug("第三方自由量写入接口setTpStock-->结束");
		}
	}

	@Override @LogService("第三方自由量写入接口")
	public Message setTpStockList(List<TpStock> tpStockList) {
		stockLog.debug("第三方自由量写入接口setTpStock（多条数据传入）-->开始");
		stockLog.debug("setTpStock传入的参数：" + tpStockList);
		Map<String, Object> msg = null;
		try {
			
			msg = checkParamList(tpStockList);
			stockLog.debug("传入的无效参数列表："+msg.get("invalidParamList"));
			stockLog.debug("传入的有效参数封装后的数据列表："+msg.get("validParamList"));
			
			List<TmpTpStock> tmpList = (List<TmpTpStock>)msg.get("validParamList");
			if(tmpList.size()==0){
				stockLog.error("setTpStock传入的参数无效：" + msg.get("invalidParamList"));
				return new Message(false,Message.PARAMETER_WRONG+"-->"+msg.get("invalidParamList"));
			}
			// 将数据插入到第三方自由量库存临时表 TMP_TP_STOCK：
			// 数据插入成功与否的标识
			int tag = tmpTpStockDefineMapper.insertList(tmpList);
			stockLog.debug("插入到TMP_TP_STOCK的数据量：" + tag);
			return new Message(tag!=0,tag!=0?null:Message.INSERT_WRONG);
			
		} catch (Exception e) {
			stockLog.debug("setTpStock报异常：" + e.getMessage());
			return new Message(false,Message.INSERT_DEBUG);
		}finally{
			stockLog.debug("第三方自由量写入接口setTpStock（多条数据传入）-->结束");
		}
		
	}

}
