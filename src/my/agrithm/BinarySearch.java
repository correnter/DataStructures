package my.agrithm;

public class BinarySearch {
	public static void main(String[] args) {
		int[] arr= {
				1,2,4,5,6,8,10,20
		};
		BinarySearch bs=new BinarySearch();
		int result=bs.search(arr, 20);
		System.out.println(result);
	}
	/**
	 * 
	 * @param arr 從小到大排序的數組
	 * @param target 目標值
	 * @return
	 */
	public int search(int[] arr,int target) {
		int left=0;
		int right=arr.length;
		while(left<=right) {
			int mid=(left+right)/2;
			if(arr[mid]==target) {
				return mid;
			}
			if(arr[mid]>target) {
				right=mid-1;
			}
			if(arr[mid]<target) {
				left=mid+1;
			}
		}
		return -1;
	}
}
