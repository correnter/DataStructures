package my.hashtable;

public class HashTable {
	public static void main(String[] args) {
		HashTable table=new HashTable(8);
		table.add(1, "����");
		table.add(2, "Ҷ��");
		table.add(3, "�����");
		table.add(4, "����");
		table.add(5, "�ε�");
		table.list();
		
		Object res=table.findById(3);
		System.out.println(res.toString());
	}
	private HashNodeList[] nodeList;
	private int size;
	public HashTable(int size) {
		super();
		this.size=size;
		//�����������顣ÿ������Ϊ��
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
	//��ӵ������е�ĳһ�������ĩβ��
	public void add(int id,Object obj) { 
		int index=hashCode(id); 
		nodeList[index].addToLast(id, obj);
	}
	//������������
	public void list() {
		for(int i=0; i<size;i++) {
			nodeList[i].list(i);
		}
	}
	//ɢ�к�����
	public int hashCode(int id) {
		return id % size;
	}

}	
