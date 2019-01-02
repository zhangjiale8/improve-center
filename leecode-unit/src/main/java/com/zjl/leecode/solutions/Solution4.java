package com.zjl.leecode.solutions;

/**
 * 
 * @Description:4. 寻找两个有序数组的中位数 
 * 				        你可以假设 nums1 和 nums2 不会同时为空。
 * 
 *                 示例 1:
 * 
 *                 nums1 = [1, 3] nums2 = [2]
 * 
 *                 则中位数是 2.0 
 *                 
 *                 示例 2:
 * 
 *                 nums1 = [1, 2] nums2 = [3, 4]
 * 
 *                 则中位数是 (2 + 3)/2 = 2.5
 * @author: zhangjiale
 * @date: 2019年1月2日 上午11:32:56
 * 
 * @Copyright: 2019
 */
public class Solution4 {
	/**
	 * 
	 * @Title: findMedianSortedArrays   
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * 时间复杂度： O(log(m + n))
	 * 空间复杂度： 
	 * @param: @param nums1
	 * @param: @param nums2
	 * @param: @return      
	 * @return: double      
	 * @throws
	 */
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
        int n = nums2.length;
        int l = (m + n + 1) / 2;
        int r = (m + n + 2) / 2;
        return (getkth(nums1, 0, nums2, 0, l) + getkth(nums1, 0, nums2, 0, r)) / 2.0;
	}

	private static double getkth(int[] nums1, int aStart, int[] nums2, int bStart, int k) {
		if (aStart > nums1.length - 1) {
            return nums2[bStart + k - 1];
        }
        if (bStart > nums2.length - 1) {
            return nums1[aStart + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[aStart], nums2[bStart]);
        }

        int aMid = Integer.MAX_VALUE;
        int bMid = Integer.MAX_VALUE;
        if (aStart + k / 2 - 1 < nums1.length) {
            aMid = nums1[aStart + k / 2 - 1];
        }
        if (bStart + k / 2 - 1 < nums2.length) {
            bMid = nums2[bStart + k / 2 - 1];
        }

        if (aMid < bMid) {
            return getkth(nums1, aStart + k / 2, nums2, bStart, k - k / 2);// Check: aRight + bLeft
        } else {
            return getkth(nums1, aStart, nums2, bStart + k / 2, k - k / 2);// Check: bRight + aLeft
        }
	}
	/**
	 * 
	 * @Title: findMedianSortedArrays2   
	 * @Description: 
	 * 时间复杂度： 
	 * 空间复杂度： 
	 * @param: @param nums1
	 * @param: @param nums2
	 * @param: @return      
	 * @return: double      
	 * @throws
	 */
	public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
		 int K = nums1.length + nums2.length;
         if (K % 2 == 0) {
             return (findMedianSortedArrays(nums1, nums2, (K - K / 2)) + findMedianSortedArrays(nums1, nums2, (K - (K / 2 + 1)))) / 2;
         } else {
             return findMedianSortedArrays(nums1, nums2, K - (K / 2 + 1));
         }
	}
	/**
	 * 
	 * @Title: findMedianSortedArrays   
	 * @Description: 中位数
	 * 时间复杂度： 
	 * 空间复杂度： 
	 * @param: @param A
	 * @param: @param B
	 * @param: @param K
	 * @param: @return      
	 * @return: double      
	 * @throws
	 */
	private static double findMedianSortedArrays(int[] A, int[] B, int K) {

        int highA = A.length;
        int highB = B.length;
        int midA;
        int midB;
        while (K > 0 && highA > 0 && highB > 0) {
            int chopA = Math.max(1, Math.min(K / 2, (highA) / 2));
            int chopB = Math.max(1, Math.min(K / 2, (highB) / 2));

            midA = highA - chopA;
            midB = highB - chopB;
            if (A[midA] < B[midB]) { 
                highB = midB;
                K = K - chopB;
            } else {
                highA = midA;
                K = K - chopA;
            }
        }

        if (highA == 0 && highB == 0) {
            return 0;
        }
        if (highA == 0) {
            return B[highB - 1 - K];
        }
        if (highB == 0) {
            return A[highA - 1 - K];
        }
        return Math.max(A[highA - 1], B[highB - 1]);
    }

}
