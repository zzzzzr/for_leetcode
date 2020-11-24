package Leetcode;

import LeetcodeStructure.*;
import LeetcodeStructure.ListNode;

class Solution142 {
	public LeetcodeStructure.ListNode detectCycle(LeetcodeStructure.ListNode head) {
		if(head==null || head.next==null)
			return null;
		boolean loopExist=false;
		LeetcodeStructure.ListNode slow=head;
		ListNode fast=head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				loopExist = true;
				break;
			}
		}
		if (!loopExist)
			return null;
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
}
public class Leetcode142 {
}
