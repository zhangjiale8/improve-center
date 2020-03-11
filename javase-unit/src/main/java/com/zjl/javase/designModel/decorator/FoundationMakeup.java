package com.zjl.javase.designModel.decorator;

import com.zjl.javase.designModel.decorator.common.Showable;

public class FoundationMakeup extends Decorator{
	 
     public FoundationMakeup(Showable showable) {
         super(showable);//调用化妆品父类注入
     }
 
     @Override
     public void show() {
         System.out.print("打粉底(");
        showable.show();
        System.out.print(")");
    }
}