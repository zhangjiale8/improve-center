package com.zjl.daily.caseinterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个长度为n的数组，寻找其中最大的k个数
 * @Description:寻找数组前K个最大的数   
 * @author: zhangjiale
 * @date:   2019年4月25日 下午2:48:52   
 *     
 * @Copyright: 2019
 */
public class FindKthElements {
	public static void main(String[] args) {
		int [] arr = {3,4,1,9,6,24,12}; 
		int k = 4;
		List<Integer> list = FindKthElements(arr,k);
		list = FindKthElements2(arr,k);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	/**
	 * 
	 * @Title: FindKthElements2   
	 * @Description: 算法二；前面k个数都比后面的数的最大值要大，则前面k个数就是最大的k个，时间复杂度O(k*(n-k))，空间复杂度O(1)
	 * 时间复杂度： O(k*(n-k))
	 * 空间复杂度： O(1)
	 * @param: @param arr
	 * @param: @param k
	 * @param: @return      
	 * @return: List<Integer>      
	 * @throws
	 */
	private static List<Integer> FindKthElements2(int[] arr, int k) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(arr.length <= 0 || arr == null || arr.length < k) {
			return res;
		}
		
		for(int i = 0;i < k;i ++) {
			int maxValueIndex = getMaxValueIndex(arr, k);
			if(arr[maxValueIndex] > arr[i]) {
				int temp = arr[maxValueIndex];
				arr[maxValueIndex] = arr[i];
				arr[i] = temp;
			}
		}
		
		for(int i = 0;i < k;i ++) {
			res.add(arr[i]);
		}
		return res;

	}
	/**
	 * 
	 * @Title: getMaxValueIndex   
	 * @Description: //选择排序：选出最大值的下标
	 * 时间复杂度： 
	 * 空间复杂度： 
	 * @param: @param arr
	 * @param: @param k
	 * @param: @return      
	 * @return: int      
	 * @throws
	 */
	private static int getMaxValueIndex(int[] arr, int k) {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * 
	 * @Title: FindKthElements   
	 * @Description: 算法一    排序，
	 * 时间复杂度： O(nlogn)
	 * 空间复杂度： O(1)
	 * @param: @param arr
	 * @param: @param k
	 * @param: @return      
	 * @return: List<Integer>      
	 * @throws
	 */
	private static List<Integer> FindKthElements(int[] arr, int k) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(arr.length <= 0 || arr == null || arr.length < k) {
			return res;
		}
		
		Arrays.sort(arr);
		for(int i = arr.length - 1;i > arr.length - 1 - k;i --) {
			res.add(arr[i]);
		}
		return res;

	}
}
