package com.zjl.daily.javavoice.day20181217.designModel.Bridge.common;

public class SquareRuler implements Ruler {

  @Override
  public void regularize() {//尺子模板画出正方形
    System.out.println("□");
  }

}
