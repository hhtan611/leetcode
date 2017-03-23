package Leetcode;

import java.util.*;

/*
 Author:     King, wangjingui@outlook.com
 Date:       Dec 13, 2014
 Problem:    Reverse Words in a String 
 Difficulty: Easy
 Source:     https://oj.leetcode.com/problems/reverse-words-in-a-string/
 Notes:
 Given an input string, reverse the string word by word.
 For example,
 Given s = "the sky is blue",
 return "blue is sky the".
 Solution: 1. Reverse the raw string and reverse each word.
 2. Cannot do it In Place by Java. oops~.~
 */
public class ReverseWordsInAString {
	public static void main(String[] args) {
		String s = "   a   b ";
		System.out.print(reverseWords(s));
		
	}

	public static String reverseWords(String s) {
		String[] ss = s.trim().split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = ss.length - 1; i >= 0; i--) {
			sb.append(ss[i] + " ");
		}
		return sb.toString().trim();
	}

	public static String reverseWords2(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = s.length() - 1; i >= 0;) {
			while (i >= 0 && s.charAt(i) == ' ')
				--i;
			StringBuffer temp = new StringBuffer();
			while (i >= 0 && s.charAt(i) != ' ') {
				temp.append(s.charAt(i--));
			}
			temp.reverse();
			if (sb.length() > 0 && temp.length() > 0)
				sb.append(" ");
			sb.append(temp);
		}
		return sb.toString();
	}
}
