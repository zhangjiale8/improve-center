package com.zjl.leecode.solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @Description:8. 字符串转换整数 (atoi)
 * 
 *                 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * 
 *                 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * 
 *                 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * 
 *                 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * 
 *                 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * 
 *                 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 * 
 *                 说明：
 * 
 *                 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231, 231 −
 *                 1]。如果数值超过这个范围，qing返回 INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 * 
 *                 示例 1:
 * 
 *                 输入: "42" 输出: 42 
 *                 
 *                 示例 2:
 * 
 *                 输入: " -42" 输出: -42 
 *                 解释: 第一个非空白字符为 '-', 它是一个负号。
 *                 我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。 
 *                 
 *                 示例 3:
 * 
 *                 输入: "4193 with words" 输出: 4193 
 *                 解释: 转换截止于数字 '3'
 *                 ，因为它的下一个字符不为数字。 
 *                 
 *                 示例 4:
 * 
 *                 输入: "words and 987" 输出: 0 
 *                 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 *                 因此无法执行有效的转换。 
 *                 
 *                 示例 5:
 * 
 *                 输入: "-91283472332" 输出: -2147483648 解释: 数字 "-91283472332" 超过
 *                 32 位有符号整数范围。 因此返回 INT_MIN (−231) 。
 * @author: zhangjiale
 * @date: 2019年1月4日 上午10:26:17
 * 
 * @Copyright: 2019
 */
public class Solution8 {
	/**
	 * 
	 * @Title: myAtoi   
	 * @Description:普通
	 * 时间复杂度： 
	 * 空间复杂度： 
	 * @param: @param param
	 * @param: @return      
	 * @return: int      
	 * @throws
	 */
	public static int myAtoi(String param) {
		//去掉字符串两端的多余的空格
		param = param.trim();
		if (param == null || param.isEmpty()) {
			return 0;
		}
		Set<Character> numbers = new HashSet<Character>();
		for (int i = 0; i < 10; i++) {
			numbers.add(Character.forDigit(i, 10));
		}

		char[] chars = param.toCharArray();
		StringBuilder sb = new StringBuilder();
		boolean negative;
		int minuSignCount = 0;
		int plusSignCount = 0;
		int i = 0;
		while (i < chars.length) {
			if (chars[i] == '-') {
				minuSignCount++;
				i++;
			} else if (chars[i] == '+') {
				plusSignCount++;
				i++;
			} else {
				break;
			}
		}
		if ((plusSignCount > 0 && minuSignCount > 0) || minuSignCount > 1 || plusSignCount > 1) {
			return 0;
		}
		negative = minuSignCount % 2 != 0;
		if (i >= chars.length) {
			return 0;
		}

		//it might be a floating number, so consider '.'
		int period = 0;
		while (i < chars.length && numbers.contains(chars[i])) {
			if (chars[i] == '.') {
				period++;
			}
			if (period > 1) {
				break;
			}
			sb.append(chars[i++]);
		}

		if (sb == null || sb.length() == 0) {
			return 0;
		}

		int result = 0;
		if (period > 0) {
			//use Double to parse
			try {
				result = (int) Double.parseDouble(sb.toString());
			} catch (Exception e) {
				System.out.println(e);
			}
		} else {
			//use Long to parse to handle integer overflow case
			long temp = 0;
			if (sb.length() >= Long.toString(Long.MAX_VALUE).length() && negative) {
				return Integer.MIN_VALUE;
			} else if (sb.length() >= Long.toString(Long.MAX_VALUE).length() && !negative) {
				return Integer.MAX_VALUE;
			} else {
				try {
					temp = Long.parseLong(sb.toString());
				} catch (Exception e) {
					if (sb.length() >= Integer.MAX_VALUE) {
						result = Integer.MAX_VALUE;
					}
				}
				if (temp > (long) Integer.MAX_VALUE + 1) {
					if (!negative) {
						return Integer.MAX_VALUE;
					} else {
						return Integer.MIN_VALUE;
					}
				} else if (temp == (long) Integer.MAX_VALUE + 1 && negative) {
					return Integer.MIN_VALUE;
				} else if (temp == (long) Integer.MAX_VALUE + 1) {
					return Integer.MAX_VALUE;
				} else if (temp < Integer.MIN_VALUE) {
					result = Integer.MIN_VALUE;
				} else {
					result = (int) temp;
				}
			}
		}

		if (negative) {
			result = -result;
		}
		return result;
	}
	/**
	 * 
	 * @Title: myAtoi2   
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * 时间复杂度： 
	 * 空间复杂度： 
	 * @param: @param param
	 * @param: @return      
	 * @return: int      
	 * @throws
	 */
	public static int myAtoi2(String param) {
		int p = 0;
		int result = 0;
		while (p < param.length() && Character.isWhitespace(param.charAt(p))) {
			p++;
		}
		if (p == param.length()) {
			return 0;
		}
		boolean negativeFlag = (param.charAt(p) == '-');
		if (param.charAt(p) == '+' || param.charAt(p) == '-') {
			p++;
		}
		for (; p < param.length(); p++) {
			if (param.charAt(p) > '9' || param.charAt(p) < '0') {
				break;
			} else {
				int digit = param.charAt(p) - '0';
				if (!negativeFlag && result > (Integer.MAX_VALUE - digit) / 10) {
					return Integer.MAX_VALUE;
				} else if (negativeFlag && result < (Integer.MIN_VALUE + digit) / 10) {
					return Integer.MIN_VALUE;
				}
				result = result * 10 + (negativeFlag ? -digit : digit);
			}
		}
		return result;
	}

}
