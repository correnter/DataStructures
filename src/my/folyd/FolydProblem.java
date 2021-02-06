package my.folyd;

import java.util.Arrays;

public class FolydProblem {
	public static void main(String[] args) {
		char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
		int[][] matrix = new int[vertex.length][vertex.length];
		final int N = 65535;
		matrix[0] = new int[] { 0, 5, 7, N, N, N, 2 };
		matrix[1] = new int[] { 5, 0, N, 9, N, N, 3 };
		matrix[2] = new int[] { 7, N, 0, N, 8, N, N };
		matrix[3] = new int[] { N, 9, N, 0, N, 4, N };
		matrix[4] = new int[] { N, N, 8, N, 0, 5, 4 };
		matrix[5] = new int[] { N, N, N, 4, 5, 0, 6 };
		matrix[6] = new int[] { 2, 3, N, N, 4, 6, 0 };
		Graph graph = new Graph(vertex.length, matrix, vertex);
		graph.floyd(); 
		graph.show();
	}
	public static class Graph{
		private char[] vertex;
		private int[][] dis;
		private int[][] pre;
		public Graph(int length, int[][] matrix, char[] vertex) {
			// TODO Auto-generated constructor stub
			this.vertex=vertex;
			this.dis=matrix;
			this.pre=new int[vertex.length][vertex.length];
			for(int i=0;i<vertex.length;i++) {
				Arrays.fill(pre[i], i);
			}
		}
		public void floyd() {
			// TODO Auto-generated method stub
			int len=0;
			for(int k=0; k<vertex.length;k++) {
				for(int i=0; i<vertex.length; i++) {
					for(int j=0; j<vertex.length; j++) {
						len=dis[i][k]+dis[k][j];
						if(len < dis[i][j]) {
							dis[i][j]=len;
							pre[i][j]=pre[k][j];
						}
					}
				}
				
			}
		}
		public void show() {
			System.out.println("Ç°Çý½áµã");
			for(int[] row : pre) {
				System.out.println(Arrays.toString(row));
			}
			System.out.println();
			for(int[] row : dis) {
				System.out.println(Arrays.toString(row));
			}
		}
		
	}
}
