package com.zjl.leecode.common.entity;

import java.util.List;

/**
 * 
 * @Description:
 * 
 *   链表
 * @author: zhangjiale
 * @date:   2019年1月2日 上午9:18:03   
 *     
 * @Copyright: 2019
 */
public class ListNode {
	private int val;
	private ListNode next;
	public int getVal() {
		return val;
	}
	
	public void setNext(ListNode next) {
		this.next = next;
	}

	public ListNode getNext() {
		return next;
	}

	public ListNode(int val) {
		super();
		this.val = val;
	}
	
	public ListNode() {
		super();
	}
	
	public ListNode(int val, ListNode next) {
		super();
		this.val = val;
		this.next = next;
	}

	public static ListNode createSinglyLinkedList() {
        ListNode head = new ListNode(1);

        ListNode node1 = new ListNode(2);
        head.next = node1;

        ListNode node2 = new ListNode(3);
        node1.next = node2;

        ListNode node3 = new ListNode(4);
        node2.next = node3;

        ListNode node4 = new ListNode(5);
        node3.next = node4;

        ListNode node5 = new ListNode(6);
        node4.next = node5;

        ListNode node6 = new ListNode(7);
        node5.next = node6;

        ListNode node7 = new ListNode(8);
        node6.next = node7;

        ListNode node8 = new ListNode(9);
        node7.next = node8;

        ListNode node9 = new ListNode(10);
        node8.next = node9;
        return head;
    }
	
	public static ListNode createSinglyLinkedList(List<Integer> listValues) {
        if (listValues == null || listValues.size() == 0) {
            throw new IllegalArgumentException(
                    "Please pass in a valid listValues to create a singly linked list.");
        }
        ListNode head = new ListNode(listValues.get(0));
        ListNode tmp = head;
        for (int i = 1; i < listValues.size(); i++) {
            ListNode next = new ListNode(listValues.get(i));
            tmp.next = next;
            tmp = tmp.next;
        }
        printList(head);
        return head;
    }
	
	public static void printList(ListNode head) {
        ListNode temp = head;
        System.out.println();
        while (temp != null) {
            System.out.print(temp.getVal() + "\t");
            temp = temp.next;
        }
    }
	
}
