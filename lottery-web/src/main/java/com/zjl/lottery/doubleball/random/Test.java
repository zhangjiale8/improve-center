package com.zjl.lottery.doubleball.random;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.zjl.lottery.doubleball.util.HistoryUtil;
import com.zjl.lottery.doubleball.util.TailUtil;
import com.zjl.lottery.util.MapDataUtil;
import com.zjl.tools.ArrayTool;
import com.zjl.tools.MapUtil;

public class Test {
	public static void main(String[] args) {
		String filePath = "E:" + File.separator + "screen" + File.separator +"initcombinedoubleball.txt";
		Map<String, Integer> datamap = MapDataUtil.getDataMap(filePath);
		Map<String, Integer> tailmap = TailUtil.getTailsStatisticsMap();
		Map<String, Integer> historymap = HistoryUtil.getHistoryMap();
		
		Map<String, Integer> resultmap = new HashMap<String, Integer>();
		MapUtil.mapCopy(datamap,resultmap);
		resultmap = historyscreen(resultmap,historymap);
		resultmap = tailscreen(resultmap,tailmap);
		String [] tails = {"3","5","1"};
		resultmap = tailscontaincreen1(resultmap,tails);
		String [] tails2 = {"2","6","5","8"};
		resultmap = tailscontaincreen(resultmap,tails2);
		
		if(null != resultmap && resultmap.size() > 0){
			MapDataUtil.createScreenTxtMap(resultmap, "currentrandomdoubleball");
		}
	}
	
	/**
	 * 尾数相同过滤1
	 * @param datamap
	 * @param tails
	 * @return
	 */
	private static Map<String, Integer> tailscontaincreen1(Map<String, Integer> datamap, String[] tails) {
		Map<String, Integer> resultmap = new HashMap<String, Integer>();
		for (Entry<String, Integer> entry : datamap.entrySet()) {
			 String combine = entry.getKey();
			 String[] combineArr = combine.split(",");
			 String tail = TailUtil.getTailsStr(combineArr);
			 String[] tailArr = tail.split(",");
			 String[] intersectArr = ArrayTool.getIntersectArr(tailArr, tails);
			 if(intersectArr.length > 0 && intersectArr.length <3){
				 resultmap.put(combine, entry.getValue());
			 }
		}

		return resultmap;
	}
	/**
	 * 尾数相同过滤
	 * @param datamap
	 * @param tails
	 * @return
	 */
	private static Map<String, Integer> tailscontaincreen(Map<String, Integer> datamap, String[] tails) {
		Map<String, Integer> resultmap = new HashMap<String, Integer>();
		for (Entry<String, Integer> entry : datamap.entrySet()) {
			 String combine = entry.getKey();
			 String[] combineArr = combine.split(",");
			 String tail = TailUtil.getTailsStr(combineArr);
			 String[] tailArr = tail.split(",");
			 String[] intersectArr = ArrayTool.getIntersectArr(tailArr, tails);
			 if(intersectArr.length > 0 && intersectArr.length <3){
				 resultmap.put(combine, entry.getValue());
			 }
		}

		return resultmap;
	}
	/**
	 * 历史数据过滤
	 * @param datamap
	 * @param tailmap
	 * @return
	 */
	private static Map<String, Integer> historyscreen(Map<String, Integer> datamap, Map<String, Integer> historymap) {

		Map<String, Integer> resultmap = new HashMap<String, Integer>();
		for (Entry<String, Integer> entry : datamap.entrySet()) {
			 String combine = entry.getKey();
			 Integer count = historymap.get(combine);
			 if(null == count){
				 resultmap.put(combine, entry.getValue());
			 }
		}

		return resultmap;
	
	}
	/**
	 * 尾数过滤
	 * @param resultmap
	 * @param tailmap
	 * @return
	 */
	private static Map<String, Integer> tailscreen(Map<String, Integer> datamap, Map<String, Integer> tailmap) {
		Map<String, Integer> resultmap = new HashMap<String, Integer>();
		for (Entry<String, Integer> entry : datamap.entrySet()) {
			 String combine = entry.getKey();
			 String[] combineArr = combine.split(",");
			 String tail = TailUtil.getTailsStr(combineArr);
			 String[] tailArr = tail.split(",");
			 Integer count = tailmap.get(tail);
			 if(null != count && tailArr.length > 3){
				 resultmap.put(combine, entry.getValue());
			 }
		}

		return resultmap;
	}
}
