package com.zjl.leecode.solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @Description:TODO 
 * 					1. 两数之和
 * 
 *                   给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个
 *                   整数，并返回他们的数组下标。
 * 
 *                   你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 
 *                   示例:
 * 
 *                   给定 nums = [2, 7, 11, 15], target = 9
 * 
 *                   因为 nums[0] + nums[1] = 2 + 7 = 9 所以返回 [0, 1]
 * 
 *                   题解： 一组数，分别两两求和，当和等于目标值时返回这两个数的位置
 * 
 * @author: zhangjiale
 * @date: 2019年1月2日 上午9:09:22
 * @Copyright: 2019
 */
public class Solution1 {

	/**
	 * 单循环 运用map的不可重复特性
	 * 
	 * @param nums
	 * @param i
	 * @return
	 */
	public static int[] addTwoSum2(int[] nums, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i]) && i != map.get(target - nums[i])) {
				result[0] = map.get(nums[i]);
				result[0] = map.get(target - nums[i]);
				break;
			}
		}
		return result;
	}

	/**
	 * 双层循环
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] addTwoSum1(int[] nums, int target) {
		int[] result = new int[2];
		for (int i = 0; i < nums.length; i++) {
			int firstNum = nums[i];
			int lastNum = target - firstNum;
			for (int j = 0; j < nums.length; j++) {
				if (nums[j] == lastNum && i != j) {
					result[0] = i;
					result[1] = j;
				}
			}
		}
		return result;
	}

}
