package com.zjl.javase.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockAndUnLock {
	static Lock lock = new ReentrantLock();//新建锁

    public static void main(String[] args) {

        new Thread("A"){
            public void run() {
                Thread.yield();//当前线程的让步，加快线程切换
                numPrint();

            };
        }.start();

        new Thread("B"){
            public void run() {
                Thread.yield();//当前线程的让步，加快线程切换
                numPrint();
            };
        }.start();

    }

    private static void numPrint(){
        lock.lock();
        try{
            for(int i=0;i<10;i++){
                Thread.sleep(100);
                System.out.println("当前线程"+Thread.currentThread().getName()+"："+i);
            }
        }catch(Exception e){

        }finally{
            lock.unlock();
        }
    }
}
