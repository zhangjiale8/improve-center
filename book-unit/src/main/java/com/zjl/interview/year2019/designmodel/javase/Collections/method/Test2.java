package com.zjl.interview.year2019.designmodel.javase.Collections.method;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @Description: reverse()方法的使用(含义：反转集合中元素的顺序)。
 * @author: zhangjiale
 * @date:   2019年6月3日 上午10:48:01   
 *     
 * @Copyright: 2019
 */
public class Test2 {
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		System.out.println(list);
		Collections.reverse(list);
		System.out.println(list);
	}
}
