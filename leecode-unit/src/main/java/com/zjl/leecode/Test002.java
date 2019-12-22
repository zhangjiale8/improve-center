package com.zjl.leecode;

public class Test002 {
	public static void main(String[] args) {
		String A = "ABCEABC";
		String B = "ACDBE";
		int dp[][] = new int [8][6];
		for (int i = 0; i < A.length(); i++) {
			for (int j = 0; j < B.length(); j++) {
				char ac = A.charAt(i);
				char bc = B.charAt(j);
				if(ac == bc){
					dp[i+1][j+1] = dp[i][j] +1;
				}else{
					
					dp[i+1][j+1] = max(dp[i+1][j],dp[i][j+1]);
				}
			}
		}
		System.out.println(dp[A.length()][B.length()]);
	}

	private static int max(int i, int j) {
		int max = i;
		if(i < j){
			max = j;
		}
		return max;
	}
}
