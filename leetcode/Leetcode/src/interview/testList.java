package interview;
import java.util.*;

public class testList {
	// ArrayList和LinkedList的大致区别如下:
	// 1.ArrayList是实现了基于动态数组的数据结构，LinkedList基于链表的数据结构。
	//The ArrayList class is a wrapper class for an array. It contains an inner array.
	/*public ArrayList<T> {
	    private Object[] array;
	    private int size;
	}*/
	/*A LinkedList is a wrapper class for a linked list, with an inner node for managing the data.
	public LinkedList<T> {
	    class Node<T> {
	        T data;
	        Node next;
	        Node prev;
	    }
	    private Node<T> first;
	    private Node<T> last;
	    private int size;
	}*/
	// 2.对于随机访问get和set，ArrayList觉得优于LinkedList，因为LinkedList要移动指针。
	//ArrayList has direct references to every element in the list, so it can get the n-th element in constant time. LinkedList has to traverse the list from the beginning to get to the n-th element.
	// 3.对于新增和删除操作add和remove，LinedList比较占优势，因为ArrayList要移动数据。
	//LinkedList is faster than ArrayList for deletion. I understand this one. ArrayList's slower since the internal backing-up array needs to be reallocated.
	//LinkedList is faster than ArrayList for insertion. 
	public static void main(String[] args) {
		List<String> arr = new ArrayList<String>();
		arr.add("a");
		arr.add("b");
		arr.add("c");
		arr.remove("b");
		System.out.println(arr.get(1)); // output "c"
		List<String> ls = new LinkedList<String>();
		ls.add("a");
		ls.add("b");
		ls.add("c");
		ls.remove("b");
		System.out.println(ls.get(1)); // output "c"
	}

	static final int N = 50000;

	static long timeList(List list) {
		long start = System.currentTimeMillis();
		Object o = new Object();
		for (int i = 0; i < N; i++) {
			list.add(0, o);
		}
		return System.currentTimeMillis() - start;
	}

	static long readList(List list) {
		long start = System.currentTimeMillis();
		for (int i = 0, j = list.size(); i < j; i++) {

		}
		return System.currentTimeMillis() - start;
	}

	static List addList(List list) {
		Object o = new Object();
		for (int i = 0; i < N; i++) {
			list.add(0, o);
		}
		return list;
	}

	public void main2(String[] args) {
		System.out.println("ArrayList添加" + N + "条耗时："
				+ timeList(new ArrayList()));
		System.out.println("LinkedList添加" + N + "条耗时："
				+ timeList(new LinkedList()));

		List list1 = addList(new ArrayList<>());
		List list2 = addList(new LinkedList<>());
		System.out.println("ArrayList查找" + N + "条耗时：" + readList(list1));
		System.out.println("LinkedList查找" + N + "条耗时：" + timeList(list2));
	}
}
