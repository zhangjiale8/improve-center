package com.zjl.lottery.doubleball.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;

import com.zjl.lottery.doubleball.util.HistoryUtil;
import com.zjl.lottery.doubleball.util.ScreenUtil;
import com.zjl.lottery.util.MapDataUtil;
import com.zjl.tools.ArrayTool;

public class TestApp {
	public static void main(String[] args) {
		String filename = "history";
		Map<String, Integer> datamap =  HistoryUtil.getHistoryMap();
		Map<String, Integer> resultmap = new HashMap<String, Integer>();
		if(null != datamap && datamap.size() > 0 && StringUtils.isNotEmpty(filename)) {
			int sum0 = 0;
			int sum1 = 0;
			int sum2 = 0;
			int sum3 = 0;
			for (Entry<String, Integer> entry : datamap.entrySet()) {
				String combine = entry.getKey();
				String[] combineArr = combine.split(",");
				int[] intcombineArr = ArrayTool.strArr2InArr(combineArr);
				int count = ScreenUtil.countSametails(intcombineArr);
				resultmap.put(combine+"||"+count, entry.getValue());
				if(0 == count) {
					sum0++;
				}else if(1 == count) {
					sum1++;
				}else if(2 == count) {
					sum2++;
				}else if(3 == count) {
					sum3++;
				}
			}
			System.out.println(sum0);
			System.out.println(sum1);
			System.out.println(sum2);
			System.out.println(sum3);
		}
		//MapDataUtil.createScreenTxtMap(resultmap, filename+"sametails");
	}
}
