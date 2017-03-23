package Leetcode;

import java.util.*;

/*
 Author:     King, wangjingui@outlook.com
 Date:       Nov 20, 2014
 Problem:    Binary Tree Postorder Traversal 
 Difficulty: Easy
 Source:     http://oj.leetcode.com/problems/binary-tree-postorder-traversal/
 Notes:
 Given a binary tree, return the postorder traversal of its nodes' values.
 For example:
 Given binary tree {1,#,2,3},
 1
 \
 2
 /
 3
 return [3,2,1].
 Note: Recursive solution is trivial, could you do it iteratively?
 Solution: 1. Iterative way (stack).   Time: O(n), Space: O(n).
 2. Recursive solution.      Time: O(n), Space: O(n).
 3. Threaded tree (Morris).  Time: O(n), Space: O(n/1). 
 Space: O(1) if in-place reverse.
 You may refer to my blog for more detailed explanations: 
 http://www.cnblogs.com/AnnieKim/archive/2013/06/15/MorrisTraversal.html
 */

public class BinaryTreePostorderTraversal {
	public static void main(String[] args) {
		// System.out.print(Math.abs(1-3));
		TreeNode root = new TreeNode(3);
		TreeNode sn = new TreeNode(1);
		sn.right = new TreeNode(2);
		root.right = sn;
		sn.left = new TreeNode(5);
		root.right = new TreeNode(0);

		BinaryTreePostorderTraversal b = new BinaryTreePostorderTraversal();
		System.out.print(b.postorderTraversal(root));
	}

	public List<Integer> postorderTraversal_1(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		Stack<TreeNode> stk = new Stack<TreeNode>();
		TreeNode cur = root;
		TreeNode pre = null;
		while (stk.isEmpty() == false || cur != null) {
			if (cur != null) {
				stk.push(cur);
				cur = cur.left;
			} else {
				TreeNode peak = stk.peek();
				if (peak.right != null && peak.right != pre) {
					cur = peak.right;
				} else {
					res.add(peak.val);
					stk.pop();
					pre = peak;
				}
			}
		}
		return res;
	}

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		List<Integer> left = postorderTraversal(root.left);
		List<Integer> right = postorderTraversal(root.right);
		res.addAll(left);
		res.addAll(right);
		res.add(root.val);
		return res;
	}

}
