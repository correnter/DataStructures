package my.linkedlist;

public class SingleLinkedList {
	private HeroNode head=new HeroNode(0,"","");
	
	public void add(HeroNode heroNode) {
		HeroNode temp=head;
		while(true) {
			if(temp.next==null)
				break;
			temp=temp.next;
		}
		temp.next=heroNode;
	}
	public void addByOrder(HeroNode heroNode) {
		HeroNode temp=head;
		boolean flag=false;
		while(true) {
			if(temp.next==null)
				break;
			if(temp.next.id==heroNode.id) {
				flag=true;
				break;
			}
			if(temp.next.id>heroNode.id)
				break;
			
			temp=temp.next;
		}
		if(flag) {
			System.out.println("待插入的数据编号已存在"+heroNode.id);
		} else {
			heroNode.next=temp.next;
			temp.next=heroNode;
		}
	}
	public void update(HeroNode heroNode) {
		HeroNode temp=head.next;
		while(true) {
			if(temp==null) {
				System.out.println("该修改的数据不存在");
				break;
			}
			if(temp.id==heroNode.id) {
				temp.name=heroNode.name;
				temp.nickName=heroNode.nickName;
				break;
			}
			temp=temp.next;
		}
	}
	public void delete(int id) {
		HeroNode temp=head;
		boolean flag=false;
		while(true) {
			if(temp.next==null)
				break;
			if(temp.next.id==id) {
				flag=true;
				break;
			}
			temp=temp.next;
		}
		if(flag) {
			temp.next=temp.next.next;
		}else {
			System.out.printf("该节点未存在 %d \n", id);
		}
		
	}
	public void list() {
		HeroNode temp=head;
		while(true) {
			if(temp.next==null)
				break;
			temp=temp.next;
			System.out.println(temp.toString());
			
		}
	}
	
	public HeroNode getHead() {
		return head;
	}

	public static class HeroNode{
		public int id;
		public String name;
		public String nickName;
		public HeroNode next;
		public HeroNode(int id, String name, String nickName) {
			super();
			this.id = id;
			this.name = name;
			this.nickName = nickName;
		}
		@Override
		public String toString() {
			return "HeroNode [id=" + id + ", name=" + name + ", nickName=" + nickName + "]";
		}
		
	}
}
