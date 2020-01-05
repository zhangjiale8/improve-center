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

		
		int[] paramArr1 = {2,4,10,13,19,23,30};
		int[] paramArr2 = {1,4,9,19,22,25,30};
		
		ArrayList<int[]> list = new ArrayList<int[]>();
		
		list.add(paramArr1);
		list.add(paramArr2);
		
		Map<String, Integer> combinemaps = new HashMap<String,Integer>();
		for (int[] conbineArr : list) {
			ArrayList<String> screenList = CombineUtil.getScreenList(conbineArr,6);
			for (String string : screenList) {
				System.out.println(string);
			}
		}
		
	}


}
