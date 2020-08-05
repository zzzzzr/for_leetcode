package JZoffer;
class SolutionJZoffer16 {
	public double myPow(double x, int n) {
		boolean flag=true;
		if(n<0){
			flag=false;
			n=-n-1;
		}
		double ans= 1;
		ans=quickpower(x,n);
//		while(n>0){
//			ans=ans*x;
//			n--;
//		}
		if(!flag)
			return 1/(ans*x);
		return ans;
	}
	double quickpower(double x,int n){
		if(n==0)
			return 1;
		if(n==1)
			return x;
		if(n%2==0){
			double temp1=quickpower(x,n/2);
			return temp1*temp1;
		}
		else {
			double temp2=quickpower(x, (n - 1) / 2);
			return temp2*temp2*x;
		}
	}
}
//0.00001
//2147483647
//1.00000
//-2147483648
public class JZoffer16 {
	public static void main(String []args){
		double base=0.00001;
		int exponention=-2147483648;
		SolutionJZoffer16 sol=new SolutionJZoffer16();
		System.out.println(sol.myPow(base,exponention));
	}
}
