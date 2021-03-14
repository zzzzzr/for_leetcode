package xiaozhaozhenti;

import java.util.*;
class Solution_mt4{
	class Node{
		int val;
		int index;
		Node left;
		Node right;
	}
	int maxvalue;
	int minweight;
	public void maxmin(){
		Scanner sc = new Scanner(System.in);
		int nodenum = sc.nextInt();
		int edgenum = sc.nextInt();
		int []weight = new int[nodenum];
		for (int i=0;i<nodenum;i++){
			weight[i] = sc.nextInt();
		}
		Node []nodes = new Node[nodenum];
		for (int i=0;i<nodenum;i++){
			nodes[i] = new Node();
			nodes[i].val = weight[i];
			nodes[i].index = i;
		}
		for (int i=0;i<edgenum;i++){
			int father = sc.nextInt();
			int son = sc.nextInt();
			if (father>son){
				int temp=father;
				father=son;
				son=temp;
			}
			if (nodes[father].left==null){
				nodes[father].left = nodes[son];
			}
			else {
				nodes[father].right = nodes[son];
			}
		}
		// 树已经搭建完毕
	}
	public void dfs(List<Integer>lis, Node node, int mode){
		if (mode==0){
			;
		}
		else {
			;
		}
	}
}
public class MST_MT_4 {
}
