package com.zjl.leecode.test;

import com.zjl.leecode.common.entity.ListNode;
import com.zjl.leecode.common.util.LinkedListUtils;
import com.zjl.leecode.solutions.Solution2;
public class Test2 {
	public static void main(String[] args) {
		ListNode l1 = LinkedListUtils.contructLinkedList(new int[]{2, 4, 3});
		ListNode l2 = LinkedListUtils.contructLinkedList(new int[]{5, 6, 4});
		ListNode sum = Solution2.addTwoNumbers(l1, l2);
		ListNode expected = LinkedListUtils.contructLinkedList(new int[]{7, 0, 8});
		sum = Solution2.addTwoNumbers2(l1, l2);
		
		l1 = LinkedListUtils.contructLinkedList(new int[]{1, 8});
		l2 = LinkedListUtils.contructLinkedList(new int[]{0});
		sum = Solution2.addTwoNumbers(l1, l2);
		expected = LinkedListUtils.contructLinkedList(new int[]{1, 8});
		sum = Solution2.addTwoNumbers2(l1, l2);
		
		l1 = LinkedListUtils.contructLinkedList(new int[]{5});
        l2 = LinkedListUtils.contructLinkedList(new int[]{5});
        sum = Solution2.addTwoNumbers(l1, l2);
        expected = LinkedListUtils.contructLinkedList(new int[]{0, 1});
        sum = Solution2.addTwoNumbers2(l1, l2);
		if(sum.equals(expected)) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}
		
	}
}
