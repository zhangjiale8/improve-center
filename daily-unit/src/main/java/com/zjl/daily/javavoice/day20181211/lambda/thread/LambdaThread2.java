package com.zjl.daily.javavoice.day20181211.lambda.thread;

public class LambdaThread2 {
	public static void main(String[] args) {
		String name = "张三";
		Runnable run = ()->System.out.println("hello "+name);
		run.run();
	}
}
