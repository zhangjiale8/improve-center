package com.zjl.daily.javavoice.day20181211.lambda.thread;

public class CommonThread {
	public static void main(String[] args) {
		new Thread(new Runnable() {
			
			public void run() {
				System.out.println("匿名函数内部的执行");
				
			}
		}).start();
	}
}
