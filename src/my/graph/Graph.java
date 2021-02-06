package my.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
	private ArrayList<String> vertus;
	private int[][] edges;
	private int numsOfVertus;
	private boolean[] isVisited;
	public Graph(int n) { 
		edges=new int[n][n];
		vertus=new ArrayList<String>();
		isVisited=new boolean[n];
	}
	/**
	 * 
	 * @param index ��ǰ��������
	 * @return ���ص�ǰ�����ڽӽڵ�
	 */
	public int getNeighbor(int index) {
		for(int j=0;j<edges[index].length;j++) {
			if(edges[index][j]>0 && this.isVisited[j]==false) {
				return j;
			}
		}
		return -1;
	}
	/**
	 * 
	 * @param v1 ��ǰ�������
	 * @param v2 ��ǰ�������������
	 * @return ���ص�ǰ������һ���ڽӽڵ㡣
	 */
	public int getNextNeighbor(int v1,int v2) {
		for(int j=v2+1;j<edges[v1].length;j++) {
			if(edges[v1][j]>0) {
				return j;
			}
		}
		return -1;
	}
	public void dfs() {
		for(int i=0;i<getNumsOfVertus();i++) {
			isVisited=new boolean[5];
			dfs(isVisited,i);
			System.out.println();
		}
		
		
	}
	public void bfs() { 
		for(int i=0;i<getNumsOfVertus();i++) {
			isVisited=new boolean[5];
			bfs(isVisited,i);
			System.out.println();
		}
	}
	public void bfs(boolean[] isVisited,int i) {
		int index;
		int last;
		//��ȡ�׽ڵ�
		String val=this.getVertux(i);
		System.out.print(val+"->");
		isVisited[i]=true;
		//����һ�����У���˳��洢ɨ��ÿ��ѭ��ɨ�赽���ֵ
		LinkedList<Integer> queue=new LinkedList<Integer>();
		queue.addLast(i);
		while(!queue.isEmpty()) {
			//��ȡ���еĶ���ֵ
			index=queue.removeFirst(); 
			//��ȡ��ǰ���index���ڽӽڵ�
			last=this.getNeighbor(index);
			while(last!=-1) {
				if(!isVisited[last]) {
					//��ǰ�ڵ�index���ڽӽڵ�û�б����ʵ���������Ϊtrue
					isVisited[last]=true;
					//������е�β��
					queue.addLast(last);
					System.out.print(this.getVertux(last)+"->");
				}
				//�����ǰ����Ѿ������ʵ�������ʵ�ǰ������һ���ڽӽڵ�
				last=this.getNextNeighbor(index, last);
			}
		}
	
	}
	public void dfs(boolean[] isVisited,int i) {
		//��ȡ��ǰ���
		String val=this.getVertux(i);
		//���õ�ǰ����ѱ��
		System.out.print(val+"->");
		isVisited[i]=true;
		//�ҵ���һ����㣻
		int w=this.getNeighbor(i);
		while(w!=-1) {
			if(isVisited[w]==false) {
				//����ýڵ�δ�����ʣ���ݹ顣
				dfs(isVisited,w);
			}else {
				//����ýڵ��Ѿ��������ˣ����ȡ��ǰ������һ���ڽӽ�㡣
				w=getNextNeighbor(i, w);
			}
		
		}
	}
	public void addVertux(String val) {
		vertus.add(val);
	}
	public void addEdgm(int v1,int v2) {
		edges[v1][v2]=1;
		edges[v2][v1]=1;
		numsOfVertus++;
	}
	public void addEdgm(int v1,int v2,int weigh) {
		edges[v1][v2]=weigh;
		edges[v2][v1]=weigh;
		numsOfVertus++;
	}
	public int getNumsOfVertus() {
		return numsOfVertus;
	}
	public String getVertux(int i) {
		return vertus.get(i);
	}
	public void showEdge() {
		for(int[] row : edges) {
			System.out.println(Arrays.toString(row));
		}
	}
	public static void main(String[] args) {
		Graph graph=new Graph(5);
		graph.addVertux("A");
		graph.addVertux("B");
		graph.addVertux("C");
		graph.addVertux("D");
		graph.addVertux("E");
		graph.addEdgm(0, 1, 1);
		graph.addEdgm(0, 2, 1);
		graph.addEdgm(1, 2, 1);
		graph.addEdgm(1, 3, 1);
		graph.addEdgm(1, 4, 1);
		graph.showEdge();
	//	graph.dfs();
		graph.bfs();
	}
}
