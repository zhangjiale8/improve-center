package com.zjl.lottery.db.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;

public class MapTxtUtil {
	/**
	 * Map集合打印
	 * @param map
	 * @param fileName
	 */
	public static void createScreenTxtMap(Map<String, Integer> map, String fileName) {
		if(null != map && map.size() > 0 && StringUtils.isNotEmpty(fileName)){
			try {
				File file = new File("E:" + File.separator + "screen" + File.separator +fileName+ ".txt");
		         if(!file.getParentFile().exists()){
	               file.getParentFile().mkdirs();
	           }
	           
	           //2：准备输出流
	           Writer out = new FileWriter(file);
	           for (Entry<String, Integer> entry : map.entrySet()) {
		           	String temp = entry.getKey()+"|"+entry.getValue();
		            out.write(temp+System.getProperty("line.separator"));
	           }
	           out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * 返回Map集合
	 * @param filePath
	 * @return
	 */
	public static Map<String, Integer> getDataMap(String filePath) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		if(StringUtils.isNotEmpty(filePath)){
			try {
				File file = new File(filePath);
				if(null != file && file.exists()) {

					BufferedReader br = new BufferedReader(new FileReader(file));
					String line = null;
					while((StringUtils.isNotEmpty(line = br.readLine()))){//使用readLine方法，一次读一行
						String[] lineArr = line.split("\\|");
						if(lineArr.length > 1){
							int num = Integer.valueOf(lineArr[1]);
							map.put(lineArr[0],num);
						}else{
							map.put(line, 1);

						}
		            }
		            br.close();
				
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return map;
	}
}
