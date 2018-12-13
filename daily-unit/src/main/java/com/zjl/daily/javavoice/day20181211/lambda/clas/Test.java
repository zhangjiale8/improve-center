package com.zjl.daily.javavoice.day20181211.lambda.clas;

public class Test {
	public static void main(String[] args) {
		TestInter test = s-> System.out.println("oneParam方法传递参数："+s);
		test.oneParam("张三");
	}
}
