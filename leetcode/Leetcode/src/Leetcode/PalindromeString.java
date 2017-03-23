package Leetcode;

public class PalindromeString {
	public static void main(String[] args) {
		String s = "123 456, 78, 87 654321";
		isPalindrome(s);
	}

	public static boolean isPalindrome(String s) {
		char[] ca = s.toCharArray();
		char[] res = new char[ca.length];
		int j = 0;
		for (int i = 0; i < ca.length; i++) {
			if (Character.isDigit(ca[i])) {
				res[j] = ca[i];
				j++;
			}
		}

		String a = res.toString().trim();
		res = a.toCharArray();
		char[] rev = new char[ca.length];
		int n = res.length / 2 - 1;
		for (int i = 0; i < n; i++) {
			rev[n--] = res[i];
		}
		char[] rev2 = new char[ca.length];
		int j1 = 0;
		for (int i = n; i < res.length; i++) {
			rev2[j1++] = res[i];
		}
		if (rev.toString().equals(rev2.toString()))
			return true;
		else
			return false;
	}
}
