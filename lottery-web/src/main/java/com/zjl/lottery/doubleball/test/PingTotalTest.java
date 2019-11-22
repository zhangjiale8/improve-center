package com.zjl.lottery.doubleball.test;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.zjl.lottery.util.ListDataUtil;
import com.zjl.lottery.util.MapDataUtil;
import com.zjl.tools.ArrayTool;

public class PingTotalTest {
	public static void main(String[] args) {
		PingTotalScreen();
	}
	
	/**
	 * 多组过滤
	 * @param:       
	 */
	private static void PingTotalScreen() {
		String filepath = "E:" + File.separator + "screen" + File.separator +"pingtatalscreensametails.txt";;
		Map<String, Integer> datamap = MapDataUtil.getDataMap(filepath);
		String pingfilepath = "E:" + File.separator + "screen" + File.separator +"sceenlist.txt";;
		Map<String, Integer> pingdatamap = MapDataUtil.getDataMap(pingfilepath);
		Map<String, Integer> screenmap = new HashMap<String, Integer>();
		Map<String, Integer> result = new HashMap<String, Integer>();
		for (Entry<String, Integer> entry : datamap.entrySet()) {
			String[] combineArr = entry.getKey().split(",");
			for (Entry<String, Integer> screenentry : pingdatamap.entrySet()) {
				String[] screenArr = screenentry.getKey().split(",");
				String[] intersectArr = ArrayTool.getIntersectArr(screenArr, combineArr);
				if(intersectArr.length > 5 && intersectArr.length <4) {
					screenmap.put(entry.getKey(), entry.getValue());
				}
			}
			
			
		}
		
		for (Entry<String, Integer> entry : datamap.entrySet()) {
			String combine = entry.getKey();
			Integer conut = screenmap.get(combine);
			if(null == conut){
				result.put(entry.getKey(), entry.getValue());
			}
			
		}		
		MapDataUtil.createScreenTxtMap(result,"pingtatalscreensametails"+"12");
	}
}
