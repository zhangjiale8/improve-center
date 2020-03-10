package com.zjl.javase.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool2 {
	/**
     * @param args
     */
    public static void main(String[] args) {

        class MyRunnable implements Runnable{
            private int a = 5;
            public void run() {
                synchronized(this){
                    for(int i=0;i<10;i++){
                        if(this.a>0){
                            System.out.println(Thread.currentThread().getName()+" a的值:"+this.a--);
                        }

                    }
                }
            }

        }
        ExecutorService exec = Executors.newCachedThreadPool();
        MyRunnable run1 = new MyRunnable();
        for(int i=0;i<5;i++)
            exec.execute(run1);
        exec.shutdown();

    }
}
