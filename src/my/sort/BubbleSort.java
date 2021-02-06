package my.sort;

public class BubbleSort {
	public static void main(String[] args) {
		int[] arr= {1,2,3,4,6};
		sort(arr);
		for(int data: arr) {
			System.out.println(data);
		}
	}
	public static void sort(int[] array) {
		int length=array.length;
		boolean flag=true;
		//数组的长度为length,一共需要length-1次排序。i+1表示第几次排序
		//j表示数组的坐标，相邻比较，逆序则换位置，只需要比较length-i-1次，结果将最小值放在第length-i-1位。
		for(int i=0; i<length-1; i++) {
			for(int j=0;j<length-i-1;j++) {
				if(array[j]>array[j+1]) {
					int k=array[j];
					array[j]=array[j+1];
					array[j+1]=k;
					flag=false;
				}
			}
			if(flag) {
				System.out.println("已经不用排序直接中断排序");
				break;
			}else{
				flag=true;
			}
		}
	}
}
