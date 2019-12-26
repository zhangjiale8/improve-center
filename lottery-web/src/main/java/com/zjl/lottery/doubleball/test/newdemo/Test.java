package com.zjl.lottery.doubleball.test.newdemo;

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

public class Test {

	public static void main(String[] args) {
	//	singlescreen();
	//	multipscreen();
		extrememultipscreen();
	}
	/**
	 * 极端测试
	 */
	private static void extrememultipscreen() {


		String [] filenameArr = {
				"resultmapdeterminedclude",
				"resultmapdeterminedunclude"			
				};
		Map<String, Integer> totalmap = new HashMap<String, Integer>();
		Map<String, Integer> result = new HashMap<String, Integer>();
		String screenfilepath = "E:" + File.separator + "screen" + File.separator +"screenlist.txt";;
		List<String[]> screenarrlist = ListDataUtil.getScreenList(screenfilepath);
		for (String filename : filenameArr) {
			filename += "";
			String filepath = "E:" + File.separator + "screen" + File.separator +filename+".txt";;
			Map<String, Integer> datamap = MapDataUtil.getDataMap(filepath);
			for (Entry<String, Integer> entry : datamap.entrySet()) {
				totalmap.put(entry.getKey(), entry.getValue());
			}
		}
		for (String[] screenArr : screenarrlist) {
			String draw = "";
			for (int i = 0; i < screenArr.length; i++) {
				draw += screenArr[i]+",";
			}
			draw = draw.substring(0, draw.length() -1);
			if(!totalmap.containsKey(draw)){
				result.put(draw, totalmap.get(draw));
			}
		}
		MapDataUtil.createScreenTxtMap(result, "pingtotal");
		
	}

	/**
	 * 单组过滤
	 * @param:       
	 */
	private static void singlescreen() {

		String [] filenameArr = {
				"resultmapdeterminedclude",
				"resultmapdeterminedunclude"			
				};
		//int[] screenIntArr = {3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,22,23,25,26,27,29,30,31};
		int[] screenIntArr = {8,25,15};
		String[] screenArr = ArrayTool.intArr2StrArr(screenIntArr);
		for (String filename : filenameArr) {
			filename += "";
			String filepath = "E:" + File.separator + "screen" + File.separator +filename+".txt";;
			Map<String, Integer> datamap = MapDataUtil.getDataMap(filepath);
			Map<String, Integer> resultmap = new HashMap<String, Integer>();
			for (Entry<String, Integer> entry : datamap.entrySet()) {
				String[] combineArr = entry.getKey().split(",");
				String[] intersectArr = ArrayTool.getIntersectArr(screenArr, combineArr);
				if(intersectArr.length <1) {
					resultmap.put(entry.getKey(), entry.getValue());
				}
				
			}
			MapDataUtil.createScreenTxtMap(resultmap, filename+"4");
		}
		
	}
	/**
	 * 多组过滤
	 * @param:       
	 */
	private static void multipscreen() {

		String [] filenameArr = {
				"resultmapdeterminedclude",
				"resultmapdeterminedunclude"			
				};
		Map<String, Integer> screenmap = new HashMap<String, Integer>();
		String screenfilepath = "E:" + File.separator + "screen" + File.separator +"screenlist.txt";;
		List<String[]> screenarrlist = ListDataUtil.getScreenList(screenfilepath);
		for (String filename : filenameArr) {
			filename += "12345";
			String filepath = "E:" + File.separator + "screen" + File.separator +filename+".txt";;
			Map<String, Integer> datamap = MapDataUtil.getDataMap(filepath);
			for (Entry<String, Integer> entry : datamap.entrySet()) {
				for (String[] screenArr : screenarrlist) {
					String[] combineArr = entry.getKey().split(",");
					String[] intersectArr = ArrayTool.getIntersectArr(screenArr, combineArr);
					if(intersectArr.length <2 || intersectArr.length >5) {
						screenmap.put(entry.getKey(), entry.getValue());
					}
				}
			}
		}
		
		for (String filename : filenameArr) {
			filename += "12345";
			String filepath = "E:" + File.separator + "screen" + File.separator +filename+".txt";;
			Map<String, Integer> datamap = MapDataUtil.getDataMap(filepath);
			Map<String, Integer> datamaptemp = new HashMap<String, Integer>();
			MapUtil.mapCopy(datamap,datamaptemp);
			for (Entry<String, Integer> entry : datamaptemp.entrySet()) {
				Integer count = screenmap.get(entry.getKey());
				if(null != count){
					datamap.remove(entry.getKey());
				}
			}
		//	datamap = ScreenUtil.singledoublemin2(datamap);
		//	datamap = ScreenUtil.areascreen(datamap);
			MapDataUtil.createScreenTxtMap(datamap, filename+"6");
		}
		
		
	}

}
