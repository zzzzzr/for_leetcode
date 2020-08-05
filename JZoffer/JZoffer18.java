package JZoffer;
class SolutionJZoffer18 {
	public ListNode deleteNode(ListNode head, int val) {
		if(head.val==val)
			return head.next;
		ListNode ln1=head,ln2=head;
		ln2=ln2.next;
		while(ln2.val!=val){
			ln2=ln2.next;
			ln1=ln1.next;
		}
		ln1.next=ln2.next;
		return head;
	}
}
public class JZoffer18 {
}
