package com.zjl.daily.javavoice.day20181211.lambda.thread;

public class LambdaThread {
	public static void main(String[] args) {
		new Thread(()->{
			System.out.println("lambda代替内部类");
		}).start();
	}
}
