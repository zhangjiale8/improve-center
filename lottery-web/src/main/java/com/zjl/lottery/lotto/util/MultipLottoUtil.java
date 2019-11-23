package com.zjl.lottery.lotto.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.zjl.lottery.util.CombineUtil;
import com.zjl.lottery.util.MapDataUtil;
import com.zjl.tools.ArrayTool;

public class MultipLottoUtil {

	public static void screenDetermined(ArrayList<int[]> screenlist, int[] screenarray) {
		Map<String, Integer> lottoallcombine = CombineUtil.getLottoCombineMap();
		Map<String, Integer> combinemaps = new HashMap<String,Integer>();
		Map<String, Integer> resultmap = new HashMap<String,Integer>();
		for (int[] combineArr : screenlist) {
			Map<String, Integer> combinemap = CombineUtil.getCombineMap(combineArr, 5);
			for (Entry<String, Integer> entry : combinemap.entrySet()) {
				String combine = entry.getKey();
				int count = null == combinemaps.get(combine)?0:combinemaps.get(combine);
				combinemaps.put(combine, count+1);
			} 
		}
		for (Entry<String, Integer> entry : lottoallcombine.entrySet()) {
			String combine = entry.getKey();
			boolean contain = combinemaps.containsKey(combine);
			if(!contain) {
				String[] combineArr = combine.split(",");
				String[] screenArr = ArrayTool.intArr2StrArr(screenarray);
				String[] intersectArr = ArrayTool.getIntersectArr(screenArr , combineArr);
				if(intersectArr.length > 2) {
					for (int[] perscreenArr : screenlist) {
						String[] combinestrArr = ArrayTool.intArr2StrArr(perscreenArr);
						String[] sameArr = ArrayTool.getIntersectArr(combineArr, combinestrArr);
						if(null != sameArr && sameArr.length > 0) {
							resultmap.put(entry.getKey(), entry.getValue());
						}
					}
				}
			}
		}
		MapDataUtil.createScreenTxtMap(resultmap, "lottoscreen");
	}

}
