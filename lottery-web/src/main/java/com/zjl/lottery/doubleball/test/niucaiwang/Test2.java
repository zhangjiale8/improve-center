package com.zjl.lottery.doubleball.test.niucaiwang;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.zjl.lottery.doubleball.util.MultipParamsListUtil;
import com.zjl.lottery.util.MapDataUtil;
import com.zjl.tools.ArrayTool;

public class Test2 {
	public static void main(String[] args) {
		Map<String, Integer> niucaiwang20combinemaps = new HashMap<String,Integer>();
		Map<String, Integer> niucaiwang20upcombinemaps = new HashMap<String,Integer>();
		Map<String, Integer> niucaiwang20lowcombinemaps = new HashMap<String,Integer>();
		String filepath = "E:" + File.separator + "screen" + File.separator +"niucaiwang.txt";
		Map<String, Integer> combinemaps = MapDataUtil.getDataMap(filepath);
		for (Entry<String, Integer> entry : combinemaps.entrySet()) {
			String [] combinearr = entry.getKey().split(",");
			int [] combineintarr = ArrayTool.strArr2InArr(combinearr);
			ArrayTool.sort(combineintarr);
			Map<String, Integer> combinemap = MultipParamsListUtil.getScreenMap(combineintarr);
			if(combinearr.length < 20){
				for (Entry<String, Integer> comentry : combinemap.entrySet()) {
					String combine =comentry.getKey();
					int count = null == niucaiwang20lowcombinemaps.get(combine)?0:niucaiwang20lowcombinemaps.get(combine);
					niucaiwang20lowcombinemaps.put(combine, count+1);
				} 
			}else if(combinearr.length == 20){
				for (Entry<String, Integer> comentry : combinemap.entrySet()) {
					String combine =comentry.getKey();
					int count = null == niucaiwang20combinemaps.get(combine)?0:niucaiwang20combinemaps.get(combine);
					niucaiwang20combinemaps.put(combine, count+1);
				} 
			}else{
				for (Entry<String, Integer> comentry : combinemap.entrySet()) {
					String combine =comentry.getKey();
					int count = null == niucaiwang20upcombinemaps.get(combine)?0:niucaiwang20upcombinemaps.get(combine);
					niucaiwang20upcombinemaps.put(combine, count+1);
				} 
			}
			
			
		}
		
		MapDataUtil.createScreenTxtMap(niucaiwang20combinemaps, "niucaiwang20combinemaps");
		MapDataUtil.createScreenTxtMap(niucaiwang20upcombinemaps, "niucaiwang20upcombinemaps");
		MapDataUtil.createScreenTxtMap(niucaiwang20lowcombinemaps, "niucaiwang20lowcombinemaps");
	}
}
