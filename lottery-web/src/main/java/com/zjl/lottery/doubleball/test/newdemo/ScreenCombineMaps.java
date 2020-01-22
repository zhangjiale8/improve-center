package com.zjl.lottery.doubleball.test.newdemo;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.zjl.lottery.doubleball.util.HistoryUtil;
import com.zjl.lottery.doubleball.util.MultipParamsListUtil;
import com.zjl.lottery.doubleball.util.ScreenUtil;
import com.zjl.lottery.doubleball.util.TailUtil;
import com.zjl.lottery.util.ListDataUtil;
import com.zjl.lottery.util.MapDataUtil;
import com.zjl.tools.ArrayTool;

public class ScreenCombineMaps {
	public static void main(String[] args) {
		String filepath = "E:" + File.separator + "screen" + File.separator +"combinemaps.txt";
		Map<String, Integer> combinemaps = MapDataUtil.getDataMap(filepath);
		combinemaps = ScreenUtil.timesscreen(combinemaps,3);
		combinemaps = fiveselect(combinemaps);
		MapDataUtil.createScreenTxtMap(combinemaps, "combinemaps1");
		combinemaps = ScreenUtil.tailspanscreen(combinemaps);
		MapDataUtil.createScreenTxtMap(combinemaps, "combinemaps12");
		combinemaps = ScreenUtil.singledoublemin2(combinemaps);
		MapDataUtil.createScreenTxtMap(combinemaps, "combinemaps123");
		combinemaps = ScreenUtil.areascreen(combinemaps);
		MapDataUtil.createScreenTxtMap(combinemaps, "combinemaps1234");
		filepath = "E:" + File.separator + "screen" + File.separator+ "lecaiwang" + File.separator +"300.txt";
		Map<String, Integer> lecaiwang300map = MapDataUtil.getDataMap(filepath);
		combinemaps = lecaiwangscreen(combinemaps,lecaiwang300map);
		MapDataUtil.createScreenTxtMap(combinemaps, "combinemaps12345");
		combinemaps = tailscreen3(combinemaps);
		MapDataUtil.createScreenTxtMap(combinemaps, "combinemaps123456");
		filepath = "E:" + File.separator + "screen" + File.separator+ "caihongduo" + File.separator +"25.txt";
		List<String[]> caihongduo25list = ListDataUtil.getScreenList(filepath);
		filepath = "E:" + File.separator + "screen" + File.separator+ "wangcai" + File.separator +"25.txt";
		List<String[]> wangcai25list = ListDataUtil.getScreenList(filepath);
		combinemaps = ScreenUtil.listcontain(combinemaps,wangcai25list,2,6);
		MapDataUtil.createScreenTxtMap(combinemaps, "combinemaps1234567");
		combinemaps = ScreenUtil.listcontain(combinemaps,caihongduo25list,2,6);
		MapDataUtil.createScreenTxtMap(combinemaps, "combinemaps12345678");
		
		
		/*filepath = "E:" + File.separator + "screen" + File.separator+ "other" + File.separator +"0-4.txt";
		List<String[]> wangcai0_4list = ListDataUtil.getScreenList(filepath);
		combinemaps = ScreenUtil.listcontain(combinemaps,wangcai0_4list,0,4);
		MapDataUtil.createScreenTxtMap(combinemaps, "combinemaps123456789");
		filepath = "E:" + File.separator + "screen" + File.separator+ "other" + File.separator +"1-4.txt";
		List<String[]> wangcai1_4list = ListDataUtil.getScreenList(filepath);
		combinemaps = ScreenUtil.listcontain(combinemaps,wangcai1_4list,1,4);
		MapDataUtil.createScreenTxtMap(combinemaps, "combinemaps1234567891");
		filepath = "E:" + File.separator + "screen" + File.separator+ "other" + File.separator +"0-3.txt";
		List<String[]> wangcai0_3list = ListDataUtil.getScreenList(filepath);
		combinemaps = ScreenUtil.listcontain(combinemaps,wangcai0_3list,0,3);
		MapDataUtil.createScreenTxtMap(combinemaps, "combinemaps12345678912");*/
		
	/*	combinemaps = niucaiwangscreen(combinemaps);
		MapDataUtil.createScreenTxtMap(combinemaps, "combinemaps123456789123");*/
		/*combinemaps = niucaiwangscreenlow20(combinemaps);
		MapDataUtil.createScreenTxtMap(combinemaps, "combinemaps1234567891234");
		combinemaps = niucaiwangscreenup20(combinemaps);
		MapDataUtil.createScreenTxtMap(combinemaps, "combinemaps12345678912345");
		combinemaps = niucaiwangscreen20(combinemaps);
		MapDataUtil.createScreenTxtMap(combinemaps, "combinemaps123456789123456");*/
		
		
		/*filepath = "E:" + File.separator + "screen" + File.separator +"caihongduo20map.txt";
		Map<String, Integer> caihongduo20map = MapDataUtil.getDataMap(filepath);
		combinemaps = ScreenUtil.uncludedmap(combinemaps,caihongduo20map);
		MapDataUtil.createScreenTxtMap(combinemaps, "combinemaps1234567891234567");
		filepath = "E:" + File.separator + "screen" + File.separator +"wangcai20map.txt";
		Map<String, Integer> wangcai20map = MapDataUtil.getDataMap(filepath);
		combinemaps = ScreenUtil.uncludedmap(combinemaps,wangcai20map);
		MapDataUtil.createScreenTxtMap(combinemaps, "combinemaps12345678912345678");
		
		combinemaps = ScreenUtil.screenThree(combinemaps);
		MapDataUtil.createScreenTxtMap(combinemaps, "combinemaps123456789123456789");*/
		
		/*filepath = "E:" + File.separator + "screen" + File.separator+ "other" + File.separator +"6.txt";
		List<String[]> wangcai6list = ListDataUtil.getScreenList(filepath);
		combinemaps = ScreenUtil.listcontain(combinemaps,wangcai6list,6,6);
		MapDataUtil.createScreenTxtMap(combinemaps, "combinemaps1234567891234567891");*/
	}
	
