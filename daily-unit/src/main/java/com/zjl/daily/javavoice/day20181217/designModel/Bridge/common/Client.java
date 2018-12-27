package com.zjl.daily.javavoice.day20181217.designModel.Bridge.common;

public class Client {
	 
     public static void main(String args[]) {
 
         //白色画笔对应的所有形状
         new WhitePen(new CircleRuler()).draw();
         new WhitePen(new SquareRuler()).draw();
         new WhitePen(new TriangleRuler()).draw();
 
        //黑色画笔对应的所有形状
        new BlackPen(new CircleRuler()).draw();
        new BlackPen(new SquareRuler()).draw();
        new BlackPen(new TriangleRuler()).draw();

        /*运行结果：
            白○
            白□
            白△
            黑○
            黑□
            黑△
        */
    }
	
}
