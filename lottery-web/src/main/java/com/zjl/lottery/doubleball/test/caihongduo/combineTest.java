package com.zjl.lottery.doubleball.test.caihongduo;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.zjl.lottery.util.ListDataUtil;
import com.zjl.lottery.util.MapDataUtil;
import com.zjl.tools.ArrayTool;

public class combineTest {
	public static void main(String[] args) {
		String [] filenameArr = {
				"resultmapdeterminedcludehistorycludeotherticketclude",
				"resultmapdeterminedcludehistorycludeotherticketunclude",
				"resultmapdeterminedcludehistoryuncludeotherticketclude",
				"resultmapdeterminedcludehistoryuncludeotherticketunclude",
				"resultmapdetermineduncludehistorycludeotherticketclude",
				"resultmapdetermineduncludehistorycludeotherticketunclude",
				"resultmapdetermineduncludehistoryuncludeotherticketclude",
				"resultmapdetermineduncludehistoryuncludeotherticketunclude"
				};

		String screenfilepath = "E:" + File.separator + "screen" + File.separator +"caihongduocombine.txt";
		Map<String, Integer> screenmap = MapDataUtil.getDataMap(screenfilepath);
		for (String filename : filenameArr) {
			filename += "threescreen";
			Map<String, Integer> resultmap = new HashMap<String, Integer>();
			String filepath = "E:" + File.separator + "screen" + File.separator +filename+".txt";;
			Map<String, Integer> datamap = MapDataUtil.getDataMap(filepath);
			for (Entry<String, Integer> entry : screenmap.entrySet()) {
				Integer count = datamap.get(entry.getKey());
				if(null != count){
					resultmap.put(entry.getKey(), datamap.get(entry.getKey()));
				}
			}
			MapDataUtil.createScreenTxtMap(resultmap, filename+"1");
		}
	}
	
}
