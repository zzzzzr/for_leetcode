package JZoffer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class SolutionJZoffer13 {
	class loc{
		int row;
		int column;
		int step;
		public loc(int i,int j,int l){
			this.row=i;
			this.column=j;
			this.step=l;
		}
	}
	public int movingCount(int m, int n, int k) {
		//  用hashmap,用1000*i+j指代

		Queue<Integer> que=new LinkedList<>();
		int count=0;
		que.offer(0);
		//count++;
		// i*1000,j*1
		// 100    100
		while (!que.isEmpty()){
			int temp=que.poll();
			count++;
			if((check(temp / 1000+1,temp % 1000,k)&&(temp/1000+1)<m)) {
				int temp1 = (temp / 1000 + 1) * 1000 + (temp % 1000)  ;
				if (!que.contains(temp1))
					que.offer(temp1);
			}
			if(check(temp / 1000,(temp % 1000) +1,k)&&((temp%1000)+1<n)) {
				int temp2 = temp / 1000 * 1000 + ((temp % 1000)  + 1) ;
				if (!que.contains(temp2))
					que.offer(temp2);
			}
		}
		return count;
	}
	public int movingCount1(int m, int n, int k) {
		char [][]board=new char[m][n];
		for (char[] chars : board) {
			Arrays.fill(chars, 'x');
		}
		int count=0;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(check(i,j,k)){
					board[i][j]='o';
					count++;
				}
			}
		}
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				System.out.print(board[i][j]+"\t");
			}
			System.out.println();
		}
		return count;
	}

	Boolean check(int i,int j,int k){
		int temp=0;
		while(i!=0){
			temp+=i%10;
			i=i/10;
		}
		while(j!=0){
			temp+=j%10;
			j=j/10;
		}
		return temp<=k;
	}
}
public class JZoffer13 {
	public static void main(String []args){
		int i=54,j=89,k=20;
		SolutionJZoffer13 sol= new SolutionJZoffer13();
		System.out.println(sol.movingCount(i,j,k));
	}
}
