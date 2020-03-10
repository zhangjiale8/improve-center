package com.zjl.javase.thread;

import java.util.concurrent.atomic.AtomicBoolean;

public class atomticTest {
	/**
     * @param args
     */
    public static void main(String[] args) {

        AtomicBoolean atomicBoolean = new AtomicBoolean();

        System.out.println("atomicBoolean默认值为:"+atomicBoolean.get());

        atomicBoolean.set(true);
        System.out.println("atomicBoolean set设置值为："+atomicBoolean.get());

        //以原子方式设置为给定值，并返回以前的值
        Boolean oldValue = atomicBoolean.getAndSet(true);
        System.out.println("getAndSet返回以前的值为："+oldValue);
        System.out.println("atomicBoolean现在的值为："+atomicBoolean.get());

        boolean expectedValue = false;
        boolean newValue = true;

        boolean value = atomicBoolean.compareAndSet(expectedValue, newValue);
        System.out.println("compareAndSet后返回的值："+value);
        System.out.println("atomicBoolean现在的值为："+atomicBoolean.get());
    }

}
