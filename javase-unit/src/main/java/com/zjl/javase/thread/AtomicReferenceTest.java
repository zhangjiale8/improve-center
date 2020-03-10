package com.zjl.javase.thread;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {
	public static void main(String[] args) {


        Student stu1 = new Student(123);
        Student stu2 = new Student(456);
        Student stu3 = new Student(789);

        AtomicReference reference = new AtomicReference(stu1);

        reference.compareAndSet(stu2, stu3);

        System.out.println(((Student) reference.get()).getAge());

        //创建泛型AtomicReference
        AtomicReference<String> refer = new AtomicReference("atmoicReference about generic");
        String str = refer.get();
        System.out.println(str);

    }
}

class Student{
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Student(int age) {
		super();
		this.age = age;
	}
	
}