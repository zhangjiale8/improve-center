package com.zjl.leecode.solutions;

/**
 * 
 * @Description: 5. 最长回文子串 
 * 				   给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 
 *               示例 1：
 * 
 *               输入: "babad" 输出: "bab" 注意: "aba" 也是一个有效答案。 
 *               
 *               示例 2：
 * 
 *               输入: "cbbd" 输出: "bb"
 * @author: zhangjiale
 * @date: 2019年1月2日 下午2:03:07
 * 
 * @Copyright: 2019
 */
public class Solution5 {
	private static int low;
    private static int maxLen;
	public static String longestPalindrome(String param) {
		 int len = param.length();
         if (len < 2) {
             return param;
         }

         for (int i = 0; i < len - 1; i++) {
             extendPalindrome(param, i, i); // assume odd length, try to extend Palindrome as possible
             extendPalindrome(param, i, i + 1); // assume even length.
         }
         return param.substring(low, low + maxLen);
	}
	private static void extendPalindrome(String param, int left, int right) {
        while (left >= 0 && right < param.length() && param.charAt(left) == param.charAt(right)) {
            left--;
            right++;
        }
        if (maxLen < right - left - 1) {
            low = left + 1;
            maxLen = right - left - 1;
        }
    }

}
