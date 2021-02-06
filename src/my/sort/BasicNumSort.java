package my.sort;

import java.util.Arrays;

public class BasicNumSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {
			10,20,39,200,45,69,320,9,58,
		};
		sort(arr);
	}

	private static void sort(int[] arr) {
		// TODO Auto-generated method stub
		//这是10个桶，每个桶存放数据，每个桶都是一维数组，用来存放数据
		int[][] buckets=new int[10][arr.length];
		//记录每个桶存放了多少个数。
		int[] bucketCounts=new int[10];
		//找出数组的最大值
		int max=0;
		for(int i=0;i<arr.length;i++) {
			if(max<arr[i])max=arr[i];
		}
		//得出最大数的长度
		int length=(max+"").length();
		//1.第一轮排序：按照个位数将每个元素放入不同的桶
		
		//遍历所有数据
		for(int i=0,n=1; i<length;i++,n*=10) {
			int index=0;
			for(int j=0;j<arr.length;j++) {
				//得每个数据的个位数
				int temp=arr[j] / n %10;
				//bucketCounts[temp] ：记录temp号桶存放了多少个数据。初始化为0，桶元素数量对应每个桶的元素编号。
				buckets[temp][bucketCounts[temp]]=arr[j];
				//bucketCounts[temp] ：记录temp号桶存放了多少个数据，+1 表示该桶有一个数据
				bucketCounts[temp]++;
			}
			//从桶中取出数据
			//遍历每个桶
			for(int j=0; j<bucketCounts.length;j++) {
				//判断桶元素的数量是否为空
				if(bucketCounts[j]!=0) {
					//遍历桶的每一个元素，按顺序存到原来的数组arr中。
					for(int k=0; k<bucketCounts[j];k++) {
						//index：原数组下标
						//k：表示桶的某一个元素
						arr[index]=buckets[j][k];
						index++;
					} 
					bucketCounts[j]=0;
				}
				
			}
			 
		}
		
		System.out.println("第一轮排序后：" + Arrays.toString(arr));
	}

}
