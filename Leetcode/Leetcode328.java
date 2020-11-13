package Leetcode;

import LeetcodeStructure.ListNode;

/*
执行结果：通过 显示详情
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：38.2 MB, 在所有 Java 提交中击败了83.47%的用户
 */
class Solution328 {
	public LeetcodeStructure.ListNode oddEvenList(LeetcodeStructure.ListNode head) {
		if (head == null || head.next == null)
			return head;
		LeetcodeStructure.ListNode odd = head;
		LeetcodeStructure.ListNode evenhead = head.next;
		LeetcodeStructure.ListNode eventail = head.next;
		int index=2;
		LeetcodeStructure.ListNode cur=head.next;
		LeetcodeStructure.ListNode next = cur.next;
		while(next!=null){
			cur = next;
			next = next.next;
			index++;
			if (index%2==1){
				odd.next = cur;
				odd = cur;
				odd.next = evenhead;
				eventail.next=null;
			}
			else{
				eventail.next = cur;
				eventail = cur;
			}
//			print(head);
		}
//		System.out.println(index);
		return head;
	}
	public void print(ListNode head){
		if (head == null)
			return;
		while(head.next!=null){
			System.out.print(head.val);
			System.out.print(" ");
			head = head.next;
		}
		System.out.println(head.val);
	}
}
public class Leetcode328 {
	public static void main(String []args){
		LeetcodeStructure.ListNode node1 = new LeetcodeStructure.ListNode(1);
		LeetcodeStructure.ListNode node2 = new LeetcodeStructure.ListNode(2);
		LeetcodeStructure.ListNode node3 = new LeetcodeStructure.ListNode(3);
		LeetcodeStructure.ListNode node4 = new LeetcodeStructure.ListNode(4);
		LeetcodeStructure.ListNode node5 = new LeetcodeStructure.ListNode(5);
		LeetcodeStructure.ListNode node6 = new LeetcodeStructure.ListNode(6);
		LeetcodeStructure.ListNode node7 = new LeetcodeStructure.ListNode(7);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;

		Solution328 sol = new Solution328();
//		System.out.println(sol.oddEvenList(node1).val);
//		System.out.println(sol.oddEvenList(node1).next.val);
		sol.print(sol.oddEvenList(node1));
	}
}
