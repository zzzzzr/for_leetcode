package xiaozhaozhenti;

import java.util.*;
class Solution_mt2{
	public void fingnum(){
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int len = s.length();
		List<Integer> lis = new ArrayList<>(506);
		for (int i=0;i<len;i++){
			if (Character.isDigit(s.charAt(i))){
				int temp = 0;
				while (i<len && Character.isDigit(s.charAt(i))){
					temp = temp*10+(s.charAt(i)-'0');
					i++;
				}
				lis.add(temp);
			}
		}
		Collections.sort(lis);
		for (Integer i:lis)
			System.out.println(i);
	}
}
public class MST_MT_2 {
	public static void main(String []args){
		Solution_mt2 sol = new Solution_mt2();
		String s = "sd15sfs154s87sfs7d87";
		sol.fingnum();
	}
}
