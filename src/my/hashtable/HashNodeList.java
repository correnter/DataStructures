package my.hashtable;

public class HashNodeList {
	private HashNode head;  
	//添加到链表的结尾
	public void addToLast(int id, Object obj) {
		// TODO Auto-generated method stub
		HashNode node=new HashNode(id,obj);
		if(head==null) {
			head=node;
			return;
		}
		//找到链表的尾结点
		HashNode current=head;
		while(true) {
			if(current.next==null) {
				break;
			}
			current=current.next;
		}
		current.next=node;
	}
	/**
	 * 遍历链表
	 * @param index 第几条链表
	 */
	public void list(int index) {
		// TODO Auto-generated method stub
		if(head==null) {
			System.out.println("第"+(index+1)+"条链表为空");
			return;
		}
		
		HashNode current=head;
		while(true) {
			System.out.printf("第%d条链表 %d号=>%s",index+1,current.id,current.obj.toString());
			if(current.next==null) {
				break;
			}
			current=current.next;
		}
		System.out.println();
	}
	public Object getNodeById(int id) {
		if(head==null) {
			return null;
		}
		HashNode current=head;
		HashNode target=new HashNode();
		while(true) {
			if(current.id==id) {
				target=current;
				break;
			}
			if(current.next==null) {
				target=null;
				break; 
			}
			current=current.next;
		}
		return target.obj;
		
	}
	//链表结点
	public static class HashNode{
		int id;
		Object obj;
		HashNode next;
		
		public HashNode() {
		}

		public HashNode(int id, Object obj) {
			super();
			this.id = id;
			this.obj = obj;
		}
		
	}
}
