package com.zjl.leecode.common.util;

import com.zjl.leecode.common.entity.ListNode;
/**
 * 
 * @Description:链表工具类   
 * @author: zhangjiale
 * @date:   2019年1月2日 上午9:32:11   
 *     
 * @Copyright: 2019
 */
public class LinkedListUtils {
	/**
	 * 
	 * @Title: contructLinkedList   
	 * @Description: 创建链表   
	 * @param: @param nums
	 * @param: @return      
	 * @return: ListNode      
	 * @throws
	 */
	public static ListNode contructLinkedList(int[] nums) {
		if (nums == null || nums.length == 0) {
            return null;
        }
        ListNode pre = new ListNode(-1);
        ListNode head = new ListNode(nums[0]);
        pre.setNext(head);
      
        for (int i = 1; i < nums.length; i++) {
            head.setNext(new ListNode(nums[i]));
            head = head.getNext();
        }
        return pre.getNext();
	}

}
