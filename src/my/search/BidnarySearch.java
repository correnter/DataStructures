package my.search;

import java.util.ArrayList;
import java.util.List;

public class BidnarySearch {
	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5,9,10,10,10,10,20,92,200};
		//int index=search(arr,0,arr.length-1,200);
		List<Integer> resList=search2(arr,0,arr.length-1,10);
		System.out.println("index===>"+resList.toString());
		
	}
	/*
	 * left��Ѱ���������߽�
	 * right: Ѱ��������ұ߽�
	 * val:Ŀ��ֵ
	 */
	private static List<Integer> search2(int[] arr, int left, int right, int val) {
		// TODO Auto-generated method stub
		if(left>right) {
			return new ArrayList<>();
		}
		int mid=(left+right)/2;
		if(val>arr[mid]) {
			return search2(arr,mid+1,right,val);
		}else if(val<arr[mid]) {
			return search2(arr,left,mid-1,val);
		}else if(val==arr[mid]) {
			List<Integer> resList=new ArrayList<>();
			resList.add(mid);
			//��������ͬ��ֵ��
			int temp=mid;
			temp++;
			while(true) {
				if(temp>right || arr[temp]!=val) {
					//��������ҵĹ����У�mid����������ұ߽磬���� arr[mid]��ֵ������Ŀ��ֵ
					//������ѭ��
					break;
				}
				resList.add(temp);
				temp++;
			}
			//��������ͬ��ֵ
			temp=mid;
			temp--;
			while(true) {
				if(temp<left || arr[temp]!=val) {
					//��������ҵĹ����У�mid������С�����ұ߽磬���� arr[mid]��ֵ������Ŀ��ֵ
					//������ѭ��
					break;
				}
				resList.add(temp);
				mid--;
				
			}
			return resList;
		}
		return new ArrayList<>();
	}
	//��С��������
	private static int search(int[] arr, int left, int right, int val) {
		//���û�ҵ���ȵ�ֵ���ͷ���-1,
		if(left>right) {
			return -1;
		}
		//����м�����
		int mid=(left+right)/2;
		if(val > arr[mid]) {
			//���ҵݹ�
			return search(arr,mid+1,right,val);
		}else if(val<arr[mid]) {
			//����ݹ�
			return search(arr,left,mid-1,val);
		}else if(val==arr[mid]){
			//�ҵ�Ŀ�귵������
			return mid;
		}
		return 0; 
	}
	
	
}
