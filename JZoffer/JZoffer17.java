package JZoffer;
class SolutionJZoffer17 {
	public int[] printNumbers(int n) {
		int len=(int)(Math.pow(10.0,n)-1);
		int []prnum=new int[n];
		for(int i=0;i<len;i++){
			prnum[i]=i+1;
		}
		return prnum;
	}
}
public class JZoffer17 {
}
