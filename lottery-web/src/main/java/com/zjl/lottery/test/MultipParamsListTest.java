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
import com.zjl.lottery.util.ThreeSreenUtil;
import com.zjl.lottery.util.TwoSreenUtil;

public class MultipParamsListTest {
	public static void main(String[] args) {

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
		randomaward(); 
		
	}
	
	private static void randomaward() {
		String filepath = "E:" + File.separator + "screen" + File.separator +"pingtotal.txt";;
		Map<String, Integer> datamap = MapTxtUtil.getDataMap(filepath);
		List<String> initlist = new ArrayList<String>();
		for (Entry<String, Integer> entry : datamap.entrySet()) {
			initlist.add(entry.getKey());
		}
		Map<String, Integer> firstdraw = new HashMap<String, Integer>();
		for (int i = 0; i < 8; i++) {
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
			
		}
		Map<String, Integer> screendraw = new HashMap<String, Integer>();
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
			filename += "threescreen123456789123456789";
			String filepath = "E:" + File.separator + "screen" + File.separator +filename+".txt";;
			Map<String, Integer> datamap = MapTxtUtil.getDataMap(filepath);
			for (Entry<String, Integer> entry : datamap.entrySet()) {
				totalmap.put(entry.getKey(), entry.getValue());
			}
		}
		MapTxtUtil.createScreenTxtMap(totalmap, "pingtotal");
	}
}
