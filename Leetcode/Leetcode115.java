package Leetcode;

import java.util.*;
class Solution115 {
	/*
	如果sj!=ti 则记录下 count j i = count j-1 i
	其实 count j-1 i 也未必是一个匹配的上的情况，但他也可以递归的去记录上面的情况
	那么其实会有两种可能： 一种是上面出现过匹配的上的情况，那么下面的这些未匹配上的 count 值都是在重复上面的 count值
	也就是在为上面匹配的上的串做复述
	另一种是上面未出现过匹配上的情况，那么这些值就都应该是0，这也是为什么要设置一个两侧更大一维的数组，而且最上面一排不赋值的原因
	如果 sj==ti 则记录下 count j i = count j-1 i + count j-1 i-1
	其实匹配的上的情况下的count值其实是代表了 s 0 j 与 t 0 i 的所有匹配可能
	而并不只是在 sj 与 t i 对应情况下的匹配可能
	赋值中的 count j-1 i 就是记录上面所有情况下的匹配个数
	而 count j-1 i-1 则是代表了只在sj 与 t i 对应情况下的匹配可能

	count数组中的每个元素都代表了 s 0 j 与 t 0 i 的所有合法的匹配情况，但有值不代表当前元素可以相互对应的上
	他也可能只是复述上面的情况
	这种复述也为下面出现元素对应的上情况时求值做准备
	 */
	public int numDistinct2(String s, String t) {
		int len1 = s.length();
		int len2 = t.length();
		int [][]count = new int[len1+1][len2+1];

		for (int j=0;j<len1;j++){
			count[j][0] = 1;
		}
		for(int i=1;i<=len2;i++){
			for (int j=1;j<=len1;j++){
				if (s.charAt(j-1)==t.charAt(i-1)){
					count[j][i] = count[j-1][i-1]+count[j-1][i];
				}
				else{
					count[j][i] = count[j-1][i];
				}
			}
		}
//		for (int []arr:count){
//			System.out.println(Arrays.toString(arr));
//		}
		return count[len1][len2];
	}

	public int numDistinct1(String s, String t) {
		int len1 = s.length();
		int len2 = t.length();
		int [][]count = new int[len1][len2];
		Set<Integer> avaible = new HashSet<>();

		for (int j=0;j<len1;j++){
			if (s.charAt(j)==t.charAt(0)){
				count[j][0]=1;
				avaible.add(j);
			}
		}
		for(int i=1;i<len2;i++){
			Set<Integer> temp = new HashSet<>();
			for (Integer j:avaible){
				for (int k=j+1;k<len1;k++){
					if (s.charAt(k)==t.charAt(i)){
						count[k][i] += count[j][i-1];
						temp.add(k);
					}
				}
			}
			avaible = temp;
		}
		int ans=0;
		for (int i=len2-1;i<len1;i++){
			ans+=count[i][len2-1];
		}
//		for (int []arr:count){
//			System.out.println(Arrays.toString(arr));
//		}
		return ans;
	}

	public int numDistinct(String s, String t) {
//		System.out.println(s+" "+t);
		if (s.length()<t.length())
			return 0;
		if (s.length()==t.length()) {
			if (s.equals(t))
				return 1;
			else
				return 0;
		}
		if (t.length()==0)
			return 1;
		int count = 0;
		for(int i=0;i<s.length();i++){
			if (s.charAt(i)==t.charAt(0)){
				count += numDistinct(s.substring(i+1),t.substring(1));
			}
		}
		return count;
	}
}
public class Leetcode115 {
	public static void main(String []args){
		String s ;
		String t ;
//		s="babgbag";
//		t="bag";
		s="rabbbit";
		t="rabbit";
		Solution115 sol = new Solution115();
		System.out.println(sol.numDistinct2(s,t));
	}
}
