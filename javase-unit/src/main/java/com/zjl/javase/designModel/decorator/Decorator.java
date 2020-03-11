package com.zjl.javase.designModel.decorator;

import com.zjl.javase.designModel.decorator.common.Showable;

public abstract class Decorator implements Showable{
	 
	     protected Showable showable;
	 
	     public Decorator(Showable showable) {
	         this.showable = showable;
	     }
	 
	     @Override
	    public void show() {
	        showable.show();//直接调用不做加任何粉饰。
	    }
	
}
