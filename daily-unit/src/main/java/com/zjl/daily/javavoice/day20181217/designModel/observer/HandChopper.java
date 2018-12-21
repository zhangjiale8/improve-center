package com.zjl.daily.javavoice.day20181217.designModel.observer;

public class HandChopper extends Buyer {
	 
	     public HandChopper(String name, Shop shop) {
	         super(name, shop);
	     }
	 
	     @Override
	     public void inform() {
	         System.out.print(name);
	        String product = shop.getProduct();
	        System.out.println("购买：" + product);
	    }
}
