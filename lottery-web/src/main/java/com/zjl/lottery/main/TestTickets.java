package com.zjl.lottery.main;

import java.io.File;
import java.util.Map;

import com.zjl.lottery.util.MapTxtUtil;
import com.zjl.lottery.util.ScreenUtil;

public class TestTickets {
	public static void main(String[] args) {
		String filePath = "E:" + File.separator + "screen" + File.separator +"historyscreen.txt";
		Map<String, Integer> resultmap = MapTxtUtil.getDataMap(filePath);
		ScreenUtil.screenTwo(ScreenUtil.screenOtherTickets(ScreenUtil.screenTickets(resultmap)));
	}
}
