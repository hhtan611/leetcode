package Leetcode;

/*
 * wrong solution
 Author:     King, wangjingui@outlook.com
 Date:       Jan 02, 2015
 Problem:    Linked List Cycle II
 Difficulty: Easy
 Source:     http://oj.leetcode.com/problems/linked-list-cycle-ii/
 Notes:
 Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 Follow up:
 Can you solve it without using extra space?
 Solution: ...
 */

/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */
public class LinkedListCycleII {
	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		one.next = two;
		ListNode three = new ListNode(3);
		two.next = three;
		ListNode four = new ListNode(4);
		three.next = four;
		ListNode five = new ListNode(5);
		four.next = five;
		five.next = one;
		System.out.print(detectCycle(four).val);
	}

	public static ListNode detectCycle2(ListNode head) {
		int flag = -1;
		if (head == null && head.next == null)
			return null;
		ListNode fast = head, slow = head;
		while (fast != null && fast.next != null) {
			fast = head.next.next;
			slow = head.next;
			if (fast == slow)
				flag = 0;
			break;
		}
		if (flag == 0) {

		}
		return null;

	}

	public static ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null)
			return null;
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				break;
		}
		if (fast == null || fast.next == null)
			return null;
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
}
