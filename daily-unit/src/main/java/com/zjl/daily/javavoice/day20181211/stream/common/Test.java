package com.zjl.daily.javavoice.day20181211.stream.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.el.parser.AstListData;

public class Test {
	public static void main(String[] args) {

		/**
		 * collect(toList())   及早求值 
		 * collect(toList())方法由Stream里的值生成一个列表，是一个及早求值操作。
		 */
		List<String> list = Stream.of("a","b","c").collect(Collectors.toList());
		/**
		 * map
		 * map可以将一种类型的值转换成另一种类型。
		 */
		List<String> listMap = Stream.of("a","b","c").map(String -> String.toUpperCase()).collect(Collectors.toList());
		/**
		 * filter过滤器
		 * 遍历并检查其中的元素时，可用filter
		 */
		List<String> listFileter = Stream.of("a","ab","abc").filter(value -> value.contains("b")).collect(Collectors.toList());
		/**
		 * flatMap
		 * 如果有一个包含了多个集合的对象希望得到所有数字的集合，我们可以用flatMap
		 */
		//List<Integer> listFlatMap = Stream.of(asList(1,2),asList(3,4)).flatMap(Collection::stream).collect(Collectors.toList());
		/**
		 * max和min
		 * 
		 */
		List<Integer> listcomp = new ArrayList<Integer>();
		listcomp.add(1);
		listcomp.add(2);
		listcomp.add(3);
		listcomp.add(4);
		listcomp.add(5);
		listcomp.add(6);
		
		Integer min = listcomp.stream().min(Comparator.comparing(integer -> integer)).get();
		Integer max = listcomp.stream().max(Comparator.comparing(integer -> integer)).get();
		/**
		 * reduce
		 * reduce操作可以实现从一组值中生成一个值，在上述例子中用到的count、min、max方法事实上都是reduce操作。
		 */
		Integer reduce = Stream.of(1, 2, 3).reduce(0, (acc,element) -> acc + element);
		System.out.println(reduce);
	}
}
