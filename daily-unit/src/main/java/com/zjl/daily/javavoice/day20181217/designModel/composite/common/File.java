package com.zjl.daily.javavoice.day20181217.designModel.composite.common;

public class File extends Node{
	 
     public File(String name) {
         super(name);
     }
 
     @Override
     protected void add(Node child) {
         System.out.println("不能添加子节点。");
    }
     
     @Override
     public void ls(int space){
         super.ls(space);
     }
}
