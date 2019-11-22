package com.zjl.lottery.doubleball.util;

import java.util.Map;
import java.util.Map.Entry;

import com.zjl.lottery.util.MapDataUtil;
import com.zjl.tools.ArrayTool;

public class TempUtil {
	/**
	 * 校验购买德实体票与实际开奖是否超过4个
	 */
	public static void checkBuyActualBeyondFour() {
		Map<String, Integer> buymap = DobuleMapDataUtil.getOtherTickets();
		Map<String, Integer> historymap = HistoryUtil.getHistoryMap();
		int total = 0;
		for (Entry<String, Integer> historyentry : historymap.entrySet()) {
			String history = historyentry.getKey();
			int max = 0;
			for (Entry<String, Integer> buyentry : buymap.entrySet()) {
				int nums = 0;
				String buy = buyentry.getKey();
				String[] historyArr = history.split(",");
				String[] buyArr = buy.split(",");
				for (int i = 0; i < historyArr.length; i++) {
					String temp = historyArr[i];
					boolean flg = ArrayTool.isContains(temp, buyArr);
					if(flg){
						nums ++;
					}
				}
				if(nums > max){
					max = nums;
				}
			}
			if(max > 4){
				total ++;
			}
		}
		
		System.out.println(total);
		System.out.println(historymap.size() - total);
		
	}
	/**
	 * 校验本次开奖与历史开奖是否超过4个
	 */
	public static void checkHistoryCompareBeyondFour() {
		Map<String, Integer> historymap = HistoryUtil.getHistoryMap();
		int total = 0;
		for (Entry<String, Integer> historyentry : historymap.entrySet()) {
			String history = historyentry.getKey();
			int max = 0;
			for (Entry<String, Integer> history2entry : historymap.entrySet()) {
				int nums = 0;
				String buy = history2entry.getKey();
				String[] historyArr = history.split(",");
				String[] buyArr = buy.split(",");
				for (int i = 0; i < historyArr.length; i++) {
					String temp = historyArr[i];
					boolean flg = ArrayTool.isContains(temp, buyArr);
					if(flg){
						nums ++;
					}
				}
				if(nums > max && nums < 6){
					max = nums;
				}
			}
			if(max > 4){
				total ++;
			}
		}
		
		System.out.println(total);
		System.out.println(historymap.size() - total);
		
	}

}
