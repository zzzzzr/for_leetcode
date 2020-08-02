
class Solution21 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode start=new ListNode(0),ln=start;
		while(l1!=null&&l2!=null){
			if(l1.val<= l2.val){
				ln.next=l1;
				ln=ln.next;
				l1=l1.next;
			}
			else{
				ln.next=l2;
				ln=ln.next;
				l2=l2.next;
			}
		}
		if(l2==null){
			ln.next=l1;
		}
		else {
			ln.next=l2;
		}
		return start.next;
	}
}
public class Leetcode21 {
}
