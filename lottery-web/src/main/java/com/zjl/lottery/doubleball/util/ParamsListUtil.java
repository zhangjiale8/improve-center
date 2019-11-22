package com.zjl.lottery.doubleball.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.zjl.lottery.util.CombineUtil;

public class ParamsListUtil {
	public static void main(String[] args) {
		int[] paramArr1 = {1,2,3,4,5,6,7,8,10,16,17,18,19,20,21,22,23,25,26,27,28,29,30,31,32};
		int[] paramArr2 = {1,2,3,4,5,8,9,10,11,12,13,16,17,18,20,21,22,24,25,26,27,28,29,31,32};
		int[] paramArr3 = {1,2,3,4,5,6,7,8,9,10,13,14,15,16,17,20,22,23,24,27,28,29,31,32,33};
		int[] paramArr4 = {1,2,4,5,6,7,10,11,14,15,16,17,18,20,21,22,23,24,25,27,28,29,30,32,33};
		int[] paramArr5 = {1,2,3,6,7,8,12,13,14,17,18,19,20,22,23,24,25,26,27,28,29,30,31,32,33};
		int[] paramArr6 = {2,3,4,5,6,7,8,9,10,12,14,16,17,18,19,20,21,22,23,24,25,26,30,31,33};
		int[] paramArr7 = {1,3,5,6,7,10,11,12,13,14,15,16,17,18,19,20,21,24,25,26,27,28,31,32,33};
		int[] paramArr8 = {1,2,3,5,7,8,9,10,11,12,16,17,18,19,20,21,22,23,25,26,27,29,30,31,33};
		int[] paramArr9 = {2,4,5,6,7,8,9,10,12,13,16,17,18,19,21,24,25,26,27,28,29,30,31,32,33};
		int[] paramArr10 = {1,2,3,5,6,7,8,10,11,12,13,14,15,16,17,19,20,21,22,23,24,27,30,31,33};
		//int[] paramArr11 = {};
		//int[] paramArr12 = {};
		ArrayList<int[]> screenlist = new ArrayList<int[]>();
		//screenlist.add(paramArr12);
		//screenlist.add(paramArr11);
		screenlist.add(paramArr10);
		screenlist.add(paramArr9);
		screenlist.add(paramArr8);
		screenlist.add(paramArr7);
		screenlist.add(paramArr6);
		screenlist.add(paramArr5);
		screenlist.add(paramArr4);
		screenlist.add(paramArr3);
		screenlist.add(paramArr2);
		screenlist.add(paramArr1);
		int[] screenarray = {1,2,3,4,5,6,7,8,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33};
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
		ScreenUtil.screenTwo(HistoryUtil.screenHistory(ScreenUtil.screenOtherTickets(ScreenUtil.screenThree(resultmap))));
	}

}
