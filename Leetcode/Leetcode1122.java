package Leetcode;

import java.util.*;
class Solution1122 {
	public int[] relativeSortArray2(int[] arr1, int[] arr2) {
		// 计数排序
		int []count = new int[1001];
		for (int i:arr1){
			count[i]++;
		}
		int index=0;
		for (int i:arr2){
			while (count[i]>0){
				arr1[index]=i;
				index++;
				count[i]--;
			}
		}
		for (int i=0;i<1001;i++){
			while (count[i]>0){
				arr1[index]=i;
				index++;
				count[i]--;
			}
		}
		return arr1;
	}

	public int[] relativeSortArray1(int[] arr1, int[] arr2) {
		if (arr2.length<=0)
			return arr1;
		int []ans = new int[arr1.length];
		Map<Integer,Integer> mapp1 = new HashMap<>();
		for (int i=0;i<arr2.length;i++){
			mapp1.put(arr2[i],i);
		}
		int []count = new int[arr2.length];
		int index1=0,index2=0;
		for (int i:arr1){
			if (mapp1.containsKey(i)){
				count[mapp1.get(i)]++;
				index2++;
			}
		}
		for (int i:arr2){
			for (int j = 0; j < count[mapp1.get(i)]; j++) {
				ans[index1] = i;
				index1++;
			}
		}
		//System.out.println(index2);
		for(int i:arr1){
			if (!mapp1.containsKey(i)){
				//System.out.println(index2);
				ans[index2]=i;
				index2++;
			}
		}
		Arrays.sort(ans,index1,ans.length);
		return ans;
	}

	public int[] relativeSortArray(int[] arr1, int[] arr2) {
		if (arr2.length<=0)
			return arr1;
		int []ans = new int[arr1.length];
		Map<Integer,Integer> mapp1 = new HashMap<>();
		for (int i:arr1){
			mapp1.put(i,mapp1.getOrDefault(i,0)+1);
		}
		//System.out.println(mapp1.toString());
		int index=0;
		for (int i:arr2){
			//System.out.println(mapp1.get(i));
			for (int j=0;j<mapp1.get(i);j++){
				ans[index]=i;
				index++;
			}
			mapp1.remove(i);
		}
		int start=index;
		for (int i: mapp1.keySet()){
			for (int j=0;j<mapp1.get(i);j++){
				ans[index]=i;
				index++;
			}
		}
		Arrays.sort(ans,start,index);
		return ans;
	}
}
public class Leetcode1122 {
	public static void main(String []args){
		int []arr1 = {2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31};
		int []arr2 = {2,42,38,0,43,21};
		/*
		[2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31]
		[2,42,38,0,43,21]
		[2,42,38,0,43,21,5,7,12,12,13,23,24,24,27,29,30,31,33,48]
		 */
		Solution1122 sol = new Solution1122();
		System.out.println(Arrays.toString(sol.relativeSortArray2(arr1,arr2)));
	}
}
