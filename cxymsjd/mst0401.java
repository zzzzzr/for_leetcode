package cxymsjd;

import java.util.*;
class Solution0401 {
	public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
		Map<Integer, Set<Integer>> positive = new HashMap<>();
		for (int[]path:graph){
			Set<Integer> temp = positive.computeIfAbsent(path[0], k -> new HashSet<>());
			temp.add(path[1]);

		}
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		Set<Integer> visited = new HashSet<>();
		visited.add(start);
		while (!queue.isEmpty()){
			int cur = queue.poll();
			Set<Integer> tempList = positive.get(cur);
			if (tempList == null){
				continue;
			}
			for (int i:tempList){
				if (!visited.contains(i)){
					if (i == target){
						return true;
					}
					queue.add(i);
					visited.add(i);
				}
			}
		}
		return false;
	}
}
public class mst0401 {
	public static void main(String[] args) {
		Solution0401 sol = new Solution0401();
		// 3
		//[[0, 1], [0, 2], [1, 2], [1, 2]]
		//0
		//2
		int n = 3;
		int [][]graph = {
				{0, 1},
				{0, 2},
				{1, 2},
				{1, 2}
		};
		int start = 0;
		int target = 2;
		System.out.println(sol.findWhetherExistsPath(n, graph, start, target));
	}
}
