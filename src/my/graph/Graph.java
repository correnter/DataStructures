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
	 * @param index 当前结点的坐标
	 * @return 返回当前结点的邻接节点
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
	 * @param v1 当前结点坐标
	 * @param v2 当前结点的领结结点坐标
	 * @return 返回当前结点的下一个邻接节点。
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
		//获取首节点
		String val=this.getVertux(i);
		System.out.print(val+"->");
		isVisited[i]=true;
		//创建一个队列，按顺序存储扫描每次循环扫描到结点值
		LinkedList<Integer> queue=new LinkedList<Integer>();
		queue.addLast(i);
		while(!queue.isEmpty()) {
			//获取队列的顶点值
			index=queue.removeFirst(); 
			//获取当前结点index的邻接节点
			last=this.getNeighbor(index);
			while(last!=-1) {
				if(!isVisited[last]) {
					//当前节点index的邻接节点没有被访问到，就设置为true
					isVisited[last]=true;
					//加入队列的尾部
					queue.addLast(last);
					System.out.print(this.getVertux(last)+"->");
				}
				//如果当前结点已经被访问到，则访问当前结点的下一个邻接节点
				last=this.getNextNeighbor(index, last);
			}
		}
	
	}
	public void dfs(boolean[] isVisited,int i) {
		//获取当前结点
		String val=this.getVertux(i);
		//设置当前结点已标记
		System.out.print(val+"->");
		isVisited[i]=true;
		//找到下一个结点；
		int w=this.getNeighbor(i);
		while(w!=-1) {
			if(isVisited[w]==false) {
				//如果该节点未被访问，则递归。
				dfs(isVisited,w);
			}else {
				//如果该节点已经被访问了，则获取当前结点的下一个邻接结点。
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
