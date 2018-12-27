package com.zjl.daily.javavoice.day20181217.designModel.AbstractFactory.common;

public class Mammoth extends Unit {// 外星猛犸巨兽
	 
     public Mammoth(int x, int y) {
         super(20, 100, 400, x, y);
     }
 
     @Override
     public void show() {
         System.out.println("猛犸巨兽兵出现在坐标：[" + x + "," + y + "]");
    }

    @Override
    public void attack() {
        System.out.println("猛犸巨兽用獠牙顶，攻击力：" + attack);
    }
	
}
