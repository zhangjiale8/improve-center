package com.zjl.lottery.doubleball.main;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;

import com.zjl.lottery.doubleball.mutitest.LotteryHaveNoMaster;
import com.zjl.lottery.doubleball.util.HistoryUtil;
import com.zjl.lottery.doubleball.util.ScreenUtil;
import com.zjl.lottery.util.JDBCPatchUtil;
import com.zjl.lottery.util.MapTxtUtil;
import com.zjl.tools.ArrayTool;

public class Main {
	public static void main(String[] args) {
		//历史数据过滤
		//MainUtil.historyScreen();
		//复试数据过滤
		//MainUtil.compoundScreen();
		//数据过滤
		//screenCombinebydata();
		//历史数据五分过滤
		//screenCombinebyHistorydata();
		//十组数据预测法
		//tenParamArrScreen();
		//多组数据组合过滤法
		//mutipleArrScreen();
		//初始化双色球历史数据
		//MainUtil.initDoubleBallHistory();
		//初始化大乐透历史数据
		//initGreatLottoHistory();
		//temp();
		for (int i = 0; i < 1; i++) {
			System.out.println((double)((Math.random()*9+1)*1000)/10000*26520);

		}
		//单组数据过滤
		//screenCombineMapbydata();
		
	}
	private static void temp() {
		/*String determinedpath = "E:" + File.separator + "screen" + File.separator +"tenarrscreen00002.txt";;
		Map<String, Integer> determinedmap = MapTxtUtil.getDataMap(determinedpath );
		Map<String, Integer> map = new HashMap<String, Integer>();
		 for (Entry<String, Integer> entry : determinedmap.entrySet()) {
		 	String combine = entry.getKey();
		 	int nums = entry.getValue();
           	if(nums < 3){
           		map.put(combine, nums);
           	}
        }
		MapTxtUtil.createScreenTxtMap(map, "tenarrscreen00003");*/
		/*String determinedpath = "E:" + File.separator + "screen" + File.separator +"tenarrscreen00003.txt";
		Map<String, Integer> determinedmap = MapTxtUtil.getDataMap(determinedpath );
		Map<String, Integer> historyMap = HistoryUtil.getHistoryMap();
		for (Entry<String, Integer> entry : historyMap.entrySet()) {
		 	String combine = entry.getKey();
		 	if(null != determinedmap.get(combine)){
		 		determinedmap.remove(combine);
		 	}
        }
		MapTxtUtil.createScreenTxtMap(determinedmap, "tenarrscreen00004");*/
		/*String determinedpath = "E:" + File.separator + "screen" + File.separator +"tenarrscreen00004.txt";
		Map<String, Integer> determinedmap = MapTxtUtil.getDataMap(determinedpath);
		String path1 = LotteryHaveNoMaster.class.getClassLoader().getResource("0000/single.txt").getPath();
		path1 = path1.substring(1, path1.length());
		String path2 = LotteryHaveNoMaster.class.getClassLoader().getResource("0000/mutipul.txt").getPath();
		path2 = path2.substring(1, path2.length());
		ArrayList<String> pathList = new ArrayList<String>();
		pathList.add(path1);
		pathList.add(path2);		
		Map<String, Integer> datamap = MapTxtUtil.getDataMap(pathList,6);
		for (Entry<String, Integer> entry : datamap.entrySet()) {
		 	String combine = entry.getKey();
		 	if(null != determinedmap.get(combine)){
		 		determinedmap.remove(combine);
		 	}
        }
		MapTxtUtil.createScreenTxtMap(determinedmap, "tenarrscreen00005");*/
		String determinedpath = "E:" + File.separator + "screen" + File.separator +"tenarrscreen00006.txt";
		Map<String, Integer> determinedmap = MapTxtUtil.getDataMap(determinedpath);
		String path2 = LotteryHaveNoMaster.class.getClassLoader().getResource("0000/single.txt").getPath();
		path2 = path2.substring(1, path2.length());
		Map<String, Integer> map = ScreenUtil.screenFile(determinedmap,path2,5);
		MapTxtUtil.createScreenTxtMap(determinedmap, "tenarrscreen00007");
		
	}
	private static void mutipleArrScreen() {
		String fileName = "tenarrscreen0703914";
		String filePath = "E:" + File.separator + "screen" + File.separator;
		List<int[]> combinelist = new ArrayList<int[]>();
		List<int[]> list = new ArrayList<int[]>();
		for (int[] param : list) {
			
		}
	}
	private static void screenCombinebyHistorydata() {
		//String fileName = "tenarrscreen0051";
		
		ArrayList<String> historyList = JDBCPatchUtil.getHistoryList();
		int index = 0;
		for (String params : historyList) {
			if(StringUtils.isNotEmpty(params)){
				String fileName = "tenarrscreen0703"+index;
				String filePath = "E:" + File.separator + "screen" + File.separator +fileName+ ".txt";
				String[] strArr = params.split(",");
				int[] paramArr = ArrayTool.strArr2InArr(strArr);
				int screenNum = 5;
				int maxNum = 5;
				String saveFileName = "tenarrscreen0703"+(++index);
				MainUtil.screenCombinebydata(filePath,paramArr,screenNum,maxNum,saveFileName);
			}
		}
		
		
	}
	/**
	 * 
	 * @Title: tenParamArrScreen   
	 * @Description: 十组数据预测法
	 * 时间复杂度： 
	 * 空间复杂度： 
	 * @param:       
	 * @return: void      
	 * @throws
	 */
	private static void tenParamArrScreen() {
		int[] paramArr1 = {2,3,4,5,6,7,8,9,10,11,14,15,17,19,20,21,22,23,24,26,28,29,30,31,32};
		int[] paramArr2 = {1,2,4,5,9,10,11,12,13,15,16,17,18,19,21,23,24,25,26,28,29,30,31,32,33};
		int[] paramArr3 = {1,3,4,6,8,9,10,11,13,14,15,16,18,19,20,21,22,25,26,28,29,30,31,32,33};
		int[] paramArr4 = {1,3,4,5,7,8,10,11,12,13,14,15,17,18,20,21,22,24,25,26,28,29,30,31,32};
		int[] paramArr5 = {1,2,3,4,5,6,7,9,10,11,15,17,18,20,21,22,23,24,25,26,27,28,29,31,32};
		int[] paramArr6 = {3,4,5,9,10,11,12,13,14,16,17,18,19,20,21,23,24,25,26,27,28,30,31,32,33};
		int[] paramArr7 = {2,3,4,5,6,7,8,9,13,14,15,16,18,20,21,22,23,24,26,27,28,29,30,31,32};
		int[] paramArr8 = {3,4,5,6,7,8,11,12,13,14,15,16,18,20,21,22,24,25,27,28,29,30,31,32,33};
		int[] paramArr9 = {3,4,5,6,8,10,11,12,13,14,15,17,19,20,21,24,25,26,27,28,29,30,31,32,33};
		int[] paramArr10 = {1,3,6,7,8,9,11,12,13,15,16,17,18,19,20,21,24,25,26,27,28,29,30,31,32};
		int[] paramArr11 = {1,2,3,4,5,8,9,10,11,13,14,16,18,19,21,23,24,25,26,28,29,30,31,32,33};
		int[] paramArr12 = {1,2,3,4,6,7,10,11,12,13,14,15,16,17,18,20,22,24,26,28,29,30,31,32,33};
		ArrayList<int[]> list = new ArrayList<int[]>();
		list.add(paramArr12);
		list.add(paramArr11);
		list.add(paramArr10);
		list.add(paramArr9);
		list.add(paramArr8);
		list.add(paramArr7);
		list.add(paramArr6);
		list.add(paramArr5);
		list.add(paramArr4);
		list.add(paramArr3);
		list.add(paramArr2);
		list.add(paramArr1);
		int screenNum = 6;
		//screencommon(list,screenNum);	
		screenDetermined(list,screenNum);	
		
	}
	private static void screenDetermined(ArrayList<int[]> list, int screenNum) {
		Map<String, Integer> combineMap = MainUtil.tenParamArrcombine(list,screenNum);
		Map<String, Integer> determinedmap = ScreenUtil.screenDetermined(combineMap);
		Map<String, Integer> ThreeMap = ScreenUtil.screenThree(determinedmap);
		Map<String, Integer> historyMap = HistoryUtil.screenHistory(ThreeMap);
		/*
		String path1 = LotteryHaveNoMaster.class.getClassLoader().getResource("0000/single.txt").getPath();
		ArrayList<String> pathList = new ArrayList<String>();
		pathList.add(path1);
		Map<String, Integer> datamap = MapTxtUtil.getDataMap(pathList,6);
		for (Entry<String, Integer> entry : datamap.entrySet()) {
		 	String combine = entry.getKey();
		 	if(null != historyMap.get(combine)){
		 		historyMap.remove(combine);
		 	}
        }*/
		MapTxtUtil.createScreenTxtMap(historyMap, "tenarrscreen20190806");
		
		
	}
	/**
	 * 正常数据过滤
	 * @param list
	 * @param screenNum
	 */
	private static void screencommon(ArrayList<int[]> list, int screenNum) {
		Map<String, Integer> combineMap = MainUtil.tenParamArrScreenHistoryAndThree(list,screenNum);
		Map<String, Integer> ThreeMap = ScreenUtil.screenThree(combineMap);
		Map<String, Integer> twoMap = ScreenUtil.screenTwo(ThreeMap);
		Map<String, Integer> historyMap = HistoryUtil.screenHistory(twoMap);
		
	}
	private static void pramsArr() {
		int[] paramArr1 = {};
		int[] paramArr2 = {};
		int[] paramArr3 = {};
		int[] paramArr4 = {};
		int[] paramArr5 = {};
		int[] paramArr6 = {};
		int[] paramArr7 = {};
		int[] paramArr8 = {};
		int[] paramArr9 = {};
		int[] paramArr10 = {};
	}

	private static void screenCombinebydata() {
		String fileName = "tenarrscreen00001";
		String filePath = "E:" + File.separator + "screen" + File.separator +fileName+ ".txt";
		int[] paramArr = {7,22,23};
		int screenNum = 2;
		int maxNum = 2;
		String saveFileName = "tenarrscreen00002";
		MainUtil.screenCombinebydata(filePath,paramArr,screenNum,maxNum,saveFileName);
	}
	
	private static void screenCombineMapbydata() {
		/*String fileName = "tenarrscreen00006";
		String filePath = "E:" + File.separator + "screen" + File.separator +fileName+ ".txt";
		int[] paramArr = {32};
		int screenNum = 1;
		int maxNum = 1;
		String saveFileName = "tenarrscreen00007";
		ScreenUtil.screenCombineMapbydata(filePath,paramArr,screenNum,maxNum,saveFileName);*/
		String fileName = "tenarrscreen00007";
		String filePath = "E:" + File.separator + "screen" + File.separator +fileName+ ".txt";
		int screenNum = 3;
		String saveFileName = "tenarrscreen00008";
		ScreenUtil.screenCombineMapbycount(filePath,screenNum,saveFileName);
	}
	
}
