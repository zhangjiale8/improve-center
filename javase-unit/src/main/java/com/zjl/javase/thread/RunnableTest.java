package com.zjl.javase.thread;

public class RunnableTest {
	public static void main(String[] args) {
		class MyRunnable implements Runnable{
			private int tickets = 5;
			public void run() {
				synchronized(this){
					for (int i = 0; i < 5; i++) {
							try {
								Thread.sleep(100);
								System.out.println(Thread.currentThread().getName()+" loop " +i);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
					}
				}
				
			}
			
		}
		
		Runnable runnable = new MyRunnable();
		Thread t1 = new Thread(runnable,"t1");
		Thread t2 = new Thread(runnable,"t2");
		t1.start();
		t2.start();
	}
}
