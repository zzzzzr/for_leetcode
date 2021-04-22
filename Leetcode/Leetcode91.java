package Leetcode;

class Solution91 {
	public int numDecodings(String s) {
		if (s.isEmpty() || s.charAt(0) == '0') {
			return 0;
		}
		if (s.length()==1){
			return 1;
		}

		int []dp = new int[s.length()+2];
		dp[s.length()+1] = 1;
		dp[s.length()] = 1;
		s = s+"9";

		for (int i=s.length()-2;i>=0;i--){
			if (s.charAt(i)!='0') {
				dp[i] += dp[i + 1];
				if (s.charAt(i) == '1') {
					if (i != s.length()-2){
						dp[i] += dp[i + 2];
					}
				} else if (s.charAt(i) == '2' && s.charAt(i + 1) < '7') {
					dp[i] += dp[i + 2];
				}
			}
		}

		return dp[0];
	}

	int ans;
	public int numDecodings1(String s) {
		if (s.isEmpty() || s.charAt(0)=='0'){
			return 0;
		}

		ans=0;

		dfs(s, 0);

		return ans;
	}
	public void dfs(String s, int index){
		if (index>=s.length()){
			ans++;
			return;
		}
		if (s.charAt(index) == '0' ){
			return;
		}

		dfs(s,index+1);
		if (index+1 < s.length() ){
			if (s.charAt(index)=='1'){
				dfs(s,index+2);
			}
			else if (s.charAt(index)=='2' && s.charAt(index+1)<'7'){
				dfs(s,index+2);
			}
		}

	}
}
public class Leetcode91 {
	public static void main(String[] args) {
		Solution91 sol = new Solution91();
		String str = "1";
		// "1226";
		// "06";
		// "0";
		// "226";
		// "12";
		System.out.println(sol.numDecodings(str));
	}
}
