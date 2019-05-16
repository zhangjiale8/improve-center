package com.zjl.lottery.combine.vo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.zjl.lottery.mutitest.LotteryHaveNoMaster;
import com.zjl.tools.ArrayTool;

public class LotteryCombine {
	private String ticketPath;
	private int index;//从第几个开始选择
	private int [] redArr;//红球数组
	private int redtotal;//红球总数
	private int redscreennum;//红选择数
	private int [] blueArr;//篮球数组
	private int bluetotal;//篮球总数
	private int bluescreennum;//篮选择数
	private LotteryTypEnum lotterytyp;
	private ScreenTypEnum screenTypEnum;
	
	private static ArrayList<Integer> tmpArr = new ArrayList<Integer>();
	private static ArrayList<String> loterryLsit = new ArrayList<String>();
	private static ArrayList<Integer> redtmpArr = new ArrayList<Integer>();
	private static ArrayList<String> redloterryLsit = new ArrayList<String>();
	private static ArrayList<Integer> bluetmpArr = new ArrayList<Integer>();
	private static ArrayList<String> blueloterryLsit = new ArrayList<String>();
	
	public LotteryCombine(String ticketPath, int index, int[] redArr, int redtotal, int redscreennum, int[] blueArr,
			int bluetotal, int bluescreennum, LotteryTypEnum lotterytyp, ScreenTypEnum screenTypEnum) {
		super();
		this.ticketPath = ticketPath;
		this.index = index;
		this.redArr = redArr;
		this.redtotal = redtotal;
		this.redscreennum = redscreennum;
		this.blueArr = blueArr;
		this.bluetotal = bluetotal;
		this.bluescreennum = bluescreennum;
		this.lotterytyp = lotterytyp;
		this.screenTypEnum = screenTypEnum;
	}

	public String getTicketPath() {
		return ticketPath;
	}

	public void setTicketPath(String ticketPath) {
		this.ticketPath = ticketPath;
	}

	public ScreenTypEnum getScreenTypEnum() {
		return screenTypEnum;
	}
	public void setScreenTypEnum(ScreenTypEnum screenTypEnum) {
		this.screenTypEnum = screenTypEnum;
	}
	public static ArrayList<Integer> getTmpArr() {
		return tmpArr;
	}
	public static void setTmpArr(ArrayList<Integer> tmpArr) {
		LotteryCombine.tmpArr = tmpArr;
	}
	public static ArrayList<String> getLoterryLsit() {
		return loterryLsit;
	}
	public static void setLoterryLsit(ArrayList<String> loterryLsit) {
		LotteryCombine.loterryLsit = loterryLsit;
	}
	public static ArrayList<Integer> getRedtmpArr() {
		return redtmpArr;
	}
	public static void setRedtmpArr(ArrayList<Integer> redtmpArr) {
		LotteryCombine.redtmpArr = redtmpArr;
	}
	public static ArrayList<String> getRedloterryLsit() {
		return redloterryLsit;
	}
	public static void setRedloterryLsit(ArrayList<String> redloterryLsit) {
		LotteryCombine.redloterryLsit = redloterryLsit;
	}
	public static ArrayList<Integer> getBluetmpArr() {
		return bluetmpArr;
	}
	public static void setBluetmpArr(ArrayList<Integer> bluetmpArr) {
		LotteryCombine.bluetmpArr = bluetmpArr;
	}
	public static ArrayList<String> getBlueloterryLsit() {
		return blueloterryLsit;
	}
	public static void setBlueloterryLsit(ArrayList<String> blueloterryLsit) {
		LotteryCombine.blueloterryLsit = blueloterryLsit;
	}
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int[] getRedArr() {
		return redArr;
	}
	public void setRedArr(int[] redArr) {
		this.redArr = redArr;
	}
	public int getRedtotal() {
		return redtotal;
	}
	public void setRedtotal(int redtotal) {
		this.redtotal = redtotal;
	}
	public int getRedscreennum() {
		return redscreennum;
	}
	public void setRedscreennum(int redscreennum) {
		this.redscreennum = redscreennum;
	}
	public int[] getBlueArr() {
		return blueArr;
	}
	public void setBlueArr(int[] blueArr) {
		this.blueArr = blueArr;
	}
	public int getBluetotal() {
		return bluetotal;
	}
	public void setBluetotal(int bluetotal) {
		this.bluetotal = bluetotal;
	}
	public int getBluescreennum() {
		return bluescreennum;
	}
	public void setBluescreennum(int bluescreennum) {
		this.bluescreennum = bluescreennum;
	}
	public LotteryTypEnum getLotterytyp() {
		return lotterytyp;
	}
	public void setLotterytyp(LotteryTypEnum lotterytyp) {
		this.lotterytyp = lotterytyp;
	}
	
