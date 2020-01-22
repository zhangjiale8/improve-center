package com.zjl.lottery.doubleball.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
import com.zjl.lottery.util.CombineUtil;
import com.zjl.lottery.util.ListDataUtil;
import com.zjl.lottery.util.MapDataUtil;
import com.zjl.tools.ArrayTool;

public class ScreenUtil {
	/**
	 * 三连过滤
	 * @param map
	 * @return
	 */
	public static Map<String, Integer> screenThree(Map<String, Integer> map) {
		Map<String, Integer> screenmap = new HashMap<String, Integer>();
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
	                String[] redArr = temprp.split(",");
        			int[] paramArr = ArrayTool.strArr2InArr(redArr);
        			ArrayList<String> tempList = CombineUtil.getScreenList(paramArr,3);
        			for (Entry<String, Integer> entry : map.entrySet()) {
        				String combine = entry.getKey();
        				String [] combineArr = combine.split(",");
        				for (String temp : tempList) {
        					String [] tempArr = temp.split(",");
        					int nums = 0;
                        	for (int i = 0; i < tempArr.length; i++) {
                        		String param = tempArr[i] + "";
                        		boolean flg = ArrayTool.isContains(param, combineArr);
                        		if(flg){
                        			nums ++;
                        		}
                        		
        					}
                        	if(nums > 2){
                        		screenmap.put(entry.getKey(), entry.getValue());
                        		break;
                        	}
                        	
						}
        			
        			}
                	
	            }
	            br.close();
		} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		for (Entry<String, Integer> entry : screenmap.entrySet()) {
			map.remove(entry.getKey());
		}
		
		//MapDataUtil.createScreenTxtMap(map, "threescreen");
		return map;
	}

	
	/**
	 * 二连过滤
	 * @param map
	 * @return
	 */
	public static Map<String, Integer> screenTwo(Map<String, Integer> map) {
		Map<String, Integer> screenmap = new HashMap<String, Integer>();
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
	                String[] redArr = temprp.split(",");
        			int[] paramArr = ArrayTool.strArr2InArr(redArr);
        			ArrayList<String> tempList = CombineUtil.getScreenList(paramArr,2);
        			for (Entry<String, Integer> entry : map.entrySet()) {
        				String combine = entry.getKey();
        				String [] combineArr = combine.split(",");
        				for (String temp : tempList) {
        					String [] tempArr = temp.split(",");
        					int nums = 0;
                        	for (int i = 0; i < tempArr.length; i++) {
                        		String param = tempArr[i] + "";
                        		boolean flg = ArrayTool.isContains(param, combineArr);
                        		if(flg){
                        			nums ++;
                        		}
                        		
        					}
                        	if(nums > 1){
                        		screenmap.put(entry.getKey(), entry.getValue());
                        		break;
                        	}
                        	
						}
        			
        			}
                	
	            }
	            br.close();
		} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		for (Entry<String, Integer> entry : screenmap.entrySet()) {
			map.remove(entry.getKey());
		}
		
		MapDataUtil.createScreenTxtMap(map, "twoscreen");
		return map;
	}
	
	/**
	 * 双色球固定组合过滤
	 * @param combineMap
	 * @return
	 */
	public static Map<String, Integer> screenDetermined(Map<String, Integer> combineMap) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		String determinedpath = LotteryHaveNoMaster.class.getClassLoader().getResource("data/disticombinedetermined.txt").getPath();
		determinedpath = determinedpath.substring(1, determinedpath.length());
		Map<String, Integer> determinedmap = MapDataUtil.getDataMap(determinedpath);
		 for (Entry<String, Integer> entry : combineMap.entrySet()) {
			 	String combine = entry.getKey();
			 	Integer nums =  entry.getValue();
			 	if( null != determinedmap.get(combine) ){
			 		map.put(combine, nums);
			 	}
	            
        }
		 MapDataUtil.createScreenTxtMap(map, "screendetermined");
		return map; 
		
	}


	public static Map<String, Integer> screenFile(Map<String, Integer> determinedmap, String filepath, int screennum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		Map<String, Integer> datamap = MapDataUtil.getDataMap(filepath);
		for (Entry<String, Integer> entry : datamap.entrySet()) {
			String redStr = entry.getKey();
			if(StringUtils.isNotEmpty(redStr)){
				String[] redArr = redStr.split(",");								
				for (Entry<String, Integer> determineentry : determinedmap.entrySet()) {
					String determine = determineentry.getKey();
					String[] determineArr = determine.split(",");
					int count = 0;
					for (int i = 0; i < redArr.length; i++) {
						String temp = redArr[i];
						boolean flg = ArrayTool.isContains(temp, determineArr);
						if(flg){
							count++;
						}
					}
					if(count >= screennum){
						map.put(determine,1);
					}
				}
				
			}
		}
		for (Entry<String, Integer> entry : map.entrySet()) {
			determinedmap.remove(entry.getKey());
		}
		return determinedmap;
	}
	/**
	 * 单组数据过滤
	 * @param filePath
	 * @param paramArr
	 * @param screenNum
	 * @param maxNum
	 * @param saveFileName
	 */
	public static void screenCombineMapbydata(String filePath, int[] paramArr, int screenNum, int maxNum, String saveFileName) {
		Map<String, Integer> datamap = MapDataUtil.getDataMap(filePath);
		ArrayList<String> screenList = CombineUtil.getScreenList(paramArr,screenNum);
		Map<String, Integer> resultmap = new HashMap<String, Integer>();
		for (Entry<String, Integer> entry : datamap.entrySet()) {
			String [] combineparamArr = entry.getKey().split(",");
			int maxsame= 0;
			for (String screenparam : screenList) {
				String [] screenparamArr = screenparam.split(",");
				int nums = 0;
				for (int i = 0; i < combineparamArr.length; i++) {
					boolean flg = ArrayTool.isContains(combineparamArr[i], screenparamArr);
					if(flg){
						nums ++;
					}
				}
				if(nums > maxsame){
					maxsame = nums;
				}
			}
			
			if(maxsame < maxNum){
				resultmap.put(entry.getKey(), entry.getValue());
			}
		}
		
		if(null != resultmap && resultmap.size() > 0){
			 MapDataUtil.createScreenTxtMap(resultmap, saveFileName);
		}
	}

	/**
	 * 根据出现次数过滤
	 * @param fileName
	 * @param screenNum
	 * @param saveFileName
	 */
	public static void screenCombineMapbycount(String filePath, int screenNum, String saveFileName) {

		Map<String, Integer> datamap = MapDataUtil.getDataMap(filePath);
		Map<String, Integer> resultmap = new HashMap<String, Integer>();
		for (Entry<String, Integer> entry : datamap.entrySet()) {
			int count = entry.getValue();
			
			if(count < screenNum){
				resultmap.put(entry.getKey(), entry.getValue());
			}
		}
		
		if(null != resultmap && resultmap.size() > 0){
			 MapDataUtil.createScreenTxtMap(resultmap, saveFileName);
		}
	
		
	}

	/**
	 * 实体票信息过滤
	 * @param screenhistory
	 * @return
	 */
	public static Map<String, Integer> screenTickets(Map<String, Integer> screenhistory) {
		Map<String, Integer> tickets = DobuleMapDataUtil.getTickets();
		Map<String, Integer> screen = new HashMap<String, Integer>();
		for (Entry<String, Integer> historyentry : screenhistory.entrySet()) {
			screen.put(historyentry.getKey(), historyentry.getValue());
		}
		for (Entry<String, Integer> entry : tickets.entrySet()) {
			String ticket = entry.getKey();
			String[] ticketArr = ticket.split(",");
			if(StringUtils.isNotEmpty(ticket)){
				for (Entry<String, Integer> historyentry : screenhistory.entrySet()) {
					String history = historyentry.getKey();
					String[] historyArr = history.split(",");
					int nums = 0;
					for (String ticketstr : ticketArr) {
						boolean flg = ArrayTool.isContains(ticketstr, historyArr);
						if(flg){
							nums++;
						}
					}
					if(nums > 4){
						screen.remove(history);
					}
				}
			}
			
			
		}
		
		MapDataUtil.createScreenTxtMap(screen, "ticketsscreen");
		return screen;
	}
	/**
	 * 其他实体票信息过滤
	 * @param screenhistory
	 * @return
	 */
	public static Map<String, Integer> screenOtherTickets(Map<String, Integer> screenhistory) {
		Map<String, Integer> tickets = DobuleMapDataUtil.getOtherTickets();
		Map<String, Integer> screen = new HashMap<String, Integer>();
		for (Entry<String, Integer> historyentry : screenhistory.entrySet()) {
			screen.put(historyentry.getKey(), historyentry.getValue());
		}
		for (Entry<String, Integer> entry : tickets.entrySet()) {
			String ticket = entry.getKey();
			String[] ticketArr = ticket.split(",");
			if(StringUtils.isNotEmpty(ticket)){
				for (Entry<String, Integer> historyentry : screenhistory.entrySet()) {
					String history = historyentry.getKey();
					String[] historyArr = history.split(",");
					int nums = 0;
					for (String ticketstr : ticketArr) {
						boolean flg = ArrayTool.isContains(ticketstr, historyArr);
						if(flg){
							nums++;
						}
					}
					if(nums > 4){
						screen.remove(history);
					}
				}
			}
			
			
		}
		
		MapDataUtil.createScreenTxtMap(screen, "otherticketsscreen");
		return screen;
	}


	public static Map<String, Integer> screenRandomTickets(Map<String, Integer> screenhistory) {
		Map<String, Integer> tickets = new HashMap<String, Integer>();
		List<String> list = new ArrayList<String>();
		for (Entry<String, Integer> historyentry : screenhistory.entrySet()) {
			list.add(historyentry.getKey());
		}
		for (int i = 0; i < 1000; i++) {
			int random = (int)((Math.random()*9+1)*1000)/10000*80453;
			String temp = list.get(random);
			tickets.put(temp, 1);
		}
		Map<String, Integer> screen = new HashMap<String, Integer>();
		for (Entry<String, Integer> historyentry : screenhistory.entrySet()) {
			screen.put(historyentry.getKey(), historyentry.getValue());
		}
		for (Entry<String, Integer> entry : tickets.entrySet()) {
			String ticket = entry.getKey();
			String[] ticketArr = ticket.split(",");
			if(StringUtils.isNotEmpty(ticket)){
				for (Entry<String, Integer> historyentry : screenhistory.entrySet()) {
					String history = historyentry.getKey();
					String[] historyArr = history.split(",");
					int nums = 0;
					for (String ticketstr : ticketArr) {
						boolean flg = ArrayTool.isContains(ticketstr, historyArr);
						if(flg){
							nums++;
						}
					}
					if(nums > 4){
						screen.remove(history);
					}
				}
			}
			
			
		}
		
		MapDataUtil.createScreenTxtMap(screen, "randomticketsscreen");
		return screen;
	}

	/**
	 * 同尾号过滤
	 * @Title: screensametails   
	 * @param: @param datamap
	 * @param: @param filename      
	 * @return: void      
	 * @throws
	 */
	public static Map<String, Integer> screensametails(Map<String, Integer> datamap, String filename) {
		Map<String, Integer> resultmap = new HashMap<String, Integer>();
		if(null != datamap && datamap.size() > 0 && StringUtils.isNotEmpty(filename)) {
			for (Entry<String, Integer> entry : datamap.entrySet()) {
				String combine = entry.getKey();
				String[] combineArr = combine.split(",");
				int[] intcombineArr = ArrayTool.strArr2InArr(combineArr);
				int count = ScreenUtil.countSametails(intcombineArr);
				if(count < 3) {
					resultmap.put(combine, entry.getValue());
				}
			}
		}
		MapDataUtil.createScreenTxtMap(resultmap, filename+"sametails");
		return resultmap;
	}
	
	/**
	 * 同尾号过滤
	 * @Title: screensametails   
	 * @param: @param datamap
	 * @param: @param filename      
	 * @return: void      
	 * @throws
	 */
	public static Map<String, Integer> screensametails(Map<String, Integer> datamap) {
		Map<String, Integer> resultmap = new HashMap<String, Integer>();
		if(null != datamap && datamap.size() > 0) {
			for (Entry<String, Integer> entry : datamap.entrySet()) {
				String combine = entry.getKey();
				String[] combineArr = combine.split(",");
				int[] intcombineArr = ArrayTool.strArr2InArr(combineArr);
				int count = ScreenUtil.countSametails(intcombineArr);
				if(count < 3) {
					resultmap.put(combine, entry.getValue());
				}
			}
		}
		return resultmap;
	}

	/**
	 * 计算同尾号个数
	 * @Title: countSametails   
	 * @param: @param intcombineArr
	 * @param: @return      
	 * @return: int      
	 * @throws
	 */
	public static int countSametails(int[] intcombineArr) {
		int nums = 0;
		if(null != intcombineArr && intcombineArr.length > 0) {
			Map<Integer, Integer> datamap = new HashMap<Integer, Integer>();
			for (int i = 0; i < intcombineArr.length; i++) {
				int temp = intcombineArr[i];
				int tail = temp%10;
				int count = null == datamap.get(tail)?1:datamap.get(tail)+1;
				datamap.put(tail, count);
			}
			for (Entry<Integer, Integer> entry : datamap.entrySet()) {
				int count = entry.getValue();
				if(count > 1) {
					nums += count-1;
				}
				
			}
		}
		return nums;
	}

	/**
	 * 去掉 偶数<1 与 奇数<1	
	 * @param: @param resultmap
	 * @param: @return      
	 * @return: Map<String,Integer>      
	 * @throws
	 */
	public static Map<String, Integer> singledoublemin2(Map<String, Integer> resultmap) {
		Map<String, Integer> datamap = new HashMap<String, Integer>();
		for (Entry<String, Integer> entry : resultmap.entrySet()) {
			String[] combinestrArr = entry.getKey().split(",");
			int doublecount = 0;
			int singlecount = 0;
			for (int i = 0; i < combinestrArr.length; i++) {
				int postion = Integer.parseInt(combinestrArr[i]);
				if(postion % 2 == 0) {
					doublecount ++;
				}else {
					singlecount ++;
				}
				
				
			}
			
			if(!(singlecount <1) && !(doublecount <1)) {
				datamap.put(entry.getKey(), entry.getValue());
			}
			
		}
		return datamap;
	}

	/**
	 * 1,2,3三区过滤
	 * @param resultmap
	 * @return
	 */
	public static Map<String, Integer> areascreen(Map<String, Integer> resultmap) {
		Map<String, Integer> datamap = new HashMap<String, Integer>();
		String [] area1 = {"1","2","3","4","5","6","7","8","9","10","11"};
		String [] area2 = {"12","13","14","15","16","17","18","19","20","21","22"};
		String [] area3 = {"23","24","25","26","27","28","29","30","31","32","33"};
		for (Entry<String, Integer> entry : resultmap.entrySet()) {
			String[] combinestrArr = entry.getKey().split(",");
			String[] area1intersectArr = ArrayTool.getIntersectArr(area1, combinestrArr);
			
			String[] area2intersectArr = ArrayTool.getIntersectArr(area2, combinestrArr);
			
			String[] area3intersectArr = ArrayTool.getIntersectArr(area3, combinestrArr);
			if(area1intersectArr.length != 0 
				&& area2intersectArr.length != 0 
				&& area3intersectArr.length != 0){
				
				datamap.put(entry.getKey(), entry.getValue());
				
			}
		}
		return datamap;
	}

	/**
	 * 组合大于5的个数过滤
	 * @param resultmap
	 * @param list
	 * @return
	 */
	public static Map<String, Integer> combine5MultipScreen(Map<String, Integer> resultmap, ArrayList<int[]> list) {
		Map<String, Integer> datamap = new HashMap<String, Integer>();
		for (Entry<String, Integer> entry : resultmap.entrySet()) {
			String combinestr = entry.getKey();
			String[] combineArr = combinestr.split(",");
			int count = 0;
			for (int[] datatempArr : list) {
				String [] datatemstrArr = ArrayTool.intArr2StrArr(datatempArr);
				String[] intersectArr = ArrayTool.getIntersectArr(combineArr, datatemstrArr);
				if(intersectArr.length == 5){
					count ++;
				}
			}
			if(count >3 && count <8){
				datamap.put(entry.getKey(), entry.getValue());
			}
			
		}
		return datamap;
	}
	/**
	 * 尾号过滤
	 * @param resultmap
	 * @return
	 */
	public static Map<String, Integer> termscreen(Map<String, Integer> resultmap) {
		Map<String, Integer> datamap = new HashMap<String, Integer>();
		
		for (Entry<String, Integer> entry : resultmap.entrySet()) {
			String[] sametermArr = ScreenUtil.getSameterm(entry.getKey());
			Map<String, String> historymap = HistoryUtil.getPeriodHistoryMap();
			int count = 0;
			for (Entry<String, String> entry2 : historymap.entrySet()) {
				String combine2 = entry2.getValue();
				String [] combineArr = combine2.split(",");
				String[] intersectArr = ArrayTool.getIntersectArr(sametermArr, combineArr);
				if(intersectArr.length == 6){
					count ++;
				}
			}
			if(count > 0){
				datamap.put(entry.getKey(), entry.getValue());
			}
		}
		return datamap;
	}
	
	/**
	 * 获取同尾所有数
	 * @param curdraw
	 * @return
	 */
	public static String[] getSameterm(String curdraw) {
		String sameterm = "";
		String[] drawArr = curdraw.split(",");
		for (int i = 0; i < drawArr.length; i++) {
			int index = Integer.parseInt(drawArr[i]);
			if(index%10 == 0){
				sameterm +="10,20,30"+",";
			}else if(index%10 == 1){
				sameterm +="1,11,21,31"+",";
			}else if(index%10 == 2){
				sameterm +="2,12,22,32"+",";
			}else if(index%10 == 3){
				sameterm +="3,13,23,33"+",";
			}else if(index%10 == 4){
				sameterm +="4,14,24"+",";
			}else if(index%10 == 5){
				sameterm +="5,15,25"+",";
			}else if(index%10 == 6){
				sameterm +="6,16,26"+",";
			}else if(index%10 == 7){
				sameterm +="7,17,27"+",";
			}else if(index%10 == 8){
				sameterm +="8,18,28"+",";
			}else if(index%10 == 9){
				sameterm +="9,19,29"+",";
			}
		}
		if(StringUtils.isNotEmpty(sameterm) && sameterm.length() > 1){
			sameterm = sameterm.substring(0,sameterm.length() -1);
		}
		return sameterm.split(",");
	}
	/**
	 * 尾数3个以上
	 * @param: @param resultmap
	 * @param: @return      
	 * @return: Map<String,Integer>      
	 * @throws
	 */
	public static Map<String, Integer> tailspanscreen(Map<String, Integer> resultmap) {
		Map<String, Integer> datamap = new HashMap<String, Integer>();
		
		for (Entry<String, Integer> entry : resultmap.entrySet()) {
			Map<String, Integer> tailmap =  new HashMap<String, Integer>();
			String[] drawstrarr = entry.getKey().split(",");
			int[] drawintarr = ArrayTool.strArr2InArr(drawstrarr);
			for (int i = 0; i < drawintarr.length; i++) {
				String tail = drawintarr[i] %10 +"";
				tailmap.put(tail, 1);
			}
			if(tailmap.size() >3) {
				datamap.put(entry.getKey(), entry.getValue());
			}
		}
		return datamap;
	}
	
	/**
	 * 组合数过滤
	 * @param datamap
	 * @return
	 */
	public static Map<String, Integer> screencombinecount(Map<String, Integer> resultmap) {

		Map<String, Integer> datamap = new HashMap<String, Integer>();
		
		for (Entry<String, Integer> entry : resultmap.entrySet()) {
			
			if(entry.getValue() < 4){
				datamap.put(entry.getKey(), entry.getValue());
			}
		}
		return datamap;
	
	}

	/**
	 * 不包括map内容
	 * @param combinemaps
	 * @param wangcai20map
	 * @return
	 */
	public static Map<String, Integer> uncludedmap(Map<String, Integer> combinemaps,
			Map<String, Integer> wangcai20map) {
		Map<String, Integer> datamap = new HashMap<String, Integer>();
		
		for (Entry<String, Integer> entry : combinemaps.entrySet()) {
			if(null == wangcai20map.get(entry.getKey())){
				datamap.put(entry.getKey(), entry.getValue());
			}
		
		}
		return datamap;
	}
	
	/**
	 * 包括map内容
	 * @param combinemaps
	 * @param wangcai20map
	 * @return
	 */
	public static Map<String, Integer> cludedmap(Map<String, Integer> combinemaps,
			Map<String, Integer> wangcai20map) {
		Map<String, Integer> datamap = new HashMap<String, Integer>();
		
		for (Entry<String, Integer> entry : combinemaps.entrySet()) {
			if(null != wangcai20map.get(entry.getKey())){
				datamap.put(entry.getKey(), entry.getValue());
			}
		
		}
		return datamap;
	}

	/**
	 * 组合中至少有几个
	 * @param combinemaps
	 * @param list
	 * @param nums
	 * @return
	 */
	public static Map<String, Integer> listcontaimin(Map<String, Integer> combinemaps, List<String[]> list,
			int nums) {
		Map<String, Integer> datamap = new HashMap<String, Integer>();
		
		for (Entry<String, Integer> entry : combinemaps.entrySet()) {
			int min = 6;
			for (String[] divinearr : list) {
				String[] combinearr = entry.getKey().split(",");
				String[] intersectArr = ArrayTool.getIntersectArr(divinearr, combinearr);
				if(intersectArr.length < min){
					min = intersectArr.length;
				}
			}
			if(min >= nums){
				datamap.put(entry.getKey(), entry.getValue());
			}
		
		}
		return datamap;
	}

	/**
	 * 组合中至少有几个最多有几个
	 * @param combinemaps
	 * @param list
	 * @param minnums
	 * @param maxnums
	 * @return
	 */
	public static Map<String, Integer> listcontain(Map<String, Integer> combinemaps, List<String[]> list,
			int minnums, int maxnums) {

		Map<String, Integer> datamap = new HashMap<String, Integer>();
		
		for (Entry<String, Integer> entry : combinemaps.entrySet()) {
			int min = 6;
			int max = 0;
			for (String[] divinearr : list) {
				String[] combinearr = entry.getKey().split(",");
				String[] intersectArr = ArrayTool.getIntersectArr(divinearr, combinearr);
				if(intersectArr.length < min){
					min = intersectArr.length;
				}
				if(intersectArr.length > max){
					max = intersectArr.length;
				}
			}
			if(min >= minnums && max <= maxnums){
				datamap.put(entry.getKey(), entry.getValue());
			}
			
			
		
		}
		return datamap;
	
	}

	/**
	 * 
	 * 最多出现次数过滤
	 * @param combinemaps
	 * @param maxnums
	 * @return
	 */
	public static Map<String, Integer> timesscreen(Map<String, Integer> combinemaps, int maxnums) {
		Map<String, Integer> datamap = new HashMap<String, Integer>();
		String filepath = "E:" + File.separator + "screen" + File.separator +"initcombinedoubleball.txt";
		Map<String, Integer> initmaps = MapDataUtil.getDataMap(filepath);
		for (Entry<String, Integer> entry : combinemaps.entrySet()) {
			Integer count = entry.getValue();
			Integer initcount = initmaps.get(entry.getKey());
			if(null != count && count <= maxnums && null != initcount){
				datamap.put(entry.getKey(), entry.getValue());
			}
			
			
		
		}
		return datamap;
	}


}
