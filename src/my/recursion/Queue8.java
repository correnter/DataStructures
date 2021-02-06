package my.recursion;

public class Queue8 {
	int max=8;
	int[] array=new int[max];
	static int count=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Queue8 queue8=new Queue8();
		 queue8.check(0);
		 System.out.println("count:"+count);
	}
	public  void check(int n) {
		if(n==8) {
			print();
			return;
		}

		for(int i=0;i<max;i++) {
			array[n]=i;
			if(judge(n)) {
				check(n+1);
			}
		}
	}
	/**
	 * 
	 * @param n ��ʾ�ڼ������ڼ��еģ��Ļʺ�
	 * @return �ж��Ƿ���ͬһ�У�ͬһб�ߡ�
	 */
	private  boolean judge(int n) {
		
		// TODO Auto-generated method stub
		for(int i=0;i<n;i++) {
			if(array[i]== array[n] || Math.abs(n-i) ==Math.abs(array[n]-array[i])) {
				return false;
			}
		}
		return true;
	}
	private  void print() {
		count++;
		// TODO Auto-generated method stub
		for(int i=0; i<array.length;i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
}
