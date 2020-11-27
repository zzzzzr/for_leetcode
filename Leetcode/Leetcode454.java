package Leetcode;

import java.util.*;
class Solution454 {
	public int fourSumCount1(int[] A, int[] B, int[] C, int[] D) {
		HashMap<Integer,Integer> mapp5 = new HashMap<>();
		for (int i:A){
			for (int j:B){
				mapp5.put(i+j,mapp5.getOrDefault(i+j,0)+1);
			}
		}

		int ans=0;
		for (int i:C){
			for (int j:D){
				if (mapp5.containsKey(-i-j)){
					ans += mapp5.get(-i-j);
				}
			}
		}
		return ans;
	}


	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		HashMap<Integer,Integer> mapp1= new HashMap<>();
		for (int i:A){
			mapp1.put(i,mapp1.getOrDefault(i,0)+1);
		}
		HashMap<Integer,Integer> mapp2= new HashMap<>();
		for (int i:B){
			mapp2.put(i,mapp2.getOrDefault(i,0)+1);
		}
		HashMap<Integer,Integer> mapp3= new HashMap<>();
		for (int i:C){
			mapp3.put(i,mapp3.getOrDefault(i,0)+1);
		}
		HashMap<Integer,Integer> mapp4= new HashMap<>();
		for (int i:D){
			mapp4.put(i,mapp4.getOrDefault(i,0)+1);
		}

		HashMap<Integer,Integer> mapp5 = new HashMap<>();
		for (int i:mapp1.keySet()){
			for (int j:mapp2.keySet()){
				mapp5.put(i+j,mapp5.getOrDefault(i+j,0)+mapp1.get(i)*mapp2.get(j));
			}
		}
		HashMap<Integer,Integer> mapp6 = new HashMap<>();
		for (int i:mapp3.keySet()){
			for (int j:mapp4.keySet()){
				mapp6.put(i+j,mapp6.getOrDefault(i+j,0)+mapp3.get(i)*mapp4.get(j));
			}
		}

		int ans=0;
		if (mapp5.size() <= mapp6.size()){
			for (int i:mapp5.keySet()){
				if (mapp6.containsKey(-i)){
					ans += (mapp5.get(i)*mapp6.get(-i));
				}
			}
			return ans;
		}
		else {
			for (int i:mapp6.keySet()){
				if (mapp5.containsKey(-i)){
					ans += (mapp5.get(-i)*mapp6.get(i));
				}
			}
			return ans;
		}
	}
}
public class Leetcode454 {
	public static void main(String []args){
		Solution454 sol = new Solution454();
		int []a={1, 2};
		int []b={-2,-1};
		int []c = {-1, 2};
		int []d = {0, 2};
		System.out.println(sol.fourSumCount(a,b,c,d));
	}
}
