package com.zjl.daily.javavoice.day20181217.designModel.FactoryMethod;

public class Client {
	 
     public static void main(String[] args) {
         int screenWidth = 100;
         System.out.println("游戏开始");
         Factory factory = new RandomFactory();
         for (int i = 0; i < 10; i++) {
             factory.create(screenWidth).show();
         }
        System.out.println("抵达关底");
        factory = new BossFactory();
        factory.create(screenWidth).show();

        /*
            游戏开始
            飞机出现坐标：27,0
            飞机向玩家发起攻击……
            坦克出现坐标：40,0
            坦克向玩家发起攻击……
            飞机出现坐标：30,0
            飞机向玩家发起攻击……
            坦克出现坐标：53,0
            坦克向玩家发起攻击……
            坦克出现坐标：19,0
            坦克向玩家发起攻击……
            飞机出现坐标：18,0
            飞机向玩家发起攻击……
            坦克出现坐标：27,0
            坦克向玩家发起攻击……
            飞机出现坐标：89,0
            飞机向玩家发起攻击……
            飞机出现坐标：24,0
           飞机向玩家发起攻击……
            飞机出现坐标：31,0
            飞机向玩家发起攻击……
           抵达关底
            Boss出现坐标：50,0
            Boss向玩家发起攻击……
        */
    }
	
}
