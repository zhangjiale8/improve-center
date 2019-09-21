package com.zjl.lottery.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.zjl.lottery.combine.util.CombineUtil;
import com.zjl.lottery.util.ListTxtUtil;
import com.zjl.tools.ArrayTool;

public class Test {
	public static void main(String[] args) {
		ArrayList<String> screenlist = new ArrayList<String>();
		try {
			String filename= "com";
			String filepath = "E:" + File.separator + "screen" + File.separator +"history"+ File.separator +filename+".txt";
			File file = new File(filepath);
			if (null != file && file.exists()) {

				BufferedReader br = new BufferedReader(new FileReader(file));
				String line = null;
				while ((StringUtils.isNotEmpty(line = br.readLine()))) {// 使用readLine方法，一次读一行
					String[] lineArr = line.split(",");
					//String time = lineArr[0];
					//String redStr = lineArr[2];
					//String temp = time+" 20:30:00@"+redStr;
					String temp = lineArr[0]+","+lineArr[1]+","+lineArr[2]+","+lineArr[3]+","+lineArr[4]+"|"+lineArr[5]+","+lineArr[6];
					screenlist.add(temp);
				}
				br.close();
				
			}
			ListTxtUtil.createScreenTxt(screenlist, filename+"@@");

		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}
