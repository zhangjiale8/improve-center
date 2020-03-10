package com.zjl.javase.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
	/**
     * @param args
     */
    public static void main(String[] args) {

        AtomicInteger integer = new AtomicInteger(123);
        System.out.println(integer);
        // 以原子方式设置当前值时
        integer.set(147);

        int expect = 147;
        int update = 300;
        // 如果当前值 == expect，则以原子方式将该值设置为update。成功返回true，否则返回false，并且不修改原值。
        integer.compareAndSet(expect, update);
        System.out.println(integer);

        //以原子方式将当前值加1，并返回加1前的值。等价于“num++”
        System.out.println("getAndIncrement的值："+integer.getAndIncrement());
        //以原子方式将当前值加1，并返回加1后的值。等价于“++num”
        System.out.println("incrementAndGet的值："+integer.incrementAndGet());
        //以原子方式将当前值减1，并返回减1前的值。等价于“num--”
        System.out.println("getAndDecrement的值为："+integer.getAndDecrement());
        //以原子方式将当前值减1，并返回减1后的值。等价于“--num”
        System.out.println("decrementAndGet的值为："+integer.decrementAndGet());
        //以原子方式将当前值加10，并返回加10后的值
        System.out.println("addAndGet的值为："+integer.addAndGet(10));
        //以原子方式将当前值加10，并返回加10前的值
        System.out.println("getAndAdd的值为："+integer.getAndAdd(10));
    }
    
}
