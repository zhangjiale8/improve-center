package com.zjl.spring.chapter01.knight;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class KnightApp {
  public static void main(String[] args) throws Exception {
	  ClassPathXmlApplicationContext context = 
			  new ClassPathXmlApplicationContext("/knight/knight.xml"); 
	  
	  Knight knight = (Knight) context.getBean("knight");
	  knight.embarkOnQuest();
	  context.close();
	  
	  AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext(com.zjl.spring.chapter01.knight.KnightConfig.class);
	 /* Knight knight2 = (Knight) context2.getBean("knight");
	  knight2.embarkOnQuest();*/
	  context2.close();
  }
}