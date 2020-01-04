package com.zjl.lottery.doubleball.test.wangcai;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.zjl.lottery.doubleball.util.ScreenUtil;
import com.zjl.lottery.util.ListDataUtil;
import com.zjl.lottery.util.MapDataUtil;
import com.zjl.tools.ArrayTool;
import com.zjl.tools.MapUtil;

public class screenTest {
	public static void main(String[] args) {
		//extrememultipscreen();
		//combinemapsresultscreen();
		multipscreen();
	}
	
	private static void multipscreen() {

		Map<String, Integer> screenmap = new HashMap<String, Integer>();
		String screenfilepath = "E:" + File.separator + "screen" + File.separator +"screenlist.txt";;
		List<String[]> screenarrlist = ListDataUtil.getScreenList(screenfilepath);

		String filepath = "E:" + File.separator + "screen" + File.separator +"combinemapsresult.txt";;
		Map<String, Integer> datamap = MapDataUtil.getDataMap(filepath);
		for (Entry<String, Integer> entry : datamap.entrySet()) {
			for (String[] screenArr : screenarrlist) {
				String[] combineArr = entry.getKey().split(",");
				String[] intersectArr = ArrayTool.getIntersectArr(screenArr, combineArr);
				if(intersectArr.length !=6 && entry.getValue() >3) {
					screenmap.put(entry.getKey(), entry.getValue());
				}
			}
		}

		Map<String, Integer> datamaptemp = new HashMap<String, Integer>();
		MapUtil.mapCopy(datamap,datamaptemp);
		for (Entry<String, Integer> entry : datamaptemp.entrySet()) {
			Integer count = screenmap.get(entry.getKey());
			if(null != count){
				datamap.remove(entry.getKey());
			}
		}
		MapDataUtil.createScreenTxtMap(datamap,"combinemapsresult100");
	
		
		
			
	}
	private static void combinemapsresultscreen() {
		String filepath = "E:" + File.separator + "screen" + File.separator +"combinemapsresult5.txt";;
		Map<String, Integer> datamap = MapDataUtil.getDataMap(filepath);
	//	datamap = ScreenUtil.singledoublemin2(datamap);
		//	datamap = ScreenUtil.areascreen(datamap);
		//	datamap = ScreenUtil.termscreen(datamap);
	//	datamap = ScreenUtil.screensametails(datamap);
		datamap = ScreenUtil.screencombinecount(datamap);
		MapDataUtil.createScreenTxtMap(datamap, "combinemapsresult6");
	}
	/**
	 * 极端测试
	 */
	private static void extrememultipscreen() {

		Map<String, Integer> result = new HashMap<String, Integer>();
		String filepath = "E:" + File.separator + "screen" + File.separator +"combinemaps25.txt";;
		Map<String, Integer> datamap = MapDataUtil.getDataMap(filepath);
		String screenfilepath = "E:" + File.separator + "screen" + File.separator +"combinemaps20.txt";;
		Map<String, Integer> screenmap = MapDataUtil.getDataMap(screenfilepath);
		for (Entry<String, Integer> entry : datamap.entrySet()) {
			if(!screenmap.containsKey(entry.getKey())){
				result.put(entry.getKey(), entry.getValue());
			}
		}
		
		MapDataUtil.createScreenTxtMap(result, "combinemapsresult");
		
	}
}
