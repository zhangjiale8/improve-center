package com.zjl.daily.javavoice.day20181211.lambda.clas;

public class Test3 {
	public static void main(String[] args) {
		TestInter3 test = (long x,long y)->x+y;
		long add = test.add(10, 10);
		System.out.println(add);
	}
}
