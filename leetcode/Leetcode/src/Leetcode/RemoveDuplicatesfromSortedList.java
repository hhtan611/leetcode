package Leetcode;

/*
 Author:     King, wangjingui@outlook.com
 Date:       Dec 12, 2014
 Problem:    Remove Duplicates from Sorted List
 Difficulty: Easy
 Source:     https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list/

 Notes:
 Given a sorted linked list, delete all duplicates such that each element appear only once.
 For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3.
 Solution: 1. Delete duplicates directly.
 2. Copy value first (like Remove Duplicates from Array) and then delete the remaining elements.
 */

public class RemoveDuplicatesfromSortedList {
	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(1);
		one.next = two;
		ListNode three = new ListNode(3);
		two.next = three;
		/*ListNode four = new ListNode(4);
		three.next = four;
		ListNode five = new ListNode(5);
		four.next = five;*/
		// five.next = one;
		System.out.print(deleteDuplicates(one));
	}

	public static ListNode deleteDuplicates_1(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode pre = head, cur = head.next;
		while (cur != null) {
			if (pre.val == cur.val) {
				pre.next = cur.next;
			}else{
				pre=pre.next;
			}
			cur=cur.next;
		}
		return head;
	}

	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode pre = head, cur = head.next;
		while (cur != null) {
			if (pre.val != cur.val) {
				pre.next.val = cur.val;
				pre = pre.next;
			}
			cur = cur.next;
		}
		pre.next = null;
		return head;
	}
}