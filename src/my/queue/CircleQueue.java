package my.queue;

public class CircleQueue {
	
	private int maxSize;
	//ָ����еĵ�һ��Ԫ��
	private int front;
	//ָ����е����һ��Ԫ�صĺ�һλ
	private int rear;
	private int[] arr;
	public CircleQueue() {
		this.maxSize=10;
		arr=new int[this.maxSize];
		this.front=0;
		this.rear=0;
	}
	public CircleQueue(int size) {
		this.maxSize=size;
		arr=new int[maxSize];
		this.front=0;
		this.rear=0;
	}
	public boolean isEmpty() {
		return rear==front;
	}
	public boolean isFull() {
		return (rear+1)%maxSize == front;
	}
	
	public void addQueue(int val) {
		if(this.isFull()) {
			System.out.println("�����Ѿ�����");
			return;
		}
		arr[rear]=val;
		rear=(rear+1)%maxSize;
	}
	public int getQueue() {
		if(this.isEmpty()) {
			throw new RuntimeException("�����ǿյģ��޷�ȡ����");
		}
		int temp=arr[front];
		front=(front+1)%maxSize;
		return temp;
	}
	public int getHead() {
		if(this.isEmpty()) {
			throw new RuntimeException("�����ǿյģ��޷�ȡ����");
		}
		return arr[front];
	}
	
	public void show() {
		if(this.isEmpty()) {
			System.out.println("�����ǿյģ��޷�ȡ����");
			return;
		}
		for(int i=front;i<front+size();i++) {
			System.out.printf("%d\t", arr[i%maxSize]);
		}
		System.out.println();
	}
	private int size() {
		// TODO Auto-generated method stub
		return ( rear+maxSize-front )%maxSize;
	}
}
