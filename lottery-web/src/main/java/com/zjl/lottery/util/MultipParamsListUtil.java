package com.zjl.lottery.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.zjl.lottery.combine.util.CombineUtil;

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
		for (int[] conbineArr : list) {
			Map<String, Integer> combinemap = MultipParamsListUtil.getScreenMap(conbineArr);
			for (Entry<String, Integer> entry : combinemap.entrySet()) {
				
			} 
		}
		
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
		
	}

}
