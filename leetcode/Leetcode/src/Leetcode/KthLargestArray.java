package Leetcode;

public class KthLargestArray {
	public static void main(String[] args) {
		int[] a = { 3, 2, 1, 5, 6, 4 };
		int[][] aa = new int[][] { { 1 }, { 2 } };
		System.out.print(findKthLargest2(a, 2));
	}

	public static int findKthLargest(int[] nums, int k) {
		for (int i = 1; i < nums.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (nums[j + 1] > nums[j]) {
					swap(nums, j + 1, j);
				}
			}
		}
		return nums[k - 1];
	}

	static void swap(int a[], int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	public static int findKthLargest2(int[] a, int k) {
		int n = a.length;
		int p = quickSelect2(a, 0, n - 1, n - k + 1);
		return a[p];
	}

	// return the index of the kth smallest number
	static int quickSelect2(int[] a, int lo, int hi, int k) {
		// use quick sort's idea
		// put nums that are <= pivot to the left
		// put nums that are > pivot to the right
		int i = lo, j = hi, pivot = a[hi];
		while (i < j) {
			if (a[i++] > pivot)
				swap(a, --i, --j);
		}
		swap(a, i, hi);

		// count the nums that are <= pivot from lo
		int m = i - lo + 1;

		// pivot is the one!
		if (m == k)
			return i;
		// pivot is too big, so it must be on the left
		else if (m > k)
			return quickSelect2(a, lo, i - 1, k);
		// pivot is too small, so it must be on the right
		else
			return quickSelect2(a, i + 1, hi, k - m);
	}
}
