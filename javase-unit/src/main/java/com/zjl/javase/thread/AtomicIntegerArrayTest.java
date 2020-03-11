package com.zjl.javase.thread;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayTest {
	static AtomicIntegerArray integerArray = new AtomicIntegerArray(10);

    public static class AddThread implements Runnable{

        int j = 0;

        public void run() {
            for(int i=0;i<10000;i++){
                integerArray.getAndIncrement(i%integerArray.length());
            }

        }

    }

    public static void main(String[] args) {

        Thread[] ts = new Thread[10];
        for(int i=0;i<10;i++){
            ts[i] = new Thread(new AddThread());
        }

        for(int i=0;i<10;i++){
            ts[i].start();
        }
        for(int i=0;i<10;i++){
            try {
                ts[i].join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        System.out.println(integerArray);
    }

}
