package JZoffer;

import java.util.*;
class MaxQueue {
	Queue<Integer> queue ;
	Deque<Integer> stack;

	public MaxQueue() {
		queue = new LinkedList<>();
		stack = new LinkedList<>();
	}

	public int max_value() {
		if (queue.isEmpty())
			return -1;
		return stack.peekFirst();
	}

	public void push_back(int value) {
		while (!stack.isEmpty() && stack.peekLast()< value){
			stack.pollLast();
		}
		stack.offerLast(value);
		queue.offer(value);
	}

	public int pop_front() {
		if (queue.isEmpty())
			return -1;
		int ans = queue.poll();
		if (ans== stack.peekFirst())
			stack.pollFirst();
		return ans;
	}
}
public class JZoffer59_2 {
}
