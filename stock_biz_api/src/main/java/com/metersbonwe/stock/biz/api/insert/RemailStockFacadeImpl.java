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
import com.metersbonwe.stock.dal.auto.sync.mapper.TmpRemailStockMapper;
import com.metersbonwe.stock.dal.define.sync.mapper.TmpRemailStockDefineMapper;
import com.metersbonwe.stock.facade.api.RemailStockFacade;
import com.metersbonwe.stock.facade.api.bean.Message;
import com.metersbonwe.stock.facade.api.bean.RemailStock;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.sync.TmpRemailStock;

/**
 * @author 张洪琴
 * 未日结接受写入接口实现类
 */
@Service
public class RemailStockFacadeImpl implements RemailStockFacade {
	
	@Resource
	TmpRemailStockMapper tmpRemailStockMapper;
	@Resource
	TmpRemailStockDefineMapper tmpRemailStockDefineMapper;
	
	private static StockLog stockLog = StockLogFactory.getLogger(RemailStockFacadeImpl.class);
	
	/**
	 * 数据有效性检查，如果有效，则进行封装
	 * @param remailStock
	 * @return
	 */
    private Map<String, Object> checkParam(RemailStock remailStock) {
        Map<String, Object> msg = new HashMap<String, Object>();
        if (remailStock == null || StringUtils.isEmpty(remailStock.getProdId()) || StringUtils.isEmpty(remailStock.getWarehId())
                || remailStock.getRemailStock() == null|| remailStock.getLocId() == null) {
            msg.put("tag", false);
        } else {
            //封装数据：
            TmpRemailStock target = new TmpRemailStock();
            BeanUtils.copyProperties(remailStock, target);
            //remailStock 字段需要自动封装：
            target.setRemailStock(new BigDecimal(remailStock.getRemailStock()));
            if (target.getUpdateTime() == null) {
                target.setUpdateTime(new Date());
            }
            msg.put("tag", true);
            msg.put("tmpRemailStock", target);
        }
        return msg;
    }
	
	/**
	 * @param remailStockList
	 * @return
	 */
	private Map<String, Object> checkParamList(List<RemailStock> remailStockList){
		Map<String, Object> msg = new HashMap<String, Object>();
		List<TmpRemailStock> validParamList = new ArrayList<TmpRemailStock>();
		List<RemailStock> invalidParamList = new ArrayList<RemailStock>();
		//
		if(remailStockList==null || remailStockList.size()==0){
			msg.put("tag", false);
			return msg;
		}
		stockLog.debug("传入的参数数据量："+remailStockList.size());
		
		for (RemailStock remailStock : remailStockList) {
			Map<String, Object> map = checkParam(remailStock);
			if( !(Boolean)map.get("tag") ){
				invalidParamList.add(remailStock);
			}
			TmpRemailStock tmp = (TmpRemailStock)map.get("tmpRemailStock");
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
	
	@Override @LogService("未日结接受写入接口")
	public Message setRemailStock(RemailStock remailStock) {
		stockLog.debug(" 未日结接受写入接口setRemailStock-->开始");
		stockLog.debug("setRemailStock方法传入的参数："+remailStock);
		Map<String, Object> msg = null;
		try {			
			
            msg = checkParam(remailStock);
			if( !(Boolean)msg.get("tag") ){
				stockLog.error("setRemailStock方法传入的参数无效："+remailStock);
				return new Message(false,Message.PARAMETER_WRONG+"--->"+remailStock );
			}
			
			//插入同步库临时表：
			int tag = this.tmpRemailStockMapper.insertSelective( (TmpRemailStock)msg.get("tmpRemailStock") );
			stockLog.debug("setRemailStock方法传入的参数插入到临时表的结果："+tag);
			return new Message(tag!=0,tag!=0?null:Message.INSERT_WRONG);
			
		} catch (Exception e) {
			stockLog.error("setRemailStock方法报异常,",e);
			return new Message(false,Message.INSERT_DEBUG+"--->"+e.getMessage());		
		}finally{
			stockLog.debug(" 未日结接受写入接口setRemailStock-->结束");
		}
	}

	@SuppressWarnings("unchecked") @Override @LogService("未日结接受写入接口")
	public Message setRemailStockList(List<RemailStock> remailStockList) {
		stockLog.debug(" 未日结接受写入接口setRemailStock(多条数据传入)-->开始");
		stockLog.debug("setRemailStock方法传入的参数：" + remailStockList);
		Map<String, Object> msg = null;
		try {
			msg = checkParamList(remailStockList);
			stockLog.debug("传入的无效参数列表："+msg.get("invalidParamList"));
			stockLog.debug("传入的有效参数封装后的列表："+msg.get("validParamList"));		
			
			//
			List<TmpRemailStock> tmpList = (List<TmpRemailStock>)msg.get("validParamList") ;
			if(tmpList.size()==0){
				stockLog.error("setRemailStock方法传入的参数无效："+msg.get("invalidParamList"));
				return new Message(false,Message.PARAMETER_WRONG+"--->"+msg.get("invalidParamList") );
			}
			
			// 插入同步库临时表：
			int tag = tmpRemailStockDefineMapper.insertList( tmpList );
			stockLog.debug("实际插入到临时表的数据量："+tag);
			return new Message(tag!=0,"传入的无效参数列表："+msg.get("invalidParamList"));

		} catch (Exception e) {
			stockLog.error("setRemailStock方法报异常", e);
			return new Message(false,Message.INSERT_DEBUG+"--->"+e.getMessage()+",传入的无效参数列表："+msg.get("invalidParamList"));
		}finally{
			stockLog.debug(" 未日结接受写入接口setRemailStock（多条数据传入）-->结束");
		}
	}

}
