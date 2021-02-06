package my.linkedlist;

public class CircleLinkedList {
	private CircleLinkedNode first=null;
	
	public void add(int nums) {
		if(nums<1) {
			System.out.println("������ٴ��ڵ���1");
			return;
		}
		CircleLinkedNode current=null;
		for(int i=1;i<=nums;i++) {
			CircleLinkedNode newNode=new CircleLinkedNode(i);
			if(i==1) {
				//��Ϊ��һ���ڵ㣬��first����newNode;
				//ʹfirst����һ�����ָ���Լ����γɻ�״��
				first=newNode;
				newNode.setNext(first);
				//first�����ƶ���ʹ��һ���������浱ǰ��λ�á�
				current=newNode;
				
			}else {
				//�������ͷ��㣬������������ĩβ
				newNode.setNext(first);
				current.setNext(newNode);
				current=newNode;
			}
		}
	}
	public void list() {
		if(first.getNext()==first) {
			System.out.println("����Ϊ��");
		}
		CircleLinkedNode current=first;
		while(true) {
			if(current.getNext()==first) {
				System.out.println(current.toString());
				break;
			}
			System.out.println(current.toString());
			current=current.getNext();
		}
	}
	public static class CircleLinkedNode{
		private int id;
		private Object obj;
		private CircleLinkedNode next;
		public CircleLinkedNode(int id) {
			super();
			this.id = id;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public CircleLinkedNode getNext() {
			return next;
		}
		public void setNext(CircleLinkedNode next) {
			this.next = next;
		}
		public Object getObj() {
			return obj;
		}
		public void setObj(Object obj) {
			this.obj = obj;
		}
		@Override
		public String toString() {
			return "CircleLinkedNode [id=" + id + "]";
		}
		
	}
	 
	public  void resolveYusephu(int start,int size,int nums) {
		if(start>nums) {
			System.out.println("��ʼ��Ų��ܴ�������");
			return;
		}
		
		CircleLinkedNode helper=first;
		while(true) {
			if(helper.getNext()==first) {
				break;
			}
			helper=helper.getNext();
		}
		for(int j=0;j<start-1;j++) {
			first=first.getNext();
			helper=helper.getNext();
		}
		while(true) {
			if(helper==first) {
				break;
			}
			for(int i=0;i<size-1;i++) {
				first=first.getNext();
				helper=helper.getNext();
			}
			System.out.printf("��Ȧ��� %d \n", first.getId());
			first=first.getNext();
			helper.setNext(first);
		}
		System.out.printf("����Ȧ %d", first.getId());
	}
	public static void main(String[] args) {
		CircleLinkedList circleList=new CircleLinkedList();
		circleList.add(5);
		circleList.list();
		circleList.resolveYusephu(1, 2, 5);
	}
}
