package my.linkedlist;

import my.linkedlist.SingleLinkedList.HeroNode;

public class SingleLinkedListTest {
	public static void main(String[] args) {
		HeroNode node1=new HeroNode(1,"狠人","");
		HeroNode node2=new HeroNode(2,"叶凡","");
		HeroNode node3=new HeroNode(3,"无始","");
		HeroNode node4=new HeroNode(4,"段德","");
		SingleLinkedList linklist=new SingleLinkedList();
		linklist.addByOrder(node1);
		linklist.addByOrder(node4);
		linklist.addByOrder(node3);
		linklist.addByOrder(node2);
		linklist.list();
		System.out.println("--------------------------update --------------------------------");
		HeroNode node=new HeroNode(4,"段道长","渡劫天功"); 
		linklist.update(node);
		linklist.list();
		System.out.println("--------------------------reverse --------------------------------");
		reverseLinkList(linklist.getHead());
		linklist.list();
		
//		System.out.println("--------------------------delete --------------------------------");
//		linklist.delete(1);
//		linklist.delete(4);
//		linklist.list();
//		System.out.println("--------------------------size --------------------------------");
//		int size=getLength(linklist.getHead());
//		System.out.println("链表长度为："+size);
//		System.out.println("--------------------------lastIndex --------------------------------");
//		HeroNode target=getLastIndexNode(linklist.getHead(), 1);
//		System.out.println(target);
	}
	//链表的有效长度
	public static int getLength(HeroNode head) {
		if(head.next==null)return 0;
		HeroNode temp=head;
		temp=temp.next;
		int count=0;
		while(true){
			if(temp==null)
				break;
			
			count++;
			temp=temp.next;
		}
		return count;
		
	}
	public static HeroNode getLastIndexNode(HeroNode head,int index) {
		HeroNode temp=head;
		int size=getLength(head);
		temp=temp.next;
		if(size>0 && index<size)
		{ 
			//size====>4
			//index====>1
			//size-index===>3
			
			for(int i=0;i<size-index;i++) {
				temp=temp.next;
			}
		}else {
			return null;
		}
		return temp; 
	}
	public static void reverseLinkList(HeroNode head) {
		if(head.next==null || head.next.next==null) return;
		
		HeroNode reverseNode =new HeroNode(0,"","");
		HeroNode current=head.next;
		HeroNode next=current.next;
		while(true) {
			if(current==null)
				break;
			next=current.next;
			current.next=reverseNode.next;
			reverseNode.next=current;
			current=next; 
		} 
		head.next=reverseNode.next;
	}
}
