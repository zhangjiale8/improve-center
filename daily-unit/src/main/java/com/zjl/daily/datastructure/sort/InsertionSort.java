package com.zjl.daily.datastructure.sort;

public class InsertionSort {
	public static void main(String[] args) {
		int[] paramArr = { 49, 38, 65, 97, 76, 13, 27, 50 };
		insertionSort(paramArr);
		for (int i : paramArr) {
			System.out.print(i + " ");
		}
	}
	/**
	 * 
	 * @Title: insertionSort   
	 * @Description: 插入排序 
	 * 
	 * 核心思想：
	 * 将数组中的所有元素依次跟前面已经排好的元素相比较，如果选择的元素比已排序的元素小，则交换，直到全部元素都比较过。
	 * 因此，从上面的描述中我们可以发现，直接插入排序可以用两个循环完成：
	 * 1.第一层循环：遍历待比较的所有数组元素
	 * 2.第二层循环：将本轮选择的元素(selected)与已经排好序的元素(ordered)相比较。如果：selected > ordered，那么将二者交换
	 * 
	 * 时间复杂度： 平均O(n^2),最好O(n),最坏O(n^2);空间复杂度O(1);稳定;简单
	 * 空间复杂度： 
	 * @param: @param a      
	 * @return: void      
	 * @throws
	 */
	private static void insertionSort(int[] paramArr) {
		int tmp;
        for (int i = 1; i < paramArr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (paramArr[j] < paramArr[j - 1]) {
                    tmp = paramArr[j - 1];
                    paramArr[j - 1] = paramArr[j];
                    paramArr[j] = tmp;
                }
            }
        }	
		
	}
}
