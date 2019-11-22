package com.zjl.lottery.combine.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import com.zjl.lottery.doubleball.mutitZ22.LotteryHaveMaster;
import com.zjl.tools.ArrayTool;

public class CombineaaAndCompare22 {
	private static ArrayList<Integer> tmpArr = new ArrayList<Integer>();
	public static void main(String[] args) {
		//int [] param = {1,3,7,8,11,13,21,28,31,32,33};
		int [] param = {2,5,6,7,8,13,15,18,19,20,22,25,26,32,33};
		int nums = 6;
		System.out.println("组合结果：");
        combine(0 ,nums ,param);
	}

	/**
     * 组合
     * 按一定的顺序取出元素，就是组合,元素个数[C arr.len 3]
     * @param index 元素位置
     * @param k 选取的元素个数
     * @param arr 数组
     */
    public static void combine(int index,int nums,int []param) {
        if(nums == 1){
            for (int i = index; i < param.length; i++) {
                tmpArr.add(param[i]);
                int count = 0;
                for (int j = 0; j < tmpArr.size(); j++) {
					int temp = tmpArr.get(j);
					if(temp%2 == 0){
						count ++;
					}
					
				}
                if(count > 1){
                    compare22(tmpArr);
                }
                tmpArr.remove((Object)param[i]);
            }
        }else if(nums > 1){
            for (int i = index; i <= param.length - nums; i++) {
                tmpArr.add(param[i]); //tmpArr都是临时性存储一下
                combine(i + 1,nums - 1, param); //索引右移，内部循环，自然排除已经选择的元素
                tmpArr.remove((Object)param[i]); //tmpArr因为是临时存储的，上一个组合找出后就该释放空间，存储下一个元素继续拼接组合了
            }
        }else{
            return ;
        }
    }

	
	
	private static Map<String, Map<String, String>> compare22(ArrayList<Integer> paramList) {
		int [] param = new int[paramList.size()];
		for (int i = 0; i < paramList.size(); i++) {
			param[i] = paramList.get(i);
		}
		Map<String, Map<String, String>> result = new HashMap<String, Map<String,String>>();
		URL url = LotteryHaveMaster.class.getClassLoader().getResource("Z22/001.txt");
		File file = new File(url.getFile());
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = null;
			int sum30 = 0;
			int sum = 0;
			boolean flag = true;
			Map<String, String> map = new HashMap<String, String>();
			
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
                      double percent = (double)length/20;
                      if(percent == 0.25 || percent == 0.3 ){
                    	  sum ++;
                    	  if(percent == 0.3){
                    		  sum30 ++;
                    	  }
                    	  if(sum  > 4){
                    		  flag = false;
                    	  }
                    	  if(sum30  > 1){
                    		  flag = false;
                    	  }
                    	  map.put(id, ArrayUtils.toString(same, ","));
                    	  //System.out.println(id+":"+ArrayUtils.toString(same, ",")); 
                      }
                                         
                }
              
                	
            }
			
			if(flag){
				System.out.println("号码："+ArrayUtils.toString(param, ","));
				System.out.println("-------------------------------------------------------");
				for(Map.Entry<String, String> entry : map.entrySet()) {
            		String key = entry.getKey();
            		String value = map.get(key);
            		if("3".equals(key) || "4".equals(key) || "5".equals(key)){

            		}
            		System.out.println(key +" : "+value);

            	}
				System.out.println("-------------------------------------------------------");
			}
            br.close(); 
		} catch (Exception e) {
			e.getStackTrace();
		}
		return null;
	}
}
