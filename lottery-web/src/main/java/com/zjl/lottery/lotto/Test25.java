package com.zjl.lottery.lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.zjl.lottery.doubleball.util.MultipParamsListUtil;
import com.zjl.lottery.util.MapDataUtil;
import com.zjl.tools.MapUtil;

public class Test25 {
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
		int[] paramArr10 = {};
		int[] paramArr11 = {};
		int[] paramArr12 = {};
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
