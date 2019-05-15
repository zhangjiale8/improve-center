package com.zjl.lottery.combine;

import java.util.ArrayList;

public class CombineTest {
	private static ArrayList<Integer> tmpArr = new ArrayList<Integer>();
	public static void main(String[] args) {
		int [] param = {4,6,9,5,0,3,2,10};
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
                System.out.println(tmpArr.toString() + ",");
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
