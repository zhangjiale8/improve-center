package com.zjl.lottery.doubleball.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.zjl.lottery.util.MapTxtUtil;
import com.zjl.tools.ArrayTool;

public class OtherTicketScreenUtil {

	public static void screenotherticket(Map<String, Integer> datamap, String filename) {

		Map<String, Integer> otherticketmap =  MapTxtUtil.getOtherTickets();
		//包括开奖结果超过四个
		OtherTicketScreenUtil.screenOtherticketClude(otherticketmap, datamap,filename);
		//包括开奖结果不超过四个
		OtherTicketScreenUtil.screenOtherticketUncolude(otherticketmap, datamap,filename);
		
	}
	
	/**
	 * 包括开奖结果不超过四个
	 * @param: @param otherticketmap
	 * @param: @param datamap
	 * @param: @param filename      
	 */
	public static void screenOtherticketUncolude(Map<String, Integer> otherticketmap, Map<String, Integer> datamap,
			String filename) {
		Map<String, Integer> resultmap = new HashMap<String, Integer>();
		for (Entry<String, Integer> entry : datamap.entrySet()) {
			String combine = entry.getKey();
			int count = entry.getValue();
			String [] tempArr = combine.split(",");
			int max = 0;
			for (Entry<String, Integer> otherticketentry : otherticketmap.entrySet()) {
				String otherticket = otherticketentry.getKey();
				String [] otherticketArr = otherticket.split(",");
				String[] intersectArr = ArrayTool.getIntersectArr(tempArr, otherticketArr);
				if(max < intersectArr.length) {
					max = intersectArr.length;
				}
			}
			if(max < 5) {
				resultmap.put(combine, count);
			}
		}
		MapTxtUtil.createScreenTxtMap(resultmap, filename+"otherticketunclude");
	}
	/**
	 * 包括开奖结果超过四个
	 * @param: @param otherticketmap
	 * @param: @param datamap
	 * @param: @param filename      
	 */
	public static void screenOtherticketClude(Map<String, Integer> otherticketmap, Map<String, Integer> datamap,
			String filename) {
		Map<String, Integer> resultmap = new HashMap<String, Integer>();
		for (Entry<String, Integer> entry : datamap.entrySet()) {
			String combine = entry.getKey();
			int count = entry.getValue();
			String [] tempArr = combine.split(",");
			int max = 0;
			for (Entry<String, Integer> otherticketentry : otherticketmap.entrySet()) {
				String otherticket = otherticketentry.getKey();
				String [] otherticketArr = otherticket.split(",");
				String[] intersectArr = ArrayTool.getIntersectArr(tempArr, otherticketArr);
				if(max < intersectArr.length) {
					max = intersectArr.length;
				}
			}
			if(max >= 5) {
				resultmap.put(combine, count);
			}
		}
		MapTxtUtil.createScreenTxtMap(resultmap, filename+"otherticketclude");
	}

}
