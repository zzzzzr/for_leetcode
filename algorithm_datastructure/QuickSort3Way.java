package algorithm_datastructure;

public class QuickSort3Way {
	public static void quickSort3(int []num, int start, int end){
		if (end-start<=15){
			InsertSort.sort(num, start, end);
			return;
		}
		swap(num, start, (int)( Math.random()*(end-start+1)+start) );   // 随机为数组段第一个量交换出一个值
		int pivot = num[start];         // 枢轴量 哨兵 被比较的值
		int lt = start+1;               // [start+1, lt]
		int gt = end;                   // [gt, end]
		int i = start+1;                // [lt+1, gt-1]
		// lt gt 指向将要赋值的位置
		while (i <= gt){
			if ( num[i] < pivot ){
				swap(num, i, lt);
				lt++;
				i++;
			} else if ( num[i] > pivot ){
				swap(num, i, gt);
				gt--;
			} else {
				i++;
			}
		}
		swap(num, start, lt-1);

		quickSort3(num, start, lt-2);
		quickSort3(num, gt+1, end);
	}

	public static void swap(int[] num, int a, int b){
		int temp = num[a];
		num[a]=num[b];
		num[b]=temp;
	}
}
