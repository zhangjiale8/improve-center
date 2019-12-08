package com.zjl.lottery.lotto;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import com.zjl.lottery.lotto.util.HistoryScreenUtil;
import com.zjl.lottery.lotto.util.HistoryUtil;
import com.zjl.lottery.lotto.util.MultipLottoUtil;
import com.zjl.lottery.util.MapDataUtil;
import com.zjl.lottery.util.ThreeSreenUtil;

public class LottoMultipParamsListTest {
	public static void main(String[] args) {
		int[] paramArr1 = {1,3,4,6,7,8,11,12,14,15,18,19,21,22,25,27,29,31,33,34};
		int[] paramArr2 = {2,3,4,5,6,8,9,11,12,13,14,15,16,19,20,21,24,25,26,29};
		int[] paramArr3 = {1,3,4,6,8,9,10,11,13,16,18,20,21,23,24,28,29,32,33,34};
		int[] paramArr4 = {2,3,4,5,6,8,9,11,12,14,18,20,21,22,23,25,29,30,32,33};
		int[] paramArr5 = {1,2,3,4,7,15,16,17,19,20,21,22,23,25,26,27,30,32,33,34};
		int[] paramArr6 = {1,3,5,6,10,12,13,14,18,20,21,23,24,25,26,27,29,30,34,35};
		int[] paramArr7 = {1,2,3,4,9,10,11,12,14,15,16,20,23,25,28,29,30,31,33,34};
		int[] paramArr8 = {1,2,4,5,6,7,9,10,11,12,13,15,17,18,19,23,24,26,28,32};
		int[] paramArr9 = {1,3,4,6,7,8,10,12,13,14,15,16,21,24,25,26,27,29,30,34};
		int[] paramArr10 = {2,3,4,5,7,9,11,13,15,16,17,18,19,21,23,27,28,29,30,31};
		int[] paramArr11 = {3,4,5,6,8,9,11,14,15,20,21,24,25,26,27,29,30,32,33,34};
		int[] paramArr12 = {1,2,4,5,7,8,9,10,11,15,17,19,20,22,24,26,28,29,30,34};
		ArrayList<int[]> screenlist = new ArrayList<int[]>();
		screenlist.add(paramArr12);
		screenlist.add(paramArr11);
		screenlist.add(paramArr10);
		screenlist.add(paramArr9);
		screenlist.add(paramArr8);
		screenlist.add(paramArr7);
		screenlist.add(paramArr6);
		screenlist.add(paramArr5);
		screenlist.add(paramArr4);
		screenlist.add(paramArr3);
		screenlist.add(paramArr2);
		screenlist.add(paramArr1);
		int[] screenarray = HistoryUtil.get10periodHistoryArr();
	
		MultipLottoUtil.screenDetermined(screenlist, screenarray);
	//	threeScreen();
	//	historyscreen();
		//twoScreen();
		//pingtotal();
		
	}
	
	/**
	 * 历史开奖信息过滤
	 */
	private static void historyscreen() {
		String filename = "lottoscreenthreescreen";
		String filepath = "E:" + File.separator + "screen" + File.separator +filename+".txt";;
		Map<String, Integer> datamap = MapDataUtil.getDataMap(filepath);
		HistoryScreenUtil.screenhistory(datamap,filename);
		
		
	}
	
	/**
	 * 三连过滤
	 * @param:       
	 */
	private static void threeScreen() {
		String filename = "lottoscreen";
		String filepath = "E:" + File.separator + "screen" + File.separator +filename +".txt";;
		Map<String, Integer> datamap = MapDataUtil.getDataMap(filepath);
		ThreeSreenUtil.threeScreen(datamap,filename);
		
	}

	public void init(){
		int[] paramArr1 = {};
		int[] paramArr2 = {};
		int[] paramArr3 = {};
		int[] paramArr4 = {};
		int[] paramArr5 = {};
		int[] paramArr6 = {};
		int[] paramArr7 = {};
		int[] paramArr8 = {};
		int[] paramArr9 = {};
		int[] paramArr10 = {};
		int[] paramArr11 = {};
		int[] paramArr12 = {};
		ArrayList<int[]> screenlist = new ArrayList<int[]>();
		screenlist.add(paramArr12);
		screenlist.add(paramArr11);
		screenlist.add(paramArr10);
		screenlist.add(paramArr9);
		screenlist.add(paramArr8);
		screenlist.add(paramArr7);
		screenlist.add(paramArr6);
		screenlist.add(paramArr5);
		screenlist.add(paramArr4);
		screenlist.add(paramArr3);
		screenlist.add(paramArr2);
		screenlist.add(paramArr1);
		int[] screenarray = {};
	
		//MultipParamsListUtil.screenDetermined(screenlist, screenarray);
		//historyscreen();
		//otherticketscreen();
		//threeScreen();
		//twoScreen();
		//pingtotal();
		
	}
	
}
