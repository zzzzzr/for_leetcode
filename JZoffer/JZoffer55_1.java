package JZoffer;

import LeetcodeStructure.*;
import java.util.*;
class SolutionJZoffer55_1 {
	public int maxDepth(TreeNode root) {
		if(root==null){
			return 0;
		}
		else {
			return Math.max(maxDepth(root.left)+1,maxDepth(root.right)+1);
		}
	}
}
public class JZoffer55_1 {

}
