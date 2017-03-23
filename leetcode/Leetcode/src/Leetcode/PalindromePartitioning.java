package Leetcode;

import java.util.*;

/*
Author:     Andy, nkuwjg@gmail.com
Date:       Jan 20, 2015
Problem:    Palindrome Partitioning
Difficulty: Easy
Source:     https://oj.leetcode.com/problems/palindrome-partitioning/
Notes:
Given a string s, partition s such that every substring of the partition is a palindrome.
Return all possible palindrome partitioning of s.
For example, given s = "aab",
Return
[
 ["aa","b"],
 ["a","a","b"]
]
Solution: ...
*/
public class PalindromePartitioning {
	public static void main(String[] args) {
		String s = "aba";
		for (List<String> aa : partition(s)) {
			System.out.println("]");
			for (String b : aa) {
				System.out.print(b + " ");
			}
		}
	}

	public static List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<List<String>>();
		int n = s.length();
		boolean[][] dp = new boolean[n][n];
		for (int i = n - 1; i >= 0; --i) {
			for (int j = i; j < n; ++j) {
				dp[i][j] = (s.charAt(i) == s.charAt(j)) && (j < i + 2 || dp[i + 1][j - 1]);
			}
		}
		ArrayList<String> path = new ArrayList<String>();
		dfs(s, dp, 0, path, res);
		return res;
	}

	public static void dfs(String s, boolean[][] dp, int start, ArrayList<String> path, List<List<String>> res) {
		if (s.length() == start) {
			res.add(new ArrayList<String>(path));
			return;
		}
		for (int i = start; i < s.length(); ++i) {
			if (dp[start][i] == false)
				continue;
			path.add(s.substring(start, i + 1));
			dfs(s, dp, i + 1, path, res);
			path.remove(path.size() - 1);
		}
	}
}
