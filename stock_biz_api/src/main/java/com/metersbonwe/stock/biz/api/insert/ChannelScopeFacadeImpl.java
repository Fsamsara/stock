package com.metersbonwe.stock.biz.api.insert;

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
import com.metersbonwe.stock.dal.auto.sync.mapper.TmpChannelScopeMapper;
import com.metersbonwe.stock.dal.define.sync.mapper.TmpChannelScopeDefineMapper;
import com.metersbonwe.stock.facade.api.ChannelScopeFacade;
import com.metersbonwe.stock.facade.api.bean.ChannelScope;
import com.metersbonwe.stock.facade.api.bean.Message;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.sync.TmpChannelScope;

/**
 * @author 张洪琴 渠道仓|店配发范围变化写入接口实现类
 */
@Service
public class ChannelScopeFacadeImpl implements ChannelScopeFacade {

	@Resource
	TmpChannelScopeMapper tmpChannelScopeMapper;// 同步库的TMP_CHANNEL_SCOPE表的mapper
	@Resource
	TmpChannelScopeDefineMapper tmpChannelScopeDefineMapper;

	private static StockLog stockLog = StockLogFactory
			.getLogger(ChannelScopeFacadeImpl.class);
	
	/**
	 * 单个数据检查，如果是有效参数：封装
	 * @param channelScope
	 * @return
	 */
	private Map<String, Object> checkParam(ChannelScope channelScope){
		Map<String, Object> msg = new HashMap<String, Object>();
		if(channelScope==null){
			msg.put("tag", false);
			msg.put("wrongMsg", "传入的对象不能为空！");
		}else if(
				StringUtils.isEmpty(channelScope.getChannelCode()) ||
				StringUtils.isEmpty(channelScope.getScopeChange()) ||
				StringUtils.isEmpty(channelScope.getWarehId()) ||
				StringUtils.isEmpty(channelScope.getWarehState()) 
				){
			msg.put("tag", false);
			msg.put("wrongMsg", "传入的对象属性不能为空！");
		}else{
			TmpChannelScope tcs = new TmpChannelScope();
			BeanUtils.copyProperties(channelScope, tcs);
			//scopeChange;warehState 手动封装
			tcs.setScopeChange(channelScope.getScopeChange().toString());
			tcs.setWarehState(channelScope.getWarehState().toString());
			if(tcs.getUpdateTime()==null){
				tcs.setUpdateTime(new Date());
			}
			msg.put("tag", true);
			msg.put("tmpChannelScope", tcs);
		}
		return msg;
	}
	
	/**
	 * 多条数据的检查、有效数据的封装
	 * @param channelScopeList
	 * @return
	 */
	private Map<String,Object> checkParamList(List<ChannelScope> channelScopeList){
		List<ChannelScope> invalidParamList = new ArrayList<ChannelScope>();
		List<TmpChannelScope> validParamList = new ArrayList<TmpChannelScope>();
		Map<String,Object> msg = new HashMap<String, Object>();
		if(channelScopeList==null || channelScopeList.size()==0){
			msg.put("tag", false);
			return msg;
		}
		stockLog.debug("传入的参数数量："+channelScopeList.size());
		
		for (ChannelScope channelScope : channelScopeList) {
			Map<String, Object> map = checkParam(channelScope);
			if( !(Boolean)map.get("tag") ){
				invalidParamList.add(channelScope);
			}
			TmpChannelScope tmp = (TmpChannelScope)map.get("tmpChannelScope");
			if(tmp!=null){
				validParamList.add(tmp);				
			}			
		}
		msg.put("invalidParamList", invalidParamList);
		msg.put("validParamList", validParamList);
		stockLog.debug("有效参数数量："+validParamList.size());
		stockLog.debug("无效参数数量："+invalidParamList.size());
		return msg;
	}
	 
	@Override  @LogService("渠道仓|店配发范围变化写入接口")
	public Message channelScopeChange(ChannelScope channelScope) {
		stockLog.debug("渠道仓|店配发范围变化写入接口channelScopeChange-->开始");
		stockLog.debug("channelScopeChange传入的参数为" + channelScope);
		Map<String, Object> msg = null;
		try {

			msg = checkParam(channelScope);
			if( !(Boolean)msg.get("tag") ){
				stockLog.error("传入的参数无效："+channelScope);
				return new Message(false, (String)msg.get("wrongMsg")+",传入的参数："+channelScope);
			}
			// 将封装好的数据插入到同步库的TMP_CHANNEL_SCOPE表中：
			int tag = this.tmpChannelScopeMapper.insertSelective( (TmpChannelScope)msg.get("tmpChannelScope") );// this.apiTmpChannelScopeMapper.insertSingle(tcs);
			stockLog.debug("channelScopeChange传入的参数为插入TMP_CHANNEL_SCOPE的结果：" + tag);
			// 返回插入的结果：插入成功为true,插入失败为false
			return new Message(tag != 0, tag != 0 ? null : Message.INSERT_WRONG);

		} catch (BeansException e) {
			stockLog.error("channelScopeChange报异常" , e);
			return new Message(false, Message.INSERT_DEBUG);
		}finally{
			stockLog.debug("渠道仓|店配发范围变化写入接口channelScopeChange-->结束");
		}

	}

	@Override @LogService("渠道仓|店配发范围变化写入接口")
	public Message channelScopeChangeList(List<ChannelScope> channelScopeList) {
		stockLog.debug("渠道仓|店配发范围变化写入接口channelScopeChange（多条数据传入）-->开始");
		stockLog.debug("channelScopeChange传入的参数是：" + channelScopeList);
		Map<String,Object> msg = null;
		try {
			msg = checkParamList(channelScopeList);			
			stockLog.debug("channelScopeChange传入的参数无效数据列表：" + msg.get("invalidParamList"));
			stockLog.debug("channelScopeChange传入有效数据封装后的列表：" + msg.get("validParamList"));
			
			List<TmpChannelScope> tmpList = (List<TmpChannelScope>)msg.get("validParamList");
			if(tmpList.size()==0){
				stockLog.error("传入的参数无效："+msg.get("invalidParamList"));
				return new Message(false, "channelScopeChange传入的参数无效数据列表：" + msg.get("invalidParamList"));
			}
			// 将封装好的数据插入到同步库的TMP_CHANNEL_SCOPE表中：
			int tag = tmpChannelScopeDefineMapper.insertList( tmpList );
			stockLog.debug("channelScopeChange实际插入临时表的数量：" + tag);
			// 返回
			return new Message(tag != 0, "传入的参数无效数据列表:" + msg.get("invalidParamList"));
		} catch (Exception e) {
			stockLog.error("channelScopeChange方法报异常", e);
			return new Message(false, Message.INSERT_DEBUG+",异常信息："+e.getMessage()+",无效的参数列表："+msg.get("invalidParamList"));
		}finally{
			stockLog.debug("渠道仓|店配发范围变化写入接口channelScopeChange（多条数据传入）-->结束");
		}
	}

}
