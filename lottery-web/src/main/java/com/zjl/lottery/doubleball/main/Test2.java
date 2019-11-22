package com.zjl.lottery.doubleball.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.zjl.lottery.doubleball.util.ListTxtUtil;
import com.zjl.lottery.util.CombineUtil;
import com.zjl.tools.ArrayTool;

public class Test2 {
	public static void main(String[] args) {
		ArrayList<String> screenlist = new ArrayList<String>();
		try {
			String filename= "historyscreen001002003003003003003003003003003003003003003";
			String filepath = "E:" + File.separator + "screen" + File.separator  +filename+".txt";
			File file = new File(filepath);
			if (null != file && file.exists()) {

				BufferedReader br = new BufferedReader(new FileReader(file));
				String line = null;
				Integer [] screenArr = {3,4,5,6,10,11,14,20,21,23,25,27,28,30};
				while ((StringUtils.isNotEmpty(line = br.readLine()))) {// 使用readLine方法，一次读一行
					String[] lineArr = line.split("\\|");
					String red = lineArr[0];
					String[] redArr = red.split(",");
					int nums = 0;
					for (int i = 0; i < redArr.length; i++) {
						Integer redtemp = Integer.parseInt(redArr[i]);
						boolean flg = Arrays.asList(screenArr).contains(redtemp);
						if(flg) {
							nums++;
						}
					}
					if(nums >1 && nums <5) {
						screenlist.add(red);
					}
				}
				br.close();
				
			}
			ListTxtUtil.createScreenTxt(screenlist, filename+"003");

		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}
