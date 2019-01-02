package com.zjl.leecode.solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @Description:3. 无重复字符的最长子串 
 * 				       给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 *                 示例 1:
 * 
 *                 输入: "abcabcbb" 输出: 3 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。 
 *                 示例 2:
 * 
 *                 输入: "bbbbb" 输出: 1 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。 
 *                 示例 3:
 * 
 *                 输入: "pwwkew" 输出: 3 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *                 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * @author: zhangjiale
 * @date: 2019年1月2日 上午10:44:02
 * 
 * @Copyright: 2019
 */
public class Solution3 {
	/**
	 * 
	 * @Title: lengthOfLongestSubstring   
	 * @Description: 利用map的属性方法   
	 * @param: @param param
	 * @param: @return      
	 * @return: int      
	 * @throws
	 */
	public static int lengthOfLongestSubstring(String param) {
		int result = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0, j = i; j < param.length(); ) {
            if (!map.containsKey(param.charAt(j)) || (map.containsKey(param.charAt(j)) && map.get(param.charAt(j)) == 0)) {
                map.put(param.charAt(j), 1);
                result = Math.max(j - i + 1, result);
                j++;
            } else {
                map.put(param.charAt(i), map.get(param.charAt(i)) - 1);
                i++;
            }
        }
        return result;
	}
	/**
	 * 
	 * @Title: lengthOfLongestSubstring2   
	 * @Description: set无序不可重复 while循环
	 * 时间复杂度： O(n)
	 * 空间复杂度： O(min(m,n)) or O(k)
	 * @param: @param param
	 * @param: @return      
	 * @return: int      
	 * @throws
	 */
	public static int lengthOfLongestSubstring2(String param) {
		int n = param.length();
        Set<Character> set = new HashSet<Character>();
        int result = 0;
        int i = 0;
        int j = 0;
        while (i < n && j < n) {
            if (!set.contains(param.charAt(j))) {
                set.add(param.charAt(j++));
                result = Math.max(result, j - i);
            } else {
                set.remove(param.charAt(i++));
            }
        }
        return result;
	}
	/**
	 * 
	 * @Title: lengthOfLongestSubstring3   
	 * @Description: 
	 * 时间复杂度： O(n)
	 * 空间复杂度： O(n)
	 * @param: @param param
	 * @param: @return      
	 * @return: int      
	 * @throws
	 */
	public static int lengthOfLongestSubstring3(String param) {
		 if (param.length() == 0) {
             return 0;
         }
         int max = 0;
         Map<Character, Integer> map = new HashMap<Character, Integer>();
         for (int i = 0, j = 0; i < param.length(); i++) {
             if (map.containsKey(param.charAt(i))) {
                 j = Math.max(j, map.get(param.charAt(i)) + 1);
             }
             map.put(param.charAt(i), i);
             max = Math.max(max, i + 1 - j);
         }
         return max;
	}
	/**
	 * 
	 * @Title: lengthOfLongestSubstring4   
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * 时间复杂度： O(n)
	 * 空间复杂度： O(n)
	 * @param: @param param
	 * @param: @return      
	 * @return: int      
	 * @throws
	 */
	public static int lengthOfLongestSubstring4(String param) {
		 if (param.length() == 0) {
             return 0;
         }
         int max = 0;
         int[] index = new int[128];
         for (int i = 0, j = 0; j < param.length(); j++) {
             i = Math.max(index[param.charAt(j)], i);
             max = Math.max(max, j - i + 1);
             index[param.charAt(j)] = j + 1;
         }
         return max;
	}
	
}
