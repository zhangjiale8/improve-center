package com.zjl.daily.javavoice.day20181217.designModel.FactoryMethod.simple;

import java.util.Random;

import com.zjl.daily.javavoice.day20181217.designModel.FactoryMethod.common.Airplane;
import com.zjl.daily.javavoice.day20181217.designModel.FactoryMethod.common.Enemy;
import com.zjl.daily.javavoice.day20181217.designModel.FactoryMethod.common.Tank;

public class SimpleFactory {
     private int screenWidth;
     private Random random;//随机数
 
     public SimpleFactory(int screenWidth) {
         this.screenWidth = screenWidth;
         this.random = new Random();
     }
 
    public Enemy create(String type){
        int x = random.nextInt(screenWidth);//生成敌人横坐标随机数
        Enemy enemy = null;
        switch (type) {
        case "Airplane":
            enemy = new Airplane(x, 0);//实例化飞机
            break;
        case "Tank":
            enemy = new Tank(x, 0);//实例化坦克
            break;
        }
        return enemy;
    }
	
}
