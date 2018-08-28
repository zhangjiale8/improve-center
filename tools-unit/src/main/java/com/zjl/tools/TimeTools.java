package com.zjl.tools;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


public class TimeTools {

	public static final String Y_M_D_H_M_S = "yyyy-MM-dd HH:mm:ss";
	public static final String Y_M_D_H_M= "yyyy-MM-dd HH:mm";
	public static final String Y_M_D_H= "yyyy-MM-dd HH";
	public static final String Y_M_D= "yyyy-MM-dd";
	public static final int SECONDS_IN_DAY = 60 * 60 * 24;
	public static final long MILLIS_IN_DAY = 1000L * SECONDS_IN_DAY;
	
	/**
	 * 时间转字符串
	 * @param date
	 * @param reg
	 * @return
	 */
	public static String DateStr(Date date, String reg) {
		if(StringUtils.isNotEmpty(reg) && null != date){
			if(Y_M_D_H_M_S.equals(reg)){
				return new SimpleDateFormat(Y_M_D_H_M_S).format(date);
			}else if(Y_M_D_H_M.equals(reg)){
				return new SimpleDateFormat(Y_M_D_H_M).format(date);
			}else if(Y_M_D_H.equals(reg)){
				return new SimpleDateFormat(Y_M_D_H).format(date);
			}else if(Y_M_D.equals(reg)){
				return new SimpleDateFormat(Y_M_D).format(date);
			}
			
		}
		return null;
	}
	
