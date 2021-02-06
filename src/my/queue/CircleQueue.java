package my.queue;

public class CircleQueue {
	
	private int maxSize;
	//指向队列的第一个元素
	private int front;
	//指向队列的最后一个元素的后一位
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
			System.out.println("队列已经满了");
			return;
		}
		arr[rear]=val;
		rear=(rear+1)%maxSize;
	}
	public int getQueue() {
		if(this.isEmpty()) {
			throw new RuntimeException("队列是空的，无法取数据");
		}
		int temp=arr[front];
		front=(front+1)%maxSize;
		return temp;
	}
	public int getHead() {
		if(this.isEmpty()) {
			throw new RuntimeException("队列是空的，无法取数据");
		}
		return arr[front];
	}
	
	public void show() {
		if(this.isEmpty()) {
			System.out.println("队列是空的，无法取数据");
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
