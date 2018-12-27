package com.zjl.daily.javavoice.day20181217.designModel.AbstractFactory.common;

public class AlienFactory implements AbstractFactory{
	 
     //外星虫族工厂坐标
     private int x;
     private int y;
 
     public AlienFactory(int x, int y) {
         this.x = x;
         this.y = y;
    }

    @Override
    public Unit createLowClass() {
        Unit unit = new Roach(x, y);
        System.out.println("制造蟑螂兵成功。");
        return unit;
    }

    @Override
    public Unit createMidClass() {
        Unit unit = new Spitter(x, y);
        System.out.println("制造毒液兵成功。");
        return unit;
    }

    @Override
    public Unit createHighClass() {
        Unit unit = new Mammoth(x, y);
        System.out.println("制造猛犸巨兽成功。");
        return unit;
    }
	
}
