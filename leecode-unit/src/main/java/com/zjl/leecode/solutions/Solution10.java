package com.zjl.leecode.solutions;

/**
 * 
 * @Description:10. 正则表达式匹配
 * 
 *                  给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。
 * 
 *                  '.' 匹配任意单个字符。 '*' 匹配零个或多个前面的元素。 匹配应该覆盖整个字符串 (s) ，而不是部分字符串。
 * 
 *                  说明:
 * 
 *                  s 可能为空，且只包含从 a-z 的小写字母。 p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 *                  示例 1:
 * 
 *                  输入: s = "aa" p = "a" 输出: false 解释: "a" 无法匹配 "aa" 整个字符串。 
 *                  
 *                  示例2:
 * 
 *                  输入: s = "aa" p = "a*" 输出: true 解释: '*' 代表可匹配零个或多个前面的元素,
 *                  即可以匹配 'a' 。因此, 重复 'a' 一次, 字符串可变为 "aa"。
 *                  
 *                   示例 3:
 * 
 *                  输入: s = "ab" p = ".*" 输出: true 解释: ".*"
 *                  表示可匹配零个或多个('*')任意字符('.')。 
 *                  
 *                  示例 4:
 * 
 *                  输入: s = "aab" p = "c*a*b" 输出: true 解释: 'c' 可以不被重复, 'a'
 *                  可以被重复一次。因此可以匹配字符串 "aab"。 
 *                  
 *                  示例 5:
 * 
 *                  输入: s = "mississippi" p = "mis*is*p*." 输出: false
 * @author: zhangjiale
 * @date: 2019年1月8日 上午11:55:57
 * 
 * @Copyright: 2019
 */
public class Solution10 {

	public static boolean isMatch(String param, String reg) {
		if (param == null || reg == null) {
            return false;
        }
        boolean[][] dp = new boolean[param.length() + 1][reg.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < reg.length(); i++) { //here's the p's length, not s's
            if (reg.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true; //here's y axis should be i+1
            }
        }
        for (int i = 0; i < param.length(); i++) {
            for (int j = 0; j < reg.length(); j++) {
                if (reg.charAt(j) == '.' || reg.charAt(j) == param.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (reg.charAt(j) == '*') {
                    if (reg.charAt(j - 1) != param.charAt(i) && reg.charAt(j - 1) != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                    }
                }
            }
        }
        return dp[param.length()][reg.length()];
	}

}
