package JZoffer;
// 和LeetCode19题一样的题目
class SolutionJZoffer22 {
	public ListNode getKthFromEnd(ListNode head, int k) {
		ListNode ln1=head,ln2=head;
		// 先让ln2向后走k步，如果不成功则返回null
		while(k!=1){
			if(ln2==null)
				return null;
			ln2=ln2.next;
			k--;
		}
		// 如果走了n步后ln2为空，则被删除的节点就是第一个节点，则返回head.next
		if(ln2==null){
			return head;
		}
		// 现在ln1,ln2相差的距离和当ln2在最后时ln1在被删除节点前一节点的距离相同，一种保持即可
		while(ln2.next!=null){
			ln1=ln1.next;
			ln2=ln2.next;
		}
		//ln2到达最后一个节点，ln1也到达了被删除节点签名的节点，执行删除
		//ln1.next=ln1.next.next;
		return ln1;
	}
}
public class JZoffer22 {
}
