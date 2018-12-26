package com.zjl.daily.javavoice.day20181217.designModel.Bridge.common;

public class CircleRuler implements Ruler {

  @Override
  public void regularize() {//尺子模板画出圆形
    System.out.println("○");
  }

}
