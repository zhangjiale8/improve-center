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
					
					System.out.println(Thread.currentThread().getName() +"现在要执行 call notify()");
					notify();
				}
			}
			
		}
		
		ThreadA t1 = new ThreadA("t1");
		
		synchronized(t1) {
			//启动线程 t1
			System.out.println(Thread.currentThread().getName() +" start t1");
			t1.start();
			try {
				//主线程等待t1通过notify() 唤醒
				System.out.println(Thread.currentThread().getName()+ "  wait()");
				t1.wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			System.out.println(Thread.currentThread().getName() +"continue");
			
		}
	}
}
