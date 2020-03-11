package com.zjl.javase.thread;

import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampedReferenceTest {
	/**
     * @param args
     */
    public static void main(String[] args) {


        final AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference(10,0);
        final int stamp = stampedReference.getStamp();
        final int reference = stampedReference.getReference();

        final AtomicMarkableReference<Integer> markableReference = new AtomicMarkableReference(10,true);
        final int getmarkAbleReference = markableReference.getReference();
        final boolean mark = markableReference.isMarked();

        System.out.println("stamp的值为："+stamp+"\n"+"reference的值为："+reference);
        System.out.println("mark的值为："+stamp+"\n"+"getmarkAbleReference的值为："+reference);

        Thread t1 = new Thread(new Runnable(){

            public void run() {
                boolean isUpdateSuccess = stampedReference.compareAndSet(reference, reference+10, stamp, stamp+1);
                System.out.println(Thread.currentThread().getName()+" isUpdateSuccess:"+isUpdateSuccess);

                boolean isMarkable = markableReference.compareAndSet(getmarkAbleReference, getmarkAbleReference+10, mark, false);
                System.out.println(Thread.currentThread().getName()+" isMarkable:"+isMarkable);
            }

        });

        Thread t2 = new Thread(new Runnable(){

            public void run() {
                boolean isUpdateSuccess = stampedReference.compareAndSet(reference, reference+10, stamp, stamp+1);
                System.out.println(Thread.currentThread().getName()+" isUpdateSuccess:"+isUpdateSuccess);

                boolean isMarkable = markableReference.compareAndSet(getmarkAbleReference, getmarkAbleReference+10, mark, false);
                System.out.println(Thread.currentThread().getName()+" isMarkable:"+isMarkable);
            }

        });

        try {
            t1.start();
            t1.join();
            t2.start();
            t2.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("stamp的值为："+stampedReference.getStamp()+"\n"+"reference的值为："+stampedReference.getReference());
        System.out.println("mark的值为："+ markableReference.isMarked()+"\n"+"getmarkAbleReference的值为："+markableReference.getReference());
        
    }

}
