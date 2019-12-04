package com.zjl.lottery.doubleball.test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.zjl.lottery.util.MapDataUtil;

public class test {
	public static void main(String[] args) {
		Map<String, Integer> resultmap = new HashMap<String, Integer>();
		String filepath = "E:" + File.separator + "screen" + File.separator +"singlecombine.txt";
		Map<String, Integer> screendatamap = MapDataUtil.getDataMap(filepath);
		filepath = "E:" + File.separator + "screen" + File.separator +"resultmapdetermineduncludehistoryuncludeotherticketuncludethreescreen.txt";
		Map<String, Integer> datamap = MapDataUtil.getDataMap(filepath);
		for (Entry<String, Integer> entry : datamap.entrySet()) {
			Integer count = screendatamap.get(entry.getKey());
			if(null != count) {
				resultmap.put(entry.getKey(), entry.getValue());
			}
		}
		
		MapDataUtil.createScreenTxtMap(resultmap, "resultmapdetermineduncludehistoryuncludeotherticketuncludethreescreen1");
	}
}
