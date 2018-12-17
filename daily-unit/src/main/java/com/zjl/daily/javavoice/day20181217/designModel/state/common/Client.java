package com.zjl.daily.javavoice.day20181217.designModel.state.common;

public class Client {
	 public static void main(String[] args) {
		    Switcher2 s = new Switcher2();
		    s.switchOff();//WARN!!!断电状态无需再关
		    s.switchOn();//OK...灯亮
		    s.switchOff();//OK...灯灭
		    s.switchOn();//OK...灯亮
		    s.switchOn();//WARN!!!通电状态无需再开
	  }
}
