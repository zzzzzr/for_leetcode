package JZoffer;
import java.util.*;
class SolutionJZoffer36 {
	static class Node {
		public int val;
		public Node left;
		public Node right;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right) {
			val = _val;
			left = _left;
			right = _right;
		}
	};


	Node pre,head;
	public Node treeToDoublyList1(Node root) {
		if (root==null)
			return null;

		dfs(root);

		// 访问过所有节点，则head指向头结点，而最后访问的是最右的节点，即尾结点，此时pre指向他
		head.left=pre;
		pre.right=head;

		return head;
	}

	/*
	以中序遍历的顺序访问节点
	 */
	public void dfs(Node root){
		if (root==null)
			return;
		dfs(root.left);

		// 中序遍历的前一个节点存在，则前一个节点的右节点是当前节点
		if (pre!=null)
			pre.right = root;
		// 不存在，则当前节点是最左的节点，为头节点
		else
			head = root;

		// 无论当前节点的前一个节点是否存在，把当前节点的左节点指向他都是没问题的
		root.left = pre;

		// 已访问过当前节点，马上要访问下一个节点，则当前节点即成为下一个节点的前一个节点
		pre=root;

		dfs(root.right);
	}



	public Node treeToDoublyList(Node root) {
		if (root==null)
			return null;
		Queue<Node> que = new LinkedList<>();
		HashMap<Node,Boolean> map = new HashMap<>();

		que.offer(root);
		//map.put(root,true);
//		map.put(null,false);
		while (!que.isEmpty()){
			Node temp = que.poll();
			System.out.println(temp.val);
//			if (map.containsKey(temp))
//				continue;

			if (temp.left!=null&&!map.containsKey(temp.left)) {
				que.offer(temp.left);
				//map.put(temp.left,true);
				Node templeft = findLeftRight(temp);
				temp.left = templeft;
				templeft.right = temp;
				//map.put(templeft,true);
			}
			if (temp.right!=null&&!map.containsKey(temp.right)) {
				que.offer(temp.right);
				Node tempright = findRightLeft(temp);
				temp.right = tempright;
				tempright.left= temp;
				//map.put(tempright,true);
			}
			map.put(temp,true);
		}
		Node head = root;
		Node tail=root;
		while(head.left!=null){
			head=head.left;
		}
		while(tail.right!=null){
			tail=tail.right;
		}
		head.left=tail;
		tail.right=head;

		return head;
	}
	public Node findLeftRight(Node node){
		if(node.left==null)
			return null;
		node = node.left;
		while(node.right!=null){
			node=node.right;
		}
		return node;
	}
	public Node findRightLeft(Node node){
		if(node.right==null)
			return null;
		node = node.right;
		while(node.left!=null){
			node=node.left;
		}
		return node;
	}
}
public class JZoffer36 {
	public static void main(String []args){
		SolutionJZoffer36 sol = new SolutionJZoffer36();
		SolutionJZoffer36.Node node1 = new SolutionJZoffer36.Node(4);
		SolutionJZoffer36.Node node2 = new SolutionJZoffer36.Node(2);
		SolutionJZoffer36.Node node3 = new SolutionJZoffer36.Node(5);
		SolutionJZoffer36.Node node4 = new SolutionJZoffer36.Node(1);
		SolutionJZoffer36.Node node5 = new SolutionJZoffer36.Node(3);

		node1.left=node2;
		node1.right=node3;
		node2.left=node4;
		node2.right=node5;

		SolutionJZoffer36.Node ans = sol.treeToDoublyList(node1);
		for(int i=0;i<6;i++){
			System.out.print(" "+ans.val);
			ans=ans.right;
		}
		System.out.println();
		for(int i=0;i<6;i++){
			System.out.print(" "+ans.val);
			ans=ans.left;
		}
	}
}
