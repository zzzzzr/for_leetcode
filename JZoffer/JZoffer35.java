package JZoffer;
import java.util.*;

class Node {
	int val;
	Node next;
	Node random;

	public Node(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}
}
/*
用一个哈希表，表示原节点和复制节点的映射
先用next序走一遍，只设置next值，并把复制的节点加入哈希表中
再走第二遍，设置random值，此时用到哈希表中存储的节点
 */
class SolutionJZoffer35 {
	public Node copyRandomList(Node head) {
		if (head==null)
			return null;
		Node head1 = head;  //指向旧头结点
		HashMap<Node,Node> map = new HashMap<>();
		while(head!=null){
			map.put(head,new Node(head.val));
			head=head.next;
		}
		// 把所有复制节点按next序链接起来
		head=head1;
		while(head!=null){
			map.get(head).next=map.get(head.next);
			head=head.next;
		}
		// 给所有复制节点的random值赋值
		head=head1;
		while(head!=null){
			map.get(head).random = map.get(head.random);
			head=head.next;
		}
		return map.get(head1);
	}
}
public class JZoffer35 {
	public static void main(String []args){
		Node node1=new Node(1);
		Node node2=new Node(3);
		Node node3=new Node(5);
		Node node4=new Node(7);
		Node node5=new Node(9);

		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;

		node1.random=node3;
		node2.random=node1;
		node4.random=node2;
		node5.random=node1;

		SolutionJZoffer35 sol = new SolutionJZoffer35();
		Node ans = sol.copyRandomList(node1);
		while(ans!=null){
			System.out.print(" "+ans.val+" ");
			if(ans.random!=null)
				System.out.print(ans.random.val);
			System.out.println();
			ans=ans.next;
		}

	}
}
