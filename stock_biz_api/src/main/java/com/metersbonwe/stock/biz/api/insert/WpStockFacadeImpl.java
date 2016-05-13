package com.metersbonwe.stock.biz.api.insert;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.metersbonwe.stock.biz.log.LogService;
import com.metersbonwe.stock.dal.auto.sync.mapper.TmpWpStockMapper;
import com.metersbonwe.stock.dal.define.sync.mapper.TmpWpStockDefineMapper;
import com.metersbonwe.stock.facade.api.WpStockFacade;
import com.metersbonwe.stock.facade.api.bean.Message;
import com.metersbonwe.stock.facade.api.bean.WpStock;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.sync.TmpWpStock;

/**
 * @author 张洪琴 仓wp安全库存接受写入接口实现
 */
@Service
public class WpStockFacadeImpl implements WpStockFacade {

	@Resource
	TmpWpStockMapper tmpWpStockMapper;
	@Resource
	TmpWpStockDefineMapper tmpWpStockDefineMapper;

	private static StockLog stockLog = StockLogFactory
			.getLogger(WpStockFacadeImpl.class);
	
	/**
	 * 单个数据的有效性检查，如果有效：则进行封装
	 * @param wpStock
	 * @return
	 */
	private Map<String, Object> checkParam(WpStock wpStock){
		Map<String, Object> msg = new HashMap<String, Object>();
		
		if( wpStock==null ||
				StringUtils.isEmpty(wpStock.getWarehId()) ||
				StringUtils.isEmpty(wpStock.getProdId())  ||
				wpStock.getWpStock()==null
				){
			msg.put("tag", false);
		}else{
			// 数据封装
			TmpWpStock target = new TmpWpStock();
			BeanUtils.copyProperties(wpStock, target);
			//手动封装：
			target.setWpStock( new BigDecimal(wpStock.getWpStock()));
			if(target.getUpdateTime()==null){
				target.setUpdateTime(new Date());
			}
			msg.put("tag", true);
			msg.put("tmpWpStock", target);
		}
			
		return msg;
	}
	
	/**
	 * 多个数据的有效性检查，如果有效：则进行封装
	 * @param wpStock
	 * @return
	 */
	private Map<String, Object> checkParamList(List<WpStock> wpStockList){
		Map<String, Object> msg = new HashMap<String, Object>();
		List<TmpWpStock> validParamList = new ArrayList<TmpWpStock>();
		List<WpStock> invalidParamList = new ArrayList<WpStock>();
		
		if(wpStockList==null || wpStockList.size()==0){
			msg.put("tag", false);
			return msg;
		}
		stockLog.debug("传入的参数数据量："+wpStockList.size());
		for (WpStock wpStock : wpStockList) {
			Map<String, Object> map = checkParam( wpStock );
			if( !(boolean)map.get("tag") ){
				invalidParamList.add(wpStock);
			}
			TmpWpStock tmp = (TmpWpStock)map.get("tmpWpStock");
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
	
	
	@Override @LogService("仓wp安全库存接受写入接口")
	public Message setWpStock(WpStock wpStock) {
		stockLog.debug("仓wp安全库存接受写入接口实现-->开始");
		stockLog.debug("setWpStock方法传入的参数是：" + wpStock);
		// 数据封装、插入数据库处理
		try {			
			Map<String, Object> map = checkParam(wpStock);
			if( !(boolean)map.get("tag") ){
				stockLog.error("setWpStock方法传入的参数无效：" + wpStock);
				return new Message(false,Message.PARAMETER_WRONG+"-->"+wpStock);				
			}
		
			// 将数据插入同步库仓WP安全库变化临时表TMP_WP_STOCK：
			int tag = this.tmpWpStockMapper.insertSelective( (TmpWpStock)map.get("tmpWpStock") );

			// 返回
			return new Message(tag!=0,tag!=0?null:Message.INSERT_WRONG);

		} catch (Exception e) {
			stockLog.error("setWpStock方法报异常：" + e.getMessage(),e);
			return new Message(false,Message.INSERT_DEBUG+"---->"+e.getMessage());
		}finally{
			stockLog.debug("仓wp安全库存接受写入接口实现-->结束");
		}
	}

	@Override @LogService("仓wp安全库存接受写入接口")
	public Message setWpStockList(List<WpStock> wpStockList) {
		stockLog.debug("仓wp安全库存接受写入接口实现（多条数据传入）-->开始");
		stockLog.debug("setWpStock方法传入的参数是：" + wpStockList);
		// 数据封装、插入数据库处理
		Map<String, Object> msg = null; 
		try {
			
			msg = checkParamList(wpStockList);
			stockLog.debug("setWpStock方法传入的无效参数列表：" + msg.get("invalidParamList"));
			stockLog.debug("setWpStock方法传入的有效参数列表：" + msg.get("validParamList"));
			
			//
			List<TmpWpStock> twsList = (List<TmpWpStock>)msg.get("validParamList");
			if ( twsList.size()==0 ) {
				stockLog.error("setWpStock方法传入的参数无效：" + msg.get("invalidParamList"));
				return new Message(false,Message.PARAMETER_WRONG+"-->"+msg.get("invalidParamList") );
			}
			
			//
			stockLog.debug("需要插入到TMP_WP_STOCK的数据量："+twsList.size());
			// 将数据插入同步库仓WP安全库变化临时表TMP_WP_STOCK：
			// 数据插入成功与否的标识
			int tag = tmpWpStockDefineMapper.insertList(twsList);
			stockLog.debug("插入到TMP_WP_STOCK的数据量："+tag);
			// 返回
			return new Message(tag!=0, "setWpStock方法传入的无效参数列表：" + msg.get("invalidParamList"));

		} catch (Exception e) {
			stockLog.error("setWpStock方法报异常：" + e.getMessage(),e);
			return new Message(false,Message.INSERT_DEBUG+"-->"+e.getMessage()+",setWpStock方法传入的无效参数列表：" + msg.get("invalidParamList"));
		}finally{
			stockLog.debug("仓wp安全库存接受写入接口实现（多条数据传入）-->结束");
		}
	}

}
