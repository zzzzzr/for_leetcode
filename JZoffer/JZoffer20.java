package JZoffer;
// 状态机
// 完全是撞样例的一道题，太依赖于样例设置了
class SolutionJZoffer20 {
	public boolean isNumber(String s) {
		if(s.length()<=0)
			return false;
		int flag=0;
		int start=0,end=s.length();
		while(s.charAt(start)==' '){
			start++;
		}
		while (s.charAt(end-1)==' '){
			end--;
		}
		for(int i=start;i<end;i++){
			char ch=s.charAt(i);
			switch (flag){
				case 0:{
					switch (ch){
						case '+':
						case '-':{
							flag=1;
							break;
						}
						case'0':
						case'1':
						case'2':
						case'3':
						case'4':
						case'5':
						case'6':
						case'7':
						case'8':
						case'9':{
							flag=2;
							break;
						}
						case '.':{
							flag=7;
							break;
						}
						default:{
							System.out.println("case 0 error");
							return false;
						}
					}
					break;
				}
				case 1:{
					switch (ch){
						case'0':
						case'1':
						case'2':
						case'3':
						case'4':
						case'5':
						case'6':
						case'7':
						case'8':
						case'9':{
							flag=2;
							break;
						}
						case '.':{
							flag=7;
							break;
						}
						default:{
							System.out.println("case 1 error");
							return false;
						}
					}
					break;
				}
				case 2:{
					switch (ch) {
						case '0':
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
						case '9': {
							break;
						}
						case '.':{
							flag=3;
							break;
						}
						case 'e':
						{
							flag=4;
							break;
						}
						default: {
							System.out.println("case 2 error");
							return false;
						}
					}
					break;
				}
				case 3:{
					switch (ch) {
						case '0':
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
						case '9': {
							break;
						}
						case 'e':
						{
							flag = 4;
							break;
						}
						default: {
							System.out.println("case 3 error");
							return false;
						}
					}
					break;
				}
				case 4:{
					switch (ch) {
						case '0':
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
						case '9': {
							flag=6;
							break;
						}
						case '+':
						case '-':{
							flag=5;
							break;
						}
						default: {
							System.out.println("case 4 error");
							return false;
						}
					}
					break;
				}
				case 5:{
					switch (ch) {
						case '0':
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
						case '9': {
							flag=6;
							break;
						}
						default: {
							System.out.println("case 5 error");
							return false;
						}
					}
					break;
				}
				case 6:{
					switch (ch) {
						case '0':
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
						case '9': {
							break;
						}
						default:{
							System.out.println("case 6 error");
							return false;
						}

					}
					break;
				}
				case 7:{
					switch (ch) {
						case '0':
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
						case '9': {
							flag=3;
							break;
						}
						default: {
							System.out.println("case 7 error");
							return false;
						}
					}
					break;
				}

			}
		}
		return flag == 2 || flag == 3 || flag == 6;
	}
}
public class JZoffer20 {
	public static void main(String []args){
		SolutionJZoffer20 sol =new SolutionJZoffer20();
		String str=" -.7e+0435";
		// "1 "
		System.out.println(sol.isNumber(str));
	}
}
