package com.zjl.lottery.doubleball.test.newdemo;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.zjl.lottery.doubleball.util.ScreenUtil;
import com.zjl.lottery.doubleball.util.TailUtil;
import com.zjl.lottery.util.ListDataUtil;
import com.zjl.lottery.util.MapDataUtil;
import com.zjl.tools.ArrayTool;

public class caihongduoAndwangcai {
	public static void main(String[] args) {
		Map<String, Integer> combinemaps = new HashMap<String, Integer>();
		String filepath = "E:" + File.separator + "screen" + File.separator +"caihongduo25map.txt";
		Map<String, Integer> caihongduo25map = MapDataUtil.getDataMap(filepath);
		filepath = "E:" + File.separator + "screen" + File.separator +"caihongduo20map.txt";
		Map<String, Integer> caihongduo20map = MapDataUtil.getDataMap(filepath);
		filepath = "E:" + File.separator + "screen" + File.separator +"wangcai25map.txt";
		Map<String, Integer> wangcai25map = MapDataUtil.getDataMap(filepath);
		filepath = "E:" + File.separator + "screen" + File.separator +"wangcai20map.txt";
		Map<String, Integer> wangcai20map = MapDataUtil.getDataMap(filepath);
		for (Entry<String, Integer> waicaientry : wangcai25map.entrySet()) {
			Integer count = caihongduo25map.get(waicaientry.getKey());
			if(null != count && count < 4 && wangcai25map.get(waicaientry.getKey()) < 4){
				combinemaps.put(waicaientry.getKey(), waicaientry.getValue());
			}
		}
		combinemaps = ScreenUtil.tailspanscreen(combinemaps);
		combinemaps = ScreenUtil.singledoublemin2(combinemaps);
		combinemaps = ScreenUtil.areascreen(combinemaps);
		combinemaps = ScreenUtil.uncludedmap(combinemaps,wangcai20map);
		combinemaps = ScreenUtil.uncludedmap(combinemaps,caihongduo20map);
		filepath = "E:" + File.separator + "screen" + File.separator+ "caihongduo" + File.separator +"25.txt";
		List<String[]> caihongduo25list = ListDataUtil.getScreenList(filepath);
		filepath = "E:" + File.separator + "screen" + File.separator+ "wangcai" + File.separator +"25.txt";
		List<String[]> wangcai25list = ListDataUtil.getScreenList(filepath);
		combinemaps = ScreenUtil.listcontain(combinemaps,wangcai25list,2,6);
		combinemaps = ScreenUtil.listcontain(combinemaps,caihongduo25list,1,6);
		filepath = "E:" + File.separator + "screen" + File.separator+ "other" + File.separator +"0-4.txt";
		List<String[]> wangcai0_4list = ListDataUtil.getScreenList(filepath);
		combinemaps = ScreenUtil.listcontain(combinemaps,wangcai0_4list,0,4);
		filepath = "E:" + File.separator + "screen" + File.separator+ "other" + File.separator +"1-4.txt";
		List<String[]> wangcai1_4list = ListDataUtil.getScreenList(filepath);
		combinemaps = ScreenUtil.listcontain(combinemaps,wangcai1_4list,1,4);
		filepath = "E:" + File.separator + "screen" + File.separator+ "other" + File.separator +"6.txt";
		List<String[]> wangcai6list = ListDataUtil.getScreenList(filepath);
		combinemaps = ScreenUtil.listcontain(combinemaps,wangcai6list,6,6);
		combinemaps = tailscreen3(combinemaps);
		combinemaps = ScreenUtil.screenThree(combinemaps);
		MapDataUtil.createScreenTxtMap(combinemaps, "combinemaps");
	}
	
	private static Map<String, Integer> tailscreen3(Map<String, Integer> combinemaps) {

		Map<String, Integer> screenmap = new HashMap<String, Integer>();
		String [] tails = {"0","2","3","5","6","9"};
		String [] pretails = {"4","5","6","8","9"};
		String [] myboytails = {"1","2","5"};
		String [] myboytails2 = {"2"};
		for (Entry<String, Integer> entry : combinemaps.entrySet()) {
			String[] combine = entry.getKey().split(",");
			String [] combinetails = TailUtil.getTailsArry(combine);
			int count = TailUtil.getCountSameTail(tails, combinetails);
			int precount = TailUtil.getCountSameTail(pretails, combinetails);
			int myboycount = TailUtil.getCountSameTail(myboytails, combinetails);
			int myboycount2 = TailUtil.getCountSameTail(myboytails2, combinetails);
			if(count > 1 && count <5 && combinetails.length >3 && precount >0 && precount <5 && myboycount >0 && myboycount <3 && myboycount2 == 0){
				screenmap.put(entry.getKey(), entry.getValue());
			}
		}
		return screenmap;
	
	}
}
