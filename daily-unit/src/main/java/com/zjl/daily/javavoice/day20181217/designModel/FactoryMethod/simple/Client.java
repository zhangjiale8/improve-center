package com.zjl.daily.javavoice.day20181217.designModel.FactoryMethod.simple;

public class Client {
	 
     public static void main(String[] args) {
         System.out.println("游戏开始");
         SimpleFactory factory = new SimpleFactory(100);
         factory.create("Airplane").show();
         factory.create("Tank").show();
     }
	 
}
