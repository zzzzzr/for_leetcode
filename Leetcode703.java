import java.util.*;
// leetcode703
class KthLargest {
	private PriorityQueue<Integer> que;
	private int k;

	public KthLargest(int k, int[] nums) {
		this.k = k;
		this.que = new PriorityQueue<>();
		for (int i:nums) {
			this.que.offer(i);
			if (this.que.size()>k)
				this.que.poll();
		}
	}

	public int add(int val) {
		this.que.offer(val);
		while (this.que.size()>k){
			this.que.poll();
		}
		return this.que.peek();
	}
}
public class Leetcode703 {
	public static void main(String []args){
		int k = 3;
		int[] arr =new int[] {4,5,8,2};
		KthLargest kthLargest = new KthLargest(3, arr);
		System.out.println(kthLargest.add(3));
		System.out.println(kthLargest.add(5));
		System.out.println(kthLargest.add(10));
		System.out.println(kthLargest.add(9));
		System.out.println(kthLargest.add(4));
	}
}
