package JZoffer;
class SolutionJZoffer05 {
	public String replaceSpace(String s) {
		StringBuilder str=new StringBuilder();
		int index=0;
		while(index<s.length()){
			char ch= s.charAt(index);
			if(ch==' '){
				str.append("%20");
			}
			else
				str.append(ch);
			index++;
		}
		return str.toString();
	}
}
public class JZoffer05 {
	public static void main(String []args) {
		String s="we hello world";
		SolutionJZoffer05 sol= new SolutionJZoffer05();
		System.out.println(sol.replaceSpace(s));
	}
}
