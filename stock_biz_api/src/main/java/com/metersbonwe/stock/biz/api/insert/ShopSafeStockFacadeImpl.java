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
import com.metersbonwe.stock.dal.auto.sync.mapper.TmpShopSafeStockMapper;
import com.metersbonwe.stock.dal.define.sync.mapper.TmpShopSafeStockDefineMapper;
import com.metersbonwe.stock.facade.api.ShopSafeStockFacade;
import com.metersbonwe.stock.facade.api.bean.Message;
import com.metersbonwe.stock.facade.api.bean.ShopSafeStock;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.sync.TmpShopSafeStock;

/**
 * @author 张洪琴
 * 门店安全库存接受写入接口实现类
 */
@Service
public class ShopSafeStockFacadeImpl implements ShopSafeStockFacade {
	
	@Resource
	TmpShopSafeStockMapper tmpShopSafeStockMapper;
	@Resource
	TmpShopSafeStockDefineMapper tmpShopSafeStockDefineMapper;
	
	private static StockLog stockLog = StockLogFactory
			.getLogger(ShopSafeStockFacadeImpl.class);
	
	/**
	 * 检查参数有效性：如果有效，则封装数据
	 * @param shopSafeStock
	 * @return
	 */
	private Map<String, Object> checkParam(ShopSafeStock shopSafeStock){
		Map<String, Object> msg = new HashMap<String, Object>();
		if( shopSafeStock==null ||
				StringUtils.isEmpty(shopSafeStock.getProdId())  ||
				StringUtils.isEmpty(shopSafeStock.getWarehId()) ||
				shopSafeStock.getShopSafeStock()==null		
				){
			msg.put("tag", false);
		}else{
			//封装数据：
			TmpShopSafeStock target = new TmpShopSafeStock();
			BeanUtils.copyProperties(shopSafeStock, target);
			//手动封装数据类型不一样的字段
			target.setShopSafeStock(new BigDecimal(shopSafeStock.getShopSafeStock()));
			if(target.getUpdateTime()==null){
				target.setUpdateTime(new Date());
			}
			msg.put("tag", true);
			msg.put("tmpShopSafeStock", target);
		}
		return msg;
	}
	
	/**
	 * 检查参数有效性：如果有效，则封装数据
	 * @param shopSafeStock
	 * @return
	 */
	private Map<String, Object> checkParamList(List<ShopSafeStock> shopSafeStockList){
		Map<String, Object> msg = new HashMap<String, Object>();
		List<TmpShopSafeStock> validParamList = new ArrayList<TmpShopSafeStock>();
		List<ShopSafeStock> invalidParamList = new ArrayList<ShopSafeStock>();
		//
		if(shopSafeStockList==null || shopSafeStockList.size()==0){
			msg.put("tag", false);
			return msg;
		}
		stockLog.debug("传入的参数数据量："+shopSafeStockList.size());
		
		for (ShopSafeStock shopSafeStock : shopSafeStockList) {
			Map<String, Object> map = checkParam(shopSafeStock);
			if( !(Boolean)map.get("tag") ){
				invalidParamList.add(shopSafeStock);
			}
			TmpShopSafeStock tmp = (TmpShopSafeStock)map.get("tmpShopSafeStock");
			if(tmp!=null){
				validParamList.add( tmp );				
			}
		}
		
		msg.put("validParamList", validParamList);
		msg.put("invalidParamList", invalidParamList);
		stockLog.debug("有效参数数据量："+validParamList.size());
		stockLog.debug("无效参数数据量："+invalidParamList.size());
		return msg;
	}
	
	@Override @LogService("门店安全库存接受写入接口")
	public Message setShopSafeStock(ShopSafeStock shopSafeStock) {
		stockLog.debug("门店安全库存接受写入接口setShopSafeStock-->开始");
		stockLog.debug("setShopSafeStock传入的参数是："+shopSafeStock);
		Map<String, Object> msg = null;
		try {
			
			msg = checkParam(shopSafeStock);
			if( !(Boolean)msg.get("tag") ){
				stockLog.error("setShopSafeStock传入的参数无效："+shopSafeStock);
				return new Message(false,Message.PARAMETER_WRONG+"---->无效参数："+shopSafeStock);				
			}
			
			//插入同步库临时表：
			int tag = this.tmpShopSafeStockMapper.insertSelective( (TmpShopSafeStock)msg.get("tmpShopSafeStock") );
			stockLog.debug("插入到临时表的数据量是："+tag);
			return new Message(tag!=0,tag!=0?null:Message.INSERT_WRONG);
			
		} catch (Exception e) {
			stockLog.error("setShopSafeStock报异常",e);
			return new Message(false,Message.INSERT_DEBUG);
		}finally{
			stockLog.debug("门店安全库存接受写入接口setShopSafeStock-->结束");
		}

	}

	@Override
	public Message setShopSafeStockList(List<ShopSafeStock> shopSafeStockList) {
		stockLog.debug("门店安全库存接受写入接口setShopSafeStock（多条数据传入）-->开始");
		stockLog.debug("setShopSafeStock传入的参数是："+shopSafeStockList);
		Map<String, Object> msg = null;
		try {
			msg = checkParamList( shopSafeStockList );
			stockLog.debug("传入的无效参数列表："+ msg.get("invalidParamList"));
			stockLog.debug("传入的有效参数封装后的列表："+ msg.get("validParamList"));
			
			//
			List<TmpShopSafeStock> tmpList = (List<TmpShopSafeStock>)msg.get("validParamList");
			if(tmpList.size()==0){
				stockLog.error("setShopSafeStock传入的参数无效："+msg.get("invalidParamList"));
				return new Message(false,Message.PARAMETER_WRONG+"---->无效参数："+msg.get("invalidParamList"));	
			}
			
			//插入数据到临时表：
			int tag = this.tmpShopSafeStockDefineMapper.insertList( tmpList );	
			stockLog.debug("插入到临时表的数据量是："+tag);
			//
			return new Message(tag!=0,"传入的无效参数列表："+ msg.get("invalidParamList"));
		} catch (Exception e) {
			stockLog.error("setShopSafeStock报异常",e);
			return new Message(false,Message.INSERT_DEBUG+"-->"+e.getMessage()+",传入的无效参数列表："+ msg.get("invalidParamList"));
		}finally{
			stockLog.debug("门店安全库存接受写入接口setShopSafeStock（多条数据传入）-->结束");
		}		
	}

}
