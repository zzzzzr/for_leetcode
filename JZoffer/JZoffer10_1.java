package JZoffer;

import java.math.BigInteger;
//这一题的做法同样适用于JZoffer10_2，只是起始条件有所变化

class SolutionJZoffer10_1 {
	public int fib(int n) {
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		BigInteger pre1=BigInteger.valueOf(0);
		BigInteger pre2=BigInteger.valueOf(1);
		//long pre2=1;
		BigInteger ans=BigInteger.valueOf(0);
		//long ans=0;

		while(n>1){
			//ans= pre1+pre2;
			ans=pre1.add(pre2);
			n--;
			pre1=pre2;
			pre2=ans;
		}
		return (pre2.mod(BigInteger.valueOf(1000000007))).intValue();

	}
	public int fib_1(int n) {
		// 重点： int的范围是-2^31~2^31-1,即-2147483648~2147483647
		// 1000000007在这个范围内，但斐波那契求和后可能不在，所以要为每一项取模
		if(n==0)
			return 1;
		if(n==1)
			return 1;
		int pre1=1;
		int pre2=1;
		int ans=0;

		while(n>1){
			ans= (pre1+pre2)%1000000007;
			n--;
			pre1=pre2;
			pre2=ans;
		}
		return ans;

	}
}
public class JZoffer10_1 {
	public static void main(String []args) {
		int n=7;
		SolutionJZoffer10_1 sol=new SolutionJZoffer10_1();
		System.out.println(sol.fib_1(n));
	}
}
/*
0 1 1 2 3 5 8 13 21 34 55
 */