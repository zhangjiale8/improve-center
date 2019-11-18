package com.zjl.lottery.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.zjl.lottery.combine.util.CombineUtil;
import com.zjl.tools.ArrayTool;

public class MultipParamsListUtil {	

	public static void screenDetermined(ArrayList<int[]> list, int[] screenarray) {
		//数组包括开奖结果
		MultipParamsListUtil.screenDeterminedClude(list, screenarray);
		//数组不包括开奖结果
		MultipParamsListUtil.screenDeterminedUncolude(list, screenarray);
		
	}
	/**
	 * 数组不包括开奖结果
	 * @param list
	 * @param screenarray
	 */
	public static void screenDeterminedUncolude(ArrayList<int[]> list, int[] screenarray) {
		Map<String, Integer> screenmap = MultipParamsListUtil.getScreenMap(screenarray);
		Map<String, Integer> combinemaps = new HashMap<String,Integer>();
		Map<String, Integer> resultTemp = new HashMap<String,Integer>();
		Map<String, Integer> resultmap = new HashMap<String,Integer>();
		for (int[] conbineArr : list) {
			Map<String, Integer> combinemap = MultipParamsListUtil.getScreenMap(conbineArr);
			for (Entry<String, Integer> entry : combinemap.entrySet()) {
				String combine = entry.getKey();
				int count = null == combinemaps.get(combine)?0:combinemaps.get(combine);
				combinemaps.put(combine, count+1);
			} 
		}
		
		for (Entry<String, Integer> entry : combinemaps.entrySet()) {
			String combine = entry.getKey();
			int count = entry.getValue();
			boolean flg = screenmap.containsKey(combine);
			if(count < 3 && !flg) {
				resultTemp.put(combine, count);
			}
		}
		for (Entry<String, Integer> entry : resultTemp.entrySet()) {
			String result = entry.getKey();
			Integer value = entry.getValue();
			String [] tempArr = result.split(",");
			int min = 3;
			for (int[] combineArr : list) {
				String[] combinestrArr = ArrayTool.intArr2StrArr(combineArr);
				String[] intersectArr = ArrayTool.getIntersectArr(tempArr, combinestrArr);
				if(min > intersectArr.length) {
					min = intersectArr.length;
				}
			}
			if(min > 2) {
				resultmap.put(result, value);
			}
		}
		MapTxtUtil.createScreenTxtMap(resultmap, "resultmapdeterminedunclude");
		
	}
	/**
	 * 获取组合集合
	 * @param screenarray
	 * @return
	 */
	public static Map<String, Integer> getScreenMap(int[] screenarray) {
		ArrayList<String> screenList = CombineUtil.getScreenList(screenarray,6);
		Map<String, Integer> screenmap = new HashMap<String, Integer>();
		for (String screen : screenList) {
			screenmap.put(screen, 1);
		}
		return screenmap;
	}
	/**
	 * 数组包括开奖结果
	 * @param list
	 * @param screenarray
	 */
	public static void screenDeterminedClude(ArrayList<int[]> list, int[] screenarray) {
		Map<String, Integer> screenmap = MultipParamsListUtil.getScreenMap(screenarray);
		Map<String, Integer> combinemaps = new HashMap<String,Integer>();
		Map<String, Integer> resultTemp = new HashMap<String,Integer>();
		Map<String, Integer> resultmap = new HashMap<String,Integer>();
		for (int[] conbineArr : list) {
			Map<String, Integer> combinemap = MultipParamsListUtil.getScreenMap(conbineArr);
			for (Entry<String, Integer> entry : combinemap.entrySet()) {
				String combine = entry.getKey();
				int count = null == combinemaps.get(combine)?0:combinemaps.get(combine);
				combinemaps.put(combine, count+1);
			} 
		}
		
		for (Entry<String, Integer> entry : combinemaps.entrySet()) {
			String combine = entry.getKey();
			int count = entry.getValue();
			boolean flg = screenmap.containsKey(combine);
			if(count < 3 && flg) {
				resultTemp.put(combine, count);
			}
		}
		for (Entry<String, Integer> entry : resultTemp.entrySet()) {
			String result = entry.getKey();
			Integer value = entry.getValue();
			String [] tempArr = result.split(",");
			int min = 3;
			for (int[] combineArr : list) {
				String[] combinestrArr = ArrayTool.intArr2StrArr(combineArr);
				String[] intersectArr = ArrayTool.getIntersectArr(tempArr, combinestrArr);
				if(min > intersectArr.length) {
					min = intersectArr.length;
				}
			}
			if(min > 2) {
				resultmap.put(result, value);
			}
		}
		MapTxtUtil.createScreenTxtMap(resultmap, "resultmapdeterminedclude");
		
	}

}
