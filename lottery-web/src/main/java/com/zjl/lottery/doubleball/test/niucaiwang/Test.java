package com.zjl.lottery.doubleball.test.niucaiwang;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.zjl.lottery.doubleball.util.MultipParamsListUtil;
import com.zjl.lottery.util.MapDataUtil;
import com.zjl.tools.ArrayTool;

public class Test {
	public static void main(String[] args) {
		int min7 = 0;
		Map<String, Integer> niucaiwangcombinemaps = new HashMap<String,Integer>();
		Map<String, Integer> niucaiwang20upcombinemaps = new HashMap<String,Integer>();
		Map<String, Integer> niucaiwang20lowcombinemaps = new HashMap<String,Integer>();
		String filepath = "E:" + File.separator + "screen" + File.separator +"niucaiwang.txt";
		Map<String, Integer> combinemaps = MapDataUtil.getDataMap(filepath);
		for (Entry<String, Integer> entry : combinemaps.entrySet()) {
			String [] combinearr = entry.getKey().split(",");
			int [] combineintarr = ArrayTool.strArr2InArr(combinearr);
			ArrayTool.sort(combineintarr);
			Map<String, Integer> combinemap = MultipParamsListUtil.getScreenMap(combineintarr);
			for (Entry<String, Integer> comentry : combinemap.entrySet()) {
				String combine =comentry.getKey();
				int count = null == niucaiwangcombinemaps.get(combine)?0:niucaiwangcombinemaps.get(combine);
				niucaiwangcombinemaps.put(combine, count+1);
			} 
		}
		for (Entry<String, Integer> entry : niucaiwangcombinemaps.entrySet()) {
			if(entry.getValue() > 10 || entry.getValue() <3){
				min7 ++;
			}
		}
		System.out.println(min7);
		MapDataUtil.createScreenTxtMap(niucaiwangcombinemaps, "niucaiwangcombinemaps");
	}
}
