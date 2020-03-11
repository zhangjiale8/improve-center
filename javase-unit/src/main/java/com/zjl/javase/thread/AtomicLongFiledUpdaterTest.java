package com.zjl.javase.thread;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

public class AtomicLongFiledUpdaterTest {
	/**
     * @param args
     */
    public static void main(String[] args) {


        //获取student的class对象
        Class cls = Student2.class;
         // 新建AtomicLongFieldUpdater对象，传递参数是“class对象”和“long类型在类中对应的名称”
        AtomicLongFieldUpdater atoLong = AtomicLongFieldUpdater.newUpdater(cls, "age");
        Student2 stu = new Student2(123456L);

        atoLong.compareAndSet(stu, 123456L, 1000);
        System.out.println("age= "+stu.age);

    }
}

class Student2{
	volatile long age;

	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}

	public Student2(long age) {
		super();
		this.age = age;
	}
	
}
