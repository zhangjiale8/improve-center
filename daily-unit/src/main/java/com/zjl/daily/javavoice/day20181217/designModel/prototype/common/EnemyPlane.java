package com.zjl.daily.javavoice.day20181217.designModel.prototype.common;

public class EnemyPlane {
	private int x;//敌机横坐标
    private int y = 0;//敌机纵坐标
 
    public EnemyPlane(int x) {//构造器
        this.x = x;
    }
 
   public int getX() {
       return x;
    }
 
    public int getY() {
        return y;
    }
 
    public void fly(){//让敌机飞
        y++;//每调用一次，敌机飞行时纵坐标＋1
    }
}
