package com.zjl.lottery.test;

import java.util.ArrayList;

import com.zjl.lottery.util.MultipParamsListUtil;
import com.zjl.lottery.util.ParamsListUtil;

public class MultipParamsListTest {
	public static void main(String[] args) {

		int[] paramArr1 = {2,3,4,5,6,10,11,12,13,14,15,16,17,18,21,22,23,24,25,26,27,28,30,31,33};
		int[] paramArr2 = {1,2,5,6,7,8,9,10,11,12,15,16,17,18,19,20,22,23,25,26,28,30,31,32,33};
		int[] paramArr3 = {1,3,4,6,7,8,10,11,12,13,15,18,19,20,23,24,25,26,27,28,29,30,31,32,33};
		int[] paramArr4 = {1,2,3,4,5,6,7,8,10,12,13,14,18,19,20,21,22,23,24,26,27,29,30,32,33};
		int[] paramArr5 = {1,2,3,4,5,6,8,9,10,11,12,13,14,15,16,18,19,20,21,23,25,26,28,29,32};
		int[] paramArr6 = {1,3,5,6,7,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,31,32,33};
		int[] paramArr7 = {1,2,3,4,6,7,8,9,10,11,13,15,16,18,20,21,23,24,25,27,28,29,30,31,33};
		int[] paramArr8 = {1,5,6,8,9,10,11,12,13,14,15,16,18,19,20,21,23,24,25,26,27,28,30,32,33};
		int[] paramArr9 = {1,2,3,5,6,7,8,9,10,12,13,14,15,16,17,18,20,23,24,25,28,29,31,32,33};
		int[] paramArr10 = {2,3,4,5,6,7,9,10,11,12,13,14,15,16,17,19,20,23,24,26,27,28,29,31,33};
		int[] paramArr11 = {1,2,3,4,5,7,8,9,10,11,12,13,15,16,18,19,20,22,23,24,27,29,30,31,32};
		//int[] paramArr12 = {};
		ArrayList<int[]> screenlist = new ArrayList<int[]>();
		//screenlist.add(paramArr12);
		screenlist.add(paramArr11);
		screenlist.add(paramArr10);
		screenlist.add(paramArr9);
		screenlist.add(paramArr8);
		screenlist.add(paramArr7);
		screenlist.add(paramArr6);
		screenlist.add(paramArr5);
		screenlist.add(paramArr4);
		screenlist.add(paramArr3);
		screenlist.add(paramArr2);
		screenlist.add(paramArr1);
		int[] screenarray = {1,2,3,5,6,7,8,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,30,31,32,33};
	
		MultipParamsListUtil.screenDetermined(screenlist, screenarray);
	}
}
