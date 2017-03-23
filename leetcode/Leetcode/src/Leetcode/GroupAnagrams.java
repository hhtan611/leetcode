package Leetcode;

import java.util.*;

public class GroupAnagrams {
	public static void main(String[] args) {
		String[] s = { "" };
		int n=s.length;
		for (List<String> ad : groupAnagrams2(s))
			for (String a : ad)
				System.out.print(a + " ");
		System.out.println();
	}

	public static List<List<String>> anagrams(String[] strs) {
		List<List<String>> lists = new ArrayList<List<String>>();
		if (strs == null || strs.length == 0)
			return lists;

		ArrayList<String> list = new ArrayList<String>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < strs.length; ++i) {
			char[] chars = strs[i].toCharArray();
			Arrays.sort(chars);
			String anagram = new String(chars);

			if (map.containsKey(anagram)) {
				int index = map.get(anagram);
				if (index != -1) {
					list.add(strs[index]);

					map.put(anagram, -1);// 用-1标识第一次出现的重排列字符串
				}
				list.add(strs[i]);
			} else
				map.put(anagram, i);
		}

		Collection<String> mapSet = map.keySet();
		for (String str : mapSet) {
			ArrayList<String> ls = new ArrayList<String>();
			for (int i = 0; i < strs.length; ++i) {
				char[] chars = strs[i].toCharArray();
				Arrays.sort(chars);
				String anagram = new String(chars);

				if (str.equals(anagram))
					ls.add(strs[i]);
			}
			lists.add(ls);
		}
		return lists;
	}

	public static List<List<String>> groupAnagrams2(String[] strs) {
		if (strs == null || strs.length == 0)
			return new ArrayList<List<String>>();
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		Arrays.sort(strs);
		for (String s : strs) {
			char[] ca = s.toCharArray();
			Arrays.sort(ca);
			String keyStr = String.valueOf(ca);
			if (!map.containsKey(keyStr))
				map.put(keyStr, new ArrayList<String>());
			map.get(keyStr).add(s);
		}
		List<List<String>> ll= new ArrayList<List<String>>(map.values());
		return ll;
	}
}
