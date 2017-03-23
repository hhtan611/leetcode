package Leetcode;

import java.util.Stack;

public class ValidParentheses {
	public static void main(String[] args) {
		String s = "([])";//"([)]";"()[]{}";
		System.out.println(isValid3(s));
	}

	public static boolean isValid2(String s) {
		if (s.length() == 0 || s.length() == 1)
			return false;

		Stack<Character> x = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
				x.push(s.charAt(i));
			} else {
				if (x.size() == 0)
					return false;
				char top = x.pop();
				if (s.charAt(i) == ')') {
					if (top != '(')
						return false;
				} else if (s.charAt(i) == '}') {
					if (top != '{')
						return false;
				} else if (s.charAt(i) == ']') {
					if (top != '[')
						return false;
				}
			}
		}
		return x.size() == 0;
	}

	public static boolean isValid3(String s) {
		if (s.length() == 0)
			return false;
		char[] ca = s.toCharArray();
		Stack<Character> x = new Stack<Character>();
		for (int i = 0; i < ca.length; i++) {
			if (ca[i] == '(' || ca[i] == '[' || ca[i] == '{') {
				x.push(ca[i]);
			} else {
				if (x.size() == 0)
					return false;
				Character top = x.pop();
				if (ca[i] == ')') {
					if (top != '(')
						return false;
				} else if (ca[i] == '}') {
					if (top != '{')
						return false;
				} else if (ca[i] == ']') {
					if (top != '[')
						return false;
				}
			}
		}

		return x.size() == 0;
	}

	public static boolean isValid(String s) {// not work
		char[] ca = s.toCharArray();
		int l = 0, r = 0, l1 = 0, r1 = 0, l2 = 0, r2 = 0;
		for (int i = 0; i < ca.length; i++) {
			if (ca[i] == '[') {
				l++;
			} else if (ca[i] == ']') {
				l--;
				r++;
				if (l1 != 0 || l2 != 0)
					return false;
			} else if (ca[i] == '(') {
				l1++;
			} else if (ca[i] == ')') {
				l1--;
				r1++;
				if (l != 0 || l2 != 0)
					return false;
			} else if (ca[i] == '{') {
				l2++;
			} else if (ca[i] == '}') {
				l2--;
				r2++;
				if (l1 != 0 || l != 0)
					return false;
			}
			if (l < 0 || l1 < 0 || l1 < 0)
				return false;
		}
		if (r == 0 && l > 0 || r1 == 0 && l1 > 0 || r2 == 0 && l2 > 0)
			return false;
		return true;
	}
}