	/**
	 * 5组精选过滤
	 * @param combinemaps
	 * @return
	 */
	private static Map<String, Integer> fiveselect(Map<String, Integer> combinemaps) {

		ArrayList<int[]> list25 = new ArrayList<int[]>();
		String filepath = "E:" + File.separator + "screen" + File.separator+ "fiveselect.txt";
		List<String[]> combinelist = ListDataUtil.getScreenList(filepath);
		for (String[] combinearr : combinelist) {
			int[] combine = ArrayTool.strArr2InArr(combinearr);
			list25.add(combine);
		}
		
		Map<String, Integer> combinemaps25 = new HashMap<String,Integer>();
		for (int[] conbineArr : list25) {
			Map<String, Integer> combinemap = MultipParamsListUtil.getScreenMap(conbineArr);
			for (Entry<String, Integer> entry : combinemap.entrySet()) {
				String combine = entry.getKey();
				int count = null == combinemaps25.get(combine)?0:combinemaps25.get(combine);
				combinemaps25.put(combine, count+1);
				combinemaps.remove(combine);
			} 
		}
		
		MapDataUtil.createScreenTxtMap(combinemaps25, "fiveselectmap");
		
		return combinemaps;
	
	}


	/**
	 * 20个组合有一个
	 * @param combinemaps
	 * @return
	 */
	private static Map<String, Integer> niucaiwangscreen20(Map<String, Integer> combinemaps) {
		Map<String, Integer> screenmap = new HashMap<String, Integer>();
		String filepath = "E:" + File.separator + "screen" + File.separator +"niucaiwang20combinemaps.txt";
		Map<String, Integer> niucaiwang20 = MapDataUtil.getDataMap(filepath);
		for (Entry<String, Integer> entry : combinemaps.entrySet()) {
			Integer count = niucaiwang20.get(entry.getKey());
			if(null != count && count == 1){
				screenmap.put(entry.getKey(), entry.getValue());
			}
		}
		return screenmap;
	}


	/**
	 * 高于20个的组合3-9个
	 * @param combinemaps
	 * @return
	 */
	private static Map<String, Integer> niucaiwangscreenup20(Map<String, Integer> combinemaps) {

		Map<String, Integer> screenmap = new HashMap<String, Integer>();
		String filepath = "E:" + File.separator + "screen" + File.separator +"niucaiwang20upcombinemaps.txt";
		Map<String, Integer> niucaiwang20 = MapDataUtil.getDataMap(filepath);
		for (Entry<String, Integer> entry : combinemaps.entrySet()) {
			Integer count = niucaiwang20.get(entry.getKey());
			if(null != count && count >2 && count <10){
				screenmap.put(entry.getKey(), entry.getValue());
			}
		}
		return screenmap;
	
	}


