package com.zjl.daily.javavoice.day20181217.designModel.singleton.eagr;

public class God {
	/**
	 * 私有化构造方法，防止外部创造实例
	 */
	private God(){
		
	}
	/**
	 * 自有永有的神单例
	 */
	 private static final God god = new God();
	 /**
	  * 请神方法公开化
	  * @return
	  */
	 public static God getInstance(){
	        return god;
	 }
	 
}
