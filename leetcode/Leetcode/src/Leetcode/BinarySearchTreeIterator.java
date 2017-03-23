package Leetcode;

import java.util.Stack;

/*
 Author:     king, wangjingui@outlook.com
 Date:       Dec 31, 2014
 Problem:    Binary Search Tree Iterator 
 Difficulty: Easy
 Source:     https://oj.leetcode.com/problems/binary-search-tree-iterator/
 Notes:
 Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 Calling next() will return the next smallest number in the BST.
 Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 Solution: Inorder traversal.t
 */

public class BinarySearchTreeIterator {
	public static void main(String[] args) {
		// System.out.print(Math.abs(1-3));
		TreeNode root = new TreeNode(8);
		TreeNode sn = new TreeNode(3);
		sn.right = new TreeNode(6);
		root.left = sn;
		sn.left = new TreeNode(1);
		root.right = new TreeNode(10);

		int res = -1;
		BinarySearchTreeIterator b = new BinarySearchTreeIterator(root);
		while (b.hasNext()) {
			res = b.next();
			System.out.println(res);
		}
	}

	private TreeNode node;
	private Stack<TreeNode> stk;

	public BinarySearchTreeIterator(TreeNode root) {
		node = root;
		stk = new Stack<TreeNode>();
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		if (stk.isEmpty() == true && node == null)
			return false;
		return true;
	}

	/** @return the next smallest number */
	public int next() {
		if (stk.isEmpty() && node == null)
			return 0;
		while (node != null) {
			stk.push(node);
			node = node.left;
		}
		int res = 0;

		node = stk.pop();
		res = node.val;
		node = node.right;
		return res;
	}

}

class BSTIterator {

	public BSTIterator(TreeNode root) {
		node = root;
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return node != null;
	}

	/** @return the next smallest number */
	public int next() {
		if (node == null)
			return 0;
		int res = 0;
		while (node != null) {
			if (node.left == null) {
				res = node.val;
				node = node.right;
				return res;
			}
			TreeNode pre = node.left;
			while (pre.right != null && pre.right != node)
				pre = pre.right;
			if (pre.right == null) {
				pre.right = node;
				node = node.left;
			} else {
				res = node.val;
				node = node.right;
				pre.right = null;
				return res;
			}
		}
		return res;
	}

	private TreeNode node;
}


/**
 * Your BSTIterator will be called like this: BSTIterator i = new
 * BSTIterator(root); while (i.hasNext()) v[f()] = i.next();
 */
