package com.zjl.lottery.doubleball.test.screen.v01;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.zjl.lottery.util.ListDataUtil;
import com.zjl.lottery.util.MapDataUtil;

public class singleUncludeTest {
	public static void main(String[] args) {
		Map<String, Integer> resultmap = new HashMap<String, Integer>();
		String filepath = "E:" + File.separator + "screen" + File.separator +"combinemaps33.txt";;
		Map<String, Integer> datamap1 = MapDataUtil.getDataMap(filepath);
		filepath = "E:" + File.separator + "screen" + File.separator +"caihongduo25combine.txt";
		Map<String, Integer> datamap2 = MapDataUtil.getDataMap(filepath);
		for (Entry<String, Integer> entry : datamap1.entrySet()) {
			if(!datamap2.containsKey(entry.getKey())) {
				resultmap.put(entry.getKey(), entry.getValue());
			}
		}
		MapDataUtil.createScreenTxtMap(resultmap, "leavecombinemap");
	}
}
