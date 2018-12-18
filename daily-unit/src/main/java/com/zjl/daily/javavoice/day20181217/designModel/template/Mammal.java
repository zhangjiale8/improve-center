package com.zjl.daily.javavoice.day20181217.designModel.template;

public abstract class Mammal {
 	private boolean female;
    //既然是哺乳动物当然会喂奶了，但这里约束为只能母的喂奶
    protected final void feedMilk(){
         if(female){//如果是母的……
             System.out.println("喂奶");
         }else{//如果是公的……或者可以抛个异常出去。
             System.out.println("公的不会");
         }
    }

    //哺乳动物当然可以移动，但具体怎么移动还不知道。
    public abstract void move();
    
}
