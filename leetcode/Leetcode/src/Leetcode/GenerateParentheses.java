package Leetcode;

import java.util.*;

/*
 Author:     King, wangjingui@outlook.com
 Date:       Dec 20, 2014
 Problem:    Generate Parentheses
 Difficulty: Medium
 Source:     https://oj.leetcode.com/problems/generate-parentheses/
 Notes:
 Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 For example, given n = 3, a solution set is:
 "((()))", "(()())", "(())()", "()(())", "()()()"
 Solution: Place n left '(' and n right ')'.
 Cannot place ')' if there are no enough matching '('.
 */

public class GenerateParentheses {
	public static void main(String[] args) {

		List<String> ls = generateParenthesis(2);
		for (String s : ls)
			System.out.print(s + " , ");
	}

	public static List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<String>();
		generateParenthesisRe(res, n, n, "");
		return res;
	}

	private static void generateParenthesisRe(List<String> res, int left,
			int right, String s) {
		if (left == 0 && right == 0)
			res.add(s);
		if (left > 0)
			generateParenthesisRe(res, left - 1, right, s + "(");
		if (right > left)
			generateParenthesisRe(res, left, right - 1, s + ")");
	}
}