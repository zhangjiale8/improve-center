package com.zjl.lottery.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class CombineUtil {
	private static ArrayList<Integer> tmpArr = new ArrayList<Integer>();
	private static ArrayList<String> loterryLsit = new ArrayList<String>();
	/**
     * 组合
     * 按一定的顺序取出元素，就是组合,元素个数[C arr.len 3]
     * @param index 元素位置
     * @param k 选取的元素个数
     * @param arr 数组
     */
    public static void combine(int index,int nums,int [] param) {
        if(nums == 1){
        	
            for (int i = index; i < param.length; i++) {
                tmpArr.add(param[i]);
                String temp = "";
                for (int j = 0; j < tmpArr.size(); j++) {
                	temp += tmpArr.get(j) +",";
				}
                if(StringUtils.isNotEmpty(temp)){
                	temp = temp.substring(0, temp.length()-1);
                    loterryLsit.add(temp);
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
    
    /**
     * 获取所有组合
     * @param paramArr
     * @param screenNum
     * @return
     */
	public static ArrayList<String> getScreenList(int[] paramArr, int screenNum) {
		tmpArr = new ArrayList<Integer>();
		loterryLsit = new ArrayList<String>();
		combine(0 ,screenNum ,paramArr);
		return loterryLsit;
	}
    /**
     * 获取所有组合Map
     * @param: @param screenarray
     * @param: @return      
     * @return: Map<String,Integer>      
     * @throws
     */
	public static Map<String, Integer> getCombineMap(int[] paramArr,int screenNum) {
		Map<String, Integer> screenmap = new HashMap<String, Integer>();
		tmpArr = new ArrayList<Integer>();
		loterryLsit = new ArrayList<String>();
		combine(0 ,screenNum ,paramArr);
		for (String screen : loterryLsit) {
			screenmap.put(screen, 1);
		}
		return screenmap;
	}
	
	/**
     * 获取大乐透全组合Map
     * @param: @param screenarray
     * @param: @return      
     * @return: Map<String,Integer>      
     * @throws
     */
	public static Map<String, Integer> getLottoCombineMap() {
		Map<String, Integer> screenmap = new HashMap<String, Integer>();
		tmpArr = new ArrayList<Integer>();
		List<String> combinelist = CombineUtil.getLottoCombineList();
		for (String screen : combinelist) {
			screenmap.put(screen, 1);
		}
		return screenmap;
	}
	
	/**
     * 获取大乐透全组合list
     * @param paramArr
     * @param screenNum
     * @return
     */
	public static ArrayList<String> getLottoCombineList() {
		
		int screenNum = 5;
		int[] paramArr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35};
		ArrayList<String> combinelist = CombineUtil.getScreenList(paramArr, screenNum);
		return combinelist;
	}
	
	/**
     * 获取双色球全组合Map
     * @param: @param screenarray
     * @param: @return      
     * @return: Map<String,Integer>      
     * @throws
     */
	public static Map<String, Integer> getDoubleBallCombineMap() {
		Map<String, Integer> screenmap = new HashMap<String, Integer>();
		List<String> combinelist = CombineUtil.getDoubleBallCombineList();
		for (String screen : combinelist) {
			screenmap.put(screen, 1);
		}
		return screenmap;
	}
	
	/**
     * 获取双色球全组合list
     * @param paramArr
     * @param screenNum
     * @return
     */
	public static ArrayList<String> getDoubleBallCombineList() {
		int screenNum = 6;
		int[] paramArr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33};
		ArrayList<String> combinelist = CombineUtil.getScreenList(paramArr, screenNum);
		return combinelist;
	}
}
