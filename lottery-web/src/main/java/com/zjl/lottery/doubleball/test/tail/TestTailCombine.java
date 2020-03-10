package com.zjl.lottery.doubleball.test.tail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.zjl.lottery.util.CombineUtil;

public class TestTailCombine {
	public static void main(String[] args) {
		
		int[] screenarray = {0,1,2,3,4,5,6,7,8,9};
		ArrayList<String> screenList = CombineUtil.getScreenList(screenarray,4);
		System.out.println(screenList.size());
	}
}
