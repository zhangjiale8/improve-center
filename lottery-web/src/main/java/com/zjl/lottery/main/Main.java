package com.zjl.lottery.main;

import java.io.File;

public class Main {
	public static void main(String[] args) {
		//历史数据过滤
		//MainUtil.historyScreen();
		//复试数据过滤
		//MainUtil.compoundScreen();
		//数据过滤
		screenCombinebydata();
	}

	private static void screenCombinebydata() {
		String fileName = "screen201906072323";
		String filePath = "E:" + File.separator + "screen" + File.separator +fileName+ ".txt";
		int[] paramArr = {3,6,16,18,21,30};
		int screenNum = 5;
		int maxNum = 5;
		String saveFileName = "screen201906072324";
		MainUtil.screenCombinebydata(filePath,paramArr,screenNum,maxNum,saveFileName);
	}
}
