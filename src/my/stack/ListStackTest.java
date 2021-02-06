package my.stack;

import java.util.Scanner;

public class ListStackTest {
	public static void main(String[] args) {
		ListStack as=new ListStack(5);
		Scanner scanner=new Scanner(System.in);
		boolean flag=true;
		while(flag) {
			System.out.println("1.show stack");
			System.out.println("2.push stack");
			System.out.println("3.pop stack");
			System.out.println("4.exit stack");
			System.out.println("5.head stack");
			String s=scanner.next();
			switch(s) {
				case "show":{
					as.show();
					break;
				}
				case "push":{
					System.out.println("请输入数据：");
					String content=scanner.next();
					as.push(content);
					break;
				}
				case "pop":{
					try {
						Object result=as.pop();
						System.out.println("出栈"+result);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					};
					break;
				}
				case "exit":{
					scanner.close();
					flag=false;
					break;
				}
				case "head":{
					Object result=as.getTop();
					System.out.println(result.toString());
					break;
				}
			}
		}
	}
}
