package com.zjl.javase.thread;

public class YieldLockTest {
	public static void main(String[] args) {

		final Object obj = new Object();
		
           class ThreadA extends Thread{
  			
			public ThreadA(String name){
				super(name);
			}
			
			@Override
			public void run() {
				synchronized(obj){
					for(int i=0;i<10;i++){
						System.out.println(this.getName()+" "+i);
						if(i%4==0){
							Thread.yield();
						}
					}
				}
			}
		}
	
		ThreadA  t1 = new ThreadA("t1");
		ThreadA  t2 = new ThreadA("t2");
		t1.start();
		t2.start();

	}

}
