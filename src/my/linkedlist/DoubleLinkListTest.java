package my.linkedlist;

public class DoubleLinkListTest {
	public static void main(String[] args) {
		DoubleLinkList doubleList=new DoubleLinkList();
		doubleList.addToLast("Ϳɽ���");
		doubleList.addToLast("Ϳɽ����");
		doubleList.addToLast("�����³�");
		doubleList.addToLast("����");
		doubleList.addToLast("���");
		doubleList.addToLast("����");
		doubleList.addToLast("����");
		doubleList.addToLast("����");
		doubleList.addToLast("����ң");
		doubleList.addToLast("����");
		doubleList.list();
		System.out.println("------------update--------------");
		doubleList.update(1,"����");
		doubleList.list();
		System.out.println("------------delete--------------");
		doubleList.delete(2);
		doubleList.list();
	}
}
