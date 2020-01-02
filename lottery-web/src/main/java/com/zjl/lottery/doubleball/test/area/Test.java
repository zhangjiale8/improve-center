package com.zjl.lottery.doubleball.test.area;

import java.util.Map;
import java.util.Map.Entry;

import com.zjl.lottery.doubleball.util.HistoryUtil;
import com.zjl.tools.ArrayTool;

public class Test {
	public static void main(String[] args) {

		int areainterrupt = 0;
		String [] area1 = {"1","2","3","4","5","6","7","8","9","10","11"};
		String [] area2 = {"12","13","14","15","16","17","18","19","20","21","22"};
		String [] area3 = {"23","24","25","26","27","28","29","30","31","32","33"};
		Map<String, String> historymap =  HistoryUtil.getPeriodHistoryMap();
		for (Entry<String, String> entry : historymap.entrySet()) {
			String[] combinestrArr = entry.getValue().split(",");
			String[] area1intersectArr = ArrayTool.getIntersectArr(area1, combinestrArr);
			
			String[] area2intersectArr = ArrayTool.getIntersectArr(area2, combinestrArr);
			
			String[] area3intersectArr = ArrayTool.getIntersectArr(area3, combinestrArr);
			if(area1intersectArr.length == 0 
				|| area2intersectArr.length == 0 
				|| area3intersectArr.length == 0){
				
				areainterrupt ++;
				
			}
		}
		System.out.println(areainterrupt);
	
	}
}
