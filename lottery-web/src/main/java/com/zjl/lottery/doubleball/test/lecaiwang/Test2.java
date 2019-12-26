package com.zjl.lottery.doubleball.test.lecaiwang;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.zjl.lottery.doubleball.util.HistoryUtil;
import com.zjl.lottery.doubleball.util.ScreenUtil;
import com.zjl.lottery.util.MapDataUtil;
import com.zjl.tools.ArrayTool;

public class Test2 {
	public static void main(String[] args) {


		String [] filenameArr = {
				"resultmapdeterminedclude12",
				"resultmapdeterminedunclude12"			
				};

		String screenfilepath = "E:" + File.separator + "screen" + File.separator +"2019149.txt";
		Map<String, Integer> screenmap = MapDataUtil.getDataMap(screenfilepath);
		for (String filename : filenameArr) {
			Map<String, Integer> resultmap = new HashMap<String, Integer>();
			String filepath = "E:" + File.separator + "screen" + File.separator +filename+".txt";;
			Map<String, Integer> datamap = MapDataUtil.getDataMap(filepath);
			for (Entry<String, Integer> dataentry : datamap.entrySet()) {
				String combine = HistoryUtil.recombination(dataentry.getKey());
				int draw1 = drawmin1(combine,screenmap);
				int draw6 = drawmax6(combine,screenmap);
				if((draw1<4) && (draw6 > 27 && draw6 <46)){
					resultmap.put(dataentry.getKey(), dataentry.getValue());
				}

			}
			resultmap = ScreenUtil.screensametails(resultmap);
			MapDataUtil.createScreenTxtMap(resultmap, filename+"3");
		}


	}
	
	private static int drawmax6(String draw, Map<String, Integer> datamap) {
		int result = 0;
		for (Entry<String, Integer> entry : datamap.entrySet()) {
			String[] screenArr = entry.getKey().split(",");
			String[] combineArr = draw.split(",");
			String[] intersectArr = ArrayTool.getIntersectArr(screenArr, combineArr);
			if(intersectArr.length >5) {
				result ++;
			}
		}
		return result;
		
	}

	private static int drawmin1(String draw, Map<String, Integer> datamap) {
		int result = 0;
		for (Entry<String, Integer> entry : datamap.entrySet()) {
			String[] screenArr = entry.getKey().split(",");
			String[] combineArr = draw.split(",");
			String[] intersectArr = ArrayTool.getIntersectArr(screenArr, combineArr);
			if(intersectArr.length <2) {
				result ++;
			}
		}
		return result;
		
	}
}
