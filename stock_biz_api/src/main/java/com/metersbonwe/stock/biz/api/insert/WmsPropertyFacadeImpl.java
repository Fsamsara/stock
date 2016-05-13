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
import com.metersbonwe.stock.dal.auto.sync.mapper.TmpWmsPropertyMapper;
import com.metersbonwe.stock.dal.define.sync.mapper.TmpWmsPropertyDefineMapper;
import com.metersbonwe.stock.facade.api.WmsPropertyFacade;
import com.metersbonwe.stock.facade.api.bean.Message;
import com.metersbonwe.stock.facade.api.bean.WmsProperty;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.sync.TmpWmsProperty;

/**
 * @author 张洪琴 仓WMS属性变化接口实现类
 */
@Service
public class WmsPropertyFacadeImpl implements WmsPropertyFacade {

	@Resource
	TmpWmsPropertyMapper tmpWmsPropertyMapper;

	@Resource
	TmpWmsPropertyDefineMapper tmpWmsPropertyDefineMapper;

	//
	private static StockLog stockLog = StockLogFactory
			.getLogger(WmsPropertyFacadeImpl.class);
	
	/**
	 * 单条数据的有效性检查：如果有效则对数据进行封装
	 * @param wmsProperty
	 * @return
	 */
	private Map<String, Object> checkParam(WmsProperty wmsProperty){
		Map<String, Object> msg = new HashMap<String, Object>();
		if( wmsProperty==null ||
				StringUtils.isEmpty(wmsProperty.getWarehId()) ||
				StringUtils.isEmpty( wmsProperty.getUsedMa())
				){
			msg.put("tag", false);
		}else{
			// 创建stock_po中对应的TmpWmsProperty类：
			TmpWmsProperty target = new TmpWmsProperty();
			// 将facade中的TmpWmsProperty类重新封装成stock_po中的TmpWmsProperty类
			BeanUtils.copyProperties(wmsProperty, target);
			if(target.getUpdateTime()==null){
				target.setUpdateTime(new Date());
			}
			msg.put("tag", true);
			msg.put("tmpWmsProperty", target);
		}
		return msg;
	}
	
	/**
	 * 多条数据的有效性检查：如果有效则对数据进行封装
	 * @param wmsProperty
	 * @return
	 */
	private Map<String, Object> checkParamList(List<WmsProperty> wmsPropertyList){
		Map<String, Object> msg = new HashMap<String, Object>();
		List<TmpWmsProperty> validParamList = new ArrayList<TmpWmsProperty>();
		List<WmsProperty> invalidParamList = new ArrayList<WmsProperty>();
		//
		if(wmsPropertyList==null || wmsPropertyList.size()==0){
			msg.put("tag", false);
			return msg;
		}
		stockLog.debug("传入的参数数据量："+wmsPropertyList.size());
		for (WmsProperty wmsProperty : wmsPropertyList) {
			Map<String, Object> map = checkParam(wmsProperty);
			if( !(boolean)map.get("tag") ){
				invalidParamList.add(wmsProperty);
			}
			TmpWmsProperty tmp = (TmpWmsProperty)map.get("tmpWmsProperty");
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
	
	@Override @LogService("仓WMS属性变化接口")
	public Message setWmsPropert(WmsProperty wmsProperty) {
		stockLog.debug("仓WMS属性变化接口setWmsPropert-->开始");
		stockLog.debug("setWmsPropert传入的参数是：" + wmsProperty);

		try {
			
			Map<String, Object> map = checkParam(wmsProperty);
			
			if( !(boolean)map.get("tag") ){
				stockLog.error("setWmsPropert传入的参数无效：" + wmsProperty);
				return new Message(false, Message.PARAMETER_WRONG+"--->"+wmsProperty );				
			}
			// 将重新封装好的数据插入临时表TMP_WMS_PROPERTY
			int tag = this.tmpWmsPropertyMapper.insertSelective( (TmpWmsProperty)map.get("tmpWmsProperty") );
			// 返回插入的的结果
			return new Message(tag != 0, tag != 0 ? null: Message.INSERT_WRONG);
			
		} catch (BeansException e) {
			stockLog.error("setWmsPropert出现异常："	+ e.getMessage(),e);
			return new Message(false, Message.INSERT_DEBUG);
		}finally{
			stockLog.debug("仓WMS属性变化接口setWmsPropert-->结束");
		}
	}

	@Override @LogService("仓WMS属性变化接口")
	public Message setWmsPropertList(List<WmsProperty> wmsPropertyList) {
		stockLog.debug("仓WMS属性变化接口setWmsPropert（多条数据传入）-->开始");
		stockLog.debug("setWmsPropert传入的参数是：" + wmsPropertyList);
		Map<String, Object> msg = null;
		try {
			
			msg = checkParamList(wmsPropertyList);
			stockLog.debug("setWmsPropert传入的无效参数列表：" + msg.get("invalidParamList") );
			stockLog.debug("setWmsPropert传入的有效参数封装后的列表：" + msg.get("validParamList") );
			
			List<TmpWmsProperty> tmpList = (List<TmpWmsProperty>)msg.get("validParamList");
			if ( tmpList.size()==0 ) {
				stockLog.error("setWmsPropert传入的参数无效：" + msg.get("invalidParamList") );
				return new Message(false, Message.PARAMETER_WRONG+"-->"+"setWmsPropert传入的无效参数列表：" + msg.get("invalidParamList"));
			} 
			
			//
			stockLog.debug("需要插入到TMP_WMS_PROPERTY的数据量："+tmpList.size());
			// 将重新封装好的数据插入临时表TMP_WMS_PROPERTY
			int tag = tmpWmsPropertyDefineMapper.insertList(tmpList);
			stockLog.debug("插入到TMP_WMS_PROPERTY的数据量："+tag);
			// 返回插入的的结果
			return new Message(tag != 0, "setWmsPropert传入的无效参数列表：" + msg.get("invalidParamList") );
			
		} catch (BeansException e) {
			stockLog.error("setWmsPropert【单数据写入】方法报异常："	+ e.getMessage(),e);
			return new Message(false, Message.INSERT_DEBUG+"-->异常信息："+e.getMessage()+",setWmsPropert传入的无效参数列表：" + msg.get("invalidParamList"));
		}finally{
			stockLog.debug("仓WMS属性变化接口setWmsPropert（多条数据传入）-->结束");
		}
	}

}
