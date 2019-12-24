package com.zjl.javase.thread;

public class ThreadTest {
	public static void main(String[] args) {
		class MyThread extends Thread {
			
			public MyThread(String name) {
				super(name);
			}

			@Override
			public void run() {
				synchronized(this) {
					for (int i = 0; i < 10; i++) {
						try {
							Thread.sleep(100);
							System.out.println(Thread.currentThread().getName() +" loop "+i);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
			
		}
		
		MyThread t1 = new MyThread("t1");
		MyThread t2 = new MyThread("t2");
		t1.start();
		t2.start();
	}
}
