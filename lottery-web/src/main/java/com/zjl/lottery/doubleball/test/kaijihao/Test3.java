package com.zjl.lottery.doubleball.test.kaijihao;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;

import com.zjl.lottery.doubleball.util.HistoryUtil;
import com.zjl.lottery.doubleball.util.TailUtil;
import com.zjl.lottery.util.MapDataUtil;

public class Test3 {
	public static void main(String[] args) {
		Map<String, Integer> kaijihaosamemap = new HashMap<String, Integer>();
		Map<String, String> perioddrawmap = HistoryUtil.getPeriodHistoryMap();
		Map<String, String> periodkaijihaomap = HistoryUtil.getHistoryKaijihaoMap();
		int min2 = 0;
		for (Entry<String, String> entry : perioddrawmap.entrySet()) {
			int same = 0;
			String kaijihao = periodkaijihaomap.get(entry.getKey());
			if(StringUtils.isNotEmpty(kaijihao)){
				String[] drawarr = entry.getValue().split(",");
				String[] kaijihaoarr = kaijihao.split(",");
				same = TailUtil.getCountSameTail(drawarr,kaijihaoarr);
				if(same >3){
					min2 ++;
				}
				kaijihaosamemap.put(entry.getKey(), same);
			}
		}
		System.out.println(min2);
		MapDataUtil.createScreenTxtMap(kaijihaosamemap, "kaijihaosamemap");
	}
}
