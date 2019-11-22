package com.zjl.lottery.lotto.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.zjl.lottery.doubleball.mutitest.LotteryHaveNoMaster;
import com.zjl.lottery.dto.LotteryDto;
import com.zjl.lottery.util.ListDataUtil;
import com.zjl.tools.TimeTools;

public class HistoryUtil {
	
	/**
	 * 获取历史开奖List
	 * @return
	 */
	public static List<LotteryDto> getHistorydtoList() {
		List<LotteryDto> list = new ArrayList<LotteryDto>();
		String path = "";
		path = "data/greatelott/historydraw.txt";
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
	 * 获取历史开奖List
	 * @return
	 */
	public static List<String> getHistoryList() {
		List<String> list = new ArrayList<String>();
		String path = "";
		path = "data/greatelott/historydraw.txt";
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
	 * 获取历史开奖Map
	 * @return
	 */
	public static Map<String, Integer> getHistoryMap() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		String path = "";
		path = "data/greatelott/historydraw.txt";
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
		//双色球4个以上包括4个，大乐透3个以上包括3个
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
					if(nums > 2){
						total ++;
					}
					result = nums+"";
					
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
	/**
	 * 获取前10期开奖数字数组
	 * @Title: get10periodHistoryArr   
	 * @param: @return      
	 * @return: int[]      
	 * @throws
	 */
	public static int [] get10periodHistoryArr() {
		Map<String, Integer> datamap = new HashMap<String, Integer>();
		List<String> getHistoryList = HistoryUtil.getHistoryList();
		List<String> datalist = new ArrayList<String>();
		for (int index = 0; index < 10; index++) {
			String [] drawArr = getHistoryList.get(index).split(",");
			for (int i = 0; i < drawArr.length; i++) {
				datamap.put(drawArr[i], 1);
			}
		}
		for (Entry<String, Integer> dataentry : datamap.entrySet()) {
			datalist.add(dataentry.getKey());
		}
		
		int[] dataArr = new int[datalist.size()];
		for (int i = 0; i < datalist.size(); i++) {
			dataArr[i] = Integer.valueOf(datalist.get(i));
		}
		Arrays.sort(dataArr);
		return dataArr;
	}

}
