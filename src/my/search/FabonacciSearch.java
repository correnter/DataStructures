package my.search;

public class FabonacciSearch {
	static int maxSize=20;
	public static void main(String[] args) {
		int[] arr= {
				1,2,4,6,7,9,11
		};
		int index=fibSearch(arr,11);
		System.out.println(index);
	}
	public static int[] fib() {
		int[] fib=new int[maxSize];
		fib[0]=1;
		fib[1]=1;
		for(int i=2;i<fib.length;i++) {
			fib[i]=fib[i-1]+fib[i-2];
		}
		return fib;
	}
	/**
	 * 
	 * @param arr 数组
	 * @param val 目标值
	 * @return 找到了就返回下标，没找到就返回-1
	 */
	public static int fibSearch(int[] arr, int val) {
		int low=0;
		int high=arr.length-1;
		int[] fib=fib();
		int k=0;
		while(high+1>fib[k]) {
			k++;
		}
		while(low<=high) {
			int mid=low+fib[k-1]-1;
			if(val<arr[mid]) {
				high=mid-1;
				k--;
			}else if(val>arr[mid]) {
				low=mid+1;
				k-=2;
			}else {
				if(mid<=high) {
					return mid;
				}else {
					return high;
				}
			}
		}
		return -1;
	}
}
