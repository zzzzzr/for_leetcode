class Solution415 {
	public String addStrings(String num1, String num2) {
		StringBuilder sb=new StringBuilder();
		int flag=0;
		int i;
		for(i=1;i<=Math.min(num1.length(),num2.length());i++){
			int sum=num1.charAt(num1.length()-i)-'0'+num2.charAt(num2.length()-i)-'0'+flag;
			sb.append(sum%10);
			flag=sum/10;
		}
//		if(num1.length()==num2.length()){
//			sb.append(flag);
//			return sb.reverse().toString();
//		}
		if(num1.length()>num2.length()){
			while(i<=num1.length()){
				int sum=num1.charAt(num1.length()-i)-'0'+flag;
				sb.append(sum%10);
				flag=sum/10;
				i++;
			}
		}
		else if(num1.length()<num2.length()){
			while(i<=num2.length()){
				int sum=num2.charAt(num2.length()-i)-'0'+flag;
				sb.append(sum%10);
				flag=sum/10;
				i++;
			}
		}
		if(flag!=0){
			sb.append(flag);
		}
		return sb.reverse().toString();
	}
}
public class Leetcode415 {
	public static void main(String []args) {
		Solution415 sol=new Solution415();
		String str1="12458",str2="97541";
		System.out.println(sol.addStrings(str1,str2));
	}
}
