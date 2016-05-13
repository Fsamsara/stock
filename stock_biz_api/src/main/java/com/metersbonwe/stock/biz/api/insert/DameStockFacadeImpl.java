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
import com.metersbonwe.stock.dal.auto.sync.mapper.TmpDameStockMapper;
import com.metersbonwe.stock.dal.define.sync.mapper.TmpDameStockDefineMapper;
import com.metersbonwe.stock.facade.api.DameStockFacade;
import com.metersbonwe.stock.facade.api.bean.DameStock;
import com.metersbonwe.stock.facade.api.bean.Message;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.sync.TmpDameStock;

/**
 * @author 张洪琴 污损值接受写入接口实现类
 */
@Service
public class DameStockFacadeImpl implements DameStockFacade {

	@Resource
	TmpDameStockMapper tmpDameStockMapper;
	@Resource
	TmpDameStockDefineMapper tmpDameStockDefineMapper;

	private static StockLog stockLog = StockLogFactory
			.getLogger(DameStockFacadeImpl.class);
	
	/**
	 * 传入的参数有效性检查，有效参数：封装
	 * @param dameStock
	 * @return
	 */
	private Map<String, Object> checkParam(DameStock dameStock){
		Map<String, Object> msg = new HashMap<String, Object>();
		if(dameStock==null){
			msg.put("tag", false);
			msg.put("wrongMsg", "传入的参数不能为空！");
		}else if(
				StringUtils.isEmpty(dameStock.getWarehId()) ||
				StringUtils.isEmpty(dameStock.getProdId()) ||
				dameStock.getDameStock()==null
				){
			msg.put("tag", false);
			msg.put("wrongMsg", "传入的对象属性不能为空！");
		}else{
			// 封装数据：
			TmpDameStock target = new TmpDameStock();
			BeanUtils.copyProperties(dameStock, target);
			//手动封装：remailStock
			target.setDameStock(new BigDecimal(dameStock.getDameStock()));
			if(target.getUpdateTime()==null){
				target.setUpdateTime(new Date());
			}
			target.setCreateTime(new Date());
            
			msg.put("tag", true);
			msg.put("tmpDameStock", target);
		}
		return msg;
	}
	
	/**
	 * 传入的参数有效性检查，有效参数：封装
	 * @param dameStockList
	 * @return
	 */
	private Map<String, Object> checkParamList(List<DameStock> dameStockList){
		
		List<DameStock> invalidParamList = new ArrayList<DameStock>();
		List<TmpDameStock> validParamList = new ArrayList<TmpDameStock>();
		Map<String, Object> msg = new HashMap<String, Object>();
		if(dameStockList==null || dameStockList.size()==0){
			msg.put("tag", false);
			return msg;
		}
		stockLog.debug("传入的参数数量："+dameStockList.size());
		
		for (DameStock dameStock : dameStockList) {
			Map<String, Object> map = checkParam(dameStock);
			if( !(Boolean)map.get("tag") ){
				invalidParamList.add(dameStock);
			}
			TmpDameStock tmp = (TmpDameStock)map.get("tmpDameStock");
			if(tmp!=null){
				validParamList.add( tmp );				
			}
			
		}
		//
		msg.put("invalidParamList", invalidParamList);
		msg.put("validParamList", validParamList);
		stockLog.debug("有效参数数量："+validParamList.size());
		stockLog.debug("无效参数数量："+invalidParamList.size());
		//
		return msg;
	}
	
	@Override @LogService("污损值接受写入接口实现类")
	public Message setDameStock(DameStock dameStock) {
		stockLog.debug("污损值接受写入接口setDameStock-->开始");
		stockLog.debug("setDameStock方法传入参数：" + dameStock);
		try {
			
			Map<String, Object> msg = checkParam(dameStock);
			if( !(Boolean)msg.get("tag") ){
				stockLog.error("setDameStock方法传入参数无效：" + dameStock);
				return new Message(false, Message.PARAMETER_WRONG+",无效参数："+ dameStock);			
			}
			
			// 插入数据到同步库临时表：
			int tag = this.tmpDameStockMapper.insertSelective( (TmpDameStock)msg.get("tmpDameStock") );
			stockLog.debug("污损值接受写入接口插入到临时表的数据量："+tag);
			// 返回写入结果;
			return new Message(tag != 0, tag != 0 ? null : Message.INSERT_WRONG);

		} catch (Exception e) {
			stockLog.error("setDameStock方法报异常," ,e);
			return new Message(false, Message.INSERT_DEBUG+","+e.getMessage());
		}finally{
			stockLog.debug("污损值接受写入接口setDameStock-->结束");
		}
	}

	@SuppressWarnings("unchecked") @Override @LogService("污损值接受写入接口实现类")
	public Message setDameStockList(List<DameStock> dameStockList) {
		stockLog.debug("污损值接受写入接口setDameStock（多条数据传入）-->开始");
		stockLog.debug("setDameStock方法传入参数：" + dameStockList);
		Map<String, Object> msg = null;
		try {

			msg = checkParamList(dameStockList);
			stockLog.debug("--->传入的无效参数列表："+msg.get("invalidParamList"));
			stockLog.debug("--->传入的有效参数封装后的结果："+msg.get("validParamList"));
			
			//
			List<TmpDameStock> tmpList = (List<TmpDameStock>)msg.get("validParamList") ;
			if(tmpList.size()==0){
				stockLog.error("setDameStock方法传入参数无效：" + msg.get("invalidParamList"));
				return new Message(false, Message.PARAMETER_WRONG+",无效参数："+ msg.get("invalidParamList"));
			}
			
			// 插入数据到同步库临时表：
			int tag = tmpDameStockDefineMapper.insertList( tmpList );
			stockLog.debug("实际插入到临时表的数据量："+tag);
			// 返回写入结果;
			return new Message(tag != 0,"传入的无效参数列表:"+msg.get("invalidParamList"));

		} catch (Exception e) {
			stockLog.error("setDameStock方法报异常", e );
			return new Message(false, Message.INSERT_DEBUG+"--->"+e.getMessage()+",传入的无效参数列表："+msg.get("invalidParamList"));
		}finally{
			stockLog.debug("污损值接受写入接口setDameStock（多条数据传入）-->结束");
		}
	}

}
