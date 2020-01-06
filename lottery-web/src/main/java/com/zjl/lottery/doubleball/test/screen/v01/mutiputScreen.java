package com.zjl.lottery.doubleball.test.screen.v01;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.zjl.lottery.doubleball.util.ScreenUtil;
import com.zjl.lottery.util.ListDataUtil;
import com.zjl.lottery.util.MapDataUtil;
import com.zjl.tools.ArrayTool;
import com.zjl.tools.MapUtil;

public class mutiputScreen {
	public static void main(String[] args) {

		Map<String, Integer> screenmap = new HashMap<String, Integer>();
		String screenfilepath = "E:" + File.separator + "screen" + File.separator +"screenlist.txt";;
		List<String[]> screenarrlist = ListDataUtil.getScreenList(screenfilepath);
		String filename = "caihongduo25combine@";
		filename += "123";
		String filepath = "E:" + File.separator + "screen" + File.separator +filename+".txt";;
		Map<String, Integer> datamap = MapDataUtil.getDataMap(filepath);
		for (Entry<String, Integer> entry : datamap.entrySet()) {
			for (String[] screenArr : screenarrlist) {
				String[] combineArr = entry.getKey().split(",");
				String[] intersectArr = ArrayTool.getIntersectArr(screenArr, combineArr);
				if(intersectArr.length <1) {
					screenmap.put(entry.getKey(), entry.getValue());
				}
			}
		}
		Map<String, Integer> datamaptemp = new HashMap<String, Integer>();
		MapUtil.mapCopy(datamap,datamaptemp);
		for (Entry<String, Integer> entry : datamaptemp.entrySet()) {
			Integer count = screenmap.get(entry.getKey());
			if(null != count){
				datamap.remove(entry.getKey());
			}
		}
		datamap = ScreenUtil.tailspanscreen(datamap);
		MapDataUtil.createScreenTxtMap(datamap, filename+"999");
		
					
	}
}
