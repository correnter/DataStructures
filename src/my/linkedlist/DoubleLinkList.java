package my.linkedlist;

public class DoubleLinkList {
	private DoubleLinkNode head=new DoubleLinkNode(0,new Object());
	
	public void addToLast(Object obj) {
		DoubleLinkNode newNode=new DoubleLinkNode(obj);
		DoubleLinkNode temp=head;
		while(true) {
			if(temp.next==null)
				break;
			temp=temp.next;
		}
		int id=temp.id+1;
		System.out.println("---------id="+id);
		newNode.id=id;
		System.out.println("---------objid="+id);
		temp.next=newNode;
		newNode.pre=temp;
	}
	public void addToLast(int id,Object obj) {
		DoubleLinkNode newNode=new DoubleLinkNode(id,obj);
		DoubleLinkNode temp=head;
		//�����ҵ����һ�����
		while(true) {
			if(temp.next==null)
				break;
			temp=temp.next;
		}
		temp.next=newNode;
		newNode.pre=temp;
	}
	public void insertToMid(int id, Object obj) {
		//����Ϊ�գ���ֱ�Ӳ���β��������addToLast();
		if(head.next==null)addToLast(id,obj);
		
		DoubleLinkNode newNode=new DoubleLinkNode(id,obj);
		DoubleLinkNode temp=head;
		boolean flag=false;
		while(true) {
			if(temp.next==null)break;
			if(id<temp.id)flag=true;
			temp=temp.next; 
		}
		if(flag) {
			//����һ���������
			 newNode.next=temp.next;
			 temp.next.pre=newNode;
			//����һ���������
			 newNode.pre=temp;
			 temp.next=newNode; 
		}else {
			//����Ҳ���newNode��id����������е��κ�һ�����id����ֱ�Ӳ���β��
			addToLast(id,obj);
		}
		
	}
	public void list() {
		if(head.next==null)
			System.out.println("˫�������ǿյ�");
		DoubleLinkNode temp=head.next;
		while(true) {
			if(temp==null)
				break;
			System.out.println(temp.toString());
			temp=temp.next;
		}
	}
	public void update(int id,Object obj) {
		if(head.next==null)
		{
			System.out.println("����Ϊ�գ��޷�����");
			return;
		}
		DoubleLinkNode temp=head.next;
		boolean flag=false;
		while(true) {
			if(temp.next==null)break;
			
			if(temp.id==id) {
				flag=true;
				break;
			}
			temp=temp.next;
		}
		if(flag) {
			temp.obj=obj;
		}else {
			System.out.println("δ�ҵ��ýڵ� ��idΪ��"+id);
		}
	}
	public void delete(int id) {
		if(head.next==null) {
			System.out.println("�������ǿյģ���ɾ�������޷����");
			return;
		}
		DoubleLinkNode temp=head.next;
		boolean flag=false;;
		while(true) {
			if(temp==null) {
				break;
			}
			if(temp.id==id) {
				flag=true;
				break;
			}
			temp=temp.next;
		}
		if(flag) {
			temp.pre.next=temp.next;
			if(temp.next!=null)
			temp.next.pre=temp.pre;
		}else {
			System.out.println("δ�ҵ��ýڵ㣬�޷�ɾ�������idΪ:" +id);
		}
	}
	public static class DoubleLinkNode{
		private int id;
		private Object obj;
		private DoubleLinkNode next;
		private DoubleLinkNode pre;

	 
		public DoubleLinkNode(Object obj) {
			super();
			this.obj = obj;
		}


		@Override
		public String toString() {
			return "DoubleLinkNode [id=" + id + ", obj=" + obj + "]";
		}


		public DoubleLinkNode(int id,Object obj) {
			this.id=id;
			this.obj=obj;
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public DoubleLinkNode getNext() {
			return next;
		}


		public void setNext(DoubleLinkNode next) {
			this.next = next;
		}
		
	}
}
