package my.queue;

import java.util.Scanner;

public class CircleQueueTest {
	public static void main(String[] args) {
		CircleQueue queue=new CircleQueue(4);
		
		boolean flag=true;
		Scanner scan=new Scanner(System.in);
		char item=' ';
		while(flag) {
			System.out.println("show--->s");
			System.out.println("add---->a");
			System.out.println("get--->g");
			System.out.println("head--->h");
			System.out.println("exit--->e");
			String s=scan.next();
			item=s.charAt(0);
			switch(item) {
				case 's':
					queue.show();
					break;
				case 'a':
					System.out.println("请输入数据");
					int val=scan.nextInt();
					queue.addQueue(val);
					break;
				case 'g':
					try {
						int top=queue.getQueue();
						System.out.println("取出头数据："+top);
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case 'h':
					try {
						int topTmp=queue.getHead();
						System.out.println("查看头数据："+topTmp);
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case 'e':
					flag=false;
					scan.close();
					break;
				default :
					break;
			}
		}
	}
}
