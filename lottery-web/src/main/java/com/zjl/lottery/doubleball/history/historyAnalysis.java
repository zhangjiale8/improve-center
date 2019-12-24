package com.zjl.lottery.doubleball.history;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;

import com.zjl.lottery.doubleball.util.HistoryUtil;
import com.zjl.lottery.doubleball.util.ScreenUtil;
import com.zjl.lottery.util.MapDataUtil;
import com.zjl.tools.ArrayTool;

public class historyAnalysis {
	public static void main(String[] args) {
	//	sameterm();
	//	perterm();
	//	sametermAndperterm();
		drawsameterm();
	}
	private static void drawsameterm() {
		int sum = 0;
		Map<String, Integer> datamap = new HashMap<String, Integer>();
		Map<String, String> historymap = HistoryUtil.getPeriodHistoryMap();
		for (Entry<String, String> entry : historymap.entrySet()) {
			int count = 0;
			String combine = entry.getValue();
			String[] sametermArr = ScreenUtil.getSameterm(combine);
			for (Entry<String, String> entry2 : historymap.entrySet()) {
				String combine2 = entry2.getValue();
				String [] combineArr = combine2.split(",");
				String[] intersectArr = ArrayTool.getIntersectArr(sametermArr, combineArr);
				if(intersectArr.length == 6){
					count ++;
				}
			}
			datamap.put(combine, count);
			if(count < 2){
				sum ++;
			}
		}	
		MapDataUtil.createScreenTxtMap(datamap, "drawsameterm");
		System.out.println(sum);
	}
	private static void sametermAndperterm() {
		String [] periodArr = {"001","002","003","004","005","006","007","008","009","010",
				"011","012","013","014","015","016","017","018","019","020","021","022",
				"023","024","025","026","027","028","029","030","031","032","033","034",
				"035","036","037","038","039","040","041","042","043","044","045","046",
				"047","048","049","050","051","052","053","054","055","056","057","058",
				"059","060","061","062","063","064","065","066","067","068","069","070",
				"071","072","073","074","075","076","077","078","079","080","081","082",
				"083","084","085","086","087","088","089","090","091","092","093","094",
				"095","096","097","098","099","100","101","102","103","104","105","106",
				"107","108","109","110","111","112","113","114","115","116","117","118",
				"119","120","121","122","123","124","125","126","127","128","129","130",
				"131","132","133","134","135","136","137","138","139","140","141","142",
				"143","144","145","146","147","148","149","150","151","152","153","154"};
		String [] termArr = {"2019","2018","2017","2016","2015",
				"2014","2013","2012","2011","2010","2009","2008",
				"2007","2006","2005","2004"};
		for (int i = 0; i < termArr.length; i++) {
			for (int j = 0; j < periodArr.length; j++) {
				String period = "000";
				if(j != 0){
					period = i+periodArr[j-1];
				}
			}
		}
		
	}
	/**
	 * 上一期数据分析
	 */
	private static void perterm() {
		int count0 = 0;
		int count1 = 0;
		int count5 = 0;
		int count6 = 0;
		String [] periodArr = {"001","002","003","004","005","006","007","008","009","010",
				"011","012","013","014","015","016","017","018","019","020","021","022",
				"023","024","025","026","027","028","029","030","031","032","033","034",
				"035","036","037","038","039","040","041","042","043","044","045","046",
				"047","048","049","050","051","052","053","054","055","056","057","058",
				"059","060","061","062","063","064","065","066","067","068","069","070",
				"071","072","073","074","075","076","077","078","079","080","081","082",
				"083","084","085","086","087","088","089","090","091","092","093","094",
				"095","096","097","098","099","100","101","102","103","104","105","106",
				"107","108","109","110","111","112","113","114","115","116","117","118",
				"119","120","121","122","123","124","125","126","127","128","129","130",
				"131","132","133","134","135","136","137","138","139","140","141","142",
				"143","144","145","146","147","148","149","150","151","152","153","154"};
		String [] termArr = {"2019","2018","2017","2016","2015",
				"2014","2013","2012","2011","2010","2009","2008",
				"2007","2006","2005","2004"};
		Map<String, String> historymap = HistoryUtil.getPeriodHistoryMap();
		for (int i = 2003; i < 2020; i++) {
			Map<String, Integer> datamap = new HashMap<String, Integer>();
			for (int j = 0; j < periodArr.length; j++) {
				String curperiod = i+periodArr[j];
				String perperiod = "000";
				if(j != 0){
					perperiod = i+periodArr[j-1];
				}
				String curdraw = historymap.get(curperiod);
				String perdraw = historymap.get(perperiod);
				int samecount = 0;
				if(StringUtils.isNotEmpty(perdraw) && StringUtils.isNotEmpty(curdraw)){
					String[] perdrawArr = perdraw.split(",");
					String[] sametermArr = ScreenUtil.getSameterm(curdraw);
					String[] intersectArr = ArrayTool.getIntersectArr(sametermArr, perdrawArr);
					samecount = intersectArr.length;
				}
				String result = curperiod +" 期 ："+ curdraw +" 上一期 "+perperiod + " " +perdraw +" 同尾号比较结果 "+samecount;
				if(samecount == 0){
					count0 ++;
				}
				if(samecount == 1){
					count1 ++;
				}
				if(samecount == 5){
					count5 ++;
				}
				if(samecount == 6){
					count6 ++;
				}
				datamap.put(result, null);
			}
			MapDataUtil.createScreenTxtMap(datamap, i+"");
		}
		System.out.println(count0);
		System.out.println(count1);
		System.out.println(count5);
		System.out.println(count6);
	}
	/**
	 * 同尾号数据分析
	 */
	private static void sameterm() {
		int count0 = 0;
		int count5 = 0;
		int count6 = 0;
		String [] termArr = {"2019","2018","2017","2016","2015",
				"2014","2013","2012","2011","2010","2009","2008",
				"2007","2006","2005","2004"};
		Map<String, String> historymap = HistoryUtil.getPeriodHistoryMap();
		for (int i = 1; i < 155; i++) {
			String period = i+"";
			if(i<10){
				period = "00"+i;
			}
			if(i>9 && i<100){
				period = "0"+i;
			}
			Map<String, String> periodmap = new HashMap<String, String>();
			for (int j = 0; j < termArr.length; j++) {
				
				String key = termArr[j]+period;
				String value = historymap.get(key);
				if(StringUtils.isNotEmpty(value)){
					periodmap.put(key, value);
				}
			}
			Map<String, Integer> datamap = new HashMap<String, Integer>();
			for (int j = 0; j < termArr.length; j++) {
				String curperiod = termArr[j]+period;
				String perperiod = (Integer.parseInt(termArr[j])-1)+period;
				String curdraw = periodmap.get(curperiod);
				String perdraw = periodmap.get(perperiod);
				int samecount = 0;
				if(StringUtils.isNotEmpty(perdraw) && StringUtils.isNotEmpty(curdraw)){
					String[] perdrawArr = perdraw.split(",");
					String[] sametermArr = ScreenUtil.getSameterm(curdraw);
					String[] intersectArr = ArrayTool.getIntersectArr(sametermArr, perdrawArr);
					samecount = intersectArr.length;
				}
				
				String result = curperiod +" 期 ："+ curdraw +" 同期 "+perperiod + " " +perdraw +" 同尾号比较结果 "+samecount;
				if(samecount == 0){
					count0 ++;
				}
				if(samecount == 5){
					count5 ++;
				}
				if(samecount == 6){
					count6 ++;
				}
				datamap.put(result, null);
			}
			MapDataUtil.createScreenTxtMap(datamap, period);
		}
		
		System.out.println(count0);
		System.out.println(count5);
		System.out.println(count6);
		
	}
	
}
