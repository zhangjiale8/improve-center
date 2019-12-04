package com.zjl.lottery.doubleball;

import java.util.Map;
import java.util.Map.Entry;

import com.zjl.lottery.doubleball.util.HistoryUtil;

class Test {
	public static void main(String[] args) {
		Map<String, Integer> historymap =  HistoryUtil.getHistoryMap();
		int doublecountmin2 = 0;
		int singlecountmin2 = 0;
		for (Entry<String, Integer> entry : historymap.entrySet()) {
			String[] combinestrArr = entry.getKey().split(",");
			int doublecount = 0;
			int singlecount = 0;
			for (int i = 0; i < combinestrArr.length; i++) {
				int postion = Integer.parseInt(combinestrArr[i]);
				if(postion % 2 == 0) {
					doublecount ++;
				}else {
					singlecount ++;
				}
				
				
			}
			
			if(singlecount <2) {
				singlecountmin2 ++;
			}
			
			if(doublecount <2) {
				doublecountmin2 ++;
			}
			
		}
		System.out.println(doublecountmin2);
		System.out.println(singlecountmin2);
	}
}
