package com.zjl.lottery.doubleball.test.tail;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;

import com.zjl.lottery.doubleball.util.HistoryUtil;
import com.zjl.lottery.util.MapDataUtil;
import com.zjl.tools.ArrayTool;

public class Test {
	public static void main(String[] args) {
		int tailmin3 = 0;
		int tailmin4 = 0;
		int tailmax6 = 0;
		int max5 = 0;
		int min2 = 0;
		Map<String, String> historymap =  HistoryUtil.getPeriodHistoryMap();
		Map<String, Integer> resultmap = new HashMap<String, Integer>();
		Map<String, String> periodtailsmap = new HashMap<String, String>();
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
			periodtailsmap.put(entry.getKey(), tailintstr);
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
		Map<String, Integer> tailsmap2 = new HashMap<String, Integer>();
		Map<String, Integer> tailsmap22 = new HashMap<String, Integer>();
		
		for (Entry<String, Integer> entry : tailsmap.entrySet()) {
			if(entry.getKey().length() == 11){
				for(Map.Entry<String, String> vo : periodtailsmap.entrySet()){
				    if(vo.getValue().equals(entry.getKey())){
				        String period = vo.getKey();
				        String year = period.substring(0, 4);
				        int term = Integer.parseInt(period.substring(4, period.length()));
				        String nextperiod = "";
				        if(term <9){
				        	nextperiod = year+"00"+(term+1);
				        }else if(term >9 && term <99){
				        	nextperiod = year+"0"+(term+1);
				        }else{
				        	nextperiod = year+(term+1);
				        }
				        String nexttail = periodtailsmap.get(nextperiod);
				        if(StringUtils.isEmpty(nexttail)){
				        	nextperiod = (Integer.parseInt(year)+1)+"001";
				        	nexttail = periodtailsmap.get(nextperiod);
				        }
				        int sametailcount = 0;
				        if(StringUtils.isNotEmpty(entry.getKey()) && StringUtils.isNotEmpty(nexttail)){
				        	String [] tailarr = entry.getKey().split(",");
				        	String [] tailarr2 = nexttail.split(",");
							String[] intersectArr = ArrayTool.getIntersectArr(tailarr, tailarr2);
							sametailcount = intersectArr.length;

				        }
				        if(sametailcount <2){
				        	min2++;
				        }
				        if(sametailcount >4){
				        	max5++;
				        }
				        tailsmap22.put(period+":"+entry.getKey() + "----------"+nextperiod+":"+nexttail +"------------"+sametailcount, null);
				    }
			    }
		
			}
		}
		System.out.println(min2);
		System.out.println(max5);
		MapDataUtil.createScreenTxtMap(tailsmap22, "tailsmap3");
	//	MapDataUtil.createScreenTxtMap(resultmap, "periodtailsmap");
		
	}
}
