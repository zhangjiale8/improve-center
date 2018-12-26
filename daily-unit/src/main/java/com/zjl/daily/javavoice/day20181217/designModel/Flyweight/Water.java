package com.zjl.daily.javavoice.day20181217.designModel.Flyweight;

public class Water implements Drawable {
	 
     private String image;//河流图片材质
 
     public Water() {
         this.image = "河流";
         System.out.print("从磁盘加载[" + image + "]图片，耗时半秒。。。");
     }
 
    @Override
    public void draw(int x, int y) {
        System.out.println("在位置[" + x + ":" + y + "]上绘制图片：[" + image + "]");
    }
	
}