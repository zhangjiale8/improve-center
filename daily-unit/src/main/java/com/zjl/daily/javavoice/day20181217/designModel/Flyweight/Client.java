package com.zjl.daily.javavoice.day20181217.designModel.Flyweight;

public class Client {
     public static void main(String[] args) {
         //先实例化图件工厂
         Factory factory = new Factory();
         //以第一行为例
         factory.getDrawable("河流").draw(10, 10);
         factory.getDrawable("河流").draw(10, 20);
         factory.getDrawable("石路").draw(10, 30);
         factory.getDrawable("草坪").draw(10, 40);
        factory.getDrawable("草坪").draw(10, 50);
        factory.getDrawable("草坪").draw(10, 60);
        factory.getDrawable("草坪").draw(10, 70);
        factory.getDrawable("草坪").draw(10, 80);
        /*运行结果
        从磁盘加载[河流]图片，耗时半秒。。。在位置[10:10]上绘制图片：[河流]
        在位置[10:20]上绘制图片：[河流]
        从磁盘加载[石路]图片，耗时半秒。。。在位置[10:30]上绘制图片：[石路]
        从磁盘加载[草坪]图片，耗时半秒。。。在位置[10:40]上绘制图片：[草坪]
        在位置[10:50]上绘制图片：[草坪]
        在位置[10:60]上绘制图片：[草坪]
        在位置[10:70]上绘制图片：[草坪]
        在位置[10:80]上绘制图片：[草坪]
        */
    }
}
