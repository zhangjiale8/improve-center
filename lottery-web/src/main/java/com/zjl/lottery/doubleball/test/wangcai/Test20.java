package com.zjl.lottery.doubleball.test.wangcai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.zjl.lottery.doubleball.util.MultipParamsListUtil;
import com.zjl.lottery.util.MapDataUtil;

public class Test20 {

	public static void main(String[] args) {

		
		int[] paramArr1 = {2,5,7,9,11,12,13,15,16,17,18,20,21,22,24,25,26,29,30,32};
		int[] paramArr2 = {1,3,4,5,6,7,8,11,14,17,18,19,20,21,22,24,25,27,29,32};
		int[] paramArr3 = {1,2,5,8,9,10,11,12,13,14,15,16,17,18,20,22,23,26,27,33};
		int[] paramArr4 = {1,2,4,5,6,8,9,10,11,12,14,15,18,20,21,23,26,27,28,29};
		int[] paramArr5 = {2,3,4,5,7,9,10,12,14,17,18,19,20,22,23,24,28,31,32,33};
		int[] paramArr6 = {1,2,4,5,8,9,10,12,13,14,15,16,17,18,19,20,23,24,26,27};
		int[] paramArr7 = {4,5,7,9,10,11,13,14,15,17,18,20,21,22,25,26,27,28,29,33};
		int[] paramArr8 = {1,5,8,9,12,13,14,15,16,17,18,19,20,24,25,26,27,28,29,32};
		int[] paramArr9 = {1,2,3,4,6,7,9,10,12,13,14,15,16,20,21,22,24,25,32,33};
		int[] paramArr10 = {2,3,7,8,9,11,12,13,15,16,18,21,22,23,24,25,28,29,30,31};
		int[] paramArr11 = {1,4,6,7,8,13,15,16,17,18,20,22,23,24,25,28,29,31,32,33};
		int[] paramArr12 = {3,4,8,9,10,12,13,14,15,17,18,20,21,22,24,25,26,28,32,33};
		ArrayList<int[]> list20 = new ArrayList<int[]>();
		list20.add(paramArr12);
		list20.add(paramArr11);
		list20.add(paramArr10);
		list20.add(paramArr9);
		list20.add(paramArr8);
		list20.add(paramArr7);
		list20.add(paramArr6);
		list20.add(paramArr5);
		list20.add(paramArr4);
		list20.add(paramArr3);
		list20.add(paramArr2);
		list20.add(paramArr1);
		
		Map<String, Integer> combinemaps20 = new HashMap<String,Integer>();
		for (int[] conbineArr : list20) {
			Map<String, Integer> combinemap = MultipParamsListUtil.getScreenMap(conbineArr);
			for (Entry<String, Integer> entry : combinemap.entrySet()) {
				String combine = entry.getKey();
				int count = null == combinemaps20.get(combine)?0:combinemaps20.get(combine);
				combinemaps20.put(combine, count+1);
			} 
		}
		
		MapDataUtil.createScreenTxtMap(combinemaps20, "combinemaps20");

	}


}
