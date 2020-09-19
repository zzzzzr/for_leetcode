package JZoffer;

class SolutionJZoffer44 {
	// 0123456789 10111213141516171819202122232425262728930
	// 0-9 10-99 100-999 1000-9999 10000-99999
	// 1    2       3       4       5
	// 10   90     900    9000   90000
	// 0-9 10-189 191-2890
	// 2,147,483,647
	/*
	123 = 1*10 + 113
	1*10: 0 1 2 3 4 5 6 7 8 9
	113 = 2*56 + 1
	2*56: 10 11 ... 64 65
	66
	 */
	/*
	执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
	内存消耗：35.4 MB, 在所有 Java 提交中击败了81.48%的用户
	 */
	public int findNthDigit(int n) {
		if (n<10)
			return n;

		n-=10;
		int i=2;
		int weight=90;
		// 改成 double 和 不用 n>i*double 是为了防止乘积超过int的表示范围
		while(n/(double)weight>i) {
			n = n - weight * i;
			i++;
			weight=weight*10;
			System.out.println(i+" "+weight+" "+n);
		}

		//System.out.println(i+" "+weight+" "+n);

		int index = n%i;
		n = weight/9 +n/i ;

		System.out.println(index+" "+n);

//		if (index==0)
//			return n%10;
//		else
			return Integer.toString(n).charAt(index)-'0';

	}
}
// 01234567891011121314151617
public class JZoffer44 {
	public static void main(String []args){
		// 1000000000
		int n=1000000000;
		SolutionJZoffer44 sol = new SolutionJZoffer44();
		System.out.println(sol.findNthDigit(n));
	}
}
