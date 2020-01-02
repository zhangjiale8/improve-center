package com.zjl.lottery.doubleball.test.singledouble;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.zjl.lottery.doubleball.util.HistoryUtil;
import com.zjl.tools.ArrayTool;

public class Test {

	public static void main(String[] args) {
		int singlemin2 = 0;
		int doublemin2 = 0;
		Map<String, String> historymap =  HistoryUtil.getPeriodHistoryMap();
		for (Entry<String, String> entry : historymap.entrySet()) {
			String[] combinestrArr = entry.getValue().split(",");
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
			
			if((singlecount <1)) {
				singlemin2 ++;
			}
			
			if((doublecount <1)) {
				doublemin2++;
			}
			
		}
		System.out.println(singlemin2);
		System.out.println(doublemin2);
	}

}
