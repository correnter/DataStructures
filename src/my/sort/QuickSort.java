package my.sort;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] arr= {-1,39,49,20,59,-5};
		sort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

	private static void sort(int[] arr, int left, int right) {
		// TODO Auto-generated method stub
		int l=left;
		int r=right;
		int pivot=arr[(left+right)/2];
		int temp=0;
		while(l<r) {
			while(arr[l]<pivot) {
				l+=1;
			}
			while(arr[r]>pivot) {
				r-=1;
			}
			if(l>=r) {
				break;
			}
			
			temp=arr[l];
			arr[l]=arr[r];
			arr[r]=temp;
			if(arr[l] == pivot) { r -= 1; }
			if(arr[r] == pivot) { l += 1; }
			
		}
		if(l==r) {
			l+=1;
			r-=1;
		}
//		if(left<r) {
//			sort(arr,left,r);
//		}
//		if(right>l) {
//			sort(arr,l,right);
//		}
		if(left < r) { sort(arr, left, r); }
		//ÏòÓÒµÝ¹é 
		if(right > l) { sort(arr, l, right); }
 	}
	
}
