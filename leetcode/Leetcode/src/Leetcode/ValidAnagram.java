package Leetcode;

import java.util.*;
/*Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?

Subscribe to see which companies asked this question.*/

public class ValidAnagram {
	public static void main(String[] args) {
		String s = "", t = "";
		System.out.println(isAnagram(s, t));
	}

	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		int[] af = new int[26];
		for (int i = 0; i < s.length(); i++) {
			af[s.charAt(i) - 'a']++;
			af[t.charAt(i) - 'a']--;
		}

		for (int i = 0; i < af.length; i++) {
			if (af[i] != 0)
				return false;
		}
		return true;
	}

	//did not pass all the case
	public static boolean isAnagram2(String s, String t) {
		if (s == "" && t == "")
			return true;
		char[] sc = s.toCharArray();
		char[] tc = t.toCharArray();
		Arrays.sort(sc);
		Arrays.sort(tc);
		String s1 = sc.toString();
		String s2 = tc.toString();
		if (s1.equals(s2))
			return true;
		else
			return false;
	}
}
