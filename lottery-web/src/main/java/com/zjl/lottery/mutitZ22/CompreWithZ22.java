package com.zjl.lottery.mutitZ22;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import com.zjl.tools.ArrayTool;

public class CompreWithZ22 {
	public static void main(String[] args) {
		//97期
		//int [] param = {1,2,3,4,5,7,8,9,10,13,14,17,22,23,27,28,31,32,33};
		//int [] param = {1,2,17,20,25,28};
		//98期
		//int [] param = {1,3,6,10,11,12,13,14,16,17,19,21,22,24,25,27,28,29,30,31};
		//int [] param = {6,10,11,20,29,32};
		//99期
		//int [] param = {3,5,6,7,8,10,13,15,17,19,21,22,23,25,26,28,29,30,31,32};
		//int [] param = {3,7,8,14,25,32};
		//100期
		//int [] param = {1,2,4,5,6,9,10,12,13,15,16,17,18,19,28,29,30,31,32,33};
		//int [] param = {2,11,14,15,29,33};
		//101期
		//int [] param = {1,3,5,7,9,10,13,14,16,17,19,21,23,25,26,27,29,30,31,32};
		//int [] param = {1,3,14,26,29,33};
		//102期
		//int [] param = {2,3,5,8,9,11,13,15,16,17,18,19,20,22,25,26,28,29,31,32};
		//int [] param = {3,4,7,8,9,10,13,14,17,19,20,21,23,25,26,28,29,30,32,33};
		//int [] param = {2,6,11,19,21,28};
		//103期
		//int [] param = {1,2,4,7,8,10,12,14,18,19,20,22,23,25,26,27,29,30,31,33};
		//int [] param = {1,3,6,8,9,11,13,15,17,18,19,22,23,25,26,27,28,31,32,33};
		//int [] param = {2,9,15,22,23,24};
		//104期
		//int [] param = {2,5,6,7,8,11,13,15,17,19,21,22,23,25,27,28,29,30,32,33};
		//int [] param = {2,4,5,7,8,10,12,13,15,17,18,21,22,24,25,27,29,31,32,33};
		int [] param = {3,5,14,17,22,31};
		//int [] param = {5,6,8,11,28,30};
		Map<String, Map<String, String>> result = compare(param);
	}

	private static Map<String, Map<String, String>> compare(int[] param) {
		Map<String, Map<String, String>> result = new HashMap<String, Map<String,String>>();
		URL url = LotteryHaveMaster.class.getClassLoader().getResource("Z22/001.txt");
		File file = new File(url.getFile());
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = null;
			while((StringUtils.isNotEmpty(line = br.readLine()))){//使用readLine方法，一次读一行
                Pattern p = Pattern.compile("\\s*|\t|\r|\n");
                Matcher m = p.matcher(line);
                String id = m.replaceAll("").split(":")[0];
                String reStr = m.replaceAll("").split(":")[1];
                String[] redArr = reStr.replaceAll("，", ",").split(",");
                int [] redTemp = ArrayTool.strArr2InArr(redArr);
                int[] same = ArrayTool.getSameElements(param,redTemp);
                int length = 0;
                if(null  != same){
                      length = same.length;
                	  System.out.println(id+":"+ArrayUtils.toString(same, ","));
                }else{
                	System.out.println(id+":null");
                }
              
                System.out.println("百分百:"+(double)length/20);	
                	
            }
            br.close(); 
		} catch (Exception e) {
			e.getStackTrace();
		}
		return null;
	}

	
}
