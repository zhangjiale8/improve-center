package com.zjl.spring.chapter01.knight;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class KnightApp {
  public static void main(String[] args) throws Exception {
	  ClassPathXmlApplicationContext context = 
			  new ClassPathXmlApplicationContext("/knight/knight.xml"); 
	  
	  Knight knight = (Knight) context.getBean("knight");
	  knight.embarkOnQuest();
	  context.close();
  }
}