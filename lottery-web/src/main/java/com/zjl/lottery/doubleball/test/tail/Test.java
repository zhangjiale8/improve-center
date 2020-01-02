package com.zjl.lottery.doubleball.test.tail;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.zjl.lottery.doubleball.util.HistoryUtil;
import com.zjl.lottery.util.MapDataUtil;
import com.zjl.tools.ArrayTool;

public class Test {
	public static void main(String[] args) {
		int tailmin3 = 0;
		int tailmin4 = 0;
		int tailmax6 = 0;
		Map<String, String> historymap =  HistoryUtil.getPeriodHistoryMap();
		Map<String, Integer> resultmap = new HashMap<String, Integer>();
		Map<String, Integer> tailsmap = new HashMap<String, Integer>();
		for (Entry<String, String> entry : historymap.entrySet()) {
			Map<String, Integer> tailmap =  new HashMap<String, Integer>();
			String[] drawstrarr = entry.getValue().split(",");
			int[] drawintarr = ArrayTool.strArr2InArr(drawstrarr);
			for (int i = 0; i < drawintarr.length; i++) {
				String tail = drawintarr[i] %10 +"";
				tailmap.put(tail, 1);
			}
			if(tailmap.size() <3) {
				tailmin3 ++;
			}
			if(tailmap.size() <4) {
				tailmin4 ++;
			}
			if(tailmap.size() >5) {
				tailmax6 ++;
			}
			String tailstr = "";
			for (Entry<String, Integer> tailentry : tailmap.entrySet()) {
				tailstr += tailentry.getKey()+",";
			}
			tailstr = tailstr.substring(0,tailstr.length() -1);
			String[] tailstrarr = tailstr.split(",");
			int[] tailintarr = ArrayTool.strArr2InArr(tailstrarr);
			ArrayTool.sort(tailintarr);
			String tailintstr = "";
			for (int i = 0; i < tailintarr.length; i++) {
				tailintstr += tailintarr[i]+",";
			}
			tailintstr = tailintstr.substring(0, tailintstr.length()-1);
			resultmap.put(entry.getKey()+" : "+tailintstr, null);
			Integer count = tailsmap.get(tailintstr);
			if(null != count) {
				count ++;
			}else {
				count = 1;
			}
			tailsmap.put(tailintstr, count);
		}
		System.out.println(tailmin3);
		System.out.println(tailmin4);
		System.out.println(tailmax6);
		MapDataUtil.createScreenTxtMap(tailsmap, "tailsmap");
		MapDataUtil.createScreenTxtMap(resultmap, "periodtailsmap");
		
	}
}
