package com.zjl.javase.designModel.observer;

public abstract class Buyer {
     protected String name;
     protected Shop shop;
 
     public Buyer(String name, Shop shop) {
         this.name = name;
         this.shop = shop;
 //        shop.register(this);
     }

    public abstract void inform();
	
}
