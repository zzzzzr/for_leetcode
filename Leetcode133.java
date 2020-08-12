import java.util.*;
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
class Solution133 {
	static class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {
			val = 0;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val) {
			val = _val;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val, ArrayList<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}

	Map<Node,Node> map= new HashMap<>();
	public Node cloneGraph(Node node) {
		if(node==null)
			return null;
		if(map.containsKey(node))
			return map.get(node);
		Node root=new Node(node.val,new ArrayList<Node>());
		map.put(node,root);
		for(Node child: node.neighbors){
			root.neighbors.add(cloneGraph(child));
		}
		return root;
	}
	/*
	用指针的观点看待题解：
	函数的目的是克隆某节点以及其所在的整个图

	如果克隆的节点为空，返回
	如果当前节点已经复制过
		返回hash表中其对应的复制节点的引用
	否则
		为当前节点建立复制节点，并在hash表中记录
		然后复制当前节点的邻居并将它们加入到复制节点的邻居链表中来
		（将邻居链表分别指向当前节点的邻居）

	题解中一个节点可以是不完全复制的，但要先把复制的引用放到hash表里供其他节点检索
	这样其他节点可以把邻居链表指过来，则图的结构可以保证
	然后随着for循环的遍历，邻居链表终究会被完全复制
	 */


}
public class Leetcode133 {
	public static void main(String []args){
		Solution133.Node node1=new Solution133.Node(1),
				node2=new Solution133.Node(2),
				node3=new Solution133.Node(3),
				node4=new Solution133.Node(4),
				node5=new Solution133.Node(5);
		node1.neighbors.add(node2);
		node1.neighbors.add(node4);
		node1.neighbors.add(node5);

		node2.neighbors.add(node1);
		node2.neighbors.add(node3);

		node3.neighbors.add(node2);
		node3.neighbors.add(node4);

		node4.neighbors.add(node1);
		node4.neighbors.add(node3);

		node5.neighbors.add(node1);

		Solution133 sol = new Solution133();
		Solution133.Node ans=sol.cloneGraph(node1);

	}
}
