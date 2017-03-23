package Leetcode;

/*  Donn't understand
 Author:     King, wangjingui@outlook.com
 Date:       Jan 2, 2015
 Problem:    Reverse Linked List II
 Difficulty: Easy
 Source:     https://oj.leetcode.com/problems/reverse-linked-list-ii/
 Notes:
 Reverse a linked list from position m to n. Do it in-place and in one-pass.
 For example:
 Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 return 1->4->3->2->5->NULL.
 Note:
 Given m, n satisfy the following condition:
 1 <= m <= n <= length of list.
 Solution: in-place & one-pass.
 */
public class ReverseLinkedListII {
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
		reverseBetween(one, 1, 3);
	}

	public static ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		ListNode first = dummy;
		for (int i = 0; i < m - 1; i++)
			first = first.next;
		ListNode hd = first.next;
        for (int i = 0; i < n - m; ++i) {
            ListNode move = hd.next;
            hd.next = move.next;
            move.next = first.next;
            first.next = move;
        }
        return dummy.next;
	}
}
