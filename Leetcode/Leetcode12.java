package Leetcode;

import java.util.*;
class Solution12 {
	public String intToRoman(int num) {
		int []value=new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
		String []sysbol=new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		StringBuilder str= new StringBuilder();
		for (int i=0;i<value.length;i++){
			while(value[i]<=num){
				num-=value[i];
				str.append(sysbol[i]);
			}
		}
		return str.toString();
	}
	public String intToRoman_1(int num) {
		String str="";
		Map<Integer,String> map=new HashMap<>();
		map.put(0,"");
		map.put(1,"I");
		map.put(2,"II");
		map.put(3,"III");
		map.put(4,"IV");
		map.put(5,"V");
		map.put(6,"VI");
		map.put(7,"VII");
		map.put(8,"VIII");
		map.put(9,"IX");
		map.put(10,"X");
		map.put(20,"XX");
		map.put(30,"XXX");
		map.put(40,"XL");
		map.put(50,"L");
		map.put(60,"LX");
		map.put(70,"LXX");
		map.put(80,"LXXX");
		map.put(90,"XC");
		map.put(100,"C");
		map.put(200,"CC");
		map.put(300,"CCC");
		map.put(400,"CD");
		map.put(500,"D");
		map.put(600,"DC");
		map.put(700,"DCC");
		map.put(800,"DCCC");
		map.put(900,"CM");
		map.put(1000,"M");
		map.put(2000,"MM");
		map.put(3000,"MMM");
		int mod;
		int weight=1;
		while(num!=0){
			mod=num%10;
			num=num/10;
			str=map.get(mod*weight).concat(str);
			weight=weight*10;
		}
		return str;
	}
}
//String reverse = new StringBuffer(string).reverse().toString();
public class Leetcode12 {
	public static void main(String []args){
		int num=1994;

		Solution12 sol=new Solution12();
		System.out.println(sol.intToRoman(num));
	}
}
