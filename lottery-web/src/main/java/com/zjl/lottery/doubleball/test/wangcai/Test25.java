package com.zjl.lottery.doubleball.test.wangcai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.zjl.lottery.doubleball.util.MultipParamsListUtil;
import com.zjl.lottery.util.MapDataUtil;

public class Test25 {
	public static void main(String[] args) {

		
		int[] paramArr1 = {2,3,4,5,7,9,10,11,12,13,15,16,17,18,19,20,21,22,24,25,26,29,30,32,33};
		int[] paramArr2 = {1,3,4,5,6,7,8,9,11,14,15,17,18,19,20,21,22,23,24,25,26,27,29,31,32};
		int[] paramArr3 = {1,2,3,5,7,8,9,10,11,12,13,14,15,16,17,18,19,20,22,23,26,27,29,31,33};
		int[] paramArr4 = {1,2,4,5,6,7,8,9,10,11,12,13,14,15,16,18,19,20,21,23,26,27,28,29,32};
		int[] paramArr5 = {1,2,3,4,5,6,7,8,9,10,11,12,14,17,18,19,20,22,23,24,28,30,31,32,33};
		int[] paramArr6 = {1,2,4,5,8,9,10,12,13,14,15,16,17,18,19,20,23,24,26,27,29,30,31,32,33};
		int[] paramArr7 = {2,4,5,7,9,10,11,12,13,14,15,17,18,19,20,21,22,25,26,27,28,29,30,31,33};
		int[] paramArr8 = {1,3,5,6,7,8,9,11,12,13,14,15,16,17,18,19,20,22,24,25,26,27,28,29,32};
		int[] paramArr9 = {1,2,3,4,6,7,8,9,10,12,13,14,15,16,17,20,21,22,24,25,26,28,29,32,33};
		int[] paramArr10 = {1,2,3,6,7,8,9,11,12,13,14,15,16,17,18,20,21,22,23,24,25,28,29,30,31};
		int[] paramArr11 = {1,4,6,7,8,10,11,12,13,15,16,17,18,20,21,22,23,24,25,28,29,30,31,32,33};
		int[] paramArr12 = {3,4,8,9,10,11,12,13,14,15,17,18,20,21,22,23,24,25,26,27,28,30,31,32,33};
		ArrayList<int[]> list25 = new ArrayList<int[]>();
		list25.add(paramArr12);
		list25.add(paramArr11);
		list25.add(paramArr10);
		list25.add(paramArr9);
		list25.add(paramArr8);
		list25.add(paramArr7);
		list25.add(paramArr6);
		list25.add(paramArr5);
		list25.add(paramArr4);
		list25.add(paramArr3);
		list25.add(paramArr2);
		list25.add(paramArr1);
		
		Map<String, Integer> combinemaps25 = new HashMap<String,Integer>();
		for (int[] conbineArr : list25) {
			Map<String, Integer> combinemap = MultipParamsListUtil.getScreenMap(conbineArr);
			for (Entry<String, Integer> entry : combinemap.entrySet()) {
				String combine = entry.getKey();
				int count = null == combinemaps25.get(combine)?0:combinemaps25.get(combine);
				combinemaps25.put(combine, count+1);
			} 
		}
		
		MapDataUtil.createScreenTxtMap(combinemaps25, "combinemaps25");

	}

}
