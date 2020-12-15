package Leetcode;

import LeetcodeStructure.ListNode;

class Solution25 {
	// 这个方法的对链表倒序的方式要好好看看
	public LeetcodeStructure.ListNode reverseKGroup2(LeetcodeStructure.ListNode head, int k) {
		LeetcodeStructure.ListNode root = new LeetcodeStructure.ListNode(0);
		root.next=head;
		LeetcodeStructure.ListNode cur = root;
		while (true){
			LeetcodeStructure.ListNode temp = cur;
			int templen=0;
			while (temp.next!=null&& templen<k){
				temp=temp.next;
				templen++;
			}
			if (templen<k)
				return root.next;
			LeetcodeStructure.ListNode[]slice = reverse(cur.next,temp);
			cur.next = slice[0];
			cur = slice[1];
		}
	}
	public LeetcodeStructure.ListNode[] reverse(LeetcodeStructure.ListNode head, LeetcodeStructure.ListNode tail) {
		LeetcodeStructure.ListNode prev = tail.next;
		LeetcodeStructure.ListNode p = head;
		while (prev != tail){
			LeetcodeStructure.ListNode next = p.next;
			p.next = prev;
			prev = p;
			p = next;
		}
		return new LeetcodeStructure.ListNode[]{tail,head};
	}

	// ----------------------------------------------------------------

	public LeetcodeStructure.ListNode reverseKGroup1(LeetcodeStructure.ListNode head, int k) {
		LeetcodeStructure.ListNode root = new LeetcodeStructure.ListNode(0);
		root.next=head;
		LeetcodeStructure.ListNode cur = root;
		while (true){
			LeetcodeStructure.ListNode temp = cur;
			int templen=0;
			while (temp.next!=null&& templen<k){
				temp=temp.next;
				templen++;
			}
			if (templen<k)
				return root.next;
			LeetcodeStructure.ListNode[]slice = devideAndConquer(cur,temp.next);
			cur.next = slice[0];
			cur = slice[1];
		}
	}
	public LeetcodeStructure.ListNode[] devideAndConquer(LeetcodeStructure.ListNode head, LeetcodeStructure.ListNode tail){
//		if (head.next==tail||head.next.next==tail)
		if (head.next.next==tail)
			return new LeetcodeStructure.ListNode[] {head.next,head.next};
		LeetcodeStructure.ListNode fast=head;
		LeetcodeStructure.ListNode slow=head;
		while (fast.next!=tail&& fast.next.next!=tail){
			fast=fast.next.next;
			slow = slow.next;
		}
		// 这时，前半段头部为 head.next ，尾部为 slow
		// 后半段头部为 slow.next ，尾部为 fast
		LeetcodeStructure.ListNode[]right = devideAndConquer(slow,tail);
		LeetcodeStructure.ListNode[]left = devideAndConquer(head,slow.next);
		head.next = right[0];
		right[1].next = left[0];
		left[1].next = tail;
		return new LeetcodeStructure.ListNode[]{right[0],left[1]};
	}


	// ---------------------------------------------------------------------------
	public LeetcodeStructure.ListNode reverseKGroup(LeetcodeStructure.ListNode head, int k) {
		LeetcodeStructure.ListNode root = new LeetcodeStructure.ListNode(0);
		root.next=head;
		LeetcodeStructure.ListNode cur = root;
		while (true){
			// 判断剩下的链表是否还能组成一个长度为 K 的子段
			LeetcodeStructure.ListNode temp = cur.next;
			int templen=0;
			while (temp!=null&& templen<k){
				temp=temp.next;
				templen++;
			}
			//System.out.println(templen);
			if (templen<k)
				return root.next;
			for (int i=0;i<k-1;i++){
				temp=cur;
				for (int j=1;j<k-i;j++){
					swap(temp.next,temp.next.next,temp);
					temp=temp.next;
				}
			}
			for (int i=0;i<k;i++)
				cur=cur.next;
		}
	}
	public void swap(LeetcodeStructure.ListNode p, LeetcodeStructure.ListNode q, LeetcodeStructure.ListNode start){
		p.next=q.next;
		q.next=p;
		start.next=q;
	}
	public void prt(ListNode root){
		while (root!=null){
			System.out.print(root.val+"->");
			root= root.next;
		}
	}
}
public class Leetcode25 {
	public static void main(String []args){
		LeetcodeStructure.ListNode node1= new LeetcodeStructure.ListNode(1);
		LeetcodeStructure.ListNode node2= new LeetcodeStructure.ListNode(2);
		LeetcodeStructure.ListNode node3= new LeetcodeStructure.ListNode(3);
		LeetcodeStructure.ListNode node4= new LeetcodeStructure.ListNode(4);
		LeetcodeStructure.ListNode node5= new LeetcodeStructure.ListNode(5);
		LeetcodeStructure.ListNode node6= new LeetcodeStructure.ListNode(6);
		LeetcodeStructure.ListNode node7= new LeetcodeStructure.ListNode(7);
		LeetcodeStructure.ListNode node8= new LeetcodeStructure.ListNode(8);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		//node8.next = node2;
		Solution25 sol = new Solution25();
		LeetcodeStructure.ListNode start=sol.reverseKGroup2(node1,5);
		sol.prt(start);
	}
}