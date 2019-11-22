package com.zjl.lottery.doubleball.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.zjl.lottery.doubleball.mutitest.LotteryHaveNoMaster;
import com.zjl.lottery.doubleball.util.MultipParamsListUtil;
import com.zjl.tools.ArrayTool;

public class DobuleMapDataUtil {
	

	public static Map<String, Integer> getTickets() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		String path = "";
		path = "data/tickets/double.txt";
		URL url = LotteryHaveNoMaster.class.getClassLoader().getResource(path);
		File file = new File(url.getFile());
		if(null != file && file.exists()) {
		 try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line = null;
				while((StringUtils.isNotEmpty(line = br.readLine()))){//使用readLine方法，一次读一行
	               
	                String[] strArr = line.split("\\|");
	                String redStr = strArr[0];	               
	                map.put(redStr,1);
	            }
	            br.close();
		} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		return map;
	}
	/**
	 * 获取购买的实体票信息
	 * @return
	 */
	public static Map<String, Integer> getOtherTickets() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		String path = "";
		path = "data/tickets/otherticket.txt";
		URL url = LotteryHaveNoMaster.class.getClassLoader().getResource(path);
		File file = new File(url.getFile());
		if(null != file && file.exists()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line = null;
				while((StringUtils.isNotEmpty(line = br.readLine()))){//使用readLine方法，一次读一行
					
					map.put(line.trim(),1);
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		return map;
	}
	
}
