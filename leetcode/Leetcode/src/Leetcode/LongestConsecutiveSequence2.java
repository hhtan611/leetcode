package Leetcode;

import java.util.*;

public class LongestConsecutiveSequence2 {
	/*
	 * Author: Andy, nkuwjg@gmail.com Date: Jun 18, 2014 Problem: Longest
	 * Consecutive Sequence Difficulty: Hard Source:
	 * https://oj.leetcode.com/problems/longest-consecutive-sequence/ Notes:
	 * Given an unsorted array of integers, find the length of the longest
	 * consecutive elements sequence. For example, Given [100, 4, 200, 1, 3, 2],
	 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its
	 * length: 4. Your algorithm should run in O(n) complexity. Solution 1:
	 * Update solution.
	 */

	public static void main(String[] args) {
		int[] aa = { 100, 4, 200, 1, 3, 2 ,5,6};
		System.out.print(longestConsecutive3(aa));
	}

	public int longestConsecutive(int[] num) {
		int size = num.length;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int res = 0;
		for (int i = 0; i < size; ++i) {
			if (map.containsKey(num[i]) == true)
				continue;
			int val = num[i];
			if (map.containsKey(val - 1) == true
					&& map.containsKey(val + 1) == true) {
				map.put(val, map.get(val - 1) + map.get(val + 1) + 1);
				map.put(val - map.get(val - 1), map.get(val));
				map.put(val + map.get(val + 1), map.get(val));
			} else if (map.containsKey(val - 1) == true) {
				map.put(val, map.get(val - 1) + 1);
				map.put(val - map.get(val - 1), map.get(val));
			} else if (map.containsKey(val + 1) == true) {
				map.put(val, map.get(val + 1) + 1);
				map.put(val + map.get(val + 1), map.get(val));
			} else {
				map.put(val, 1);
			}
			res = Math.max(res, map.get(val));
		}
		return res;
	}

	public static int longestConsecutiveMySolution(int[] num) {
		int n = num.length;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();

		for (int i = 0; i < n; i++) {
			map.put(num[i], i);
			if (map.containsKey(num[i] - 1)) {
				map2.put(num[i] - 1, map.get(num[i] - 1));
				map2.put(num[i], i);

			} else if (map.containsKey(num[i] + 1)) {
				map2.put(num[i] + 1, map.get(num[i] + 1));
				map2.put(num[i], i);
			}
		}
		return map2.size();
	}
	
	public static int longestConsecutive3(int[] num) {
		// if array is empty, return 0
		if (num.length == 0) {
			return 0;
		}
	 
		Set<Integer> set = new HashSet<Integer>();
		int max = 1;
	 
		for (int e : num)
			set.add(e);
	 
		for (int e : num) {
			int left = e - 1;
			int right = e + 1;
			int count = 1;
	 
			while (set.contains(left)) {
				count++;
				set.remove(left);
				left--;
			}
	 
			while (set.contains(right)) {
				count++;
				set.remove(right);
				right++;
			}
	 
			max = Math.max(count, max);
		}
	 
		return max;
	}

}
