package com.zjl.javase.thread;

public class WaitTimeoutTest {
	public static void main(String[] args) {
		class ThreadA extends Thread {
			public ThreadA(String name) {
				super(name);
			}

			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + " run");
				// 死循环
				while (true)
					;
			}
		}

		ThreadA t1 = new ThreadA("t1");
		synchronized (t1) {
			try {
				// 启动“线程t1”
				System.out.println(Thread.currentThread().getName() + " start t1");
				t1.start();

				// 主线程等待t1通过notify()唤醒 或 notifyAll()唤醒，或超过3000ms延时；然后才被唤醒。
				System.out.println(Thread.currentThread().getName() + " call wait ");
				t1.wait(3000);

				System.out.println(Thread.currentThread().getName() + " continue");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
