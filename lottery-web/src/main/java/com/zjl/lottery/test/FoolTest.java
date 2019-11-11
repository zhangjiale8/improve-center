package com.zjl.lottery.test;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.zjl.lottery.util.ListTxtUtil;
import com.zjl.lottery.util.MapTxtUtil;
import com.zjl.tools.ArrayTool;

public class FoolTest {
	public static void main(String[] args) {
		singlescreen();
		//multipscreen();
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
		int[] screenIntArr = {16,19,21,28,32,33,12,15,24,4,25,29,3,30,22};
		String[] screenArr = ArrayTool.intArr2StrArr(screenIntArr);
		for (String filename : filenameArr) {
			filename += "threescreen123456789123456789123456789123456789123456789123456789123456789123456789123456789"
					+ "123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789";
			String filepath = "E:" + File.separator + "screen" + File.separator +filename+".txt";;
			Map<String, Integer> datamap = MapTxtUtil.getDataMap(filepath);
			Map<String, Integer> resultmap = new HashMap<String, Integer>();
			for (Entry<String, Integer> entry : datamap.entrySet()) {
				String[] combineArr = entry.getKey().split(",");
				String[] intersectArr = ArrayTool.getIntersectArr(screenArr, combineArr);
				if(intersectArr.length <6) {
					resultmap.put(entry.getKey(), entry.getValue());
				}
				
			}
			MapTxtUtil.createScreenTxtMap(resultmap, filename+"2");
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
		String screenfilepath = "E:" + File.separator + "screen" + File.separator +"sceenlist.txt";;
		List<String[]> screenarrlist = ListTxtUtil.getScreenList(screenfilepath);
		for (int i = 0; i < screenarrlist.size(); i++) {
			String[] screenArr = screenarrlist.get(i);
			for (String filename : filenameArr) {
				filename += "threescreen";
				if(i > 0) {
					filename += i;
				}
				String filepath = "E:" + File.separator + "screen" + File.separator +filename+".txt";;
				Map<String, Integer> datamap = MapTxtUtil.getDataMap(filepath);
				Map<String, Integer> resultmap = new HashMap<String, Integer>();
				for (Entry<String, Integer> entry : datamap.entrySet()) {
					String[] combineArr = entry.getKey().split(",");
					String[] intersectArr = ArrayTool.getIntersectArr(screenArr, combineArr);
					if(intersectArr.length < 6) {
						resultmap.put(entry.getKey(), entry.getValue());
					}
					
				}
				String afterfilename = filename+(i+1);
				MapTxtUtil.createScreenTxtMap(resultmap,afterfilename);
			}		
			
		}
		
	}
}
