package com.zjl.interview.year2019.designmodel.javase.Collections.method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @Description: fill(List list,Object o)方法的使用(含义：用对象o替换集合list中的所有元素)
 * @author: zhangjiale
 * @date:   2019年6月3日 上午10:48:01   
 *     
 * @Copyright: 2019
 */
public class Test4 {
	public static void main(String[] args) {
		List list = Arrays.asList("1,2,3,4,5".split(","));
		System.out.println(list);
		Collections.fill(list, "00");
		System.out.println(list);
	
	}
}
