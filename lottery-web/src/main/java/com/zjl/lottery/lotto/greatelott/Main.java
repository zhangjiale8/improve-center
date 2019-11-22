package com.zjl.lottery.lotto.greatelott;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.zjl.lottery.combine.util.CombineUtil;
import com.zjl.lottery.util.JDBCPatchUtil;
import com.zjl.lottery.util.MapTxtUtil;
import com.zjl.tools.ArrayTool;

public class Main {
	public static void main(String[] args) {
		
		//十组数据预测法
		//tenParamArrScreen();
		
		getAllCombine();
		
	}

	private static void getAllCombine() {
		int screenNum = 5;
		int[] paramArr ={1,4,5,8,9,10,11,13,14,15,16,17,18,19,20,21,23,24,26,28,29,30,31,33,34,35};
		ArrayList<String> screenList = CombineUtil.getScreenList(paramArr,screenNum);
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < screenList.size(); i++) {
			String temp = screenList.get(i);
			map.put(temp, 1);
		}
		Map<String, Integer> threemap = MainUtil.screenThree(map);
		Map<String, Integer> twomap = MainUtil.screenTwo(threemap);
		MapTxtUtil.createScreenTxtMap(map, "tenarrscreenquan");

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
		int[] paramArr1 = {1,3,4,5,6,11,12,13,14,17,19,20,23,24,25,26,27,30,32,33};
		int[] paramArr2 = {1,2,4,5,6,9,10,11,13,15,16,17,19,21,22,27,28,29,30,31};
		int[] paramArr3 = {1,3,4,5,9,10,11,12,13,14,15,17,18,19,22,23,26,27,29,33};
		int[] paramArr4 = {2,3,5,7,8,9,10,11,14,15,16,18,19,20,22,23,25,27,28,34};
		int[] paramArr5 = {1,2,3,4,5,6,7,9,12,14,15,16,18,21,22,25,28,30,32,33};
		int[] paramArr6 = {2,5,6,7,8,11,12,13,15,16,19,23,24,25,27,28,29,30,32,33};
		int[] paramArr7 = {2,4,5,7,9,12,13,14,15,16,18,19,20,23,25,26,28,31,32,33};
		int[] paramArr8 = {1,2,3,4,5,11,12,15,18,20,21,22,23,27,28,29,30,31,34};
		int[] paramArr9 = {1,3,7,8,10,11,12,15,17,18,21,22,23,24,25,27,28,29,30,31};
		//int[] paramArr10 = {};
		ArrayList<int[]> list = new ArrayList<int[]>();
		//list.add(paramArr11);
		//list.add(paramArr10);
		list.add(paramArr9);
		list.add(paramArr8);
		list.add(paramArr7);
		list.add(paramArr6);
		list.add(paramArr5);
		list.add(paramArr4);
		list.add(paramArr3);
		list.add(paramArr2);
		list.add(paramArr1);
		int screenNum = 5;
		Map<String, Integer> map = MainUtil.tenParamArrScreen(list,screenNum);
		Map<String, Integer> threemap = MainUtil.screenThree(map);
		Map<String, Integer> twomap = MainUtil.screenTwo(threemap);
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

}
