package com.zjl.lottery.db.test;

import java.util.ArrayList;
import java.util.Iterator;

import com.zjl.lottery.db.DoubleBallDTO;
import com.zjl.lottery.db.test.vo.CombineVo;
import com.zjl.lottery.util.JDBCPatchUtil;

public class ScreenCombine {
	private static ArrayList<Integer> tmpArr = new ArrayList<Integer>();
	private static ArrayList<String> loterryLsit = new ArrayList<String>();
	public static void main(String[] args) {
		int [] param = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33};
	
		int nums = 6;
		System.out.println("组合结果：");
        combine(0 ,nums ,param);
        ArrayList<CombineVo> list = new ArrayList<CombineVo>();
        System.out.println("组合结果："+loterryLsit.size());
        for (int i = 0; i < loterryLsit.size(); i++) {
        	String redStr = loterryLsit.get(i);
        	CombineVo combineVo = new CombineVo(redStr,"1,2");
        	list.add(combineVo);
		}
        if(null != list && list.size() > 0){
        	 
        	 JDBCPatchUtil.screenDoubleBallBatch(list);
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
                int count = 0;
                for (int j = 0; j < tmpArr.size(); j++) {
					int temp = tmpArr.get(j);
					if(temp%2 == 0){
						count ++;
					}
					
				}
                if(count < 2){
                	String temp = tmpArr.toString();
      				temp = temp.substring(1, temp.length());
      				temp = temp.substring(0, temp.length()-1).replaceAll(" ", "");
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
}
