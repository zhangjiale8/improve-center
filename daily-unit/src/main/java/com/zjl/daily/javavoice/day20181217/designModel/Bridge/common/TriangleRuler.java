package com.zjl.daily.javavoice.day20181217.designModel.Bridge.common;

public class TriangleRuler implements Ruler {

  @Override
  public void regularize() {//尺子模板画出三角形
    System.out.println("△");
  }

}
