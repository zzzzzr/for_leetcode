package Leetcode;

class Solution43 {
	public String multiply(String num1, String num2) {
		if(num1.length()<=0||num2.length()<=0)
			return "";
		if(num1.equals("0")||num2.equals("0"))
			return "0";
		StringBuilder strb = new StringBuilder();
		int len1=num1.length(),len2=num2.length();
		int jinwei=0;
		for(int i=len1+len2-2;i>=0;i--){
			int tempsum=0;
			for(int j=len1-1;j>=0;j--){
				// i-j 作为第二个数字的下标
				if((i-j)<0||(i-j)>(len2-1))
					continue;
				int factor1=num1.charAt(j)-'0';
				int factor2=num2.charAt(i-j)-'0';
				tempsum+=factor1*factor2;
			}
			//System.out.println(""+tempsum+","+jinwei);
			strb.append((tempsum+jinwei)%10);
			jinwei=(tempsum+jinwei)/10;
		}
		if(jinwei!=0)
			strb.append(jinwei);
		return strb.reverse().toString();
	}
}
public class Leetcode43 {
	public static void main(String []args){
		String str1="123",str2="456";
		Solution43 sol = new Solution43();
		System.out.println(sol.multiply(str1,str2));
	}

}
