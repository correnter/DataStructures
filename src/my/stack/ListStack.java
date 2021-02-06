package my.stack;
/*
 * 基于带头结点链表实现的栈ListStack
 */

public class ListStack {
	private StackNode head=new StackNode("");
	private int maxSize;
	
	public ListStack(int maxSize) {
		this.maxSize = maxSize;
	}
	public boolean isFull() {
		StackNode temp=head;
		int count=0;
		while(true) {
			if(temp.next==null) {
				count++;
				break;
			}else {
				count++;
				temp=temp.next;
			}
			 
		}
		return count==maxSize;
	}
	public void push(Object object) {
		//添加数据到栈顶
		//判断栈是否已经满了
		if(isFull()) {
			System.out.println("栈满了,无法添加");
			return;
		}else {
			System.out.println("可添加");
		}
		StackNode newNode=new StackNode(object);
		StackNode temp=head;
		while(true){
			if(temp.next==null)
				break;
			temp=temp.next;
		}
		temp.next=newNode;
	}
	public Object pop() {
		//弹出栈顶的数据，即链表的最后一个结点的数据
		if(head.next==null) {
			throw new RuntimeException("栈空");
		}
		StackNode temp=head;
		while(true) {
			//判定条件，下一个结点的下一个结点为空。即找到倒数第二个结点。
			if(temp.next.next==null) {
				break;
			}
			temp=temp.next;
		}
		//找到下一个结点。
		StackNode next=temp.next;
		Object result=temp.next.getData();
		temp.next=null;
		
		return result;
	}
	public void show() {
		//打印栈，先将链表反转，在打印数据。
		if(head.next==null ) {
			System.out.println("栈空");
		}
		StackNode reverseHead=new StackNode("");
		StackNode temp=head.next;
		StackNode next=temp.next;
		while(true) {
			if(temp==null)
				break; 
			next=temp.next;
			temp.next=reverseHead.next;
			reverseHead.next=temp;
			temp=next;
		}
		temp=reverseHead.next;
		while(true) {
			if(temp==null)
				break;
			System.out.println(temp.data.toString());
			temp=temp.next;
		}
		//恢复为原来的样子。。。
		restoreToOrginal(reverseHead);
	}
	private void restoreToOrginal(StackNode reverseHead) {
		// TODO Auto-generated method stub
		StackNode orgNode=new StackNode("");
		StackNode current=reverseHead.next;
		StackNode next=current.next;
		while(true) {
			if(current==null)break;
			next=current.next;
			current.next=orgNode.next;
			orgNode.next=current;
			current=next;
		}
		head.next=orgNode.next;
	}
	public Object getTop() {
		//查看栈顶的数据
		if(head.next==null) {
			throw new RuntimeException("栈空");
		}
		StackNode temp=head;
		while(true) {
			if(temp.next==null)
				break;
			temp=temp.next;
		}
		return temp.data;
	}
	
	public StackNode getHead() {
		return head;
	}
	public class StackNode{
		private Object data;
		private StackNode next;
		public StackNode(Object data) {
			super();
			this.data = data;
		}

		public Object getData() {
			return data;
		}
		public void setData(Object data) {
			this.data = data;
		}
		public StackNode getNext() {
			return next;
		}
		public void setNext(StackNode next) {
			this.next = next;
		}
		
	}
}
