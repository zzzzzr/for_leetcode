import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
// 拓扑排序，BFS
class Solution207 {
	int []outedge;
	List<List<Integer>> edges;
	int []shunxu;                   // Leetcode 210
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if(numCourses<=0||prerequisites.length<=0)
			return true;
		outedge=new int [numCourses];
		edges=new ArrayList<List<Integer>>();
		shunxu=new int[numCourses];     // Leetcode 210
		for(int i=0;i<numCourses;i++){
			edges.add(new ArrayList<Integer>());
		}
		for(int[] edge:prerequisites){
			//  edge[1]:被依赖的节点   edge[0]:依赖其他节点的节点
			edges.get(edge[1]).add(edge[0]);
			outedge[edge[0]]++;     // 依赖其他节点的节点的出度+1
		}
		int num=numCourses;
		Queue<Integer> que=new LinkedList<>();
		for(int i=0;i<numCourses;i++){
			if(outedge[i]==0){
				// 出度为0，则可以直接上课
				// 加入队列，当前未上课节点-1
				que.offer(i);
				num--;
				shunxu[numCourses-num-1]=i;     // Leetcode 210
			}
		}
		while(!que.isEmpty()){
			int temp=que.poll();
			for(int v:edges.get(temp)){
				outedge[v]--;
				if(outedge[v]==0){
					que.offer(v);
					num--;
					shunxu[numCourses-num-1]=v;     // Leetcode 210
				}
			}
		}
		return num==0;

//		if(num==0)                                  // Leetcode 210
//			return shunxu;
//		else
//			return new int[0];
	}
}
public class Leetcode207 {
}
