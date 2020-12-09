package Leetcode;

class Solution621 {

	// https://leetcode-cn.com/problems/task-scheduler/solution/jian-ming-yi-dong-de-javajie-da-by-lan-s-jfl9/
	public int leastInterval1(char[] tasks, int n) {
		if (n==0)
			return tasks.length;
		int []count = new int['Z'+1];
		for (char ch:tasks)
			count[ch]++;
		int maxcount=0;
		int equalmax=0;
		for (int i='A';i<='Z';i++){
			if (count[i]>maxcount){
				maxcount = count[i];
				equalmax=1;
			}
			else if (count[i]==maxcount)
				equalmax++;
		}
		return Math.max((maxcount-1)*(n+1)+equalmax,tasks.length);
	}

	public int leastInterval(char[] tasks, int n) {
		if (n==0)
			return tasks.length;
		int []count = new int['Z'+1];
		for (char ch:tasks)
			count[ch]++;
		//System.out.println(Arrays.toString(count));
		char []ans = new char[2600];
		int res=0;
		int i=0;

		// 找得到可以填充的字母
		int index = findMax(count);
		while (index>0){
			// 被填充的字母还有
			while (count[index]>0) {
				// 根据之前的位置确定可以填充的位置
				i = fill(ans, i);
				// 填充
				ans[i] = (char) index;
				// 被填充字母个数减一
				count[index]--;
				i+=n+1;
			}
			// 判断尾部是否变大
			res = Math.max(res, i);
			// 下标回归开头位置
			i=0;
			// 确定下一个可以填充的字母是谁
			index = findMax(count);
		}
		for (int j=0;j<res;j++)
			if (ans[j]>='A' && ans[j]<='Z')
				System.out.print(ans[j]);
			else
				System.out.print('_');
		System.out.println();

		while (ans[res]<'A')
			res--;
		return res+1;
	}
	public int fill(char []ans,int i){
		while (ans[i]>='A' && ans[i]<='Z'){
			i++;
		}
		return i;
	}

	public int findMax(int []count){
		int index='A';
		for (int i='A'+1;i<='Z';i++){
			if (count[i]>count[index])
				index=i;
		}
		if (count[index]>0)
			return index;
		else
			return -1;
	}
}
public class Leetcode621 {
	public static void main(String []args){
		char []nums={'A','A','A','B','B','B','C','C','D','C','D','E'};
		// ["A","A","A","B","B","B", "C","C","C", "D", "D", "E"]
		int n=2;
		Solution621 sol = new Solution621();
		System.out.println(sol.leastInterval1(nums,n));
	}
}
