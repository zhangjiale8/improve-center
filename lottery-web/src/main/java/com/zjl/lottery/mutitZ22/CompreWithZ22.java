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
		
	
		//109期
		//int [] param = {1,2,3,5,7,9,11,13,15,16,17,20,22,24,27,28,29,30,31,32};
		int [] param = {2,4,6,8,9,11,13,14,15,16,17,20,21,22,23,24,26,29,30,33};
		//int [] param = {10,11,18,23,31,33};
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
