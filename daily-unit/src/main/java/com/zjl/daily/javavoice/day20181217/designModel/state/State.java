package com.zjl.daily.javavoice.day20181217.designModel.state;

public interface State {
	public void switchOn(Switcher switcher);//开
    public void switchOff(Switcher switcher);//关
}
