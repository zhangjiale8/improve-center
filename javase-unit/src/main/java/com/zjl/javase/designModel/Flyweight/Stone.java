package com.zjl.javase.designModel.Flyweight;

public class Stone implements Drawable {
	 
     private String image;//石路图片材质
 
     public Stone() {
         this.image = "石路";
         System.out.print("从磁盘加载[" + image + "]图片，耗时半秒。。。");
     }
 
    @Override
    public void draw(int x, int y) {
        System.out.println("在位置[" + x + ":" + y + "]上绘制图片：[" + image + "]");
    }
	
}
