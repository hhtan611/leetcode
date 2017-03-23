package interview;
public class FindNthLinkedList {
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
		// five.next = one;
		System.out.print(FindNthListRe(one, 2, 0).val);
	}

	public static ListNode FindNthList(ListNode head, int k) {
		if (head == null || k < 1)
			return null;
		ListNode cur = head;
		ListNode rcur = head;
		for (int i = 1; i < k; i++) {
			cur = cur.next;
			if (cur == null)
				return null;
		}
		while (cur.next != null) {
			cur = cur.next;
			rcur = rcur.next;
		}
		return rcur;
	}

	
	public static ListNode FindNthListRe(ListNode head, int k, int i) {
		if (head == null)
			return null;
		ListNode node =FindNthListRe(head.next, k, i);
		i++;//wrong
		if(i==k)
		return head;
		return node;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}