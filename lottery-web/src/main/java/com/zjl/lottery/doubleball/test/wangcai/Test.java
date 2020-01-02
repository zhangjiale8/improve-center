package com.zjl.lottery.doubleball.test.wangcai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.zjl.lottery.doubleball.util.MultipParamsListUtil;
import com.zjl.lottery.util.CombineUtil;
import com.zjl.lottery.util.MapDataUtil;

public class Test {

	public static void main(String[] args) {

		
		int[] paramArr1 = {0,1,2,3,4,5,6,7,8,9};
		
		ArrayList<int[]> list = new ArrayList<int[]>();
		
		list.add(paramArr1);
		
		Map<String, Integer> combinemaps = new HashMap<String,Integer>();
		for (int[] conbineArr : list) {
			ArrayList<String> screenList = CombineUtil.getScreenList(conbineArr,3);
			System.out.println(screenList.size());
		}
		
	}


}
