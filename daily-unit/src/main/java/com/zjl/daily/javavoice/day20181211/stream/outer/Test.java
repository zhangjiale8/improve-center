package com.zjl.daily.javavoice.day20181211.stream.outer;

import java.util.ArrayList;
import java.util.Iterator;
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
		for (Integer integer : list) {
			if(integer == 3) {
				System.out.println(integer);
			}
		}
		
		Iterator<Integer> it =  list.iterator();
		while(it.hasNext()) {
			Integer integer = it.next();
			if(integer == 3) {
				System.out.println(integer);
			}
		}
		
		
	}
}
