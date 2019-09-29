package com.zjl.lottery.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.zjl.tools.ArrayTool;

public class TwoSreenUtil {
	/**
	 * 二连过滤
	 * @param: @param datamap
	 * @param: @param filename      
	 */
	public static void twoScreen(Map<String, Integer> datamap, String filename) {
		Map<String, Integer> twomap =  MapTxtUtil.getTwoMap();
		Map<String, Integer> resultmap = new HashMap<String, Integer>();
		for (Entry<String, Integer> entry : datamap.entrySet()) {
			String combine = entry.getKey();
			int count = entry.getValue();
			String [] tempArr = combine.split(",");
			int max = 0;
			for (Entry<String, Integer> twoentry : twomap.entrySet()) {
				String two = twoentry.getKey();
				String [] twoArr = two.split(",");
				String[] intersectArr = ArrayTool.getIntersectArr(tempArr, twoArr);
				if(max < intersectArr.length) {
					max = intersectArr.length;
				}
			}
			if(max < 2) {
				resultmap.put(combine, count);
			}
		}
		MapTxtUtil.createScreenTxtMap(resultmap, filename+"twoscreen");
	
	}
	
}
