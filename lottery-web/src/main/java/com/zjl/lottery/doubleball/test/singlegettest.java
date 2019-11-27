package com.zjl.lottery.doubleball.test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.zjl.lottery.util.CombineUtil;
import com.zjl.lottery.util.MapDataUtil;
import com.zjl.tools.ArrayTool;

public class singlegettest {
	public static void main(String[] args) {

		Map<String, Integer> combinemap = new HashMap<String, Integer>();
		List<int []> singlelist = new ArrayList<int []>();
		Map<String, Integer> singlecombinemap = new HashMap<String, Integer>();
		String filename = "sceenlist";
		String filepath = "E:" + File.separator + "screen" + File.separator +filename+".txt";;
		Map<String, Integer> datamap = MapDataUtil.getDataMap(filepath);
		for (Entry<String, Integer> entry : datamap.entrySet()) {
			String combinestr = entry.getKey();
			int[] combineArr = ArrayTool.strArr2InArr(combinestr.split(","));
			if(combineArr.length > 16) {
				singlelist.add(combineArr);
			}
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
		
		for (int[] paramArr : singlelist) {
			Map<String, Integer> datamaptemp = CombineUtil.getCombineMap(paramArr, 6);
			for (Entry<String, Integer> entry : datamaptemp.entrySet()) {
				String combinestr = entry.getKey();
				Integer count = combinemap.get(combinestr);
				if(count == 1) {
					singlecombinemap.put(combinestr, count);
				}
			}
		}
		
		MapDataUtil.createScreenTxtMap(singlecombinemap, "singlecombine");
	
	}
}
