package Leetcode;

import java.util.*;

import LeetcodeStructure.ListNode;

class Solution92 {
	public LeetcodeStructure.ListNode reverseBetween(LeetcodeStructure.ListNode head, int left, int right) {
		LeetcodeStructure.ListNode dummy = new LeetcodeStructure.ListNode(-1,head);
		LeetcodeStructure.ListNode temp = dummy;
		for (int i=1;i<left;i++){
			temp = temp.next;
		}
		// temp 在的位置即为 被反转链表左侧链表的最右节点
		LeetcodeStructure.ListNode nodefinal = temp.next;
		head = null;
		LeetcodeStructure.ListNode cur=null;
		LeetcodeStructure.ListNode nxt = temp.next;
		for (int i=0;i<=right-left;i++){
			cur = nxt;
			nxt = cur.next;

			cur.next = head;
			head = cur;
		}
		temp.next = cur;
		nodefinal.next = nxt;
		return dummy.next;
	}
	public void prt(ListNode node){
		while (node!=null){
			System.out.print(node.val+" ");
			node = node.next;
		}
	}
}
public class Leetcode92 {
	public static void main(String []args){
		Solution92 sol = new Solution92();
		LeetcodeStructure.ListNode node5 = new LeetcodeStructure.ListNode(5);
		LeetcodeStructure.ListNode node4 = new LeetcodeStructure.ListNode(4,node5);
		LeetcodeStructure.ListNode node3 = new LeetcodeStructure.ListNode(3,node4);
		LeetcodeStructure.ListNode node2 = new LeetcodeStructure.ListNode(2,node3);
		LeetcodeStructure.ListNode node1 = new LeetcodeStructure.ListNode(1,node2);
		sol.prt(sol.reverseBetween(node1,2,4));
		List<Integer> lis = new LinkedList<>();
		Iterator<Integer> ite = lis.listIterator();
	}
}
