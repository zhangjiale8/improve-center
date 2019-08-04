package com.zjl.lottery.db.util;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

public class ListTxtUtil {
	/**
	 * 创建过滤后文件
	 * @param screenlist
	 * @param fileName
	 */
	public static void createScreenTxt(ArrayList<String> screenlist, String fileName) {
		if(null != screenlist && screenlist.size() > 0 && StringUtils.isNotEmpty(fileName)){
			try {
				File file = new File("E:" + File.separator + "screen" + File.separator +fileName+ ".txt");
		         if(!file.getParentFile().exists()){
	               file.getParentFile().mkdirs();
	           }
	           
	           //2：准备输出流
	           Writer out = new FileWriter(file);
	           for (int i = 0; i < screenlist.size(); i++) {
		           	String temp = screenlist.get(i);
		            out.write(temp+System.getProperty("line.separator"));
	           }
	           out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
