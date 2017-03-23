package Leetcode;

/*
 Author:     Annie Kim, anniekim.pku@gmail.com
 Date:       Dec 12, 2014 [Two pointers ('last' and 'lastlast').]
 Problem:    Remove Duplicates from Sorted Array II
 Difficulty: Medium
 Source:     https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 Notes:
 Follow up for "Remove Duplicates":
 What if duplicates are allowed at most twice?
 For example,
 Given sorted array A = [1,1,1,2,2,3],
 Your function should return length = 5, and A is now [1,1,2,2,3].
 Solution: ...
 */
public class RemoveDuplicatesfromSortedArrayII {
	public static void main(String[] args) {
		int[] b = { 1, 1, 1,2,2,3 };
		removeDuplicates2(b);
	}
	public static int removeDuplicates3(int[] nums) {
	    int i = 0;
	    for (int n : nums)
	        if (i < 2 || n > nums[i-2])
	            nums[i++] = n;
	    return i;
	}

	public static int removeDuplicates(int[] nums) {
		int n = nums.length;
		int[] a = new int[n];
		int idx = 0;
		for (int i = 0; i < n; i++) {
			if (i < 2) {
				a[idx++] = nums[i];
			} else if (nums[i] == nums[i - 2]) {
				continue;
			} else {
				a[idx++] = nums[i];
			}
		}
		return idx;
	}
	public static int removeDuplicates2(int[] nums) {
		int n = nums.length;
		if (n <= 2) return n;
		int idx = 2;
		for (int i = 2; i < n; i++) {
			if (nums[i] != nums[idx - 2]) {
				nums[idx++] = nums[i];
			}
		}
		return idx;
	}
}
