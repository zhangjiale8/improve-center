package com.zjl.daily.javavoice.day20181217.designModel.decorator;

import com.zjl.daily.javavoice.day20181217.designModel.decorator.common.Showable;

public class Lipstick extends Decorator{
	 
     public Lipstick(Showable showable) {
         super(showable);
     }
 
     @Override
     public void show() {
         System.out.print("涂口红(");
        showable.show();
        System.out.print(")");
    }
}
