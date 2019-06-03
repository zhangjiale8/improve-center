package com.zjl.interview.year2019.designmodel.javase.Collections.method;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @Description: sort(Collection)方法的使用(含义：对集合进行排序)。
 * @author: zhangjiale
 * @date:   2019年6月3日 上午10:48:01   
 *     
 * @Copyright: 2019
 */
public class Test {
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("l");
		list.add("o");
		list.add("v");
		list.add("e");
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
	}
}
