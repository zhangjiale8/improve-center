package com.zjl.javase.designModel.iterator.common;

public class Client {
	     public static void main(String[] args) {
	         DrivingRecorder dr = new DrivingRecorder();
	         //假设记录了12条视频
	         for (int i = 0; i < 12; i++) {
	             dr.append("视频_" + i);
	         }
	         dr.display();
	         /*按原始顺序显示,视频0与1分别被10与11覆盖了。
	            0: 视频_10
	            1: 视频_11
	            2: 视频_2
	            3: 视频_3
	            4: 视频_4
	            5: 视频_5
	            6: 视频_6
	            7: 视频_7
	            8: 视频_8
	            9: 视频_9
	        */
	        dr.displayInOrder();
	        /*按顺序从新到旧显示
	            视频_11
	            视频_10
	            视频_9
	            视频_8
	            视频_7
	            视频_6
	            视频_5
	            视频_4
	            视频_3
	            视频_2
	        */
	    }
}
