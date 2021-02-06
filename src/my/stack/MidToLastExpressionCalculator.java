package my.stack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;

public class MidToLastExpressionCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String expression = "1+2*3+(3+3)*3+11";
		List<String> midList = MidToList(expression);
		List<String> lastList = MidToLast(midList);
		System.out.println(midList);
		System.out.println(lastList);
	}

	private static List<String> MidToLast(List<String> midList) {
		// TODO Auto-generated method stub
		int size = midList.size();
		Stack<String> operStack = new Stack<String>();
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < size; i++) {
			String val = midList.get(i);
			if (val.matches("\\d+")) {
				result.add(val);
			} else if (isOper(val)) {
				while (true) {
					if (operStack.size() == 0)
						break;
					if (priority(val) <= priority(operStack.peek())) {
						String peek = operStack.pop();
						result.add(peek);
					} else {
						break;
					}
				}
				operStack.push(val);
			} else if (val.equals("(")) {
				operStack.push(val);
			} else if (val.equals(")")) {
				while (true) {
					String peek = operStack.pop();
					if (peek.equals("(")) {
						break;
					}
					result.add(peek);
				}

			}
		}
		while(operStack.size()!=0) {
			result.add(operStack.pop());
		}
		return result;
	}

	private static boolean isOper(String val) {
		// TODO Auto-generated method stub
		return val.equals("*") || val.equals("/") || val.equals("+") || val.equals("-");
	}

	private static int priority(String val) {
		if (val.equals("*") || val.equals("/")) {
			return 2;
		} else if (val.equals("+") || val.equals("-")) {
			return 1;
		}
		return 0;
	}

	private static List<String> MidToList(String expression) {
		// TODO Auto-generated method stub
		int length = expression.length();
		char ch;
		String temp = "";
		List<String> midList = new ArrayList<>();
		for (int i = 0; i < length;) {
			if (expression.charAt(i) < 48 || expression.charAt(i) > 57) {
				midList.add(expression.charAt(i) + "");
				i++;
			} else {
				temp = "";
				while (i < length && expression.charAt(i) >= 48 && expression.charAt(i) <= 57) {
					temp += expression.charAt(i) + "";
					i++;
				}
				midList.add(temp);

			}
		}
		return midList;
	}

}
