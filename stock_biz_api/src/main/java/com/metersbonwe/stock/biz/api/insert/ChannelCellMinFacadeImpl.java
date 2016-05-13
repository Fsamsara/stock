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
import com.metersbonwe.stock.dal.auto.sync.mapper.TmpChannelCellMinMapper;
import com.metersbonwe.stock.dal.define.sync.mapper.TmpChannelCellMinDefineMapper;
import com.metersbonwe.stock.facade.api.ChannelCellMinFacade;
import com.metersbonwe.stock.facade.api.bean.ChannelCellMin;
import com.metersbonwe.stock.facade.api.bean.Message;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.sync.TmpChannelCellMin;

/**
 * @author 张洪琴
 * 渠道单元最小值变化接收接口实现类
 */
@Service
public class ChannelCellMinFacadeImpl implements ChannelCellMinFacade {
	
	private static StockLog stockLog = StockLogFactory
			.getLogger(ChannelCellMinFacadeImpl.class);
	
	@Resource
	TmpChannelCellMinDefineMapper tmpChannelCellMinDefineMapper;
	@Resource
	TmpChannelCellMinMapper tmpChannelCellMinMapper;	
	
	/**
	 * 判断传入的参数数据有效性，如果有效，则封装好数据
	 * @param channelCellMin
	 * @return
	 */
	private Map<String, Object> checkParam(ChannelCellMin channelCellMin){
		Map<String, Object> msg = new HashMap<String, Object>();
		if(channelCellMin==null){
			msg.put("tag", false);
			msg.put("wrongMsg", "传入的对象不能为空！");
		}else if(
				StringUtils.isEmpty(channelCellMin.getChannelCode()) ||
				StringUtils.isEmpty(channelCellMin.getProdId()) ||
				channelCellMin.getChannelCellMin()==null
				){
			msg.put("tag", false);
			msg.put("wrongMsg", "传入的参数属性不能为空值！");
		}else{
			msg.put("tag", true);
			if(channelCellMin.getUpdateTime()==null){
				channelCellMin.setUpdateTime(new Date());
			}
			//封装数据：
			TmpChannelCellMin target = new TmpChannelCellMin();
			BeanUtils.copyProperties(channelCellMin, target);
			//Integer到BigDecimal的数据封装  手动：channelCellMin
			target.setChannelCellMin(BigDecimal.valueOf(channelCellMin.getChannelCellMin()));
			msg.put("tmpChannelCellMin", target);
		}
		return msg;
	}
	
	
	/**
	 * 判断传入的参数数据有效性，如果有效，则封装好数据
	 * @param list
	 * @return
	 */
	private Map<String, Object> checkParamList(List<ChannelCellMin> list){
		//申明封装有效数据的变量：
		List<TmpChannelCellMin> validParamList = new ArrayList<TmpChannelCellMin>();
		//申明保存无效数据的变量：
		List<ChannelCellMin> invalidParamList = new ArrayList<ChannelCellMin>();
		Map<String, Object> msg = new HashMap<String, Object>(); 
		if(list==null || list.size()==0){
			msg.put("tag", false);
			return msg;
		}
		
		stockLog.debug("传入的参数数量："+list.size());
		
		for (ChannelCellMin channelCellMin : invalidParamList) {
			Map<String, Object> map = checkParam(channelCellMin);
			if( !(Boolean)map.get("tag") ){
				invalidParamList.add(channelCellMin);
			}
			TmpChannelCellMin tmp = (TmpChannelCellMin)map.get("tmpChannelCellMin") ;
			if(tmp!=null){
				validParamList.add( tmp );				
			}
		}		
		msg.put("validParamList", validParamList);
		stockLog.debug("有效参数数量："+validParamList.size());
		msg.put("invalidParamList", invalidParamList);
		stockLog.debug("无效参数数量："+invalidParamList.size());
		
		return msg;
	}
	
	
	@Override @LogService("渠道单元最小值变化接收接口") 
	public Message setChannelCellMin(ChannelCellMin channelCellMin) {
		stockLog.debug("渠道单元最小值变化接收接口setChannelCellMin-->开始");
		stockLog.debug("setChannelCellMin传入的参数是："+channelCellMin);
		Map<String, Object> msg = null;
		try {
			msg = checkParam(channelCellMin);
			if( !(Boolean)msg.get("tag") ){
				stockLog.error("setChannelCellMin传入的参数无效："+channelCellMin);
				return new Message(false,Message.PARAMETER_WRONG+"--->"+msg.get("wrongMsg")+",传入的参数："+channelCellMin);
			}
			
			//插入同步库临时表：
			int tag = this.tmpChannelCellMinMapper.insertSelective( (TmpChannelCellMin)msg.get("tmpChannelCellMin") );
			stockLog.debug("setChannelCellMin传入的参数插入临时表的行数："+tag);
			return new Message( tag!=0, tag!=0?null:Message.INSERT_WRONG);
			
		} catch (Exception e) {
			stockLog.error("setChannelCellMin报异常！传入的参数是："+channelCellMin,e);
			return new Message(false,Message.INSERT_DEBUG+",异常原因："+e.getMessage());
		}finally{
			stockLog.debug("渠道单元最小值变化接收接口setChannelCellMin-->结束");
		}

	}

	@Override @LogService("渠道单元最小值变化接收接口") 
	public Message setChannelCellMinList(List<ChannelCellMin> channelCellMinList) {
		stockLog.debug("渠道单元最小值变化接收接口setChannelCellMin（多条数据传入）-->开始");
		stockLog.debug("setChannelCellMin传入的参数是："+channelCellMinList);
		Map<String, Object> msg = null;
		try {
			//检查数据有效性，封装有效数据
			msg = checkParamList(channelCellMinList);			
			stockLog.debug("setChannelCellMin传入的参数无效的列表如下："+msg.get("invalidParamList"));
			stockLog.debug("setChannelCellMin传入的参数有效列表封装结果如下："+msg.get("validParamList"));
			
			List<TmpChannelCellMin> tmpList = (List<TmpChannelCellMin>)msg.get("validParamList");
			if(tmpList.size()==0){
				stockLog.error( "传入的参数无效："+msg.get("invalidParamList") );
				return new Message(false,Message.PARAMETER_WRONG+"--->传入的参数："+msg.get("invalidParamList"));
			}
			//插入数据到临时表：
			int tag = tmpChannelCellMinDefineMapper.insertList( tmpList);
			stockLog.debug("setChannelCellMin实际插入临时表的数据量是："+tag);
			//返回结果
			return new Message( tag!=0,"传入的无效参数列表："+msg.get("validParamList"));
		} catch (Exception e) {
			stockLog.error("setChannelCellMin报异常：",e);
			return new Message(false,Message.INSERT_DEBUG+",无效参数如下："+msg.get("invalidParamList"));
		}finally{
			stockLog.debug("渠道单元最小值变化接收接口setChannelCellMin(多条数据传入)-->结束");
		}		

	}

}
