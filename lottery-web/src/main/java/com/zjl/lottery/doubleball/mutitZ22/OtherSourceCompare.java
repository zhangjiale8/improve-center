package com.zjl.lottery.doubleball.mutitZ22;

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

public class OtherSourceCompare {
	public static void main(String[] args) {
		
		int [] param = {};
		Map<String, Map<String, String>> result = compare(param);
	}

	private static Map<String, Map<String, String>> compare(int[] param) {
		Map<String, Map<String, String>> result = new HashMap<String, Map<String,String>>();
		URL url = LotteryHaveMaster.class.getClassLoader().getResource("122/00401.txt");
		File file = new File(url.getFile());
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = null;
			int index = 0;
			while((StringUtils.isNotEmpty(line = br.readLine()))){//使用readLine方法，一次读一行
                Pattern p = Pattern.compile("\\s*|\t|\r|\n");
                Matcher m = p.matcher(line);
                String reStr = m.replaceAll("");
                String[] redArr = reStr.replaceAll("，", ",").split(",");
                int [] redTemp = ArrayTool.strArr2InArr(redArr);
                int[] same = ArrayTool.getSameElements(param,redTemp);
                int length = 0;
                if(null  != same){
                      length = same.length;
                	  System.out.println(++index+":"+ArrayUtils.toString(same, ","));
                }else{
                	System.out.println(++index+":null");
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
