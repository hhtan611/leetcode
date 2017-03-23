package interview;
public class findMinNum {
	public static void main(String[] args) {
		reverseString("abcde");
	}

	public static void reverseString(String s) {
		if (s == null || s.isEmpty() || (s.length() == 1)) {
			System.out.println(new String(s));
		} else {
			int len = s.length();
			char[] ss = s.toCharArray();
			char[] rs = new char[len];
			for (int i = len - 1; i >= 0; i--) {
				rs[len - 1 - i] = ss[i];
			}
			System.out.println(new String(rs));
		}
	}

	public void findMinNum(String s) {
		int[] num = { 52, 77, 73, 9, 12, 88, 1 };
		int min = num[0];
		for (int i = num.length - 1; i > 0; i--) {
			if (num[i] < min)
				min = num[i];
		}
		System.out.println(min);
	}
}
