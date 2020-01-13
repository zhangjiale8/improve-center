package com.zjl.lottery.doubleball.test.newdemo;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;

import com.zjl.lottery.util.MapDataUtil;


public class Selection {
	public static void main(String[] args) {
	//	pingtotal();
		randomaward();
	}
	
	/**
	 * 组装所有
	 * @param:       
	 * @return: void      
	 */
	private static void pingtotal() {
		String [] filenameArr = {
				"resultmapdeterminedclude",
				"resultmapdeterminedunclude"			
				};
		Map<String, Integer> totalmap = new HashMap<String, Integer>();
		for (String filename : filenameArr) {
			filename += "";
			String filepath = "E:" + File.separator + "screen" + File.separator +filename+".txt";;
			Map<String, Integer> datamap = MapDataUtil.getDataMap(filepath);
			for (Entry<String, Integer> entry : datamap.entrySet()) {
				totalmap.put(entry.getKey(), entry.getValue());
			}
		}
		MapDataUtil.createScreenTxtMap(totalmap, "pingtotal");
	}
	
	//随机选取
		private static void randomaward() {
			String filepath = "E:" + File.separator + "screen" + File.separator +"niucaiwang20combinemaps.txt";;
			Map<String, Integer> datamap = MapDataUtil.getDataMap(filepath);
			List<String> initlist = new ArrayList<String>();
			for (Entry<String, Integer> entry : datamap.entrySet()) {
					initlist.add(entry.getKey());
			}
			Map<String, Integer> firstdraw = new HashMap<String, Integer>();
			Map<String, Integer> randommap = new HashMap<String, Integer>();
			String data = "";
			for (int i = 0; i < 1; i++) {
				double random = (double) ((Math.random()*9+1)*1000)/10000;
				int index = Integer.parseInt(new java.text.DecimalFormat("0").format(random*initlist.size()));
				String draw = initlist.get(index);
				System.out.println(draw);
				randommap.put(draw, null);
				if(StringUtils.isNotEmpty(draw)){
					String [] drawArr = draw.split(",");
					for (int j = 0; j < drawArr.length; j++) {
						firstdraw.put(drawArr[j], null);
					}
				}
				data += ","+draw;
			}		
		//	MapDataUtil.createScreenTxtMap(randommap, "1000-10");

		}
}
