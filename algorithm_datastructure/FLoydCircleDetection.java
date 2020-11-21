package algorithm_datastructure;

import LeetcodeStructure.*;
// 用来判断一个链表有没有环，也可以稍作修改，用来判断一个数组是否成环
public class FLoydCircleDetection {
	boolean loopExist=false;
	ListNode slow;
	ListNode fast;

	public ListNode findLoopBegin(ListNode head){
		slow = head;
		fast = head;
		while (slow.next!=null && fast.next.next!=null){
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast){
				loopExist = true;
				break;
			}
		}
		if (loopExist) {
			slow = head;
			while (slow != fast) {
				slow = slow.next;
				fast = fast.next;
			}
			return slow;
		}
		return null;
	}

}
