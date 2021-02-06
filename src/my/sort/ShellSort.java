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
			//gap��ʾÿ��Ԫ�صļ�ࡣ
			//���gap=2,��ô{0,2,4,6,8}��Ԫ��Ϊһ�飬 {1,3,5,7,9}��Ԫ��Ϊһ�顣����ʹ�ò��������������
			//���gap=5,��ô{0,5}һ�飬{1,6}һ�飬{2,7}һ�飬{3,8}һ�飬{4,9}һ�顣
			for(int i=gap; i<arr.length; i++) {  
				
				//1.һ��ʼ��i=2,�����ֻ�� 0��Ԫ�أ� �������2,4,6��8��Ԫ�ء�
				//2.insertIndex: Ҫ����Ŀ���λ�ã�����ָ�������������һλ�� һ��ʼָ����0
				//3. insertValue: ��ʾ�������뵽������һ��Ԫ��ֵ�� 
				insertIndex=i-gap; 
				insertVal=arr[i];
				//���whileѭ���ҵ�Ҫ�����Ԫ�ص�λ�����ġ����������ΪinsertIndex.
				//insertIndex>=0 :��ʾ�Ѿ����������ı�ͷ�ˡ�ǰ��û��Ԫ���ˡ�
				//insertValue<arr[insertIndex]����ʾҪ�����ֵ��������arr[insertIndex]��ֵС-->
				//����Ҫ�ҵ� һ��λ�ã����ǲ���Ԫ�ص�ֵ��ĳһԪ�ش��ʱ���˳���ѭ������ insertValue>=arr[insertIndex]
				//���ҵ���Ҫ�����λ�ã�����ΪinsertIndex+gap.
				while(insertIndex>=0 && insertVal<arr[insertIndex]) {
					//���������ƶ�һλ�����gapΪ5��2��1�� gap��ʾÿ��Ԫ�صļ�ࡣ
					arr[insertIndex+gap]=arr[insertIndex];
					insertIndex-=gap;
				}
				//���������������Ԫ��ʱ���Ͳ��ý��в�����
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
