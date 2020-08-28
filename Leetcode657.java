import java.util.*;
class Solution657 {
	public boolean judgeCircle(String moves) {
		if (moves.length()<=0)
			return true;
		int lr=0;
		int ud=0;
		char []move = moves.toCharArray();
		for (char ch:move){
			switch (ch){
				case 'L':
				{
					lr--;
					break;
				}
				case 'R':
				{
					lr++;
					break;
				}
				case 'U':{
					ud++;
					break;
				}
				case 'D':{
					ud--;
					break;
				}
			}
		}
		return lr==0&&ud==0;
	}
}
public class Leetcode657 {
}
