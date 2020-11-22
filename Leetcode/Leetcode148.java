package Leetcode;

import LeetcodeStructure.ListNode;

class Solution148 {
	class Solution {
		public LeetcodeStructure.ListNode sortList1(LeetcodeStructure.ListNode head) {
			if (head == null) {
				return head;
			}
			// 确定链表长度
			int length = 0;
			LeetcodeStructure.ListNode node = head;
			while (node != null) {
				length++;
				node = node.next;
			}

			// dummyhead作为head节点的前一个节点，不变，用来做返回值
			LeetcodeStructure.ListNode dummyHead = new LeetcodeStructure.ListNode(0, head);

			// sublength 指的是待排序的子段的长度
			for (int subLength = 1; subLength < length; subLength*=2 ) {

				// prev 表示当前正在排序的两段链表的前面一个节点
				// curr表示当前正在排序的链表的第一个节点
				LeetcodeStructure.ListNode prev = dummyHead, curr = dummyHead.next;
				while (curr != null) {
					// 按长度找出第一段，用 head1 指向头部
					LeetcodeStructure.ListNode head1 = curr;
					for (int i = 1; i < subLength && curr.next != null; i++) {
						curr = curr.next;
					}
					// 把第1段的尾部分割
					LeetcodeStructure.ListNode head2 = curr.next;
					curr.next = null;
					curr = head2;

					// 按长度找出第二段，用 head2 指向头部
					for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
						curr = curr.next;
					}

					// 用 next 指向接下来待排序的链表子段的头部
					// 并且对第2段的尾部做分割
					LeetcodeStructure.ListNode next = null;
					if (curr != null) {
						next = curr.next;
						curr.next = null;
					}

					// 排序
					LeetcodeStructure.ListNode merged = merge(head1, head2);

					// 把 merged重新连到正确的位置
					prev.next = merged;
					// 因为被排序的链表已经断开了，所以一直往后走，走到尽头就是已排序链表段的尽头
					// 也就是下一个被排序链表段要连接的位置
					while (prev.next != null) {
						prev = prev.next;
					}
					// curr指向next，也就是下一段待排序链表的开头，一边一会重复流程
					curr = next;
				}
			}
			return dummyHead.next;
		}

		public LeetcodeStructure.ListNode merge(LeetcodeStructure.ListNode head1, LeetcodeStructure.ListNode head2) {
			LeetcodeStructure.ListNode dummyHead = new LeetcodeStructure.ListNode(0);
			LeetcodeStructure.ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
			while (temp1 != null && temp2 != null) {
				if (temp1.val <= temp2.val) {
					temp.next = temp1;
					temp1 = temp1.next;
				} else {
					temp.next = temp2;
					temp2 = temp2.next;
				}
				temp = temp.next;
			}
			if (temp1 != null) {
				temp.next = temp1;
			} else if (temp2 != null) {
				temp.next = temp2;
			}
			return dummyHead.next;
		}
	}



	public LeetcodeStructure.ListNode sortList(LeetcodeStructure.ListNode head) {
		//prt(head);
		// 先用快慢指针把链表分成两部分，不断划分，直到不能划分，然后归并
		// 怎么截断链表是个问题

		// 边界条件
		if (head.next == null)
			return head;

		LeetcodeStructure.ListNode index1,index2;
		index1=head;
		index2=head;
		while (index2.next!=null && index2.next.next!=null){
			index1 = index1.next;
			index2 = index2.next.next;
		}
		// 断开
		LeetcodeStructure.ListNode temp = index1;
		index1 = index1.next;
		temp.next  =null;

		// 分
		head = sortList(head);
		//prt(head);
		index1 = sortList(index1);
		//prt(index1);

		// 治
		LeetcodeStructure.ListNode ret=new LeetcodeStructure.ListNode(0);
		index2 = ret;
		while (head!=null && index1!=null){
			//System.out.println(head.val+" "+index1.val);
			if (head.val <= index1.val){
				ret.next = head;
				ret = ret.next;
				head = head.next;
			}
			else {
				ret.next = index1;
				ret = ret.next;
				index1 = index1.next;
			}
		}
		if (head != null){
			ret.next = head;
		}
		else {
			ret.next = index1;
		}
		//prt(index2.next);
		return index2.next;
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
public class Leetcode148 {
	public static void main(String []args){
		LeetcodeStructure.ListNode node1 = new LeetcodeStructure.ListNode(4);
		LeetcodeStructure.ListNode node2 = new LeetcodeStructure.ListNode(2);
		LeetcodeStructure.ListNode node3 = new LeetcodeStructure.ListNode(1);
		LeetcodeStructure.ListNode node4 = new LeetcodeStructure.ListNode(3);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		Solution148 sol = new Solution148();
		sol.prt(sol.sortList(node1));
	}
}
