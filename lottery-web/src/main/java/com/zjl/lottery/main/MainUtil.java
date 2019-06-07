package com.zjl.lottery.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.zjl.lottery.combine.util.CombineUtil;
import com.zjl.lottery.db.util.JDBCPatchUtil;
import com.zjl.tools.ArrayTool;

public class MainUtil {
	/**
	 * 复试数据过滤
	 */
	public static void compoundScreen() {
		
		
	}

	public static void historyScreen() {
		try {
			ArrayList<String> combineList = JDBCPatchUtil.getCombineList();
			ArrayList<String> historyList = JDBCPatchUtil.getHistoryList();
			ArrayList<String> resultList = JDBCPatchUtil.getHistoryList();
			for (String combineparam : combineList) {
				String[] combineparamArr = combineparam.split(",");
				int numsMax = 0;
				for (String history : historyList) {
					String[] historyArr = history.split(",");
					int nums = 0;
					for (int i = 0; i < combineparamArr.length; i++) {
						boolean flg = ArrayTool.isContains(combineparamArr[i], historyArr);
						if(flg){
							nums ++;
						}
					}
					if(nums > numsMax){
						numsMax = nums;
					}
				}
				if(numsMax < 5){
					resultList.add(combineparam);
				}
			}
			
			if(null != resultList && resultList.size() > 0){
				File file = new File("E:" + File.separator + "screen" + File.separator + "result.txt");
		         if(!file.getParentFile().exists()){
	               file.getParentFile().mkdirs();
	           }
	           
	           //2：准备输出流
	           Writer out = new FileWriter(file);
	           for (int i = 0; i < resultList.size(); i++) {
		           	String temp = resultList.get(i);
		            out.write(temp+System.getProperty("line.separator"));
	           }
	           out.close();
	           JDBCPatchUtil.emptyScreenTemp();
	           JDBCPatchUtil.insertScreenTempPatch(resultList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
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
	/**
	 * 
	 * @param filePath 需要过滤的文件的路径
	 * @param paramArr 过滤依据的数据
	 * @param screenNum 过滤数
	 * @param maxNum 最大数
	 * @param savePath 
	 */
	public static void screenCombinebydata(String filePath, int[] paramArr, int screenNum, int maxNum, String saveFileName) {
		ArrayList<String> combineList = getCombineList(filePath);
		ArrayList<String> screenList = CombineUtil.getScreenList(paramArr,screenNum);
		ArrayList<String> resultList = new ArrayList<String>();
		for (String combineparam : combineList) {
			String [] combineparamArr = combineparam.split(",");
			int maxsame= 0;
			for (String screenparam : screenList) {
				String [] screenparamArr = screenparam.split(",");
				int nums = 0;
				for (int i = 0; i < combineparamArr.length; i++) {
					boolean flg = ArrayTool.isContains(combineparamArr[i], screenparamArr);
					if(flg){
						nums ++;
					}
				}
				if(nums > maxsame){
					maxsame = nums;
				}
			}
			
			if(maxsame < maxNum){
				resultList.add(combineparam);
			}
		}
		
		if(null != resultList && resultList.size() > 0){
			MainUtil.createScreenTxt(resultList,saveFileName);
		}
	}
	/**
	 * 
	 * @param filePath
	 * @return
	 */
	public static ArrayList<String> getCombineList(String filePath) {
		ArrayList<String> list = new ArrayList<String>();
		if(StringUtils.isNotEmpty(filePath)){
			try {
				File file = new File(filePath);
				if(null != file && file.exists()) {

					BufferedReader br = new BufferedReader(new FileReader(file));
					String line = null;
					while((StringUtils.isNotEmpty(line = br.readLine()))){//使用readLine方法，一次读一行
						list.add(line);
		            }
		            br.close();
				
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	


}
