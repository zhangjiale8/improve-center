package com.zjl.daily.javavoice.day20181217.designModel.strategy.common;

public class Calculator {//违反设计模式原则的做法
    public int add(int a, int b){//加法
        return a + b;
    }
 
    public int sub(int a, int b){//减法
        return a - b;
    }
}