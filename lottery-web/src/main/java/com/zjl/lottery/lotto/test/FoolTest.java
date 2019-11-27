package com.zjl.lottery.lotto.test;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.zjl.lottery.util.ListDataUtil;
import com.zjl.lottery.util.MapDataUtil;
import com.zjl.tools.ArrayTool;
import com.zjl.tools.MapUtil;

public class FoolTest {
	public static void main(String[] args) {
		singlescreen();
	//	multipscreen();
	}
	
	/**
	 * 单组过滤
	 * @param:       
	 */
	private static void singlescreen() {

		int[] screenIntArr = {3,13,24,26,31,4,34,26,1,17};
		String[] screenArr = ArrayTool.intArr2StrArr(screenIntArr);
		String filename = "lottoscreenthreescreenscreenhistory123456789123";
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
	/**
	 * 多组过滤
	 * @param:       
	 */
	private static void multipscreen() {

		Map<String, Integer> screenmap = new HashMap<String, Integer>();
		String screenfilepath = "E:" + File.separator + "screen" + File.separator +"screenlist.txt";;
		List<String[]> screenarrlist = ListDataUtil.getScreenList(screenfilepath);
		String filename = "lottoscreenthreescreenscreenhistory12345678";
		String filepath = "E:" + File.separator + "screen" + File.separator +filename+".txt";;
		Map<String, Integer> datamap = MapDataUtil.getDataMap(filepath);
		for (Entry<String, Integer> entry : datamap.entrySet()) {
			for (String[] screenArr : screenarrlist) {
				String[] combineArr = entry.getKey().split(",");
				String[] intersectArr = ArrayTool.getIntersectArr(screenArr, combineArr);
				if(intersectArr.length ==5) {
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
		MapDataUtil.createScreenTxtMap(datamap, filename+"9");
		
	
	}
	
	
}
