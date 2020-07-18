import java.util.*;
class Solution8 {
	public int myAtoi(String str) {
		String newstr=str.trim();
		int index=0;
		int sign=0;
		int start=0;
		int ans=0;
		int charatvalue=0;
		if(newstr.length()<=0){
			return 0;
		}
		if(newstr.charAt(0)=='-'){
			sign=-1;
			index++;
		}
		else if(newstr.charAt(0)=='+'){
			sign=1;
			index++;
		}
		if(index==1&&newstr.length()<=1){
			return 0;
		}
		if(newstr.charAt(index)<'0'||newstr.charAt(index)>'9'){
			return 0;
		}
		while(index<newstr.length()&&newstr.charAt(index)<='9'&&newstr.charAt(index)>='0'){
			index++;
		}
		String numstr=newstr.substring(0,index);
		if(sign!=0){
			start=1;
		}
		for(int i=start;i<numstr.length();i++){
			charatvalue=(numstr.charAt(i)-'0');
			if(verification(ans,charatvalue,sign)==1){
				if(sign==-1){
					return Integer.MIN_VALUE;
				}
				else
					return Integer.MAX_VALUE;
			}
			ans=ans*10+charatvalue;
		}
		if(sign==-1){
			return ans*-1;
		}
		else
			return ans;
	}
	private int verification(int number, int valueOfCharAt, int flag) {
		int result = 0;
		if (flag == -1) {                               // 负数校验
			if (((-number) < Integer.MIN_VALUE / 10) || (-number == (Integer.MIN_VALUE / 10) && valueOfCharAt > 8)) {
				result = 1;
			}
		} else {                                        // 正数校验
			if ((number > Integer.MAX_VALUE / 10) || ((number == Integer.MAX_VALUE / 10) && valueOfCharAt > 7)) {
				result = 1;
			}
		}
		return result;
	}
}
public class Leetcode8 {
	public static void main(String []args){
		String test="2147483648";
		//"1";
		//"words and 987";
		//"4193 with words";
		//"   -42";
		//"  -1201313";
		Solution8 tes=new Solution8();
		System.out.println(tes.myAtoi(test));
	}
}
