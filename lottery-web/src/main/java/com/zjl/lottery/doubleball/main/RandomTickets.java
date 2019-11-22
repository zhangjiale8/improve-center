package com.zjl.lottery.doubleball.main;

import java.io.File;
import java.util.Map;

import com.zjl.lottery.doubleball.util.ScreenUtil;
import com.zjl.lottery.util.MapDataUtil;

public class RandomTickets {
	public static void main(String[] args) {
		String filePath = "E:" + File.separator + "screen" + File.separator +"otherticketsscreen.txt";
		Map<String, Integer> resultmap = MapDataUtil.getDataMap(filePath);
		ScreenUtil.screenTwo(ScreenUtil.screenRandomTickets(resultmap));
	}
}
