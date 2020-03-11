package com.zjl.javase.designModel.strategy;

public class Subtraction implements Strategy{//实现算法接口
	 
    public int calculate(int a, int b) {//减数与被减数
        return a - b;//这里我们做减法运算
    }
 
}
