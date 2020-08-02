package JZoffer;
class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
}
class SolutionJZoffer06 {
	public int[] reversePrint(ListNode head) {
		int len=0;
		ListNode ln=head;
		while(ln!=null){
			len++;
			ln=ln.next;
		}
		int []reverse= new int[len];
		ln=head;
		while (ln!=null){
			reverse[len-1]= ln.val;
			ln=ln.next;
			len--;
		}
		return reverse;
	}
}
public class JZoffer06 {
}
