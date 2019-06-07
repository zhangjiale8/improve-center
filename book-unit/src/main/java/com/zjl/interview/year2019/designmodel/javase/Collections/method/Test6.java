package com.zjl.interview.year2019.designmodel.javase.Collections.method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @Description: min(Collection),min(Collection,Comparator)方法的使用(前者采用Collection内含自然比较法，后者采用Comparator进行比较)
 * @author: zhangjiale
 * @date:   2019年6月3日 上午10:48:01   
 *     
 * @Copyright: 2019
 */
public class Test6 {
	public static void main(String[] args) {
		List list = Arrays.asList("7,2,0,4,5".split(","));
		System.out.println(list);
		System.out.println(Collections.min(list));
	
	}
}
