package Leetcode;

/*
 Author:     King, wangjingui@outlook.com
 Date:       Dec 12, 2014
 Problem:    Remove Duplicates from Sorted List II
 Difficulty: Medium
 Source:     https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 Notes:
 Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 For example,
 Given 1->2->3->3->4->4->5, return 1->2->5.
 Given 1->1->1->2->3, return 2->3.
 Solution: 1. iterative 2. recursive
 */

public class RemoveDuplicatesfromSortedListII {
	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		one.next = two;
		ListNode three = new ListNode(2);
		two.next = three;
		ListNode four = new ListNode(4);
		three.next = four;
		ListNode five = new ListNode(4);
		four.next = five;
		ListNode six = new ListNode(5);
		five.next = six;
		//five.next = one;
		System.out.print(deleteDuplicates(one));
	}

	public static ListNode deleteDuplicates_1(ListNode head) {
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		while (head != null) {
			if (head.next != null && head.val == head.next.val) {
				while (head.next != null && head.val == head.next.val)
					head = head.next;
			} else {
				cur.next = head;
				cur = cur.next;
			}
			head = head.next;
		}
		cur.next = null;
		return dummy.next;
	}

	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null) return null;
        if (head.next == null || head.val != head.next.val){
            head.next = deleteDuplicates(head.next);
            return head;
        }
        while (head.next != null && head.val == head.next.val)
            head = head.next;
        return deleteDuplicates(head.next);
	}
}
