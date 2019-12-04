package com.zjl.lottery.doubleball.test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;

import com.zjl.lottery.doubleball.util.HistoryScreenUtil;
import com.zjl.lottery.doubleball.util.HistoryUtil;
import com.zjl.lottery.doubleball.util.MultipParamsListUtil;
import com.zjl.lottery.doubleball.util.OtherTicketScreenUtil;
import com.zjl.lottery.doubleball.util.ScreenUtil;
import com.zjl.lottery.util.MapDataUtil;
import com.zjl.lottery.util.ThreeSreenUtil;
import com.zjl.lottery.util.TwoSreenUtil;

public class MultipParamsListTest {
	public static void main(String[] args) {

		int[] paramArr1 = {1,2,3,5,7,8,9,10,11,12,13,14,15,16,17,19,20,24,25,26,27,30,31,32,33};
		int[] paramArr2 = {2,3,4,5,8,9,11,12,13,14,15,16,17,18,19,20,21,23,25,26,27,28,29,30,33};
		int[] paramArr3 = {1,3,4,5,6,7,8,9,11,12,13,15,16,17,18,20,21,22,23,24,25,28,29,30,33};
		int[] paramArr4 = {1,4,5,7,8,10,11,12,14,15,16,17,18,19,21,22,23,24,26,27,28,29,30,32,33};
		int[] paramArr5 = {1,2,3,4,5,7,8,9,10,11,12,13,15,16,17,18,19,21,22,23,24,25,26,28,33};
		int[] paramArr6 = {1,3,4,6,7,8,9,10,11,12,14,15,16,17,19,20,21,22,24,27,29,30,31,32,33};
		int[] paramArr7 = {1,2,4,5,6,8,10,11,12,13,15,16,18,19,20,21,22,23,25,26,27,28,31,32,33};
		int[] paramArr8 = {1,2,4,5,6,8,9,11,12,13,14,17,19,20,21,23,24,25,26,27,28,29,30,31,33};
		int[] paramArr9 = {1,2,4,5,7,8,9,10,11,13,16,17,18,19,20,22,24,25,26,27,28,29,30,31,33};
		int[] paramArr10 = {1,3,7,9,10,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,29,30,31,32};
		int[] paramArr11 = {1,2,3,5,6,9,10,12,13,14,15,16,17,18,20,21,22,23,24,25,26,28,29,31,33};
		int[] paramArr12 = {1,2,3,4,5,6,7,8,9,11,12,13,14,15,16,21,22,24,25,27,28,29,30,31,33};
		ArrayList<int[]> screenlist = new ArrayList<int[]>();
		screenlist.add(paramArr12);
		screenlist.add(paramArr11);
		screenlist.add(paramArr10);
		screenlist.add(paramArr9);
		screenlist.add(paramArr8);
		screenlist.add(paramArr7);
		screenlist.add(paramArr6);
		screenlist.add(paramArr5);
		screenlist.add(paramArr4);
		screenlist.add(paramArr3);
		screenlist.add(paramArr2);
		screenlist.add(paramArr1);
		int[] screenarray = HistoryUtil.get10periodHistoryArr();	
	
	
		MultipParamsListUtil.screenDetermined(screenlist, screenarray);
	//	historyscreen();
	//	otherticketscreen();
	//	threeScreen();
		//twoScreen();
	//	pingtotal();
	//	sametails();
	//	randomaward(); 
		
	}
	/**
	 * 同尾号过滤
	 * @Title: sametails   
	 * @param:       
	 * @return: void      
	 * @throws
	 */
	private static void sametails() {
		String filename = "pingtotal";
		String filepath = "E:" + File.separator + "screen" + File.separator +filename+".txt";;
		Map<String, Integer> datamap = MapDataUtil.getDataMap(filepath);
		ScreenUtil.screensametails(datamap,filename);
		
	}
	//随机选取
	private static void randomaward() {
		String filepath = "E:" + File.separator + "screen" + File.separator +"pingtotalsametails.txt";;
		Map<String, Integer> datamap = MapDataUtil.getDataMap(filepath);
		List<String> initlist = new ArrayList<String>();
		for (Entry<String, Integer> entry : datamap.entrySet()) {
			initlist.add(entry.getKey());
		}
		Map<String, Integer> firstdraw = new HashMap<String, Integer>();
		String data = "";
		for (int i = 0; i < 7; i++) {
			double random = (double) ((Math.random()*9+1)*1000)/10000;
			int index = Integer.parseInt(new java.text.DecimalFormat("0").format(random*initlist.size()));
			String draw = initlist.get(index);
			System.out.println(draw);
			if(StringUtils.isNotEmpty(draw)){
				String [] drawArr = draw.split(",");
				for (int j = 0; j < drawArr.length; j++) {
					firstdraw.put(drawArr[j], 1);
				}
			}
			data += ","+draw;
		}
	//	System.out.println(data);
		/*Map<String, Integer> screendraw = new HashMap<String, Integer>();
		for (Entry<String, Integer> entry : datamap.entrySet()) {
			String combine = entry.getKey();
			if(StringUtils.isNotEmpty(combine)){
				int count = 0;
				String [] drawArr = combine.split(",");
				for (int j = 0; j < drawArr.length; j++) {
					Integer flg = firstdraw.get(drawArr[j]);
					if(null != flg){
						count ++;
					}
				}
				if(count > 3){
					screendraw.put(combine, entry.getValue());
				}
			}
		}
		
		List<String> secondlist = new ArrayList<String>();
		for (Entry<String, Integer> entry : screendraw.entrySet()) {
			secondlist.add(entry.getKey());
		}
		for (int i = 0; i < 2; i++) {
			double random = (double) ((Math.random()*9+1)*1000)/10000;
			int index = Integer.parseInt(new java.text.DecimalFormat("0").format(random*secondlist.size()));
			String draw = secondlist.get(index);
			System.out.println(draw);
		}
		*/
		
	}

