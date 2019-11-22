package com.zjl.lottery.doubleball.test;

import java.util.Map;
import java.util.Map.Entry;

import com.zjl.lottery.doubleball.util.HistoryUtil;
import com.zjl.lottery.doubleball.util.MultipParamsListUtil;
import com.zjl.lottery.util.MapTxtUtil;
import com.zjl.tools.ArrayTool;

public class Comparewith22ArrTest{
	public static void main(String[] args) {
		historycompare();
	}

	private static void historycompare() {
		Map<String, Integer> array22datamap = MapTxtUtil.get22ArrayMap();
		Map<String, Integer> historymap =  HistoryUtil.getHistoryMap();
		Map<String, Integer> array22combinemap =  MapTxtUtil.get22ArrayCombineMap();
		int[] combinetempIntArr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33};
		Map<String, Integer> screenmap = MultipParamsListUtil.getScreenMap(combinetempIntArr);
		System.out.println(screenmap.size());
		
		int count0 = 0;
		int countno0 = 0;
		for (Entry<String, Integer> entry : historymap.entrySet()) {
			String history = entry.getKey();
			int count = 0;
			String [] historyArr = history.split(",");
			for (Entry<String, Integer> array22entry : array22datamap.entrySet()) {
				String array22 = array22entry.getKey();
				String [] array22Arr = array22.split(",");
				String[] intersectArr = ArrayTool.getIntersectArr(historyArr, array22Arr);
				if(intersectArr.length == 6) {
					count ++;
				}
			}
			historymap.put(history, count);
			if(0 == count){
				count0 ++;
			}else{
				countno0++;
			}
		}
		System.out.println(count0);
		System.out.println(countno0);
		MapTxtUtil.createScreenTxtMap(historymap,"histroycomparewith22array");
		MapTxtUtil.createScreenTxtMap(array22combinemap,"array22combinemap");
	}
}
