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
		//����10��Ͱ��ÿ��Ͱ������ݣ�ÿ��Ͱ����һά���飬�����������
		int[][] buckets=new int[10][arr.length];
		//��¼ÿ��Ͱ����˶��ٸ�����
		int[] bucketCounts=new int[10];
		//�ҳ���������ֵ
		int max=0;
		for(int i=0;i<arr.length;i++) {
			if(max<arr[i])max=arr[i];
		}
		//�ó�������ĳ���
		int length=(max+"").length();
		//1.��һ�����򣺰��ո�λ����ÿ��Ԫ�ط��벻ͬ��Ͱ
		
		//������������
		for(int i=0,n=1; i<length;i++,n*=10) {
			int index=0;
			for(int j=0;j<arr.length;j++) {
				//��ÿ�����ݵĸ�λ��
				int temp=arr[j] / n %10;
				//bucketCounts[temp] ����¼temp��Ͱ����˶��ٸ����ݡ���ʼ��Ϊ0��ͰԪ��������Ӧÿ��Ͱ��Ԫ�ر�š�
				buckets[temp][bucketCounts[temp]]=arr[j];
				//bucketCounts[temp] ����¼temp��Ͱ����˶��ٸ����ݣ�+1 ��ʾ��Ͱ��һ������
				bucketCounts[temp]++;
			}
			//��Ͱ��ȡ������
			//����ÿ��Ͱ
			for(int j=0; j<bucketCounts.length;j++) {
				//�ж�ͰԪ�ص������Ƿ�Ϊ��
				if(bucketCounts[j]!=0) {
					//����Ͱ��ÿһ��Ԫ�أ���˳��浽ԭ��������arr�С�
					for(int k=0; k<bucketCounts[j];k++) {
						//index��ԭ�����±�
						//k����ʾͰ��ĳһ��Ԫ��
						arr[index]=buckets[j][k];
						index++;
					} 
					bucketCounts[j]=0;
				}
				
			}
			 
		}
		
		System.out.println("��һ�������" + Arrays.toString(arr));
	}

}
