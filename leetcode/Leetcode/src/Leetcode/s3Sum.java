package Leetcode;

import java.util.*;

/*
 Author:     King, wangjingui@outlook.com
 Date:       Dec 20, 2014
 Problem:    3Sum
 Difficulty: Medium
 Source:     https://oj.leetcode.com/problems/3sum/
 Notes:
 Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 Find all unique triplets in the array which gives the sum of zero.
 Note:
 Elements in a triplet (a,b,c) must be in non-descending order. (ie, a <= b <= c)
 The solution set must not contain duplicate triplets.
 For example, given array S = {-1 0 1 2 -1 -4},
 A solution set is:
 (-1, 0, 1)
 (-1, -1, 2)
 Solution: Simplify '3sum' to '2sum' O(n^2). http://en.wikipedia.org/wiki/3SUM
 */
public class s3Sum {
	public static void main(String[] args) {
		int[] numbers = { -1, 0, 1, 2, -1, -4 };
		for (List<Integer> nr : threeSum(numbers))
			for (int n : nr) {
				System.out.print(n + " ");
			}
		System.out.println();
	}

	public static List<List<Integer>> threeSum(int[] num) {
	    Arrays.sort(num);
	    List<List<Integer>> res = new LinkedList<>(); 
	    for (int i = 0; i < num.length-2; i++) {
	        if (i == 0 || (i > 0 && num[i] != num[i-1])) {
	            int lo = i+1, hi = num.length-1, sum = 0 - num[i];
	            while (lo < hi) {
	                if (num[lo] + num[hi] == sum) {
	                    res.add(Arrays.asList(num[i], num[lo], num[hi]));
	                    while (lo < hi && num[lo] == num[lo+1]) lo++;
	                    while (lo < hi && num[hi] == num[hi-1]) hi--;
	                    lo++; hi--;
	                } else if (num[lo] + num[hi] < sum) lo++;
	                else hi--;
	           }
	        }
	    }
	    return res;
	}

	public static List<List<Integer>> threeSum2(int[] num) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(num);
		int N = num.length;
		for (int i = 0; i < N - 2 && num[i] <= 0; ++i) {
			int twosum = 0 - num[i];
			int l = i + 1, r = N - 1;
			while (l < r) {
				int sum = num[l] + num[r];
				if (sum < twosum)
					++l;
				else if (sum > twosum)
					--r;
				else {
					ArrayList<Integer> tmp = new ArrayList<Integer>();
					tmp.add(num[i]);
					tmp.add(num[l]);
					tmp.add(num[r]);
					res.add(tmp);
					++l;
					--r;
					while (l < r && num[l] == num[l - 1])
						++l; // avoid duplicates
					while (l < r && num[r] == num[r + 1])
						--r; // avoid duplicates
				}
			}
		}
		return res;
	}
}
