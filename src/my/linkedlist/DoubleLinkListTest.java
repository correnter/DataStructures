package my.linkedlist;

public class DoubleLinkListTest {
	public static void main(String[] args) {
		DoubleLinkList doubleList=new DoubleLinkList();
		doubleList.addToLast("涂山红红");
		doubleList.addToLast("涂山雅雅");
		doubleList.addToLast("东方月初");
		doubleList.addToLast("玄霄");
		doubleList.addToLast("天河");
		doubleList.addToLast("夙玉");
		doubleList.addToLast("天青");
		doubleList.addToLast("紫萱");
		doubleList.addToLast("李逍遥");
		doubleList.addToLast("景天");
		doubleList.list();
		System.out.println("------------update--------------");
		doubleList.update(1,"无终");
		doubleList.list();
		System.out.println("------------delete--------------");
		doubleList.delete(2);
		doubleList.list();
	}
}
