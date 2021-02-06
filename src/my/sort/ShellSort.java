package my.sort;

import java.util.Arrays;

public class ShellSort {
	public static void main(String[] args) {
		int[] arr= {1,2,5,6,3,7,4,0,9,8,20,50,38,28,27,19,48,29,21,23,47};
		//sort(arr);
		sort2(arr);
	}
	private static void sort2(int[] arr) {
		// TODO Auto-generated method stub
		int temp=0; 
		int insertIndex=0;  
		int insertVal=0;
		for(int gap=arr.length/2; gap>0; gap/=2) {
			//gap表示每隔元素的间距。
			//如果gap=2,那么{0,2,4,6,8}号元素为一组， {1,3,5,7,9}号元素为一组。，并使用插入排序进行排序。
			//如果gap=5,那么{0,5}一组，{1,6}一组，{2,7}一组，{3,8}一组，{4,9}一组。
			for(int i=gap; i<arr.length; i++) {  
				
				//1.一开始，i=2,有序表只有 0号元素， 无序表有2,4,6，8号元素。
				//2.insertIndex: 要插入的可能位置，这里指向了有序表的最后一位。 一开始指向了0
				//3. insertValue: 表示无序表插入到有序表的一个元素值。 
				insertIndex=i-gap; 
				insertVal=arr[i];
				//这个while循环找到要插入的元素的位置在哪。具体坐标的为insertIndex.
				//insertIndex>=0 :表示已经到了有序表的表头了。前面没有元素了。
				//insertValue<arr[insertIndex]：表示要插入的值比有序表的arr[insertIndex]的值小-->
				//这里要找到 一个位置：就是插入元素的值比某一元素大的时候，退出该循环。即 insertValue>=arr[insertIndex]
				//即找到了要插入的位置，坐标为insertIndex+gap.
				while(insertIndex>=0 && insertVal<arr[insertIndex]) {
					//有序表向后移动一位，间距gap为5，2，1， gap表示每隔元素的间距。
					arr[insertIndex+gap]=arr[insertIndex];
					insertIndex-=gap;
				}
				//当无序表本身就是最大元素时，就不用进行操作。
				if(insertIndex+gap != i) {
					arr[insertIndex+gap]=insertVal;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	private static void sort(int[] arr) {
		// TODO Auto-generated method stub
		int temp=0;
		for(int gap=arr.length/2; gap>0; gap/=2) {
			for(int i=gap; i<arr.length;i++) {
				for(int j=i-gap; j>=0;j-=gap) {
					if(arr[j] > arr[j+gap]) {
						temp=arr[j];
						arr[j]=arr[j+gap];
						arr[j+gap]=temp;
					}
				}
			}
		}
		
		
		
	}
}
