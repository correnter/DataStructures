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
		//����ĳ���Ϊlength,һ����Ҫlength-1������i+1��ʾ�ڼ�������
		//j��ʾ��������꣬���ڱȽϣ�������λ�ã�ֻ��Ҫ�Ƚ�length-i-1�Σ��������Сֵ���ڵ�length-i-1λ��
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
				System.out.println("�Ѿ���������ֱ���ж�����");
				break;
			}else{
				flag=true;
			}
		}
	}
}
