package my.hashtable;

public class HashTable {
	public static void main(String[] args) {
		HashTable table=new HashTable(8);
		table.add(1, "妖妖");
		table.add(2, "叶凡");
		table.add(3, "荒天帝");
		table.add(4, "无终");
		table.add(5, "段德");
		table.list();
		
		Object res=table.findById(3);
		System.out.println(res.toString());
	}
	private HashNodeList[] nodeList;
	private int size;
	public HashTable(int size) {
		super();
		this.size=size;
		//创建链表数组。每个链表都为空
		this.nodeList=new HashNodeList[size];
		for(int i=0; i<size;i++) {
			this.nodeList[i]=new HashNodeList();
		}
	}
	public Object findById(int id) {
		int index=hashCode(id);
		Object result=this.nodeList[index].getNodeById(id);
		return result;
	}
	//添加到数组中的某一条链表的末尾中
	public void add(int id,Object obj) { 
		int index=hashCode(id); 
		nodeList[index].addToLast(id, obj);
	}
	//遍历数组链表
	public void list() {
		for(int i=0; i<size;i++) {
			nodeList[i].list(i);
		}
	}
	//散列函数。
	public int hashCode(int id) {
		return id % size;
	}

}	
