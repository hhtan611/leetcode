package Leetcode;

import java.util.*;

/*
 Author:     King, wangjingui@outlook.com
 Date:       Dec 20, 2014
 Problem:    3Sum Closest
 Difficulty: Medium
 Source:     https://oj.leetcode.com/problems/3sum-closest/
 Notes:
 Given an array S of n integers, find three integers in S such that the sum is closest to 
 a given number, target. Return the sum of the three integers. 
 You may assume that each input would have exactly one solution.
 For example, given array S = {-1 2 1 -4}, and target = 1.
 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 Solution: Similar to 3Sum, taking O(n^2) time complexity.
 */

public class s3SumClosest {
	public static void main(String[] args) {
		int[] numbers = { -1, 0, 1, 2, -1, -4 };
		/*
		 * for (List<Integer> nr : threeSum2(numbers)) for (int n : nr) {
		 * System.out.print(n + " "); }
		 */
		System.out.println();
	}

	public int threeSumClosest(int[] num, int target) {
		int N = num.length;
		if (N < 3)
			return 0;
		int res = num[0] + num[1] + num[2];
		Arrays.sort(num);
		for (int i = 0; i < N - 2; i++) {
			int l = i + 1, r = N - 1;
			while (r > l) {
				int threesum = num[i] + num[l] + num[r];
				if (target == threesum)
					return target;
				else if (target > threesum)
					l++;
				else 
					r--;
				if (Math.abs(threesum-target)<Math.abs(res-target))
					res = threesum;
			}
		}

		return res;
	}
}
