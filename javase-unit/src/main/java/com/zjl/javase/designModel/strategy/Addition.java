package com.zjl.javase.designModel.strategy;

public class Addition implements Strategy{//实现算法接口
	 
    public int calculate(int a, int b) {//加数与被加数
        return a + b;//这里我们做加法运算
    }
 
}