	/**
	 *  低于20个的组合一个没有
	 * @param combinemaps
	 * @return
	 */
	private static Map<String, Integer> niucaiwangscreenlow20(Map<String, Integer> combinemaps) {

		Map<String, Integer> screenmap = new HashMap<String, Integer>();
		String filepath = "E:" + File.separator + "screen" + File.separator +"niucaiwang20lowcombinemaps.txt";
		Map<String, Integer> niucaiwang20 = MapDataUtil.getDataMap(filepath);
		for (Entry<String, Integer> entry : combinemaps.entrySet()) {
			Integer count = niucaiwang20.get(entry.getKey());
			if(count == null){
				screenmap.put(entry.getKey(), entry.getValue());
			}
		}
		return screenmap;
	
	}


	/**
	 * 牛彩网数据4-10
	 * @param combinemaps
	 * @return
	 */
	private static Map<String, Integer> niucaiwangscreen(Map<String, Integer> combinemaps) {

		Map<String, Integer> screenmap = new HashMap<String, Integer>();
		String filepath = "E:" + File.separator + "screen" + File.separator +"niucaiwangcombinemaps.txt";
		Map<String, Integer> niucaiwang20 = MapDataUtil.getDataMap(filepath);
		for (Entry<String, Integer> entry : combinemaps.entrySet()) {
			Integer count = niucaiwang20.get(entry.getKey());
			if(null != count && count >3 && count <11){
				screenmap.put(entry.getKey(), entry.getValue());
			}
		}
		return screenmap;
	
	}



	private static Map<String, Integer> tailscreen3(Map<String, Integer> combinemaps) {

		Map<String, Integer> screenmap = new HashMap<String, Integer>();
		String [] tails = {"0","4","1","6","8"};
		String [] othertails = {"2","3","5","9","7"};
		String [] pretails = {"2","3","6","0","5","7"};
		String [] kaijitails = {"0","1","4","5","8"};
		String [] myboytails = {"1","2","5"};
		String [] myboytails2 = {"0","2","8","6"};
		for (Entry<String, Integer> entry : combinemaps.entrySet()) {
			String[] combine = entry.getKey().split(",");
			String [] combinetails = TailUtil.getTailsArry(combine);
			int count = TailUtil.getCountSameTail(tails, combinetails);
			int othercount = TailUtil.getCountSameTail(othertails, combinetails);
			int precount = TailUtil.getCountSameTail(pretails, combinetails);
			int kaijicount = TailUtil.getCountSameTail(kaijitails, combinetails);
			int myboycount = TailUtil.getCountSameTail(myboytails, combinetails);
			int myboycount2 = TailUtil.getCountSameTail(myboytails2, combinetails);
			if(count > 1 && count <5 && combinetails.length >3 
				&& precount >0 && precount <5 
				&& kaijicount >0 && kaijicount <5 
			//	&& myboycount >0 && myboycount <3
				&& othercount > 0 && othercount <5
			//	&& myboycount2 > 0
				){
				screenmap.put(entry.getKey(), entry.getValue());
			}
		}
		return screenmap;
	
	}
	/**
	 *乐彩网过滤
	 * @param combinemaps
	 * @param lecaiwang300map
	 * @return
	 */
	private static Map<String, Integer> lecaiwangscreen(Map<String, Integer> combinemaps, Map<String, Integer> lecaiwang300map) {
		Map<String, Integer> resultmap = new HashMap<String, Integer>();
		for (Entry<String, Integer> dataentry : combinemaps.entrySet()) {
			String combine = HistoryUtil.recombination(dataentry.getKey());
			int draw1 = drawmin1(combine,lecaiwang300map);
			int draw6 = drawmax6(combine,lecaiwang300map);
			if((draw1<4) && (draw6 > 27 && draw6 <46)){
				resultmap.put(dataentry.getKey(), dataentry.getValue());
			}

		}
		return resultmap;
	}
	
	private static int drawmax6(String draw, Map<String, Integer> datamap) {
		int result = 0;
		for (Entry<String, Integer> entry : datamap.entrySet()) {
			String[] screenArr = entry.getKey().split(",");
			String[] combineArr = draw.split(",");
			String[] intersectArr = ArrayTool.getIntersectArr(screenArr, combineArr);
			if(intersectArr.length >5) {
				result ++;
			}
		}
		return result;
		
	}

	private static int drawmin1(String draw, Map<String, Integer> datamap) {
		int result = 0;
		for (Entry<String, Integer> entry : datamap.entrySet()) {
			String[] screenArr = entry.getKey().split(",");
			String[] combineArr = draw.split(",");
			String[] intersectArr = ArrayTool.getIntersectArr(screenArr, combineArr);
			if(intersectArr.length <2) {
				result ++;
			}
		}
		return result;
		
	}
}
