package com.zjl.interview.year2019.designmodel.javase.Collections.method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @Description: copy(List m,List n)方法的使用(含义：将集合n中的元素全部复制到m中,并且覆盖相应索引的元素)
 * @author: zhangjiale
 * @date:   2019年6月3日 上午10:48:01   
 *     
 * @Copyright: 2019
 */
public class Test5 {
	public static void main(String[] args) {
		List list = Arrays.asList("1,2,3,4,5".split(","));
		List list2 = Arrays.asList("7,8".split(","));
		System.out.println(list);
		System.out.println(list2);
		Collections.copy(list, list2);
		System.out.println(list);
		System.out.println(list2);
	
	}
}
