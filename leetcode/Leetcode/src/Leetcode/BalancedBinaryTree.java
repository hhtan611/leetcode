package Leetcode;

/*
 Author:     King, higuige@gmail.com
 Date:       Oct 07, 2014
 Problem:    Balanced Binary Tree
 Difficulty: Easy
 Source:     https://oj.leetcode.com/problems/balanced-binary-tree/
 Notes:
 Given a binary tree, determine if it is height-balanced.
 For this problem, a height-balanced binary tree is defined as a binary tree in which 
 the depth of the two subtrees of every node never differ by more than 1.
 Solution: DFS.
 */
/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
public class BalancedBinaryTree {
	public static void main(String[] args) {
		//System.out.print(Math.abs(1-3));
		TreeNode root = new TreeNode(3);
		TreeNode sn = new TreeNode(1);
		sn.left = new TreeNode(2);
		root.left = sn;
		sn.right = new TreeNode(5);

		BalancedBinaryTree b = new BalancedBinaryTree();
		System.out.print(b.isBalanced(root));
	}

	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		return isBalancedRe(root) > -1;
	}

	public int isBalancedRe(TreeNode root) {
		if (root == null)
			return 0;

		int left = isBalancedRe(root.left);
		int right = isBalancedRe(root.right);
		
		if (left == -1 || right == -1)
			return -1;
		if (Math.abs(right - left) > 1)
			return -1;
		return Math.max(left, right) + 1;
	}
}


