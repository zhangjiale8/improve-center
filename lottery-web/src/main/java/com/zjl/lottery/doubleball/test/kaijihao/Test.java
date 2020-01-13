package com.zjl.lottery.doubleball.test.kaijihao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;

import com.zjl.lottery.util.MapDataUtil;

public class Test {
	public static void main(String[] args) {
		Map<String, Integer> datamaptemp = new HashMap<String, Integer>();
		String filename = "kaijihao";
		String filepath = "E:" + File.separator + "screen" + File.separator +filename+".txt";;

		try {
			File file = new File(filepath);
			if(null != file && file.exists()) {

				BufferedReader br = new BufferedReader(new FileReader(file));
				String line = null;
				int hang = 0;
				String kaijihao = "";
				while((StringUtils.isNotEmpty(line = br.readLine()))){//使用readLine方法，一次读一行
					hang ++;
					if(line.length() >2){
						String temp = line.substring(0,2);
						if("20".equals(temp)){
							datamaptemp.put(kaijihao, null);
							kaijihao = "";
							hang = 1;
						}
					}
					
					if(hang == 1){
						kaijihao += line+" ";
					}
					if(hang == 2){
						kaijihao += line +" ";
					}
					if(hang == 3){
						kaijihao += line +" ";
					}
					
	            }
	            br.close();
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		MapDataUtil.createScreenTxtMap(datamaptemp, filename+"1");
	}
}
