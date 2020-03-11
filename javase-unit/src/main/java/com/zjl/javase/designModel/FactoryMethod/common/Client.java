package com.zjl.javase.designModel.FactoryMethod.common;

import java.util.Random;

public class Client {
	 
     public static void main(String[] args) {
         int screenWidth = 100;//屏幕宽度
         System.out.println("游戏开始");
         Random random = new Random();//准备随机数
 
         int x = random.nextInt(screenWidth);//生成敌机横坐标随机数
         Enemy airplan = new Airplane(x, 0);//实例化飞机
        airplan.show();//显示飞机

        x = random.nextInt(screenWidth);//坦克同上
        Enemy tank = new Tank(x, 0);
        tank.show();

        /*输出结果：
            游戏开始
            飞机出现坐标：94,0
            飞机向玩家发起攻击……
            坦克出现坐标：89,0
            坦克向玩家发起攻击……
        */
    }
}
