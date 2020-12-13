package Leetcode;

import java.util.*;
import LeetcodeStructure.*;
import LeetcodeStructure.ListNode;

class Solution24 {
	public LeetcodeStructure.ListNode swapPairs(LeetcodeStructure.ListNode head) {
		LeetcodeStructure.ListNode newnode = new LeetcodeStructure.ListNode(0);
		newnode.next = head;
		swap(newnode);
		return newnode.next;
	}
	public void swap(LeetcodeStructure.ListNode root){
		if (root.next==null || root.next.next==null)
			return;
		LeetcodeStructure.ListNode one = root.next;
		LeetcodeStructure.ListNode two = one.next;
		ListNode three = two.next;
		two.next = one;
		one.next = three;
		root.next = two;
		swap(one);
	}
}
public class Leetcode24 {
}
