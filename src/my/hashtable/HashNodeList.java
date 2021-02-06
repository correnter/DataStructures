package my.hashtable;

public class HashNodeList {
	private HashNode head;  
	//��ӵ�����Ľ�β
	public void addToLast(int id, Object obj) {
		// TODO Auto-generated method stub
		HashNode node=new HashNode(id,obj);
		if(head==null) {
			head=node;
			return;
		}
		//�ҵ������β���
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
	 * ��������
	 * @param index �ڼ�������
	 */
	public void list(int index) {
		// TODO Auto-generated method stub
		if(head==null) {
			System.out.println("��"+(index+1)+"������Ϊ��");
			return;
		}
		
		HashNode current=head;
		while(true) {
			System.out.printf("��%d������ %d��=>%s",index+1,current.id,current.obj.toString());
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
	//������
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
