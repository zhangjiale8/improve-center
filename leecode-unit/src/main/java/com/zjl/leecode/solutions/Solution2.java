package com.zjl.leecode.solutions;

import com.zjl.leecode.common.entity.ListNode;

/**
 * 
 * @Description:TODO 2.两数相加 
 * 					   给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序
 *                   的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 
 *                   如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 
 *                   您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 *                   示例：
 * 
 *                   输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 
 *                   输出：7 -> 0 -> 8 
 *                   原因：342 + 465 = 807
 * @author: zhangjiale
 * @date: 2019年1月2日 上午9:09:02
 * 
 * @Copyright: 2019
 */
public class Solution2 {

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
        ListNode tmp = result;
        int sum = 0;
        while (l1 != null || l2 != null) {
            sum /= 10;
            if (l1 != null) {
                sum += l1.getVal();
                l1 = l1.getNext();
            }
            if (l2 != null) {
                sum += l2.getVal();
                l2 = l2.getNext();
            }
            tmp.setNext(new ListNode(sum % 10));
            tmp = tmp.getNext();
        }
        if (sum / 10 == 1) {
            tmp.setNext(new ListNode(1));
        }
		return result.getVal() == 0 ? result.getNext() : result;
	}

	public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		ListNode pre = new ListNode(-1);
        ListNode head = new ListNode(0);
        pre.setNext(head);
        int carry = 0;
        while (l1 != null || l2 != null) {
            int val = carry;
            if (l1 != null) {
                val += l1.getVal();
                l1 = l1.getNext();
            }
            if (l2 != null) {
                val += l2.getVal();
                l2 = l2.getNext();
            }
            if (val >= 10) {
                val %= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            head.setNext(new ListNode(val));
            head = head.getNext();
        }
        if (carry != 0) {
            head.setNext(new ListNode(carry));
        }
        return pre.getNext().getNext();
	}

}
