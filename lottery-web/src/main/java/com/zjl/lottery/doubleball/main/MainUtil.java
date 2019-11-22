package com.zjl.lottery.doubleball.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.zjl.lottery.combine.util.CombineUtil;
import com.zjl.lottery.doubleball.mutitest.LotteryHaveNoMaster;
import com.zjl.lottery.doubleball.util.ListTxtUtil;
import com.zjl.lottery.doubleball.util.MapTxtUtil;
import com.zjl.lottery.util.JDBCPatchUtil;
import com.zjl.lottery.util.ThreeSreenUtil;
import com.zjl.tools.ArrayTool;

public class MainUtil {
	/**
	 * 复试数据过滤
	 */
	public static void compoundScreen() {
		
		
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
			ListTxtUtil.createScreenTxt(resultList,saveFileName);
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
	public static void tenParamArrScreen(ArrayList<int[]> list, int screenNum) {
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
			if(count < 4) {
				screenlist.add(entry.getKey());
			}
		
		}
		
		ListTxtUtil.createScreenTxt(screenlist, "tenarrscreen");
		
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
	public static Map<String, Integer> tenParamArrScreenHistoryAndThree(ArrayList<int[]> list, int screenNum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int[] paramArr : list) {
			ArrayList<String> screenList = CombineUtil.getScreenList(paramArr,screenNum);
			if(null != screenList && screenList.size() > 0) {
				for (int i = 0; i < screenList.size(); i++) {
					String combine = screenList.get(i);
					if(StringUtils.isNotEmpty(combine)) {
						int count = (null == map.get(combine)) ? 1 : map.get(combine) + 1;
						map.put(combine, count);
					}
					
				}
			}
			
		}
		ArrayList<String> screenlist = new ArrayList<String>();
		for (Entry<String, Integer> entry : map.entrySet()) {
			int count = entry.getValue();
			if(count < 4) {
				screenlist.add(entry.getKey());
			}
		
		}
		
		ListTxtUtil.createScreenTxt(screenlist, "tenarrscreen");
		return map;
		
	}
	

	/**
	 * 多组数据全部组合
	 * @param list
	 * @param screenNum
	 * @return
	 */
	public static Map<String, Integer> tenParamArrcombine(ArrayList<int[]> list, int screenNum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int[] paramArr : list) {
			ArrayList<String> screenList = CombineUtil.getScreenList(paramArr,screenNum);
			if(null != screenList && screenList.size() > 0) {
				for (int i = 0; i < screenList.size(); i++) {
					String combine = screenList.get(i);
					if(StringUtils.isNotEmpty(combine)) {
						int count = (null == map.get(combine)) ? 1 : map.get(combine) + 1;
						map.put(combine, count);
					}
					
				}
			}
			
		}		
		return map;
	}
	
	public static void main(String[] args) {
		Map<String, Integer> result = new HashMap<String, Integer>();
		int[] paramArr = {3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,22,23,25,26,27,29,30,31};
		List<String> list1 = CombineUtil.getScreenList(paramArr , 5);
		int[] paramArr2 = {1,2,19,20,21,24,28,32,33};
		List<String> list2 = CombineUtil.getScreenList(paramArr2  , 2);
		for (String bine1 : list1) {
			for (String bine2 : list2) {
				if(StringUtils.isNotEmpty(bine1)&& StringUtils.isNotEmpty(bine2)){
					String temp = bine1+","+bine2;
					String [] tempArr = temp.split(",");
					int [] tempIntArr = ArrayTool.strArr2InArr(tempArr);
					tempIntArr = ArrayTool.sort(tempIntArr);
					String combine = Arrays.toString(tempIntArr);
					combine = combine.substring(1, combine.length()-1);
					result.put(combine, 1);
				}
			}
		}
		
		if(null != result && result.size() > 0){
			MapTxtUtil.createScreenTxtMap(result, "initdoubleball");
		}
		Map<String, Integer> combinemap = new HashMap<String, Integer>();
		for (Entry<String, Integer> entry : result.entrySet()) {
			 String temp = entry.getKey();
			 String [] tempArr = temp.split(",");
			 int [] tempIntArr = ArrayTool.strArr2InArr(tempArr);
			 List<String> combinelist = CombineUtil.getScreenList(tempIntArr , 6);
			 for (String combine : combinelist) {
				 combinemap.put(combine, 1);
			}
        }
		 
		if(null != combinemap && combinemap.size() > 0){
			MapTxtUtil.createScreenTxtMap(combinemap, "initcombinedoubleball");
		}
		
		String filepath = "E:" + File.separator + "screen" + File.separator +"initcombinedoubleball.txt";
		Map<String, Integer> datamap = MapTxtUtil.getDataMap(filepath);
		ThreeSreenUtil.threeScreen(datamap, "initcombinedoubleball");
	}
	
}
