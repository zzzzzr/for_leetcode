import java.util.*;
class Node {
	int val;
	Node left;
	Node right;
	int num;

	public Node(int val) {
		this.val = val;
	}

	public Node(int val, Node left, Node right, int num) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public Node() {
	}

	public String toString(){
		return this.val+" " ;
	}
}
class Solution_TMS{
	public List<char[]> deleteNode(Node root, int[]deletedLevel){
		// 假设数组是有序的
		int height = 0;
//		Queue<Node> queue = new LinkedList<>();
		Queue<Node> currentNodeQueue = new LinkedList<>();
		Node dummyNode = new Node();
		dummyNode.left = root;
		currentNodeQueue.add(dummyNode);

		Queue<Node> nextNodeQueue = new LinkedList<>();

		Arrays.sort(deletedLevel);
		int index = 0;

		while (!currentNodeQueue.isEmpty()) {
			height++;
			int size = currentNodeQueue.size();

			for (int i=0; i<size; i++) {

				Node temp = currentNodeQueue.poll();
//				System.out.println(temp);
				if (temp!=null){
					if(index< deletedLevel.length && deletedLevel[index]==height) {
						index++;
						if (temp.left!=null){
							if (temp.left.left!=null){
								nextNodeQueue.add(temp.left.left);
							}
							if (temp.left.right!=null){
								nextNodeQueue.add(temp.left.right);
							}

						}
						if (temp.right!=null){
							if (temp.right.left!=null){
								nextNodeQueue.add(temp.right.left);
							}
							if (temp.right.right!=null){
								nextNodeQueue.add(temp.right.right);
							}

						}
						System.out.println(height + " " + temp.num);
					}

					currentNodeQueue.add(temp.left);
					currentNodeQueue.add(temp.right);

					temp.left=null;
					temp.right = null;

				}
			}
		}

		if (deletedLevel[0]!=1){
			nextNodeQueue.add(root);
		}
		System.out.println(nextNodeQueue);

		List<char[]>ans = new LinkedList<>();
		for(Node temp : nextNodeQueue){
			ans.add(bfs(temp));
		}
		return ans;
	}
	public char[]bfs(Node node){
		List<Character> path = new LinkedList<>();
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()){
			int size = queue.size();
			for (int i=0; i<size;i++){
				Node temp = queue.poll();
//				System.out.println(temp);
				if (temp!=null){
					path.add('1');
					queue.add(temp.left);
					queue.add(temp.right);
				} else {
					path.add('#');
				}
			}
		}
		while(path.get(path.size()-1)=='#'){
			path.remove(path.size()-1);
		}
		char[]ans = new char[path.size()];
		for (int i=0; i< path.size();i++){
			ans[i] = path.get(i);
		}
		return ans;
	}
}
public class BST_Time {
	public static void main(String[] args) {
		Node node11 = new Node(1,null,null,11);
		Node node10 = new Node(1,null,null,10);
		Node node7 = new Node(1,null,node10,7);
		Node node8 = new Node(1, node11, null,8);
		Node node9 = new Node(1,null,null,9);
		Node node4 = new Node(1, node7, node8,4);
		Node node5 = new Node(1, null, node9,5);
		Node node6 = new Node(1,null,null,6);
		Node node2 = new Node(1, node4, node5,2);
		Node node3 = new Node(1, node6, null,3);
		Node node1 = new Node(1, node2, node3,1);
		Solution_TMS sol = new Solution_TMS();
		int []delete = {3};
//		System.out.println(Arrays.toString(sol.bfs(node1)));

		List<char[]>ans = sol.deleteNode(node1, delete);
		for (char[] arr : ans){
			System.out.println(Arrays.toString(arr));
		}

	}
}
