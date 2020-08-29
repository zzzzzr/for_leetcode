package Leetcode;

import java.util.*;
class Solution201 {

	public int rangeBitwiseAnd1(int m, int n) {
		int shift =0;
		while(m<n){
			m=m>>1;
			n=n>>1;
			shift++;
		}
		return m<<shift;
	}

	public int rangeBitwiseAnd(int m, int n) {
		if (m==0)
			return 0;
		int len1 = (int)(Math.log(m)/Math.log(2))+1;
		int len2 = (int)(Math.log(n)/Math.log(2))+1;

		//int minus = n-m;

		//System.out.println(" "+len1+" "+len2);

		if (len1<len2){
			return 0;
		}

		int []ans = new int[len1];
		Arrays.fill(ans,1);

		for(int i=m;i<=n;i++){
			int temp =i;
			for(int j=0;j<len1;j++){
				int k = temp&1;
				temp = temp>>1;
				if(ans[j]!=0&&k==0)
					ans[j]=0;
			}
			if(i==2147483647)
				break;
		}

		int res=0;
		int weight = 1;
		for(int j=0;j<len1;j++){
			if(ans[j]==1){
				res+=weight;
			}
			weight=weight*2;
		}
		return res;
	}

	public int short_n(int n,int len){
		int ans = 0;
		int weight =1;
		for(int i=0;i<len ;i++){
			ans =ans+ weight*(n&1);
			n=n>>1;
			weight = weight*2;
		}
		return ans;
	}

	public int short_n1(int n,int len){
		int ans = 0;
		int weight =1;
		for(int i=0;i<len ;i++){
			ans =ans+ weight;
			weight = weight*2;
		}
		return Math.min(ans,n);
	}

	public void print(int x,int len){
		for(int i =0;i<len;i++){
			System.out.println(x&1);
			x= x>>1;
		}
	}
}
public class Leetcode201 {
	public static void main(String []args){
		int m=11,n=12;
		// 2147483646
		//2147483647
		//System.out.println(n);
		Solution201 sol = new Solution201();
		System.out.println(sol.rangeBitwiseAnd1(m,n));
		//sol.print(5,3);
		//System.out.println(sol.short_n(15,2));
	}
}
