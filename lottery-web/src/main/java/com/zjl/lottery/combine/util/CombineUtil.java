package com.zjl.lottery.combine.util;

import java.util.ArrayList;

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
		combine(0 ,screenNum ,paramArr);
		return loterryLsit;
	}
    
    

}
