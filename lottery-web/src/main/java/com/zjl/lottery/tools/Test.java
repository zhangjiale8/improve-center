package com.zjl.lottery.tools;

import java.util.Map;

import com.zjl.lottery.doubleball.util.MultipParamsListUtil;
import com.zjl.tools.ArrayTool;

public class Test {
	public static void main(String[] args) {
		int[] paramArr1 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
		int[] paramArr2 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		Map<String, Integer> combinemap1 = MultipParamsListUtil.getScreenMap(paramArr1);
		Map<String, Integer> combinemap2 = MultipParamsListUtil.getScreenMap(paramArr2);
		System.out.println(combinemap1.size() - combinemap2.size());

	}
}
