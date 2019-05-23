package com.zjl.lottery.combine.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.zjl.lottery.combine.CombineMain;
import com.zjl.lottery.combine.vo.CombineGenerate;
import com.zjl.lottery.combine.vo.LotteryTypEnum;
import com.zjl.lottery.combine.vo.ScreenTypEnum;
import com.zjl.lottery.mutitest.LotteryHaveNoMaster;
import com.zjl.tools.ArrayTool;

public class InitCombineParam {

	public static CombineGenerate init(LotteryTypEnum lotteryTyp, ScreenTypEnum screenTypEnum, Integer screenNum,
			int[] otherArr, String periods) {
		CombineGenerate combineGenerate = null;
	    try {
	    	Properties properties = new Properties();
		    // 使用ClassLoader加载properties配置文件生成对应的输入流
		    InputStream in = null;
		    if(in == null && null != lotteryTyp){
		    	if(lotteryTyp == LotteryTypEnum.DOUBLE_BALL){
				    in = CombineMain.class.getClassLoader().getResourceAsStream("properties/lottery/1.properties");
		    	}else if(lotteryTyp == LotteryTypEnum.GREAT_LOTTO){
		    		in = CombineMain.class.getClassLoader().getResourceAsStream("properties/lottery/2.properties");
		    	}
		    	 // 使用properties对象加载输入流
				properties.load(in);
				//获取key对应的value值
				LotteryTypEnum lotterytyp = LotteryTypEnum.getEnumByKey(properties.getProperty("lottery.lotterytyp"));
				int index = 0;
			    String ticketpath = periods+"/"+properties.getProperty("lottery.ticketpath");
			    String redStr = properties.getProperty("lottery.redarr");
			    int[] redArr = Str2IntArr(redStr);
			    int redscreennum = Integer.valueOf(properties.getProperty("lottery.redscreennum"));
			    String blueStr = properties.getProperty("lottery.bluearr");
			    int[] blueArr = Str2IntArr(blueStr);
			    int bluescreennum = Integer.valueOf(properties.getProperty("lottery.bluescreennum"));
			    if(null != screenNum && null != screenTypEnum && null != otherArr && otherArr.length > 0) {
			    	if(screenTypEnum == ScreenTypEnum.RED) {
			    		redArr = otherArr;
			    		redscreennum = screenNum;			
			    	}else if(screenTypEnum == ScreenTypEnum.BLUE) {
			    		blueArr = otherArr;
			    		bluescreennum = screenNum;			
			    	}
			    }
			    int redtotal = Integer.valueOf(properties.getProperty("lottery.redtotal"));
			    int bluetotal = Integer.valueOf(properties.getProperty("lottery.bluetotal"));
			    combineGenerate = new CombineGenerate(ticketpath, index, redArr, redtotal, redscreennum, blueArr, bluetotal, bluescreennum, lotterytyp, ScreenTypEnum.RED);
			    combineGenerate.redgenerate();
		    }
		   
		    
	    } catch (IOException e) {
			e.printStackTrace();
		}
		return combineGenerate;	    
	
	}


	public static int[] Str2IntArr(String str) {
		str = str.replaceAll("，", ",");
		String [] arr = str.split(",");
		return ArrayTool.strArr2InArr(arr);
	}

	public static void screenRedTxt(CombineGenerate combineGenerate, int maxSame) throws Exception {
		int size = combineGenerate.getRedloterryLsit().size();
	    System.out.println(size);
	    ArrayList<String> redloterryLsit = combineGenerate.getRedloterryLsit();
	    InitCombineParam.screenRedTxt(combineGenerate,maxSame);
	    if(null != redloterryLsit && redloterryLsit.size() > 0){
	    	 File file = new File("D:" + File.separator + "demo" + File.separator + "test.txt");
	         if(!file.getParentFile().exists()){
                file.getParentFile().mkdirs();
            }
            
            //2：准备输出流
            Writer out = new FileWriter(file);
            for (int i = 0; i < redloterryLsit.size(); i++) {
            	String temp = redloterryLsit.get(i);
            	String [] arry = temp.split(",");
            	boolean printFlg = filterResult(arry,combineGenerate,maxSame);
            	if(printFlg){
                	out.write(temp+System.getProperty("line.separator"));

            	}
			}
            out.close();
            
	    }
		
	}


	private static boolean filterResult(String[] arry, CombineGenerate combineGenerate, int maxSame) throws Exception {
		boolean limitflg = true;
		String path = combineGenerate.getTicketPath();
		path = path.substring(0, path.length()-3)+"008";
		URL url = LotteryHaveNoMaster.class.getClassLoader().getResource(path);
		File file = new File(url.getFile());
		if(null != file && file.exists()) {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = null;
			while((StringUtils.isNotEmpty(line = br.readLine()))){//使用readLine方法，一次读一行
                Pattern p = Pattern.compile("\\s*|\t|\r|\n");
                Matcher m = p.matcher(line);
                String temprp = m.replaceAll("");
                String[] strArr = temprp.split("\\|");
                if(null != strArr && strArr.length == 2) {
                	String redStr = strArr[0];
                	redStr = redStr.replaceAll("，", ",");
        			String [] redArr = redStr.split(",");
                	int nums = 0;
                	for (int i = 0; i < arry.length; i++) {
                		String param = arry[i] + "";
                		boolean flg = ArrayTool.isContains(param, redArr);
                		if(flg){
                			nums ++;
                		}
						
					}
                	
                	if(nums > maxSame){
                		limitflg = false;
                		break;
                	}
                	
                }
            }
            br.close();
		}
		return limitflg;
	}
}
