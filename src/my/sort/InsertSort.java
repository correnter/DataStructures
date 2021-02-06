package my.sort;

public class InsertSort {
	public static void main(String[] args) {
		int[] arr= {2,5,12,2,6,22,11,99,3};
		sort(arr);
		for(int data: arr) {
			System.out.println(data);
		}
	}
	public static void sort(int[] arr) {
		int length=arr.length;
		int insertIndex=0;
		int insertValue=0;
		//要求从小到大排序。
		for(int i=1; i<length; i++) {
			//insertIndex: 要插入的可能位置，这里指向了有序表的最后一位。
			insertIndex=i-1;
			//insertValue: 表示无序表插入到有序表的一个元素值。
			insertValue=arr[i];
			//这个while循环找到要插入的元素的位置在哪。具体坐标的为insertIndex.
			//insertIndex>=0 :表示已经到了有序表的表头了。前面没有元素了。
			//insertValue<arr[insertIndex]：表示要插入的值比有序表的arr[insertIndex]的值小-->
			//这里要找到 一个位置：就是插入元素的值比某一元素大的时候，退出该循环。即 insertValue>=arr[insertIndex]
			//即找到了要插入的位置，坐标为insertIndex.
			while(insertIndex>=0 && insertValue <arr[insertIndex]) {
				//值向后移动一位。
				arr[insertIndex+1]=arr[insertIndex];
				//坐标向前移动一位
				insertIndex--;
			}
			//当无序表本身就是最大元素时，就不用进行操作。
			if(insertIndex+1 != i) {
				arr[insertIndex+1]=insertValue;
			} 
		}
		
	}
}
