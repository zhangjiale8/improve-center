package com.zjl.daily.javavoice.day20181203.lomok.test;

import com.zjl.daily.javavoice.day20181203.lomok.LomokBean;

public class Test {
	public static void main(String[] args) {
		LomokBean lomok = new LomokBean();
		lomok.setId("1");
		lomok.setName("张三");
		lomok.noNull("");
		System.out.println(lomok.toString());
		LomokBean lomok2 = new LomokBean("李四", "2");
		System.out.println(lomok2.toString());
	}
}
