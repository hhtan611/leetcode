package Leetcode;

/*
 Author:     Andy, nkuwjg@gmail.com
 Date:       Jan 29, 2015
 Problem:    Convert Sorted Array to Binary Search Tree
 Difficulty: Medium
 Source:     https://oj.leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 Notes:
 Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 Solution: Recursion. 1. preorder
 2. inorder
 */

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
public class ConvertSortedArraytoBinarySearchTree {
	public static void main(String[] args){
		int[] num = {-1,0,1,2};
		sortedArrayToBST_1(num);
	}
	
	public static TreeNode sortedArrayToBST_1(int[] num) {
		return sortedArrayToBSTRe(num, 0, num.length - 1);
	}

	public static TreeNode sortedArrayToBSTRe(int[] num, int left, int right) {
		if (left > right)
			return null;
		if (left == right)
			return new TreeNode(num[left]);
		int len = (right+left)>>1;
		TreeNode root = new TreeNode(num[left]);
		root.left = sortedArrayToBSTRe(num, left+1, left+len);
		root.right= sortedArrayToBSTRe(num, left+1+len, right);
		/*if (left > right)
			return null;
		if (left == right)
			return new TreeNode(num[left]);
		int len = (right+left)>>1;
		TreeNode root = new TreeNode(num[len]);
		root.left = sortedArrayToBSTRe(num, left, len-1);
		root.right= sortedArrayToBSTRe(num, 1+len, right);*/
        return root;
	}

	public TreeNode sortedArrayToBST(int[] num) {
		
		int[] curidx = new int[1];
		curidx[0] = 0;
		return sortedArrayToBSTRe1(num, num.length, curidx);
	}

	public TreeNode sortedArrayToBSTRe1(int[] num, int len, int[] curidx) {
		if (len == 0)
			return null;
		if (len == 1)
			return new TreeNode(num[curidx[0]++]);
		int mid = len / 2;
		TreeNode left = sortedArrayToBSTRe1(num, mid, curidx);
		TreeNode node = new TreeNode(num[curidx[0]++]);
		node.left = left;
		node.right = sortedArrayToBSTRe1(num, len - 1 - mid, curidx);
		return node;
	}
}