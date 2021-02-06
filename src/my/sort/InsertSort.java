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
		//Ҫ���С��������
		for(int i=1; i<length; i++) {
			//insertIndex: Ҫ����Ŀ���λ�ã�����ָ�������������һλ��
			insertIndex=i-1;
			//insertValue: ��ʾ�������뵽������һ��Ԫ��ֵ��
			insertValue=arr[i];
			//���whileѭ���ҵ�Ҫ�����Ԫ�ص�λ�����ġ����������ΪinsertIndex.
			//insertIndex>=0 :��ʾ�Ѿ����������ı�ͷ�ˡ�ǰ��û��Ԫ���ˡ�
			//insertValue<arr[insertIndex]����ʾҪ�����ֵ��������arr[insertIndex]��ֵС-->
			//����Ҫ�ҵ� һ��λ�ã����ǲ���Ԫ�ص�ֵ��ĳһԪ�ش��ʱ���˳���ѭ������ insertValue>=arr[insertIndex]
			//���ҵ���Ҫ�����λ�ã�����ΪinsertIndex.
			while(insertIndex>=0 && insertValue <arr[insertIndex]) {
				//ֵ����ƶ�һλ��
				arr[insertIndex+1]=arr[insertIndex];
				//������ǰ�ƶ�һλ
				insertIndex--;
			}
			//���������������Ԫ��ʱ���Ͳ��ý��в�����
			if(insertIndex+1 != i) {
				arr[insertIndex+1]=insertValue;
			} 
		}
		
	}
}
