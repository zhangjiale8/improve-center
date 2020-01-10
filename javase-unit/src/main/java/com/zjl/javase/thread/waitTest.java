package com.zjl.javase.thread;

public class waitTest {
	public static void main(String[] args) {
		class ThreadA extends Thread{
			public ThreadA(String name) {
				super(name);
			}

			@Override
			public void run() {
				synchronized(this) {
					System.out.println(Thread.currentThread().getName() +"正在执行");
					
					System.out.println(Thread.currentThread().getName() +"现在要执行");
					notify();
				}
			}
			
		}
		
		ThreadA t1 = new ThreadA("t1");
		
		synchronized(t1) {
			//启动线程 t1
			System.out.println(Thread.currentThread().getName() +"start t1");
			t1.start();
			
			
		}
	}
}
