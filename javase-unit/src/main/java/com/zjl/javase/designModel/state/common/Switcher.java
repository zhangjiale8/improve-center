package com.zjl.javase.designModel.state.common;

public class Switcher {
	//false代表关，true代表开
	private boolean state = false;//初始状态是关
 
     public void switchOn(){
         state = !state;
         System.out.println("OK...灯亮");
     }
 
    public void switchOff(){
        state = !state;
        System.out.println("OK...灯灭");
    }
}
