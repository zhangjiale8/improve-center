package com.zjl.lottery.doubleball.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


import com.zjl.tools.ArrayTool;

public class TailUtil {
	
	/**
	 * 获取每期开奖尾数
	 * @return
	 */
	public static Map<String, String> getPeriodTailsMap() {

		Map<String, String> historymap =  HistoryUtil.getPeriodHistoryMap();
		Map<String, String> periodtailsmap = new HashMap<String, String>();
		for (Entry<String, String> entry : historymap.entrySet()) {
			Map<String, Integer> tailmap =  new HashMap<String, Integer>();
			String[] drawstrarr = entry.getValue().split(",");
			int[] drawintarr = ArrayTool.strArr2InArr(drawstrarr);
			for (int i = 0; i < drawintarr.length; i++) {
				String tail = drawintarr[i] %10 +"";
				tailmap.put(tail, 1);
			}
			
			String tailstr = "";
			for (Entry<String, Integer> tailentry : tailmap.entrySet()) {
				tailstr += tailentry.getKey()+",";
			}
			tailstr = tailstr.substring(0,tailstr.length() -1);
			String[] tailstrarr = tailstr.split(",");
			int[] tailintarr = ArrayTool.strArr2InArr(tailstrarr);
			ArrayTool.sort(tailintarr);
			String tailintstr = "";
			for (int i = 0; i < tailintarr.length; i++) {
				tailintstr += tailintarr[i]+",";
			}
			tailintstr = tailintstr.substring(0, tailintstr.length()-1);
			periodtailsmap.put(entry.getKey(), tailintstr);
					
		}
		
		return periodtailsmap;
	
	}
	/**
	 * 尾数统计
	 * @return
	 */
	public static Map<String, Integer> getTailsStatisticsMap() {
		Map<String, Integer> tailsmap = new HashMap<String, Integer>();
		Map<String, String> periodtailsmap = TailUtil.getPeriodTailsMap();
		for (Entry<String, String> entry : periodtailsmap.entrySet()) {
			Integer count = tailsmap.get(entry.getValue());
			if(null != count){
				count ++;
			}else{
				count = 1;
			}
			tailsmap.put(entry.getValue(), count);
		}
		return tailsmap;
	}
	/**
	 * 获取组合尾数数组
	 * @param drawarr
	 * @return
	 */
	public static String[] getTailsArry(String[] drawarr) {
		int[] drawintarr = ArrayTool.strArr2InArr(drawarr);
		Map<String, Integer> tailmap =  new HashMap<String, Integer>();
		for (int i = 0; i < drawintarr.length; i++) {
			String tail = drawintarr[i] %10 +"";
			tailmap.put(tail, 1);
		}
		String tailstr = "";
		for (Entry<String, Integer> tailentry : tailmap.entrySet()) {
			tailstr += tailentry.getKey()+",";
		}
		tailstr = tailstr.substring(0,tailstr.length() -1);
		String[] tailstrarr = tailstr.split(",");
		return tailstrarr;
	}
	
	/**
	 * 获取组合尾数字符串
	 * @param drawarr
	 * @return
	 */
	public static String getTailsStr(String[] drawarr) {
		int[] drawintarr = ArrayTool.strArr2InArr(drawarr);
		Map<String, Integer> tailmap =  new HashMap<String, Integer>();
		for (int i = 0; i < drawintarr.length; i++) {
			String tail = drawintarr[i] %10 +"";
			tailmap.put(tail, 1);
		}
		String tailstr = "";
		for (Entry<String, Integer> tailentry : tailmap.entrySet()) {
			tailstr += tailentry.getKey()+",";
		}
		tailstr = tailstr.substring(0,tailstr.length() -1);
		
		return tailstr;
	}
	/**
	 * 计算两个数组相同尾数的个数
	 * @param tails
	 * @param comptails
	 * @return
	 */
	public static int getCountSameTail(String[] tails, String[] comptails) {
		int count = 0;
		String [] tailsarr = TailUtil.getTailsArry(tails);
		String [] comptailsarr = TailUtil.getTailsArry(comptails);
		String[] intersectArr = ArrayTool.getIntersectArr(tailsarr, comptailsarr);
		if(null != intersectArr){
			count = intersectArr.length;
		}
		
		return count;
	}
	
	/**
	 * 计算两个数组相同尾数的个数
	 * @param tails
	 * @param comptails
	 * @return
	 */
	public static int getCountSameTail(int[] tails, int[] comptails) {
		int count = 0;
		String [] tailsarr = TailUtil.getTailsArry(ArrayTool.intArr2StrArr(tails));
		String [] comptailsarr = TailUtil.getTailsArry(ArrayTool.intArr2StrArr(comptails));
		String[] intersectArr = ArrayTool.getIntersectArr(tailsarr, comptailsarr);
		if(null != intersectArr){
			count = intersectArr.length;
		}
		
		return count;
	}

}
