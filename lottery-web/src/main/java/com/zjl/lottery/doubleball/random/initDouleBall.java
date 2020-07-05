package com.zjl.lottery.doubleball.random;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;

import com.zjl.lottery.doubleball.util.HistoryUtil;
import com.zjl.lottery.util.CombineUtil;
import com.zjl.lottery.util.MapDataUtil;
import com.zjl.tools.ArrayTool;

public class initDouleBall {
	public static void main(String[] args) {

		Map<String, Integer> result = new HashMap<String, Integer>();
		//int[] paramArr = {3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,22,23,25,26,27,29,30,31};
		int[] paramArr = {1,4,10,30};
		List<String> list1 = CombineUtil.getScreenList(paramArr , 4);
	//	int[] paramArr2 = {1,2,19,20,21,24,28,32,33};
		int[] paramArr2 = {2,4,5,6,13,14,19,22,23,25,26,27,28,29,33};
		List<String> list2 = CombineUtil.getScreenList(paramArr2  , 2);
		for (String bine1 : list1) {
			for (String bine2 : list2) {
				if(StringUtils.isNotEmpty(bine1)&& StringUtils.isNotEmpty(bine2)){
					String temp = bine1+","+bine2;
					String [] tempArr = temp.split(",");
					int [] tempIntArr = ArrayTool.strArr2InArr(tempArr);
					tempIntArr = ArrayTool.sort(tempIntArr);
					String combine = Arrays.toString(tempIntArr);
					combine = combine.substring(1, combine.length()-1);
					result.put(combine, 1);
				}
			}
		}
	
		Map<String, Integer> historymap = HistoryUtil.getHistoryMap();
		Map<String, Integer> combinemap = new HashMap<String, Integer>();
		int sum6 = 0;
		for (Entry<String, Integer> entry : result.entrySet()) {
			 String temp = entry.getKey();
			 String [] tempArr = temp.split(",");
			 int [] tempIntArr = ArrayTool.strArr2InArr(tempArr);
			 ArrayTool.sort(tempIntArr);
			 List<String> combinelist = CombineUtil.getScreenList(tempIntArr , 6);
			 for (String combine : combinelist) {
				 Integer count = historymap.get(combine);
				 if(null != count && null == combinemap.get(combine)){
					 sum6 ++;
				 }
				 combinemap.put(combine, 1);
			}
        }
		 
		if(null != combinemap && combinemap.size() > 0){
			MapDataUtil.createScreenTxtMap(combinemap, "initcombinedoubleball");
		}
	
	
	}

}
