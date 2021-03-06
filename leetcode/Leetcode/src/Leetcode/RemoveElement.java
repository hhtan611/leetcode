package Leetcode;


/*
Author:     King, wangjingui@outlook.com
Date:       Dec 12, 2014
Problem:    Remove Element
Difficulty: Easy
Source:     https://oj.leetcode.com/problems/remove-element/
Notes:
Given an array and a value, remove all instances of that value in place and return the new length.
The order of elements can be changed. It doesn't matter what you leave beyond the new length.
Solution: Refactor: Update solution. Use two pointers.
*/
public class RemoveElement {
	public int removeElement(int[] nums, int val) {
        int idx = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=val) 
                nums[idx++] = nums[i];
        }
        return idx;
    }
}