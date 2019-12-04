package com.zjl.lottery.doubleball;

import java.util.Map;
import java.util.Map.Entry;

import com.zjl.lottery.doubleball.util.HistoryUtil;
import com.zjl.tools.ArrayTool;

public class AreaTest {
	public static void main(String[] args) {
		Map<String, Integer> historymap =  HistoryUtil.getHistoryMap();
		int area1counttotal = 0;
		int area2counttotal = 0;
		int area3counttotal = 0;
		String [] area1 = {"1","2","3","4","5","6","7","8","9","10","11"};
		String [] area2 = {"12","13","14","15","16","17","18","19","20","21","22"};
		String [] area3 = {"23","24","25","26","27","28","29","30","31","32","33"};
		for (Entry<String, Integer> entry : historymap.entrySet()) {
			String[] combinestrArr = entry.getKey().split(",");
			String[] area1intersectArr = ArrayTool.getIntersectArr(area1, combinestrArr);
			if(area1intersectArr.length == 0){
				area1counttotal ++;
			}
			String[] area2intersectArr = ArrayTool.getIntersectArr(area2, combinestrArr);
			if(area2intersectArr.length == 0){
				area2counttotal ++;
			}
			String[] area3intersectArr = ArrayTool.getIntersectArr(area3, combinestrArr);
			if(area3intersectArr.length == 0){
				area3counttotal ++;
			}
		}
		System.out.println(area1counttotal);
		System.out.println(area2counttotal);
		System.out.println(area3counttotal);
	}
}
