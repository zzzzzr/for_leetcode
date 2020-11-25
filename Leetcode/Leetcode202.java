package Leetcode;

import java.util.*;
class Solution202 {
	public boolean isHappy2(int n) {
		Set<Integer> sett = new HashSet<>();
		int j=count(n);
		while (!sett.contains(j)){
			sett.add(j);
			j=count(j);
		}
		return j==1;
	}

	public boolean isHappy1(int n) {
		Map<Integer,Integer> map = new HashMap<>();
		int j=count(n);
		map.put(n,j);
		while (!map.containsKey(j)){
			int i=count(j);
			map.put(j,i);
			j=i;
		}
		return j==1;
	}


	public boolean isHappy(int n) {
//		int []map = new int[201];
		int []map = {0, 1, 4, 9, 16, 25, 36, 49, 64, 81, 1, 2, 5, 10, 17, 26, 37, 50, 65, 82, 4, 5, 8, 13, 20, 29, 40, 53, 68, 85, 9, 10, 13, 18, 25, 34, 45, 58, 73, 90, 16, 17, 20, 25, 32, 41, 52, 65, 80, 97, 25, 26, 29, 34, 41, 50, 61, 74, 89, 106, 36, 37, 40, 45, 52, 61, 72, 85, 100, 117, 49, 50, 53, 58, 65, 74, 85, 98, 113, 130, 64, 65, 68, 73, 80, 89, 100, 113, 128, 145, 81, 82, 85, 90, 97, 106, 117, 130, 145, 162, 1, 2, 5, 10, 17, 26, 37, 50, 65, 82, 2, 3, 6, 11, 18, 27, 38, 51, 66, 83, 5, 6, 9, 14, 21, 30, 41, 54, 69, 86, 10, 11, 14, 19, 26, 35, 46, 59, 74, 91, 17, 18, 21, 26, 33, 42, 53, 66, 81, 98, 26, 27, 30, 35, 42, 51, 62, 75, 90, 107, 37, 38, 41, 46, 53, 62, 73, 86, 101, 118, 50, 51, 54, 59, 66, 75, 86, 99, 114, 131, 65, 66, 69, 74, 81, 90, 101, 114, 129, 146, 82, 83, 86, 91, 98, 107, 118, 131, 146, 163, 4};
		for (int i=1;i<201;i++){
			map[i]=count(i);
		}
		System.out.println(Arrays.toString(map));
		int i=n,j=n;
		do{
			if (i==1)
				return true;
			i=map[i];
			j=map[map[j]];
		}while ( i != j);
		return i==1;
	}
	public int count(int a){
		int ans=0;
		while (a>0){
			ans+=(a%10)*(a%10);
			a/=10;
		}
		return ans;
	}
}
public class Leetcode202 {
	public static void main(String []args){
		int n=19;
		Solution202 sol = new Solution202();
		System.out.println(sol.isHappy1(n));
	}
}
