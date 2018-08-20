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
