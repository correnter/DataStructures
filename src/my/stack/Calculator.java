package my.stack;

public class Calculator {
	public static void main(String[] args) {
		String experssion="3*28-1+5";
		ArrayStack2 numStack=new ArrayStack2(10);
		ArrayStack2 operStack=new ArrayStack2(10);
		int num1=0;
		int num2=0;
		char oper=0;
		char ch=' ';
		int result=0;
		int index=0;
		String keepStr="";
		while(true) {
			ch=experssion.charAt(index);
			if(isOper(ch)) {
				if(!operStack.isEmpty()) {
					if(priority(ch) <= priority((char) operStack.head())) {
						num1=(int) numStack.pop();
						num2=(int) numStack.pop();
						oper=(char) operStack.pop();
						result=calculate(num1, num2, oper);
						numStack.push(result);
						operStack.push(ch);
					}else {
						operStack.push(ch);
					}
				}else {
					operStack.push(ch);
				}
			}else {
			//	numStack.push(ch-48);
				keepStr+=ch;
				if(index+1==experssion.length()) {
					numStack.push(Integer.valueOf(keepStr));
				}else {
					char nextChar=experssion.charAt(index+1);
					if(isOper(nextChar)) {
						numStack.push(Integer.valueOf(keepStr));
						keepStr="";
					} 
				}
			}
			
			index++;
			if(index==experssion.length())break;
		}
		while(true) {
			if(operStack.isEmpty())break;
			num1=(int) numStack.pop();
			num2=(int) numStack.pop();
			oper=(char) operStack.pop();
			result=calculate(num1, num2, oper);
			numStack.push(result);
		}
		 
		System.out.println(experssion +" =======> "+numStack.pop());
		
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
class ArrayStack2 {
	private int maxSize;
	private Object[] stack;
	private int top;
	public ArrayStack2(int size) {
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
