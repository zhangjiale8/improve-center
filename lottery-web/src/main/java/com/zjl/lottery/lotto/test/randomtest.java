package com.zjl.lottery.lotto.test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;

import com.zjl.lottery.util.MapDataUtil;

public class randomtest {
	public static void main(String[] args) {

		String filepath = "E:" + File.separator + "screen" + File.separator +"lottoscreenthreescreenscreenhistory123456789123.txt";;
		Map<String, Integer> datamap = MapDataUtil.getDataMap(filepath);
		List<String> initlist = new ArrayList<String>();
		for (Entry<String, Integer> entry : datamap.entrySet()) {
			initlist.add(entry.getKey());
		}
		Map<String, Integer> firstdraw = new HashMap<String, Integer>();
		String data = "";
		for (int i = 0; i < 3; i++) {
			double random = (double) ((Math.random()*9+1)*1000)/10000;
			int index = Integer.parseInt(new java.text.DecimalFormat("0").format(random*initlist.size()));
			String draw = initlist.get(index);
			System.out.println(draw);
			if(StringUtils.isNotEmpty(draw)){
				String [] drawArr = draw.split(",");
				for (int j = 0; j < drawArr.length; j++) {
					firstdraw.put(drawArr[j], 1);
				}
			}
			data += ","+draw;
		}
	//	System.out.println(data);
		
	
	}
}
