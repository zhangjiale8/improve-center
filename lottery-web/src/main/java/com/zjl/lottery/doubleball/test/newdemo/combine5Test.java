package com.zjl.lottery.doubleball.test.newdemo;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.zjl.lottery.util.ListDataUtil;
import com.zjl.lottery.util.MapDataUtil;
import com.zjl.tools.ArrayTool;
import com.zjl.tools.MapUtil;

public class combine5Test {
	public static void main(String[] args) {


		String [] filenameArr = {
				"resultmapdeterminedclude",
				"resultmapdeterminedunclude"			
				};
		Map<String, Integer> screenmap = new HashMap<String, Integer>();
		String screenfilepath = "E:" + File.separator + "screen" + File.separator +"screenlist.txt";;
		List<String[]> screenarrlist = ListDataUtil.getScreenList(screenfilepath);
		for (String filename : filenameArr) {
			filename += "";
			String filepath = "E:" + File.separator + "screen" + File.separator +filename+".txt";;
			Map<String, Integer> datamap = MapDataUtil.getDataMap(filepath);
			for (Entry<String, Integer> entry : datamap.entrySet()) {
				int count = 0;
				for (String[] screenArr : screenarrlist) {
					String[] combineArr = entry.getKey().split(",");
					String[] intersectArr = ArrayTool.getIntersectArr(screenArr, combineArr);
					if(intersectArr.length >4) {
						count ++;
					}
				}
				screenmap.put(entry.getKey(), count);
			}
		}
		
		for (String filename : filenameArr) {
			filename += "";
			String filepath = "E:" + File.separator + "screen" + File.separator +filename+".txt";;
			Map<String, Integer> datamap = MapDataUtil.getDataMap(filepath);
			Map<String, Integer> datamaptemp = new HashMap<String, Integer>();
			MapUtil.mapCopy(datamap,datamaptemp);
			for (Entry<String, Integer> entry : datamaptemp.entrySet()) {
				Integer count = screenmap.get(entry.getKey());
				if(null != count && (count >5 || count <1)){
					datamap.remove(entry.getKey());
				}
			}
			MapDataUtil.createScreenTxtMap(datamap, filename+"1");
		}		
	
	}
}
