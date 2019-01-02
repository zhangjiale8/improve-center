package com.zjl.leecode.solutions;

/**
 * 11. 盛最多水的容器
 * 
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i,
 * ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 
 * @author zhangjiale
 *
 */
public class Solution11 {
	public static void main(String[] args) {
		int [] height = {2,6,3,8,9,5,7};
		int area = maxArea(height);
		System.out.println(area);
	}

	private static int maxArea(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int max = 0;
		while(left < right) {
			 max = Math.max(max, Math.min(height[left], height[right])*(right-left));
			 if(height[left]<height[right]){
				 left++;
		     }else{
		    	 right--;
		     }
		}
		return 0;
	}
}
