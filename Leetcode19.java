/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}
class Solution19 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		// 找出链表的长度
		int len=0;
		ListNode ln=head;
		while(ln!=null){
			len++;
			ln=ln.next;
		}
		if(len<n)
			return null;
		if(len==n){
			return head.next;
		}
//		ln=head;
//		if(len==n)
//			return ln;
		ListNode start=new ListNode(0);
		start.next=head;
		ln=start;
		for(int i=0;i<len-n;i++){
			ln=ln.next;
		}
		ln.next=ln.next.next;
		return head;
	}
}
public class Leetcode19 {
}
