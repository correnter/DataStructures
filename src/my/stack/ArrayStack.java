package my.stack;

public class ArrayStack {
	private int maxSize;
	private Object[] stack;
	private int top;
	public ArrayStack(int size) {
		this.maxSize=size;
		this.stack=new Object[this.maxSize];
		top=-1;
	}
	public boolean isEmpty() {
		return top == -1;
	}
	public boolean isFull() {
		return top == maxSize-1;
	}
	public synchronized void push(Object data) {
		if(isFull()) {
			System.out.println("Õ»Âú");
			return;
		}
		top++;
		stack[top]=data;
	}
	public synchronized Object pop() {
		if(isEmpty()) {
			throw new RuntimeException("Õ»¿Õ");
		}
		Object result=stack[top];
		top--;
		return result;
	}
	public Object head() {
		if(isEmpty()) {
			throw new RuntimeException("Õ»¿Õ");
		}
		return stack[top];
	}
	public void show() {
		if(isEmpty()) {
			System.out.println("Õ»¿Õ");
			return;
		}
		for(int i=top;i>=0;i--) {
			System.out.println(stack[i].toString()); 
		}
	}
}
