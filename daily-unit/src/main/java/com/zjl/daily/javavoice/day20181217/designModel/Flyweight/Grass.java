package com.zjl.daily.javavoice.day20181217.designModel.Flyweight;

public class Grass implements Drawable {
	 
     private String image;//草坪图片材质
 
     public Grass() {
         this.image = "草坪";
         System.out.print("从磁盘加载[" + image + "]图片，耗时半秒。。。");
     }
 
    @Override
    public void draw(int x, int y) {
        System.out.println("在位置[" + x + ":" + y + "]上绘制图片：[" + image + "]");
    }
	
}