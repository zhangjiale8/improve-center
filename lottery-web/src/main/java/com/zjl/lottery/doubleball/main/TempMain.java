package com.zjl.lottery.doubleball.main;

import com.zjl.lottery.doubleball.util.TempUtil;

public class TempMain {
	public static void main(String[] args) {
		//校验购买德实体票与实际开奖是否超过4个
		//TempUtil.checkBuyActualBeyondFour();
		//校验本次开奖与历史开奖是否超过4个
		TempUtil.checkHistoryCompareBeyondFour();
	}
}
