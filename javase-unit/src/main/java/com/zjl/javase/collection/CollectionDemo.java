package com.zjl.javase.collection;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("张三");
		c.add("李四");
		c.add("王五");
		c.add("赵六");
		System.out.println(c); // [张三, 李四, 王五, 赵六]
		
		// boolean addAll(Collection c)
		Collection c2 = new ArrayList(); 
		c2.add("曹操");
		c2.add("萨达姆");
		c2.add("本拉登");
		c.addAll(c2);
		
		System.out.println(c);
		
		// boolean remove(Object o) 
		System.out.println("remove: " + c.remove("张三"));
		System.out.println(c);
		// boolean removeAll(Collection<?> c) 
//		System.out.println("removeAll: " + c.removeAll(c2));
//		System.out.println(c);
		
		// void clear() 
//		c.clear();
//		System.out.println(c);
		
		System.out.println(c.size());
		
		System.out.println("contains: " + c.contains("李四"));
		System.out.println("contains: " + c.contains("曹操"));
		System.out.println("contains: " + c.contains(""));
		System.out.println("containsAll: " + c.containsAll(c2));
		System.out.println("isEmpty: " + c.isEmpty());
		
		Collection c3 = new ArrayList();
//		c3.add("张三");
//		c3.add("李四");
//		c3.add("王五");
//		c3.add("赵六");
//		c3.add("曹操");
//		c3.add("萨达姆");
//		c3.add("本拉登");
//		c3.add("秦始皇");
		System.out.println(c);
		System.out.println(c3);
		System.out.println("retainAll:" + c.retainAll(c3));
		System.out.println("c:" + c);
		
	}

}
