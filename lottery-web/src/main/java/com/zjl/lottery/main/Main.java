package com.zjl.lottery.main;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.zjl.lottery.db.util.JDBCPatchUtil;
import com.zjl.tools.ArrayTool;

public class Main {
	public static void main(String[] args) {
		//历史数据过滤
		//MainUtil.historyScreen();
		//复试数据过滤
		//MainUtil.compoundScreen();
		//数据过滤
		//screenCombinebydata();
		//历史数据五分过滤
		//screenCombinebyHistorydata();
		//十组数据预测法
		tenParamArrScreen();
		//多组数据组合过滤法
		//mutipleArrScreen();
		//初始化双色球历史数据
		//MainUtil.initDoubleBallHistory();
		//初始化大乐透历史数据
		//initGreatLottoHistory();
	}
	private static void mutipleArrScreen() {
		String fileName = "tenarrscreen0703914";
		String filePath = "E:" + File.separator + "screen" + File.separator;
		List<int[]> combinelist = new ArrayList<int[]>();
		List<int[]> list = new ArrayList<int[]>();
		for (int[] param : list) {
			
		}
	}
	private static void screenCombinebyHistorydata() {
		//String fileName = "tenarrscreen0051";
		
		ArrayList<String> historyList = JDBCPatchUtil.getHistoryList();
		int index = 0;
		for (String params : historyList) {
			if(StringUtils.isNotEmpty(params)){
				String fileName = "tenarrscreen0703"+index;
				String filePath = "E:" + File.separator + "screen" + File.separator +fileName+ ".txt";
				String[] strArr = params.split(",");
				int[] paramArr = ArrayTool.strArr2InArr(strArr);
				int screenNum = 5;
				int maxNum = 5;
				String saveFileName = "tenarrscreen0703"+(++index);
				MainUtil.screenCombinebydata(filePath,paramArr,screenNum,maxNum,saveFileName);
			}
		}
		
		
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
		int[] paramArr1 = {1,3,5,7,8,10,11,13,14,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,33};
		int[] paramArr2 = {1,2,3,5,6,8,9,11,12,13,14,15,16,17,18,20,23,24,25,26,27,28,29,31,33};
		int[] paramArr3 = {1,2,3,4,5,6,8,9,10,11,12,13,16,20,21,22,23,24,25,26,28,30,31,32};
		int[] paramArr4 = {1,2,3,4,5,6,7,8,9,10,11,12,13,17,18,19,20,22,23,24,25,26,27,30,32};
		int[] paramArr5 = {1,2,4,6,7,9,11,12,13,14,15,17,18,20,21,22,23,24,25,27,28,29,30,32,33};
		int[] paramArr6 = {1,2,3,4,5,6,8,9,10,11,14,15,16,17,20,22,24,25,27,28,29,30,31,32,33};
		int[] paramArr7 = {1,2,3,4,5,8,9,10,11,12,13,14,15,16,17,18,20,21,22,23,24,26,27,29,33};
		int[] paramArr8 = {1,2,4,5,6,7,8,9,10,12,13,14,15,16,17,20,21,24,25,27,29,30,31,32,33};
		int[] paramArr9 = {1,4,5,7,8,9,11,12,13,15,17,18,19,20,21,22,23,24,25,26,28,30,31,32,33};
		int[] paramArr10 = {4,6,7,9,10,11,13,14,15,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32};
		ArrayList<int[]> list = new ArrayList<int[]>();
		//list.add(paramArr11);
		list.add(paramArr10);
		list.add(paramArr9);
		list.add(paramArr8);
		list.add(paramArr7);
		list.add(paramArr6);
		list.add(paramArr5);
		list.add(paramArr4);
		list.add(paramArr3);
		list.add(paramArr2);
		list.add(paramArr1);
		int screenNum = 6;
		Map<String, Integer> combineMap = MainUtil.tenParamArrScreenHistoryAndThree(list,screenNum);
		Map<String, Integer> ThreeMap = MainUtil.screenThree(combineMap);
		Map<String, Integer> twoMap = MainUtil.screenTwo(ThreeMap);
		Map<String, Integer> historyMap = MainUtil.screenHistory(twoMap);
		
	}
	
	private static void pramsArr() {
		int[] paramArr1 = {};
		int[] paramArr2 = {};
		int[] paramArr3 = {};
		int[] paramArr4 = {};
		int[] paramArr5 = {};
		int[] paramArr6 = {};
		int[] paramArr7 = {};
		int[] paramArr8 = {};
		int[] paramArr9 = {};
		int[] paramArr10 = {};
	}

	private static void screenCombinebydata() {
		String fileName = "tenarrscreen00026";
		String filePath = "E:" + File.separator + "screen" + File.separator +fileName+ ".txt";
		int[] paramArr = {13,14,15};
		int screenNum = 3;
		int maxNum = 3;
		String saveFileName = "tenarrscreen00027";
		MainUtil.screenCombinebydata(filePath,paramArr,screenNum,maxNum,saveFileName);
	}
	
}
