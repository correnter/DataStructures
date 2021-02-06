package my.search;

public class SeqSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,40,29,20,59,39};
		int index=search(arr,20);
		System.out.println("index===>"+index);
	}

	private static int search(int[] arr, int val) {
		// TODO Auto-generated method stub
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==val) {
				return i;
			}
		}
		return -1;
	}

}
