package com.zjl.javase.thread;

public class RunnableTest2 {
	public static void main(String[] args) {
final Object obj = new Object();
		
		class MyThread extends Thread{
			
			public MyThread(String name){
				super(name);
			}
			@Override
			public void run() {
				synchronized(obj){
					for(int i=0;i<10;i++){
						try {
							 if (i%4 == 0)
								 Thread.sleep(100);
							System.out.println(Thread.currentThread().getName()+" loop "+i);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
		
		Thread t1 = new MyThread("t1");
		Thread t2 = new MyThread("t2");
		t1.start();
		t2.start();

	}
}
