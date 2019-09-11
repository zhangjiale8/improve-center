package com.zjl.lottery.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.zjl.lottery.combine.util.CombineUtil;
import com.zjl.lottery.mutitest.LotteryHaveNoMaster;
import com.zjl.tools.ArrayTool;

public class ScreenUtil {
	/**
	 * 三连过滤
	 * @param map
	 * @return
	 */
	public static Map<String, Integer> screenThree(Map<String, Integer> map) {
		Map<String, Integer> screenmap = new HashMap<String, Integer>();
		String path = "";
		path = "data/threecontinue.txt";
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
		
		MapTxtUtil.createScreenTxtMap(map, "threescreen");
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
		path = "data/twocontinue.txt";
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
		
		MapTxtUtil.createScreenTxtMap(map, "twoscreen");
		return map;
	}
	
	/**
	 * 双色球固定组合过滤
	 * @param combineMap
	 * @return
	 */
	public static Map<String, Integer> screenDetermined(Map<String, Integer> combineMap) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		String determinedpath = LotteryHaveNoMaster.class.getClassLoader().getResource("data/disticombinedetermined.txt").getPath();
		determinedpath = determinedpath.substring(1, determinedpath.length());
		Map<String, Integer> determinedmap = MapTxtUtil.getDataMap(determinedpath);
		 for (Entry<String, Integer> entry : combineMap.entrySet()) {
			 	String combine = entry.getKey();
			 	Integer nums =  entry.getValue();
			 	if( null != determinedmap.get(combine) ){
			 		map.put(combine, nums);
			 	}
	            
        }
		 MapTxtUtil.createScreenTxtMap(map, "screendetermined");
		return map; 
		
	}


	public static Map<String, Integer> screenFile(Map<String, Integer> determinedmap, String filepath, int screennum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		Map<String, Integer> datamap = MapTxtUtil.getDataMap(filepath);
		for (Entry<String, Integer> entry : datamap.entrySet()) {
			String redStr = entry.getKey();
			if(StringUtils.isNotEmpty(redStr)){
				String[] redArr = redStr.split(",");								
				for (Entry<String, Integer> determineentry : determinedmap.entrySet()) {
					String determine = determineentry.getKey();
					String[] determineArr = determine.split(",");
					int count = 0;
					for (int i = 0; i < redArr.length; i++) {
						String temp = redArr[i];
						boolean flg = ArrayTool.isContains(temp, determineArr);
						if(flg){
							count++;
						}
					}
					if(count >= screennum){
						map.put(determine,1);
					}
				}
				
			}
		}
		for (Entry<String, Integer> entry : map.entrySet()) {
			determinedmap.remove(entry.getKey());
		}
		return determinedmap;
	}
	/**
	 * 单组数据过滤
	 * @param filePath
	 * @param paramArr
	 * @param screenNum
	 * @param maxNum
	 * @param saveFileName
	 */
	public static void screenCombineMapbydata(String filePath, int[] paramArr, int screenNum, int maxNum, String saveFileName) {
		Map<String, Integer> datamap = MapTxtUtil.getDataMap(filePath);
		ArrayList<String> screenList = CombineUtil.getScreenList(paramArr,screenNum);
		Map<String, Integer> resultmap = new HashMap<String, Integer>();
		for (Entry<String, Integer> entry : datamap.entrySet()) {
			String [] combineparamArr = entry.getKey().split(",");
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
				resultmap.put(entry.getKey(), entry.getValue());
			}
		}
		
		if(null != resultmap && resultmap.size() > 0){
			 MapTxtUtil.createScreenTxtMap(resultmap, saveFileName);
		}
	}

	/**
	 * 根据出现次数过滤
	 * @param fileName
	 * @param screenNum
	 * @param saveFileName
	 */
	public static void screenCombineMapbycount(String filePath, int screenNum, String saveFileName) {

		Map<String, Integer> datamap = MapTxtUtil.getDataMap(filePath);
		Map<String, Integer> resultmap = new HashMap<String, Integer>();
		for (Entry<String, Integer> entry : datamap.entrySet()) {
			int count = entry.getValue();
			
			if(count < screenNum){
				resultmap.put(entry.getKey(), entry.getValue());
			}
		}
		
		if(null != resultmap && resultmap.size() > 0){
			 MapTxtUtil.createScreenTxtMap(resultmap, saveFileName);
		}
	
		
	}

}
