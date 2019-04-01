package com.zjl.daily.datastructure.sort;

public class ShellSort {
	public static void main(String[] args) {
		int[] paramArr = { 49, 38, 65, 97, 76, 13, 27, 50 };
		shellSort(paramArr);
		for (int i : paramArr) {
			System.out.print(i + " ");
		}
	}
	/**
	 * 希尔排序
	 * @Title: shellSort   
	 * @Description: 
	 * 
	 * 
	 * 
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
