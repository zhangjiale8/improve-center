package com.zjl.javase.designModel.AbstractFactory.common;

public class HumanFactory implements AbstractFactory{
	 
     //人族工厂坐标
     private int x;
     private int y;
 
     public HumanFactory(int x, int y) {
         this.x = x;
         this.y = y;
    }

    public Unit createLowClass() {
        Unit unit = new Marine(x, y);
        System.out.println("制造海军陆战队员成功。");
        return unit;
    }

    public Unit createMidClass() {
        Unit unit = new Tank(x, y);
        System.out.println("制造变形坦克成功。");
        return unit;
    }

    public Unit createHighClass() {
        Unit unit = new Battleship(x, y);
        System.out.println("制造巨型战舰成功。");
        return unit;
    }
	
}
