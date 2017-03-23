package interview;
public class printEmptyString {
	public static void main(String[] s) {
		int n = 6;
		for (int x = 0; x < n; x++) {
			for (int i = n - x; i > 0; i--) {
				System.out.print(" ");
			}
			for (int j = n - x - 1; j < n; j++) {
				System.out.print("#");
			}
			System.out.print("\n");
		}
	}
}
