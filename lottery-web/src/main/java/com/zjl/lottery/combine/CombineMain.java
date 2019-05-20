package com.zjl.lottery.combine;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Properties;

import com.zjl.lottery.combine.util.InitCombineParam;
import com.zjl.lottery.combine.vo.CombineGenerate;
import com.zjl.lottery.combine.vo.LotteryTypEnum;
import com.zjl.lottery.combine.vo.ScreenTypEnum;
import com.zjl.tools.ArrayTool;

public class CombineMain {
	public static void main(String[] args) {
		
	    try {
			LotteryTypEnum lotteryTyp = LotteryTypEnum.DOUBLE_BALL;
			ScreenTypEnum screenTypEnum = ScreenTypEnum.RED;
			Integer screenNum = 6;
			int[] otherArr = {1,2,3,4,5,6,7};
			//期数
			String periods = "056";
			CombineGenerate combineGenerate = InitCombineParam.init(lotteryTyp,screenTypEnum,screenNum,otherArr);
		    int size = combineGenerate.getRedloterryLsit().size();
		    System.out.println(size);
		    ArrayList<String> redloterryLsit = combineGenerate.getRedloterryLsit();
		    if(null != redloterryLsit && redloterryLsit.size() > 0){
		    	 File file = new File("D:" + File.separator + "demo" + File.separator + "test.txt");
		         if(!file.getParentFile().exists()){
	                file.getParentFile().mkdirs();
	            }
	            
	            //2：准备输出流
	            Writer out = new FileWriter(file);
	            for (int i = 0; i < redloterryLsit.size(); i++) {
	            	String temp = redloterryLsit.get(i);
	            	out.write(temp+System.getProperty("line.separator"));
				}
	            out.close();
		    }
	    } catch (IOException e) {
			e.printStackTrace();
		}
	    
	}

}
