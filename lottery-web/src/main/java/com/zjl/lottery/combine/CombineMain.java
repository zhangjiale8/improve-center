package com.zjl.lottery.combine;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.zjl.lottery.combine.vo.CombineGenerate;
import com.zjl.lottery.combine.vo.LotteryTypEnum;
import com.zjl.lottery.combine.vo.ScreenTypEnum;
import com.zjl.tools.ArrayTool;

public class CombineMain {
	public static void main(String[] args) {
		
	    try {
	    	Properties properties = new Properties();
			LotteryTypEnum lotteryTyp = LotteryTypEnum.DOUBLE_BALL;
		    // 使用ClassLoader加载properties配置文件生成对应的输入流
		    InputStream in = null;
		    if(in == null ){
		    	if(lotteryTyp == LotteryTypEnum.DOUBLE_BALL){
				    in = CombineMain.class.getClassLoader().getResourceAsStream("properties/lottery/1.properties");
		    	}else if(lotteryTyp == LotteryTypEnum.GREAT_LOTTO){
		    		in = CombineMain.class.getClassLoader().getResourceAsStream("properties/lottery/2.properties");
		    	}

		    }
		    // 使用properties对象加载输入流
			properties.load(in);
			//获取key对应的value值
			LotteryTypEnum lotterytyp = LotteryTypEnum.getEnumByKey(properties.getProperty("lottery.lotterytyp"));
			int index = 0;
		    String ticketpath = properties.getProperty("lottery.ticketpath");
		    String redStr = properties.getProperty("lottery.redarr");
		    int[] redArr = Str2IntArr(redStr);
		    int redtotal = Integer.valueOf(properties.getProperty("lottery.redtotal"));
		    int redscreennum = Integer.valueOf(properties.getProperty("lottery.redscreennum"));
		    String blueStr = properties.getProperty("lottery.bluearr");
		    int[] blueArr = Str2IntArr(blueStr);
		    int bluetotal = Integer.valueOf(properties.getProperty("lottery.bluetotal"));
		    int bluescreennum = Integer.valueOf(properties.getProperty("lottery.bluescreennum"));
		    CombineGenerate combineGenerate = new CombineGenerate(ticketpath, index, redArr, redtotal, redscreennum, blueArr, bluetotal, bluescreennum, lotterytyp, ScreenTypEnum.RED);
		    combineGenerate.redgenerate();
		    int size = combineGenerate.getRedloterryLsit().size();
		    System.out.println(size);
	    } catch (IOException e) {
			e.printStackTrace();
		}
	    
	}

	private static int[] Str2IntArr(String str) {
		str = str.replaceAll("，", ",");
		String [] arr = str.split(",");
		return ArrayTool.strArr2InArr(arr);
	}
}
