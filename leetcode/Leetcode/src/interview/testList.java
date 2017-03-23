package interview;
import java.util.*;

public class testList {
	// ArrayList��LinkedList�Ĵ�����������:
	// 1.ArrayList��ʵ���˻��ڶ�̬��������ݽṹ��LinkedList������������ݽṹ��
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
	// 2.�����������get��set��ArrayList��������LinkedList����ΪLinkedListҪ�ƶ�ָ�롣
	//ArrayList has direct references to every element in the list, so it can get the n-th element in constant time. LinkedList has to traverse the list from the beginning to get to the n-th element.
	// 3.����������ɾ������add��remove��LinedList�Ƚ�ռ���ƣ���ΪArrayListҪ�ƶ����ݡ�
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
		System.out.println("ArrayList���" + N + "����ʱ��"
				+ timeList(new ArrayList()));
		System.out.println("LinkedList���" + N + "����ʱ��"
				+ timeList(new LinkedList()));

		List list1 = addList(new ArrayList<>());
		List list2 = addList(new LinkedList<>());
		System.out.println("ArrayList����" + N + "����ʱ��" + readList(list1));
		System.out.println("LinkedList����" + N + "����ʱ��" + timeList(list2));
	}
}
