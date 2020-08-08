package JZoffer;
// jz offer 30
class MinStack {

	/** initialize your data structure here. */
	private class ListNode {
		int val;
		int min;
		ListNode next;
		public ListNode(int x){
			this.val=x;
			this.min=Integer.MAX_VALUE;
		}
	}
	private ListNode start;
	//private int min;
	public MinStack() {
		start=null;
		//min=Integer.MAX_VALUE;
	}

	public void push(int x) {
		ListNode temp=new ListNode(x);
		temp.next=start;
		if(start==null)
			temp.min= x;
		else
			temp.min=Math.min(start.min, x);
		start=temp;
	}

	public void pop() {
		if(start==null)
			return;
		start=start.next;
	}

	public int top() {
		if(start==null)
			return -1;
		return start.val;
	}

	public int min() {
		if(start==null)
			return Integer.MIN_VALUE;
		return start.min;
	}
}
public class JZoffer30 {
	public static void main(String []args){
		int x=1;
		MinStack obj = new MinStack();
		obj.push(x);
		obj.push(3);
		obj.push(2);
		obj.pop();
		int param_3 = obj.top();
		int param_4 = obj.min();
		System.out.println(param_3);
		System.out.println(param_4);
	}

}
