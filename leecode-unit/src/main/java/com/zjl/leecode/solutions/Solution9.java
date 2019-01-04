package com.zjl.leecode.solutions;

/**
 * 
 * @Description:9. 回文数
 * 
 *                 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 
 *                 示例 1:
 * 
 *                 输入: 121 输出: true 
 *                 
 *                 示例 2:
 * 
 *                 输入: -121 输出: false 解释: 从左向右读, 为 -121 。 从右向左读, 为 121-
 *                 。因此它不是一个回文数。 
 *                 
 *                 示例 3:
 * 
 *                 输入: 10 输出: false 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * @author: zhangjiale
 * @date: 2019年1月4日 上午11:34:49
 * 
 * @Copyright: 2019
 */
public class Solution9 {
	/**
	 * 
	 * @Title: isPalindrome   
	 * @Description: 
	 * 时间复杂度： 
	 * 空间复杂度： 
	 * @param: @param param
	 * @param: @return      
	 * @return: int      
	 * @throws
	 */
	public static boolean isPalindrome(int param) {
		if (param == 0) {
            return true;
        }
        if (param < 0) {
            return false;
        }
        int rev = 0;
        int tmp = param;
        while (tmp != 0) {
            rev *= 10;
            rev += tmp % 10;
            tmp /= 10;
        }
        return rev == param;
	}

	public static boolean isPalindrome2(int param) {
		if (param < 0) {
            return false;
        } else if (param == 0) {
            return true;
        } else if (param % 10 == 0) {
            return false;
        }
        int reversed = 0;
        while (param > reversed) {
            int digit = param % 10;
            reversed *= 10;
            reversed += digit;
            param /= 10;
        }
        return (param == reversed || param == reversed / 10);
	}

}
