package com.zjl.javase.designModel.Flyweight;

public class House implements Drawable {
	 
     private String image;//房子图片材质
 
     public House() {
         this.image = "房子";
         System.out.print("从磁盘加载[" + image + "]图片，耗时一秒。。。");
     }
 
    @Override
    public void draw(int x, int y) {
        System.out.println("将图层切到最上层。。。");//房子盖在地上，所以切换到顶层图层。
        System.out.println("在位置[" + x + ":" + y + "]上绘制图片：[" + image + "]");
    }
	
}
