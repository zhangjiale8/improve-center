package com.zjl.lottery.util;

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

import com.zjl.lottery.combine.util.CombineUtil;
import com.zjl.lottery.mutitest.LotteryHaveNoMaster;
import com.zjl.tools.ArrayTool;

public class MapTxtUtil {
	/**
	 * Map集合打印
	 * @param map
	 * @param fileName
	 */
	public static void createScreenTxtMap(Map<String, Integer> map, String fileName) {
		//if(null != map && map.size() > 0 && StringUtils.isNotEmpty(fileName)){
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
		//}
		
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
							int  length = lineArr[1].split(",").length;
							if(length > 1){
								map.put(lineArr[0], 1);
							}else{								
								int num = Integer.valueOf(lineArr[1]);
								map.put(lineArr[0],num);
							}
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
	
	/**
	 * 返回Map集合
	 * @param filePath
	 * @return
	 */
	public static Map<String, Integer> getDataMap(List<String> filepathlist,int screennum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		if (null != filepathlist && filepathlist.size() > 0) {
			try {
				for (String filepath : filepathlist) {
					File file = new File(filepath);
					if (null != file && file.exists()) {

						BufferedReader br = new BufferedReader(new FileReader(file));
						String line = null;
						while ((StringUtils.isNotEmpty(line = br.readLine()))) {// 使用readLine方法，一次读一行
							String[] lineArr = line.split("\\|");
							String redStr = lineArr[0];
							if(StringUtils.isNotEmpty(redStr)){
								String[] redArr = redStr.split(",");
								int[] redIntArr = ArrayTool.strArr2InArr(redArr);
								ArrayList<String> combineList = CombineUtil.getScreenList(redIntArr, 6);
								for (String combine : combineList) {
									map.put(combine, 1);

								}
							}
							
						}
						br.close();

					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return map;
	}

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
	/**
	 * 获取三连数据
	 */
	public static Map<String, Integer> getThreeMap() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		String path = "";
		path = "data/threecontinue.txt";
		URL url = LotteryHaveNoMaster.class.getClassLoader().getResource(path);
		File file = new File(url.getFile());
		if(null != file && file.exists()) {
		 try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line = null;
				while((StringUtils.isNotEmpty(line = br.readLine()))){//使用readLine方法，一次读一行
	                Pattern p = Pattern.compile("\\s*|\t|\r|\n");
	                Matcher m = p.matcher(line);
	                String temprp = m.replaceAll("");
	                map.put(temprp, 1);
	            }
	            br.close();
		} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return map;
	}
	/**
	 * 获取二连数据
	 */
	public static Map<String, Integer> getTwoMap() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		String path = "";
		path = "data/twocontinue.txt";
		URL url = LotteryHaveNoMaster.class.getClassLoader().getResource(path);
		File file = new File(url.getFile());
		if(null != file && file.exists()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line = null;
				while((StringUtils.isNotEmpty(line = br.readLine()))){//使用readLine方法，一次读一行
					Pattern p = Pattern.compile("\\s*|\t|\r|\n");
					Matcher m = p.matcher(line);
					String temprp = m.replaceAll("");
					map.put(temprp, 1);
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return map;
	}
	
	/**
	 * 获取22组数据
	 */
	public static Map<String, Integer> get22ArrayMap() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		String path = "";
		path = "Z22/001.txt";
		URL url = LotteryHaveNoMaster.class.getClassLoader().getResource(path);
		File file = new File(url.getFile());
		if(null != file && file.exists()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line = null;
				while((StringUtils.isNotEmpty(line = br.readLine()))){//使用readLine方法，一次读一行
					Pattern p = Pattern.compile("\\s*|\t|\r|\n");
					Matcher m = p.matcher(line);
					String temprp = m.replaceAll("");
					String[] combineArr = temprp.split(":");
					map.put(combineArr[1], 1);
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return map;
	}
	
	/**
	 * 获取22组组合数据
	 */
	public static Map<String, Integer> get22ArrayCombineMap() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		String path = "";
		path = "Z22/001.txt";
		URL url = LotteryHaveNoMaster.class.getClassLoader().getResource(path);
		File file = new File(url.getFile());
		if(null != file && file.exists()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line = null;
				while((StringUtils.isNotEmpty(line = br.readLine()))){//使用readLine方法，一次读一行
					Pattern p = Pattern.compile("\\s*|\t|\r|\n");
					Matcher m = p.matcher(line);
					String temprp = m.replaceAll("");
					String[] combineArr = temprp.split(":");
					String combine = combineArr[1];
					String[] combinetempArr = combine.split(",");
					int[] combinetempIntArr = ArrayTool.strArr2InArr(combinetempArr);
					Map<String, Integer> screenmap = MultipParamsListUtil.getScreenMap(combinetempIntArr);
					for (Entry<String, Integer> array22entry : screenmap.entrySet()) {
						Integer count =  map.get(array22entry.getKey());
						if(null == count){
							count = 1;
						}else{
							count++;
						}
						map.put(array22entry.getKey(), count);
					}
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return map;
	}
}
