package Leetcode;

import java.util.*;

public class ContainsDuplicateK {
	public static void main(String[] args) {
		int[] nums = { 99, 99 };
		int k = 2;
		containsNearbyDuplicate2(nums, k);
	}

	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		int n = nums.length;
		if (n < k + 1 || k == 0)
			return false;
		int i = 0;
		while (i + k < n) {
			int j = i + k;
			if (nums[i] == nums[j])
				return true;
			i++;
		}
		while (i - k >= 0) {
			int j = i - k;
			if (nums[i] == nums[j])
				return true;
			i--;
		}
		return false;
	}

	public static boolean containsNearbyDuplicate2(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				if (i - map.get(nums[i]) <= k)
					return true;
			}
			map.put(nums[i], i);
		}
		return false;
	}
}
