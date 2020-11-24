package Leetcode;

import LeetcodeStructure.ListNode;
class Solution141 {
	public boolean hasCycle(ListNode head) {
		if(head==null || head.next==null)
			return false;
		boolean loopExist=false;
		ListNode slow=head;
		ListNode fast=head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				loopExist = true;
				break;
			}
		}
		return loopExist;
	}
}
public class Leetcode141 {
	public static void main(String []args){

	}
}
