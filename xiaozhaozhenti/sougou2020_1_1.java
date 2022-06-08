package xiaozhaozhenti;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
// https://www.nowcoder.com/test/question/55975b1c45a14aafae78166617b1751f?pid=24119923&tid=35561694
// 神奇的数列
class Solutionsougou2020_1_1{
	void fibonachi(int num){
		Map<Integer,Integer> mapp=new HashMap<>();
		// 构造最开始的两个数字
		for(int i=1;i<=num-1;i++){
			for(int j=1;j<=num-i;j++){
				int temp=find(i,j,num);
				if(temp!=-1){
					if(!mapp.containsKey(temp))
						mapp.put(temp,1);
					else
						mapp.put(temp,mapp.get(temp)+1);
				}
			}
		}
		for (Integer key : mapp.keySet()) {
			System.out.println("" + key+" "+mapp.get(key));
		}
	}
	int find(int i,int j,int k){
		int index=2,pre=i ,lat=j,ans=0;
		while(ans<=k){
			if(ans==k)
				return index;
			ans=pre+lat;
			index++;
			pre=lat;
			lat=ans;
		}
		return -1;
	}
}
public class sougou2020_1_1 {
	public static void main(String []args){
		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		Solutionsougou2020_1_1 sol=new Solutionsougou2020_1_1();
		sol.fibonachi(test);
	}
}
