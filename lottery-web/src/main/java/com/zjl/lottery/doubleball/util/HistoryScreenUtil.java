package com.zjl.lottery.doubleball.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.zjl.tools.ArrayTool;

public class HistoryScreenUtil {
	/**
	 * 过滤历史开奖记录
	 * @param: @param datamap
	 * @param: @param filename      
	 */
	public static void screenhistory(Map<String, Integer> datamap, String filename) {
		Map<String, Integer> historymap =  HistoryUtil.getHistoryMap();
		//包括开奖结果超过四个
		HistoryScreenUtil.screenHistoryClude(historymap, datamap,filename);
		//包括开奖结果不超过四个
		HistoryScreenUtil.screenHistoryUncolude(historymap, datamap,filename);
		
	}
	/**
	 * 包括开奖结果不超过四个
	 * @param: @param historymap
	 * @param: @param datamap
	 * @param: @param filename      
	 */
	public static void screenHistoryUncolude(Map<String, Integer> historymap, Map<String, Integer> datamap,
			String filename) {
		Map<String, Integer> resultmap = new HashMap<String, Integer>();
		for (Entry<String, Integer> entry : datamap.entrySet()) {
			String combine = entry.getKey();
			int count = entry.getValue();
			String [] tempArr = combine.split(",");
			int max = 0;
			for (Entry<String, Integer> historyentry : historymap.entrySet()) {
				String history = historyentry.getKey();
				String [] historyArr = history.split(",");
				String[] intersectArr = ArrayTool.getIntersectArr(tempArr, historyArr);
				if(max < intersectArr.length) {
					max = intersectArr.length;
				}
			}
			if(max < 5) {
				resultmap.put(combine, count);
			}
		}
		MapTxtUtil.createScreenTxtMap(resultmap, filename+"historyunclude");
	}
	/**
	 * 包括开奖结果超过四个
	 * @param: @param historymap
	 * @param: @param datamap
	 * @param: @param filename      
	 */
	public static void screenHistoryClude(Map<String, Integer> historymap, Map<String, Integer> datamap,
			String filename) {
		Map<String, Integer> resultmap = new HashMap<String, Integer>();
		for (Entry<String, Integer> entry : datamap.entrySet()) {
			String combine = entry.getKey();
			int count = entry.getValue();
			String [] tempArr = combine.split(",");
			int max = 0;
			for (Entry<String, Integer> historyentry : historymap.entrySet()) {
				String history = historyentry.getKey();
				String [] historyArr = history.split(",");
				String[] intersectArr = ArrayTool.getIntersectArr(tempArr, historyArr);
				if(max < intersectArr.length) {
					max = intersectArr.length;
				}
			}
			if(max >= 5) {
				resultmap.put(combine, count);
			}
		}
		MapTxtUtil.createScreenTxtMap(resultmap, filename+"historyclude");
	}

}
