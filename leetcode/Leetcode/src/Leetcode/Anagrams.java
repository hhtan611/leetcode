package Leetcode;

/*
 Author:     King, wangjingui@outlook.com
 Date:       Dec 25, 2014
 Problem:    Anagrams
 Difficulty: Easy
 Source:     https://oj.leetcode.com/problems/anagrams/
 Notes:
 Given an array of strings, return all groups of strings that are anagrams.
 Note: All inputs will be in lower-case.
 Solution: Sort the string to see if they're anagrams.
 */

import java.util.*;
import java.util.Map.Entry;

public class Anagrams {
	public static void main(String[] args) {
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<String> ls = anagrams(strs);
	}

	public static List<String> anagrams(String[] strs) {
		ArrayList<String> res = new ArrayList<String>();
		HashMap<String, ArrayList<String>> group = new HashMap<String, ArrayList<String>>();
		if (strs.length == 0)
			return res;
		for (int i = 0; i < strs.length; ++i) {
			char[] tmp = strs[i].toCharArray();
			Arrays.sort(tmp);
			String s = String.valueOf(tmp);
			if (group.containsKey(s))
				(group.get(s)).add(strs[i]);
			else {
				ArrayList<String> t = new ArrayList<String>();
				t.add(strs[i]);
				group.put(s, t);
			}
		}
		Iterator<Entry<String, ArrayList<String>>> iter = group.entrySet()
				.iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			ArrayList<String> val = (ArrayList<String>) entry.getValue();
			if (val.size() > 1)
				res.addAll(val);
		}
		return res;
	}

	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs.length == 0 || strs == null)
			return new ArrayList<List<String>>();
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String str : strs) {
			char[] tmp = str.toCharArray();
			Arrays.sort(tmp);
			String keys = String.valueOf(tmp);
			if (!map.containsKey(keys)) {
				map.put(keys, new ArrayList<String>());
			}
			map.get(keys).add(str);
		}		
		return new ArrayList<List<String>>(map.values());
	} 

}