	public void init(){

		int[] paramArr1 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33};
		int[] paramArr2 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33};
		int[] paramArr3 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33};
		int[] paramArr4 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33};
		int[] paramArr5 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33};
		int[] paramArr6 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33};
		int[] paramArr7 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33};
		int[] paramArr8 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33};
		int[] paramArr9 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33};
		int[] paramArr10 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33};
		int[] paramArr11 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33};
		int[] paramArr12 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33};
		ArrayList<int[]> screenlist = new ArrayList<int[]>();
		screenlist.add(paramArr12);
		screenlist.add(paramArr11);
		screenlist.add(paramArr10);
		screenlist.add(paramArr9);
		screenlist.add(paramArr8);
		screenlist.add(paramArr7);
		screenlist.add(paramArr6);
		screenlist.add(paramArr5);
		screenlist.add(paramArr4);
		screenlist.add(paramArr3);
		screenlist.add(paramArr2);
		screenlist.add(paramArr1);
		int[] screenarray = HistoryUtil.get10periodHistoryArr();	
		MultipParamsListUtil.screenDetermined(screenlist, screenarray);
		//historyscreen();
		//otherticketscreen();
		//threeScreen();
		//twoScreen();
		//pingtotal();
		
	}
	/**
	 * 历史开奖信息过滤
	 */
	private static void historyscreen() {
		String [] filenameArr = {"resultmapdeterminedclude","resultmapdeterminedunclude"};
		for (String filename : filenameArr) {
			String filepath = "E:" + File.separator + "screen" + File.separator +filename+".txt";;
			Map<String, Integer> datamap = MapDataUtil.getDataMap(filepath);
			HistoryScreenUtil.screenhistory(datamap,filename);
		}
		
	}
	/**
	 * 自购实体票信息过滤
	 * @param:       
	 */
	private static void otherticketscreen() {
		String [] filenameArr = {
				"resultmapdeterminedcludehistoryclude",
				"resultmapdeterminedcludehistoryunclude",
				"resultmapdetermineduncludehistoryclude",
				"resultmapdetermineduncludehistoryunclude"
				};
		for (String filename : filenameArr) {
			String filepath = "E:" + File.separator + "screen" + File.separator +filename+".txt";;
			Map<String, Integer> datamap = MapDataUtil.getDataMap(filepath);
			OtherTicketScreenUtil.screenotherticket(datamap,filename);
		}
		
	}
	/**
	 * 三连过滤
	 * @param:       
	 */
	private static void threeScreen() {
		String [] filenameArr = {
				"resultmapdeterminedcludehistorycludeotherticketclude",
				"resultmapdeterminedcludehistorycludeotherticketunclude",
				"resultmapdeterminedcludehistoryuncludeotherticketclude",
				"resultmapdeterminedcludehistoryuncludeotherticketunclude",
				"resultmapdetermineduncludehistorycludeotherticketclude",
				"resultmapdetermineduncludehistorycludeotherticketunclude",
				"resultmapdetermineduncludehistoryuncludeotherticketclude",
				"resultmapdetermineduncludehistoryuncludeotherticketunclude"
				};
		for (String filename : filenameArr) {
			String filepath = "E:" + File.separator + "screen" + File.separator +filename+".txt";;
			Map<String, Integer> datamap = MapDataUtil.getDataMap(filepath);
			ThreeSreenUtil.threeScreen(datamap,filename);
		}
		
	}
	
	/**
	 * 
	 * @param:       
	 */
	private static void twoScreen() {
		String [] filenameArr = {
				"resultmapdeterminedcludehistorycludeotherticketclude",
				"resultmapdeterminedcludehistorycludeotherticketunclude",
				"resultmapdeterminedcludehistoryuncludeotherticketclude",
				"resultmapdeterminedcludehistoryuncludeotherticketunclude",
				"resultmapdetermineduncludehistorycludeotherticketclude",
				"resultmapdetermineduncludehistorycludeotherticketunclude",
				"resultmapdetermineduncludehistoryuncludeotherticketclude",
				"resultmapdetermineduncludehistoryuncludeotherticketunclude"
				};
		for (String filename : filenameArr) {
			filename += "threescreen";
			String filepath = "E:" + File.separator + "screen" + File.separator +filename+".txt";;
			Map<String, Integer> datamap = MapDataUtil.getDataMap(filepath);
			TwoSreenUtil.twoScreen(datamap,filename);
		}
		
	}
	
	/**
	 * 组装所有
	 * @param:       
	 * @return: void      
	 */
	private static void pingtotal() {
		String [] filenameArr = {
				"resultmapdeterminedcludehistorycludeotherticketclude",
				"resultmapdeterminedcludehistorycludeotherticketunclude",
				"resultmapdeterminedcludehistoryuncludeotherticketclude",
				"resultmapdeterminedcludehistoryuncludeotherticketunclude",
				"resultmapdetermineduncludehistorycludeotherticketclude",
				"resultmapdetermineduncludehistorycludeotherticketunclude",
				"resultmapdetermineduncludehistoryuncludeotherticketclude",
				"resultmapdetermineduncludehistoryuncludeotherticketunclude"
				};
		Map<String, Integer> totalmap = new HashMap<String, Integer>();
		for (String filename : filenameArr) {
			filename += "threescreen12345";
			String filepath = "E:" + File.separator + "screen" + File.separator +filename+".txt";;
			Map<String, Integer> datamap = MapDataUtil.getDataMap(filepath);
			for (Entry<String, Integer> entry : datamap.entrySet()) {
				totalmap.put(entry.getKey(), entry.getValue());
			}
		}
		MapDataUtil.createScreenTxtMap(totalmap, "pingtotal");
	}
}
