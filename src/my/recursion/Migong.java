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

		// ����ʧ��·���������
		pane[5][2] = 1;
		pane[5][1] = 1;
		pane[5][3] = 1;
		pane[4][3] = 1;
		pane[3][3] = 1;
		pane[3][2] = 1;
		int[][] temp=pane;
		List<Integer> list=new ArrayList<>();
		System.out.println("----------------------���Թ�1��-------------------------------------");
		
		goAway(pane, 1, 1);
		print(pane);
		list.add(calculateShortest(pane));
		System.out.println("----------------------���·��------------------------------------"+list.get(0));
		pane=temp;
		System.out.println("----------------------���Թ�2��-------------------------------------");
		goAway2(pane, 1, 1);
		print(pane);
		list.add(calculateShortest(pane));
		pane=temp;
		System.out.println("----------------------���Թ�3��-------------------------------------");
		goAway3(pane, 1, 1);
		print(pane);
		list.add(calculateShortest(pane));
		pane=temp;
		System.out.println("----------------------���Թ�4��-------------------------------------");
		goAway4(pane, 1, 1);
		print(pane);
		list.add(calculateShortest(pane));
		pane=temp;
		System.out.println("------���Ϊ��"+list);
		
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

	// �ߵ�˳�� �£��ң��ϣ���
	private static boolean goAway(int[][] pane, int i, int j) {
		// TODO Auto-generated method stub
		if (pane[6][5] == 2) {
			return true;
		} else {
			if (pane[i][j] == 0) {
				// �ж�Ϊ0��˵��û�߹���
				pane[i][j] = 2;
				if (goAway(pane, i + 1, j)) {
					// ������
					return true;
				} else if (goAway(pane, i, j + 1)) {
					// ������
					return true;
				} else if (goAway(pane, i - 1, j)) {
					// ������
					return true;
				} else if (goAway(pane, i, j - 1)) {
					// ������
					return true;
				} else {
					// �������Ҷ��߲�ͨ�������øýڵ�Ϊ3����ʾ��·��ͨ��
					pane[i][j] = 3;
					return false;
				}
			} else {
				// �жϲ�Ϊ�㣬˵���õ��߹��ˡ���������2,1��Ҳ������3��
				return false;
			}

		}
	}

	private static boolean goAway2(int[][] pane, int i, int j) {
		// TODO Auto-generated method stub
		//��������
		if (pane[6][5] == 2) {
			return true;
		} else {
			if (pane[i][j] == 0) {
				// �ж�Ϊ0��˵��û�߹���
				pane[i][j] = 2;
				if (goAway2(pane, i - 1, j)) {
					// ������
					return true;
				} else if (goAway2(pane, i, j+1)) {
					// ������
					return true;
				} else if (goAway2(pane, i + 1, j)) {
					// ������
					return true;
				} else if (goAway2(pane, i, j-1)) {
					// ������
					return true;
				} else {
					// �������Ҷ��߲�ͨ�������øýڵ�Ϊ3����ʾ��·��ͨ��
					pane[i][j] = 3;
					return false;
				}
			} else {
				// �жϲ�Ϊ�㣬˵���õ��߹��ˡ���������2,1��Ҳ������3��
				return false;
			}

		}
	}
	//��������
	private static boolean goAway3(int[][] pane, int i, int j) {
		// TODO Auto-generated method stub
		if (pane[6][5] == 2) {
			return true;
		} else {
			if (pane[i][j] == 0) {
				// �ж�Ϊ0��˵��û�߹���
				pane[i][j] = 2;
				 if (goAway3(pane, i, j + 1)) {
					// ������
					return true;
				} 
				 else if (goAway3(pane, i + 1, j)) {
					// ������
					return true;
				} else if (goAway3(pane, i - 1, j)) {
					// ������
					return true;
				} else if (goAway3(pane, i, j - 1)) {
					// ������
					return true;
				} else {
					// �������Ҷ��߲�ͨ�������øýڵ�Ϊ3����ʾ��·��ͨ��
					pane[i][j] = 3;
					return false;
				}
			} else {
				// �жϲ�Ϊ�㣬˵���õ��߹��ˡ���������2,1��Ҳ������3��
				return false;
			}

		}
	}
	//��������
	private static boolean goAway4(int[][] pane, int i, int j) {
		// TODO Auto-generated method stub
		if (pane[6][5] == 2) {
			return true;
		} else {
			if (pane[i][j] == 0) {
				// �ж�Ϊ0��˵��û�߹���
				pane[i][j] = 2;
				if (goAway4(pane, i  , j-1)) {
					// ������
					return true;
				} else if (goAway4(pane, i-1, j )) {
					// ������
					return true;
				} else if (goAway4(pane, i - 1, j+1)) {
					// ������
					return true;
				} else if (goAway4(pane, i+1, j)) {
					// ������
					return true;
				} else {
					// �������Ҷ��߲�ͨ�������øýڵ�Ϊ3����ʾ��·��ͨ��
					pane[i][j] = 3;
					return false;
				}
			} else {
				// �жϲ�Ϊ�㣬˵���õ��߹��ˡ���������2,1��Ҳ������3��
				return false;
			}

		}
	}
}
