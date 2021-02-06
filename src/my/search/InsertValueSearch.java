package my.search;

public class InsertValueSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,3,4,5,9,10,20,92,200};
		int index=search(arr,0,arr.length-1,200);
		System.out.println("index===>"+index);
	}
	/**
	 * ע�⣺�������Ѿ���С��������
	 * @param arr ����
	 * @param left �������߽�
	 * @param right ������ұ߽�
	 * @param val Ŀ��ֵ
	 * @return �ҵĵ�Ŀ��ֵ���򷵻��±꣬���򷵻�-1
	 */
	private static int search(int[] arr, int left, int right, int val) {
		// TODO Auto-generated method stub
		//left>right���ж��������߽��Ƿ���б߽磬���������
		// val<arr[0]�� �ж�Ŀ��ֵ�Ƿ�С���������Сֵ��С�������
		//val>arr[arr.length-1]: �ж�Ŀ��ֵ�Ƿ������������ֵ�������������
		//ԭ��val����midֵ���㣬���valֵ�޴���ó���midֵ̫��ֱ��Խ�硣
		if(left>right || val<arr[0] || val>arr[arr.length-1] ) {
			return -1;
		}
		//mid������Ӧ�㷨��
		int mid= left+(right-left) * (val-arr[left]) / (arr[right] - arr[left] );
		//����midԪ�ص�ֵ
		int midVal=arr[mid];
		if(val>midVal) {
			//���ҵݹ����
			return search(arr,mid+1,right,val);
		}else if(val<midVal) {
			//����ݹ����
			return search(arr,left,mid-1,val);
		}else if(val==midVal) {
			return mid;
		}
		return 0;
	}
	
}
