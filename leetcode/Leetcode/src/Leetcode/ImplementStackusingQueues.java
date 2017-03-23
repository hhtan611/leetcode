package Leetcode;

import java.util.*;

public class ImplementStackusingQueues {

	public static void main(String[] args) {
		MyStack obj = new MyStack();
		int x = 1;
		obj.push(x);
		int param_3 = obj.top();
		int param_2 = obj.pop();

		Boolean param_4 = obj.empty();
	}

	Queue<Integer> ls;

	/** Initialize your data structure here. */
	public ImplementStackusingQueues() {
		ls = new LinkedList<Integer>();
	}

	/** Push element x onto stack. */
	public void push(int x) {
		ls.add(x);
		for (int i = 0; i < ls.size() - 1; i++) {
			ls.add(ls.poll());
		}
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		return ls.poll();
	}

	/** Get the top element. */
	public int top() {
		return ls.peek();
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		/*
		 * if(ls.size()== 0) return true; return false;
		 */
		return ls.isEmpty();
	}
}

class MyStack {
	// using two queue. The push is inefficient.
	private Queue<Integer> q1 = new LinkedList<Integer>();
	private Queue<Integer> q2 = new LinkedList<Integer>();

	public void push(int x) {
		q1.offer(x);
	}

	public int pop() {
		while(q1.size()>1){
			q2.offer(q1.poll());
		}
		int temp = q1.poll();
		 Queue tmp = q1;
        q1 = q2;
        q2 = tmp;
		return temp;
	}

	public int top() {
		while(q1.size()>1){
			q2.offer(q1.poll());
		}
		int top = q1.peek();
	 q2.offer(q1.poll());
        
        Queue tmp = q1;
        q1 = q2;
        q2 = tmp;
		return top;
	}

	public boolean empty() {
		 return q1.isEmpty();
	}
}