	/**
	 * 字符串转时间
	 * @param dateStr
	 * @param reg
	 * @return
	 */
	public static Date DateFormate(String dateStr, String reg) {
		if(StringUtils.isNotEmpty(reg) && StringUtils.isNotEmpty(reg)){
			try {
				if(Y_M_D_H_M_S.equals(reg)){
					return new SimpleDateFormat(Y_M_D_H_M_S).parse(dateStr);
				}else if(Y_M_D_H_M.equals(reg)){
					return new SimpleDateFormat(Y_M_D_H_M).parse(dateStr);
				}else if(Y_M_D_H.equals(reg)){
					return new SimpleDateFormat(Y_M_D_H).parse(dateStr);
				}else if(Y_M_D.equals(reg)){
					return new SimpleDateFormat(Y_M_D).parse(dateStr);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	/**
	 * 跨天时间分割
	 * @param start
	 * @param end
	 * @return
	 */
	public static JSONArray TimeDivision(String start, String end) {
		if(StringUtils.isNotEmpty(start) && StringUtils.isNotEmpty(end)){
			start = DateStr(DateFormate(start,Y_M_D_H_M_S), Y_M_D_H_M_S);
			end = DateStr(DateFormate(end,Y_M_D_H_M_S), Y_M_D_H_M_S);
			JSONArray jsonArr = new JSONArray();
			if(ExtendDay(start,end)){
				do{
					JSONObject jsonObj = new JSONObject();
					jsonObj.put("start", start);
					long stTemp = DateFormate(start,Y_M_D).getTime();
					Calendar calendar = Calendar.getInstance();//获取日历实例  
					calendar.setTime(new Date(stTemp)); 
					calendar.add(Calendar.DAY_OF_MONTH, 1);  //设置为后一天
					start= DateStr(calendar.getTime(), Y_M_D_H_M_S);
					jsonObj.put("end", start);
					jsonArr.add(jsonObj);
				}while(ExtendDay(start,end));
				if(!start.equals(end)){
					JSONObject jsonObj = new JSONObject();
					jsonObj.put("start", start);
					jsonObj.put("end", end);
					jsonArr.add(jsonObj);
				}
			}else{
				JSONObject jsonObj = new JSONObject();
				jsonObj.put("start", start);
				jsonObj.put("end", end);
				jsonArr.add(jsonObj);
			}
			return jsonArr;
		}
		return null;
	}
	
	/**
	 * 时间是否跨天
	 * 结束时间为第二天零点不算跨天
	 * @param start
	 * @param end
	 * @return
	 */
	public static boolean ExtendDay(String start, String end) {
		try {
			long stTimeStamp = DateFormate(start,Y_M_D).getTime();
			long edTimeStamp = DateFormate(end,Y_M_D).getTime();
			if(edTimeStamp > stTimeStamp){
				Calendar calendar = Calendar.getInstance();//获取日历实例  
				calendar.setTime(new Date(stTimeStamp)); 
				calendar.add(Calendar.DAY_OF_MONTH, 1);  //设置为后一天
				String tomorrow= DateStr(calendar.getTime(), Y_M_D_H_M_S);
				if(!tomorrow.equals(end)){
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return false;
	}
	
	/**
	 * 获取后一天
	 * @param time
	 * @return
	 */
	public static String getTomorrow(String time) {
		String result = "";
		if(StringUtils.isNotEmpty(time)){
			long timeStamp = DateFormate(time,Y_M_D_H_M_S).getTime();
			Calendar calendar = Calendar.getInstance();//获取日历实例  
			calendar.setTime(new Date(timeStamp)); 
			calendar.add(Calendar.DAY_OF_MONTH, 1);  //设置为后一天
			result = DateStr(calendar.getTime(), Y_M_D_H_M_S);
		}
		return result;
	}
	
	/**
	 * 获取前一天
	 * @param time
	 * @return
	 */
	public static String getYesterday(String time) {
		String result = "";
		if(StringUtils.isNotEmpty(time)){
			long timeStamp = DateFormate(time,Y_M_D_H_M_S).getTime();
			Calendar calendar = Calendar.getInstance();//获取日历实例  
			calendar.setTime(new Date(timeStamp)); 
			calendar.add(Calendar.DAY_OF_MONTH, -1);  //设置为后一天
			result = DateStr(calendar.getTime(), Y_M_D_H_M_S);
		}
		return result;
	}
	
	public static void main(String[] args) {
		Date start = DateFormate("2018-07-26 08:00:00",TimeTools.Y_M_D_H_M_S);
		Date end = DateFormate("2018-07-26 08:00:00",TimeTools.Y_M_D_H_M_S);
		boolean flag = TimeTools.compareTime(start,end);
		Date firstday = TimeTools.getCurrentMonthFirst(new Date());
		Date lastday = TimeTools.getCurrentMonthLast(new Date());
		System.out.println(DateStr(firstday,TimeTools.Y_M_D_H_M_S));
		System.out.println(DateStr(lastday,TimeTools.Y_M_D_H_M_S));
		
	}
	/**
	 * 获取某个时间当前月最后一天
	 * @param date
	 * @return
	 */
	public static Date getCurrentMonthLast(Date date) {
		if(null != date) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.MONTH, 1);
			cal.set(Calendar.DAY_OF_MONTH, 0);
			return cal.getTime();
		}
		return null;
	}
	/**
	 * 获取某个时间当前月第一天
	 * @param date
	 * @return
	 */
	public static Date getCurrentMonthFirst(Date date) {
		if(null != date) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.MONTH, 0);
			cal.set(Calendar.DAY_OF_MONTH, 1);
			return cal.getTime();
		}
		return null;
	}

	/**
	 * 时间比较
	 * @param start
	 * @param end
	 * @return
	 */
	public static boolean compareTime(Date start, Date end) {
		if(null != start && null != end) {
			if(start.getTime() < end.getTime()) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 获取多个时间中距离某个时间最近的时间（只适用于数组中数据度不为空的情况）
	 *时间间隔取绝对值
	 * @param dateArrParam
	 * @param param
	 * @return
	 */
	public static Date getMinDistanceTime(Date[] dateArrParam, Date param) {
		if(null != dateArrParam && dateArrParam.length > 0 && null != param) {
			// 初始化最近时间，默认为第一个
	        long minDiff = Math.abs(param.getTime() - dateArrParam[0].getTime());
	        int min = 0;
	        for (int i = 0; i < dateArrParam.length; i++) {
	            long diff = Math.abs(param.getTime() - dateArrParam[i].getTime());
	            if (diff < minDiff) {
	                min = i;
	                minDiff = diff;
	            }
	        }
	        return dateArrParam[min];
		}
		return null;
	}
}
