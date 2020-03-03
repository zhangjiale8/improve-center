package com.zjl.javase.thread;

public class YieldTest {
	public static void main(String[] args) {

		class ThreadA extends Thread{
			public ThreadA(String name){
				super(name);
			}
			
			@Override
			public synchronized void run() {

				for(int i=0;i<10;i++){
					System.out.println(" "+this.getName()+" "+i);
					
					if(i%2 == 0){
						Thread.yield();
					}
				}
			}
		}
		
		ThreadA t1 = new ThreadA("t1");
		ThreadA t2 = new ThreadA("t2");
		t1.start();
		t2.start();

	}

}
