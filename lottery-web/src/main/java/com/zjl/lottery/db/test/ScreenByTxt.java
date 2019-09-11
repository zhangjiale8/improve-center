package com.zjl.lottery.db.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.zjl.lottery.db.test.vo.CombineVo;
import com.zjl.lottery.util.JDBCPatchUtil;
import com.zjl.tools.ArrayTool;

public class ScreenByTxt {
	private static ArrayList<Integer> tmpArr = new ArrayList<Integer>();
	private static ArrayList<String> loterryLsit = new ArrayList<String>();
	public static void main(String[] args) {
		int [] param = {1,10,15,18,19,21,24,26,27,29,30,32};
		int screenNums = 5;
		System.out.println("组合结果：");
        combine(0 ,screenNums ,param);
        ArrayList<String> screenList = new ArrayList<String>();
       if(null != loterryLsit && loterryLsit.size() > 0){
    	   for (int i = 0; i < loterryLsit.size(); i++) {
    		   String screenStr = loterryLsit.get(i)+",6";
    		   screenList.add(screenStr);
    	   }
       }
       ScreenRedList(screenList,screenNums);
        
        
	}
	/**
	 * 筛选数据
	 * @param screenList
	 */
	private static void ScreenRedList(ArrayList<String> screenList,int screenNums) {
		 if(null != screenList && screenList.size() > 0){
			 try {
				 ArrayList<String> resultList = new ArrayList<String>();
				 File file = new File("D:" + File.separator + "demo" + File.separator + "test.txt");
				 for (int i = 0; i < screenList.size(); i++) {
					String screenStr = screenList.get(i);
					if (file.isFile() && file.exists() && StringUtils.isNotEmpty(screenStr)) { //判断文件是否存在
						InputStreamReader read = new InputStreamReader(new FileInputStream(file));//考虑到编码格式
				        BufferedReader br = new BufferedReader(read);
						String line = null;
						while((StringUtils.isNotEmpty(line = br.readLine()))){//使用readLine方法，一次读一行
							Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			                Matcher m = p.matcher(line);
			                String redStr= m.replaceAll("");
			                if(StringUtils.isNotEmpty(redStr)){
			                	redStr = redStr.replaceAll("，", ",");
			                	screenStr = screenStr.replaceAll("，", ",");
			        			String [] redArr = redStr.split(",");
			        			String [] screenArr = screenStr.split(",");
			                	int nums = 0;
			                	for (int j = 0; j < redArr.length; j++) {
			                		String param = redArr[j] + "";
			                		boolean flg = ArrayTool.isContains(param, screenArr);
			                		if(flg){
			                			nums ++;
			                		}
									
								}
			                	if(nums != screenNums){
			                		resultList.add(redStr);
			                	}
			                }
		                	
						}
						 br.close();
					}
					
				}
				if(null != resultList && resultList.size() > 0){
			        if(file.getParentFile().exists()){
		                file.delete();
			        }else{
			        	 file.getParentFile().mkdirs();
			        }
			        //2：准备输出流
			         Writer out = new FileWriter(file);
		            for (int i = 0; i < resultList.size(); i++) {
		            	String temp = resultList.get(i);
		            	out.write(temp+System.getProperty("line.separator"));
					}
		            out.close();
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			 
		 }
		
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
                String temp = tmpArr.toString();
  				temp = temp.substring(1, temp.length());
  				temp = temp.substring(0, temp.length()-1).replaceAll(" ", "");
                loterryLsit.add(temp);
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
}
