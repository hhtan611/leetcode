package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagramsinaString {
	public static void main(String[] args) {
		String s = "cbaebabacd";
		String p = "abc";
		for (int a : findAnagrams1(s, p))
			System.out.print(a);
	}

	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> list = new ArrayList<>();
		if (s == null || s.length() == 0 || p == null || p.length() == 0)
			return list;
		int[] hash = new int[256]; // character hash
		// record each character in p to hash
		for (char c : p.toCharArray()) {
			hash[c]++;
		}
		// two points, initialize count to p's length
		int left = 0, right = 0, count = p.length();
		while (right < s.length()) {
			// move right everytime, if the character exists in p's hash,
			// decrease the count
			// current hash value >= 1 means the character is existing in p
			if (hash[s.charAt(right++)]-- >= 1)
				count--;

			// when the count is down to 0, means we found the right anagram
			// then add window's left to result list
			if (count == 0)
				list.add(left);

			// if we find the window's size equals to p, then we have to move
			// left (narrow the window) to find the new match window
			// ++ to reset the hash because we kicked out the left
			// only increase the count if the character is in p
			// the count >= 0 indicate it was original in the hash, cuz it won't
			// go below 0
			if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0)
				count++;
		}
		return list;
	}

	public static List<Integer> findAnagrams1(String s, String p) {
		ArrayList<Integer> lst = new ArrayList<Integer>();
		int n = s.length(), m = p.length();
		for (int i = 0; i < n - m + 1; i++) {
			String subStr = s.substring(i, i + m);
			if (compare(subStr, p))
				lst.add(i);
		}
		return lst;

	}

	public static boolean compare(String a, String b) {
		int[] dic = new int[26];
		for (int i = 0; i < a.length(); i++)
			dic[a.charAt(i) - 'a']++;

		for (int i = 0; i < b.length(); i++)
			dic[b.charAt(i) - 'a']--;

		for (int i = 0; i < dic.length; i++) {
			if (dic[i] < 0)
				return false;
		}
		return true;
	}

}
