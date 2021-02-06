package my.packageproblem;

import java.util.Arrays;

public class PackageProblem {
	public static void main(String[] args) {
		int n=4;
		int[] w= {
				1,4,3
		};
		int value[]= {
				1500,3000,2000
		};
		int[][] v=new int[n][n+1];
		int[][] target=new int[n][n+1];
		for(int i=0;i<v[0].length;i++) {
			v[0][i]=0;
		}
		for(int i=0;i<v.length;i++) {
			v[i][0]=0;
		}
		for(int i=1;i<v.length;i++) {
			for(int j=1;j<v[0].length;j++) {
				if(w[i-1]>j) {
					v[i][j]=v[i-1][j];
				}else {
					if(v[i-1][j]<value[i-1]+v[i-1][j-w[i-1]])
					{
						v[i][j]=value[i-1]+v[i-1][j-w[i-1]];
						target[i][j]=1;
					}else {
						v[i][j]=v[i-1][j];
					}
				}
			}
		}
		for(int[] row : v) {
			System.out.println(Arrays.toString(row));
		}
		System.out.println("--------------------------");
		for(int[] row : target) {
			System.out.println(Arrays.toString(row));
		}
		int i=v.length-1;
		int j=v[0].length-1;
		while(j>0 && i>0) {
			if(target[i][j]==1) {
				System.out.println("第"+i+"件商品");
				j-=w[i-1];
			}
			i--;
		}
	}
}
