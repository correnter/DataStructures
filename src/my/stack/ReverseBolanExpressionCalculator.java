package my.stack;

public class ReverseBolanExpressionCalculator {
	public static void main(String[] args) {
		String expression="34+5*6-";
		ArrayStack3 numStack=new ArrayStack3(10);
		int num1=0;
		int num2=0;
		char oper=' ';
		char ch=' ';
		int result=0;
		String keepStr="";
		int index=0;
		while(true) {
			if(index>=expression.length()) { 
				break;
			}
				
			ch=expression.charAt(index);
			if(isOper(ch)) {
				num1=(int) numStack.pop();
				num2=(int) numStack.pop();
				result=calculate(num1, num2, ch);
				numStack.push(result);
			}else {
				numStack.push(ch-48);
			}
			index++;
		}
	 
		System.out.println(expression +"=======>"+numStack.pop());
	}
	public static boolean isOper(char oper) {
		return oper=='*' || oper=='/' || oper=='-' || oper=='+';
	}
	public static int priority( char oper) {
		if(oper=='*' || oper=='/') {
			return 1;
		}else if(oper=='+' || oper=='-') {
			return 0;
		}else {
			return -1;
		}
	}
	public static int calculate(int num1,int num2,int oper) {
		int result=0;
		if(oper=='*') {
			result=num1*num2;
		}else if(oper=='/') {
			result=num2/num1;
		}else if(oper=='-') {
			result=num2-num1;
		}else if(oper=='+') {
			result=num2+num1;
		}
		return result;
	}
}
class ArrayStack3 {
	private int maxSize;
	private Object[] stack;
	private int top;
	public ArrayStack3(int size) {
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
