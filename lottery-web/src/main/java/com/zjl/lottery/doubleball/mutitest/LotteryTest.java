package com.zjl.lottery.doubleball.mutitest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

public class LotteryTest {
	public static void main(String[] args) {
		URL url = LotteryTest.class.getClassLoader().getResource("119/306.txt");
		File file = new File(url.getFile());
		Map<String, Map<String, Integer>> map = txt2Map(file);
		Map<String, Integer> redMap = map.get("Red");
		if(null != redMap && redMap.size() > 0) {
			System.out.println("-------------red打印开始------------");
			for(Map.Entry<String, Integer> entry : redMap.entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
			System.out.println("-------------red打印结束------------");
		}
		Map<String, Integer> blueMap = map.get("Blue");
		if(null != blueMap && blueMap.size() > 0) {
			System.out.println("-------------blue打印开始------------");
			for(Map.Entry<String, Integer> entry : blueMap.entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
			System.out.println("-------------blue打印结束------------");
		}
	}

	private static Map<String, Map<String, Integer>> txt2Map(File file) {
		Map<String, Map<String, Integer>> result = new HashMap<String, Map<String, Integer>>();
		result.put("Red", null);
		result.put("Blue", null);
		if(null != file && file.exists()) {
			//构造一个BufferedReader类来读取文件
			try {
				Map<String, Integer> redMap = new HashMap<String, Integer>();
				Map<String, Integer> blueMap = new HashMap<String, Integer>();
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line = null;
				while((StringUtils.isNotEmpty(line = br.readLine()))){//使用readLine方法，一次读一行
	                Pattern p = Pattern.compile("\\s*|\t|\r|\n");
	                Matcher m = p.matcher(line);
	                String temp = m.replaceAll("");
	                String[] tempArr = temp.split(":");
	                String[] strArr = tempArr[1].split("\\|");
	                if(null != strArr && strArr.length == 2) {
	                	String redStr = strArr[0];
	                	String blueStr = strArr[1];
	                	//red处理
	                	Map<String, Integer> redMapTemp = dealRedOrBlueStr(redStr);
	                	for(Map.Entry<String, Integer> entry : redMapTemp.entrySet()) {
	                		String key = entry.getKey();
	                		Integer sum = redMap.get(key);
	                		if(null != sum && sum != 0) {
	                			redMap.put(key, sum + 1);
	                		}else {
	                			redMap.put(key, 1);
	                		}
	                	}
	                	//blue处理
	                	Map<String, Integer> blueMapTemp = dealRedOrBlueStr(blueStr);
	                	for(Map.Entry<String, Integer> entry : blueMapTemp.entrySet()) {
	                		String key = entry.getKey();
	                		Integer sum = blueMap.get(key);
	                		if(null != sum && sum != 0) {
	                			blueMap.put(key, sum + 1);
	                		}else {
	                			blueMap.put(key, 1);
	                		}
	                	}
	                	result.put("Red", redMap);
	            		result.put("Blue", blueMap);
	                	
	                }
	            }
	            br.close();  
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
		return result;
	}
	
	/**
	 * red处理或blue处理
	 * @param redStr
	 * @return
	 */
	private static Map<String, Integer> dealRedOrBlueStr(String redStr) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		if(StringUtils.isNotEmpty(redStr)) {
			redStr = redStr.replaceAll("，", ",");
			String [] strArr = redStr.split(",");
			if(null != strArr && strArr.length > 0) {
				for (int i = 0; i < strArr.length; i++) {
					map.put(strArr[i], 1);
				}
			}
		}
		return map;
	}
}
