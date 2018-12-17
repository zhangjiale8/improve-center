package com.zjl.daily.javavoice.day20181217.designModel.state.common;

public class Switcher2 {
	//false代表关，true代表开
     boolean state = false;//初始状态是关
 
     public void switchOn(){
         if(state == false){//当前是关状态
             state = true;
             System.out.println("OK...灯亮");
         }else{//当前是开状态
            System.out.println("WARN!!!通电状态无需再开");
        }
    }

    public void switchOff(){
        if(state == true){//当前是开状态
            state = false;
            System.out.println("OK...灯灭");
        }else{//当前是关状态
            System.out.println("WARN!!!断电状态无需再关");
        }
    }
}
