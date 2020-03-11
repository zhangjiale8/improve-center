package com.zjl.javase.designModel.template.common;

public class CigarLighter implements CigarLighterInterface {
     //点烟器的实现
     public void electrifyDC16V() {
         int time = 1000;
         while(--time>0){
             System.out.println("加热电炉丝");
         }
         System.out.println("点烟器弹出");
    }
	
}
