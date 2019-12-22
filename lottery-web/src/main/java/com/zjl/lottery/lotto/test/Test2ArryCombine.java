package com.zjl.lottery.lotto.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zjl.lottery.util.CombineUtil;
import com.zjl.lottery.util.MapDataUtil;

public class Test2ArryCombine {
	public static void main(String[] args) {
		try {
			int[] paramarr1 = {3,4,6,8,10,11,13,15,16,17,20,21,24,25,26,29,31};
			int screennum1 = 3;
			int[] paramarr2 = {1,2,5,7,9,12,14,18,19,22,23,27,28,30,32,33,34,35};
			int screennum2 = 2;
			Map<String, Integer> combinemap = CombineUtil.getCustomizeCombineMap(paramarr1, screennum1, paramarr2, screennum2);
			MapDataUtil.createScreenTxtMap(combinemap, "customizecombine");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
