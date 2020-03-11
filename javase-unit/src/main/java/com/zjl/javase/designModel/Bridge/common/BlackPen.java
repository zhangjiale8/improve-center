package com.zjl.javase.designModel.Bridge.common;

public class BlackPen extends Pen {
	 
	   public BlackPen(Ruler ruler) {
	     super(ruler);
	   }
	 
	   @Override
	   public void draw() {
	       System.out.print("黑");
	      ruler.regularize();
	  }
	
}
