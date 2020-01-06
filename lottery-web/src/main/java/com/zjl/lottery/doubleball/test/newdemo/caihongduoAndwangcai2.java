package com.zjl.lottery.doubleball.test.newdemo;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.zjl.lottery.doubleball.util.ScreenUtil;
import com.zjl.lottery.doubleball.util.TailUtil;
import com.zjl.lottery.util.ListDataUtil;
import com.zjl.lottery.util.MapDataUtil;
import com.zjl.tools.ArrayTool;

public class caihongduoAndwangcai2 {
	public static void main(String[] args) {
		Map<String, Integer> combinemaps = new HashMap<String, Integer>();
		String filepath = "E:" + File.separator + "screen" + File.separator +"caihongduo25map.txt";
		Map<String, Integer> caihongduo25map = MapDataUtil.getDataMap(filepath);
		filepath = "E:" + File.separator + "screen" + File.separator +"wangcai25map.txt";
		Map<String, Integer> wangcai25map = MapDataUtil.getDataMap(filepath);
		for (Entry<String, Integer> waicaientry : wangcai25map.entrySet()) {
			Integer count = caihongduo25map.get(waicaientry.getKey());
			if(null != count && count > 3){
				combinemaps.put(waicaientry.getKey(), count);
			}else{
				combinemaps.put(waicaientry.getKey(), waicaientry.getValue());
			}
			
		}
		for (Entry<String, Integer> caihongduoentry : caihongduo25map.entrySet()) {
			Integer count = combinemaps.get(caihongduoentry.getKey());
			if(null == count){
				combinemaps.put(caihongduoentry.getKey(), caihongduoentry.getValue());
			}
		}
		
		MapDataUtil.createScreenTxtMap(combinemaps, "combinemaps");
	}
	
}
