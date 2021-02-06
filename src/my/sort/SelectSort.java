package my.sort;

public class SelectSort {
	public static void main(String[] args) {
		int[] arr= {2,5,12,2,6,22,11,99,3};
		sort(arr);
		for(int data: arr) {
			System.out.println(data);
		}
	}
	private static void sort(int[] arr) {
		int length=arr.length;
		//存最小值
		int min=0;
		// k 用于存最小值的坐标
		for(int i=0; i<length-1;i++) {
			int k=i;
			min=arr[i];
			for(int j=i+1;j<length;j++) {
				if(min>arr[j]) {
					//找到最小值，记录最小值和下标
					min=arr[j];
					k=j;
				}
			} 
			//k与i相等，说明，最小值就是他自己。
			if(k!=i) {
				arr[k]=arr[i];
				arr[i]=min;
			}
		
			
		}

	}
}
