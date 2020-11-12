package Leetcode;

import java.util.*;
import LeetcodeStructure.*;
import LeetcodeStructure.ListNode;
class Solution160 {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode start1 = headA;
		ListNode start2 = headB;
		while(start1 != start2){
			if (start1!=null)
				start1=start1.next;
			else
				start1 = headB;

			if (start2!=null)
				start2=start2.next;
			else
				start2 = headA;
		}
		return start1;
	}
}
public class Leetcode160 {
}
