package com.zjl.lottery.lotto.other;

import java.util.Map;

import com.zjl.lottery.util.CombineUtil;
import com.zjl.lottery.util.MapDataUtil;

public class Test {
	public static void main(String[] args) {
		int screenNum = 5;
		int[] paramArr = {3,7,11,12,15,23,24,30,35};
		Map<String, Integer> datamap = CombineUtil.getCombineMap(paramArr, screenNum);
		MapDataUtil.createScreenTxtMap(datamap, "newlottomap");
	}
}
