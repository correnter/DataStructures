package my.recursion;

import java.util.ArrayList;
import java.util.List;

public class Migong {
	public static void main(String[] args) {
		int[][] pane = new int[8][7];
		for (int i = 0; i < 8; i++) {
			pane[i][0] = 1;
			pane[i][6] = 1;
		}
		for (int i = 0; i < 7; i++) {
			pane[0][i] = 1;
			pane[7][i] = 1;
		}

		// 创造失败路径的情况。
		pane[5][2] = 1;
		pane[5][1] = 1;
		pane[5][3] = 1;
		pane[4][3] = 1;
		pane[3][3] = 1;
		pane[3][2] = 1;
		int[][] temp=pane;
		List<Integer> list=new ArrayList<>();
		System.out.println("----------------------走迷宫1后-------------------------------------");
		
		goAway(pane, 1, 1);
		print(pane);
		list.add(calculateShortest(pane));
		System.out.println("----------------------最短路径------------------------------------"+list.get(0));
		pane=temp;
		System.out.println("----------------------走迷宫2后-------------------------------------");
		goAway2(pane, 1, 1);
		print(pane);
		list.add(calculateShortest(pane));
		pane=temp;
		System.out.println("----------------------走迷宫3后-------------------------------------");
		goAway3(pane, 1, 1);
		print(pane);
		list.add(calculateShortest(pane));
		pane=temp;
		System.out.println("----------------------走迷宫4后-------------------------------------");
		goAway4(pane, 1, 1);
		print(pane);
		list.add(calculateShortest(pane));
		pane=temp;
		System.out.println("------结果为："+list);
		
	}
	
	private static void print(int[][] pane) {
		// TODO Auto-generated method stub
		for (int[] row : pane) {
			for (int data : row) {
				System.out.printf(data + " ");
			}
			System.out.println();
		}
	}

	private static int  calculateShortest(int[][] pane) {
		// TODO Auto-generated method stub
		int count=0;
		for (int[] row : pane) {
			for (int data : row) {
				if(data==2) {
					count++;
				} 
			} 
		}
		return count;
	}

	// 走的顺序： 下，右，上，左
	private static boolean goAway(int[][] pane, int i, int j) {
		// TODO Auto-generated method stub
		if (pane[6][5] == 2) {
			return true;
		} else {
			if (pane[i][j] == 0) {
				// 判断为0，说明没走过。
				pane[i][j] = 2;
				if (goAway(pane, i + 1, j)) {
					// 向下走
					return true;
				} else if (goAway(pane, i, j + 1)) {
					// 向右走
					return true;
				} else if (goAway(pane, i - 1, j)) {
					// 向上走
					return true;
				} else if (goAway(pane, i, j - 1)) {
					// 向左走
					return true;
				} else {
					// 上下左右都走不通，就设置该节点为3，表示此路不通。
					pane[i][j] = 3;
					return false;
				}
			} else {
				// 判断不为零，说明该点走过了。。可能是2,1，也可能是3。
				return false;
			}

		}
	}

	private static boolean goAway2(int[][] pane, int i, int j) {
		// TODO Auto-generated method stub
		//上右下左
		if (pane[6][5] == 2) {
			return true;
		} else {
			if (pane[i][j] == 0) {
				// 判断为0，说明没走过。
				pane[i][j] = 2;
				if (goAway2(pane, i - 1, j)) {
					// 向下走
					return true;
				} else if (goAway2(pane, i, j+1)) {
					// 向右走
					return true;
				} else if (goAway2(pane, i + 1, j)) {
					// 向上走
					return true;
				} else if (goAway2(pane, i, j-1)) {
					// 向左走
					return true;
				} else {
					// 上下左右都走不通，就设置该节点为3，表示此路不通。
					pane[i][j] = 3;
					return false;
				}
			} else {
				// 判断不为零，说明该点走过了。。可能是2,1，也可能是3。
				return false;
			}

		}
	}
	//右下左上
	private static boolean goAway3(int[][] pane, int i, int j) {
		// TODO Auto-generated method stub
		if (pane[6][5] == 2) {
			return true;
		} else {
			if (pane[i][j] == 0) {
				// 判断为0，说明没走过。
				pane[i][j] = 2;
				 if (goAway3(pane, i, j + 1)) {
					// 向右走
					return true;
				} 
				 else if (goAway3(pane, i + 1, j)) {
					// 向下走
					return true;
				} else if (goAway3(pane, i - 1, j)) {
					// 向上走
					return true;
				} else if (goAway3(pane, i, j - 1)) {
					// 向左走
					return true;
				} else {
					// 上下左右都走不通，就设置该节点为3，表示此路不通。
					pane[i][j] = 3;
					return false;
				}
			} else {
				// 判断不为零，说明该点走过了。。可能是2,1，也可能是3。
				return false;
			}

		}
	}
	//左上右下
	private static boolean goAway4(int[][] pane, int i, int j) {
		// TODO Auto-generated method stub
		if (pane[6][5] == 2) {
			return true;
		} else {
			if (pane[i][j] == 0) {
				// 判断为0，说明没走过。
				pane[i][j] = 2;
				if (goAway4(pane, i  , j-1)) {
					// 向下走
					return true;
				} else if (goAway4(pane, i-1, j )) {
					// 向右走
					return true;
				} else if (goAway4(pane, i - 1, j+1)) {
					// 向上走
					return true;
				} else if (goAway4(pane, i+1, j)) {
					// 向左走
					return true;
				} else {
					// 上下左右都走不通，就设置该节点为3，表示此路不通。
					pane[i][j] = 3;
					return false;
				}
			} else {
				// 判断不为零，说明该点走过了。。可能是2,1，也可能是3。
				return false;
			}

		}
	}
}
