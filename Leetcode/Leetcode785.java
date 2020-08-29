package Leetcode;

import java.util.*;
class Solution785 {
	/* 从某个节点开始，将该节点染为一个颜色，并将与其相邻的节点染成另一个颜色
	 * 然后再将相邻节点的相邻节点然而一个颜色，不断交替染色
	 * 直到所有点都被染色，则染成一个颜色的点为一组，所有点可以二分
	 * 反之，若某个点被染过一个颜色后又要被染成另一个颜色，则说明发生冲突，所有点不能被二分
	 * */
	public boolean isBipartite(int[][] graph) {
		final int uncolored=0;
		final int green=2;
		final int red=1;
		int[]color;
		//color用于保存每个节点被染的颜色，初始时所有节点都为未染色
		color=new int[graph.length];
		Arrays.fill(color,uncolored);

		for(int i=0;i<graph.length;i++){
			if(color[i]==uncolored){
				Queue<Integer> queue=new LinkedList<>();
				queue.offer(i);
				color[i]=red;

				while(!queue.isEmpty()){
					int node=queue.poll();
					int neibor=(color[node]==red?green:red);

					for(int j:graph[node]) {
						if (color[j] == uncolored) {
							queue.offer(j);
							color[j] = neibor;
						} else if (color[j] != neibor) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}
}

public class Leetcode785 {
	public static void main(String []args){
		int [][]test=new int[][]{{1,2,3}, {0,2}, {0,1,3}, {0,2}};
		//{{1,3}, {0,2}, {1,3}, {0,2}}
		//{{1,2,3}, {0,2}, {0,1,3}, {0,2}}
		Solution785 tes=new Solution785();
		System.out.println(tes.isBipartite(test));
	}
}
