package com.zjl.leecode.day20181228;



public class Solution2 {
	public static void main(String[] args) {
		
		
	}
	
	
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) { 

	        //==========预处理,保证计算不出nullpointer错
	        if(l1 == null){
	            l1 = new ListNode(0);
	        }
	        if(l2 == null){
	            l2 = new ListNode(0);
	        }
	        //========================================


	         if(l1.next==null && l2.next==null){//最小情况
	             int val = l1.val+l2.val;
	             if(val>9){
	                 ListNode node = new ListNode(val%10);//设置第二位
	                 node.next = new ListNode(val/10);//设置第一位
	                 return node;
	             }else
	             return new ListNode(val);
	         }else {//可继续迭代的情况
	             int val = l1.val+l2.val;
	             if(val>9){
	                 val = val-10;
	                 if(l1.next!=null)  l1.next.val++;
	                 else if(l2.next!=null)  l2.next.val++;
	                 //else //不存在的，必为上述两种情况之一。
	             }

	             ListNode node = new ListNode(val);
	             //开始迭代
	             node.next = addTwoNumbers(l1.next,l2.next);
	             return node;
	         }
	    }  
	
    
}


class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x; 
	}
 }