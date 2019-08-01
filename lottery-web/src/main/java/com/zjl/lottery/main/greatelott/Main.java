package com.zjl.lottery.main.greatelott;

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
		int[] paramArr1 = {3,5,6,7,8,10,11,13,14,15,20,21,22,23,25,27,28,29,32,34};
		int[] paramArr2 = {1,2,3,5,6,9,11,14,17,19,21,22,26,27,29,30,32,33,34};
		int[] paramArr3 = {1,2,3,4,5,6,10,13,14,15,18,21,22,23,25,28,29,30,31,34};
		int[] paramArr4 = {1,4,5,6,8,9,11,12,17,18,19,20,21,24,26,28,30,31,32,34};
		int[] paramArr5 = {1,4,5,6,7,10,11,13,15,16,17,21,23,26,28,29,30,33,34,35};
		int[] paramArr6 = {1,2,4,6,7,8,9,10,11,14,17,18,19,21,22,23,25,27,31,32};
		int[] paramArr7 = {1,2,6,8,11,12,13,15,16,17,18,20,21,24,25,27,30,31,32,33};
		int[] paramArr8 = {2,6,8,9,10,11,12,13,17,18,20,21,22,24,26,27,28,29,31,34};
		int[] paramArr9 = {2,3,5,6,8,9,11,12,13,14,16,18,19,21,23,25,26,28,29,31};
		int[] paramArr10 = {5,6,7,9,11,12,15,16,19,21,23,24,25,26,27,28,29,30,32,34};
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
