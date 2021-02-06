package my.djs;

import java.util.Arrays;

public class DjsAlgorithm {
	public static void main(String[] args) {
		char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
		int[][] matrix = new int[vertex.length][vertex.length];
		final int N = 65535;// 表示不可以连接
		matrix[0] = new int[] { N, 5, 7, N, N, N, 2 };
		matrix[1] = new int[] { 5, N, N, 9, N, N, 3 };
		matrix[2] = new int[] { 7, N, N, N, 8, N, N };
		matrix[3] = new int[] { N, 9, N, N, N, 4, N };
		matrix[4] = new int[] { N, N, 8, N, N, 5, 4 };
		matrix[5] = new int[] { N, N, N, 4, 5, N, 6 };
		matrix[6] = new int[] { 2, 3, N, N, 4, 6, N };
		Graph graph = new Graph(vertex, matrix);
		graph.showGraph();
		graph.djs(6);
		graph.showDjs();
	}
}
class Graph{
	private char[] vertex;
	private int[][] matrix;
	private VisitedVertex vv;
	public Graph(char[] vertex,int[][] matrix) {
		this.vertex=vertex;
		this.matrix=matrix;
	}
	public void showDjs() {
		vv.show();
	}
	public void showGraph() {
		for(int[] link : matrix) {
			System.out.println(Arrays.toString(link));
		}
	}
	public void djs(int index) {
		vv=new VisitedVertex(vertex.length,index);
		update(index);
		for(int j=1; j<vertex.length ;j++) {
			index= vv.updateArr();
			update(index);
		}
	}
	private void update(int index) {
		// TODO Auto-generated method stub
		int len=0;
		for(int j=0; j<matrix[index].length; j++) {
			len=vv.dis[index] +matrix[index][j];
			if(!(vv.already_arr[j]==1) && len< vv.dis[j]) {
				vv.pre_visited[j]=index;
				vv.dis[j]=len;
			}
		}
	}
	
}
class VisitedVertex{

	public int[] pre_visited;
	public int[] already_arr;
	public int[] dis;

	public VisitedVertex(int length, int index) {
		// TODO Auto-generated constructor stub
		this.pre_visited=new int[length];
		this.already_arr=new int[length];
		this.dis=new int[length];
		
		Arrays.fill(dis, 65535);
		this.already_arr[index]=1;
		this.dis[index]=0;
	}

	public int updateArr() {
		// TODO Auto-generated method stub
		int min=65535,index=0;
		for(int i=0; i<already_arr.length; i++) {
			if(already_arr[i]==0 && dis[i]<min) {
				min=dis[i];
				index=i;
			}
		}
		already_arr[index]=1;
		return index;
	}

	public void show() {
		// TODO Auto-generated method stub
		System.out.println("==========================");
		System.out.println(Arrays.toString(already_arr));
		System.out.println(Arrays.toString(pre_visited));
		System.out.println(Arrays.toString(dis));
	}
	
}