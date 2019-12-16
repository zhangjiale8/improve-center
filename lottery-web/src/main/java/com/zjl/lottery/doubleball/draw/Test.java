package com.zjl.lottery.doubleball.draw;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.zjl.lottery.util.ListDataUtil;
import com.zjl.lottery.util.MapDataUtil;
import com.zjl.tools.ArrayTool;
import com.zjl.tools.MapUtil;

public class Test {
	public static void main(String[] args) {
		String draw = "02,12,16,22,25,32";
		drawmin1(draw);
	//	drawmax6(draw);
	}
	
	private static void drawmax6(String draw) {

		String screenfilepath = "E:" + File.separator + "screen" + File.separator +"screenlist.txt";;
		List<String[]> screenarrlist = ListDataUtil.getScreenList(screenfilepath);
		for (String[] screenArr : screenarrlist) {
			String[] combineArr = draw.split(",");
			String[] intersectArr = ArrayTool.getIntersectArr(screenArr, combineArr);
			if(intersectArr.length >5) {
				String temp = "";
				for (int i = 0; i < screenArr.length; i++) {
					temp +=  screenArr[i]+",";
				}
				temp = temp.substring(0, temp.length()-1);
				System.out.println(temp);
			}
		}
		
	}

	private static void drawmin1(String draw) {

		String screenfilepath = "E:" + File.separator + "screen" + File.separator +"screenlist.txt";;
		List<String[]> screenarrlist = ListDataUtil.getScreenList(screenfilepath);
		for (String[] screenArr : screenarrlist) {
			String[] combineArr = draw.split(",");
			String[] intersectArr = ArrayTool.getIntersectArr(screenArr, combineArr);
			if(intersectArr.length <2) {
				String temp = "";
				for (int i = 0; i < screenArr.length; i++) {
					temp +=  screenArr[i]+",";
				}
				temp = temp.substring(0, temp.length()-1);
				System.out.println(temp);
			}
		}
		
	}
}
