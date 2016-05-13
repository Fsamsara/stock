package com.metersbonwe.stock.facade.api.bean;

import java.io.Serializable;

/**
 * @author dell
 * 接口返回结果包装类
 */
public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//调用API接口出现错误的常量定义
	public static final String PARAMETER_WRONG =" 传入的参数无效！ ";
	
	public static final String INSERT_DEBUG =" 传入的参数插入数据库出现异常！ ";
	
	public static final String INSERT_WRONG =" 传入的参数插入数据库失败！ ";
	
	//
	private Boolean isSetData;

	private String message;

	public Message() {
		
	}

	public Message(Boolean isSetData, String message) {
		super();
		this.isSetData = isSetData;
		this.message = message;
	}

	public Boolean getIsSetData() {
		return isSetData;
	}

	public void setIsSetData(Boolean isSetData) {
		this.isSetData = isSetData;
	}

	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Message [isSetData=" + isSetData + ", message="
				+ message + "]";
	}

}
