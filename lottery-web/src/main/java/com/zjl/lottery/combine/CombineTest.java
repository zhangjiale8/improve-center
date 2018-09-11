package com.zjl.lottery.combine;

import java.util.ArrayList;

public class CombineTest {
	private static ArrayList<Integer> tmpArr = new ArrayList<Integer>();
	public static void main(String[] args) {
		//int [] param = {1,3,7,8,11,13,21,28,31,32,33};
		int [] param = {30,15,4,12,32,1,9,28,29,31,6,18,22,33};
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
                boolean falg1 = false;
                boolean falg2 = false;
                for (int j = 0; j < tmpArr.size(); j++) {
					int temp = tmpArr.get(j);
					if(temp%2 == 0){
						count ++;
					}
					if(!falg1 && temp==30){
						falg1 = true;
					}
					if(!falg2 && temp==15){
						falg2 = true;
					}
				}
                if(count > 1 && falg1 || falg2){
                    System.out.println(tmpArr.toString() + ",");
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
