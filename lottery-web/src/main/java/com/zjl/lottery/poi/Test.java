package com.zjl.lottery.poi;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;

import com.zjl.lottery.doubleball.util.HistoryUtil;
import com.zjl.lottery.util.ListDataUtil;
import com.zjl.lottery.util.MapDataUtil;
import com.zjl.tools.ArrayTool;
import com.zjl.tools.poi.ExcelUtils;
/**
 * 结论 draw1 0-2 draw 28-45 
 * @author Administrator
 *
 */
public class Test {
	public static void main(String[] args) {
		int draw1count = 0;
		for (int i = 149; i < 150; i++) {
			String filename = "";
			if(i < 100){
				filename += "20190"+i;
			}else{
				filename += "2019"+i;
			}
			String filepath = "E:" + File.separator + "screen" + File.separator+ "46144" + File.separator +filename+"双色球预测汇总数据.xls";
			String [] fileds = {"USER_NAM","PERIOD_VAL",
					"24RED_VAL","18RED_VAL","12RED_VAL",
					"TAP_VAL","PTERIS_VAL","RED_SINGLE_VAL",
					"RED_TWO_VAL","RED_THREE_VAL","KILL_RED_THREE_VAL",
					"KILL_RED_SIX_VAL","BLUE_SINGLE_VAL","BLUE_TWO_VAL",
					"BLUE_THREE_VAL","BLUE_SIX_VAL","KILL_BLUE_THREE_VAL",
					"KILL_BLUE_SIX_VAL"};
			try {
				int sheetnum = 0;
				int startrownum = 2;
				int startcolnum  = 0;
				List<Map<String,String>> list = ExcelUtils.getData(filepath,fileds,sheetnum,startrownum,startcolnum);
				Map<String, Integer> datamap =new HashMap<String, Integer>();
				for (int j = 0; j < list.size(); j++) {
					Map<String,String> maptemp = list.get(j);
					String red24val = maptemp.get("24RED_VAL");
					datamap.put(red24val, null);
				}
				/*Map<String, String> historymap = HistoryUtil.getPeriodHistoryMap();
				String drawinfo = historymap.get(filename);
				if(StringUtils.isNotEmpty(drawinfo)){
					drawinfo = HistoryUtil.recombination(drawinfo);
					int draw1 = drawmin1(drawinfo,datamap);
					if(draw1 >2){
						draw1count ++;
					}
					int draw6 = drawmax6(drawinfo,datamap);
					
					System.out.println(filename+":"+draw1 +"----------"+draw6 );
				}*/
				MapDataUtil.createScreenTxtMap(datamap, filename);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		System.out.println(draw1count);
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
