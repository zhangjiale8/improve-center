package com.zjl.lottery.doubleball.test.kaijihao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;

import com.zjl.lottery.util.MapDataUtil;

public class Test2 {
	public static void main(String[] args) {
		Map<String, Integer> datamaptemp = new HashMap<String, Integer>();
		String filename = "kaijihao1";
		String filepath = "E:" + File.separator + "screen" + File.separator +filename+".txt";;

		try {
			File file = new File(filepath);
			if(null != file && file.exists()) {

				BufferedReader br = new BufferedReader(new FileReader(file));
				String line = null;
				
				while((StringUtils.isNotEmpty(line = br.readLine()))){//使用readLine方法，一次读一行
					String [] temp = line.split("@");
					String kaijihao = temp[2];
					kaijihao = kaijihao.substring(0,kaijihao.length() -1);
					String combine = kaijihao.substring(0,kaijihao.length()-3)+"|"+kaijihao.substring(kaijihao.length()-2,kaijihao.length());
					String result = temp[0] + "@"+temp[1]+"@@"+combine;
					datamaptemp.put(result, null);
	            }
	            br.close();
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		MapDataUtil.createScreenTxtMap(datamaptemp, filename+"2");
	}
}
