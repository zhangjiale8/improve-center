package com.zjl.leecode.solutions;

/**
 * 
 * @Description:7. 整数反转
 * 
 *                 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 
 *                 示例 1:
 * 
 *                 输入: 123 输出: 321 
 *                 
 *                 示例 2:
 * 
 *                 输入: -123 输出: -321 
 *                 
 *                 示例 3:
 * 
 *                 输入: 120 输出: 21 注意:
 * 
 *                 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 −1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * @author: zhangjiale
 * @date: 2019年1月4日 上午9:56:42
 * 
 * @Copyright: 2019
 */
public class Solution7 {

	public static int reverse(int param) {
		long rev = 0;
        while (param != 0) {
            rev = rev * 10 + param % 10;
            param /= 10;
            if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
                return 0;
            }
        }
        return (int) rev;
	}

}
