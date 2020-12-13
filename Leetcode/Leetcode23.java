package Leetcode;

import java.util.*;
import LeetcodeStructure.*;
import LeetcodeStructure.ListNode;

class Solution23 {
	public LeetcodeStructure.ListNode mergeKLists3(LeetcodeStructure.ListNode[] lists) {
		return devideAndConquer(lists,0, lists.length-1);
	}
	public LeetcodeStructure.ListNode devideAndConquer(LeetcodeStructure.ListNode[]lists, int left, int right){
		if (left==right)
			return lists[left];
		if (left>right)
			return null;
		int mid = (left+right)/2;
		return merge(devideAndConquer(lists, left, mid),devideAndConquer(lists, mid+1, right));
	}

	public LeetcodeStructure.ListNode mergeKLists2(LeetcodeStructure.ListNode[] lists) {
		LeetcodeStructure.ListNode ans = null;
		for (LeetcodeStructure.ListNode node:lists)
			ans = merge(ans,node);
		return ans;
	}
	public LeetcodeStructure.ListNode merge(LeetcodeStructure.ListNode head1, LeetcodeStructure.ListNode head2){
		if (head1==null)
			return head2;
		if (head2==null)
			return head1;
		LeetcodeStructure.ListNode head = new LeetcodeStructure.ListNode(0);
		LeetcodeStructure.ListNode temp = head;
		while (head1!=null && head2!=null){
			if (head1.val<head2.val){
				temp .next=head1;
				temp = temp.next;
				head1 = head1.next;
			}
			else {
				temp .next=head2;
				temp = temp.next;
				head2 = head2.next;
			}
		}
		if (head1!=null)
			temp.next=head1;
		if (head2!=null)
			temp.next = head2;
		return head.next;
	}

	public LeetcodeStructure.ListNode mergeKLists1(LeetcodeStructure.ListNode[] lists) {
		int len=0;
		for (LeetcodeStructure.ListNode node:lists){
			while (node!=null){
				len++;
				node = node.next;
			}
		}
		if (len==0)
			return null;
		LeetcodeStructure.ListNode[]list = new LeetcodeStructure.ListNode[len];
		int index=0;
		for (LeetcodeStructure.ListNode node:lists){
			while (node!=null){
				list[index]=node;
				index++;
				node = node.next;
			}
		}
		Arrays.sort(list, new Comparator<LeetcodeStructure.ListNode>() {
			@Override
			public int compare(LeetcodeStructure.ListNode o1, LeetcodeStructure.ListNode o2) {
				return o1.val-o2.val;
			}
		});
		int i;
		for (i=0;i< list.length-1;i++)
			list[i].next=list[i+1];
		list[i].next=null;
		return list[0];
	}

	public LeetcodeStructure.ListNode mergeKLists(LeetcodeStructure.ListNode[] lists) {
		LeetcodeStructure.ListNode head=new LeetcodeStructure.ListNode(0);
		ListNode temp = head;
		int index=0;
		while (true) {
			int min=Integer.MAX_VALUE;
			for (int i = 0; i < lists.length; i++) {
				if (lists[i] != null && lists[i].val < min) {
					index = i;
					min=lists[i].val;
				}
			}
			if(min==Integer.MAX_VALUE)
				break;

			temp.next=lists[index];
			temp = temp.next;
			lists[index] = lists[index].next;

		}
		return head.next;
	}
}
public class Leetcode23 {
}