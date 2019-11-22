package com.zjl.lottery.doubleball.test;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.zjl.lottery.util.ListTxtUtil;
import com.zjl.lottery.util.MapTxtUtil;
import com.zjl.tools.ArrayTool;

public class FoolTest {
	public static void main(String[] args) {
		singlescreen();
	//	multipscreen();
	}
	
	/**
	 * 单组过滤
	 * @param:       
	 */
	private static void singlescreen() {

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
		//int[] screenIntArr = {3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,22,23,25,26,27,29,30,31};
		int[] screenIntArr = {10,17,20,32,21,24};
		String[] screenArr = ArrayTool.intArr2StrArr(screenIntArr);
		for (String filename : filenameArr) {
			filename += "threescreen123456789123";
			String filepath = "E:" + File.separator + "screen" + File.separator +filename+".txt";;
			Map<String, Integer> datamap = MapTxtUtil.getDataMap(filepath);
			Map<String, Integer> resultmap = new HashMap<String, Integer>();
			for (Entry<String, Integer> entry : datamap.entrySet()) {
				String[] combineArr = entry.getKey().split(",");
				String[] intersectArr = ArrayTool.getIntersectArr(screenArr, combineArr);
				if(intersectArr.length <1) {
					resultmap.put(entry.getKey(), entry.getValue());
				}
				
			}
			MapTxtUtil.createScreenTxtMap(resultmap, filename+"4");
		}
		
	}
	/**
	 * 多组过滤
	 * @param:       
	 */
	private static void multipscreen() {

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
		Map<String, Integer> screenmap = new HashMap<String, Integer>();
		String screenfilepath = "E:" + File.separator + "screen" + File.separator +"sceenlist.txt";;
		List<String[]> screenarrlist = ListTxtUtil.getScreenList(screenfilepath);
		for (String filename : filenameArr) {
			filename += "threescreen123456789";
			String filepath = "E:" + File.separator + "screen" + File.separator +filename+".txt";;
			Map<String, Integer> datamap = MapTxtUtil.getDataMap(filepath);
			for (Entry<String, Integer> entry : datamap.entrySet()) {
				for (String[] screenArr : screenarrlist) {
					String[] combineArr = entry.getKey().split(",");
					String[] intersectArr = ArrayTool.getIntersectArr(screenArr, combineArr);
					if(intersectArr.length ==6) {
						screenmap.put(entry.getKey(), entry.getValue());
					}
				}
			}
		}
		
		for (String filename : filenameArr) {
			filename += "threescreen123456789";
			String filepath = "E:" + File.separator + "screen" + File.separator +filename+".txt";;
			Map<String, Integer> datamap = MapTxtUtil.getDataMap(filepath);
			Map<String, Integer> datamaptemp = new HashMap<String, Integer>();
			mapCopy(datamap,datamaptemp);
			for (Entry<String, Integer> entry : datamaptemp.entrySet()) {
				Integer count = screenmap.get(entry.getKey());
				if(null != count){
					datamap.remove(entry.getKey());
				}
			}
			MapTxtUtil.createScreenTxtMap(datamap, filename+"1");
		}
		
		
	}
	
	/**
	 * 复制map对象
	 * @explain 将paramsMap中的键值对全部拷贝到resultMap中；
	 * paramsMap中的内容不会影响到resultMap（深拷贝）
	 * @param paramsMap
	 *     被拷贝对象
	 * @param resultMap
	 *     拷贝后的对象
	 */
	public static void mapCopy(Map paramsMap, Map resultMap) {
	    if (resultMap == null) resultMap = new HashMap();
	    if (paramsMap == null) return;

	    Iterator it = paramsMap.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry entry = (Map.Entry) it.next();
	        Object key = entry.getKey();
	        resultMap.put(key, paramsMap.get(key) != null ? paramsMap.get(key) : "");

	    }
	}
}
