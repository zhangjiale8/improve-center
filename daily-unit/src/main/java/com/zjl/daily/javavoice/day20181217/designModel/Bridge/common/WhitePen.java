package com.zjl.daily.javavoice.day20181217.designModel.Bridge.common;

public class WhitePen extends Pen {
	 
   public WhitePen(Ruler ruler) {
     super(ruler);
   }
 
   @Override
   public void draw() {
       System.out.print("白");
      ruler.regularize();
  }
	
}
