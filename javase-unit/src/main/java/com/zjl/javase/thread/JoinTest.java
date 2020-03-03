package com.zjl.javase.thread;

public class JoinTest {
	public static void main(String[] args) {


		class ThreadA extends Thread{
			
			public ThreadA(String name){
				super(name);
			}
			
			@Override
			public void run() {
				System.out.println("start "+this.getName());
				
				for(int i=0;i<1000000000;i++)
					;
				
				System.out.println("finish "+ this.getName());
			}
		}

		Thread t1 = new ThreadA("t1");
		t1.start();
		
		try {
			
			t1.join();
			
			System.out.println("finish "+Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
