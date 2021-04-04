package Leetcode;

import java.util.*;
class Solution781 {
	public int numRabbits(int[] answers) {
		// Set<Integer> sett = new HashSet<>();
		Map<Integer,Integer> mapp = new HashMap<>();
		int ans=0;
		for (int answer : answers) {
			mapp.put(answer, mapp.getOrDefault(answer, 0) + 1);
		}
		System.out.println(mapp);
		for (Map.Entry<Integer,Integer> ent:mapp.entrySet()){
			int count = ent.getKey()+1;
			int total = ent.getValue();
			int sample;
			if(total%count==0){
				sample = total;
			}
			else {
				sample = (total/count+1)*count;
			}
			ans += sample;
//			ans+= Math.floor(1.0*ent.getValue()/(ent.getKey()+1))*(ent.getKey()+1);
//			System.out.println(ans);
		}
		return ans;
	}
}
public class Leetcode781 {
	public static void main(String []args){
		Solution781 sol = new Solution781();
		int []nums = {0,0,1,1,1};
		// {1,1,2};
		// {1,0,1,0,0};
		System.out.println(sol.numRabbits(nums));
	}
}
