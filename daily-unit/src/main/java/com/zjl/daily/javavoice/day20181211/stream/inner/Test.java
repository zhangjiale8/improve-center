package com.zjl.daily.javavoice.day20181211.stream.inner;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		
		long count = list.stream().filter(integer -> integer >2).count();
		System.out.println(count);
		
		
	}
}
