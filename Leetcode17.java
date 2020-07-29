import java.util.*;
class Solution17 {
	String []strs=new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	List<String> lis= new ArrayList<>();
	public List<String> letterCombinations(String digits) {
		if(digits.length()<=0){
			return  null;
		}
		StringBuilder str=new StringBuilder("");
		dfs(digits,str,0);
		return lis;
	}
	void dfs(String digits,StringBuilder temp,int index){
		if(index==digits.length()){
			lis.add(temp.toString());
			return ;
		}
		int digit=(digits.charAt(index)-'0')-2;
		for(int j=0;j<strs[digit].length();j++){
			temp.append(strs[digit].charAt(j));
			index++;
			dfs(digits,temp,index);
			index--;
			temp.deleteCharAt(index);
		}
	}
}
public class Leetcode17 {
	public static void main(String [] args){
		Solution17 sol= new Solution17();
		System.out.println(sol.letterCombinations("223"));
	}
}
