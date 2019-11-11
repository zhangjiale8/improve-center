package com.zjl.lottery.test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;

import com.zjl.lottery.util.HistoryScreenUtil;
import com.zjl.lottery.util.MapTxtUtil;
import com.zjl.lottery.util.MultipParamsListUtil;
import com.zjl.lottery.util.OtherTicketScreenUtil;
import com.zjl.lottery.util.ParamsListUtil;
import com.zjl.lottery.util.ScreenUtil;
import com.zjl.lottery.util.ThreeSreenUtil;
import com.zjl.lottery.util.TwoSreenUtil;

public class MultipParamsListTest {
	public static void main(String[] args) {

		int[] paramArr1 = {1,2,3,4,5,6,7,9,10,13,14,15,16,18,19,20,21,23,24,25,26,27,29,32,33};
		int[] paramArr2 = {1,2,3,4,7,8,9,11,12,13,14,15,16,18,19,20,21,22,23,25,26,27,28,30,33};
		int[] paramArr3 = {1,2,3,5,6,7,8,10,12,13,14,15,16,17,20,21,22,23,26,27,28,29,30,32,33};
		int[] paramArr4 = {1,2,3,4,5,7,8,10,12,13,14,15,16,17,21,23,24,25,27,28,29,30,31,32,33};
		int[] paramArr5 = {2,3,6,7,8,9,12,13,14,15,16,17,19,20,21,22,23,24,25,26,27,30,31,32,33};
		int[] paramArr6 = {2,3,4,6,7,8,9,10,11,12,13,14,15,16,17,18,19,24,26,27,29,30,31,32,33};
		int[] paramArr7 = {1,3,4,5,9,11,12,13,15,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33};
		int[] paramArr8 = {1,2,3,4,6,7,8,9,10,11,12,13,14,16,18,20,22,23,24,25,26,30,31,32,33};
		int[] paramArr9 = {1,2,3,5,6,7,8,9,10,12,13,14,16,17,18,19,20,21,22,23,24,27,28,31,32};
		int[] paramArr10 = {1,3,4,5,6,7,11,12,13,14,15,17,18,19,20,22,23,26,27,28,29,30,31,32,33};
		int[] paramArr11 = {1,4,5,7,8,9,10,11,12,13,14,15,17,18,19,20,22,23,24,25,26,27,28,29,30};
	//	int[] paramArr12 = {};
		ArrayList<int[]> screenlist = new ArrayList<int[]>();
	//	screenlist.add(paramArr12);
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
		int[] screenarray = {2,3,4,6,7,8,9,10,11,12,14,15,16,17,19,21,22,23,24,26,27,28,29,30,31,32,33};
	
		//MultipParamsListUtil.screenDetermined(screenlist, screenarray);
		//historyscreen();
		//otherticketscreen();
		//threeScreen();
		//twoScreen();
		//pingtotal();
		//sametails();
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
		Map<String, Integer> datamap = MapTxtUtil.getDataMap(filepath);
		ScreenUtil.screensametails(datamap,filename);
		
	}
	//随机选取
	private static void randomaward() {
		String filepath = "E:" + File.separator + "screen" + File.separator +"resultmapdetermineduncludehistoryuncludeotherticketcludethreescreen.txt";;
		Map<String, Integer> datamap = MapTxtUtil.getDataMap(filepath);
		List<String> initlist = new ArrayList<String>();
		for (Entry<String, Integer> entry : datamap.entrySet()) {
			initlist.add(entry.getKey());
		}
		Map<String, Integer> firstdraw = new HashMap<String, Integer>();
		String data = "";
		for (int i = 0; i < 5; i++) {
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
			data += draw;
		}
		System.out.println(data);
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
		int[] paramArr11 = {};
		int[] paramArr12 = {};
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
		int[] screenarray = {};
	
		//MultipParamsListUtil.screenDetermined(screenlist, screenarray);
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
			Map<String, Integer> datamap = MapTxtUtil.getDataMap(filepath);
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
			Map<String, Integer> datamap = MapTxtUtil.getDataMap(filepath);
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
			Map<String, Integer> datamap = MapTxtUtil.getDataMap(filepath);
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
			Map<String, Integer> datamap = MapTxtUtil.getDataMap(filepath);
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
			filename += "threescreen123456789123456789123456789123456789123456789123456789123456789123456789123456789"
					+ "1234567891234567891234567891234567891234567891234567891234567891234567891234567891234567892";
			String filepath = "E:" + File.separator + "screen" + File.separator +filename+".txt";;
			Map<String, Integer> datamap = MapTxtUtil.getDataMap(filepath);
			for (Entry<String, Integer> entry : datamap.entrySet()) {
				totalmap.put(entry.getKey(), entry.getValue());
			}
		}
		MapTxtUtil.createScreenTxtMap(totalmap, "pingtotal");
	}
}
