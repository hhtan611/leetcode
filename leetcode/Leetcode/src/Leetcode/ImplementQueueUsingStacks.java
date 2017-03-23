package Leetcode;

import java.util.Stack;

public class ImplementQueueUsingStacks {
	public static void main(String[] args) {
		 MyQueue2 obj = new MyQueue2();
		 obj.push(1);obj.push(2);obj.push(3);obj.push(4);
		 //int param_3 = obj.peek();
		 while(!obj.empty()){
		 System.out.print(obj.pop()+ " ");
		 }
		
		 boolean param_4 = obj.empty();
	}
}
class MyQueue {
	Stack<Integer> stack1 = new Stack<>();
	Stack<Integer> stack2 = new Stack<>();
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
    	while(!stack1.isEmpty()){
    		stack2.push(stack1.pop());
    	}
    	int top = stack2.pop();
    	while(!stack2.isEmpty()){
    		stack1.push(stack2.pop());
    	}
        return top;
    }
    
    /** Get the front element. */
    public int peek() {
    	while(!stack1.isEmpty()){
    		stack2.push(stack1.pop());
    	}
    	int top = stack2.peek();
    	while(!stack2.isEmpty()){
    		stack1.push(stack2.pop());
    	}
        return top;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty();
    }
}

class MyQueue2 {
	Stack<Integer> stack = new Stack<>();
    
	public void push(int x) {
    	Stack<Integer> tmp = new Stack<>();
    	while(!stack.isEmpty()){
    		tmp.push(stack.pop());
    	}
        stack.push(x);
        while(!tmp.isEmpty()){
    		stack.push(tmp.pop());
    	}
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return stack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */