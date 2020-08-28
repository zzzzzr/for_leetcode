import java.util.*;
class Solution547 {
	int []unionfind;
	public int findCircleNum(int[][] M) {
		if (M.length<=0)
			return 0;
		unionfind = new int[M.length];
		// 每个节点的父节点指向自己
		for (int i=0;i<M.length;i++){
			unionfind[i] = i;
		}
		// 如果后面的节点和前面的节点相连，则后面节点的父节点指向前面节点的父节点
		for (int i=0;i<M.length-1;i++){
			for (int j=i+1;j<M.length;j++){
				if (M[i][j]==1){
					merge(i,j);
				}
			}
		}
		int ans=0;
		for (int i=0;i<M.length;i++){
			if (unionfind[i]==i)
				ans++;
		}
		return ans;
	}

	int find1(int x)
	{
		if(unionfind[x] == x)
			return x;
		else
			return find(unionfind[x]);
	}

	int find(int x)
	{
		if(x == unionfind[x])
			return x;
		else{
			unionfind[x] = find(unionfind[x]);  //父节点设为根节点
			return unionfind[x];         //返回父节点
		}
	}
	void merge(int i, int j)
	{
		unionfind[find(i)] = find(j);
	}
}
public class Leetcode547 {
}
