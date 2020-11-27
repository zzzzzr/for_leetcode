package Leetcode;

class Solution50 {
	public double myPow(double x, int n) {
		if (n==0)
			return 1;
		if (x==0 || x==1)
			return x;
//		if (n<0)
//			return 1/quickpower(x,-n);
		return quickpower(x, n);
	}
	public double quickpower(double x,int n){
		if (n==1)
			return x;
		if (n==-1)
			return 1/x;
		if (n%2==0){
			double tmp=quickpower(x, n/2);
			return tmp*tmp;
		}
		else {
			if (n>0) {
				double tmp = quickpower(x, (n - 1) / 2);
				return tmp * tmp * x;
			}
			else {
				double tmp = quickpower(x,(n+1)/2);
				return tmp*tmp/x;
			}
		}
	}
}
public class Leetcode50 {
	public static void main(String []args){
		double x=2.0;
		int n=10;
		Solution50 sol = new Solution50();
		System.out.println(sol.myPow(x,n));
	}
}
