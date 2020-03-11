package com.zjl.javase.designModel.Bridge.common;

public class TriangleRuler implements Ruler {

  public void regularize() {//尺子模板画出三角形
    System.out.println("△");
  }

}
