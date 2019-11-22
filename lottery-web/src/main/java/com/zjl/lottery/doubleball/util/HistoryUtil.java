package com.zjl.lottery.doubleball.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.zjl.lottery.doubleball.mutitest.LotteryHaveNoMaster;
import com.zjl.lottery.dto.LotteryDto;
import com.zjl.lottery.util.CombineUtil;
import com.zjl.lottery.util.JDBCPatchUtil;
import com.zjl.lottery.util.ListDataUtil;
import com.zjl.lottery.util.MapDataUtil;
import com.zjl.tools.ArrayTool;
import com.zjl.tools.TimeTools;

public class HistoryUtil {
	

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
	 * 初始化双色球历史
	 */
	public static void initDoubleBallHistory() {
		ArrayList<String> historyListTemp = JDBCPatchUtil.getDoubleBallHistoryList();
		ArrayList<String> historyList = new ArrayList<String>();
		for (int i = 0; i < historyListTemp.size(); i++) {
			String param = historyListTemp.get(i);
			/*String [] paramArr = param.split("@");
			String temp = paramArr[2];*/
			historyList.add(param);
		}
		ListDataUtil.createScreenTxt(historyList, "doubleballhistorydrawinfo");
	}

	
	/**
	 * map历史数据过滤
	 * @param map
	 * @return
	 */
	public static Map<String, Integer> screenHistory(Map<String, Integer> map) {
		Map<String, Integer> screenmap = new HashMap<String, Integer>();
		String path = "";
		path = "data/doubleballhistorydrawinfo.txt";
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
	                String[] strArr = temprp.split("@");
	                String[] params = strArr[2].split("\\|");
	                if(null != params && params.length == 2) {
	                	String redStr = params[0];
	                	redStr = redStr.replaceAll("，", ",");
	        			String [] redArr = redStr.split(",");
	        			int[] paramArr = ArrayTool.strArr2InArr(redArr);
	        			ArrayList<String> tempList = CombineUtil.getScreenList(paramArr,6);
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
	                        	if(nums > 4){
	                        		screenmap.put(entry.getKey(), entry.getValue());
	                        		break;
	                        	}
	                        	
	                        	
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
		
		MapDataUtil.createScreenTxtMap(map, "historyscreen");
		return map;
	}
	/**
	 * 获取历史开奖List
	 * @return
	 */
	public static List<String> getHistoryList() {
		List<String> list = new ArrayList<String>();
		String path = "";
		path = "data/doubleballhistorydrawinfo.txt";
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
	                String[] strArr = temprp.split("@");
	                String[] params = strArr[2].split("\\|");
	                if(null != params && params.length == 2) {
	                	String redStr = params[0];
	                	redStr = redStr.replaceAll("，", ",");
	                	list.add(redStr);	                	
	                }
	            }
	            br.close();
		} catch (Exception e) {
				e.printStackTrace();
			}
			
		}		
		return list;
	}
	
	/**
	 * 获取历史开奖List
	 * @return
	 */
	public static List<LotteryDto> getHistorydtoList() {
		List<LotteryDto> list = new ArrayList<LotteryDto>();
		String path = "";
		path = "data/doubleballhistorydrawinfo.txt";
		URL url = LotteryHaveNoMaster.class.getClassLoader().getResource(path);
		File file = new File(url.getFile());
		if(null != file && file.exists()) {
		 try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line = null;
				while((StringUtils.isNotEmpty(line = br.readLine()))){//使用readLine方法，一次读一行
	               
	                String[] strArr = line.split("@");
	                String period = strArr[0];
	                Date drawdtm = TimeTools.DateFormate(strArr[1], TimeTools.Y_M_D_H_M_S);
	                String red = "";
	                String blue = "";
	                String[] params = strArr[2].split("\\|");
	                if(null != params && params.length == 2) {
	                	red = params[0];
	                	blue = params[1];
	                	red = red.replaceAll("，", ",");
	                	blue = blue.replaceAll("，", ",");
	                }
	                LotteryDto lotterydto = new LotteryDto(period, red, blue, drawdtm);
                	list.add(lotterydto);	                	
	            }
	            br.close();
		} catch (Exception e) {
				e.printStackTrace();
			}
			
		}		
		return list;
	}
	
	/**
	 * 获取历史开奖Map
	 * @return
	 */
	public static Map<String, Integer> getHistoryMap() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		String path = "";
		path = "data/doubleballhistorydrawinfo.txt";
		URL url = LotteryHaveNoMaster.class.getClassLoader().getResource(path);
		File file = new File(url.getFile());
		if (null != file && file.exists()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line = null;
				while ((StringUtils.isNotEmpty(line = br.readLine()))) {// 使用readLine方法，一次读一行
					Pattern p = Pattern.compile("\\s*|\t|\r|\n");
					Matcher m = p.matcher(line);
					String temprp = m.replaceAll("");
					String[] strArr = temprp.split("@");
					String[] params = strArr[2].split("\\|");
					if (null != params && params.length == 2) {
						String redStr = params[0];
						redStr = redStr.replaceAll("，", ",");
						map.put(redStr, 1);
					}
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return map;
	}
	
	public static void main(String[] args) {
		ArrayList<String> analysislist = new ArrayList<String>();
		List<LotteryDto> list = HistoryUtil.getHistorydtoList();
		int total = 0;
		for (int i = 0; i <list.size(); i++) {
			LotteryDto lotterydto = list.get(i);
			if(null != lotterydto){
				int surplus = list.size()-i;
				StringBuffer analysis = new StringBuffer();
				String period = lotterydto.getPeriod();
				String drawdtm = TimeTools.DateStr(lotterydto.getDrawdtm(), TimeTools.Y_M_D_H_M_S);
				String red = lotterydto.getRed();
				String blue = lotterydto.getBlue();
				String result = "0";
				if(surplus/11 > 0){
					Map<String, Integer> redmap = new HashMap<String, Integer>();
					Map<String, Integer> bluemap = new HashMap<String, Integer>();
					for (int j = 1; j < 11; j++) {
						LotteryDto lotterydtotemp = list.get(i+j);
						String redtemp = lotterydtotemp.getRed();
						String[] redtempArr = redtemp.split(",");
						for (int k = 0; k < redtempArr.length; k++) {
							String redstr = redtempArr[k];
							int nums = null == redmap.get(redstr) ?0:redmap.get(redstr);
							nums += 1;
							redmap.put(redstr, nums);
							
						}
						String bluetemp = lotterydtotemp.getRed();
						String[] bluetempArr = bluetemp.split(",");
						for (int k = 0; k < bluetempArr.length; k++) {
							String bluestr = bluetempArr[k];
							int nums = null == bluemap.get(bluestr) ?0:bluemap.get(bluestr);
							nums += 1;
							bluemap.put(bluestr, nums);
							
						}
					}
					String[] redArr = red.split(",");
					int nums = 0;
					for (int j = 0; j < redArr.length; j++) {
						String retemp = redArr[j];
						boolean flg = redmap.containsKey(retemp);
						if(flg){
							nums ++;
						}
					}
					if(nums > 5){
						result = "1";
						total ++;
					}
					
				}
				
				analysis.append(" period = "+period);
				analysis.append(" ;drawdtm = "+drawdtm);
				analysis.append(" ;red = "+red);
				analysis.append(" ;blue = "+blue);
				analysis.append(" ;result = "+result);
				analysislist.add(analysis.toString());
			}
		}
		
		System.out.println(total);
		System.out.println(list.size() - total);
		if(null != analysislist && analysislist.size() > 0){
			ListDataUtil.createScreenTxt(analysislist,"analysislist");
		}
	}

}
