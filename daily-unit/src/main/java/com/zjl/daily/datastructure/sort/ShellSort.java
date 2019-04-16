package com.zjl.daily.datastructure.sort;

public class ShellSort {
	public static void main(String[] args) {
		int[] paramArr = { 14,22,25,3,21,30,5,7,2,4,16,11,26,19,20,32,34 };
		shellSort(paramArr);
		for (int i : paramArr) {
			System.out.print(i + " ");
		}
	}
	/**
	 * 希尔排序
	 * @Title: shellSort   
	 * @Description: 
	 * 核心思想：将待排序数组按照步长gap进行分组，然后将每组的元素利用直接插入排序的方法进行排序；每次将gap折半减小，循环上述操作；当gap=1时，利用直接插入，完成排序。同样的：从上面的描述中我们可以发现：希尔排序的总体实现应该由三个循环完成：
	 * 1.第一层循环：将gap依次折半，对序列进行分组，直到gap=1
	 * 2.第二、三层循环：也即直接插入排序所需要的两次循环。
	 * 时间复杂度： 
	 * 空间复杂度： 
	 * @param: @param paramArr      
	 * @return: void      
	 * @throws
	 */
	private static void shellSort(int[] paramArr) {
		if (paramArr == null || paramArr.length <= 1) {
			return;
		}
		// 增量
		int incrementNum = paramArr.length / 2;
		while (incrementNum >= 1) {
			for (int i = 0; i < paramArr.length; i++) {
				// 进行插入排序
				for (int j = i; j < paramArr.length - incrementNum; j = j + incrementNum) {
					if (paramArr[j] > paramArr[j + incrementNum]) {
						int temple = paramArr[j];
						paramArr[j] = paramArr[j + incrementNum];
						paramArr[j + incrementNum] = temple;
					}
				}
			}
			// 设置新的增量
			incrementNum = incrementNum / 2;
		}

	}
}
