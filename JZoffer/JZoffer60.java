package JZoffer;

import java.util.*;
class SolutionJZoffer60 {
	public double[] dicesProbability(int n) {
		double []basic = new double[6];
		for (int i=0;i<6;i++)
			basic[i]=1.0;
		for (int i=2;i<=n;i++){
			// i 指代当前有几颗骰子
			int len=i*5+1;
			// len 指代数组的长度
			int half;
			// half 指代数组对称部分长度
			// i 为偶数，数组长度为奇，半径为奇
			// i 为奇数，数组长度为偶，半径为偶
			half=(len+1)/2;
			// 每次的点数和的范围为 i-6i
			double []newbasic = new double[len];
			int tempsum=0;
			for (int j=0;j<half;j++){
				if (j<6){
					tempsum+=basic[j];
					newbasic[j] = tempsum;
				}
				else {
					tempsum+=basic[j]-basic[j-6];
					newbasic[j]=tempsum;
				}
			}
			for (int j=half;j<len;j++){
				newbasic[j] = newbasic[len-1-j];
			}
			basic = newbasic;
			//System.out.println(Arrays.toString(basic));
		}
		double power = Math.pow(6,n);
		for (int i=0;i< basic.length;i++)
			basic[i]/=power;
		return basic;
	}
}
/*
		    [0, 0, 1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1]
      [0, 0, 0, 1, 3, 6, 10, 15, 21, 25, 27, 27, 25, 21, 15, 10, 6, 3, 1]
[0, 0, 0, 0, 1, 4, 10, 20, 35, 56, 80, 104, 125, 140, 146, 140, 125, 104, 80, 56, 35, 20, 10, 4, 1]
* */
public class JZoffer60 {
	public static void main(String []args){
		int n=4;
		SolutionJZoffer60 sol = new SolutionJZoffer60();
		System.out.println(Arrays.toString(sol.dicesProbability(n)));
//		int []count = new int[n*6+1];
//		for (int i=1;i<=6;i++){
//			for (int j=1;j<=6;j++){
////				for (int k=1;k<=6;k++){
////					for (int l=1;l<=6;l++) {
//						count[i + j ]++;
////					}
////				}
//			}
//		}
//		System.out.println(Arrays.toString(count));
	}
}
