package com.zjl.javase.thread;

public class synchronizedTest {
	public static void main(String[] args) {
		class Demo {
			public synchronized void syncMethod() {
				for (int i = 0; i < 999999999; i++) {
					
				}
			}
			
			public void syncBlock() {
				synchronized(this) {
					for (int i = 0; i < 999999999; i++) {
						
					}
				}
			}
		}
		
		Demo demo = new Demo();
		long start,diff;
		start = System.currentTimeMillis();
		demo.syncMethod();   // 调用“synchronized方法块”
		diff = System.currentTimeMillis() -start; // 获取“时间差值”
		System.out.println(" syncMethod() : "+diff);
		
		start = System.currentTimeMillis();
		demo.syncBlock();  // 调用“synchronized方法块”
		diff = System.currentTimeMillis() -start; // 获取“时间差值”
		System.out.println(" syncBlock() : "+diff);
		
	}
}
