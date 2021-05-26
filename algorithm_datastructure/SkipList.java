package algorithm_datastructure;

import java.util.Random;

class Node{
	int val;
	Node left;
	Node right;
	Node up;
	Node down;

	public Node(int val) {
		this.val = val;
	}

	@Override
	public String toString() {
		return "Node{ " +
				"val = " + val +
				" }";
	}
}

public class SkipList {
	private static final double PROMOTE_RATE = 0.5;
	private Node head;
	private Node tail;
	private int maxLevel;

	public SkipList(){
		head = new Node(Integer.MIN_VALUE);
		tail = new Node(Integer.MAX_VALUE);
		head.right = tail;
		tail.left = head;
	}

	// 找到目标节点
	public Node search(int data) {
		Node node = findPreNode(data);
		if (node.val == data){
			return node;
		}
		else {
			return null;
		}
	}

	// 找到小于等于目标数据的最接近的节点
	// 且找到的会是同一节点里最底层的那个
	private Node findPreNode(int data){
		Node node = head;
		while (true){
			while (node.right.val != Integer.MAX_VALUE && node.right.val <= data){
				node = node.right;
			}
			if (node.down == null){
				break;
			}
			node = node.down;
		}
		return node;
	}

	public void insert(int data){
		Node preNode = findPreNode(data);
		if (preNode.val == data){
			return;
		}

		Node node = new Node(data);
		appendNode(preNode, node);

		int currentLevel = 0;
		Random random = new Random();
		// 循环判断是否要向上晋升
		while (random.nextDouble() < PROMOTE_RATE){
			// 进入循环说明要晋升
			// 如果当前层已经是最高层，而节点还要晋升，则创建新一层作为最高层
			if (currentLevel == maxLevel){
				addLevel();
			}
			// 寻找上一层的位于当前节点左侧的节点
			// 就算所有节点都没有晋升的上一层，至少最左侧的边界节点有上层节点
			while (preNode.up == null){
				preNode = preNode.left;
			}
			preNode = preNode.up;
			// 把晋升节点插入到上一层
			Node upNode = new Node(data);
			appendNode(preNode, upNode);
			// 组织好上下层的引用关系
			upNode.down = node;
			node.up = upNode;
			// 把节点引用指向上一层，目光也从这一次切换到上一层
			node = upNode;
			currentLevel++;
		}
	}

	public void appendNode(Node pre, Node cur){
		cur.left = pre;
		cur.right = pre.right;
		pre.right.left = cur;
		pre.right = cur;
	}

	// 创建一个空的最高层
	public void addLevel(){
		maxLevel++;

		Node p1 = new Node(Integer.MIN_VALUE);
		Node p2 = new Node(Integer.MAX_VALUE);

		p1.right = p2;
		p2.left = p1;

		p1.down = head;
		head.up = p1;

		p2.down = tail;
		tail.up = p2;

		head = p1;
		tail = p2;
	}

	public boolean removeNode(int data){
		Node node = search(data);
		if (node == null){
			return false;
		}
		int currentLevel = 0;
		while (node != null){
			node.left.right = node.right;
			node.right.left = node.left;
			// 如果当前层不是最底层，且除了被删除节点外只有左右两个边界节点，则删除整个层
			if (currentLevel != 0 && node.left.val == Integer.MIN_VALUE && node.right.val == Integer.MAX_VALUE){
				removeLevel(node.left);
			}
			// 否则，移到上一层继续删除
			else {
				currentLevel++;
			}
			node = node.up;
		}
		return true;
	}

	public void removeLevel(Node leftNode){
		Node rightNode = leftNode.right;
		// 如果被删除层是最高的一层
		if (leftNode.up == null){
			leftNode.down.up = null;
			rightNode.down.up = null;

			head = leftNode.down;
			tail = rightNode.down;
		}
		// 如果不是
		else {
			leftNode.down.up = leftNode.up;
			leftNode.up.down = leftNode.down;

			rightNode.down.up = rightNode.up;
			rightNode.up.down = rightNode.down;
		}
		maxLevel--;
	}

	// 输出调表最底层的数据
	public void printList(){
		Node node = head;
		while (node.down != null){
			node = node.down;
		}
		while (node.right.val != Integer.MAX_VALUE){
			System.out.print(node.right.val+" ");
			node = node.right;
		}
		System.out.println();
	}


	public static void main(String[] args) {
		SkipList list=new SkipList();
		list.insert(50);

		list.insert(15);
		list.insert(13);
		list.printList();
		list.insert(20);
		list.insert(100);
		list.insert(75);
		list.printList();
		list.insert(99);
		list.insert(76);
		list.insert(83);
		list.printList();
		list.insert(65);
		list.printList();
		System.out.println(list.search(50));
		list.removeNode(50);
		list.printList();
		System.out.println(list.search(50));
	}
}
