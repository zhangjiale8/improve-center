package com.zjl.lottery.doubleball.test.wangcai;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.zjl.lottery.doubleball.util.MultipParamsListUtil;
import com.zjl.lottery.util.ListDataUtil;
import com.zjl.lottery.util.MapDataUtil;
import com.zjl.tools.ArrayTool;

public class Test20_02 {

	public static void main(String[] args) {

		ArrayList<int[]> list20 = new ArrayList<int[]>();
		String filepath = "E:" + File.separator + "screen" + File.separator+ "wangcai" + File.separator +"20.txt";
		List<String[]> combinelist = ListDataUtil.getScreenList(filepath);
		for (String[] combinearr : combinelist) {
			int[] combine = ArrayTool.strArr2InArr(combinearr);
			list20.add(combine);
		}
		
		Map<String, Integer> combinemaps20 = new HashMap<String,Integer>();
		for (int[] conbineArr : list20) {
			Map<String, Integer> combinemap = MultipParamsListUtil.getScreenMap(conbineArr);
			for (Entry<String, Integer> entry : combinemap.entrySet()) {
				String combine = entry.getKey();
				int count = null == combinemaps20.get(combine)?0:combinemaps20.get(combine);
				combinemaps20.put(combine, count+1);
			} 
		}
		
		MapDataUtil.createScreenTxtMap(combinemaps20, "wangcai20map");

	}


}
