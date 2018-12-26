package com.zjl.daily.javavoice.day20181217.designModel.Proxy.common;

public class Modem implements Internet {//调制解调器

    @Override
    public void access(String url){//实现互联网访问接口
        System.out.println("正在访问：" + url);
    }
}
