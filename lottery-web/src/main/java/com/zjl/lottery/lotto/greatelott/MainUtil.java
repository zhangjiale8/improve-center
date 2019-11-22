package com.zjl.lottery.lotto.greatelott;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.zjl.lottery.doubleball.mutitest.LotteryHaveNoMaster;
import com.zjl.lottery.util.CombineUtil;
import com.zjl.lottery.util.JDBCPatchUtil;
import com.zjl.tools.ArrayTool;

public class MainUtil {
	
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
	/**
	 * @param screenNum 
	 * 多组数据筛选法
	 * @Title: tenParamArrScreen   
	 * @Description:多组数据筛选法
	 * 时间复杂度： 
	 * 空间复杂度： 
	 * @param: @param list      
	 * @return: void      
	 * @throws
	 */
	public static Map<String, Integer> tenParamArrScreen(ArrayList<int[]> list, int screenNum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int[] paramArr : list) {
			ArrayList<String> screenList = CombineUtil.getScreenList(paramArr,screenNum);
			if(null != screenList && screenList.size() > 0) {
				for (int i = 0; i < screenList.size(); i++) {
					String combine = screenList.get(i);
					if(StringUtils.isNotEmpty(combine)) {
						int count = (null == map.get(combine)) ? 0 : map.get(combine) + 1;
						map.put(combine, count);
					}
					
				}
			}
			
		}
		ArrayList<String> screenlist = new ArrayList<String>();
		for (Entry<String, Integer> entry : map.entrySet()) {
			int count = entry.getValue();
			if(count < 3) {
				screenlist.add(entry.getKey());
			}
		
		}
		
		createScreenTxt(screenlist, "tenarrscreen");
		
		return map;
		
	}

	/**
	 * 三连过滤
	 * @param map
	 * @return
	 */
	public static Map<String, Integer> screenThree(Map<String, Integer> map) {
		Map<String, Integer> screenmap = new HashMap<String, Integer>();
		String path = "";
		path = "data/greatelott/threecontinue.txt";
		URL url = LotteryHaveNoMaster.class.getClassLoader().getResource(path);
		File file = new File(url.getFile());
		if(null != file && file.exists()) {
		 try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line = null;
				while((StringUtils.isNotEmpty(line = br.readLine()))){//使用readLine方法，一次读一行
	                Pattern p = Pattern.compile("\\s*|\t|\r|\n");
	                Matcher m = p.matcher(line);
	                String temprp = m.replaceAll("");
	                String[] redArr = temprp.split(",");
        			int[] paramArr = ArrayTool.strArr2InArr(redArr);
        			ArrayList<String> tempList = CombineUtil.getScreenList(paramArr,3);
        			for (Entry<String, Integer> entry : map.entrySet()) {
        				String combine = entry.getKey();
        				String [] combineArr = combine.split(",");
        				for (String temp : tempList) {
        					String [] tempArr = temp.split(",");
        					int nums = 0;
                        	for (int i = 0; i < tempArr.length; i++) {
                        		String param = tempArr[i] + "";
                        		boolean flg = ArrayTool.isContains(param, combineArr);
                        		if(flg){
                        			nums ++;
                        		}
                        		
        					}
                        	if(nums > 2){
                        		screenmap.put(entry.getKey(), entry.getValue());
                        		break;
                        	}
                        	
						}
        			
        			}
                	
	            }
	            br.close();
		} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		for (Entry<String, Integer> entry : screenmap.entrySet()) {
			map.remove(entry.getKey());
		}
		ArrayList<String> screenlist = new ArrayList<String>();
		for (Entry<String, Integer> entry : map.entrySet()) {
			screenlist.add(entry.getKey());		
		}
		
		createScreenTxt(screenlist, "threescreen");
		return map;
	}
	
	/**
	 * 二连过滤
	 * @param map
	 * @return
	 */
	public static Map<String, Integer> screenTwo(Map<String, Integer> map) {
		Map<String, Integer> screenmap = new HashMap<String, Integer>();
		String path = "";
		path = "data/greatelott/twocontinue.txt";
		URL url = LotteryHaveNoMaster.class.getClassLoader().getResource(path);
		File file = new File(url.getFile());
		if(null != file && file.exists()) {
		 try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line = null;
				while((StringUtils.isNotEmpty(line = br.readLine()))){//使用readLine方法，一次读一行
	                Pattern p = Pattern.compile("\\s*|\t|\r|\n");
	                Matcher m = p.matcher(line);
	                String temprp = m.replaceAll("");
	                String[] redArr = temprp.split(",");
        			int[] paramArr = ArrayTool.strArr2InArr(redArr);
        			ArrayList<String> tempList = CombineUtil.getScreenList(paramArr,2);
        			for (Entry<String, Integer> entry : map.entrySet()) {
        				String combine = entry.getKey();
        				String [] combineArr = combine.split(",");
        				for (String temp : tempList) {
        					String [] tempArr = temp.split(",");
        					int nums = 0;
                        	for (int i = 0; i < tempArr.length; i++) {
                        		String param = tempArr[i] + "";
                        		boolean flg = ArrayTool.isContains(param, combineArr);
                        		if(flg){
                        			nums ++;
                        		}
                        		
        					}
                        	if(nums > 1){
                        		screenmap.put(entry.getKey(), entry.getValue());
                        		break;
                        	}
                        	
						}
        			
        			}
                	
	            }
	            br.close();
		} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		for (Entry<String, Integer> entry : screenmap.entrySet()) {
			map.remove(entry.getKey());
		}
		ArrayList<String> screenlist = new ArrayList<String>();
		for (Entry<String, Integer> entry : map.entrySet()) {
			screenlist.add(entry.getKey());		
		}
		
		createScreenTxt(screenlist, "twoscreen");
		return map;
	}

}