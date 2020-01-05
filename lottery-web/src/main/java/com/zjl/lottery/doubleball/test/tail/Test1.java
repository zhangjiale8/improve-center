package com.zjl.lottery.doubleball.test.tail;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.zjl.lottery.doubleball.util.HistoryUtil;
import com.zjl.lottery.doubleball.util.TailUtil;

public class Test1 {
	public static void main(String[] args) {
		Map<String, String> periodtailsmap = TailUtil.getPeriodTailsMap();
		Map<String, String> historymap =  HistoryUtil.getPeriodHistoryMap();
		//Map<String, Integer> tailsmap = TailUtil.getTailsStatisticsMap();
		/*String[] comptails = {"23","1","2"};
		String [] tails = TailUtil.getTailsArry(comptails);
		int count = TailUtil.getCountSameTail(tails,comptails);
		System.out.println();*/
		for (int i = 2003; i < 2021; i++) {
			String period =  i + "003";
			String tails = periodtailsmap.get(period);
			String pretails = periodtailsmap.get((i-1) + "003");
			int same = 0;
			if(StringUtils.isNotEmpty(tails) && StringUtils.isNotEmpty(pretails)){
				String[] tailsarr = tails.split(",");
				String[] comptailsarr = pretails.split(",");
				same = TailUtil.getCountSameTail(tailsarr,comptailsarr);

			}
			System.out.println(period+":"+historymap.get(period)+"@"+tails+"--------" +same );
		}
	}
}
