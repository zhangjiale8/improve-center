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
			int[] otherArr = {1,2,3,5,6,11,13,14,15,16,18,19,20,21,22,23,24,25,27,28,29,30,31,33};
			//期数
			String periods = "059";
			CombineGenerate combineGenerate = InitCombineParam.init(lotteryTyp,screenTypEnum,screenNum,otherArr,periods);
			int maxSame = 4;
			InitCombineParam.screenRedTxt(combineGenerate,maxSame);
		   
	    } catch (Exception e) {
			e.printStackTrace();
		}
	    
	}

	

}
