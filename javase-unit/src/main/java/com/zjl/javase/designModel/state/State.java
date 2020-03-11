package com.zjl.javase.designModel.state;

public interface State {
	public void switchOn(Switcher switcher);//开
    public void switchOff(Switcher switcher);//关
}
