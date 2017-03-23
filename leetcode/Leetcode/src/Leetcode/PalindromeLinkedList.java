package Leetcode;

public class PalindromeLinkedList {
	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		one.next = two;
		/*ListNode three = new ListNode(3);
		two.next = three;
		ListNode four = new ListNode(2);
		three.next = four;
		ListNode five = new ListNode(1);
		four.next = five;*/
		// five.next = one;
		System.out.print(isPalindrome(one));
	}

	public static boolean isPalindrome(ListNode head) {
		/*
		 * ListNode dummy = new ListNode(-1); dummy.next=head;
		 */
		ListNode fast = head, slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		if (fast != null) { // odd nodes: let right half smaller
			slow = slow.next;
		}
		slow = reverse(slow);
		fast = head;

		while (slow != null) {
			if (fast.val != slow.val) {
				return false;
			}
			fast = fast.next;
			slow = slow.next;
		}
		return true;
	}

	public static ListNode reverse(ListNode head) {
		ListNode newhead = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = newhead;
			newhead = head;
			head = next;
		}
		return newhead;
	}
}
