package my.stack;
/*
 * ���ڴ�ͷ�������ʵ�ֵ�ջListStack
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
		//������ݵ�ջ��
		//�ж�ջ�Ƿ��Ѿ�����
		if(isFull()) {
			System.out.println("ջ����,�޷����");
			return;
		}else {
			System.out.println("�����");
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
		//����ջ�������ݣ�����������һ����������
		if(head.next==null) {
			throw new RuntimeException("ջ��");
		}
		StackNode temp=head;
		while(true) {
			//�ж���������һ��������һ�����Ϊ�ա����ҵ������ڶ�����㡣
			if(temp.next.next==null) {
				break;
			}
			temp=temp.next;
		}
		//�ҵ���һ����㡣
		StackNode next=temp.next;
		Object result=temp.next.getData();
		temp.next=null;
		
		return result;
	}
	public void show() {
		//��ӡջ���Ƚ�����ת���ڴ�ӡ���ݡ�
		if(head.next==null ) {
			System.out.println("ջ��");
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
		//�ָ�Ϊԭ�������ӡ�����
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
		//�鿴ջ��������
		if(head.next==null) {
			throw new RuntimeException("ջ��");
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
