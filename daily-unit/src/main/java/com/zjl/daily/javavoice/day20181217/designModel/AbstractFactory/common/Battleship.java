package com.zjl.daily.javavoice.day20181217.designModel.AbstractFactory.common;

public class Battleship extends Unit {// 巨型战舰
	 
     public Battleship(int x, int y) {
         super(25, 200, 500, x, y);
     }
 
     @Override
     public void show() {
         System.out.println("战舰出现在坐标：[" + x + "," + y + "]");
    }

    @Override
    public void attack() {
        System.out.println("战舰用激光炮打击，攻击力：" + attack);
    }
	
}
