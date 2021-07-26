package cxymsjd;

import java.util.*;
class SortedStack {

	Stack<Integer> mainStack ;
	Stack<Integer> helpStack ;

	public SortedStack() {
		mainStack = new Stack<>();
		helpStack = new Stack<>();
	}

	public void push(int val) {
		while (!mainStack.isEmpty() && mainStack.peek()<val){
			helpStack.push(mainStack.pop());
		}
		mainStack.push(val);
		while (!helpStack.isEmpty()){
			mainStack.push(helpStack.pop());
		}
	}

	public void pop() {
		if (mainStack.isEmpty()){
			return;
		}
		mainStack.pop();
	}

	public int peek() {
		if (mainStack.isEmpty()){
			return -1;
		}
		return mainStack.peek();
	}

	public boolean isEmpty() {
		return mainStack.isEmpty();
	}
}
public class mst0305 {
}
