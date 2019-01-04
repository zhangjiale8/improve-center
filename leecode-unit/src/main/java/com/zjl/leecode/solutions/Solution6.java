package com.zjl.leecode.solutions;

/**
 * 
 * @Description:6. Z 字形变换 
 * 					将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 
 *                 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * 
 *                 L C I R E T O E S I I G E D H N
 *                 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 
 *                 请你实现这个将字符串进行指定行数变换的函数：
 * 
 *                 string convert(string s, int numRows); 
 *                 示例 1:
 * 
 *                 输入: s = "LEETCODEISHIRING", numRows = 3 输出:
 *                 "LCIRETOESIIGEDHN" 
 *                 示例 2:
 * 
 *                 输入: s = "LEETCODEISHIRING", numRows = 4 输出:
 *                 "LDREOEIIECIHNTSG" 解释:
 * 
 *                 L     D     R
 *				   E   O E   I I
 *				   E C   I H   N
				   T     S     G
 * @author: zhangjiale
 * @date: 2019年1月3日 上午11:00:56
 * 
 * @Copyright: 2019
 */
public class Solution6 {

	public static String convert(String param, int numRows) {
		StringBuilder[] sb = new StringBuilder[numRows];
		char[] c = param.toCharArray();
		int len = param.length();
		for (int i = 0; i < numRows; i++) {
			sb[i] = new StringBuilder();//this is an important step to initialize it
		}
		int i = 0;
		while (i < len) {
			for (int index = 0; index < numRows && i < len; index++) {
				sb[index].append(c[i++]);// vertically down
			}

			for (int index = numRows - 2; index >= 1 && i < len; index--) {
				/**Why it should start from numRows - 2? Think of the example when numRows = 3
				 the starting point of obliquely going up is 1, which is numRows-2.*/
				sb[index].append(c[i++]);// obliquely up
			}
		}

		for (i = 1; i < numRows; i++) {
			sb[0].append(sb[i]);
		}
		return sb[0].toString();
	}
	
}
