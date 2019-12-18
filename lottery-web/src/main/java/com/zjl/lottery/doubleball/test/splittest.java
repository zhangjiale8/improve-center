package com.zjl.lottery.doubleball.test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.zjl.lottery.util.MapDataUtil;

public class splittest {
	public static void main(String[] args) {
		Map<String, Integer> datamaptemp = new HashMap<String, Integer>();
		String filename = "splitlist";
		String filepath = "E:" + File.separator + "screen" + File.separator +filename+".txt";;
		Map<String, Integer> datamap = MapDataUtil.getDataMap(filepath);
		for (Entry<String, Integer> entry : datamap.entrySet()) {
			String temp = "";
			String combine = entry.getKey();
			for (int i = 0; i < combine.length(); i++) {
				if(i%2 == 1) {
					char ch1=combine.charAt(i-1);
					char ch2=combine.charAt(i);
					temp += ch1+"" + ch2+",";
				}
			}
			if(temp.length() > 2 ) {
				temp = temp.substring(0, temp.length()-1);
				datamaptemp.put(temp, null);
			}
		}
		MapDataUtil.createScreenTxtMap(datamaptemp, filename);
	}
}
