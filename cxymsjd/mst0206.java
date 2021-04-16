package cxymsjd;

import LeetcodeStructure.ListNode;
import java.util.*;

class Solution0206 {
	ListNode frontnode;
	public boolean isPalindrome(ListNode head) {
		frontnode = head;
		return recursive(head);
	}
	public boolean recursive(ListNode node){
		if (node!=null) {
			if (!recursive(node.next))
				return false;
			if (node.val != frontnode.val)
				return false;
			frontnode = frontnode.next;
		}
		return true;
	}

	public boolean isPalindrome2(ListNode head) {
		if (head==null){
			return true;
		}
		ListNode slow = head,fast = head;
		while (fast.next!=null && fast.next.next!=null){
			fast = fast.next.next;
			slow = slow.next;
		}

		ListNode cur = slow.next;
		slow.next = null;

		ListNode pre = null;
		ListNode nxt = cur.next;
		while (nxt!=null){
			cur.next = pre;
			pre = cur;

			cur = nxt;
			nxt=nxt.next;
		}
		cur.next = pre;

		ListNode start = head,end=cur;
		while (start!=null && end!=null){
			if (start.val!= end.val){
				return false;
			}
			start = start.next;
			end = end.next;
		}
		return true;
	}

	public boolean isPalindrome1(ListNode head) {
		Deque<Integer> sta = new LinkedList<>();
		while(head!=null){
			sta.push(head.val);
			head = head.next;
		}
		while(sta.size()>1){
			int front = sta.pollFirst();
			int end = sta.pollLast();
			if(front!=end){
				return false;
			}
		}
		return true;
	}
}
public class mst0206 {
}
