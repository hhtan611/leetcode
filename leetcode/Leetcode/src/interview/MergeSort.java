package interview;
//import java.util.*;

public class MergeSort {
	public static void main(String[] s) {
		/*String[] sa = { "5", "3", "1", "5", "31" };
		String[] sad = sa.clone();

		// Arrays.sort(sad);
		mergeSort(sad, 0, sa.length);

		for (int i = 0; i < sad.length; i++) {
			//System.out.print(sad[i] + " \\n");
			Integer.parseInt("x");
		}*/
		bubbleSort();

	}
	

	private static void mergeSort(Object[] dest, int low, int high) {
		for (int i = 0; i < dest.length; i++) {
			for (int j = i; j > low; j--) {
				if (((Comparable) dest[j - 1]).compareTo(dest[j]) > 0)
					swap(dest, j, j - 1);
			}
		}
	}
	
	public static void bubbleSort(){  
		   
	    int a[]={1,54,6,3,78,34,12,45};  
	   
	    int temp=0;  
	   
	    for(int i=0;i<a.length;i++){  
	   
	       for(int j=i+1;j<a.length;j++){  
	   
	       if(a[i]>a[j]){  
	   
	           temp=a[i];  
	   
	           a[i]=a[j];  
	   
	           a[j]=temp;  
	   
	       }  
	   
	       }  
	   
	    }  
	   
	    for(int i=0;i<a.length;i++)  
	   
	       System.out.println(a[i]);     
	   
	}  
	
	void SortByRecursion( Object[] dest, int n )
	{
	    int i;
	    if(1 == n)
	    {
	        return;
	    }
	    for(i = 0; i < n - 1; i++)
	    {
	        if (((Comparable) dest[i - 1]).compareTo(dest[i]) > 0)
	        	swap(dest, i, i - 1);
	    }
	    SortByRecursion( dest, n - 1 );
	}

	private static void swap(Object[] src, int j, int i) {
		Object d = src[j];
		src[j] = src[i];
		src[i] = d;
	}
}
