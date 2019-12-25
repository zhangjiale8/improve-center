package com.zjl.javase.thread;

public class LockTest {
	static class Something {
		public synchronized void isSyncA() {
			for(int i=0;i<5;i++){
                try {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName()+" : isSyncA " +i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
		}
		
		public synchronized void isSyncB() {
			for(int i=0;i<5;i++){
                try {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName()+" : isSyncB " +i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
		}
		
		public static synchronized void cSyncA() {
			for(int i=0;i<5;i++){
                try {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName()+" : cSyncA " +i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
		}
		
		public static synchronized void cSyncB() {
			for(int i=0;i<5;i++){
                try {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName()+" : cSyncB " +i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
		}	
		
	}
	
	Something x = new Something();
	Something y = new Something();
	
	private void test1() {
		Thread t11 = new Thread(new Runnable(){
            public void run() {
                x.isSyncA();    
              //  x.cSyncA();
            }
        },"t11");

        Thread t12 = new Thread(new Runnable(){
            public void run() {
             //   x.isSyncB();
             //   y.isSyncA();
             //   y.cSyncB();
                Something.cSyncA();
            }
        },"t12");

        t11.start();
        t12.start();
	}
	
	public static void main(String[] args) {
		LockTest lockTest1 = new LockTest();
        lockTest1.test1();
	}
	
	
}
