import java.util.*;
class Solution13 {
	public int romanToInt(String s) {
		if(s.length()<=0)
			return 0;
		Map<String,Integer> map=new HashMap<>();
		map.put("I",1);
		map.put("IV",4);
		map.put("V",5);
		map.put("IX",9);
		map.put("X",10);
		map.put("XL",40);
		map.put("L",50);
		map.put("XC",90);
		map.put("C",100);
		map.put("CD",400);
		map.put("D",500);
		map.put("CM",900);
		map.put("M",1000);
		int index=0;
		int ans=0;
		int len=s.length();
		while(index<len){
			if(map.containsKey(s.substring(index,index+2))){
				ans+=map.get(s.substring(index,index+2));
				index+=2;
			}
			else {
				ans+=map.get(s.substring(index,index+1));
				index++;
			}
		}
		return ans;
	}
	public int romanToInt_1(String s) {
		if(s.length()<=0)
			return 0;
		int ans=0;
		//int status=0;
		int index=0;
		int len=s.length();
		int I=1;
		int V=5;
		int X=10;
		int L=50;
		int C=100;
		int D=500;
		int M=1000;
		while(index<len){
			System.out.println(ans+" "+index+" "+s.charAt(index));
			switch (s.charAt(index)){
				case 'M':{
					ans+=M;
					break;
				}
				case 'D':{
					ans+=D;
					break;
				}
				case 'C':{
					if(index+1<len&&s.charAt(index+1)=='M'){
						ans+=M-C;
						index++;
						break;
					}
					else if(index+1<len&&s.charAt(index+1)=='D'){
						ans+=D-C;
						index++;
						break;
					}
					else{
						ans+=C;
						break;
					}
				}
				case 'L':{
					ans+=L;
					break;
				}
				case 'X':{
					if(index+1<len&&s.charAt(index+1)=='C'){
						ans+=C-X;
						index++;
						break;
					}
					else if(index+1<len&&s.charAt(index+1)=='L'){
						ans+=L-X;
						index++;
						break;
					}
					else{
						ans+=X;
						break;
					}
				}
				case 'V':{
					ans+=V;
					break;
				}
				case 'I':{
					if(index+1<len&&s.charAt(index+1)=='X'){
						ans+=X-I;
						index++;
						break;
					}
					else if(index+1<len&&s.charAt(index+1)=='V'){
						ans+=V-I;
						index++;
						break;
					}
					else{
						ans+=I;
						break;
					}
				}
			}

			index++;
		}
		return ans;
	}
}
/*
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
*/
public class Leetcode13 {
	public static void main(String []args){
		String str="MCMXCIV";
		//"LVIII";
		//"IX";
		//"IV";
		//"III";
		//"CDXXIV";
		//{3,1,5,8};
		//{1,2,3};
		Solution13 sol=new Solution13();
		System.out.println(sol.romanToInt(str));
	}
}
