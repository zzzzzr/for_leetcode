package algorithm_datastructure;

public class union_find_set {
	int []unionfind;
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
