package Leetcode;

import java.util.*;
class Solution841 {
	int[]father;
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		if (rooms.size()<=1)
			return true;
//		father= new int[rooms.size()];
//		for (int i=0;i< rooms.size();i++)
//		 	father[i] = i;

		Queue<Integer> queue = new LinkedList<>();
		queue.offer(0);
		Set<Integer> seett = new HashSet<>();
		seett.add(0);

		while (!queue.isEmpty()){
			int temp = queue.poll();
			for (int i:rooms.get(temp)){
				if (!seett.contains(i)){
					seett.add(i);
					queue.offer(i);
				}
			}
		}

		return seett.size()==rooms.size();
	}

	public boolean canVisitAllRooms1(List<List<Integer>> rooms) {
		if (rooms.size()<=1)
			return true;

		boolean []vis = new boolean[rooms.size()];
		vis[0] = true;
		int visited = rooms.size()-1;

		Queue<Integer> que = new LinkedList<>();
		que.offer(0);

		while (!que.isEmpty()){
			int temp = que.poll();
			for (int i:rooms.get(temp)){
				if (!vis[i]){
					que.offer(i);
					vis[i]=true;
					visited--;
				}
			}
		}

		return visited==0;
	}

	int visited;
	public boolean canVisitAllRooms2(List<List<Integer>> rooms) {
		if (rooms.size()<=1)
			return true;
		boolean []vis = new boolean[rooms.size()];
		vis[0] = true;
		visited = rooms.size()-1;
		dfs(rooms,vis,0);
		return visited==0;
	}
	public void dfs(List<List<Integer>>rooms,boolean[]vis,int i){
		for (int j:rooms.get(i)){
			if (!vis[j]){
				visited--;
				vis[j]=true;
				dfs(rooms, vis, j);
			}
		}
	}

}
public class Leetcode841 {
	public static void main(String []args){
		List<List<Integer>> lis = new LinkedList<>();
		List<Integer> lis1 = new LinkedList<>();
		List<Integer> lis2 = new LinkedList<>();
		List<Integer> lis3 = new LinkedList<>();
		List<Integer> lis4 = new LinkedList<>();
		lis1.add(1);
		lis1.add(3);
		lis2.add(3);
		lis2.add(1);
		lis2.add(0);
		lis3.add(2);
		lis4.add(0);
		lis.add(lis1);
		lis.add(lis2);
		lis.add(lis3);
		lis.add(lis4);

		Solution841 sol = new Solution841();
		System.out.println(sol.canVisitAllRooms2(lis));

	}
}
