package Leetcode;

import java.util.*;
// https://leetcode-cn.com/problems/evaluate-division/solution/399-chu-fa-qiu-zhi-nan-du-zhong-deng-286-w45d/
class Solution399 {
	int []father;
	double []weight;

	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		int size = equations.size();

		father = new int[size*2];
		for (int i=0;i<size*2;i++){
			father[i] = i;
		}
		weight = new double[size*2];
		Arrays.fill(weight, 1.0);

		Map<String, Integer> mapp = new HashMap<>();

		int index=0;
		for (int i=0;i<size;i++){
			List<String> lis = equations.get(i);
			String str1 = lis.get(0);
			String str2 = lis.get(1);
			if (!mapp.containsKey(str1)){
				mapp.put(str1,index);
				index++;
			}
			if(!mapp.containsKey(str2)){
				mapp.put(str2,index);
				index++;
			}
			combine(mapp.get(str1),mapp.get(str2),values[i]);
		}

		int querysize = queries.size();
		double []ans = new double[querysize];
		for (int i=0;i< querysize;i++){
			List<String> lis = queries.get(i);
			String str1 = lis.get(0);
			String str2 = lis.get(1);
			int id1 = mapp.getOrDefault(str1,-1);
			int id2 = mapp.getOrDefault(str2,-1);
			if (id1==-1 || id2==-1)
				ans[i]=-1;
			else
				ans[i] = isconnected(id1,id2);
		}
		return ans;
	}
	public int find(int i){
		if (father[i] != i){
			int fa = father[i];
			father[i] = find(fa);
			weight[i] *= weight[fa];
		}
		return father[i];
	}
	public void combine(int i, int j, double num){
		int fi = find(i);
		int fj = find(j);
		if(fi!=fj){
			father[fi] = fj;
			weight[fi] = weight[j]*num/weight[i];
		}
	}
	public double isconnected(int i, int j){
		if(find(i)==find(j))
			return weight[i]/weight[j];
		else
			return -1.0;
	}
}
public class Leetcode399 {
}
