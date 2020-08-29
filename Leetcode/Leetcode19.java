package Leetcode;

/**
 * Definition for singly-linked list.
 * public class Leetcode.ListNode {
 *     int val;
 *     Leetcode.ListNode next;
 *     Leetcode.ListNode(int x) { val = x; }
 * }
 */
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}
class Solution19 {
	// 只用一次遍历实现
	// 方法：两个指针，间隔n，当后一个到达最后时前一个就在该被删除的位置
	public ListNode removeNthFromEnd(ListNode head, int n) {
		// 找出链表的长度
		int len=0;
		ListNode ln1=head,ln2=head;
		// 先让ln2向后走n步，如果不成功则返回null
		while(n!=0){
			if(ln2==null)
				return null;
			ln2=ln2.next;
			n--;
		}
		// 如果走了n步后ln2为空，则被删除的节点就是第一个节点，则返回head.next
		if(ln2==null){
			return head.next;
		}
		// 现在ln1,ln2相差的距离和当ln2在最后时ln1在被删除节点前一节点的距离相同，一种保持即可
		while(ln2.next!=null){
			ln1=ln1.next;
			ln2=ln2.next;
		}
		//ln2到达最后一个节点，ln1也到达了被删除节点签名的节点，执行删除
		ln1.next=ln1.next.next;
		return head;
	}

	public ListNode removeNthFromEnd_1(ListNode head, int n) {
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
