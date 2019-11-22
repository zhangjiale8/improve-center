package com.zjl.lottery.doubleball.test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.zjl.lottery.util.CombineUtil;
import com.zjl.lottery.util.MapDataUtil;
import com.zjl.tools.ArrayTool;

public class mutipcombineTest {
	public static void main(String[] args) {
	//	int [] masterArr = {3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,22,23,25,26,27,29,30,31};
	//	int [] deputyArr = {1,2,19,20,21,24,28,32,33};
	//	int [] masterArr = {1,2,3,4,6,7,8,9,11,12,14,15,16,17,19,20,21,24,26,27,29,30,31,32,33};
		//int [] deputyArr = {5,10,13,18,22,23,25,28};
	//	mutipcombine(masterArr,deputyArr);
	//	samecombine();
		combineunclude();
	}

	private static void combineunclude() {
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
		String filepath = "E:" + File.separator + "screen" + File.separator +"samecombine.txt";;
		Map<String, Integer> samemap = MapDataUtil.getDataMap(filepath);
		for (String filename : filenameArr) {
			filename += "threescreen1234567891";
			filepath = "E:" + File.separator + "screen" + File.separator +filename+".txt";;
			Map<String, Integer> datamap = MapDataUtil.getDataMap(filepath);
			Map<String, Integer> resultmap = new HashMap<String, Integer>();
			for (Entry<String, Integer> entry : datamap.entrySet()) {
				String combine = entry.getKey();
				Integer count = samemap.get(combine);
				if(null != count) {
					resultmap.put(combine, entry.getValue());
				}
			}
			MapDataUtil.createScreenTxtMap(resultmap, filename+"2");
		}
		
	}

	private static void samecombine() {
		Map<String, Integer> combinemap = new HashMap<String, Integer>();
		String filepath = "E:" + File.separator + "screen" + File.separator +"combinemap001.txt";;
		Map<String, Integer> data1map = MapDataUtil.getDataMap(filepath);
		filepath = "E:" + File.separator + "screen" + File.separator +"combinemap002.txt";;
		Map<String, Integer> data2map = MapDataUtil.getDataMap(filepath);
		for (Entry<String, Integer> entry : data1map.entrySet()) {
			String combine = entry.getKey();
			Integer count = data2map.get(combine);
			if(null != count) {
				combinemap.put(combine, count);
			}
			
		}
		MapDataUtil.createScreenTxtMap(combinemap, "samecombine");
	}

	private static void mutipcombine(int[] masterArr, int[] deputyArr) {
		Map<String, Integer> combinemap = new HashMap<String, Integer>();
		ArrayList<String> masterList = CombineUtil.getScreenList(masterArr,5);
		ArrayList<String> deputyList = CombineUtil.getScreenList(deputyArr,2);
		for (int i = 0; i < masterList.size(); i++) {
			for (int j = 0; j < deputyList.size(); j++) {
				String combinestr = masterList.get(i)+","+deputyList.get(j);
				int[] combineArr = ArrayTool.strArr2InArr(combinestr.split(","));
				Arrays.sort(combineArr);
				ArrayList<String> combineList = CombineUtil.getScreenList(combineArr,6);
				for (int k = 0; k < combineList.size(); k++) {
					String combine = combineList.get(k);
					Integer count = combinemap.get(combine);
					if(null != count) {
						count ++;
					}else {
						count = 1;
					}
					combinemap.put(combine, count);
				}
			}
		}
		
		MapDataUtil.createScreenTxtMap(combinemap, "combinemap001");
		
	}
}
