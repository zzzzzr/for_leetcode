package JZoffer;

import java.util.*;
class SolutionJZoffer57_2 {
	public int[][] findContinuousSequence1(int target) {
		liss = new LinkedList<>();
		for (int i=1;i<=target/2+1;i++){
//			int delta = 1+8*target-4*i+4*i*i;
			long delta = 4*(2*target+(long)i*(i-1))+1;
			//System.out.println(i+" "+delta);
			if (delta>=0){
				int sqrtt = (int)Math.sqrt(delta);
				if ((long)sqrtt*sqrtt==delta){
					int j=(-1+sqrtt)/2;
					add1(i,j);
				}
			}
		}
		int [][]res = new int[liss.size()][];
		int index=0;
		for (int[] arr:liss){
			res[index]=arr;
			index++;
		}
		return res;
	}

	public void add1(int start,int end){
		int []ans=new int[end-start+1];
		int index=0;
		for (int i=start;i<=end;i++){
			ans[index]=i;
			index++;
		}
		liss.add(ans);
	}


	List<int[]> liss;
	public int[][] findContinuousSequence(int target) {
		liss = new LinkedList<>();
		int i=1,j=2;
		while (i<j){
			int sum=(i+j)*(j-i+1)/2;
			if (sum==target) {
				add1(i, j);
				i++;
			}
			else if (sum<target){
				j++;
			}
			else {
				i++;
			}
		}
		int [][]res = new int[liss.size()][];
		int index=0;
		for (int[] arr:liss){
			res[index]=arr;
			index++;
		}
		return res;
	}
}
public class JZoffer57_2 {
	public static void main(String []args){
		int target = 98160;
		SolutionJZoffer57_2 sol = new SolutionJZoffer57_2();
		for (int []arr: sol.findContinuousSequence(target))
			System.out.println(Arrays.toString(arr));
	}
}
