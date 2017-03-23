package interview;
public class ReverseString {
	public static void main(String args[]) {
		String s = "hello";
		char[] sa = s.toCharArray();

		StringBuilder sb = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--) {
			sb.append(sa[i]);
		}
		System.out.println(sb);
	}
}
