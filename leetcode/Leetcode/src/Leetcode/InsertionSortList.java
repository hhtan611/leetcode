package Leetcode;

/*
Author:     King, wangjingui@outlook.com
Date:       Jan 02, 2015
Problem:    Insertion Sort List
Difficulty: Easy
Source:     http://oj.leetcode.com/problems/insertion-sort-list/
Notes:
Sort a linked list using insertion sort.
Solution: ...
*/
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class InsertionSortList {
	public static void main(String[] args) {
		ListNode one = new ListNode(5);
		ListNode two = new ListNode(2);
		one.next = two;
		ListNode three = new ListNode(3);
		two.next = three;
		ListNode four = new ListNode(4);
		three.next = four;
		ListNode five = new ListNode(1);
		four.next = five;
		// five.next = one;
		System.out.print(insertionSortList(one));
	}

	public static ListNode insertionSortList(ListNode head) {
		if (head == null)
			return head;
		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		dummy.next = head;
		ListNode cur = head.next;
		head.next = null;
		while (cur != null) {
			ListNode tmp = dummy;
			while (tmp.next != null && tmp.next.val <= cur.val)
				tmp = tmp.next;
			ListNode next = cur.next;
			cur.next = tmp.next;
			tmp.next = cur;
			cur = next;
		}
		return dummy.next;
	}
	
	public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
		dummy.next = head;
		ListNode cur=head.next;
		head.next=null;
		while(cur!=null){
		    ListNode tmp = dummy;
		    ListNode next=cur.next;
		    cur.next=head;
		    tmp.next=cur;
		    cur=next;
		}
		return dummy.next;
    }

}
