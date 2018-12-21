package com.zjl.daily.javavoice.day20181217.designModel.iterator;

import java.util.ArrayList;
import java.util.List;

public class Client {
     public static void main(String[] args) {
         DrivingRecorder dr = new DrivingRecorder();
         // 假设记录了12条视频
         for (int i = 0; i < 12; i++) {
             dr.append("视频_" + i);
         }
         //用户要获取交通事故视频，定义事故列表。
         List<String> accidents = new ArrayList<>();
        //用户拿到迭代器
        Iterator<String> it = dr.iterator();

        while (it.hasNext()) {//如果还有下一条则继续迭代
            String video = it.next();
            System.out.println(video);
            //用户翻看视频发现10和8可作为证据。
            if("视频_10".equals(video) || "视频_8".equals(video)){
                accidents.add(video);
            }
        }
        //拿到两个视频集accidents交给交警查看。
        System.out.println("事故证据：" + accidents);
        /*
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
        事故证据：[视频_10, 视频_8]
        */
    }
}
