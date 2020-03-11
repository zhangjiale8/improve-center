package com.zjl.javase.designModel.ChainofResponsibility;

public class CEO extends Approver {
	 
     public CEO(String name) {
         super(name);
     }
 
     @Override
     public void approve(int amount) {
         if (amount <= 10000) {
            System.out.println("审批通过。【CEO：" + name + "】");
        } else {
            System.out.println("无权审批，升级驳回申请。【CEO：" + name + "】");
        }
    }
	
}
