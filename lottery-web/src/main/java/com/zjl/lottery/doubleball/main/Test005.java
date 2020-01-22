package com.zjl.lottery.doubleball.main;

import java.util.Map;

import com.zjl.lottery.doubleball.util.MultipParamsListUtil;

public class Test005 {
	public static void main(String[] args) {
		int[] conbineArr ={2,3,4,6,7,8,9,10,11,13,14,15,16,17,18,20,21,22,23,24,26,27,30,31,32};
		Map<String, Integer> combinemap = MultipParamsListUtil.getScreenMap(conbineArr );
		System.out.println(combinemap.size());
	}
}
