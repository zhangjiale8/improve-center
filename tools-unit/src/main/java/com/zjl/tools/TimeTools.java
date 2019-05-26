package com.zjl.tools;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


public class TimeTools {

	public static final String Y_M_D_H_M_S = "yyyy-MM-dd HH:mm:ss";
	public static final String Y_M_D_H_M= "yyyy-MM-dd HH:mm";
	public static final String Y_M_D_H= "yyyy-MM-dd HH";
	public static final String Y_M_D= "yyyy-MM-dd";
	public static final String Y= "yyyy";
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
	
	/**
	 * 获取当前年
	 * @return
	 */
	public static String getCurrentYeart() {
	
		 return new SimpleDateFormat(Y).format(new Date());
	}
	
	/**
	 * 时间段交集
	 * 规则描述： 如果时间段1开始时间早于时间段2开始时间 ，则开始时间取时间段2开始时间
	 * 		  如果时间段1结束时间迟于时间段2的结束时间，则取时间段2结束时间
	 * 		如果时间段1开始时间，时间段1结束时间 都超过时间段2开始时间和结束时间，则取时间段1时间
	 * @param periodPre 时间段1
	 * @param periodAft 时间段2
	 * @return
	 */
	public static JSONObject timeIntersection(JSONObject periodPre,JSONObject periodAft) {
		JSONObject JSONObject = new JSONObject();
		if(null != periodPre && null != periodAft) {
			Date preSt = DateFormate(periodPre.getString("start"),Y_M_D_H_M_S);
			Date aftSt = DateFormate(periodAft.getString("start"),Y_M_D_H_M_S);
			Date preEd = DateFormate(periodPre.getString("end"),Y_M_D_H_M_S);
			Date aftEd = DateFormate(periodAft.getString("end"),Y_M_D_H_M_S);
			boolean stFlg = compareTime(preSt,aftSt);
			boolean edFlg = compareTime(preEd,aftEd);
			if(stFlg && edFlg) {
				JSONObject.put("start", periodAft.getString("start"));
				JSONObject.put("end", periodPre.getString("end"));
			}else if(!stFlg && !edFlg) {
				JSONObject.put("start", periodPre.getString("start"));
				JSONObject.put("end", periodAft.getString("end"));
			}else if(stFlg && !edFlg) {
				JSONObject.put("start", periodAft.getString("start"));
				JSONObject.put("end", periodAft.getString("end"));
			}else if(!stFlg && edFlg) {
				JSONObject.put("start", periodPre.getString("start"));
				JSONObject.put("end", periodPre.getString("end"));
			}
		}
		
		return JSONObject;		
		 
	}
	
	/**
	 * 判断两个时间段是否有交集
	 * @param busy
	 * @param empty
	 * @return
	 */
	public static boolean isPeriodOccr(JSONObject busy,JSONObject empty) {
		if(null != busy && null != empty) {
			Date leftSt = DateFormate(busy.getString("start"),Y_M_D_H_M_S);
			Date leftEd = DateFormate(busy.getString("end"),Y_M_D_H_M_S);
			Date rightSt = DateFormate(empty.getString("start"),Y_M_D_H_M_S);
			Date rightEd = DateFormate(empty.getString("end"),Y_M_D_H_M_S);
			return (leftSt.getTime() >= rightSt.getTime() && leftSt.getTime() < rightEd.getTime())
				||(leftSt.getTime() > rightSt.getTime() && leftSt.getTime() <= rightEd.getTime())
				||(rightSt.getTime() >= leftSt.getTime() && rightSt.getTime() < leftEd.getTime())
				||(rightSt.getTime() > leftSt.getTime() && rightSt.getTime() <= leftEd.getTime());
		}
		return false;
	}
	
	/**
	 * 时间刨除，获取所有空闲时间段
	 * @param list 忙碌时间段
	 * @param start 开始时间
	 * @param end 结束时间
	 * @return
	 */
	public static JSONArray emptyTimeReduce(List<JSONObject> list,Date start,Date end) {
		if(null != start && null != end) {
			List<JSONArray> listEmpty = new LinkedList<JSONArray>();
			JSONArray initEmpty = new JSONArray();
			JSONObject jsonEmpty = new JSONObject();
			jsonEmpty.put("start", DateStr(start,Y_M_D_H_M_S));
			jsonEmpty.put("end", DateStr(end,Y_M_D_H_M_S));
			initEmpty.add(jsonEmpty);
			listEmpty.add(initEmpty);
			if(null != list && list.size() > 0) {
				if(null != listEmpty && listEmpty.size() > 0) {
					int i = 0;
					do {
						JSONObject param = list.get(i);
						Date stBusy =  DateFormate(param.getString("start"),Y_M_D_H_M_S); 
						Date edBusy =  DateFormate(param.getString("end"),Y_M_D_H_M_S);
						initEmpty = listEmpty.get(listEmpty.size() - 1);
						if(null != initEmpty && initEmpty.size()  > 0) {
							JSONArray emptyTempArr = new JSONArray();
							for (int j = 0; j < initEmpty.size(); j++) {
								JSONObject emptyTemp = initEmpty.getJSONObject(j);
								Date stEmpty = DateFormate(emptyTemp.getString("start"),Y_M_D_H_M_S);
								Date edEmpty =  DateFormate(emptyTemp.getString("end"),Y_M_D_H_M_S);
								boolean occr = isPeriodOccr(param, emptyTemp);
								if(occr) {
									if(stEmpty.getTime() >= stBusy.getTime()
									 && stEmpty.getTime() <= edBusy.getTime()) {
										if(edBusy.getTime() != edEmpty.getTime()) {
											JSONObject empty = new JSONObject();
											empty.put("start", param.getString("end"));
											empty.put("end", emptyTemp.getString("end"));
											emptyTempArr.add(empty);
										}
									}else if(edEmpty.getTime() >= stBusy.getTime()
											&& edEmpty.getTime() <= edBusy.getTime()) {
										if(stBusy.getTime() != stEmpty.getTime()) {
											JSONObject empty = new JSONObject();
											empty.put("start", emptyTemp.getString("start"));
											empty.put("end", param.getString("start"));
											emptyTempArr.add(empty);
										}
									}else if(stBusy.getTime() > stEmpty.getTime()
											&& edBusy.getTime() < edEmpty.getTime()) {
										JSONObject emptypre = new JSONObject();
										emptypre.put("start", emptyTemp.getString("start"));
										emptypre.put("end", param.getString("start"));
										emptyTempArr.add(emptypre);
										JSONObject emptylst = new JSONObject();
										emptylst.put("start", param.getString("end"));
										emptylst.put("end", emptyTemp.getString("end"));
										emptyTempArr.add(emptylst);
									}
								}else {
									emptyTempArr.add(emptyTemp);
								}
							}
						}
						i++;
					} while (i < list.size());
				}
				return listEmpty.get(listEmpty.size() - 1);
			}
		}
		return null;
		
		
	}
	/**
	 * Java中Date转化成数据库中Timestamp
	 * @param date
	 * @return
	 */
	public static Timestamp DbTypeTranse(Date date) {
		if(null != date){
			return new java.sql.Timestamp(date.getTime());
		}
		return null;
	}
	
}
