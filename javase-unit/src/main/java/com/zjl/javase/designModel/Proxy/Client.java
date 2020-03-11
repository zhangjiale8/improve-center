package com.zjl.javase.designModel.Proxy;

import java.lang.reflect.Proxy;

import com.zjl.javase.designModel.Proxy.common.Internet;
import com.zjl.javase.designModel.Proxy.common.Modem;

public class Client {
     public static void main(String[] args) {
 
         //访问外网（互联网）,生成猫代理。
         Internet internet = (Internet) Proxy.newProxyInstance(
                 Modem.class.getClassLoader(),
                 Modem.class.getInterfaces(), 
                 new KeywordFilter(new Modem()));
         internet.access("http://www.电影.com");
        internet.access("http://www.游戏.com");
        internet.access("http://www.学习.com");
        internet.access("http://www.工作.com");

        //访问内网（局域网），生成交换机代理。
        Intranet intranet = (Intranet) Proxy.newProxyInstance(
                Switch.class.getClassLoader(),
                Switch.class.getInterfaces(), 
                new KeywordFilter(new Switch()));
        intranet.fileAccess("\\192.68.1.2\\共享\\电影\\IronHuman.mp4");
        intranet.fileAccess("\\192.68.1.2\\共享\\游戏\\Hero.exe");
        intranet.fileAccess("\\192.68.1.4\\shared\\Java学习资料.zip");
        intranet.fileAccess("\\192.68.1.6\\Java知音\\设计模式是什么鬼.doc");

        /*
            开启关键字过滤模式...
            禁止访问：http://www.电影.com
            禁止访问：http://www.游戏.com
            正在访问：http://www.学习.com
            正在访问：http://www.工作.com
            开启关键字过滤模式...
            禁止访问：\192.68.1.2共享电影IronHuman.mp4
            禁止访问：\192.68.1.2共享游戏Hero.exe
            访问内网：\192.68.1.4sharedJava学习资料.zip
            访问内网：\192.68.1.6Java知音设计模式是什么鬼.doc

        */
    }
}
