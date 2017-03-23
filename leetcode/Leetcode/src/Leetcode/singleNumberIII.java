package Leetcode;

import java.util.*;

public class singleNumberIII {
	public static void main(String[] args) {
		int[] strs = { 1, 2, 1, 3, 2, 5 };
		singleNumber(strs);
	}

	public static int[] singleNumber(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], 1);
				set.add(nums[i]);
			} else {
				if (set.contains(nums[i]))
					set.remove(nums[i]);
			}
		}
		int[] arr = new int[2];
		int i = 0;
		for (int a : set) {
			arr[i] = a;
			i++;
		}
		return arr;
	}
}
