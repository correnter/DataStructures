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
		//����Сֵ
		int min=0;
		// k ���ڴ���Сֵ������
		for(int i=0; i<length-1;i++) {
			int k=i;
			min=arr[i];
			for(int j=i+1;j<length;j++) {
				if(min>arr[j]) {
					//�ҵ���Сֵ����¼��Сֵ���±�
					min=arr[j];
					k=j;
				}
			} 
			//k��i��ȣ�˵������Сֵ�������Լ���
			if(k!=i) {
				arr[k]=arr[i];
				arr[i]=min;
			}
		
			
		}

	}
}
