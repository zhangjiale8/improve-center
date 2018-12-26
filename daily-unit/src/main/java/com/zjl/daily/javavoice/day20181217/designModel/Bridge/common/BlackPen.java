package com.zjl.daily.javavoice.day20181217.designModel.Bridge.common;

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
