package JZoffer;

import java.util.*;

class SolutionJZoffer14_2 {
	// 这一题不能再用动归，改成贪心算法
	public int cuttingRope(int n) {
		if(n<4)
			return n-1;
		long ans=1;
		int mod=(int)1e9+7;
		while(n>4){
			ans=ans*3%mod;
			n-=3;
		}
		return (int)(ans*n%mod);
	}
	//  (a*b)%c=((p*c+q)*(m*c+n))%c=(p*m*c*c+n*p*c+q*m*c+nq)%c=n*q%c=(a%c)*(b%c)%c
}

public class JZoffer14_2 {
	public static void main(String []args){
		int num=127;
		SolutionJZoffer14_2 sol=new SolutionJZoffer14_2();
		System.out.println(sol.cuttingRope(num));
	}
}
