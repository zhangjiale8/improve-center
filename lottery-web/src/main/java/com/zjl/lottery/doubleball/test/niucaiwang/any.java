package com.zjl.lottery.doubleball.test.niucaiwang;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.zjl.lottery.doubleball.util.ScreenUtil;
import com.zjl.lottery.util.ListDataUtil;
import com.zjl.lottery.util.MapDataUtil;
import com.zjl.tools.ArrayTool;

public class any {
	public static void main(String[] args) {
		int count = 0;
		String filepath = "E:" + File.separator + "screen" + File.separator +"2020003"+ File.separator +"niucaiwang-8.txt";
		Map<String, Integer> combinemaps = MapDataUtil.getDataMap(filepath);
		int [] param = {2,15,23,26,29,30};
		String [] paramstr = ArrayTool.intArr2StrArr(param); 
		for (Entry<String, Integer> entry : combinemaps.entrySet()) {
			String [] combinearr = entry.getKey().split(",");
			String[] intersectArr = ArrayTool.getIntersectArr(paramstr, combinearr);
			if(intersectArr.length == 6){
				count ++;
				System.out.println(entry.getKey());
				System.out.println(combinearr.length);

			}
		}
		System.out.println(count);
	}
}
