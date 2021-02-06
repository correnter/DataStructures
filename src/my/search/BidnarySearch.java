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
	 * left：寻找区间的左边界
	 * right: 寻找区间的右边界
	 * val:目标值
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
			//向右找相同的值。
			int temp=mid;
			temp++;
			while(true) {
				if(temp>right || arr[temp]!=val) {
					//如果向右找的过程中，mid的坐标大于右边界，或者 arr[mid]的值不等于目标值
					//就跳出循环
					break;
				}
				resList.add(temp);
				temp++;
			}
			//向左找相同的值
			temp=mid;
			temp--;
			while(true) {
				if(temp<left || arr[temp]!=val) {
					//如果向右找的过程中，mid的坐标小于于右边界，或者 arr[mid]的值不等于目标值
					//就跳出循环
					break;
				}
				resList.add(temp);
				mid--;
				
			}
			return resList;
		}
		return new ArrayList<>();
	}
	//从小到大排序
	private static int search(int[] arr, int left, int right, int val) {
		//如果没找到相等的值，就返回-1,
		if(left>right) {
			return -1;
		}
		//获得中间坐标
		int mid=(left+right)/2;
		if(val > arr[mid]) {
			//向右递归
			return search(arr,mid+1,right,val);
		}else if(val<arr[mid]) {
			//向左递归
			return search(arr,left,mid-1,val);
		}else if(val==arr[mid]){
			//找到目标返回坐标
			return mid;
		}
		return 0; 
	}
	
	
}
