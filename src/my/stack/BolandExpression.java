package my.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BolandExpression {
	public static void main(String[] args) {
		String expression="3 4 + 5 * 6 -";
		List<String> elist=getList(expression);
		System.out.println(elist);
		int result=calculate(elist);
		System.out.println(" result====>"+result);
	}

	private static int calculate(List<String> elist) {
		// TODO Auto-generated method stub
		Stack<String> stack=new Stack<>();
		 
		for(String ex :elist) {
			if(ex.matches("\\d+")) {
				stack.push(ex);
			}else {
				int result=0;
				int num2=Integer.parseInt(stack.pop());
				int num1=Integer.parseInt(stack.pop());
				if(ex.equals("+")) {
					result=num1+num2;
				}else if(ex.equals("-")) {
					result=num1-num2;
				}else if(ex.equals("*")) {
					result=num1*num2;
				}else if(ex.equals("/")) {
					result=num1/num2;
				}else {
					throw new RuntimeException("×Ö·ûÓÐÎó");
				}
				stack.push(String.valueOf(result) );
			}
		}
		return Integer.parseInt(stack.pop());
	}
 
	private static List<String> getList(String expression) {
		// TODO Auto-generated method stub
		String[] expressions=expression.split(" ");
		List<String> elist=new ArrayList<>();
		for(String ex: expressions) {
			elist.add(ex);
		}
		return elist;
	}
}
