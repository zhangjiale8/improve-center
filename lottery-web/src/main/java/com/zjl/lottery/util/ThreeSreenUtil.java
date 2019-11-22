package com.zjl.lottery.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.zjl.lottery.doubleball.util.MapTxtUtil;
import com.zjl.tools.ArrayTool;

public class ThreeSreenUtil {
	/**
	 * 三连过滤
	 * @param: @param datamap
	 * @param: @param filename      
	 */
	public static void threeScreen(Map<String, Integer> datamap, String filename) {
		Map<String, Integer> threemap =  MapTxtUtil.getThreeMap();
		Map<String, Integer> resultmap = new HashMap<String, Integer>();
		for (Entry<String, Integer> entry : datamap.entrySet()) {
			String combine = entry.getKey();
			int count = entry.getValue();
			String [] tempArr = combine.split(",");
			int max = 0;
			for (Entry<String, Integer> threeentry : threemap.entrySet()) {
				String three = threeentry.getKey();
				String [] threeArr = three.split(",");
				String[] intersectArr = ArrayTool.getIntersectArr(tempArr, threeArr);
				if(max < intersectArr.length) {
					max = intersectArr.length;
				}
			}
			if(max < 3) {
				resultmap.put(combine, count);
			}
		}
		MapTxtUtil.createScreenTxtMap(resultmap, filename+"threescreen");
	
	}
	
}
