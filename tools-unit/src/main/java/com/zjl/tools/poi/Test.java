package com.zjl.tools.poi;

import java.io.File;
import java.util.List;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		String filepath = "E:" + File.separator + "screen" + File.separator +"双色球预测汇总数据 (7).xls";;
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
