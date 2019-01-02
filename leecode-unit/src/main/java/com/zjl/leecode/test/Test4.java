package com.zjl.leecode.test;

import com.zjl.leecode.solutions.Solution4;

public class Test4 {
	public static void main(String[] args) {
		int [] nums1 = {1,3};
		int [] nums2 = {2};
		double result = Solution4.findMedianSortedArrays(nums1,nums2);
		result = Solution4.findMedianSortedArrays2(nums1,nums2);
		System.out.println(result);
	}
}
