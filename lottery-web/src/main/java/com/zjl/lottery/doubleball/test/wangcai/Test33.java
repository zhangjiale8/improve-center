package com.zjl.lottery.doubleball.test.wangcai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.zjl.lottery.doubleball.util.MultipParamsListUtil;
import com.zjl.lottery.doubleball.util.ScreenUtil;
import com.zjl.lottery.doubleball.util.TailUtil;
import com.zjl.lottery.util.MapDataUtil;
import com.zjl.tools.ArrayTool;

public class Test33 {
	public static void main(String[] args) {

		
		int[] paramArr1 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33};
		
		ArrayList<int[]> list33 = new ArrayList<int[]>();
		
		list33.add(paramArr1);
		
		Map<String, Integer> combinemaps33 = new HashMap<String,Integer>();
		for (int[] conbineArr : list33) {
			Map<String, Integer> combinemap = MultipParamsListUtil.getScreenMap(conbineArr);
			for (Entry<String, Integer> entry : combinemap.entrySet()) {
				String combine = entry.getKey();
				int count = null == combinemaps33.get(combine)?0:combinemaps33.get(combine);
				combinemaps33.put(combine, count+1);
			} 
		}
		/*combinemaps33 = ScreenUtil.tailspanscreen(combinemaps33);
		combinemaps33 = ScreenUtil.singledoublemin2(combinemaps33);
		combinemaps33 = ScreenUtil.screenThree(combinemaps33);
		combinemaps33 = ScreenUtil.areascreen(combinemaps33);*/
		//combinemaps33 = tailscreen(combinemaps33);
		//combinemaps33 = tailscreen3(combinemaps33);
		MapDataUtil.createScreenTxtMap(combinemaps33, "combinemaps33");

	}

	private static Map<String, Integer> tailscreen3(Map<String, Integer> combinemaps33) {

		Map<String, Integer> screenmap = new HashMap<String, Integer>();
		String [] tails = {"0","2","3","5","6","9"};
		String [] pretails = {"4","5","6","8","9"};
		String [] kaijihaotails = {"0","1","6","8","9"};
		for (Entry<String, Integer> entry : combinemaps33.entrySet()) {
			String[] combine = entry.getKey().split(",");
			String [] combinetails = TailUtil.getTailsArry(combine);
			int count = TailUtil.getCountSameTail(tails, combinetails);
			int precount = TailUtil.getCountSameTail(pretails, combinetails);
			int kaijihaocount = TailUtil.getCountSameTail(kaijihaotails, combinetails);
			if(count > 1 
			&& count <5 && combine.length >3 
			&& precount >0 && precount <5
			&& kaijihaocount>0 && kaijihaocount <5){
				screenmap.put(entry.getKey(), entry.getValue());
			}
		}
		return screenmap;
	
	}

	private static Map<String, Integer> tailscreen2(Map<String, Integer> combinemaps33) {
		Map<String, Integer> screenmap = new HashMap<String, Integer>();
		String [] tails = {"2","3","7","8"};
		for (Entry<String, Integer> entry : combinemaps33.entrySet()) {
			int count = 0;
			Map<String, Integer> tailmap =  new HashMap<String, Integer>();
			String[] drawstrarr = entry.getKey().split(",");
			int[] drawintarr = ArrayTool.strArr2InArr(drawstrarr);
			for (int i = 0; i < drawintarr.length; i++) {
				String tail = drawintarr[i] %10 +"";
				Integer tailcount = tailmap.get(tail);
				if(null != tailcount) {
					tailcount ++;
				}else {
					tailcount = 1;
				}
				tailmap.put(tail, tailcount);
				boolean flg = Arrays.asList(tails).contains(tail);
				if(flg) {
					count ++;
				}
			}
			if(count == 4 && tailmap.size() >4 && tailmap.get("2") == 1) {
				screenmap.put(entry.getKey(), entry.getValue());
			}
		}
		return screenmap;
	}

	private static Map<String, Integer> tailscreen(Map<String, Integer> combinemaps33) {
		Map<String, Integer> screenmap = new HashMap<String, Integer>();
		String [] tails = {"2","3","7","8"};
		for (Entry<String, Integer> entry : combinemaps33.entrySet()) {
			int count = 0;
			Map<String, Integer> tailmap =  new HashMap<String, Integer>();
			String[] drawstrarr = entry.getKey().split(",");
			int[] drawintarr = ArrayTool.strArr2InArr(drawstrarr);
			for (int i = 0; i < drawintarr.length; i++) {
				String tail = drawintarr[i] %10 +"";
				Integer tailcount = tailmap.get(tail);
				if(null != tailcount) {
					tailcount ++;
				}else {
					tailcount = 1;
				}
				tailmap.put(tail, tailcount);
				boolean flg = Arrays.asList(tails).contains(tail);
				if(flg) {
					count ++;
				}
			}
			if(count == 4 && tailmap.size() >4) {
				screenmap.put(entry.getKey(), entry.getValue());
			}
		}
		return screenmap;
	}

}
