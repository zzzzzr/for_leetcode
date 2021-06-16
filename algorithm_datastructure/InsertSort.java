package algorithm_datastructure;

public class InsertSort {
	// [start, end)
	public static void sort(int[] a, int start, int end)
	{
		//将a[]按升序排列
		int N=end-start;
		for (int i=start;i<end;i++)
		{
			//将a[i]插入到a[i-1]，a[i-2]，a[i-3]……之中
			for(int j=i; j>start && a[j] < a[j-1] ; j--)
			{
				int temp=a[j];
				a[j]=a[j-1];
				a[j-1]=temp;
			}
		}
	}

}
