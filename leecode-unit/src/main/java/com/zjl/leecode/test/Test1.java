package com.zjl.leecode.test;

import com.zjl.leecode.solutions.Solution1;

public class Test1 {
	public static void main(String[] args) {
		int [] nums = {2,7,11,15,22};
		int[] result = Solution1.addTwoSum1(nums,26);
		result = Solution1.addTwoSum2(nums,26);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		
	}
}
