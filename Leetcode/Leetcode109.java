package Leetcode;

import java.util.*;
/*
找出链表中位数节点的方法多种多样，其中较为简单的一种是「快慢指针法」。初始时，快指针 \textit{fast}fast 和慢指针 \textit{slow}slow
均指向链表的左端点 \textit{left}left。我们将快指针 \textit{fast}fast 向右移动两次的同时，将慢指针 \textit{slow}slow 向右移动一次，
直到快指针到达边界（即快指针到达右端点或快指针的下一个节点是右端点）。此时，慢指针对应的元素就是中位数。


 */

class Solution109 {

	public TreeNode sortedListToBST1(ListNode head) {
		return buildBST(head,null);
	}
	public TreeNode buildBST(ListNode start,ListNode end){
		if(start==end)
			return null;
		ListNode mid = find_mid(start,end);
		TreeNode middle = new TreeNode(mid.val);
		middle.left = buildBST(start,mid);
		middle.right = buildBST(mid.next,end);
		return middle;
	}
	public ListNode find_mid(ListNode start,ListNode end){
		ListNode fast = start,slow = start;
		while(fast!=end&&fast.next!=end){
			fast=fast.next;
			fast=fast.next;
			slow=slow.next;
		}
		return slow;
	}


	// o.g.solution
	public TreeNode sortedListToBST(ListNode head) {
		if(head==null)
			return null;
		List<Integer> list = new LinkedList<>();
		while(head!=null){
			list.add(head.val);
			head=head.next;
		}
		int []nums = new int[list.size()];
		for(int i=0;i< list.size();i++){
			nums[i] = list.get(i);
		}
		return creatBST(nums,0, list.size()-1);
	}

	public TreeNode creatBST(int []nums,int start,int end){
		if(start>end||start<0||end>= nums.length)
			return null;
		int mid = (start+end+1)/2;
		TreeNode middle = new TreeNode(nums[mid]);
		middle.left = creatBST(nums,start,mid-1);
		middle.right = creatBST(nums,mid+1,end);
		return middle;
	}
}
public class Leetcode109 {
	public static void main(String []args){
		ListNode node1 = new ListNode(-10);
		ListNode node2 = new ListNode(-3);
		ListNode node3 = new ListNode(0);
		ListNode node4 = new ListNode(5);
		ListNode node5 = new ListNode(9);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		Solution109 sol = new Solution109();
		TreeNode ans = sol.sortedListToBST(node1);
		System.out.println(ans.val);
		System.out.println(ans.left.val);
		System.out.println(ans.right.val);
		System.out.println(ans.left.left.val);
		System.out.println(ans.left.right.val);
		System.out.println(ans.right.left.val);
		System.out.println(ans.right.right.val);
	}
}
