package my.kruskal;

import java.util.Arrays;

public class KruskalProblem {
	public static void main(String[] args) {
		char[] vertexs = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
		int matrix[][] = { /* A *//* B *//* C *//* D *//* E *//* F *//* G */
				/* A */ { 0, 12, INF, INF, INF, 16, 14 }, /* B */ { 12, 0, 10, INF, INF, 7, INF },
				/* C */ { INF, 10, 0, 3, 5, 6, INF }, /* D */ { INF, INF, 3, 0, 4, INF, INF },
				/* E */ { INF, INF, 5, 4, 0, 2, 8 }, /* F */ { 16, 7, 6, INF, 2, 0, 9 },
				/* G */ { 14, INF, INF, INF, 8, 9, 0 } };
		KruskalProblem problem = new KruskalProblem(vertexs, matrix);
		EData[] edges = problem.getEdges();
		// System.out.println(Arrays.toString(edges));
		problem.kruskal();
	}

	private int edgeNum;
	private char[] vertexs;
	private int[][] matrix;
	public static int INF = Integer.MAX_VALUE;

	public KruskalProblem(char[] vertexs, int[][] matrix) {
		int vlen = vertexs.length;
		this.matrix = new int[vlen][vlen];
		this.vertexs = new char[vlen];
		// 获去顶点和边的邻接矩阵
		for (int i = 0; i < vlen; i++) {
			this.vertexs[i] = vertexs[i];
			for (int j = 0; j < vlen; j++) {
				this.matrix[i][j] = matrix[i][j];
			}
		}
		// 获取一共有多少条有效边
		for (int i = 0; i < vlen; i++) {
			for (int j = i + 1; j < vlen; j++) {
				if (matrix[i][j] != INF) {
					edgeNum++;
				}
			}
		}

	}

	public EData[] kruskal() {
		EData[] edges = this.getEdges();
		this.sortEdges(edges);
		int[] ends = new int[this.edgeNum];
		EData[] result = new EData[edgeNum];
		int index = 0;
		for (int i = 0; i < this.vertexs.length; i++) {
			EData edge = edges[i];
			int start = this.getPosition(edge.start);
			int end = this.getPosition(edge.end);

			int m = this.getEnds(ends, start);
			int n = this.getEnds(ends, end);
			if (m != n) {
				System.out.println("m="+m+" n="+n);
				ends[m] = n;
				result[index] = edge;
				index++;
			}
		}
		System.out.println("最小生成树为");
		for (int i = 0; i < index; i++) {
			System.out.println(result[i]);
		}
		return result;
	}

	public int getPosition(char v) {
		for (int i = 0; i < vertexs.length; i++) {
			if (v == vertexs[i]) {
				return i;
			}
		}
		return -1;
	}

	public int getEnds(int[] ends, int i) {
		while (ends[i] != 0) {
			i = ends[i];
		}
		return i;
	}

	public void sortEdges(EData[] edges) {
		int elen = edges.length;
		for (int i = 0; i < elen - 1; i++) {
			for (int j = 0; j < elen - i - 1; j++) {
				if (edges[j].weight > edges[j + 1].weight) {
					EData temp = edges[j];
					edges[j] = edges[j + 1];
					edges[j + 1] = temp;
				}
			}
		}
	}

	public EData[] getEdges() {
		EData[] edges = new EData[this.edgeNum];
		int index = 0;
		for (int i = 0; i < vertexs.length; i++) {
			for (int j = i + 1; j < vertexs.length; j++) {
				if (this.matrix[i][j] != INF) {
					edges[index] = new EData(this.vertexs[i], this.vertexs[j], this.matrix[i][j]);
					index++;
				}
			}
		}
		return edges;
	}

	public class EData {
		char start;
		char end;
		int weight;

		public EData(char start, char end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "EData [start=" + start + ", end=" + end + ", weight=" + weight + "]";
		}

	}
}