	/**
     * 组合
     * 按一定的顺序取出元素，就是组合,元素个数[C arr.len 3]
     * @param index 元素位置
     * @param k 选取的元素个数
     * @param arr 数组
     */
	public void combine(int index,int nums,int [] param) {
        if(nums == 1){
        	if(null != screenTypEnum) {
        		if(screenTypEnum == ScreenTypEnum.RED) {
        			for (int i = index; i < param.length; i++) {
	          			  redtmpArr.add(param[i]);
	          			  boolean screenflg = screenRedLimit(redtmpArr);
	          			  if(screenflg){
		          			  redloterryLsit.add(redtmpArr.toString());
	          			  }
	                      redtmpArr.remove((Object)param[i]);
                    }
        		}else if(screenTypEnum == ScreenTypEnum.BLUE) {
        			for (int i = index; i < param.length; i++) {
            			  bluetmpArr.add(param[i]);
            			  boolean screenflg  = bluescreenLimit(bluetmpArr);
	          			  if(screenflg){
	          				  blueloterryLsit.add(bluetmpArr.toString());
	          			  }
                          bluetmpArr.remove((Object)param[i]);
                      }
          		}
        	}else {
        		  for (int i = index; i < param.length; i++) {
	        			  tmpArr.add(param[i]);
	        			  loterryLsit.add(tmpArr.toString());
	                      tmpArr.remove((Object)param[i]);
                  }
        	}
          
        }else if(nums > 1){
        	if(null != screenTypEnum) {
        		if(screenTypEnum == ScreenTypEnum.RED) {
        			for (int i = index; i <= param.length - nums; i++) {
                     	 redtmpArr.add(param[i]); //tmpArr都是临时性存储一下
                         combine(i + 1,nums - 1, param); //索引右移，内部循环，自然排除已经选择的元素
                         redtmpArr.remove((Object)param[i]); //tmpArr因为是临时存储的，上一个组合找出后就该释放空间，存储下一个元素继续拼接组合了
                     }
        		}else if(screenTypEnum == ScreenTypEnum.BLUE) {
        			 for (int i = index; i <= param.length - nums; i++) {
                      	bluetmpArr.add(param[i]); //tmpArr都是临时性存储一下
                        combine(i + 1,nums - 1, param); //索引右移，内部循环，自然排除已经选择的元素
                        bluetmpArr.remove((Object)param[i]); //tmpArr因为是临时存储的，上一个组合找出后就该释放空间，存储下一个元素继续拼接组合了
                      }
          		}
        	}else {
        		 for (int i = index; i <= param.length - nums; i++) {
                 	tmpArr.add(param[i]); //tmpArr都是临时性存储一下
                    combine(i + 1,nums - 1, param); //索引右移，内部循环，自然排除已经选择的元素
                    tmpArr.remove((Object)param[i]); //tmpArr因为是临时存储的，上一个组合找出后就该释放空间，存储下一个元素继续拼接组合了
                 }
        	}
          
        }else{
            return ;
        }
    }
	private boolean bluescreenLimit(ArrayList<Integer> bluetmpArr2) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 
	 * @Title: screenLimit   
	 * @Description: 与实体票数据对比 
	 * 默认是全部不出
	 * @param: @param paramList
	 * @param: @return      
	 * @return: boolean      
	 * @throws
	 */
	public boolean screenRedLimit(ArrayList<Integer> paramList) {
		boolean limitflg = false;
		if(null != paramList && paramList.size() > 0) {
			Integer[] listarr = new Integer[paramList.size()];
			paramList.toArray(listarr);
			limitflg = redCompareWithTxt(listarr);
		}
		
		return limitflg;
	}

	public boolean redCompareWithTxt(Integer[] listarr) {
		boolean limitflg = true;
		URL url = LotteryHaveNoMaster.class.getClassLoader().getResource(ticketPath);
		File file = new File(url.getFile());
		if(null != file && file.exists()) {
			//构造一个BufferedReader类来读取文件
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line = null;
				while((StringUtils.isNotEmpty(line = br.readLine()))){//使用readLine方法，一次读一行
	                Pattern p = Pattern.compile("\\s*|\t|\r|\n");
	                Matcher m = p.matcher(line);
	                String temp = m.replaceAll("");
	                String[] strArr = temp.split("\\|");
	                if(null != strArr && strArr.length == 2) {
	                	String redStr = strArr[0];
	                	redStr = redStr.replaceAll("，", ",");
	        			String [] redArr = redStr.split(",");
	                	int nums = 0;
	                	for (int i = 0; i < listarr.length; i++) {
	                		String param = listarr[i] + "";
	                		boolean flg = ArrayTool.isContains(param, redArr);
	                		if(flg){
	                			nums ++;
	                		}
							
						}
	                	
	                	if(nums == redscreennum){
	                		limitflg = false;
	                		break;
	                	}
	                	
	                }
	            }
	            br.close();  
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
		return limitflg;
	}
	
	
}
