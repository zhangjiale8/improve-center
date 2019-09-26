package com.zjl.lottery.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.zjl.lottery.combine.util.CombineUtil;
import com.zjl.lottery.util.ListTxtUtil;
import com.zjl.tools.ArrayTool;

public class Test2 {
	public static void main(String[] args) {
		ArrayList<String> screenlist = new ArrayList<String>();
		try {
			String filename= "twoscreen";
			String filepath = "E:" + File.separator + "screen" + File.separator  +filename+".txt";
			File file = new File(filepath);
			if (null != file && file.exists()) {

				BufferedReader br = new BufferedReader(new FileReader(file));
				String line = null;
				int [] screenArr = {3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,22,23,25,26,27,29,30,31};
				while ((StringUtils.isNotEmpty(line = br.readLine()))) {// 使用readLine方法，一次读一行
					String[] lineArr = line.split("\\|");
					String red = lineArr[0];
					String[] redArr = red.split(",");
					int nums = 0;
					for (int i = 0; i < redArr.length; i++) {
						int redtemp = Integer.parseInt(redArr[i]);
						boolean flg = Arrays.asList(screenArr).contains(redtemp);
						if(flg) {
							nums++;
						}
					}
					if(nums != 6) {
						screenlist.add(red);
					}
				}
				br.close();
				
			}
			ListTxtUtil.createScreenTxt(screenlist, filename+"@@");

		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}
