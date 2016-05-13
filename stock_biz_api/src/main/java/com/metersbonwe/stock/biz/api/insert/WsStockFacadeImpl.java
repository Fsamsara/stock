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
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;

import com.metersbonwe.stock.biz.log.LogService;
import com.metersbonwe.stock.dal.auto.sync.mapper.TmpWsStockMapper;
import com.metersbonwe.stock.dal.define.sync.mapper.TmpWsStockDefineMapper;
import com.metersbonwe.stock.facade.api.WsStockFacade;
import com.metersbonwe.stock.facade.api.bean.Message;
import com.metersbonwe.stock.facade.api.bean.WsStock;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.sync.TmpWsStock;

/**
 * @author 张洪琴 仓ws安全库存写入接口实现
 */
@Service
public class WsStockFacadeImpl implements WsStockFacade {

	@Resource
	TmpWsStockMapper tmpWsStockMapper;
	@Resource
	TmpWsStockDefineMapper tmpWsStockDefineMapper;

	//
	private static StockLog stockLog = StockLogFactory
			.getLogger(WsStockFacadeImpl.class);
	
	/**
	 * 单个数据有效性检查：如果有效则进行封装
	 * @param wsStock
	 * @return
	 */
	private Map<String, Object> checkParam(WsStock wsStock){
		 Map<String, Object> msg = new HashMap<String, Object>();
	
		 if( wsStock==null ||
				 StringUtils.isEmpty(wsStock.getWarehId()) ||
				 wsStock.getWsStock() == null
				 ){
			 msg.put("tag", false);
		 }else{
			// stock_po中的类
			TmpWsStock target = new TmpWsStock();
			// 将facade中的实体类复制到stock_po对应的类中：
			BeanUtils.copyProperties(wsStock, target);
			//手动封装：
			target.setWsStock( new BigDecimal(wsStock.getWsStock()));
			if(target.getUpdateTime()==null){
				target.setUpdateTime(new Date());
			}
			msg.put("tag", true);
			msg.put("tmpWsStock", target);
		 }
		 
		 return msg;
	}
	
	/**
	 * 多个数据有效性检查：如果有效则进行封装
	 * @param wsStock
	 * @return
	 */
	private Map<String, Object> checkParamList(List<WsStock> wsStockList){
		 Map<String, Object> msg = new HashMap<String, Object>();
		 List<TmpWsStock> validParamList = new ArrayList<TmpWsStock>();
		 List<WsStock> invalidParamList = new ArrayList<WsStock>();
		 //
		 if(wsStockList==null || wsStockList.size()==0){
			 msg.put("tag", false);
			 return msg;
		 }
		 stockLog.debug("传入的参数数据量："+wsStockList.size());
		 for (WsStock wsStock : wsStockList) {
			 Map<String, Object> map = checkParam( wsStock );
			 if( !(boolean)map.get("tag") ){
				 invalidParamList.add(wsStock);
			 }
			 TmpWsStock tmp = (TmpWsStock)map.get("tmpWsStock");
			 if(tmp!=null){
				 validParamList.add( tmp );				 
			 }
		}
		
		 //
		msg.put("validParamList", validParamList);
		msg.put("invalidParamList", invalidParamList);
		stockLog.debug("有效参数数据量："+validParamList.size());
		stockLog.debug("无效参数数据量："+invalidParamList.size());
		return msg;
	}
	
	@Override @LogService("仓ws安全库存写入接口")
	public Message setWsStockMessage(WsStock wsStock) {
		stockLog.debug("仓ws安全库存写入接口setWsStockMessage-->开始");
		stockLog.debug("setWsStockMessage传入的参数是：" + wsStock);

		try {			
			 Map<String, Object> map = checkParam( wsStock );
			 if( !(boolean)map.get("tag") ){
				 stockLog.error("setWsStockMessage传入的参数无效：" + wsStock);
				 return new Message(false, Message.PARAMETER_WRONG);				 
			 }

			// 将外部传入的且已经封装好的仓ws安全库存数据信息插入到临时表：
			int tag = this.tmpWsStockMapper.insertSelective( (TmpWsStock)map.get("tmpWsStock") );

			// 是否插入成功的返回
			return new Message(tag != 0, tag != 0 ? null : Message.INSERT_WRONG);

		} catch (BeansException e) {
			stockLog.error("WsStockFacadeImpl->setWsStockMessage报异常:"+ e.getMessage(),e);
			return new Message(false, Message.INSERT_DEBUG+"-->"+e.getMessage());
		}finally{
			stockLog.debug("仓ws安全库存写入接口setWsStockMessage-->结束");
		}
	}
 
	@Override @LogService("仓ws安全库存写入接口")
	public Message setWsStockMessageList(List<WsStock> wsStockList) {
		stockLog.debug("仓ws安全库存写入接口setWsStockMessage（多条数据传入）-->开始");
		stockLog.debug("setWsStockMessage传入的参数是：" + wsStockList);
		//
		Map<String, Object> msg = null;
		try {
			msg = checkParamList(wsStockList);
			stockLog.debug("setWsStockMessage传入的无效参数列表：" + msg.get("invalidParamList"));
			stockLog.debug("setWsStockMessage传入的有效参数封装后列表：" + msg.get("validParamList"));
			
			List<TmpWsStock> wsList = (List<TmpWsStock>)msg.get("validParamList");
			if ( wsList.size() == 0) {
				stockLog.error("setWsStockMessage传入的无效参数列表：" + msg.get("invalidParamList"));
				return new Message(false, Message.PARAMETER_WRONG+"--->"+msg.get("invalidParamList"));
			} 
			
			stockLog.debug("需要插入到TMP_WS_STOCK的数据量："+wsList.size());
			// 批量插入数据到STOCK_USER.TMP_WS_STOCK表
			int tag = tmpWsStockDefineMapper.insertList(wsList);
			stockLog.debug("插入到TMP_WS_STOCK的数据量："+tag);
			// 返回插入结果
			return new Message(tag != 0, "setWsStockMessage传入的无效参数列表：" + msg.get("invalidParamList"));
		
		} catch (Exception e) {
			stockLog.error("setWsStockMessage报异常:"+ e.getMessage(), e);
			return new Message(false, Message.INSERT_DEBUG+"-->"+e.getMessage()+",setWsStockMessage传入的无效参数列表：" + msg.get("invalidParamList"));
		}finally{
			stockLog.debug("仓ws安全库存写入接口setWsStockMessage（多条数据传入）-->结束");
		}
	}

}
