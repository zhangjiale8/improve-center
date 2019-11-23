package com.zjl.lottery.lotto.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.zjl.lottery.util.MapDataUtil;
import com.zjl.tools.ArrayTool;

public class HistoryScreenUtil {
	/**
	 * 过滤历史开奖记录
	 * @param: @param datamap
	 * @param: @param filename      
	 */
	public static void screenhistory(Map<String, Integer> datamap, String filename) {
		Map<String, Integer> historymap =  HistoryUtil.getHistoryMap();

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
			if(max < 4) {
				resultmap.put(combine, count);
			}
		}
		MapDataUtil.createScreenTxtMap(resultmap, filename+"screenhistory");
	
		
	}	
	
}
