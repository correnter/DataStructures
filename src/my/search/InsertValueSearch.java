package my.search;

public class InsertValueSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,3,4,5,9,10,20,92,200};
		int index=search(arr,0,arr.length-1,200);
		System.out.println("index===>"+index);
	}
	/**
	 * 注意：该数组已经从小到大排序
	 * @param arr 数组
	 * @param left 区间的左边界
	 * @param right 区间的右边界
	 * @param val 目标值
	 * @return 找的到目标值，则返回下标，否则返回-1
	 */
	private static int search(int[] arr, int left, int right, int val) {
		// TODO Auto-generated method stub
		//left>right：判断区间的左边界是否大有边界，大于则结束
		// val<arr[0]： 判断目标值是否小于数组的最小值，小于则结束
		//val>arr[arr.length-1]: 判断目标值是否大于数组的最大值，大于则结束。
		//原因：val参与mid值运算，如果val值巨大，则得出的mid值太大，直接越界。
		if(left>right || val<arr[0] || val>arr[arr.length-1] ) {
			return -1;
		}
		//mid的自适应算法。
		int mid= left+(right-left) * (val-arr[left]) / (arr[right] - arr[left] );
		//数组mid元素的值
		int midVal=arr[mid];
		if(val>midVal) {
			//向右递归查找
			return search(arr,mid+1,right,val);
		}else if(val<midVal) {
			//向左递归查找
			return search(arr,left,mid-1,val);
		}else if(val==midVal) {
			return mid;
		}
		return 0;
	}
	
}
