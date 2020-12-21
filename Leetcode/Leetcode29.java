package Leetcode;

class Solution29 {
	public int divide(int dividend, int divisor) {
		if (dividend==0)
			return 0;
		if (divisor==1)
			return dividend;
		if (divisor==-1 && dividend==Integer.MIN_VALUE)
			return Integer.MAX_VALUE;

		int flag=1;
		if ((dividend>0 && divisor<0) || (dividend<0 && divisor>0))
			flag=-1;

		dividend = -Math.abs(dividend);
		divisor = -Math.abs(divisor);
		//System.out.println(dividend+" "+divisor);

		int ans=0;
		while (dividend <= divisor){

			int temp=-1;
			int temp_divisor=divisor;

			while ( dividend <= (temp_divisor<<1)){
				if(temp_divisor <= (Integer.MIN_VALUE >> 1))
					break;
				temp <<= 1;
				temp_divisor <<= 1;
				//System.out.println(temp+" "+temp_divisor);
			}
			//System.out.println(temp+" "+temp_divisor);
			dividend -= temp_divisor;
			ans+=temp;
		}

		if (flag>0)
			return ans==Integer.MIN_VALUE?Integer.MAX_VALUE:  -ans;
		else
			return ans;
	}

	public long divise(int a, int b){
		if (a<b)
			return 0;
		int count=1;
		int doubleb=b;
		while ((doubleb+doubleb)<a){
			count += count;
			doubleb += doubleb;
		}
		//System.out.println(count);
		return count+divise(a-doubleb,b);
	}
}
public class Leetcode29 {
	public static void main(String []args){
		int a=-2147483648;
		int b=-2;
		// -2147483648
		//-1

		//System.out.println(-2<<1);
		Solution29 sol = new Solution29();
		System.out.println(sol.divide(a,b));
	}
}
