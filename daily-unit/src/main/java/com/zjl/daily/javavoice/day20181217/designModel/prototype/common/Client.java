package com.zjl.daily.javavoice.day20181217.designModel.prototype.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Client {
	public static void main(String[] args) {
        List<EnemyPlane> enemyPlanes = new ArrayList<EnemyPlane>();

        for (int i = 0; i < 50; i++) {
            //此处随机位置产生敌机
            EnemyPlane ep = new EnemyPlane(new Random().nextInt(200));
            enemyPlanes.add(ep);
        }

   }
}
