package com.zjl.javase.thread;

public class SyncAndSync {
	public static void main(String[] args) {
		class Count{
			// 含有synchronized同步块的方法
			public void sync() {
				synchronized(this) {
					for (int i = 0; i < 5; i++) {
						try {
							Thread.sleep(100);
							System.out.println(Thread.currentThread().getName() + " sync loop " +i);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
				}
				
			}
            // 也包含synchronized同步块的方法
			public void sync2() {
				synchronized(this) {
					
					for (int i = 0; i < 5; i++) {
						try {
							Thread.sleep(100);
							System.out.println(Thread.currentThread().getName() + " sync2 loop " +i);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
				}
			}
		}
		
		 final Count count = new Count();
	     // 新建t1, t1会调用“count对象”的synMethod()方法
		 Thread t1 = new Thread(new Runnable() {
			
			public void run() {
				
				count.sync();
			}
		},"t1");
		 // 新建t2, t2会调用“count对象”的Syn2Method()方法
		 Thread t2 = new Thread(new Runnable() {
				
				public void run() {
					count.sync2();
					
				}
			},"t2");
		 
		 t1.start();
		 t2.start();

	}
}
