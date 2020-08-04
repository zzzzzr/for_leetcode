package JZoffer;
class SolutionJZoffer15 {
	// you need to treat n as an unsigned value

	// 利用位预算结题
	public int hammingWeight(int n) {
		int count=0;
		while(n!=0){
			// 把 n和 1都看作二进制数字，则1表示为 0000 0000 0000 0001，取与后若 n的最后一位为1则结果为1，否则为0
			count+=n&1;
			n=n>>>1;
		}
		return count;
	}


	public int hammingWeight1(int n) {

		int count=0;
		if(n<0){
			count++;
			n=~n;
		}
		StringBuilder str=new StringBuilder();
		while(n!=0){
			if(n%2==1)
				count++;
			str.append((n%2));
			n=n/2;
		}
		System.out.println(str.reverse().toString());
		return count;
	}
	long binary2decimal(String str){
		long sum=0;
		long weight=1;
		for(int i=str.length()-1;i>=0;i--){
			sum+=weight*(str.charAt(i)-'0');
			weight=weight*2;
			//System.out.println(weight*(str.charAt(i)-'0'));
		}
		return sum;
	}
}
// 11111111111111111111111111111101
// 11111111111111111111111111111101
public class JZoffer15 {
	public static void main(String []args){
		int num=429496729;
		long numm=4294967293L;
		SolutionJZoffer15 sol=new SolutionJZoffer15();
		System.out.println(sol.hammingWeight(num));
		System.out.println(sol.binary2decimal("11111111111111111111111111111101"));         // 4294967293
		System.out.println(Math.pow(2,32));
		System.out.println(4>>>2);
		System.out.println(6&5);
		System.out.println(numm>>>1);
		System.out.println(numm>>1);
	}
}
