package Leetcode;

import java.util.*;

public class DecodeString {
	public static void main(String[] args) {
		String s = "sd2[f2[e]g]i";// "2[abc]xyc3[z]";//"2[2[b]]";
		System.out.print(decodeString2(s));
	}

	public static String decodeString(String s) {
		int N = s.length();
		int right = 0, left = 0;
		StringBuilder ct = new StringBuilder();
		Stack<String> counts = new Stack<String>();
		Stack<String> strings = new Stack<String>();
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		for (int i = 0; i < N; i++) {
			char cur = s.charAt(i);
			if (cur == '[') {
				left++;
				if (sb.length() != 0) {
					strings.push(sb.toString());
					sb = new StringBuilder();
				}
				if (ct.length() > 0) {
					counts.push(ct.toString());
					ct = new StringBuilder();
				}
				strings.push("[");
			}
			if (cur == ']' && right < left) {
				right++;
				if (sb.length() != 0) {
					strings.push(sb.toString());
					sb = new StringBuilder();
				}
				if (ct.length() > 0) {
					counts.push(ct.toString());
					ct = new StringBuilder();
				}
				int num = Integer.valueOf(counts.pop());
				String tmp = "";
				while (strings.peek() != "[") {
					tmp = strings.pop() + tmp;
				}
				if (strings.peek() == "[")
					strings.pop();
				while (num > 0) {
					sb2.append(tmp);
					num--;
				}
				if (strings.size() > 0 && (strings.peek() != "[")) {
					String tmp2 = strings.pop();
					tmp2 = tmp2 + sb2.toString();
					strings.push(tmp2);
					sb2 = new StringBuilder();
				}
				if (sb2.length() > 0
						&& ((strings.size() == 0) || (strings.peek() == "["))) {
					strings.push(sb2.toString());
					sb2 = new StringBuilder();
				}
				sb = new StringBuilder();
			}
			if (right > left)
				return null;
			if (cur >= '0' && cur <= '9') {
				ct.append(cur);
				// int n = cur - '0';
			} else if (cur >= 'a' && cur <= 'z') {
				sb.append(cur);
			}
		}
		if (right == left) {
			if (strings.size() > 1) {
				String tmp = "";
				while (strings.size() > 0) {
					tmp = strings.pop() + tmp;
				}
				sb2.append(tmp);
			}

			if (strings.size() > 0)
				sb2.append(strings.pop());
			if (sb.length() > 0)
				sb2.append(sb);
		}
		return sb2.toString();
	}

	public static String decodeString2(String s) {
		Stack<Integer> inStack = new Stack<>();
		Stack<StringBuffer> charStack = new Stack<>();
		StringBuffer sb = new StringBuffer();
		int count = 0;
		for (char c : s.toCharArray()) {
			if (Character.isDigit(c))
				count = count * 10 + c - '0';
			else if (c == '[') {
				inStack.add(count);
				charStack.add(sb);
				count = 0;
				sb = new StringBuffer();
			} else if (c == ']') {
				StringBuffer tem = sb;
				sb = charStack.pop();
				for (int k = inStack.pop(); k > 0; k--)
					sb.append(tem);
			} else
				sb.append(c);
		}
		return sb.toString();
	}


}
