package interview;
public class ArrayBinarySearch {
	public static void main(String[] s) {
		int[] arr = { 2, 3, 4, 5, 6 };
		int low = 0;
		int high = arr.length;
		int key = binarySearch0(arr, 3, low, high);
		System.out.print(key);
	}

	public static int binarySearch0(int[] arr, int key, int low, int high) {
		int mid = (low + high) >>> 1;
		int rslt = -1;
		if (key < arr[mid]) {
			binarySearch0(arr, key, low, mid);
		} else if (key > arr[mid]) {
			binarySearch0(arr, key, mid, high);
		} else if (key == arr[mid]) {
			return mid;
		}
		return rslt;
	}

	private static int binarySearch(int[] arr, Object key, int fromIndex,int toIndex) {
		int low = fromIndex;
		int high = toIndex - 1;

		while (low <= high) {
			int mid = (low + high) >>> 1;
			Comparable midval = arr[mid];
			int cmp = midval.compareTo(key);
			
			if (cmp < 0)
				mid = mid - 1;
			else if (cmp > 0)
				mid = mid + 1;
			else
				return mid;
		}
		return -(low + 1); // key not found.
	}
}
