package com.zjl.daily.javavoice.day20181217.designModel.template.common;

public class GPS implements CigarLighterInterface {
    //导航的实现
    @Override
    public void electrifyDC16V() {
        System.out.println("连接卫星");
        System.out.println("定位。。。");
    }

}