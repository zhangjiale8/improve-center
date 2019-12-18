package com.zjl.lottery.doubleball.test.lecaiwang;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.zjl.lottery.doubleball.util.HistoryUtil;
import com.zjl.lottery.util.MapDataUtil;
import com.zjl.tools.ArrayTool;

public class Test {
	public static void main(String[] args) {


		String [] filenameArr = {
				"resultmapdeterminedcludehistorycludeotherticketclude",
				"resultmapdeterminedcludehistorycludeotherticketunclude",
				"resultmapdeterminedcludehistoryuncludeotherticketclude",
				"resultmapdeterminedcludehistoryuncludeotherticketunclude",
				"resultmapdetermineduncludehistorycludeotherticketclude",
				"resultmapdetermineduncludehistorycludeotherticketunclude",
				"resultmapdetermineduncludehistoryuncludeotherticketclude",
				"resultmapdetermineduncludehistoryuncludeotherticketunclude"
				};

		String screenfilepath = "E:" + File.separator + "screen" + File.separator +"2019145.txt";
		Map<String, Integer> screenmap = MapDataUtil.getDataMap(screenfilepath);
		for (String filename : filenameArr) {
			filename += "threescreen12";
			Map<String, Integer> resultmap = new HashMap<String, Integer>();
			String filepath = "E:" + File.separator + "screen" + File.separator +filename+".txt";;
			Map<String, Integer> datamap = MapDataUtil.getDataMap(filepath);
			for (Entry<String, Integer> dataentry : datamap.entrySet()) {
				String combine = HistoryUtil.recombination(dataentry.getKey());
				int draw1 = drawmin1(combine,screenmap);
				int draw6 = drawmax6(combine,screenmap);
				if((draw1 >0 && draw1<3) && (draw6 > 27 && draw6 <46)){
					resultmap.put(dataentry.getKey(), dataentry.getValue());
				}

			}
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
