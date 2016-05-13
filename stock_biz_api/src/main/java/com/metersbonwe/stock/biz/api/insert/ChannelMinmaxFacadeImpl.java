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
import com.metersbonwe.stock.dal.auto.sync.mapper.TmpChannelMinmaxMapper;
import com.metersbonwe.stock.dal.define.sync.mapper.TmpChannelMinmaxDefineMapper;
import com.metersbonwe.stock.facade.api.ChannelMinmaxFacade;
import com.metersbonwe.stock.facade.api.bean.ChannelMinmax;
import com.metersbonwe.stock.facade.api.bean.Message;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.sync.TmpChannelMinmax;

/**
 * @author 张洪琴
 * 渠道最大、最小值值变化接收接口实现类
 */
@Service
public class ChannelMinmaxFacadeImpl implements ChannelMinmaxFacade {

	@Resource
	TmpChannelMinmaxMapper tmpChannelMinmaxMapper;
	@Resource
	TmpChannelMinmaxDefineMapper tmpChannelMinmaxDefineMapper;

	private static StockLog stockLog = StockLogFactory
			.getLogger(ChannelMinmaxFacadeImpl.class);
	
	/**
	 * 单个数据有效性检查：如果有效则封装数据
	 * @param channelMinmax
	 * @return
	 */
	private Map<String, Object> checkParam(ChannelMinmax channelMinmax){
		Map<String, Object> msg = new HashMap<String, Object>();
		if(channelMinmax==null){
			msg.put("tag", false);
			msg.put("wrongMsg", "传入的对象不能为空");
		}else if( StringUtils.isEmpty(channelMinmax.getChannelCode()) ){
			msg.put("tag", false);
			msg.put("wrongMsg", "ChannelCode渠道编码不能为空！");
		}else{
			msg.put("tag", true);
			// 封装数据：
			TmpChannelMinmax target = new TmpChannelMinmax();
			BeanUtils.copyProperties(channelMinmax, target);
			if(target.getUpdateTime()==null){
				target.setUpdateTime(new Date());
			}
			msg.put("tmpChannelMinmax", target);
		}
		return msg;
	}
	
	/**
	 * 多个数据有效性检查：如果有效则封装数据
	 * @param channelMinmax
	 * @return
	 */
	private Map<String, Object> checkParamList(List<ChannelMinmax> channelMinmaxList){
		List<TmpChannelMinmax> validParamList = new ArrayList<TmpChannelMinmax>();
		List<ChannelMinmax> invalidParamList = new ArrayList<ChannelMinmax>();
		Map<String, Object> msg = new HashMap<String, Object>();
		
		if(channelMinmaxList==null || channelMinmaxList.size()==0){
			msg.put("tag", false);
			return msg;
		}
		stockLog.debug("传入的参数数量："+channelMinmaxList.size());
		
		for (ChannelMinmax channelMinmax : channelMinmaxList) {
			Map<String, Object> map = checkParam(channelMinmax);
			if( !(Boolean)map.get("tag") ){
				invalidParamList.add(channelMinmax);
			}
			TmpChannelMinmax tmp = (TmpChannelMinmax)map.get("tmpChannelMinmax");
			if(tmp!=null){
				validParamList.add(tmp);				
			}
			
		}		
		msg.put("validParamList", validParamList);
		msg.put("invalidParamList", invalidParamList);
		stockLog.debug("有效参数数量："+validParamList.size());
		stockLog.debug("无效参数数量："+invalidParamList.size());
		return msg;
	}
	
	@Override @LogService("渠道最大、最小值值变化接收接口")
	public Message setChannelMinmax(ChannelMinmax channelMinmax) {
		stockLog.debug("渠道最大、最小值值变化接收接口-->开始");
		stockLog.debug("setChannelMinmax传入的参数是：" + channelMinmax);
		try {
			 Map<String, Object> msg = checkParam(channelMinmax);
			if( !(Boolean)msg.get("tag") ){
				stockLog.error("setChannelMinmax传入的参数无效：" + channelMinmax);
				return new Message(false, Message.PARAMETER_WRONG+"-->"+msg.get("wrongMsg")+",参数信息如下："+channelMinmax);
			}			
			// 插入同步库临时表：
			int tag = this.tmpChannelMinmaxMapper.insertSelective( (TmpChannelMinmax)msg.get("tmpChannelMinmax") );
			return new Message(tag != 0, tag != 0 ? null : Message.INSERT_WRONG);

		} catch (Exception e) {
			stockLog.error("setChannelMinmax报异常", e);
			return new Message(false, Message.INSERT_DEBUG+"--->异常信息："+e.getMessage());
		}finally{
			stockLog.debug("渠道最大、最小值值变化接收接口-->结束");
		}
	}

	@Override  @LogService("渠道最大、最小值值变化接收接口")
	public Message setChannelMinmaxList(List<ChannelMinmax> channelMinmaxList) {
		stockLog.debug("渠道最大、最小值值变化接收接口（多条数据传入）-->开始");
		stockLog.debug("setChannelMinmax传入的参数是：" + channelMinmaxList);
		Map<String, Object> msg = null;
		try {
			
			msg = checkParamList(channelMinmaxList);
			stockLog.debug("传入的无效参数列表："+msg.get("invalidParamList"));
			stockLog.debug("传入的有效参数封装后的列表："+msg.get("validParamList"));
			
			List<TmpChannelMinmax> tmpList = (List<TmpChannelMinmax>)msg.get("validParamList") ;
			if(tmpList.size()==0){
				stockLog.error("setChannelMinmax传入的参数无效：" + msg.get("invalidParamList"));
				return new Message(false, Message.PARAMETER_WRONG+"-->"+msg.get("invalidParamList"));
			}
			// 插入数据到临时表：
			int tag = tmpChannelMinmaxDefineMapper.insertList(tmpList );
			stockLog.debug("渠道最大、最小值值变化接收接口实际插入的数据量："+tag);
			
			return new Message(tag != 0, "传入的无效参数列表："+msg.get("invalidParamList"));
		} catch (Exception e) {
			stockLog.debug("setChannelMinmax报异常", e);
			return new Message(false, Message.INSERT_DEBUG+","+"传入的无效参数列表："+msg.get("invalidParamList"));
		}finally{
			stockLog.debug("渠道最大、最小值值变化接收接口（多条数据传入）-->结束");
		}

	}

}
