package Leetcode;

import java.util.*;
class Solution649 {
	public String predictPartyVictory2(String senate) {
		int n=senate.length();
		Queue<Integer> left = new LinkedList<>();
		Queue<Integer> right = new LinkedList<>();
		for (int i=0;i<n;i++){
			if (senate.charAt(i)=='R')
				left.offer(i);
			else
				right.offer(i);
		}
		while (!left.isEmpty() && !right.isEmpty()){
			//System.out.println(left+" "+right);
			int leftindex=left.poll();
			int rightindex = right.poll();
			if (leftindex<rightindex){
				//right.poll();
				left.offer(leftindex+n);
			}
			else {
				//left.poll();
				right.offer(rightindex+n);
			}

		}
		return left.isEmpty()?"Dire":"Radient";
	}

	public String predictPartyVictory1(String senate) {
		boolean []isSilence = new boolean[senate.length()];
		int index=0;
		int count=0;
		int leftlen=0;
		int rightlen=0;
		for (int i=0;i<senate.length();i++){
			if (senate.charAt(i)=='R'){
				leftlen++;
			}
			else {
				rightlen++;
			}
		}
		int silenceLenLeft=0;
		int silenceLenRight=0;
		while (silenceLenLeft<leftlen && silenceLenRight<rightlen){
			if (!isSilence[index]){
				if (senate.charAt(index)=='R'){
					if (count<0) {
						isSilence[index] = true;
						silenceLenLeft++;
					}
					count++;
				}
				else {
					if (count>0) {
						isSilence[index] = true;
						silenceLenRight++;
					}
					count--;
				}
			}
			index=(index+1)%senate.length();
		}
		return silenceLenLeft==leftlen?"Dire":"Radiant";
	}

	public String predictPartyVictory(String senate) {
		boolean []isSilence = new boolean[senate.length()];
		int leftlen=0;
		int rightlen=0;
		for (int i=0;i<senate.length();i++){
			if (senate.charAt(i)=='R'){
				leftlen++;
			}
			else {
				rightlen++;
			}
		}
		int silenceLenLeft=0;
		int silenceLenRight=0;
		int index=0;
		while (silenceLenLeft<leftlen && silenceLenRight<rightlen){
			if (!isSilence[index]){
				if (senate.charAt(index)=='R'){
					findnext(isSilence,senate,'D',index);
					silenceLenRight++;
				}
				else {
					findnext(isSilence,senate,'R',index);
					silenceLenLeft++;
				}
			}
			index = (index+1)%senate.length();
		}
		return silenceLenLeft==leftlen?"Dire":"Radiant";
	}
	public void findnext(boolean []isSilence,String str, char side,int index){
		while (true){
			if (!isSilence[index] && str.charAt(index)==side){
				isSilence[index]=true;
				return ;
			}
			index=(index+1)%str.length();
		}
	}
}
public class Leetcode649 {
	public static void main(String []args){
		String str = "DRRDRDRDRDDRDRDR";
		// "DRRDRDRDRDDRDRDR"
		Solution649 sol = new Solution649();
		System.out.println(sol.predictPartyVictory2(str));
	}
}
