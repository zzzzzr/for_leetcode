package JZoffer;
class SolutionJZoffer24 {
	public ListNode reverseList(ListNode head) {
		//ListNode temp=null;
		return reverse(null,head);
	}
	public ListNode reverse(ListNode pre,ListNode next){
		// 当前节点为空，则到达最后一个节点，之前返回前面已完成的链表
		if(next==null)
			return pre;
		// temp指向当前节点的下一个节点
		ListNode temp=next.next;
		// 把当前节点拼到前面已完成链表的头部，完成新的反转
		next.next=pre;
		// 对新的链表和下一个节点完成反转
		return reverse(next,temp);
	}
}
public class JZoffer24 {
}
