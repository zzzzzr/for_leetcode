import java.util.*;
class SolutionJZoffer40 {
	public int[] getLeastNumbers(int[] arr, int k) {
		Arrays.sort(arr);
		return Arrays.copyOfRange(arr,0,k);
		//return new int[k]{arr.}
	}
}
public class JZoffer40 {
}
