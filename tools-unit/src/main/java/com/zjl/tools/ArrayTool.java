package com.zjl.tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayTool {
	/**
	 * 将数组转成set集合；
	 * @param arrParam
	 * @return
	 */
	public static Set<Object> aray2Set(Object[] arrParam) {
		if(null != arrParam) {
			return new HashSet<Object>(Arrays.asList(arrParam));
		}
		return null;
	}
	/**
	 * 数组中是否包含某一个值
	 * @param param
	 * @param arrParam
	 * @return
	 */
	public static boolean isContains(Object param, Object[] arrParam) {
		if(null != arrParam && null != param) {
			return Arrays.asList(arrParam).contains(param);
		}
		return false;
	}
	/**
	 * 从array中创建list
	 * @param arrParam
	 * @return
	 */
	public static ArrayList<Object> array2List(Object[] arrParam) {
		if(null != arrParam) {
			return new ArrayList<Object>(Arrays.asList(arrParam));
		}
		return null;
	}
	
	/**
	 * 从array中创建list 通过for循环
	 * @param arrParam
	 * @return
	 */
	public static ArrayList<Object> array2ListByLoop(Object[] arrParam) {
		if(null != arrParam) {
			ArrayList<Object> list=new ArrayList<Object>();
			for (Object obj : arrParam) {
				list.add(obj);
			}
			return list;
		}
		return null;
	}
	/**
	 * int数组转成string
	 * @param array
	 * @return
	 */
	public static String intArr2String(int[] array) {
		if(null != array) {
			return Arrays.toString(array);
		}
		return null;
		
	}
	/**
	 * 获取int数组长度
	 * @param array
	 * @return
	 */
	public static int getArrayLength(int[] array) {
		if(null != array) {
			return array.length;
		}
		return 0;
	}
	
}
