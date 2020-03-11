package com.zjl.javase.designModel.Bridge.common;

public abstract class Pen {//画笔
	 
   protected Ruler ruler;//尺子的引用
 
   public Pen(Ruler ruler) {
     this.ruler = ruler;
   }
 
   public abstract void draw();//抽象方法
}
