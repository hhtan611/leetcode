package Leetcode;

import java.util.*;
import java.util.Map.Entry;

/*
 Author:     King, wangjingui@outlook.com
 Date:       Dec 20, 2014
 Problem:    Count and Say
 Difficulty: Easy
 Source:     https://oj.leetcode.com/problems/count-and-say/
 Notes:
 The count-and-say sequence is the sequence of integers beginning as follows:
 1, 11, 21, 1211, 111221, ...
 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.
 Given an integer n, generate the nth sequence.
 Note: The sequence of integers will be represented as a string.
 Solution: ...
 */

public class CountandSay {
	public static void main(String[] args) {
		countAndSay(5);
	}

	public static String countAndSay(int n) {
		String[] s = new String[n];
		s[0] = "1";
		for (int i = 1; i < n; i++) {
			List<List<String>> ls = new ArrayList<List<String>>();
			char[] ch = s[i - 1].toCharArray();
			ls.add(new ArrayList<String>());
			String s0 = String.valueOf(ch[0]);
			ls.get(0).add(s0);
			int y = 0;
			for (int j = 1; j < ch.length; j++) {
				if (ch[j-1]!=ch[j]) {
					ls.add(new ArrayList<String>());
					y++;
				}
				ls.get(y).add(String.valueOf(ch[j]));
			}
			StringBuilder sb = new StringBuilder();
			for (List<String> subls : ls) {
				sb.append(subls.size());
				sb.append(subls.get(0));
			}
			s[i] = sb.toString();
		}
		return s[n - 1].toString();
	}
	 public String countAndSay2(int n) {
	        StringBuffer s = new StringBuffer("1");
	        StringBuffer res = new StringBuffer();
	        while((--n) != 0){
	            res.setLength(0);
	            int size = s.length();
	            int cnt = 1;
	            char cur = s.charAt(0);
	            for(int i=1;i<size;i++){
	                if(s.charAt(i)!=cur){
	                    res.append(cnt);
	                    res.append(cur);
	                    cur = s.charAt(i);
	                    cnt = 1;
	                }else ++cnt;
	            }
	            res.append(cnt);
	            res.append(cur);
	            StringBuffer tmp = s;
	            s = res;
	            res = tmp;
	        }
	        return s.toString();
	    }
	 
}