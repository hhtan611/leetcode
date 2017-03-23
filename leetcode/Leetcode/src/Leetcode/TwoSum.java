package Leetcode;

import java.util.HashMap;

/*
 Author:     Andy, nkuwjg@gmail.com
 Date:       Dec 13, 2014
 Problem:    Two Sum
 Difficulty: Medium
 Source:     https://oj.leetcode.com/problems/two-sum/
 Notes:
 Given an array of integers, find two numbers such that they add up to a specific target number.
 The function twoSum should return indices of the two numbers such that they add up to the target, 
 where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 You may assume that each input would have exactly one solution.
 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2
 Solution: 1. Hash table. O(n)

 Note:  Hash Table solution has been updated.  In case that the two elements are the same, 
 all the indices should be stored in the map.
 */

public class TwoSum {
	public static void main(String[] args) {
		int[] numbers = { 11, 15, 2, 7 };
		int[] res = twoSum(numbers, 1);
		if (res != null)
			for (int n : res)
				System.out.println(n);
	}

	public static int[] twoSum(int[] numbers, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; ++i) {
			int b = target - numbers[i];
			if (map.get(b) != null) {
				return new int[] { map.get(b), i };
			} else
				map.put(numbers[i], i);
		}
		return null;
	}

	public int[] twoSum1(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] rlt = new int[3];
		for (int i = 0; i < nums.length; i++) {
			int aa = target - nums[i];
			if (map.containsKey(aa)) {
				rlt[0] = map.get(aa);
				rlt[1] = i;
			} else {
				map.put(nums[i], i);
			}
		}
		return rlt;
	}

}
