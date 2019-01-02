package com.zjl.leecode.test;

import com.zjl.leecode.solutions.Solution3;

public class Test3 {
	public static void main(String[] args) {
		String param = "abcabcbb";
		int count = Solution3.lengthOfLongestSubstring(param);
		count = Solution3.lengthOfLongestSubstring2(param);
		count = Solution3.lengthOfLongestSubstring3(param);
		count = Solution3.lengthOfLongestSubstring4(param);
		System.out.println(count);
	}
}
