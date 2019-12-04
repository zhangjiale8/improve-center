package com.zjl.lottery.doubleball.test.caihongduo;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.zjl.lottery.util.CombineUtil;
import com.zjl.lottery.util.MapDataUtil;
import com.zjl.tools.ArrayTool;

public class Test {
	public static void main(String[] args) {
		Map<String, Integer> resultmap = new HashMap<String, Integer>();
		Map<String, Integer> resultmaptemp = new HashMap<String, Integer>();
		String filepath = "E:" + File.separator + "screen" + File.separator +"caihongduo.txt";
		Map<String, Integer> datamap = MapDataUtil.getDataMap(filepath);
		
		for (Entry<String, Integer> entry : datamap.entrySet()) {
			String datastr = entry.getKey();
			String [] paramArr = datastr.split(",");
			int [] dataArr = ArrayTool.strArr2InArr(paramArr);
			Map<String, Integer> combinemap = CombineUtil.getCombineMap(dataArr, 6);
			for (Entry<String, Integer> combineentry : combinemap.entrySet()) {
				String combinestr = combineentry.getKey();
				Integer count = resultmap.get(combinestr);
				if(null == count){
					resultmap.put(combineentry.getKey(), 1);
				}else{
					
					resultmap.put(combineentry.getKey(), count+1);
				}
			}
		}
		
		for (Entry<String, Integer> entry : datamap.entrySet()) {
			String datastr = entry.getKey();
			String [] dataArr = datastr.split(",");
			for (Entry<String, Integer> combineentry : resultmap.entrySet()) {
				String combinestr = combineentry.getKey();
				String [] combineArr = combinestr.split(",");
				String[] intersectArr = ArrayTool.getIntersectArr(dataArr, combineArr);
				if(intersectArr.length >2 && resultmap.get(combinestr) < 4) {
					resultmaptemp.put(combineentry.getKey(), combineentry.getValue());
				}
			}
		}
		MapDataUtil.createScreenTxtMap(resultmaptemp,"caihongduocombine");
	}
}
