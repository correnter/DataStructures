package my.queue;

public class ArrayQueue {
	private int maxSize;
	private int front;
	private int rear;
	private int[] arr;
	
	public ArrayQueue() {
		this.maxSize=10;
		arr=new int[this.maxSize];
		this.front=-1;
		this.rear=-1;
	}
	public ArrayQueue(int size) {
		this.maxSize=size;
		arr=new int[maxSize];
		this.front=-1;
		this.rear=-1;
	}
	
	public boolean isEmpty() {
		return rear==front;
	}
	public boolean isFull() {
		return rear==maxSize;
	}
	public void addQueue(int val) {
		if(this.isFull()) {
			System.out.println("�����Ѿ�����");
			return;
		}
		rear++;
		this.arr[rear]=val;
	}
	public int getQueue() {
		if(this.isEmpty()) {
			throw new RuntimeException("�����ǿյģ��޷�ȡ����");
		}
		front++;
		return arr[front];
	}
	public int getHead() {
		if(this.isEmpty()) {
			throw new RuntimeException("�����ǿյģ��޷�ȡ����");
		}
		return arr[front+1];
	}
	public void show() {
		if(this.isEmpty()) {
			System.out.println("�����ǿյģ��޷�ȡ����");
			return;
		}
		for(int i=0;i<maxSize;i++) {
			System.out.printf("%d\t", arr[i]);
		}
	}
}
