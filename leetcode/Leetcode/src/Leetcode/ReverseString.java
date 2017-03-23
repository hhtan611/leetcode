package Leetcode;

public class ReverseString {
	public String reverseString(String s) {
		StringBuilder cp = new StringBuilder();
		for (int i = s.length() - 1; i >=0; i--) {
			cp.append(s.charAt(i));
		}
		return cp.toString();
	}
}
