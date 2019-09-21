package com.zjl.lottery.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.zjl.lottery.combine.util.CombineUtil;

public class ParamsListUtil {
	public static void main(String[] args) {
		int[] paramArr1 = {};
		int[] paramArr2 = {};
		int[] paramArr3 = {};
		int[] paramArr4 = {};
		int[] paramArr5 = {};
		int[] paramArr6 = {};
		int[] paramArr7 = {};
		int[] paramArr8 = {};
		int[] paramArr9 = {};
		//int[] paramArr10 = {};
		//int[] paramArr11 = {};
		//int[] paramArr12 = {};
		ArrayList<int[]> screenlist = new ArrayList<int[]>();
		//screenlist.add(paramArr12);
		//screenlist.add(paramArr11);
		//screenlist.add(paramArr10);
		screenlist.add(paramArr9);
		screenlist.add(paramArr8);
		screenlist.add(paramArr7);
		screenlist.add(paramArr6);
		screenlist.add(paramArr5);
		screenlist.add(paramArr4);
		screenlist.add(paramArr3);
		screenlist.add(paramArr2);
		screenlist.add(paramArr1);
		int[] screenarray = {1,2,3,4,5,6,7,8,9,11,12,13,14,15,16,17,18,20,21,22,23,24,26,27,29,30,31,32,33};
		ParamsListUtil.screenDetermined(screenlist,screenarray);	
		
	
	}

	public static void screenDetermined(ArrayList<int[]> list, int[] screenarray) {
		Map<String, Integer> resultmap = new HashMap<String, Integer>();
		ArrayList<String> screenList = CombineUtil.getScreenList(screenarray,6);
		Map<String, Integer> screenmap = new HashMap<String, Integer>();
		Map<String, Integer> combinemap = new HashMap<String, Integer>();
		for (String screen : screenList) {
			screenmap.put(screen, 1);
		}
		
		for (int[] combinearray : list) {
			ArrayList<String> combinelist = CombineUtil.getScreenList(combinearray,6);
			for (String combine : combinelist) {
				int nums = null == combinemap.get(combine) ? 1:combinemap.get(combine)+1;
				combinemap.put(combine, nums);
			}
		}
		
		for (Entry<String, Integer> entry : combinemap.entrySet()) {
           	String temp = entry.getKey();
            boolean flg = screenmap.containsKey(temp);
            if(!flg){
            	int nums = combinemap.get(temp);
            	if(nums < 3){
            		resultmap.put(temp, nums);
            	}
            }
       }
		
		MapTxtUtil.createScreenTxtMap(resultmap, "resultmapdetermined");
		//ScreenUtil.screenTwo(ScreenUtil.screenThree(resultmap));
		ScreenUtil.screenTwo(HistoryUtil.screenHistory(ScreenUtil.screenThree(resultmap)));
	}

}
