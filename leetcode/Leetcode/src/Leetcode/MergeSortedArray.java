package Leetcode;

public class MergeSortedArray {
	public static void main(String[] args) {
		int[] A = new int[2]; 
		A[0]=0;
		int[] B = { 1 };
		merge(A, 0, B, 1);
	}

	public static void merge(int A[], int m, int B[], int n) {
        int i = m - 1;
        int j = n - 1;
        int x = m + n - 1;
        while (i >= 0 && j >= 0)
            if (A[i] >= B[j]) A[x--] = A[i--];
            else A[x--] = B[j--];
        while (j >= 0) A[x--] = B[j--];
    }
}