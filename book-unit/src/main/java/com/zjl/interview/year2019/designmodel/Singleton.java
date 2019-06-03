package com.zjl.interview.year2019.designmodel;

public class Singleton {
	private Singleton() {}
	
	private static class SingletonInstance {
		private static final Singleton INSTANCE = new Singleton();
	}
	
	public static Singleton getInatance() {
		return SingletonInstance.INSTANCE;
	}
}

