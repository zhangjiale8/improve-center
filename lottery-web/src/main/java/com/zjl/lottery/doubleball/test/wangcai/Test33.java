package com.zjl.lottery.doubleball.test.wangcai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.zjl.lottery.doubleball.util.MultipParamsListUtil;
import com.zjl.lottery.util.MapDataUtil;

public class Test33 {
	public static void main(String[] args) {

		
		int[] paramArr1 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33};
		
		ArrayList<int[]> list33 = new ArrayList<int[]>();
		
		list33.add(paramArr1);
		
		Map<String, Integer> combinemaps33 = new HashMap<String,Integer>();
		for (int[] conbineArr : list33) {
			Map<String, Integer> combinemap = MultipParamsListUtil.getScreenMap(conbineArr);
			for (Entry<String, Integer> entry : combinemap.entrySet()) {
				String combine = entry.getKey();
				int count = null == combinemaps33.get(combine)?0:combinemaps33.get(combine);
				combinemaps33.put(combine, count+1);
			} 
		}
		
		MapDataUtil.createScreenTxtMap(combinemaps33, "combinemaps33");

	}

}
