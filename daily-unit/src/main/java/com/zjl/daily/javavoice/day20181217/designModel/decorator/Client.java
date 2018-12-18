package com.zjl.daily.javavoice.day20181217.designModel.decorator;

import com.zjl.daily.javavoice.day20181217.designModel.decorator.common.Girl;
import com.zjl.daily.javavoice.day20181217.designModel.decorator.common.Showable;

public class Client {
    public static void main(String[] args) {
        //口红包裹粉底，再包裹女友。
        Showable madeupGirl = new Lipstick(new FoundationMakeup(new Girl()));
        madeupGirl.show();
        //运行结果：涂口红(打粉底(女孩的脸庞))
        
        /**
         * 实用案例 流
         */
        //new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));

    }
}
