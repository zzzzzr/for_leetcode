package Leetcode;

import LeetcodeStructure.ListNode;

class Solution147 {
	public LeetcodeStructure.ListNode insertionSortList(LeetcodeStructure.ListNode head) {
		if (head==null || head.next ==null)
			return head;

		LeetcodeStructure.ListNode start = new LeetcodeStructure.ListNode(0);
		start.next =head;

		LeetcodeStructure.ListNode index = head.next;
		LeetcodeStructure.ListNode pre = head;

		while (index!=null){
			if(index.val>= pre.val){
				pre = pre.next;
			}
			else {
				pre.next  =index.next;
				LeetcodeStructure.ListNode find = start;
				while (find.next.val <= index.val){
					find = find.next;
				}
				index.next = find.next;
				find.next = index;
			}
			index = pre.next;
		}
		return start.next;
	}

	public void prt(ListNode root){
		while (root!=null){
			System.out.print(root.val);
			System.out.print(" ");
			root = root.next;
		}
		System.out.println();
	}
}
public class Leetcode147 {
	public static void main(String []args) {
		// -1->5->3->4->0
		LeetcodeStructure.ListNode node1 = new LeetcodeStructure.ListNode(3);
		LeetcodeStructure.ListNode node2 = new LeetcodeStructure.ListNode(2);
		LeetcodeStructure.ListNode node3 = new LeetcodeStructure.ListNode(4);
//		ListNode node4 = new ListNode(4);
//		ListNode node5 = new ListNode(1);
		node1.next = node2;
		node2.next = node3;
//		node3.next = node4;
//		node4.next = node5;
		Solution147 sol = new Solution147();
		sol.prt(sol.insertionSortList(node1));
	}
}
