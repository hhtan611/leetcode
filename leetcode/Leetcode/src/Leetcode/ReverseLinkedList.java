package Leetcode;

public class ReverseLinkedList {
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
		reverseList2(one);
	}

	public static ListNode reverseList(ListNode head) {
		return reverseListInt(head, null);
	}

	private static ListNode reverseListInt(ListNode head, ListNode newHead) {
		if (head == null)
			return newHead;
		ListNode next = head.next;
		head.next = newHead;
		return reverseListInt(next, head);
	}

	public static ListNode reverseList2(ListNode head) {
		if (head == null)
			return head;
		ListNode cur = head.next;
		head.next = null;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = head;
			head = cur;
			cur = next;
		}
		return head;
	}
}
