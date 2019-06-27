package com.zjl.lottery.main;

import java.io.File;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		//历史数据过滤
		//MainUtil.historyScreen();
		//复试数据过滤
		//MainUtil.compoundScreen();
		//数据过滤
		//screenCombinebydata();
		//十组数据预测法
		tenParamArrScreen();
	}
	/**
	 * 
	 * @Title: tenParamArrScreen   
	 * @Description: 十组数据预测法
	 * 时间复杂度： 
	 * 空间复杂度： 
	 * @param:       
	 * @return: void      
	 * @throws
	 */
	private static void tenParamArrScreen() {
		int[] paramArr1 = {};
		int[] paramArr2 = {};
		int[] paramArr3 = {};
		int[] paramArr4 = {};
		ArrayList<int[]> list = new ArrayList<int[]>();
		int screenNum = 6;
		MainUtil.tenParamArrScreen(list,screenNum);
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
