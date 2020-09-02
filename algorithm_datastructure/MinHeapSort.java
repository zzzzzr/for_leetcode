package algorithm_datastructure;
import java.util.*;

class Minheap{
	int length;
	int []nums;
	// 数组下标从0开始，到length结束

	public Minheap(int []a){
		this.nums = new int[a.length+1];
		System.arraycopy(a,0,nums,1,a.length);
		this.length = a.length;
	}

//	public Minheap(){
//		this.length=0;
//		this.nums = new int[1];
//	}

	// 构建小顶堆
	// 从最后一个父节点开始，一个一个调整子树的大小关系让他们满足小顶堆的定义
	// 当倒数第一层的父节点都调整完之后，调整倒数第二层的父节点，adjust函数要求下面的子树都满足小顶堆的定义，而前面的工作会让这个条件成立
	public void build(){
		for (int i=length/2;i>=1;i--){
			adjustheap(i);
		}
		//System.out.println(Arrays.toString(nums));
	}

	// 自节点k开始向下调整以k为根节点的子树
	// 这个过程只是在大体符合小顶堆的前提下，对当前可能不满足小顶堆条件的节点k进行调整
	// 把节点k调整到他所在的子树中合适的位置
	// 但这种调整在每次分叉时只会涉及到一个子树，另一个子树剩下的部分是否合法并不考虑
	// 所以不能只用这一个函数解决对小顶堆的调整
	public void adjustheap(int k){
		int temp = nums[k];
		for (int i=2*k;i<=length;i=i*2){
			if (i+1<=length && nums[i+1]<nums[i])
				i++;
			if (nums[i]<temp) {
				nums[k] = nums[i];
				k = i;
			}
			else
				break;
		}
		nums[k] = temp;
	}

	public void adjustheap(int k,int end){
		int temp = nums[k];
		for (int i=2*k;i<=end;i=i*2){
			if (i+1<=end && nums[i+1]<nums[i])
				i++;
			if (nums[i]<temp) {
				nums[k] = nums[i];
				k = i;
			}
			else
				break;
		}
		nums[k] = temp;
	}

	public int[] sort(){
		int size = length;
		build();
		while(size>=1){
			swap(1,size);
			size--;
			adjustheap(1,size);
		}
		return nums;
	}


	public void swap(int index1,int index2){
		int temp = nums[index1];
		nums[index1] = nums[index2];
		nums[index2] = temp;
	}
}


//class HeapSort {
//	public static void main(String []args){
//		int []arr = {7,6,7,11,5,12,3,0,1};
//		System.out.println("排序前："+Arrays.toString(arr));
//		sort(arr);
//		System.out.println("排序前："+Arrays.toString(arr));
//	}
//
//	public static void sort(int []arr){
//		//1.构建大顶堆
//		for(int i=arr.length/2-1;i>=0;i--){
//			//从第一个非叶子结点从下至上，从右至左调整结构
//			adjustHeap(arr,i,arr.length);
//		}
//		//2.调整堆结构+交换堆顶元素与末尾元素
//		for(int j=arr.length-1;j>0;j--){
//			swap(arr,0,j);//将堆顶元素与末尾元素进行交换
//			adjustHeap(arr,0,j);//重新对堆进行调整
//		}
//
//	}
//
//	/**
//	 * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
//	 * @param arr
//	 * @param i
//	 * @param length
//	 */
//	public static void adjustHeap(int []arr,int i,int length){
//		int temp = arr[i];//先取出当前元素i
//		for(int k=i*2+1;k<length;k=k*2+1){//从i结点的左子结点开始，也就是2i+1处开始
//			if(k+1<length && arr[k]<arr[k+1]){//如果左子结点小于右子结点，k指向右子结点
//				k++;
//			}
//			if(arr[k] >temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
//				arr[i] = arr[k];
//				i = k;
//			}else{
//				break;
//			}
//		}
//		arr[i] = temp;//将temp值放到最终的位置
//	}
//
//	/**
//	 * 交换元素
//	 * @param arr
//	 * @param a
//	 * @param b
//	 */
//	public static void swap(int []arr,int a ,int b){
//		int temp=arr[a];
//		arr[a] = arr[b];
//		arr[b] = temp;
//	}
//}

public class MinHeapSort {
	public static void main(String []args){
		int[]nums = new int[]{2,4,8,3,1,5,7,6,9};
		Minheap heap = new Minheap(nums);
		//HeapSort hs = new HeapSort();
		System.out.println(Arrays.toString(heap.sort()));

	}
}
