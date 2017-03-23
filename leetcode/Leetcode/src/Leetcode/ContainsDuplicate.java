package Leetcode;

import java.util.*;

public class ContainsDuplicate {
	public boolean containsDuplicate(int[] nums) {
		int n = nums.length;
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			if (!set.contains(nums[i])) {
				set.add(nums[i]);
			} else {
				return true;
			}
		}
		return false;
	}

	public boolean containsDuplicate2(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i : nums)
			if (!set.add(i))// if there is same
				return true;
		return false;
	}

	public boolean containsDuplicateLS(ListNode nums) {
		ListNode head = nums;
		HashSet<Integer> set = new HashSet<>();
		while (head != null) {
			if (!set.add(head.val))
				return true;
			head = head.next;
		}
		return false;
	}
}
