package com.zjl.lottery.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;

import com.zjl.lottery.util.HistoryUtil;
import com.zjl.lottery.util.MapTxtUtil;
import com.zjl.lottery.util.ScreenUtil;
import com.zjl.tools.ArrayTool;

public class TestApp {
	public static void main(String[] args) {
		String filename = "history";
		Map<String, Integer> datamap =  HistoryUtil.getHistoryMap();
		Map<String, Integer> resultmap = new HashMap<String, Integer>();
		if(null != datamap && datamap.size() > 0 && StringUtils.isNotEmpty(filename)) {
			for (Entry<String, Integer> entry : datamap.entrySet()) {
				String combine = entry.getKey();
				String[] combineArr = combine.split(",");
				int[] intcombineArr = ArrayTool.strArr2InArr(combineArr);
				int count = ScreenUtil.countSametails(intcombineArr);
				resultmap.put(combine+"||"+count, entry.getValue());
			}
		}
		MapTxtUtil.createScreenTxtMap(resultmap, filename+"sametails");
	}
}
