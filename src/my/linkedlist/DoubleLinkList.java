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
		//遍历找到最后一个结点
		while(true) {
			if(temp.next==null)
				break;
			temp=temp.next;
		}
		temp.next=newNode;
		newNode.pre=temp;
	}
	public void insertToMid(int id, Object obj) {
		//链表为空，则直接插入尾部，调用addToLast();
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
			//与下一个结点相连
			 newNode.next=temp.next;
			 temp.next.pre=newNode;
			//与上一个结点连接
			 newNode.pre=temp;
			 temp.next=newNode; 
		}else {
			//如果找不到newNode的id比这个链表中的任何一个结点id大，则直接插入尾部
			addToLast(id,obj);
		}
		
	}
	public void list() {
		if(head.next==null)
			System.out.println("双向链表是空的");
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
			System.out.println("链表为空，无法更新");
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
			System.out.println("未找到该节点 ，id为："+id);
		}
	}
	public void delete(int id) {
		if(head.next==null) {
			System.out.println("该链表是空的，该删除操作无法完成");
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
			System.out.println("未找到该节点，无法删除，编号id为:" +id);
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
