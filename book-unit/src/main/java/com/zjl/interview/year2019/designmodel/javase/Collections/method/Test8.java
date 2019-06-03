package com.zjl.interview.year2019.designmodel.javase.Collections.method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @Description: indexOfSubList(List list,List subList)方法的使用(含义：查找subList在list中首次出现位置的索引)。

 * @author: zhangjiale
 * @date:   2019年6月3日 上午10:48:01   
 *     
 * @Copyright: 2019
 */
public class Test8 {
	public static void main(String[] args) {
		List list = Arrays.asList("7,2,0,9,5,0,9,5".split(","));
		List list2 = Arrays.asList("0,9,5".split(","));
		System.out.println(list);
		System.out.println(Collections.indexOfSubList(list, list2));
	
	}
}
