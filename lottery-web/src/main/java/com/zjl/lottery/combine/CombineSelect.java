package com.zjl.lottery.combine;

import java.util.ArrayList;
import java.util.Iterator;

public class CombineSelect {
	private static ArrayList<Integer> tmpArr = new ArrayList<Integer>();
	private static ArrayList<String> loterryLsit = new ArrayList<String>();
	public static void main(String[] args) {
		int [] param = {2,4,5,6,7,8,9,10,11,14,16,17,18,19,21,27,28,29,30,33};
		int nums = 6;
		System.out.println("组合结果：");
        combine(0 ,nums ,param);
        int totalSize = loterryLsit.size();
        int res8 = (int) (totalSize * 0.08);
        int res18 = (int) (totalSize * 0.18);
        int res66 = (int) (totalSize * 0.66);
        int res88 = (int) (totalSize * 0.88);
        int res99 = (int) (totalSize * 0.99);
        System.out.println(loterryLsit.get(res8));
        System.out.println(loterryLsit.get(res18));
        System.out.println(loterryLsit.get(res66));
        System.out.println(loterryLsit.get(res88));
        System.out.println(loterryLsit.get(res99));
        
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
                    //System.out.println(tmpArr.toString() + ",");
                    loterryLsit.add(tmpArr.toString());
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
