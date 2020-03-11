package com.zjl.javase.designModel.decorator;

import com.zjl.javase.designModel.decorator.common.Showable;

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
