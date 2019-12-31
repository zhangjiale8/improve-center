package com.zjl.lottery.lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.zjl.lottery.doubleball.util.ScreenUtil;
import com.zjl.lottery.util.CombineUtil;
import com.zjl.lottery.util.MapDataUtil;

public class test {
	public static void main(String[] args) {
		/*int[] paramArr3 = {1,3,4,6,7,8,9,10,11,14,16,17,19,20,21,25,29,31,32,33};
		int[] paramArr2 = {2,5,12,13,15,18,22,23,24,26,27,28,30,34,35};*/
		int[] paramArr3 = {9,11,14,21,29,31,33};
		int[] paramArr2 = {27,35};
		ArrayList<String> screenList3 = CombineUtil.getScreenList(paramArr3,3);
		ArrayList<String> screenList2 = CombineUtil.getScreenList(paramArr2,2);
		Map<String, Integer> combinemaps = new HashMap<String,Integer>();
		for (String combine2 : screenList2) {
			for (String combine3 : screenList3) {
				String combine = combine2+","+combine3;
				combinemaps.put(combine, 1);
			}
		}
		combinemaps = ScreenUtil.singledoublemin2(combinemaps);
		combinemaps = ScreenUtil.areascreen(combinemaps);
		MapDataUtil.createScreenTxtMap(combinemaps, "combinemaps");
	}
}
