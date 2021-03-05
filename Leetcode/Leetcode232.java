package Leetcode;

import java.util.*;
class MyQueue1 {
	Stack<Integer> insta;
	Stack<Integer> outsta;
	public MyQueue1() {
		insta = new Stack<>();
		outsta = new Stack<>();
	}
	public void push(int x) {
		insta.push(x);
	}
	public int pop() {
		if (outsta.isEmpty()){
			in2out();
		}
		return outsta.pop();
	}
	public int peek() {
		if (outsta.isEmpty()){
			in2out();
		}
		return outsta.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return insta.isEmpty()&& outsta.empty();
	}
	public void in2out(){
		while (!insta.isEmpty()){
			outsta.push(insta.pop());
		}
	}
}

class MyQueue {
	Stack<Integer> sta1;
	Stack<Integer> sta2;

	/** Initialize your data structure here. */
	public MyQueue() {
		sta1 = new Stack<>();
		sta2 = new Stack<>();
	}

	/** Push element x to the back of queue. */
	public void push1(int x) {
		sta1.push(x);
		while (!sta2.isEmpty()){
			sta1.push(sta2.pop());
		}
		Stack<Integer> temp = sta2;
		sta2 = sta1;
		sta1 = temp;
		System.out.println("push "+sta1.toString()+"  "+sta2.toString());
	}

	public void push(int x) {
		while (!sta2.isEmpty()){
			sta1.push(sta2.pop());
		}
		sta2.push(x);
		while (!sta1.isEmpty()){
			sta2.push(sta1.pop());
		}
//		Stack<Integer> temp = sta2;
//		sta2 = sta1;
//		sta1 = temp;
		System.out.println("push "+sta1.toString()+"  "+sta2.toString());
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop1() {
		System.out.println("pop "+sta1.toString()+"  "+sta2.toString());
		return sta2.pop();
	}

	public int pop() {
		System.out.println("pop "+sta1.toString()+"  "+sta2.toString());
		return sta2.pop();
	}

	/** Get the front element. */
	public int peek() {
		return sta2.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return sta2.isEmpty();
	}
}
public class Leetcode232 {
	public static void main(String []args){
		MyQueue obj = new MyQueue();
        obj.push(1);
		obj.push(2);
		obj.push(3);
		obj.push(4);
		System.out.println(obj.pop());
		obj.push(5);
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
        boolean param_4 = obj.empty();
	}
}
