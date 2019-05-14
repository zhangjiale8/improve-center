package com.zjl.daily.nowcoder.textbook.crazyjava.process;
/**
 * 
 * @Description:9*9乘法   
 * @author: zhangjiale
 * @date:   2019年5月13日 上午11:48:31   
 *     
 * @Copyright: 2019
 */
public class Multiplication99 {
	public static void main(String[] args) {
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j <= i; j++) {
				if(j != i) {
					System.out.print(j+" * "+i+" = "+i*j +" ");
				}else {
					System.out.println(j+" * "+i+" = "+i*j);
				}
				
			}
		}
	}
}
