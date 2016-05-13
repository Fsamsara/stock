package com.metersbonwe.stock.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	public static void main(String[] args) {
		System.out.print(getBeforeTime(new Date(), -10));
	}
	
	/**
	 * 将指定格式的字符串时间转换为日期格式
	 * @param dateStr
	 * @param dateFormatStr
	 * @return
	 */
	public static Date getDateFromStr(String dateStr, String dateFormatStr){
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormatStr);
		Date resultDate = null;
		try {
			resultDate = sdf.parse(dateStr);
		} catch (ParseException e) {
			resultDate = new Date();
		}
		return resultDate;
	}
	
	/**
	 * 获取大于或者小于指定日期的日期
	 * @param date 指定日期
	 * @param day 1表示明天|-1表示昨天
	 * @return 
	 */
	public static Date getBeforeDay(Date date, int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		cal.add(Calendar.DATE, day);
		
		return cal.getTime();
	}
	
	/**
	 * 获取大于或者小于指定日期的日期
	 * @param date 指定日期
	 * @param minute +表示加|-表示减
	 * @return 
	 */
	public static Date getBeforeTime(Date date, int minute) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		cal.add(Calendar.MINUTE, minute);
		return cal.getTime();
	}
}
