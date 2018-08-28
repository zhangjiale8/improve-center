package com.zjl.lottery.tools;

import java.util.Scanner;

import org.apache.commons.lang.StringUtils;

import com.zjl.tools.TimeTools;

public class LotteryTool {
	private static int year = 0;
	private static int issue = 0;

	public static void initYearAndIssue() {
		System.out.println("请输入年份整数：");
		Scanner yearSc = new Scanner(System.in);
		int yearIn = yearSc.nextInt();
		String curYear = TimeTools.getCurrentYeart();
		if(StringUtils.isNotEmpty(curYear)) {
			int cur = Integer.parseInt(curYear);
			if(yearIn == cur) {
				year  = yearIn;
			}else {
				System.out.println("当前不支持跨年初始化");
			}
			
		}else {
			System.out.println("获取当前年失败！");
			
		}
		
	}

}
