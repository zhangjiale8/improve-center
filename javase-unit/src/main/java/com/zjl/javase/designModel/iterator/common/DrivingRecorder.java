package com.zjl.javase.designModel.iterator.common;

public class DrivingRecorder {
	     private int index = -1;// 当前记录位置
	     private String[] records = new String[10];// 假设只能记录10条视频
	 
	     public void append(String record) {
	         if (index == 9) {// 循环覆盖
	             index = 0;
	         } else {
	             index++;
	        }
	        records[index] = record;
	    }
	
	    public void display() {// 循环数组并显示所有10条记录
	        for (int i = 0; i < 10; i++) {
	            System.out.println(i + ": " + records[i]);
	        }
	    }
	
	    public void displayInOrder() {//按顺序从新到旧显示10条记录
	        for (int i = index, loopCount = 0; loopCount < 10; i = i == 0 ? i = 9 : i - 1, loopCount++) {
	            System.out.println(records[i]);
	        }
	    }
}
