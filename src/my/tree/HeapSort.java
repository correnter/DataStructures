package my.tree;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {
				4,6,8,5,9,
		};
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	public static void heapSort(int arr[]) {
		int temp=0;
		//在这里，将一个无需的数组 转化为一个大顶堆。
		for(int i=arr.length/2-1;i>=0;i--) {
			adjustHeap(arr,i,arr.length);
		}
		//在这里，将数组的最大值，也就是大顶堆的头顶和数组末尾n元素进行交换，
		//每一次交换后，末尾就是最大值，在对剩余的n-1个元素进行排序-->
		//由于交换完后，大顶堆可能变为无需的队。所以需要在此排序，变为大顶堆。
		//然后再将大顶堆的头部最大值与第n-1个元素交换,重复这个过程，直到所有元素的排完
		for(int j=arr.length-1;j>0;j--) {
			temp=arr[j];
			arr[j]=arr[0];
			arr[0]=temp;
			adjustHeap(arr,0,j);
		}
		
		
	}
	/**
	 * 
	 * @param arr 数组
	 * @param i 非叶子结点的序号
	 * @param length 排序的数组的长度
	 */
	public static void adjustHeap(int[] arr,int i,int length) {
		//先将第i个非叶子结点的值保存
		int temp=arr[i];
		//找到 第i个非叶子结点的两个子节点
		for(int k=2*i+1; k<length;k=2*k+1) {
			//如果左子节点小于又子节点，则k=k+1。
			if(k+1<length && arr[k]<arr[k+1]) {
				k++;
			}
			//将两个子节点中的最大值与temp父节点（也就是第i个非叶子结点）进行比较，
			//若子节点的值大于父节点的值，则进行交换，否则直接退出循环，
			//因为这个循环是从左到右，从上到下进行排序的
			if(temp<arr[k]) {
				arr[i]=arr[k];
				//记录第i个非叶子结点的下一个非叶子结点的值。
				i=k;
			}else {
				break;
			}
			arr[k]=temp;
			//在将叶子结点的值换位非叶子结点的值。
		}
	}
}
