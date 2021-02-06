package my.prim;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimAlgorithm {

	public static void main(String[] args) {
		// ���Կ���ͼ�Ƿ񴴽� ok
		char[] data = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
		int verxs = data.length; // �ڽӾ���Ĺ�ϵʹ�ö�ά�����ʾ,10000 �����������ʾ�����㲻��ͨ
		int[][] weight =
				new int[][] { { 10000, 5, 7, 10000, 10000, 10000, 2 }, { 5, 10000, 10000, 9, 10000, 10000, 3 },
				{ 7, 10000, 10000, 10000, 8, 10000, 10000 }, { 10000, 9, 10000, 10000, 10000, 4, 10000 },
				{ 10000, 10000, 8, 10000, 10000, 5, 4 }, { 10000, 10000, 10000, 4, 5, 10000, 6 },
				{ 2, 3, 10000, 10000, 4, 6, 10000 }, };
		PrimAlgorithm prim=new PrimAlgorithm();
		Graph graph=prim.createGraph(verxs, data, weight);
		prim.showGraph(graph);
		List<Object> objList=prim.prim(graph, 0);
		System.out.println(objList.toString());
	}

	public Graph createGraph(int vertus, char[] data, int[][] weigh) {
		Graph graph = new Graph(vertus);
		for (int i = 0; i < vertus; i++) {
			graph.data[i] = data[i];
			for (int j = 0; j < vertus; j++) {
				graph.weight[i][j] = weigh[i][j];
			}
		}
		return graph;
	}

	public void showGraph(Graph graph) {
		for (int[] row : graph.weight) {
			System.out.println(Arrays.toString(row));
		}
	}
	/**
	 * 
	 * @param graph ͼ
	 * @param v ������±�
	 * @return 
	 */
	public List<Object> prim(Graph graph,int v) {
		//��Ƕ����Ƿ񱻷��ʹ�
		int[] visited=new int[graph.vertus];
		//Ĭ�϶���0
		for(int i=0; i<graph.vertus;i++) {
			visited[i]=0;
		}
		visited[v]=1;
		int h1=-1;
		int h2=-1;
		int minWeight=10000;
		
		List<Object> result=new ArrayList<Object>();
		result.add(graph.data[v]);
		//�ҳ���һ����v���������ıߣ��ұߵ�Ȩֵ��С
		
		for(int k=1;k<graph.vertus;k++) {
			
			for(int i=0; i<graph.vertus; i++) {
				for(int j=0; j<graph.vertus; j++) {
					if(visited[i]==1 && visited[j]==0 && minWeight >graph.weight[i][j]) {
						minWeight=graph.weight[i][j];
						h1=i;
						h2=j;
					}
				}
			}
			System.out.println("h1="+h1 + " h2="+h2);
			System.out.println("��<"+graph.data[h1]+","+graph.data[h2]+">="+minWeight);
			visited[h2]=1;
			minWeight=10000;
			result.add(graph.data[h2]);
		} 
		return result;
	}
	public class Graph {
		int vertus;
		char[] data;
		int[][] weight;

		public Graph(int vertus) {
			this.vertus = vertus;
			data = new char[vertus];
			weight = new int[vertus][vertus];
		}
	}
}
