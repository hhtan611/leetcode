package Leetcode;

/*
 Author:     Andy, nkuwjg@gmail.com
 Date:       Jan 16, 2015
 Problem:    Construct Binary Tree from Preorder and Inorder Traversal
 Difficulty: Medium
 Source:     https://oj.leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 Notes:
 Given preorder and inorder traversal of a tree, construct the binary tree.
 Note:
 You may assume that duplicates do not exist in the tree.
 Solution: Recursion.
 */

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
	/*
	 * public TreeNode buildTree(int[] preorder, int[] inorder) {
	 * if(inorder.length == 0 || preorder.length == 0 || inorder.length !=
	 * preorder.length) return null; return buildTreeRe(preorder, 0, inorder, 0,
	 * preorder.length); } public TreeNode buildTreeRe(int[] preorder, int s1,
	 * int[] inorder, int s2, int size) { if (size <= 0 ) return null; TreeNode
	 * node = new TreeNode(preorder[s1]); if (size == 1) return node; int pos =
	 * s2; while (pos <= (s2 + size - 1)) { if (inorder[pos] == preorder[s1])
	 * break; ++pos; } int leftlen = pos - s2; node.left = buildTreeRe(preorder,
	 * s1 + 1, inorder, s2, leftlen); node.right = buildTreeRe(preorder, s1 +
	 * leftlen + 1, inorder, pos + 1, size - leftlen - 1); return node; }
	 */
	public static void main(String[] args) {
		int a[] = { 8, 4, 2, 5, 1, 6, 3, 7 };
		int b[] = { 1, 2, 4, 8, 5, 3, 6, 7};
		buildTree(a, b);
	}
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		int len1 = inorder.length, len2 = preorder.length;
		return buildTreeRe(inorder, 0, len1 - 1, preorder, 0, len2 - 1);
	}

	private static TreeNode buildTreeRe(int[] inorder, int s1, int e1,
			int[] preorder, int s2, int e2) {
		if (s1 > e1)
			return null;
		if (s1 == e1)
			return new TreeNode(preorder[s2]);
		int j = -1;
		for (int i = 0; i <= e1; i++) {
			if (inorder[i] == preorder[s2]) {
				j = i;
				break;
			}
		}
		int leftlen = j - s1;
		TreeNode root = new TreeNode(preorder[s2]);
		root.left = buildTreeRe(inorder, s1, j - 1, preorder, s2+1, s2+ leftlen);
		root.right = buildTreeRe(inorder, j + 1, e1, preorder, s2+1 + leftlen,e2);
		return root;
	}
}