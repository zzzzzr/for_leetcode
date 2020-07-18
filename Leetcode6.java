import java.util.*;
class Solution6 {
	public String convert(String s, int numRows) {
		if(s.length()<=0||numRows<=0){
			return "";
		}
		if(numRows==1){
			return s;
		}
		char []array=new char[s.length()];
		int k1=2*numRows-2;
		int bloc=(int)Math.ceil((double)s.length()/k1);
		int index=0;
		int loc;
		//System.out.println(k1+" "+bloc+" "+s.length());
		for(int i=0;i<numRows;i++){
//			if(index>=s.length()){
//				break;
//			}
			if(i==0||i==numRows-1){
				for(int j=0;j<bloc;j++){
					loc=j*k1+i;
					if(loc>=s.length()){
						break;
					}
//					System.out.print(index+"\t");
//					System.out.println(loc);
					array[index]=s.charAt(loc);
					index++;
				}
			}
			else{
				for(int j=0;j<bloc;j++){
					loc=j*k1+i;
					if(loc>=s.length()){
						break;
					}
					array[index]=s.charAt(loc);
					index++;

					loc=(j+1)*k1-i;
					if(loc>=s.length()){
						break;
					}
					array[index]=s.charAt(loc);
					index++;
				}
			}

		}
		String ans=new String(array);
		return ans;
	}
}
public class Leetcode6 {
	public static void main(String []args){
		String test="A";
		//"LEETCODEISHIRING";
		int numrows=1;
		Solution6 sol=new Solution6();
		System.out.println(sol.convert(test,numrows));
	}
}
//LCIRETOESIIGEDHN
//LCIRETOESIIGEDHN
//LDREOEIIECIHNTSG
//LDREOEIIECIHNTSG
