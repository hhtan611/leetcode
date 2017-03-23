package Leetcode;

import java.util.*;

/*
 Author:     King, wangjingui@outlook.com
 Date:       Dec 25, 2014
 Problem:    Binary Tree Preorder Traversal
 Difficulty: Easy
 Source:     http://oj.leetcode.com/problems/binary-tree-preorder-traversal/
 Notes:
 Given a binary tree, return the preorder traversal of its nodes' values.
 For example:
 Given binary tree {1,#,2,3},
 1
 \
 2
 /
 3
 return [1,2,3].
 Note: Recursive solution is trivial, could you do it iteratively?
 Solution: 1. Iterative way (stack).   Time: O(n), Space: O(n).
 2. Recursive solution.      Time: O(n), Space: O(n).
 3. Threaded tree (Morris).  Time: O(n), Space: O(1).
 */

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
public class BinaryTreePreorderTraversal {
	public static void main(String[] args) {
		// System.out.print(Math.abs(1-3));
		TreeNode root = new TreeNode(1);
		TreeNode sn = new TreeNode(2);
		sn.left = new TreeNode(3);
		root.left = sn;
		sn.right = new TreeNode(5);
		root.right = new TreeNode(0);

		BinaryTreePreorderTraversal b = new BinaryTreePreorderTraversal();
		System.out.print(b.preorderTraversal_1(root));
	}

	public List<Integer> preorderTraversal_1(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		res.add(root.val);
		List<Integer> left = preorderTraversal(root.left);
		List<Integer> right = preorderTraversal(root.right);
		res.addAll(left);
		res.addAll(right);
		return res;
	}

	public List<Integer> preorderTraversalRe_6(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		Deque<TreeNode> que = new ArrayDeque<TreeNode>();
		TreeNode cur = root;
		TreeNode pre = null;
		while (!que.isEmpty() || cur != null) {
			if (cur != null) {
				que.add(cur);
				cur = cur.right;
			} else {
				TreeNode peek = que.peek();
				res.add(peek.val);
				que.remove();
				pre = peek;
				if (peek.left != null && peek.left != pre) {
					que.push(peek.left);
				}
				if (peek.right != null && peek.right != pre) {
					que.push(peek.right);
				}
			}
		}
		return res;
	}

	public void preorderTraversalRe(TreeNode root, List<Integer> res) {
		if (root == null)
			return;
		res.add(root.val);
		preorderTraversalRe(root.left, res);
		preorderTraversalRe(root.right, res);
	}

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		preorderTraversalRe(root, res);
		return res;
	}

	public List<Integer> preorderTraversal_3(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		Stack<TreeNode> stk = new Stack<TreeNode>();
		stk.push(root);
		while (stk.isEmpty() == false) {
			TreeNode cur = stk.pop();
			res.add(cur.val);
			if (cur.right != null)
				stk.push(cur.right);
			if (cur.left != null)
				stk.push(cur.left);
		}
		return res;
	}

	public List<Integer> preorderTraversal_4(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		Stack<TreeNode> stk = new Stack<TreeNode>();
		TreeNode cur = root;
		while (stk.isEmpty() == false || cur != null) {
			if (cur != null) {
				stk.push(cur);
				res.add(cur.val);
				cur = cur.left;
			} else {
				cur = stk.pop();
				cur = cur.right;
			}
		}
		return res;
	}

}
