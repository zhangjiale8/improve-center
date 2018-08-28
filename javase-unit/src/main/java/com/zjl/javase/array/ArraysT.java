package com.zjl.javase.array;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.zjl.tools.ArrayTool;

public class ArraysT {
	public static void main(String[] args) {
		//声明数组
		declareArray();
		//初始化数组
		initArray();
		
		int[]  array={1,2,3,4,5,6,7,8,9,0};
		//获取数组长度
		int length = ArrayTool.getArrayLength(array);
		//int数组转成string
		String  strArr = ArrayTool.intArr2String(array);
		System.out.println(strArr);
		
		String []  strArrParam={"1","2","3","4","5","6","7"};
		//从array中创建arraylist
		ArrayList<Object> list = ArrayTool.array2ListByLoop(strArrParam);
		ArrayList<Object> list2 = ArrayTool.array2List(strArrParam);
		for (Object string : list) {
			System.out.println(string.toString());
		}
		
		//数组中是否包含某一个值
		boolean contain =  ArrayTool.isContains("1",strArrParam);
		System.out.println(contain);
		
		//将数组转成set集合；
		Set<Object> set = ArrayTool.aray2Set(strArrParam);
		for (Object object : set) {
			System.out.println(object.toString());
		}
		
		//数组填充
		int [] fillArr = new int[5]; 
		ArrayTool.fill(fillArr,5);
		for (int i = 0; i < fillArr.length; i++) {
			System.out.println(fillArr[i]);
		}
		//sorts
		int [] sortArr = {1,5,2,9,4,0};
		sortArr = ArrayTool.sort(sortArr);
		for (int i = 0; i < sortArr.length; i++) {
			System.out.println(sortArr[i]);
		}
		//sorts
		sortArr = ArrayTool.sort(sortArr,1,3);
		for (int i = 0; i < sortArr.length; i++) {
			System.out.println(sortArr[i]);
		}
		//复制数组
		int[] copyArr = {3,5,7,1,9};
		int[] copyArr2 = ArrayTool.copyof(copyArr,10);
		for (int i = 0; i < copyArr2.length; i++) {
			int j = copyArr2[i];
			System.out.println(j);
			
		}
		int[] copyArr3 = {3,5,7,1,9};
		int[] copyArr4 = ArrayTool.copyOfRange(copyArr3,1,3);
		for (int i = 0; i < copyArr4.length; i++) {
			int j = copyArr4[i];
			System.out.println(j);
		}
		//比较数组
		int[] comArr = {3,5,7,1,9};
		int[] comArr2 = {3,5,7,6,9};
		
		boolean flag = ArrayTool.compareArr(comArr,comArr2);
		System.out.println(flag);
		
		//去重
		int[] removeArr = {1, 2, 3, 4,5,6,7,8,9,0,3,2,4,5,6,7,4,32,2,1,1,4,6,3};
		
		int[] removeArr2 = ArrayTool.removeRepeat(removeArr);
		for (int i = 0; i < removeArr2.length; i++) {
			System.out.println(removeArr2[i]);
		}
		//获取最大值
		int[] maxArr = {10, 2, 3, 4,5,6,7,8,9,0,3,2,4,5,6,7,4,32,2,1,1,4,6,3};
		int max = ArrayTool.getMaxInArr(maxArr);
		System.out.println(max);
		//获取最小值
		int[] minArr = {10, 2, 3, 4,5,6,7,8,9,3,2,4,5,6,7,4,32,2,1,1,4,6,3};
		int min = ArrayTool.getMinInArr(minArr);
		System.out.println(min);
	}
	
	/**
	 * 初始化数组
	 */
	private static void initArray() {
		//静态初始化
		int[] arr = new int[] {1,2,3};
		String []  strArr = {"1","2"};
		String [] strArr2 = new String[] {"1","2","3"};
		//动态初始化
		int[] score = new int[3];
		for (int i = 0; i < score.length; i++) {
			score[i] = i;
		}
		
	}
	/**
	 * 声明数组
	 */
	private static void declareArray() {
		String [] arry;
		String arry2 [];
		String [] arry3 = new String[5];
		int score [] = new int[3];
		
	}
}
