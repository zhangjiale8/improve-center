package com.zjl.daily.nowcoder.textbook.crazyjava.process;
/**
 * 
 * @Description:使用循坏输出等腰三角形   例如给定4  
 * @author: zhangjiale
 * @date:   2019年5月13日 下午2:08:42   
 *     
 * @Copyright: 2019
 */
public class GetRectangle {
	public static void main(String[] args) {
		int nums = 5;
		getRectangle(nums);
	}

	private static void getRectangle(int nums) {
		for (int i = 1; i < nums; i++) {
			for (int j = 0; j < nums -i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 2*i - 1; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
	}
}
