package com.zjl.daily.javavoice.day20181211.lambda.clas;

public class Test2 {
	public static void main(String[] args) {
		TestInter2 test = (x,y)->x+y;
		int add = test.add(10, 10);
		System.out.println(add);
	}
}
