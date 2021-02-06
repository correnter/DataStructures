package my.tree;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {
				4,6,8,5,9,
		};
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	public static void heapSort(int arr[]) {
		int temp=0;
		//�������һ����������� ת��Ϊһ���󶥶ѡ�
		for(int i=arr.length/2-1;i>=0;i--) {
			adjustHeap(arr,i,arr.length);
		}
		//���������������ֵ��Ҳ���Ǵ󶥶ѵ�ͷ��������ĩβnԪ�ؽ��н�����
		//ÿһ�ν�����ĩβ�������ֵ���ڶ�ʣ���n-1��Ԫ�ؽ�������-->
		//���ڽ�����󣬴󶥶ѿ��ܱ�Ϊ����Ķӡ�������Ҫ�ڴ����򣬱�Ϊ�󶥶ѡ�
		//Ȼ���ٽ��󶥶ѵ�ͷ�����ֵ���n-1��Ԫ�ؽ���,�ظ�������̣�ֱ������Ԫ�ص�����
		for(int j=arr.length-1;j>0;j--) {
			temp=arr[j];
			arr[j]=arr[0];
			arr[0]=temp;
			adjustHeap(arr,0,j);
		}
		
		
	}
	/**
	 * 
	 * @param arr ����
	 * @param i ��Ҷ�ӽ������
	 * @param length ���������ĳ���
	 */
	public static void adjustHeap(int[] arr,int i,int length) {
		//�Ƚ���i����Ҷ�ӽ���ֵ����
		int temp=arr[i];
		//�ҵ� ��i����Ҷ�ӽ��������ӽڵ�
		for(int k=2*i+1; k<length;k=2*k+1) {
			//������ӽڵ�С�����ӽڵ㣬��k=k+1��
			if(k+1<length && arr[k]<arr[k+1]) {
				k++;
			}
			//�������ӽڵ��е����ֵ��temp���ڵ㣨Ҳ���ǵ�i����Ҷ�ӽ�㣩���бȽϣ�
			//���ӽڵ��ֵ���ڸ��ڵ��ֵ������н���������ֱ���˳�ѭ����
			//��Ϊ���ѭ���Ǵ����ң����ϵ��½��������
			if(temp<arr[k]) {
				arr[i]=arr[k];
				//��¼��i����Ҷ�ӽ�����һ����Ҷ�ӽ���ֵ��
				i=k;
			}else {
				break;
			}
			arr[k]=temp;
			//�ڽ�Ҷ�ӽ���ֵ��λ��Ҷ�ӽ���ֵ��
		}
	}
}
